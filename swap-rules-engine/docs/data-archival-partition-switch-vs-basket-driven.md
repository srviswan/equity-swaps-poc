# Partition `SWITCH` vs basket-driven archival (quick comparison)

This note compares two **different** uses of partitioning, then contrasts **source removal**
via `ALTER TABLE … SWITCH` with the **current engine** (basket lifecycle → chunked copy → verify →
delete). Read alongside [`data-archival-design.md`](./data-archival-design.md).

---

## Two places partitioning appears

| Where | Role today | Mechanism |
|-------|------------|-----------|
| **Source DW** | Tables are **not** partitioned | Removal = batched `DELETE` (after copy to archive) |
| **Archive store** | Tables **are** partitioned on `archived_period_key` (`YYYYMM`) | **Retention purge** = `SWITCH PARTITION` to staging + drop (metadata-only, seconds) |

Do not conflate them. The engine **already** uses partition `SWITCH` on the **archive** side for
regulatory retention (drop partitions older than N years). The design choice under review is whether
**source** retirement should also be `SWITCH`-based instead of basket-keyed copy + delete.

---

## What “partition SWITCH archival” usually means (source)

Typical pattern on a **date-partitioned** fact table:

1. Identify partitions whose data is wholly “cold” (e.g. all activity before a cutoff date).
2. `ALTER TABLE … SWITCH PARTITION` the partition to an archive table (or staging), then truncate/drop on source.
3. Source row removal is **metadata-only** (partition detach), not row-by-row `DELETE`.

**Assumption:** cold data aligns with **partition boundaries** (calendar month, business date, etc.).

---

## What we do today (basket-driven)

Eligibility is **not** “everything before date D.” It is **basket grain**:

```text
DimBasket termination event
  → basket_archive_state (TERMINATED + termination_date + 13-month dormancy)
  → worklist of basket_key values
  → per chunk: same basket set across ~20 tables (DIRECT or BRIDGE joins)
  → copy → verify (checksum) → delete on source
  → mark basket archived; rows land in current archived_period partition on target
```

- **Unit of removal:** all rows for basket *B* across all in-scope tables (logical product cut).
- **Source:** `INSERT…SELECT` / `BulkCopy` + `DELETE` with staged `#archive_keys` (seek, not scan).
- **Pacing:** adaptive batches, log/AG throttling, weekend windows, break-glass, restartable chunks.

---

## Why basket lifecycle fights naive source `SWITCH`

| Basket-driven fact | Implication for source `SWITCH` |
|--------------------|----------------------------------|
| Eligibility = **terminated basket** after **N months since termination**, not calendar age of rows | A “January 2024” partition still holds **active** baskets; you cannot switch the whole partition out. |
| One basket’s rows span **many** `business_date_key` / periods on large facts | No single source partition contains “this basket only.” |
| **All** tables for the same basket move together (FK / consistency) | `SWITCH` is per **table**; twenty tables rarely share identical partition boundaries and cold cutoffs. |
| **NEEDS_REVIEW** (terminated, no date) must **never** auto-archive | Date-partition “archive everything &lt; X” would bypass quarantine unless extra rules are built. |
| Reactivation = **new** surrogate; old basket is immutable | Row-level/basket-level delete is correct; partition-wide drop risks wrong scope if mis-partitioned. |
| `business_date_key` is a **surrogate** (order ≠ time) | Partitioning source on that key does **not** give time-locality for cold data. |

**Bottom line:** source `SWITCH` works when **partition = retention unit**. Here the retention unit is
**basket**, which is orthogonal to how SQL Server range partitions are usually defined (date/period).

---

## Side-by-side comparison

| Dimension | Source partition `SWITCH` (classic) | Current basket-driven engine |
|-----------|-----------------------------------|------------------------------|
| **Eligibility driver** | Time / partition boundary (“all rows in P are cold”) | `DimBasket` termination + configurable dormancy (e.g. 13 months) |
| **Granularity** | Whole partition(s) per table | Subset of rows per table (one or more `basket_key`s per chunk) |
| **Consistency across 20 tables** | Only if all tables share aligned partitioning + same cutoff — rare | Same basket set per chunk; `dependency_level` ordering |
| **Source prerequisite** | Source **must** be partitioned; aligned indexes; staging/archive table with matching partition scheme | Seeking index on `join_columns` (+ bridge index for BRIDGE); source may stay unpartitioned |
| **Source removal cost** | Metadata detach (very low log/delete cost **per partition**) | Logged `DELETE` (FULL recovery + AG); throttled and batched |
| **Archive population** | Partition often **is** the archive slice (switch in place) | Explicit copy (`SAME_DB` / `CROSS_DB` / `CROSS_SERVER`) + optional checksum |
| **Partial / staggered retirement** | Poor fit if cold rows are mixed inside hot partitions | Natural: only eligible baskets move; active baskets untouched |
| **AG / log pressure** | Low for detach; still logged for any bulk load to archive if separate | Copy + delete both log/shipped on AG source (mitigated: smaller chunks, pause, non-AG archive DB) |
| **Restart / failure** | Partition switch is largely atomic per partition | Per-chunk, per-table checkpoint (`archive_chunk_log`); cross-server `COPIED` resume |
| **Investigation restore** | Reload partition or copy out | Lineage by `basket_key` / `archive_batch_id` into investigation DB |
| **Archive retention purge** | Same `SWITCH` tooling on archive | **Already planned:** `SWITCH` on `archived_period_key` after N years |
| **Fit for ~1 TB non-partitioned source** | Requires **redesign + backfill** partition function/scheme + likely downtime/migration | Matches “source not partitioned” locked decision |

---

## What we already get from `SWITCH` (archive side)

The current design **does** use partition switching where it fits:

- Target partitioned on **`archived_period_key`** (month of archive run).
- Because a basket is archived **in one chunk**, its rows land in **one** archived-period partition.
- Purging data older than regulatory retention = **`SWITCH` partition out + drop** (fast, no row delete on billions in archive).

That addresses **“how do we drop old archive data cheaply?”** — not **“how do we remove eligible baskets from the live DW cheaply?”**

---

## Hybrid picture (recommended)

```text
SOURCE (unpartitioned, basket lifecycle)
  refresh basket_archive_state ← DimBasket
  chunk eligible baskets → copy → verify → DELETE
  post-run UPDATE STATISTICS

ARCHIVE (partitioned by archived_period_key)
  load into current period partition (CCI / compressed)
  retention job (separate cadence): SWITCH old partitions → drop
```

Use **basket-driven copy+delete** for **live DW retirement**; use **`SWITCH`** for **archive retention**
and any future source redesign only if eligibility can be expressed as partition boundaries.

---

## When source `SWITCH` is worth revisiting

Consider a **future** source redesign **only if** most of the below become true:

- Legal/ops agree eligibility can move to **time-slice** (e.g. “no BAU on data before business date X”)
  **instead of** or **in addition to** basket termination.
- Large facts are (re)built **partitioned on a real date column** (not `business_date_key` surrogate),
  and “cold” ≈ “whole partitions are cold.”
- The same cutoff applies consistently across the 20-table set (or you accept per-table partition jobs).
- Migration cost (repartition 1 TB+ tables, index rebuild, validation) is funded and scheduled.

Until then, the design doc’s locked position stands: **source not partitioned → batched delete path**,
with **`SWITCH` on the archive store for purge** — which matches **basket-driven life** on the DW and
**period-driven life** on the archive.

---

## One-line summary

| Approach | Best for |
|----------|----------|
| **Source partition `SWITCH`** | Retiring **time-aligned cold partitions** wholesale |
| **Basket-driven engine (current)** | Retiring **terminated product baskets** scattered across time and 20 related tables |
| **Archive partition `SWITCH`** (current target) | Dropping **old archived months** after N years — complementary, not a substitute for basket eligibility |
