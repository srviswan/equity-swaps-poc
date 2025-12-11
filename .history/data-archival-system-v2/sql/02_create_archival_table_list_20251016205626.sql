-- 02_create_archival_table_list.sql
-- Create configuration table for archival table list

USE control_db;
GO

-- Create control schema
IF NOT EXISTS (SELECT * FROM sys.schemas WHERE name = 'control')
BEGIN
    EXEC('CREATE SCHEMA control');
    PRINT 'Created control schema';
END
GO

-- Archival table configuration list
CREATE TABLE control.archival_table_list (
    config_id INT IDENTITY(1,1) PRIMARY KEY,
    source_database VARCHAR(100) NOT NULL,
    table_schema VARCHAR(50) NOT NULL DEFAULT 'dbo',
    table_name VARCHAR(100) NOT NULL,
    
    -- Archival configuration
    archival_enabled BIT DEFAULT 1 NOT NULL,
    archival_type VARCHAR(50) NOT NULL, -- 'CONTRACT_MATURITY', 'DATE_BASED', 'MANUAL'
    date_column VARCHAR(100) NULL, -- Column to check for date-based archival
    months_before_archival INT DEFAULT 13 NOT NULL, -- Months before eligible for archival
    
    -- Partition configuration
    partition_column VARCHAR(100) NOT NULL, -- Column used for monthly partitioning (e.g., businessDate)
    primary_key_columns VARCHAR(500) NOT NULL, -- Comma-separated PK columns
    
    -- Monthly archival table naming
    monthly_archival_table_pattern VARCHAR(200) NOT NULL, -- e.g., '{table_name}_Archive_{YYYYMM}'
    
    -- Final archival destination
    archive_db_schema VARCHAR(100) NOT NULL, -- Schema in archive_db (e.g., SourceDB1)
    archive_db_table VARCHAR(100) NOT NULL, -- Table name in archive_db
    
    -- Metadata
    created_date DATETIME DEFAULT GETDATE(),
    last_archived DATETIME NULL,
    active BIT DEFAULT 1 NOT NULL,
    
    CONSTRAINT UQ_archival_table UNIQUE (source_database, table_schema, table_name)
);

CREATE INDEX IDX_archival_enabled ON control.archival_table_list(archival_enabled, active);
CREATE INDEX IDX_source_db ON control.archival_table_list(source_database);

PRINT 'Created archival_table_list configuration table';
GO

