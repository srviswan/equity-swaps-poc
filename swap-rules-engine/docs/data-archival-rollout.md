# Data archival — Phase 8 rollout runbook

Operational guide to take the archiver from "all features built + green tests" to "running safely
in production across the 20 tables / 3–5 B rows". It complements the architecture in
[`data-archival-design.md`](./data-archival-design.md); read that first. For **partition `SWITCH` vs
basket-driven** archival (and where `SWITCH` is still used on the archive for retention purge), see
[`data-archival-partition-switch-vs-basket-driven.md`](./data-archival-partition-switch-vs-basket-driven.md).

Phase 8 is **execution + validation against real infrastructure**, not new engine code. Work
through it in order; each stage has explicit **go / no-go gates** and is fully restartable, so a
failed gate never leaves data half-moved.

---

## 0. Pre-requisites (one-time)

- [ ] Engine artifact built from a tagged commit; `mvn -pl swap-archiver -am verify` green.
- [ ] Control DB (`archive_control`) provisioned; Flyway migrations `V001–V003` applied.
- [ ] Service account exists with the **least-privilege** grants from the design doc §6
      (source: `SELECT` + `DELETE` + `ALTER` on in-scope tables; target: `INSERT`/DDL;
      control: `db_owner` on `archive_control` only).
- [ ] Auth verified end-to-end in the target environment (Kerberos ticket / keytab, or CyberArk
      CCP reachability + mTLS cert). A `DRY_RUN` that passes pre-flight proves this.
- [ ] FK graph confirmed and encoded as `dependency_level` per table; `join_columns` /
      `key_resolution` (DIRECT vs BRIDGE) set and **pre-flight-validated** (supporting indexes exist).
- [ ] Archive DB recovery model and placement decided (recommended: **SIMPLE**, **outside the AG**,
      so the copy half doesn't ship over the AG — `CROSS_DB`/`CROSS_SERVER`).
- [ ] Monitoring wired (see §5) and an on-call owner identified for the run windows.

---

## 1. Objectives & overall exit criteria

| Goal | Measure | Target (tune per environment) |
|---|---|---|
| No BAU impact | Source blocking / lock waits during a window | No BAU query blocked > a few seconds; engine yields |
| Bounded log growth | `archive_job.log_used_pct_pause` respected | Log used % never sustained above pause threshold |
| AG protected | `redo`/`send` queue under the configured cap | RPO preserved; engine pauses before breaching |
| Throughput | rows/sec sustained | Enough to clear 3–5 B in the available weekend windows |
| Correctness | `CHECKSUM_AGG` source == target before delete | 0 mismatches; 0 row-count discrepancies |
| Restartability | resume after induced crash | No duplicates, no loss; chunk log consistent |

---

## 2. Performance test (non-prod)

Run on a **restored copy of production** (ideal: includes the ~1 TB table) or, for a local smoke,
the synthetic generator [`swap-archiver/dev/perf-seed.sql`](../swap-archiver/dev/perf-seed.sql).

### 2.1 Generate / stage volume

```bash
# Local smoke (scale via the @baskets / @tradesPerBasket knobs at the top of the file):
docker exec -i swap-rules-mssql /opt/mssql-tools18/bin/sqlcmd \
  -S localhost -U sa -P 'Swap_rules_1!' -C -No -d dw < swap-archiver/dev/perf-seed.sql
```

For the real test, restore a prod backup into a non-prod instance and point the `source` endpoint
at it. Do **not** point a perf test at live prod.

### 2.2 What to measure (per chunk and per run)

The engine already records most of this in the control tables — query them while it runs:

```sql
-- Live throughput + adaptive batch behaviour (run repeatedly during the test):
SELECT TOP 20 chunk_no, source_table, state, rows_copied, rows_deleted,
       duration_ms, log_used_pct, ag_redo_queue_kb, updated_at_utc
FROM archive_control.dbo.archive_chunk_log
ORDER BY updated_at_utc DESC;

-- Per-run rollup:
SELECT run_id, status, baskets_selected, rows_copied, rows_deleted,
       DATEDIFF(SECOND, started_at_utc, ISNULL(ended_at_utc, SYSUTCDATETIME())) AS secs
FROM archive_control.dbo.archive_run ORDER BY run_id DESC;
```

Also watch on the **source instance**: `sys.dm_db_log_space_usage`, `log_reuse_wait_desc`,
`sys.dm_exec_requests` (blocking), and AG `log_send_queue_size` / `redo_queue_size`.

### 2.3 Tuning loop

All knobs live in `archive_job` (data — no redeploy). Adjust, re-run, compare `duration_ms` and the
pressure columns:

| Symptom | Knob | Direction |
|---|---|---|
| Chunks finish far under `target_chunk_millis` | `default/max_batch_size` | increase |
| Chunks overshoot the window / cause blocking | `target_chunk_millis`, `max_batch_size` | decrease |
| Log fills / frequent pauses | `log_used_pct_pause`; log-backup cadence | lower threshold / back up log more often |
| AG secondary falls behind | `ag_redo_queue_pause` | lower (pause earlier) |
| Slow deletes | supporting index on `join_columns`; clustered-key alignment | add/align index |

**Gate G2:** sustained throughput extrapolates to clearing the backlog within the available
windows; 0 checksum mismatches; log + AG stayed inside thresholds; an induced kill mid-chunk
resumed cleanly (see §6).

---

## 3. Dry-run on a prod-like replica

```bash
ARCHIVER_MODE=DRY_RUN mvn -pl swap-archiver spring-boot:run
```

- [ ] Pre-flight passes: connectivity, permissions, schema consistency (source vs archive columns),
      supporting indexes (incl. BRIDGE mapping indexes), capacity.
- [ ] Worklist scope reviewed: count of eligible baskets and the **`NEEDS_REVIEW`** set (terminated
      but undated) triaged with the data owners — these are intentionally *not* archived.
- [ ] `archive_window` rows configured (typically large weekend windows); confirm the engine refuses
      to start a chunk that wouldn't finish before the window closes.
- [ ] **Break-glass drill**: flip `run_signal = 'STOP'`, confirm halt at the next committed boundary,
      then `RUN` to resume.
- [ ] **Restore drill**: archive a known basket in non-prod, then
      `ARCHIVER_MODE=RESTORE RESTORE_BASKETS=<key>` and confirm rows land in the investigation DB and
      `archive_restore_log` shows `DONE`.

**Gate G3:** pre-flight clean, scope signed off by data owners, windows + break-glass + restore all
demonstrated.

---

## 4. Staged production rollout

Ramp blast radius gradually. Each stage is a full run cycle; promote only after its gate passes.

### Stage A — single small table, off-peak
- One low-volume, leaf (`dependency_level` highest) table; `CROSS_DB` to the SIMPLE-recovery archive
  DB; `checksum_verify = 1`; small `max_batch_size`.
- Verify counts, checksums, lineage (`archive_batch_id`), and BAU is undisturbed.
- **Gate A:** clean run + a successful restore of one archived basket from this table.

### Stage B — ramp tables and volume
- Enable a handful of related tables (respecting `dependency_level`); raise `max_batch_size` toward
  the perf-test sweet spot; run inside a real weekend window.
- Watch the §5 dashboards; confirm pauses behave and no BAU blocking.
- **Gate B:** multiple windows completed; adaptive sizing stable; backlog burning down on schedule.

### Stage C — full 20 tables, steady state
- All tables enabled; weekend (and any weekday) windows configured; `update_stats_after = 1`.
- Run to backlog completion across successive windows; the run is naturally resumable between them.
- **Gate C:** backlog cleared; steady-state incremental archiving keeps pace with new terminations.

---

## 5. Monitoring & alerting

The engine emits one structured line per run for log-based scraping (no in-process HTTP server):

```
ARCHIVE_SUMMARY run=<id> status=DONE|PAUSED chunks=<n> copied=<n> deleted=<n> duration_ms=<n> halt=<reason|->
```

- Ship logs to your platform (Splunk/ELK/Loki) or a Prometheus **textfile collector** / log exporter;
  build a dashboard on `copied`/`deleted`/`duration_ms` and chunk-level `log_used_pct` /
  `ag_redo_queue_kb`.
- **Alerts** — page/notify on lines prefixed `ALERT`:
  - `ALERT ... FAILED` — run failed (resumable; investigate `error_text` in `archive_chunk_log`).
  - `ALERT ... PAUSED` — halted on window close or sustained log/AG pressure (often expected; alert
    if it recurs or backlog stalls).
  - `ALERT RESTORE failed` — investigation restore failed.
- Control-table health checks (schedule):
  ```sql
  -- Stuck/failed chunks:
  SELECT * FROM archive_control.dbo.archive_chunk_log WHERE state = 'FAILED';
  -- Indexes left disabled by a crash (should self-heal on next run's rebuild):
  SELECT * FROM archive_control.dbo.archive_index_state;
  ```

---

## 6. Abort / rollback

- **Stop now:** set `archive_job.run_signal = 'STOP'` (or `ARCHIVER_MODE=STOP`). Halts at the next
  committed boundary; restart resumes from the last `DONE` chunk. `kill -9` / SQL `KILL <spid>` is
  also safe — the in-flight transaction rolls back.
- **Same-server (`SAME_DB`/`CROSS_DB`)** copy+delete is one transaction per chunk → a crash leaves
  the chunk fully present in source (no partial move).
- **`CROSS_SERVER`** uses the checkpointed copy→verify→delete state machine; a crash after `COPIED`
  resumes delete-only — never re-copies or duplicates.
- **Undo an archived slice:** restore it from the archive (Phase 7 reverse pipeline) into the
  investigation DB for inspection; restoring into the live source is gated behind
  `archiver.restore.allow-restore-to-source` and should be a deliberate, reviewed action.

---

## 7. Post-archive purge cadence (separate from archiving)

Archiving moves rows *into* the archive; purging ages them *out*. Run on its own schedule:

- Archive tables are partitioned by `archived_period_key` (or business date). Purge years older than
  `archive_job.archive_retention_yrs` by **`SWITCH PARTITION` to a staging table + `TRUNCATE`/drop** —
  a metadata operation, no row-by-row delete.
- Validate the partition function/scheme has boundaries for upcoming periods before they're needed.

---

## 8. Final sign-off checklist

- [ ] G2 (perf), G3 (dry-run), and Gates A/B/C passed and recorded.
- [ ] Runbook owners + on-call rota for windows documented.
- [ ] Dashboards + `ALERT` alerts live and tested.
- [ ] Restore procedure exercised and documented for investigations.
- [ ] Purge job scheduled and validated independently.
- [ ] Rollback procedure rehearsed.
