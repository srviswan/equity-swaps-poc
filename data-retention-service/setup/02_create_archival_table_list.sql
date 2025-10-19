-- 02_create_archival_table_list.sql
-- Create configuration table for archival table list with retention policies

USE control_db;
GO

-- Create control schema
IF NOT EXISTS (SELECT * FROM sys.schemas WHERE name = 'control')
BEGIN
    EXEC('CREATE SCHEMA control');
    PRINT 'Created control schema';
END
GO

-- Archival table configuration list with retention policies
CREATE TABLE control.archival_table_list (
    config_id INT IDENTITY(1,1) PRIMARY KEY,
    source_database VARCHAR(100) NOT NULL,
    table_schema VARCHAR(50) NOT NULL DEFAULT 'dbo',
    table_name VARCHAR(100) NOT NULL,
    
    -- Archival configuration
    archival_enabled BIT DEFAULT 1 NOT NULL,
    archival_type VARCHAR(50) NOT NULL DEFAULT 'DATE_BASED', -- 'CONTRACT_MATURITY', 'DATE_BASED', 'MANUAL'
    date_column VARCHAR(100) NULL, -- Column to check for date-based archival
    months_before_archival INT DEFAULT 13 NOT NULL, -- Months before eligible for archival
    
    -- Retention and disposal configuration
    retention_years_in_archive INT DEFAULT 7 NOT NULL,  -- Years to keep in archive_db
    disposal_enabled BIT DEFAULT 1 NOT NULL,            -- Enable automatic disposal
    disposal_method VARCHAR(50) DEFAULT 'DELETE',        -- 'DELETE' or 'PARTITION_DROP'
    
    -- Partition configuration
    partition_column VARCHAR(100) NOT NULL DEFAULT 'archival_flag', -- Column used for partitioning
    primary_key_columns VARCHAR(500) NOT NULL, -- Comma-separated PK columns
    
    -- Monthly archival table naming
    monthly_archival_table_pattern VARCHAR(200) NOT NULL DEFAULT '{table_name}_Archive_{YYYYMM}',
    
    -- Final archival destination
    archive_db_schema VARCHAR(100) NOT NULL, -- Schema in archive_db (e.g., SourceDB1)
    archive_db_table VARCHAR(100) NOT NULL, -- Table name in archive_db
    
    -- Metadata
    created_date DATETIME DEFAULT GETDATE(),
    last_archived DATETIME NULL,
    last_disposal DATETIME NULL,                        -- Track last disposal
    active BIT DEFAULT 1 NOT NULL,
    
    CONSTRAINT UQ_archival_table UNIQUE (source_database, table_schema, table_name)
);

-- Indexes for performance
CREATE INDEX IDX_archival_enabled ON control.archival_table_list(archival_enabled, active);
CREATE INDEX IDX_source_db ON control.archival_table_list(source_database);
CREATE INDEX IDX_disposal_enabled ON control.archival_table_list(disposal_enabled, retention_years_in_archive);

PRINT 'Created archival_table_list configuration table with retention policies';
GO
