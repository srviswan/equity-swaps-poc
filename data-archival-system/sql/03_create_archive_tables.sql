-- 03_create_archive_tables.sql
-- Create archive database control tables

USE archive_db;
GO

-- Control schema
CREATE SCHEMA control;
GO

-- Disposal queue: rows currently being hard-deleted (exclusion for archive inserts)
CREATE TABLE control.disposal_queue (
    id BIGINT IDENTITY PRIMARY KEY,
    schema_name SYSNAME NOT NULL,
    table_name SYSNAME NOT NULL,
    primary_key_hash VARBINARY(32) NOT NULL,
    primary_key_values NVARCHAR(500) NOT NULL,
    started_at DATETIME DEFAULT GETDATE(),
    status VARCHAR(20) DEFAULT 'IN_PROGRESS', -- IN_PROGRESS | DONE | FAILED
    INDEX ix_disposal_lookup (schema_name, table_name, primary_key_hash)
);

-- Quarantine for any bad rows found during copy/validation
CREATE TABLE control.quarantine (
    id BIGINT IDENTITY PRIMARY KEY,
    schema_name SYSNAME NOT NULL,
    table_name SYSNAME NOT NULL,
    batch_id UNIQUEIDENTIFIER NOT NULL,
    reason NVARCHAR(4000) NOT NULL,
    primary_key_values NVARCHAR(500) NULL,
    payload VARBINARY(MAX) NULL,
    created_at DATETIME DEFAULT GETDATE()
);

-- Merge audit to verify idempotency and actions
CREATE TABLE control.merge_audit (
    id BIGINT IDENTITY PRIMARY KEY,
    batch_id UNIQUEIDENTIFIER NOT NULL,
    schema_name SYSNAME NOT NULL,
    table_name SYSNAME NOT NULL,
    action_taken VARCHAR(20) NOT NULL, -- INSERTED | SKIPPED
    records INT NOT NULL,
    created_at DATETIME DEFAULT GETDATE()
);

-- Hold registry for disposal holds
CREATE TABLE control.hold (
    hold_id BIGINT IDENTITY PRIMARY KEY,
    schema_name SYSNAME NOT NULL,
    table_name SYSNAME NOT NULL,
    scope_type VARCHAR(20) NOT NULL,  -- 'CONTRACT' | 'PK'
    contractId UNIQUEIDENTIFIER NULL,
    primary_key_hash VARBINARY(32) NULL,
    primary_key_values NVARCHAR(500) NULL,
    reason NVARCHAR(2000) NOT NULL,
    placed_by SYSNAME NOT NULL,
    placed_at DATETIME DEFAULT GETDATE(),
    hold_until DATETIME NULL,
    active BIT DEFAULT 1,
    INDEX ix_hold_lookup (schema_name, table_name, scope_type, contractId, primary_key_hash) INCLUDE (active)
);

-- Hold audit
CREATE TABLE control.hold_audit (
    id BIGINT IDENTITY PRIMARY KEY,
    action VARCHAR(20) NOT NULL, -- PLACED | DEACTIVATED | EXPIRED
    hold_id BIGINT NOT NULL,
    actor SYSNAME NOT NULL,
    at DATETIME DEFAULT GETDATE(),
    details NVARCHAR(2000) NULL
);

PRINT 'Archive control tables created successfully';
