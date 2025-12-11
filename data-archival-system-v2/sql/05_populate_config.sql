-- 05_populate_config.sql
-- Populate archival table list configuration

USE control_db;
GO

-- Configure Position table from SourceDB1
INSERT INTO control.archival_table_list (
    source_database, table_schema, table_name,
    archival_enabled, archival_type, date_column, months_before_archival,
    partition_column, primary_key_columns,
    monthly_archival_table_pattern,
    archive_db_schema, archive_db_table
)
VALUES (
    'SourceDB1', 'dbo', 'Position',
    1, 'DATE_BASED', 'businessDate', 3, -- Archive data older than 3 months
    'businessDate', 'basketId,positionId,businessDate',
    'Position_Archive_{YYYYMM}',
    'SourceDB1', 'Position'
);

-- Configure Trade table from SourceDB2
INSERT INTO control.archival_table_list (
    source_database, table_schema, table_name,
    archival_enabled, archival_type, date_column, months_before_archival,
    partition_column, primary_key_columns,
    monthly_archival_table_pattern,
    archive_db_schema, archive_db_table
)
VALUES (
    'SourceDB2', 'dbo', 'Trade',
    1, 'DATE_BASED', 'tradeDate', 3,
    'tradeDate', 'tradeId',
    'Trade_Archive_{YYYYMM}',
    'SourceDB2', 'Trade'
);

-- Configure PriceHistory table from SourceDB3
INSERT INTO control.archival_table_list (
    source_database, table_schema, table_name,
    archival_enabled, archival_type, date_column, months_before_archival,
    partition_column, primary_key_columns,
    monthly_archival_table_pattern,
    archive_db_schema, archive_db_table
)
VALUES (
    'SourceDB3', 'dbo', 'PriceHistory',
    1, 'DATE_BASED', 'priceDate', 3,
    'priceDate', 'priceId,securityId,priceDate',
    'PriceHistory_Archive_{YYYYMM}',
    'SourceDB3', 'PriceHistory'
);

PRINT 'Archival table list configuration populated';
GO

-- Display configuration
SELECT 
    config_id,
    source_database,
    table_name,
    archival_type,
    months_before_archival,
    monthly_archival_table_pattern,
    archive_db_schema + '.' + archive_db_table AS archive_destination
FROM control.archival_table_list
WHERE archival_enabled = 1;
GO
