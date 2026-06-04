-- ============================================================================
-- Dev-only seed for the phase-2 SAME_DB demo (Docker SQL Server).
-- Creates a small source + archive table in dw, seeds basket lifecycle state,
-- and configures the basket-archive job to move baskets 100 & 101 (terminated
-- long ago) while leaving the active basket 200 in place.
--   sqlcmd -S localhost -U sa -P 'Swap_rules_1!' -i dev/seed-phase2.sql
-- Then run:  ARCHIVER_MODE=ARCHIVE mvn -pl swap-archiver spring-boot:run
-- ============================================================================
USE dw;
GO
DROP TABLE IF EXISTS dbo.Trades;
DROP TABLE IF EXISTS dbo.Trades_Archive;
GO
CREATE TABLE dbo.Trades (trade_id INT NOT NULL PRIMARY KEY, basket_key BIGINT NOT NULL, amount INT);
CREATE INDEX ix_trades_basket ON dbo.Trades (basket_key);     -- supporting index for the join (pre-flight enforced)
CREATE TABLE dbo.Trades_Archive (
    trade_id            INT       NOT NULL,
    basket_key          BIGINT    NOT NULL,
    amount              INT,
    archive_batch_id    BIGINT,        -- lineage (populated by the engine)
    archived_at_utc     DATETIME2,
    archived_period_key INT
);
GO
INSERT INTO dbo.Trades VALUES (1,100,10),(2,100,20),(3,101,30),(4,200,40);
GO

USE archive_control;
GO
DELETE FROM archive_chunk_log;
DELETE FROM archive_worklist;
DELETE FROM archive_run;
DELETE FROM archive_table;
DELETE FROM basket_archive_state;
DELETE FROM archive_job;
GO
INSERT INTO archive_job (job_name, topology, retention_months) VALUES ('basket-archive','SAME_DB',13);
INSERT INTO archive_table
    (job_name, source_schema, source_table, target_schema, target_table,
     dependency_level, join_columns, key_resolution, copy_strategy)
VALUES
    ('basket-archive','dbo','Trades','dbo','Trades_Archive', 0, 'basket_key', 'DIRECT', 'SAME_DB');
-- Baskets 100 & 101 terminated > 13 months ago (eligible); 200 still active.
INSERT INTO basket_archive_state (basket_key, termination_date, status) VALUES
    (100, '2020-01-01', 'TERMINATED'),
    (101, '2020-02-01', 'TERMINATED'),
    (200, NULL,         'ACTIVE');
GO
