-- 02_create_control_tables.sql
-- Create control tables in control_db

USE control_db;
GO

-- Set required options for computed columns
SET QUOTED_IDENTIFIER ON;
GO

-- Create control schema
CREATE SCHEMA control;
GO

-- Master configuration for all archivable tables across multiple databases
CREATE TABLE control.archival_table_config (
    config_id INT IDENTITY(1,1) PRIMARY KEY,
    source_database VARCHAR(100) NOT NULL,  -- Source database name
    table_schema VARCHAR(50) NOT NULL,
    table_name VARCHAR(100) NOT NULL,
    table_type VARCHAR(20) NOT NULL,  -- 'FUNCTIONAL', 'REFERENCE', 'OPERATIONAL'
    archival_enabled BIT DEFAULT 1,
    archival_logic VARCHAR(50) NOT NULL,  -- 'CONTRACT_MATURITY', 'DATE_BASED', 'CUSTOM'
    join_to_contract VARCHAR(500),  -- SQL for joining to Contract table
    date_column VARCHAR(100),  -- Column to check for date-based archival
    months_retention INT,  -- Months before archival eligibility
    years_retention_archive INT DEFAULT 7,  -- Years to keep in archive before disposal
    has_partitioning BIT DEFAULT 0,  -- Is table already partitioned?
    partition_column VARCHAR(100),  -- Column used for partitioning
    primary_key_columns VARCHAR(500),  -- Comma-separated PK columns
    archive_schema AS (source_database) PERSISTED,  -- Computed - source DB becomes archive schema
    last_archived DATETIME NULL,
    last_disposed DATETIME NULL,
    active BIT DEFAULT 1,
    execution_priority INT DEFAULT 50,
    INDEX idx_source_db (source_database, active),
    INDEX idx_table_type (table_type, active),
    UNIQUE (source_database, table_schema, table_name)
);

-- Track archival eligibility across all tables
CREATE TABLE control.archival_marker (
    marker_id BIGINT IDENTITY(1,1) PRIMARY KEY,
    source_database VARCHAR(100) NOT NULL,
    table_schema VARCHAR(50) NOT NULL,
    table_name VARCHAR(100) NOT NULL,
    primary_key_hash VARBINARY(32) NOT NULL,  -- Hash of PK values for generic lookup
    primary_key_values NVARCHAR(500),  -- JSON or delimited string of PK values
    contractId UNIQUEIDENTIFIER NULL,  -- If applicable
    archival_eligible BIT DEFAULT 0,
    marked_date DATETIME DEFAULT GETDATE(),
    archived_date DATETIME NULL,
    retention_expiry_date DATE NULL,
    INDEX idx_table_eligible (source_database, table_schema, table_name, archival_eligible),
    INDEX idx_pk_hash (source_database, table_schema, table_name, primary_key_hash),
    INDEX idx_eligible (archival_eligible, archived_date)
);

-- Execution log for all archival operations
CREATE TABLE control.archival_execution_log (
    log_id BIGINT IDENTITY(1,1) PRIMARY KEY,
    batch_id UNIQUEIDENTIFIER NOT NULL,
    source_database VARCHAR(100),
    table_schema VARCHAR(50),
    table_name VARCHAR(100),
    operation VARCHAR(50),  -- 'MARK', 'ARCHIVE', 'DISPOSE'
    records_affected INT,
    execution_start DATETIME DEFAULT GETDATE(),
    execution_end DATETIME NULL,
    duration_seconds AS DATEDIFF(SECOND, execution_start, execution_end),
    status VARCHAR(20),  -- 'SUCCESS', 'FAILED', 'PARTIAL'
    error_message NVARCHAR(MAX) NULL,
    INDEX idx_batch (batch_id),
    INDEX idx_table (source_database, table_schema, table_name, execution_start DESC)
);

-- Recovery state tracking
CREATE TABLE control.recovery_state (
    id BIGINT IDENTITY PRIMARY KEY,
    batch_id UNIQUEIDENTIFIER NOT NULL,
    source_database VARCHAR(100) NOT NULL,
    table_schema VARCHAR(50) NOT NULL,
    table_name VARCHAR(100) NOT NULL,
    phase VARCHAR(40) NOT NULL,   -- MARKED | SWITCHED_TO_STAGING | COPIED_TO_ARCHIVE | MARKERS_UPDATED | STAGING_TRUNCATED
    started_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME NULL,
    details NVARCHAR(MAX) NULL,
    UNIQUE(batch_id, source_database, table_schema, table_name)
);

PRINT 'Control tables created successfully';
