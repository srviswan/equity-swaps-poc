# swap-archiver

Restartable, self-healing data-archival engine for SQL Server. See the full design in
[`../docs/data-archival-design.md`](../docs/data-archival-design.md).

A single config-driven fat jar. *What* is archived lives in the `archive.*` control tables (data,
not code), so criteria/table changes need no redeploy.

## Phase status

- **Phase 1 (done):** connectivity, three auth modes (Kerberos / Integrated / SQL via CyberArk or
  env), and pre-flight checks (connectivity, identity, recovery model, log-space visibility, key
  permissions, source↔target schema consistency). `DRY_RUN` runs pre-flight only.
- **Phase 2 (done):** single-table SAME_DB archive. `ARCHIVE` opens (or resumes) a run, selects
  eligible baskets into a chunked worklist, and per chunk moves the table's rows
  (`INSERT…SELECT` + `DELETE` in one transaction, keys staged in an indexed temp table, lineage
  columns populated), checkpointing each table to `archive_chunk_log`. Restart skips `DONE` work;
  break-glass halts cleanly at the next chunk boundary. See the demo below.
- **Phase 3 (done):** runtime adaptive chunking. Chunks are formed lazily (`nextChunk`), so the
  AIMD controller resizes the row target each chunk (converted to baskets via an EMA of observed
  rows/basket). `LogAndAgMonitor` samples log-space + `log_reuse_wait` + AG redo/send queues and
  pauses on pressure (fails soft when a DMV is unreadable / not an AG); `WindowScheduler` gates each
  chunk on the per-day `archive_window` and stops cleanly when the window closes. `IN_PROGRESS`
  chunks are reclaimed on restart.
- **Phase 4 (done):** index management + verification. Per-table `disable_target_indexes` disables
  the target's plain non-clustered indexes before the load and rebuilds them on every exit path
  (success, halt, failure) and on restart, tracked in the checkpointed `archive_index_state` table
  (PK/unique-constraint and clustered indexes are never touched). With `checksum_verify` on, each
  chunk requires an order-independent `CHECKSUM_AGG` over the source slice to equal the
  just-inserted target slice **before** the delete is allowed; both checksums are recorded in
  `archive_chunk_log`.
- **Phase 5 (done):** cross-DB and cross-server topologies. `CROSS_DB` keeps the single local
  transaction but writes the target via a 3-part `[db].[schema].[table]` name (target DB taken from
  the endpoint URL). `CROSS_SERVER` streams source→target with `SQLServerBulkCopy` over two
  connections and drives a checkpointed **copy → verify → delete** state machine: it cleans any
  partial target rows for the batch, bulk-copies, verifies row-count (+ optional checksum), records
  `COPIED`, then deletes the source — and a crash after `COPIED` resumes delete-only, so the
  verified copy is never duplicated or lost.
- **Phase 6 (done):** multi-table orchestration + generic key resolution + basket-state build. Each
  chunk moves the same basket set across all in-scope tables in `dependency_level` order. A shared
  `ChunkKeys` helper stages the per-chunk key set and builds seekable joins for **DIRECT** (fact
  carries the basket key) and **BRIDGE** (fact keyed by e.g. `swap_key`, resolved to its keys via a
  mapping table). Pre-flight fails a BRIDGE whose mapping table isn't indexed on its basket column.
  `BasketStateRefresher` builds `basket_archive_state` from a configured source dimension
  (TERMINATED / NEEDS_REVIEW / ACTIVE), run before each archive selects its worklist.
- **Phase 7 (done):** stats post-steps + observability + alerting + restore. After a successful run
  `StatsMaintainer` runs `UPDATE STATISTICS` on every in-scope source table (gated by
  `archive_job.update_stats_after`) so the now-smaller tables don't push stale stats into BAU plans.
  Each run emits one structured `ARCHIVE_SUMMARY run=… status=… chunks=… copied=… deleted=…
  duration_ms=… halt=…` line (scrape-friendly for a log exporter / Prometheus textfile collector),
  and PAUSED/FAILED lines are prefixed `ALERT`. `mode=RESTORE` runs the reverse pipeline:
  `RestoreService` locates archived rows by lineage (`archiver.restore.batchIds` and/or
  `archiver.restore.baskets`, resolved to their `archive_batch_id`) and restores them in parent →
  child order into a separate investigation DB (`archiver.restore.targetDb`, refusing the live source
  unless `archiver.restore.allowRestoreToSource`), auto-creating the investigation table, idempotent
  per batch, audited in `archive_restore_log`.
- **Phase 8 (runbook):** perf test, dry-run, and staged prod rollout — execution/validation against
  real infrastructure (no new engine code). See [`../docs/data-archival-rollout.md`](../docs/data-archival-rollout.md)
  for the perf-test + tuning loop, dry-run/break-glass/restore drills, staged go/no-go rollout,
  monitoring/alerting, and abort/rollback. Generate local volume with `dev/perf-seed.sql`.

## Local dev with Docker SQL Server

From the repo root (`swap-rules-engine/`):

```bash
# 1. Start the SQL Server container (defined in docker-compose.yml)
docker compose up -d mssql

# 2. Create the dev databases (control / source / target / investigation)
docker exec -i swap-rules-mssql /opt/mssql-tools18/bin/sqlcmd \
  -S localhost -U sa -P 'Swap_rules_1!' -C -No -i - < swap-archiver/dev/bootstrap.sql

# 3. Run pre-flight (DRY_RUN is the default mode)
mvn -pl swap-archiver -am spring-boot:run
```

On first run Flyway creates the `archive.*` control tables in `archive_control`, then the
pre-flight report is printed. With no `archive_table` rows yet, table-level checks warn (expected).

### Phase 2 demo (SAME_DB archive)

```bash
# Seed a sample source/archive table + eligible baskets (creates dw.Trades + config)
docker exec -i swap-rules-mssql /opt/mssql-tools18/bin/sqlcmd \
  -S localhost -U sa -P 'Swap_rules_1!' -C -No -i - < swap-archiver/dev/seed-phase2.sql

# Run the archive: copies eligible baskets (100,101) to dw.Trades_Archive and deletes them from dw.Trades.
# SAME_DB ⇒ the archive table lives in the source DB, so point the target endpoint at dw too.
TGT_DB=dw ARCHIVER_MODE=ARCHIVE mvn -pl swap-archiver spring-boot:run

# Verify: Trades_Archive has the 3 moved rows; Trades keeps only basket 200; baskets flagged archived
docker exec swap-rules-mssql /opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P 'Swap_rules_1!' -C -No -d dw \
  -Q "SELECT 'archived'=COUNT(*) FROM dbo.Trades_Archive; SELECT 'remaining'=COUNT(*) FROM dbo.Trades"
```

Re-running `ARCHIVE` is idempotent — the archived baskets are no longer eligible, so a second run
moves nothing.

### Phase 7 demo (restore for investigation)

```bash
# Restore the rows archived for baskets 100,101 into the investigation DB (not the live source).
# The engine resolves each basket's archive_batch_id and copies its rows back, parent → child.
TGT_DB=dw ARCHIVER_MODE=RESTORE RESTORE_BASKETS=100,101 mvn -pl swap-archiver spring-boot:run

# Verify: the rows land in archive_investigation, and the restore is audited.
docker exec swap-rules-mssql /opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P 'Swap_rules_1!' -C -No \
  -d archive_investigation -Q "SELECT 'restored'=COUNT(*) FROM dbo.Trades_Archive"
```

You can also restore by run id directly with `RESTORE_BATCH_IDS=<runId>`. Restore is idempotent
(prior rows for the same batch are cleared first) and refuses to write into the live source DB
unless `archiver.restore.allow-restore-to-source=true`.

## Emergency stop (break-glass)

The engine is crash-safe (every chunk is transactional), so stopping is always safe and
restartable. Fastest → safest:

```sql
-- From any SQL client: halt at the next committed boundary.
UPDATE archive.archive_job
SET run_signal = 'STOP', signal_reason = '<why>', signal_by = SUSER_SNAME(), signal_at = SYSUTCDATETIME()
WHERE job_name = 'basket-archive';
-- Resume later:
UPDATE archive.archive_job SET run_signal = 'RUN' WHERE job_name = 'basket-archive';
```

- `STOP` stays down until reset to `RUN`; `PAUSE` resumes next window.
- Or run the jar: `ARCHIVER_MODE=STOP mvn -pl swap-archiver spring-boot:run`.
- Last resort: SIGTERM/Ctrl-C (graceful), or `kill -9` / SQL Server `KILL <spid>` — still safe;
  the in-flight transaction rolls back and restart resumes from the last committed chunk.

## Auth modes

| Mode | Config | Notes |
|---|---|---|
| SQL (dev) | `auth: sql`, `credential.provider: env` | username/password from config/env |
| SQL (prod) | `auth: sql`, `credential.provider: cyberark-ccp` | CyberArk CCP (REST + mTLS + AppID) |
| Kerberos | `auth: kerberos` | consumes an existing ticket/keytab; set the URL's `authenticationScheme=JavaKerberos` |
| Integrated | `auth: integrated` | Windows `integratedSecurity=true` |

Override any default via env vars (e.g. `SRC_AUTH=kerberos`, `TGT_CRED=cyberark-ccp`,
`ARCHIVER_MODE=ARCHIVE`). See `src/main/resources/application.yml`.
