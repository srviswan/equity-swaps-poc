-- ============================================================================
-- Basket-state source: where the engine reads basket lifecycle from to refresh
-- basket_archive_state (e.g. a DimBasket dimension on the source DW). All NULL =
-- operator/ETL seeds basket_archive_state directly and the engine skips refresh.
-- ============================================================================
ALTER TABLE archive_job ADD
    basket_source_table        VARCHAR(256) NULL,  -- e.g. dbo.DimBasket
    basket_key_column          VARCHAR(128) NULL,  -- basket key column on the source
    basket_status_column       VARCHAR(128) NULL,  -- optional status column
    basket_termination_column  VARCHAR(128) NULL,  -- termination date column
    basket_terminated_value    VARCHAR(64)  NULL;  -- status value meaning "terminated"
