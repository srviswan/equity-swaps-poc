-- 04_schema_tracking_tables.sql
-- Schema versioning and change tracking infrastructure

USE control_db;
GO

-- ===========================================
-- TABLE: Archive Schema Versions
-- Tracks different schema versions for each table
-- ===========================================
CREATE TABLE control.archive_schema_versions (
    schema_version_id UNIQUEIDENTIFIER NOT NULL DEFAULT NEWID(),
    source_database VARCHAR(100) NOT NULL,
    table_name VARCHAR(100) NOT NULL,
    schema_version INT NOT NULL,
    schema_hash VARCHAR(32) NOT NULL,
    column_list NVARCHAR(MAX) NOT NULL,
    column_types NVARCHAR(MAX) NOT NULL,
    archive_schema VARCHAR(100) NOT NULL,
    archive_table VARCHAR(200) NOT NULL,
    created_date DATETIME2 NOT NULL DEFAULT GETDATE(),
    is_active BIT NOT NULL DEFAULT 1,
    created_by VARCHAR(100) NOT NULL DEFAULT SYSTEM_USER,
    
    CONSTRAINT PK_archive_schema_versions PRIMARY KEY (schema_version_id),
    CONSTRAINT UQ_archive_schema_versions_table_version UNIQUE (source_database, table_name, schema_version),
    CONSTRAINT UQ_archive_schema_versions_active UNIQUE (source_database, table_name, is_active)
);

-- Index for fast lookups
CREATE INDEX IX_archive_schema_versions_lookup 
ON control.archive_schema_versions (source_database, table_name, is_active);

-- ===========================================
-- TABLE: Schema Change Log
-- Audit trail of schema changes detected and handled
-- ===========================================
CREATE TABLE control.schema_change_log (
    change_id UNIQUEIDENTIFIER NOT NULL DEFAULT NEWID(),
    source_database VARCHAR(100) NOT NULL,
    table_name VARCHAR(100) NOT NULL,
    old_version INT NULL,
    new_version INT NULL,
    change_type VARCHAR(50) NOT NULL, -- 'COLUMN_ADDED', 'COLUMN_REMOVED', 'TYPE_CHANGED', 'SCHEMA_CHANGED'
    change_details NVARCHAR(MAX) NULL,
    old_schema_hash VARCHAR(32) NULL,
    new_schema_hash VARCHAR(32) NULL,
    detected_date DATETIME2 NOT NULL DEFAULT GETDATE(),
    handled_date DATETIME2 NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'DETECTED', -- 'DETECTED', 'HANDLED', 'FAILED', 'IGNORED'
    error_message NVARCHAR(MAX) NULL,
    batch_id UNIQUEIDENTIFIER NULL,
    execution_id UNIQUEIDENTIFIER NULL,
    
    CONSTRAINT PK_schema_change_log PRIMARY KEY (change_id)
);

-- Index for change tracking
CREATE INDEX IX_schema_change_log_table_date 
ON control.schema_change_log (source_database, table_name, detected_date);

-- Index for status tracking
CREATE INDEX IX_schema_change_log_status 
ON control.schema_change_log (status, detected_date);

-- ===========================================
-- TABLE: Archive Table Registry
-- Registry of all archive tables created (for disposal and management)
-- ===========================================
CREATE TABLE control.archive_table_registry (
    registry_id UNIQUEIDENTIFIER NOT NULL DEFAULT NEWID(),
    source_database VARCHAR(100) NOT NULL,
    source_table VARCHAR(100) NOT NULL,
    archive_database VARCHAR(100) NOT NULL DEFAULT 'archive_db',
    archive_schema VARCHAR(100) NOT NULL,
    archive_table VARCHAR(200) NOT NULL,
    schema_version INT NOT NULL,
    table_created_date DATETIME2 NOT NULL DEFAULT GETDATE(),
    last_archived_date DATETIME2 NULL,
    record_count BIGINT NULL DEFAULT 0,
    data_size_mb DECIMAL(18,2) NULL DEFAULT 0,
    is_active BIT NOT NULL DEFAULT 1,
    disposal_enabled BIT NOT NULL DEFAULT 1,
    retention_years INT NOT NULL DEFAULT 7,
    
    CONSTRAINT PK_archive_table_registry PRIMARY KEY (registry_id),
    CONSTRAINT UQ_archive_table_registry_table UNIQUE (archive_database, archive_schema, archive_table)
);

-- Index for disposal queries
CREATE INDEX IX_archive_table_registry_disposal 
ON control.archive_table_registry (disposal_enabled, retention_years, last_archived_date);

-- ===========================================
-- VIEW: Active Schema Versions
-- Convenient view of currently active schema versions
-- ===========================================
GO

CREATE VIEW control.v_active_schema_versions AS
SELECT 
    sv.schema_version_id,
    sv.source_database,
    sv.table_name,
    sv.schema_version,
    sv.schema_hash,
    sv.archive_schema,
    sv.archive_table,
    sv.created_date,
    sv.created_by,
    atr.record_count,
    atr.data_size_mb,
    atr.last_archived_date
FROM control.archive_schema_versions sv
LEFT JOIN control.archive_table_registry atr 
    ON sv.source_database = atr.source_database 
    AND sv.table_name = atr.source_table 
    AND sv.schema_version = atr.schema_version
WHERE sv.is_active = 1;

-- ===========================================
-- VIEW: Schema Change Summary
-- Summary of recent schema changes
-- ===========================================
GO

CREATE VIEW control.v_schema_change_summary AS
SELECT 
    source_database,
    table_name,
    COUNT(*) as total_changes,
    COUNT(CASE WHEN status = 'HANDLED' THEN 1 END) as handled_changes,
    COUNT(CASE WHEN status = 'FAILED' THEN 1 END) as failed_changes,
    COUNT(CASE WHEN status = 'DETECTED' THEN 1 END) as pending_changes,
    MAX(detected_date) as last_change_date,
    MAX(CASE WHEN status = 'HANDLED' THEN handled_date END) as last_handled_date
FROM control.schema_change_log
WHERE detected_date >= DATEADD(DAY, -30, GETDATE())
GROUP BY source_database, table_name;
GO

PRINT 'Schema tracking tables created successfully';
PRINT '- archive_schema_versions: Tracks schema versions per table';
PRINT '- schema_change_log: Audit trail of schema changes';
PRINT '- archive_table_registry: Registry of all archive tables';
PRINT '- v_active_schema_versions: View of active schema versions';
PRINT '- v_schema_change_summary: Summary of recent changes';
