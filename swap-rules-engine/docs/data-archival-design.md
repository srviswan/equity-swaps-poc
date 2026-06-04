# Data Archival Framework — Architecture & Design

A reliable, restartable, self-healing archival engine for a high-volume SQL Server 2018
data warehouse (~9.8 TB, ~8–9 billion rows, top table ~1 TB). It archives terminated
baskets out of the live DW into a compressed archive store and removes them from source —
moving ~3–5 billion rows across ~20 tables in small, BAU-safe iterations.

---

## 1. Decisions locked (from planning)

| Topic | Decision |
|---|---|
| Source recovery model | **FULL** (log clears only on log backup) |
| HA | **AG with 4 replicas**: 1 sync-commit primary (R/W), 1 **synchronous** read-only secondary, 2 **async** read-only secondaries |
| Source partitioning | **Not partitioned** → batched `DELETE` path |
| FK enforcement | **None at DB level** — enforced in the application. `dependency_level` is configured manually, not derived from `sys.foreign_keys` |
| Topology rollout | **A) same DB (archive table in the AG-replicated DW DB) → B) same server, other DB → C) different server** |
| Initial schedule | **Weekend-only** to start (window data), moving to continuous later |
| Target volume | ~3–5B rows over **~5–6 weeks**, mostly weekends |
| Parallelism | **Single-stream by default** (`max_parallel_workers=1`). Optional **basket-sharded** workers later if measurement proves headroom — never table-parallel across dependency levels |
| Primary auth | **Kerberos**, consuming an existing ticket/keytab (infra-provisioned) |
| Secrets | **CyberArk** (pluggable: CCP REST default, AIM agent swap) — used only for SQL auth |
| Eligibility driver | Explicit **termination event** in `DimBasket` + **13-month** dormancy (configurable) |
| `businessDateKey` | Arbitrary **surrogate** (key order ≠ date order); fact rows carry a real date |
| Reactivation | Upstream reactivation mints a **new surrogate** → archived baskets are **immutable** |
| Missing termination date | **Quarantine** for manual review — never auto-archive |
| Removal unit | **All** rows for an eligible basket leave source |
| Selection keys | **Per-table configurable join** (`join_columns`): DIRECT basket key, or BRIDGE via a mapping table (e.g. `swap_key`). A supporting index on `join_columns` is required (pre-flight enforced) |
| Schema evolution (target) | **Mixed**: auto-additive by default, **strict** per-table flag for sensitive tables |
| Archive storage | Per-table choice (rowstore+PAGE vs clustered columnstore) — recommended later |
| Archive partitioning | By **`archived_period_key`** (`YYYYMM` of archived date) |
| Archive retention | **N years from archived date** (configurable / regulatory) → purge by partition switch |
| Archive access | **Restore** supported — into a **separate investigation DB**, not live source |

---

## 2. Technology choice

**A single config-driven Java CLI (fat jar); heavy DML done set-based in SQL, orchestrated by Java.**

- **Auth**: Microsoft JDBC driver natively supports SQL auth, `integratedSecurity`, and
  `authenticationScheme=JavaKerberos` (pure-Java, keytab/ambient ticket, runs on Linux).
- **Cross-server throughput**: `com.microsoft.sqlserver.jdbc.SQLServerBulkCopy` streams a
  source `ResultSet` directly into a target table (needs only `INSERT`, no `bulkadmin`,
  no MSDTC, no Kerberos delegation since we use two direct connections).
- **Minimal CI/CD overhead**: one Maven module → one fat jar. *Archive criteria and table
  lists live in DB control tables (data, not code)*, so changing what gets archived needs
  **zero redeploy**.
- **Fits the team**: existing Java 21 / Spring Boot 3.3.5 / Maven / Flyway / Micrometer stack.

**Hybrid split**: Java owns control flow (batching, windows, log/AG throttling, verification,
restart, auth, pre-flight). Data DML is set-based SQL (optionally stored procedures deployed
via Flyway so DBAs can tune execution plans without an app release).

---

## 3. High-level architecture

```text
                       ┌──────────────────────────────────────────────┐
                       │            swap-archiver (fat jar)             │
  archiver.yml ──────► │  Preflight ─► Orchestrator ─► ChunkProcessor   │
  (runtime knobs)      │     │              │               │           │
                       │     │         WindowScheduler  CopyStrategy    │
  Control tables ────► │     │         AdaptiveController  ├ SameDb     │
  (config, state,      │     │         LogAndAgMonitor     ├ CrossDb    │
   checkpoints)        │     │         IndexManager        └ CrossSrv   │
  CyberArk (SQL auth)► │     └── CredentialProvider ── CheckpointStore  │
  Kerberos ticket ───► │                                                │
                       └───────────────┬────────────────┬──────────────┘
                                       │                │
                                ┌──────▼─────┐   ┌──────▼───────┐   ┌──────────────┐
                                │  SOURCE DW  │   │  ARCHIVE DB   │   │ RESTORE DB    │
                                │ (FULL, AG)  │   │ (SIMPLE, CCI) │   │ (investigate) │
                                └─────────────┘   └──────────────┘   └──────────────┘
```

**Unit of work = a chunk**: a slice of eligible baskets sized to a manageable row count,
processed across all in-scope tables in FK dependency order, fully checkpointed.

---

## 4. Eligibility & basket lifecycle

Purge eligibility lives at the **basket grain**, not the row grain. We never write a
per-row `archiveFlag` (a mass `UPDATE` on billions of rows would be fully logged and
shipped across the AG — self-defeating). Instead we maintain a small state table.

```text
BasketArchiveState (one row per basket)
  basket_key        PK
  termination_date  -- explicit lifecycle event from DimBasket
  status            ACTIVE | TERMINATED | NEEDS_REVIEW | ELIGIBLE | ARCHIVED
  archived          bit
  archive_batch_id
  archived_at_utc
  last_refreshed_at
```

- **Refresh** (light upsert from `DimBasket`): set `termination_date`/`status`.
- **Eligibility** (policy in config, not data):

```sql
SELECT basket_key
FROM   archive.basket_archive_state
WHERE  status = 'TERMINATED'
  AND  termination_date < DATEADD(MONTH, -:retention_months, :as_of_date)
  AND  archived = 0;
```

- **Missing termination date** → `status = NEEDS_REVIEW` (quarantine). Reported, never
  auto-archived. Profile this subset before the backfill.
- **Immutability**: a terminated surrogate never reactivates (reactivation mints a new
  surrogate upstream), so deleting its source rows is safe and needs no cooling-off.
- After all rows for a basket are copied + verified + deleted across all tables, set
  `archived = 1`, `archive_batch_id`, `archived_at_utc` (cheap, basket-grain). This is the
  real, auditable "flag," in the right place.

---

## 5. Control / metadata model

A small `archive` schema keeps the jar stateless and configuration as data:

- **`archive_job`** — named job: topology, default/min/max batch size, retention months,
  archive retention years, recovery-model awareness, enabled flag.
- **`archive_table`** — the ~20 tables: source + target names, FK `dependency_level`
  (delete order), key columns, copy strategy, `disable_target_indexes`, `checksum_verify`,
  `schema_mode` (AUTO|STRICT), `storage_format`, restorable flag, column map.
- **`archive_window`** — per `day_of_week`: `start_time`, `end_time`, `max_duration`,
  `batch_size_cap` (bigger on weekends).
- **`basket_archive_state`** — basket lifecycle (section 4).
- **`archive_worklist`** — materialized eligible baskets per run + per-chunk `status`
  (`PENDING → IN_PROGRESS → COPIED → VERIFIED → DELETED → DONE | FAILED`).
- **`archive_run`** / **`archive_chunk_log`** — run header + per-chunk audit: rows
  copied/deleted, checksums, durations, log-space + AG-queue readings, error text, retries.
- **`archive_schema_audit`** — every auto-ALTER applied to a target table.
- **`archive_restore_log`** — every restore operation, for audit.

**Restart** = "find worklist/chunks not `DONE`, resume." **Criteria change** = new
`archive_job` / config row. No code change, no deploy.

---

## 6. Core engine behaviors

### 6.1 Chunking
The eligible basket worklist is grouped into chunks until the **estimated row count** (from
`sys.dm_db_partition_stats` / statistics) for the largest table reaches the target batch
size. Every in-scope table archives the **same basket set** per chunk, joining on
`basket_key`, so all 20 tables stay consistent.

### 6.2 Adaptive batch sizing + transaction-log breathing room (FULL recovery)
AIMD-style controller adjusts batch size within `[min, max]` based on:
- measured **chunk duration** vs target,
- **log used %** (`sys.dm_db_log_space_usage`) and **`log_reuse_wait_desc`**.

In FULL recovery the log only truncates on **log backup**. When
`log_reuse_wait_desc = LOG_BACKUP` or log pressure is high, the engine **pauses and waits**
for the log-backup job (or issues `BACKUP LOG` if granted `db_backupoperator`). This is the
"wait for the right time to clear the log" requirement.

> No minimal logging is available in FULL recovery — even `SQLServerBulkCopy`/`INSERT…SELECT`
> with `TABLOCK` is fully logged. Pace accordingly.

### 6.3 Availability Group throttling
Every insert/delete is fully logged and **must ship to and redo on AG secondaries**. The
monitor also reads `sys.dm_hadr_database_replica_states` (`log_send_queue_size`,
`redo_queue_size`) and **pauses when a secondary falls behind** a configurable threshold —
protecting RPO and any readable-secondary BAU reporting. Note: archiving into the **same**
AG-replicated DB (phase A) logs+ships *both* the copy and the delete (~2× volume); moving to
a **non-AG archive DB** (phase B/C) removes the copy side from AG shipping.

### 6.4 Scheduling windows
Before each chunk: check `day_of_week`/time against `archive_window`. If the **estimated**
chunk time would exceed the remaining window (or duration budget), **stop cleanly at the
last committed chunk boundary**. Weekend rows allow larger windows and bigger batch caps.

### 6.5 Index management
Optional per-table flag to **disable non-clustered indexes on the archive *target*** before
bulk load and **rebuild after** (faster load). Enable/rebuild runs in **both success and
failure paths**; the disabled/enabled state is checkpointed so a **restart re-enables** them.

> Default is **target tables only**. Disabling source (live DW) indexes breaks BAU and you
> cannot disable a clustered index without making the table unreadable. Source index changes
> are gated behind an explicit, separate flag.

### 6.6 Restartability + transactional safety (topology-dependent)
A single transaction cannot span two instances, so the safety model differs:

- **Same server (same or different DB)** — `INSERT…SELECT` then `DELETE` for the chunk run
  in **one explicit transaction**. Crash → automatic rollback → chunk re-runs. Atomic, no
  orphans.
- **Cross-server** — no cheap distributed transaction. Use a **state machine + idempotency**:
  `COPY → VERIFY (count + optional checksum) → DELETE`, each step checkpointed.
  - `COPIED` not `VERIFIED` → re-verify; mismatch → delete target rows for that chunk key set
    and re-copy (idempotent on key).
  - `VERIFIED` not `DELETED` → delete source (target already proven).

Uncommitted work always rolls back to the last `DONE` chunk; restart resumes exactly there.

### 6.7 Verification
Per chunk: `rows_selected == rows_inserted`, and optionally a column-aware
`CHECKSUM_AGG` / `HASHBYTES` aggregate match between source slice and target slice **before**
the delete is allowed. "Copy is successful before delete" is guaranteed.

### 6.8 FK ordering (app-enforced, not DB-enforced)
There are **no database-level FK constraints** (referential integrity is enforced in the
application), so order cannot be derived from `sys.foreign_keys`. `archive_table.dependency_level`
is **configured manually** from application knowledge and drives **delete order
(children → parents)** and **restore order (parents → children)**.

- Upside: deletes incur **no constraint-check or cascade overhead** and never fail on FK.
- Still required: ordering preserves **logical consistency** on partial failure and on restore
  into the investigation DB (where we may add FKs). Basket-key-driven selection moves all of a
  basket's rows together regardless of grain, so ordering is a consistency concern, not a hard
  constraint.

### 6.9 Parallelism (default off)
In FULL recovery + a **synchronous-commit AG**, the binding resource is the **shared
log-harden/redo pipeline**, not CPU/IO. So parallelism only helps when measurement proves that
pipeline has headroom — usually it does not in this topology.

- **Do NOT parallelize by table** for the same basket set: it breaks the children→parents delete
  ordering, and all tables share the same log/sync ceiling anyway.
- **The only safe parallel axis is by basket** (disjoint shards): baskets are independent (no
  shared rows, no cross-basket relationship). Each worker runs the full table sequence in
  dependency order for its own baskets.
- Controlled by `archive_job.max_parallel_workers` (default **1**) + a `worker_id` shard column on
  `archive_worklist`. A **shared global throttle** (log/AG monitor) governs all workers.
- **Bigger weekend win**: moving the archive to a **non-AG DB (phase B)** removes the copy from the
  sync pipeline — more throughput than parallelism inside the AG.

**Rule:** start single-stream, push `AdaptiveController` to the safe log/AG ceiling, measure on the
1 TB table; only then consider 2–4 basket-sharded workers.

### 6.10 Generic per-table selection (configurable join keys)
Eligibility is always basket-based (the worklist is a set of eligible basket keys), but **how each
table finds its rows is configurable per table** (`archive_table.join_columns` + `key_resolution`):

- **DIRECT** — the table carries the basket key (any column name). Join straight to the worklist.
  `join_columns` may be a single column (`basket_key`) or composite (`basket_key,business_date_key`).
- **BRIDGE** — the table is keyed by something else (e.g. `swap_key`) with no basket key. Resolve
  eligible baskets → this table's keys through a mapping (`bridge_table`,`bridge_basket_column`,
  `bridge_join_columns`, e.g. `DimSwap(basket_key, swap_key)`), then join the big table on its own
  key. Resolution uses `DISTINCT`; the bridge must be indexed on its basket column.

### 6.11 Break-glass / emergency stop
Because every chunk is transactional, halting is always safe and restartable. Three layers
(fastest → safest), surfaced via `StopController`:

1. **DB flag (primary break-glass)** — flip `archive_job.run_signal` from any SQL client; the engine
   checks it at every committed boundary and halts cleanly:

```sql
UPDATE archive.archive_job
SET run_signal = 'STOP', signal_reason = '<why>', signal_by = SUSER_SNAME(), signal_at = SYSUTCDATETIME()
WHERE job_name = 'basket-archive';
```

   - `STOP` halts and **stays down** (engine refuses to start until reset to `RUN`). `PAUSE` halts now
     and resumes next window. Reset with `run_signal='RUN'`.
   - Also available as `ARCHIVER_MODE=STOP` (runs the jar to flip the flag) for ops without SQL access.
2. **In-process cancel** — the active `Statement` is registered; a stop cancels in-flight SQL, rolling
   back the current chunk (re-run on restart).
3. **OS signal / KILL** — SIGTERM/Ctrl-C trigger a graceful stop via a JVM shutdown hook; a hard
   `kill -9` or SQL Server `KILL <spid>` is still safe — the in-flight transaction rolls back and
   restart resumes from the last committed chunk.

The flag **fails open** (unreadable control DB ⇒ RUN), so a control-DB blip never silently stalls a
run; the in-process and OS layers remain available regardless.

**Efficiency safeguards (so a 1 TB join never scans):**
1. **Stage keys per chunk** into an indexed temp table (`#keys`, clustered on `join_columns`), then
   `INSERT…SELECT` / `DELETE` **join the source to `#keys`** — accurate cardinality, index seek, no
   giant `IN (...)` lists.
2. **Pre-flight `source.index(...)` check**: every configured table must have an index whose
   **leading key columns are exactly its `join_columns`**. If the table exists but lacks one, this is
   a **FAIL** (a scan on a billion-row table is fatal), not a warning.
3. Composite join keys are seekable only if an index leads with that exact column set.

---

## 7. Copy topologies

| Mode | Mechanism | Transaction model |
|---|---|---|
| Same server, same DB | `INSERT…SELECT` + `DELETE` | single local transaction |
| Same server, different DB | 3-part name `db.schema.table` | single local transaction (same instance) |
| Different server/DB | `SQLServerBulkCopy` streaming source→target | copy→verify→delete state machine |

Pluggable `CopyStrategy`, selected per table in `archive_table`.

---

## 8. Authentication & secrets

### Kerberos (primary) — consume existing ticket/keytab
- `authenticationScheme=JavaKerberos`; ambient ticket cache (`KRB5CCNAME`) or
  infra-provisioned keytab via JAAS. Infra owns renewal. No `kinit`, no delegation.
- Pre-flight validates a usable, unexpired ticket and SPN resolution.
- Self-healing: on Kerberos auth failure, if a keytab is configured, re-init the JAAS login
  context and retry; else surface an actionable "ticket expired" error.

### CyberArk (SQL auth only — phases B/C targets)
- Default **CCP (REST + mTLS + AppID)**; **AIM/local agent** (`javapasswordsdk.jar`) is a
  drop-in swap. Returns `username` + `password`.
- Secret held in a zeroed `char[]`, **short-TTL in-memory cache**, never logged (masked).
- **Rotation self-healing**: on `18456` login failure, evict cache, re-fetch, retry.
- Pre-flight verifies safe reachability and that the `credentialId` resolves before any data op.

| Phase | Source auth | Target auth | Secret source |
|---|---|---|---|
| A — same DB | Kerberos (ambient) | same connection | none |
| B — same server, other DB | Kerberos | Kerberos *(or SQL via CyberArk)* | CyberArk if SQL |
| C — different server | Kerberos (ticket) | SQL via **CyberArk** | CyberArk |

---

## 9. Pre-flight checks (fail fast, before touching data)

1. **Connectivity** to source + target with chosen auth (+ usable Kerberos ticket).
2. **Schema consistency** — source vs target column name/type/nullability/collation/ordinal
   (`sys.columns`). Apply **auto-additive** evolution or **strict** stop (section 11).
3. **Permissions** — `SELECT`/`DELETE` on source, `INSERT`/`ALTER` on target,
   `VIEW SERVER STATE` for DMVs (`HAS_PERMS_BY_NAME` / `fn_my_permissions`).
4. **Capacity** — data/log free space, target filegroup space, recovery model, log-backup job.
5. **Topology reachability** — cross-server connectivity; CyberArk safe reachability.
6. **Dry-run mode** — report worklist size, estimated rows/chunks/time per table, no writes.

---

## 10. Permissions (least privilege — `archive_engine_role`)

**Server-level (login)**

| Capability | Permission |
|---|---|
| Connect | `CONNECT SQL` + login |
| Log space DMV | `VIEW SERVER STATE` |
| AG queues DMV | `VIEW SERVER STATE` |
| `BACKUP LOG` *(only if engine owns it)* | `db_backupoperator` |

**Source DB**: `CONNECT`; `SELECT` + `DELETE` on the 20 tables; `ALTER` on those tables
(index disable, `SET LOCK_ESCALATION`, `UPDATE STATISTICS`); `VIEW DATABASE STATE`.

**Target / archive DB**: `CONNECT`; `INSERT` + `SELECT` on target tables; `ALTER`
(index, `IDENTITY_INSERT`); optional `CREATE TABLE` + schema `ALTER` (auto-create) or
`db_ddladmin`; full DML on the `archive` schema control tables.

Notes: `SQLServerBulkCopy` over JDBC needs only `INSERT` (no `bulkadmin`).
`UPDATE STATISTICS` is covered by `ALTER`. Avoid `sysadmin`/`db_owner`.

---

## 11. Target table schema strategy

**One stable archive table per source table, created once, evolved additively** — not
timestamped-per-run copies (which cause object sprawl, fragmented history, multiplied
index/permission/stats management, and painful retention).

- **Auto-additive evolution** (default `schema_mode = AUTO`):
  - New source column → auto-add to target as **NULLable**; log to `archive_schema_audit`.
    Zero manual DDL, zero redeploy.
  - Dropped source column → **keep** in target (historical rows used it); stop populating.
  - Widened type (loss-free) → auto-widen target.
  - Incompatible change (narrowing/type swap/collation conflict) → **stop and alert**.
- **`schema_mode = STRICT`** per sensitive table → any drift requires human approval.
- **Engine lineage columns** on every target (namespaced): `archive_batch_id`,
  `archived_at_utc`, `archived_period_key`, `source_row_hash`, `basket_key`.
- **Restorable tables** must avoid lossy column drops in the column map (you can't restore
  what you didn't keep). Mask/encrypt at rest instead if needed.
- **True breaking change** (rare) → engine spins a `_v2` table + a `UNION ALL` view over
  v1/v2. Versioning only on breaking change, not every run.

### Partitioning & storage
- Partition archive tables on **`archived_period_key` (`YYYYMM` of archived date)** because
  retention is **N years from archived date**. Each monthly run targets one partition.
- **Property**: since all of a basket's rows are archived together, a basket lands in a single
  archived-period partition → purge a partition = remove whole baskets cleanly.
- **Purge** = `SWITCH` partitions older than N years → drop. Metadata-only, seconds.
- **Storage format** per table: clustered columnstore (max compression, ~5–10× on cold data;
  load batches ≥ 102,400 rows for compressed rowgroups) vs rowstore + PAGE compression.
- **Restore-locating index**: nonclustered on `basket_key` (and/or `archive_batch_id`) so
  investigative restore finds a basket's rows without scanning billions.

### Partitioning rule: the archive table design differs from source
SQL Server partitions on **exactly one column**, and **a unique index must contain the
partitioning column** to be aligned. So when a source table has a unique clustered index on
`(basket_key, business_date_key)` (where `business_date_key` is a non-date-ordered surrogate), the
archive table changes as follows:

1. Add a **persisted partition column** (a single column), since the surrogate isn't date-ordered:
   - `ARCHIVED_PERIOD` (recommended, matches "purge N years from archived date"):
     `archived_period_key AS (YEAR(archived_at_utc)*100+MONTH(archived_at_utc)) PERSISTED`.
   - `BUSINESS_DATE` (only if data-age queries/legal hold need it): derive from the real date
     column on the fact row — but then retention purge no longer maps 1:1 to a partition `SWITCH`.
2. The **unique clustered index must include** that partition column, e.g.
   `UNIQUE CLUSTERED (archived_period_key, basket_key, business_date_key)`. The partition column
   must be *in* the key but need not be leading (leading → groups by period for load/purge
   locality; trailing → groups by basket for restore locality).
3. **Uniqueness is not weakened**: the period/date is functionally dependent on the row (date is
   determined by `business_date_key`; archived period by the run), so adding it to the key keeps
   `(basket_key, business_date_key)` effectively unique.
4. **CCI caveat**: a clustered columnstore cannot be unique — if `storage_format=CCI`, partition the
   CCI on the single column, drop the unique constraint, add an aligned nonclustered btree on
   `basket_key` for restore, and rely on the engine's idempotent copy for dedup.

So the "partition key" is **one column**; the 3-column list is the **clustered index key** that
*contains* it. `archive_table.partition_strategy` / `partition_granularity` drive this per table.

---

## 12. Restore (investigations)

A first-class **reverse mode** of the same jar (same `CopyStrategy`, auth, control tables —
no new deployable):

- **Default target = a separate restore/investigation DB**, not live source (restoring a
  dead surrogate into source would confuse BAU). Restoring into source is a gated option.
- **Reverse FK order** (parents → children), `IDENTITY_INSERT` / column mapping as needed.
- **Lineage-driven**: locate by `basket_key` / `archive_batch_id`; every restore audited in
  `archive_restore_log`.

---

## 13. End-to-end run flow

1. **Refresh** `basket_archive_state` from `DimBasket` (light upsert).
2. **Select** eligible baskets (termination + 13-mo rule, config-driven) → worklist;
   missing-termination → `NEEDS_REVIEW`.
3. **Chunk** baskets to target row count.
4. Per chunk, per table (FK child→parent): **copy → verify → delete**, restartable,
   AG/log-throttled, inside the scheduling window.
5. Mark baskets `archived = 1`.
6. Rows land in current **archived-period** partition (columnstore/compressed).
7. **Post-run**: `UPDATE STATISTICS` on affected source tables; observability/alerts.
8. **Separate cadence**: purge archive partitions older than N years (`SWITCH` + drop).

---

## 14. Risks & mitigations

| Risk | Impact | Mitigation |
|---|---|---|
| **Stale statistics** after huge deletes | BAU plans regress; billion-row auto-stats threshold trips late | Scheduled `UPDATE STATISTICS` (key cols, possibly `FULLSCAN`) post-run; consider `AUTO_UPDATE_STATISTICS_ASYNC` |
| **Plan cache invalidation / param sniffing** | Recompiles, latency shifts | Deliberate stats update; validate key BAU plans post-run |
| **Space not reclaimed / fragmentation** | Empty pages; heaps don't deallocate without `TABLOCK` | Off-hours `REBUILD`/`REORG`; `DBCC CLEANTABLE`; ghost-cleanup awareness |
| **Lock escalation → table lock** | Blocks BAU | Keep statement row touches under ~5,000; partition-level / disabled escalation during run; `DEADLOCK_PRIORITY LOW`; archive cold baskets only |
| **Transaction log growth / backup chain** | Disk full | Adaptive batch + log monitor; pace to log-backup cadence |
| **AG redo/send lag** | RPO breach; secondary BAU lag | Throttle on `log_send_queue_size`/`redo_queue_size`; bigger weekend windows |
| **Synchronous-commit secondary latency** | Every commit waits for the sync replica to harden log (`HADR_SYNC_COMMIT`) → it is the throughput bottleneck | Provision sync-replica I/O + network; monitor `HADR_SYNC_COMMIT`; consider sync→async during the bulk window (RPO trade-off, deliberate ops decision) |
| **Same-DB archive doubles footprint** | Copy + delete both logged/shipped (~2×) and archived copy grows the DW DB itself | Treat phase A as short proving ground; move to a **non-AG archive DB (phase B)** ASAP; capacity-plan data/log file growth |
| **FULL recovery = no minimal logging** | Everything fully logged + shipped | Smaller batches; prefer non-AG archive DB (phase B/C) |
| **FK violations** | Failed deletes/restores | `dependency_level` ordering |
| **DELETE triggers on source** | Audit triggers fire per row | Detect; disable/coordinate explicitly |
| **Missing termination dates** | Wrong baskets archived | Quarantine (`NEEDS_REVIEW`), never auto-archive |
| **Lossy column map vs restore** | Can't restore dropped columns | Keep all columns on restorable tables; mask at rest |
| **tempdb / version store (RCSI)** | Pressure under long txns | Short per-chunk transactions; monitor version store |

> **Worth evaluating later**: if the largest tables could be partitioned on a date-derived
> key, `ALTER TABLE … SWITCH` would make source removal a metadata op. Out of scope now
> (source is not partitioned), but the highest-leverage future optimization.

---

## 14a. Operational responsibilities — engine (automatic) vs operator (explicit)

`BasketArchiveState` is **maintained automatically** by the engine (upsert from `DimBasket` +
eligibility computation each run); the only manual touch-point is reviewing the `NEEDS_REVIEW`
quarantine. The split of everything else:

| Concern | Engine (automatic) | Operator / DBA (explicit) |
|---|---|---|
| Eligibility + `BasketArchiveState` | refresh from `DimBasket`, compute eligibility | review `NEEDS_REVIEW` quarantine |
| Worklist, chunking, restart/resume | yes | — |
| Adaptive batch sizing | yes | set min/max/target in `archive_job` |
| Log-pressure pause | pauses on `log_reuse_wait=LOG_BACKUP` | **ensure frequent log backups in the window** (or grant `BACKUP LOG`) |
| AG lag pause | pauses on redo/send queue | **sync-replica I/O + network; monitor `HADR_SYNC_COMMIT`; sync→async decision** |
| Scheduling windows | weekend-only via config | seed `archive_window` |
| Copy→verify→delete + checkpoint | yes | — |
| Target index disable/rebuild | yes (if flagged) | — |
| FK ordering | uses `dependency_level` | **populate `dependency_level`** (no DB FKs to derive from) |
| Stale stats | optional post-run `UPDATE STATISTICS` | **validate key BAU plans; schedule stats scope/timing** |
| Source index fragmentation / space reclaim | never touches source indexes | **`REBUILD/REORG`, `DBCC CLEANTABLE` off-hours** |
| DB space growth (same-DB copy) | — | **capacity-plan data + log file growth; backup-chain storage** |
| Triggers / CDC / replication on source | — | **confirm none / coordinate** |
| Lock escalation vs BAU | batch sizing + `DEADLOCK_PRIORITY LOW` | decide `SET LOCK_ESCALATION` policy per table |
| Full/diff backup & `CHECKDB` windows | — | **avoid overlap with the run** |

**Feasibility note** (~4B rows / ~6 weekends ≈ ~670M rows/weekend ≈ ~3,700 rows/sec over a
~50h window): achievable, but the **synchronous-commit secondary** and **FULL-recovery logging**
are the limiters, not the engine. **Measure on the 1 TB table first** before committing to the
6-weekend plan.

---

## 15. File layout (minimal, one deployable)

```text
swap-archiver/
├── pom.xml
├── src/main/resources/
│   ├── application.yml                    # runtime knobs only
│   └── db/archive/V001__archive_control.sql
└── src/main/java/com/pb/swap/archiver/
    ├── ArchiverApplication.java          # CLI entrypoint
    ├── config/ArchiverProperties.java
    ├── auth/{AuthMode,ConnectionFactory,CredentialProvider,
    │         CyberArkCcpCredentialProvider,KerberosTicketProvider}.java
    ├── engine/{Orchestrator,WorklistProvider,ChunkProcessor,
    │           AdaptiveController,LogAndAgMonitor,WindowScheduler,
    │           IndexManager,PreflightValidator}.java
    ├── copy/{CopyStrategy,SameDbCopyStrategy,CrossDbCopyStrategy,
    │         CrossServerBulkCopyStrategy}.java
    └── restore/RestoreService.java
```

One fat jar. Criteria/table changes are data, not deploys.

---

## 16. Implementation phases

0. **Sign-off + control schema** (this doc + the migration). ✅
1. **Connectivity, 3 auth modes, pre-flight** (read-only, safe). ✅
2. **Single table, same-DB copy→delete with checkpoint + restart**. ✅ — run/worklist build+resume,
   eligibility from `basket_archive_state`, per-chunk staged-key `INSERT…SELECT`+`DELETE` in one
   transaction with lineage columns, `archive_chunk_log` checkpointing (idempotent restart), basket
   archived-marking, and break-glass halt at chunk boundaries.
3. **Adaptive batch sizing + log/AG monitor + scheduling windows**. ✅ — chunks are formed at
   runtime (lazy `nextChunk`) so the AIMD `AdaptiveController` resizes the row target each chunk
   (converted to a basket count via an EMA of observed rows/basket); `LogAndAgMonitor` samples
   `sys.dm_db_log_space_usage` + `log_reuse_wait_desc` + AG redo/send queues (fails soft when a DMV
   is unreadable / not an AG) and pauses on pressure; `WindowScheduler` gates each chunk on the
   per-day `archive_window` and stops cleanly when the window closes. Crash-reclaim of `IN_PROGRESS`
   chunks on restart.
4. **Index management + verification/checksums**. ✅ — optional per-table `disable_target_indexes`
   disables the *target's* plain non-clustered indexes before the load and rebuilds them after, on
   every exit path (success, halt, failure) and on restart, via the checkpointed
   `archive_index_state` table (leftover rows = indexes still to rebuild; PK/unique-constraint and
   clustered indexes are never touched). When `checksum_verify` is on, each chunk computes an
   order-independent `CHECKSUM_AGG(CHECKSUM(<data cols>))` over the source slice and the
   just-inserted target slice and requires them to match **before** the delete is allowed (skipped
   when a restart re-runs an already-moved chunk, i.e. `rowsCopied = 0`); both checksums are
   persisted to `archive_chunk_log` for audit. Index disable/rebuild runs only when there is work.
5. **Cross-DB + cross-server (`SQLServerBulkCopy`)**. ✅ — `CROSS_DB` reuses the single-transaction
   `INSERT…SELECT`+`DELETE` path but qualifies the target with a 3-part `[db].[schema].[table]`
   name (target DB parsed from the endpoint URL), so an archive DB in SIMPLE recovery outside the AG
   gets the copy off AG shipping while staying atomic. `CROSS_SERVER` streams the source slice into
   the target via `SQLServerBulkCopy` (two direct connections, batch sized for columnstore
   rowgroups) and — since no transaction spans instances — runs a checkpointed **copy → verify →
   delete** state machine: copy first cleans any partial target rows for the batch (idempotent),
   verifies target row-count (+ optional `CHECKSUM_AGG`) against the source slice, persists the
   `COPIED` checkpoint, then deletes the source. A crash after `COPIED` resumes via a delete-only
   branch so the verified archive is never re-cleaned or re-copied (no data loss, no duplicates).
6. **Multi-table orchestration + FK ordering (all 20) + `BasketArchiveState` build**. ✅ — each chunk
   moves the same eligible-basket set across every in-scope table in `dependency_level` order
   (children → parents). A shared `ChunkKeys` helper stages the per-chunk key set into an indexed
   `#archive_keys` temp table and builds the seekable join for both resolutions: **DIRECT** (the fact
   carries the basket key) and **BRIDGE** (a fact keyed by e.g. `swap_key` resolves eligible baskets
   to its own keys through a mapping table with `DISTINCT`, then joins on its own `join_columns`).
   Pre-flight now also fails a BRIDGE table whose bridge mapping isn't indexed on its basket column.
   `BasketStateRefresher` builds `basket_archive_state` from a configured source dimension
   (e.g. `DimBasket`), classifying TERMINATED / NEEDS_REVIEW (terminated but undated) / ACTIVE and
   never overwriting already-archived baskets; the Orchestrator refreshes it before selecting each
   run's worklist.
7. **Stats/plan post-steps + observability + alerting + restore**. ✅ — after a successful run
   `StatsMaintainer` runs `UPDATE STATISTICS` on every in-scope source table (gated by
   `archive_job.update_stats_after`, V003) so the now-smaller tables don't carry stale stats into
   BAU plans; failures are logged, never fail the committed archive. The Orchestrator emits a single
   structured `ARCHIVE_SUMMARY run=… status=… chunks=… copied=… deleted=… duration_ms=… halt=…`
   line per run (scrape-friendly for a log exporter / Prometheus textfile collector — no in-process
   HTTP server in a batch job), and prefixes PAUSED/FAILED/restore-failure lines with `ALERT` for
   log-based alerting. `RestoreService` is the reverse pipeline: located by lineage
   (`archive_batch_id` = the archive `run_id`, optionally resolved from a basket key), it restores in
   **parent → child** order into a **separate investigation DB** (guarded against the live source
   unless `restore.allow-restore-to-source`), auto-creating the investigation table from the archive
   shape, idempotent per batch, every restore audited in `archive_restore_log`.
8. **Perf test on the 1 TB table, dry-run, staged prod rollout**.

---

## 17. Open items to confirm before/while building

- Where exactly `DimBasket` exposes status + termination date (column names).
- Size/age profile of the missing-termination (`NEEDS_REVIEW`) subset.
- Log-backup cadence and whether the engine may issue `BACKUP LOG`.
- AG lag tolerance (RPO) and whether a readable secondary serves BAU.
- Clustered-key layout and existing indexes per table (drives delete efficiency).
- FK graph among the 20 tables (dependency levels).
- Per-table storage-format recommendation (columnstore vs rowstore+PAGE).
- CyberArk style (CCP vs AIM) — kept pluggable for now.
