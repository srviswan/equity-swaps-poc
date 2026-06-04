-- ============================================================================
-- Post-archive statistics maintenance. After a run deletes large slices from the
-- source, its statistics are stale and plans can regress (the original risk). When
-- this flag is set the engine runs UPDATE STATISTICS on every in-scope source table
-- at the end of a successful run. Off for jobs that prefer a separate maintenance
-- window (full-scan stats on a 1 TB table are expensive).
-- ============================================================================
ALTER TABLE archive_job ADD
    update_stats_after BIT NOT NULL DEFAULT 1;
