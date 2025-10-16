-- 08_populate_config.sql
-- Populate configuration for test tables

USE control_db;
GO

-- Set required options
SET QUOTED_IDENTIFIER ON;
GO

-- Insert configuration for test tables
INSERT INTO control.archival_table_config (
    source_database, table_schema, table_name, table_type, archival_logic, 
    join_to_contract, months_retention, years_retention_archive, 
    primary_key_columns, execution_priority
)
VALUES 
-- SourceDB1 - Functional tables (contract maturity-based)
('SourceDB1', 'dbo', 'Position', 'FUNCTIONAL', 'CONTRACT_MATURITY', 
 'INNER JOIN SourceDB1.dbo.Contract c ON t.contractId = c.contractId', 
 13, 7, 'basketId,positionId,businessDate', 10),

-- SourceDB2 - Functional tables
('SourceDB2', 'dbo', 'Trade', 'FUNCTIONAL', 'CONTRACT_MATURITY',
 'INNER JOIN SourceDB2.dbo.Contract c ON t.contractId = c.contractId',
 13, 7, 'tradeId', 10),

-- SourceDB3 - Reference tables (date-based, shorter retention)
('SourceDB3', 'dbo', 'PriceHistory', 'REFERENCE', 'DATE_BASED',
 NULL,
 36, 2, 'priceId', 50);

PRINT 'Configuration populated successfully';
