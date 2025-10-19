-- 03_create_marker_tables.sql
-- Create marker tables for tracking archival eligibility, execution, and state management

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
    operation VARCHAR(50) NOT NULL, -- 'MARK', 'PREPARE', 'MOVE_TO_ARCHIVE', 'DISPOSE'
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

-- Execution state management - tracks current execution state for resumability
CREATE TABLE control.archival_execution_state (
    execution_id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    batch_id UNIQUEIDENTIFIER NOT NULL,
    
    -- Execution context
    workflow_type VARCHAR(50) NOT NULL, -- 'ARCHIVAL', 'DISPOSAL', 'LIFECYCLE'
    source_database VARCHAR(100),
    table_name VARCHAR(100),
    
    -- State management
    current_phase VARCHAR(50) NOT NULL, -- 'PREPARE', 'MOVE', 'DISPOSE'
    current_step VARCHAR(100),
    step_sequence INT,
    
    -- Idempotency
    is_complete BIT DEFAULT 0,
    can_resume BIT DEFAULT 1,
    resume_point VARCHAR(200), -- JSON or description of where to resume
    
    -- Timing
    started_at DATETIME DEFAULT GETDATE(),
    last_heartbeat DATETIME DEFAULT GETDATE(),
    completed_at DATETIME,
    
    -- Status
    execution_status VARCHAR(50), -- 'RUNNING', 'SUCCESS', 'FAILED', 'PAUSED'
    
    -- Error tracking
    error_count INT DEFAULT 0,
    last_error NVARCHAR(MAX),
    
    -- Audit
    created_by VARCHAR(100) DEFAULT SYSTEM_USER
);

CREATE INDEX IDX_execution_batch ON control.archival_execution_state(batch_id, execution_status);
CREATE INDEX IDX_execution_resume ON control.archival_execution_state(can_resume, is_complete);

PRINT 'Created archival_execution_state table';
GO

-- Partition switch tracking - tracks partition operations
CREATE TABLE control.partition_switch_tracking (
    tracking_id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    batch_id UNIQUEIDENTIFIER NOT NULL,
    source_database VARCHAR(100),
    table_name VARCHAR(100),
    
    -- Partition detection
    has_partition BIT NOT NULL,
    partition_function VARCHAR(200),
    partition_scheme VARCHAR(200),
    partition_number INT,
    
    -- Operation method
    operation_method VARCHAR(50) NOT NULL, -- 'PARTITION_SWITCH' or 'BULK_COPY'
    operation_reason VARCHAR(200), -- Why this method was chosen
    
    -- Staging table
    staging_table_name VARCHAR(200),
    staging_table_created DATETIME,
    
    -- Results
    records_identified BIGINT,
    records_moved BIGINT,
    operation_status VARCHAR(50) NOT NULL, -- 'PENDING', 'IN_PROGRESS', 'SUCCESS', 'FAILED'
    
    -- Timing
    started_at DATETIME DEFAULT GETDATE(),
    completed_at DATETIME,
    duration_ms INT,
    
    -- Error handling
    error_message NVARCHAR(MAX),
    retry_count INT DEFAULT 0,
    
    -- Audit
    created_date DATETIME DEFAULT GETDATE()
);

CREATE INDEX IDX_partition_tracking_batch ON control.partition_switch_tracking(batch_id, operation_status);
CREATE INDEX IDX_partition_tracking_table ON control.partition_switch_tracking(source_database, table_name);

PRINT 'Created partition_switch_tracking table';
GO

-- Archive data movement tracking - tracks data movement to archive_db
CREATE TABLE control.archive_data_movement_tracking (
    movement_id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    batch_id UNIQUEIDENTIFIER NOT NULL,
    source_database VARCHAR(100),
    staging_table_name VARCHAR(200),
    archive_table_name VARCHAR(200),
    
    -- Movement strategy
    movement_strategy VARCHAR(50), -- 'BCP', 'INSERT_SELECT', 'BULK_INSERT'
    movement_reason VARCHAR(200), -- Why this strategy was chosen
    
    -- Performance metrics
    records_to_move BIGINT,
    records_moved BIGINT,
    data_size_mb DECIMAL(18,2),
    
    -- Timing
    started_at DATETIME,
    completed_at DATETIME,
    duration_ms INT,
    throughput_mb_per_sec DECIMAL(18,2),
    
    -- Status
    operation_status VARCHAR(50), -- 'PENDING', 'IN_PROGRESS', 'SUCCESS', 'FAILED'
    staging_table_dropped BIT DEFAULT 0,
    staging_drop_date DATETIME,
    
    -- Error handling
    error_message NVARCHAR(MAX),
    retry_count INT DEFAULT 0,
    
    -- Audit
    created_date DATETIME DEFAULT GETDATE()
);

CREATE INDEX IDX_movement_tracking_batch ON control.archive_data_movement_tracking(batch_id, operation_status);
CREATE INDEX IDX_movement_tracking_strategy ON control.archive_data_movement_tracking(movement_strategy, operation_status);

PRINT 'Created archive_data_movement_tracking table';
GO

-- Archive disposal tracking - tracks disposal operations
CREATE TABLE control.archive_disposal_tracking (
    disposal_id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    batch_id UNIQUEIDENTIFIER NOT NULL,
    
    -- Target information
    archive_database VARCHAR(100) DEFAULT 'archive_db',
    archive_schema VARCHAR(100) NOT NULL,
    archive_table VARCHAR(100) NOT NULL,
    source_database VARCHAR(100) NOT NULL,  -- Original source for reference
    
    -- Retention policy
    retention_years INT NOT NULL,
    disposal_cutoff_date DATE NOT NULL,     -- Records before this date will be disposed
    
    -- Disposal method
    disposal_method VARCHAR(50) NOT NULL,   -- 'DELETE', 'PARTITION_DROP', 'TRUNCATE'
    disposal_reason VARCHAR(200),           -- Why this method was chosen
    
    -- Records disposal details
    records_identified BIGINT,              -- Records eligible for disposal
    records_disposed BIGINT,                -- Records actually removed
    data_size_mb DECIMAL(18,2),
    
    -- Compliance and audit
    compliance_hold BIT DEFAULT 0,          -- If true, skip disposal
    compliance_reason NVARCHAR(MAX),
    disposal_approved_by VARCHAR(100),      -- Who approved disposal
    disposal_approved_date DATETIME,
    
    -- Timing
    started_at DATETIME DEFAULT GETDATE(),
    completed_at DATETIME,
    duration_ms INT,
    
    -- Status
    operation_status VARCHAR(50) NOT NULL,  -- 'PENDING', 'APPROVED', 'IN_PROGRESS', 'SUCCESS', 'FAILED', 'CANCELLED'
    
    -- Error handling
    error_message NVARCHAR(MAX),
    retry_count INT DEFAULT 0,
    
    -- Audit trail
    created_date DATETIME DEFAULT GETDATE(),
    created_by VARCHAR(100) DEFAULT SYSTEM_USER
);

CREATE INDEX IDX_disposal_status ON control.archive_disposal_tracking(operation_status, started_at);
CREATE INDEX IDX_disposal_table ON control.archive_disposal_tracking(archive_table, disposal_cutoff_date);

PRINT 'Created archive_disposal_tracking table';
GO

-- Monitoring metrics - tracks performance and system health
CREATE TABLE control.archival_metrics (
    metric_id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    batch_id UNIQUEIDENTIFIER,
    
    -- Metric details
    metric_timestamp DATETIME DEFAULT GETDATE(),
    metric_type VARCHAR(50), -- 'THROUGHPUT', 'LATENCY', 'ERROR_RATE', 'QUEUE_SIZE'
    metric_name VARCHAR(100),
    metric_value DECIMAL(18,2),
    metric_unit VARCHAR(20),
    
    -- Context
    source_database VARCHAR(100),
    table_name VARCHAR(100),
    operation VARCHAR(50),
    
    -- Aggregation
    aggregation_window_minutes INT DEFAULT 5,
    
    -- Alerts
    threshold_exceeded BIT DEFAULT 0,
    alert_severity VARCHAR(20) -- 'INFO', 'WARNING', 'CRITICAL'
);

CREATE INDEX IDX_metrics_timestamp ON control.archival_metrics(metric_timestamp DESC);
CREATE INDEX IDX_metrics_alerts ON control.archival_metrics(threshold_exceeded, alert_severity);

PRINT 'Created archival_metrics table';
GO

PRINT 'All marker and tracking tables created successfully';
