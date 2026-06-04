-- ============================================================================
-- Dev/perf seed: generate a LARGE synthetic source table to exercise the engine
-- under volume (adaptive batch sizing, log/AG throttling, chunk pacing). This is
-- a local perf *smoke* — a true 1 TB run uses a restored copy of prod (see
-- docs/data-archival-rollout.md). NOT for production.
--
--   sqlcmd -S localhost -U sa -P 'Swap_rules_1!' -C -No -d dw -i dev/perf-seed.sql
--   ARCHIVER_MODE=ARCHIVE TGT_DB=dw mvn -pl swap-archiver spring-boot:run
--
-- Scale with the two knobs below. Rows = @baskets * @tradesPerBasket.
--   5000 * 2000   = 10,000,000 rows   (a few minutes to seed)
--   20000 * 5000  = 100,000,000 rows  (sizeable; expect longer seed + run)
-- ============================================================================
SET NOCOUNT ON;
USE dw;
GO

DECLARE @baskets        INT = 5000;     -- number of terminated (eligible) baskets
DECLARE @tradesPerBasket INT = 2000;    -- rows per basket
DECLARE @baseBasket     BIGINT = 1000000;
DECLARE @rows           BIGINT = CAST(@baskets AS BIGINT) * @tradesPerBasket;

DROP TABLE IF EXISTS dbo.Trades;
DROP TABLE IF EXISTS dbo.Trades_Archive;
GO
CREATE TABLE dbo.Trades (
    trade_id          BIGINT   NOT NULL,
    basket_key        BIGINT   NOT NULL,
    business_date_key INT      NOT NULL,
    amount            DECIMAL(18,2) NOT NULL,
    payload           CHAR(200) NOT NULL DEFAULT 'x',   -- pad the row so volume is realistic
    CONSTRAINT pk_trades PRIMARY KEY CLUSTERED (trade_id)
);
CREATE INDEX ix_trades_basket ON dbo.Trades (basket_key);   -- supporting seek index (pre-flight enforced)

CREATE TABLE dbo.Trades_Archive (
    trade_id            BIGINT   NOT NULL,
    basket_key          BIGINT   NOT NULL,
    business_date_key   INT      NOT NULL,
    amount              DECIMAL(18,2) NOT NULL,
    payload             CHAR(200) NOT NULL,
    archive_batch_id    BIGINT,
    archived_at_utc     DATETIME2,
    archived_period_key INT
);
CREATE INDEX ix_arch_basket ON dbo.Trades_Archive (basket_key);  -- disabled before load, rebuilt after
GO

-- Tally generator (portable to SQL Server 2018 — no GENERATE_SERIES needed).
;WITH
 L0 AS (SELECT 1 c UNION ALL SELECT 1),
 L1 AS (SELECT 1 c FROM L0 a CROSS JOIN L0 b),
 L2 AS (SELECT 1 c FROM L1 a CROSS JOIN L1 b),
 L3 AS (SELECT 1 c FROM L2 a CROSS JOIN L2 b),
 L4 AS (SELECT 1 c FROM L3 a CROSS JOIN L3 b),
 L5 AS (SELECT 1 c FROM L4 a CROSS JOIN L4 b),
 Nums AS (SELECT ROW_NUMBER() OVER (ORDER BY (SELECT NULL)) AS n FROM L5)
INSERT INTO dbo.Trades (trade_id, basket_key, business_date_key, amount, payload)
SELECT
    n,
    @baseBasket + ((n - 1) % @baskets),                       -- spread rows across baskets
    20200101 + CAST((n % 365) AS INT),                        -- a spread of business dates
    CAST(n % 10000 AS DECIMAL(18,2)) + 0.50,
    'x'
FROM Nums
WHERE n <= @rows
OPTION (MAXDOP 4);
GO

-- Refresh stats so the seek plan is sane for the run.
UPDATE STATISTICS dbo.Trades;
GO
SELECT 'Trades rows' = COUNT_BIG(*) FROM dbo.Trades;
GO

-- ----------------------------------------------------------------------------
-- Control config: make every generated basket TERMINATED long ago (eligible).
-- ----------------------------------------------------------------------------
USE archive_control;
GO
DELETE FROM archive_chunk_log;
DELETE FROM archive_worklist;
DELETE FROM archive_restore_log;
DELETE FROM archive_run;
DELETE FROM archive_window;
DELETE FROM archive_index_state;
DELETE FROM archive_table;
DELETE FROM basket_archive_state;
DELETE FROM archive_job;
GO

DECLARE @baskets    INT = 5000;
DECLARE @baseBasket BIGINT = 1000000;

INSERT INTO archive_job
    (job_name, topology, retention_months, default_batch_size, min_batch_size, max_batch_size,
     log_used_pct_pause, ag_redo_queue_pause, update_stats_after)
VALUES
    ('basket-archive', 'SAME_DB', 13, 50000, 5000, 200000, 70, 5000000, 1);

INSERT INTO archive_table
    (job_name, source_schema, source_table, target_schema, target_table,
     dependency_level, join_columns, key_resolution, copy_strategy, disable_target_indexes, checksum_verify)
VALUES
    ('basket-archive','dbo','Trades','dbo','Trades_Archive', 0, 'basket_key', 'DIRECT', 'SAME_DB', 1, 1);

;WITH
 L0 AS (SELECT 1 c UNION ALL SELECT 1),
 L1 AS (SELECT 1 c FROM L0 a CROSS JOIN L0 b),
 L2 AS (SELECT 1 c FROM L1 a CROSS JOIN L1 b),
 L3 AS (SELECT 1 c FROM L2 a CROSS JOIN L2 b),
 L4 AS (SELECT 1 c FROM L3 a CROSS JOIN L3 b),
 Nums AS (SELECT ROW_NUMBER() OVER (ORDER BY (SELECT NULL)) AS n FROM L4)
INSERT INTO basket_archive_state (basket_key, termination_date, status)
SELECT @baseBasket + (n - 1), DATEADD(YEAR, -3, CAST(SYSUTCDATETIME() AS DATE)), 'TERMINATED'
FROM Nums
WHERE n <= @baskets;
GO
SELECT 'eligible baskets' = COUNT_BIG(*) FROM basket_archive_state WHERE status = 'TERMINATED';
GO
