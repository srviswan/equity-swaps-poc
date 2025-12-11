-- 03_create_marker_tables.sql
-- Create marker tables for tracking archival eligibility and execution

USE control_db;
GO

-- Archival marker - tracks which records are eligible for archival
CREATE TABLE control.archival_marker (
    marker_id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    source_database VARCHAR(100) NOT NULL,
    table_schema VARCHAR(50) NOT NULL,
    table_name VARCHAR(100) NOT NULL,
    
    -- Record identification
    primary_key_hash VARCHAR(256) NOT NULL, -- Hashed PK for quick lookup
    primary_key_values NVARCHAR(MAX) NOT NULL, -- JSON or concatenated PK values
    
    -- Archival status
    archival_eligible BIT DEFAULT 0 NOT NULL,
    marked_date DATETIME DEFAULT GETDATE(),
    archival_month VARCHAR(6) NULL, -- YYYYMM format for monthly partitioning
    
    -- Execution tracking
    moved_to_monthly_archive BIT DEFAULT 0 NOT NULL,
    monthly_archive_date DATETIME NULL,
    monthly_archive_table VARCHAR(200) NULL,
    
    moved_to_archive_db BIT DEFAULT 0 NOT NULL,
    archive_db_date DATETIME NULL,
    
    -- Batch tracking
    batch_id UNIQUEIDENTIFIER NULL,
    
    CONSTRAINT UQ_archival_marker UNIQUE (source_database, table_schema, table_name, primary_key_hash)
);

CREATE INDEX IDX_archival_eligible ON control.archival_marker(source_database, table_name, archival_eligible);
CREATE INDEX IDX_archival_month ON control.archival_marker(archival_month, moved_to_monthly_archive);
CREATE INDEX IDX_batch_id ON control.archival_marker(batch_id);

PRINT 'Created archival_marker table';
GO

-- Execution log - tracks all archival operations
CREATE TABLE control.archival_execution_log (
    log_id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    batch_id UNIQUEIDENTIFIER NOT NULL,
    execution_start DATETIME DEFAULT GETDATE(),
    execution_end DATETIME NULL,
    
    -- Operation details
    operation VARCHAR(50) NOT NULL, -- 'MARK', 'MOVE_TO_MONTHLY', 'MOVE_TO_ARCHIVE_DB'
    source_database VARCHAR(100) NULL,
    table_schema VARCHAR(50) NULL,
    table_name VARCHAR(100) NULL,
    archival_month VARCHAR(6) NULL, -- YYYYMM
    
    -- Results
    records_affected INT NULL,
    status VARCHAR(50) NOT NULL, -- 'RUNNING', 'SUCCESS', 'FAILED'
    error_message NVARCHAR(MAX) NULL,
    duration_seconds INT NULL,
    
    created_date DATETIME DEFAULT GETDATE()
);

CREATE INDEX IDX_batch_id_log ON control.archival_execution_log(batch_id);
CREATE INDEX IDX_execution_start ON control.archival_execution_log(execution_start DESC);
CREATE INDEX IDX_operation ON control.archival_execution_log(operation, status);

PRINT 'Created archival_execution_log table';
GO

-- Monthly archival tracking - tracks monthly archival tables
CREATE TABLE control.monthly_archival_tracking (
    tracking_id INT IDENTITY(1,1) PRIMARY KEY,
    source_database VARCHAR(100) NOT NULL,
    table_schema VARCHAR(50) NOT NULL,
    base_table_name VARCHAR(100) NOT NULL,
    
    -- Monthly archival table info
    archival_month VARCHAR(6) NOT NULL, -- YYYYMM
    monthly_table_name VARCHAR(200) NOT NULL,
    created_date DATETIME DEFAULT GETDATE(),
    
    -- Movement to archive_db
    moved_to_archive_db BIT DEFAULT 0 NOT NULL,
    archive_db_date DATETIME NULL,
    
    -- Record counts
    record_count BIGINT NULL,
    
    CONSTRAINT UQ_monthly_archival UNIQUE (source_database, table_schema, base_table_name, archival_month)
);

CREATE INDEX IDX_monthly_archival_month ON control.monthly_archival_tracking(archival_month, moved_to_archive_db);
CREATE INDEX IDX_base_table ON control.monthly_archival_tracking(source_database, base_table_name);

PRINT 'Created monthly_archival_tracking table';
GO

PRINT 'All marker tables created successfully';
