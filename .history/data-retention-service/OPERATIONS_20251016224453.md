# Data Retention Service - Operations Guide

## Overview

This guide provides comprehensive operational procedures for the Data Retention Service, including monitoring, recovery, troubleshooting, and maintenance tasks.

## Table of Contents

1. [System Monitoring](#system-monitoring)
2. [Recovery Procedures](#recovery-procedures)
3. [Troubleshooting](#troubleshooting)
4. [Maintenance Tasks](#maintenance-tasks)
5. [Performance Tuning](#performance-tuning)
6. [Security Considerations](#security-considerations)
7. [Backup and Restore](#backup-and-restore)

## System Monitoring

### Health Checks

#### Basic Health Check
```bash
# Check system status
python3 orchestrator.py --status

# Check running executions
python3 orchestrator.py --monitor
```

#### Database Health Check
```sql
-- Validate system prerequisites
EXEC control_db.control.sp_Validate_System_Prerequisites

-- Show system health metrics
EXEC control_db.control.sp_Show_System_Health

-- Monitor running executions
EXEC control_db.control.sp_Monitor_Executions
```

### Key Metrics to Monitor

#### Performance Metrics
- **Throughput**: Records processed per second
- **Latency**: Time to complete operations
- **Error Rate**: Percentage of failed operations
- **Queue Size**: Number of pending operations

#### Storage Metrics
- **Archive Database Size**: Total size of archived data
- **Retention Compliance**: Records past retention period
- **Partition Health**: Partition alignment and performance

#### System Metrics
- **Execution Status**: Running, failed, or completed operations
- **Error Count**: Number of retry attempts
- **Heartbeat**: Last activity timestamp

### Monitoring Queries

#### Check Archive Database Status
```sql
USE archive_db;
SELECT 
    s.name as schema_name,
    t.name as table_name,
    SUM(p.rows) as record_count,
    SUM(au.total_pages) * 8.0 / 1024.0 as size_mb
FROM sys.tables t
JOIN sys.schemas s ON t.schema_id = s.schema_id
JOIN sys.partitions p ON t.object_id = p.object_id
JOIN sys.allocation_units au ON p.partition_id = au.container_id
WHERE p.index_id IN (0,1)
GROUP BY s.name, t.name
ORDER BY size_mb DESC;
```

#### Check Recent Executions
```sql
SELECT TOP 20
    execution_id,
    workflow_type,
    source_database,
    table_name,
    current_phase,
    execution_status,
    DATEDIFF(MINUTE, started_at, GETDATE()) as running_minutes,
    error_count,
    last_error
FROM control.archival_execution_state
WHERE started_at >= DATEADD(DAY, -1, GETDATE())
ORDER BY started_at DESC;
```

#### Check Performance Metrics
```sql
SELECT 
    metric_type,
    metric_name,
    AVG(metric_value) as avg_value,
    MAX(metric_value) as max_value,
    metric_unit
FROM control.archival_metrics
WHERE metric_timestamp >= DATEADD(HOUR, -1, GETDATE())
GROUP BY metric_type, metric_name, metric_unit
ORDER BY metric_type, metric_name;
```

## Recovery Procedures

### Automatic Recovery

The system includes automatic recovery capabilities:

#### Resume Failed Executions
```bash
# Automatically resume failed executions
python3 orchestrator.py --resume
```

#### Manual Recovery
```sql
-- Resume failed executions manually
EXEC control_db.control.sp_Resume_Failed_Executions
```

### Manual Recovery Steps

#### 1. Identify Failed Operations
```sql
SELECT 
    execution_id,
    batch_id,
    workflow_type,
    source_database,
    table_name,
    current_phase,
    execution_status,
    error_count,
    last_error,
    can_resume
FROM control.archival_execution_state
WHERE execution_status = 'FAILED'
ORDER BY started_at DESC;
```

#### 2. Check Error Details
```sql
SELECT 
    log_id,
    batch_id,
    operation,
    source_database,
    table_name,
    records_affected,
    status,
    error_message,
    execution_start,
    execution_end
FROM control.archival_execution_log
WHERE status = 'FAILED'
  AND execution_start >= DATEADD(DAY, -1, GETDATE())
ORDER BY execution_start DESC;
```

#### 3. Resume Specific Execution
```sql
-- Resume specific execution by ID
DECLARE @execution_id UNIQUEIDENTIFIER = 'your-execution-id-here';
DECLARE @batch_id UNIQUEIDENTIFIER;

SELECT @batch_id = batch_id
FROM control.archival_execution_state
WHERE execution_id = @execution_id;

-- Reset status and resume
UPDATE control.archival_execution_state
SET execution_status = 'RUNNING',
    error_count = error_count + 1,
    last_heartbeat = GETDATE()
WHERE execution_id = @execution_id;

-- Re-execute workflow
EXEC control.sp_Execute_Complete_Archival_With_Resume @batch_id, @execution_id;
```

### Recovery Scenarios

#### Scenario 1: Partition Switch Failure
**Symptoms**: `PARTITION_SWITCH_FAILED` in execution log
**Recovery**:
1. Check partition alignment
2. Verify staging table exists
3. Use bulk copy fallback

```sql
-- Check partition alignment
EXEC control.sp_Validate_Partition_Alignment 'SourceDB1', 'Position'

-- Check staging table
SELECT name FROM SourceDB1.sys.tables WHERE name LIKE '%Staging%'
```

#### Scenario 2: Data Movement Failure
**Symptoms**: `MOVE_TO_ARCHIVE_FAILED` in execution log
**Recovery**:
1. Check archive database space
2. Verify archive table structure
3. Retry with different strategy

```sql
-- Check archive database space
SELECT 
    name,
    size * 8.0 / 1024.0 as size_mb,
    max_size * 8.0 / 1024.0 as max_size_mb
FROM archive_db.sys.database_files;

-- Check archive table structure
EXEC control.sp_Show_Partition_Info 'archive_db', 'YourTable'
```

#### Scenario 3: Disposal Failure
**Symptoms**: `DISPOSAL_FAILED` in execution log
**Recovery**:
1. Check compliance holds
2. Verify retention policies
3. Manual cleanup if needed

```sql
-- Check compliance holds
SELECT 
    disposal_id,
    archive_schema,
    archive_table,
    compliance_hold,
    compliance_reason,
    operation_status
FROM control.archive_disposal_tracking
WHERE operation_status = 'FAILED';

-- Check retention policies
SELECT 
    source_database,
    table_name,
    retention_years_in_archive,
    disposal_enabled,
    disposal_method
FROM control.archival_table_list
WHERE disposal_enabled = 1;
```

## Troubleshooting

### Common Issues

#### Issue 1: "SETUP REQUIRED" Error
**Cause**: Control database not initialized
**Solution**:
```bash
# Initialize control database
./init_control_db.sh
```

#### Issue 2: "SQL Server not responding"
**Cause**: Container not running or not ready
**Solution**:
```bash
# Check container status
docker ps | grep archival-sqlserver-v2

# Start container if needed
./start.sh

# Check container logs
docker logs archival-sqlserver-v2
```

#### Issue 3: "No tables configured for archival"
**Cause**: No entries in archival_table_list
**Solution**:
```sql
-- Add table configuration
INSERT INTO control.archival_table_list (
    source_database, table_name, archival_enabled,
    months_before_archival, retention_years_in_archive,
    disposal_enabled, archive_db_schema, archive_db_table
) VALUES (
    'YourDB', 'YourTable', 1,
    3, 7, 1, 'YourDB', 'YourTable_Archive'
);
```

#### Issue 4: "Partition function not found"
**Cause**: Table not partitioned or partition function missing
**Solution**:
```sql
-- Check if table is partitioned
EXEC control.sp_Detect_Partition_Info 'YourDB', 'YourTable'

-- Create partition function if needed
CREATE PARTITION FUNCTION PF_YourTable_ArchivalFlag (BIT)
AS RANGE LEFT FOR VALUES (0);

CREATE PARTITION SCHEME PS_YourTable_ArchivalFlag
AS PARTITION PF_YourTable_ArchivalFlag
TO ([PRIMARY], [PRIMARY]);
```

### Performance Issues

#### Issue 1: Slow Data Movement
**Symptoms**: Low throughput, long execution times
**Solutions**:
1. Check data size and choose appropriate strategy
2. Verify table hints are being used
3. Check for blocking locks

```sql
-- Check blocking locks
SELECT 
    session_id,
    blocking_session_id,
    wait_type,
    wait_time,
    resource_description
FROM sys.dm_exec_requests
WHERE blocking_session_id > 0;
```

#### Issue 2: High Memory Usage
**Symptoms**: Memory pressure, slow performance
**Solutions**:
1. Reduce batch sizes
2. Use partition switching instead of bulk operations
3. Monitor tempdb usage

```sql
-- Check tempdb usage
SELECT 
    session_id,
    request_id,
    task_alloc_pages,
    task_dealloc_pages
FROM sys.dm_db_task_space_usage
WHERE session_id > 50;
```

### Log Analysis

#### Check Execution Logs
```sql
-- Recent executions with errors
SELECT TOP 20
    log_id,
    batch_id,
    operation,
    source_database,
    table_name,
    records_affected,
    status,
    error_message,
    execution_start,
    DATEDIFF(SECOND, execution_start, execution_end) as duration_seconds
FROM control.archival_execution_log
WHERE execution_start >= DATEADD(DAY, -1, GETDATE())
ORDER BY execution_start DESC;
```

#### Check Performance Metrics
```sql
-- Performance trends
SELECT 
    CAST(metric_timestamp AS DATE) as date,
    metric_name,
    AVG(metric_value) as avg_value,
    MAX(metric_value) as max_value,
    COUNT(*) as sample_count
FROM control.archival_metrics
WHERE metric_timestamp >= DATEADD(DAY, -7, GETDATE())
GROUP BY CAST(metric_timestamp AS DATE), metric_name
ORDER BY date DESC, metric_name;
```

## Maintenance Tasks

### Daily Tasks

#### 1. Check System Health
```bash
# Run health check
python3 orchestrator.py --status

# Check for failed executions
python3 orchestrator.py --monitor
```

#### 2. Review Execution Logs
```sql
-- Check for errors in last 24 hours
SELECT COUNT(*) as error_count
FROM control.archival_execution_log
WHERE status = 'FAILED'
  AND execution_start >= DATEADD(DAY, -1, GETDATE());
```

### Weekly Tasks

#### 1. Clean Up Old Data
```sql
-- Clean up old execution data (keep 30 days)
EXEC control.sp_Cleanup_Old_Data @days_to_keep = 30;
```

#### 2. Review Performance Metrics
```sql
-- Weekly performance summary
SELECT 
    metric_name,
    AVG(metric_value) as avg_value,
    MAX(metric_value) as max_value,
    MIN(metric_value) as min_value
FROM control.archival_metrics
WHERE metric_timestamp >= DATEADD(DAY, -7, GETDATE())
GROUP BY metric_name
ORDER BY metric_name;
```

### Monthly Tasks

#### 1. Review Retention Policies
```sql
-- Check tables approaching retention limit
SELECT 
    source_database,
    table_name,
    retention_years_in_archive,
    last_disposal,
    DATEDIFF(MONTH, last_disposal, GETDATE()) as months_since_disposal
FROM control.archival_table_list
WHERE disposal_enabled = 1
ORDER BY months_since_disposal DESC;
```

#### 2. Archive Database Maintenance
```sql
-- Check archive database size
SELECT 
    DB_NAME() as database_name,
    SUM(size * 8.0 / 1024.0) as total_size_mb
FROM sys.database_files;

-- Update statistics
EXEC sp_updatestats;
```

## Performance Tuning

### Optimization Strategies

#### 1. Partition Switching
- Use for large datasets (>1M records)
- Requires proper partition alignment
- Provides instant data movement

#### 2. Batch Operations
- Use appropriate batch sizes (10K-50K records)
- Monitor memory usage
- Use table hints for performance

#### 3. Index Optimization
```sql
-- Check index usage
SELECT 
    object_name(object_id) as table_name,
    index_id,
    user_seeks,
    user_scans,
    user_lookups,
    user_updates
FROM sys.dm_db_index_usage_stats
WHERE database_id = DB_ID('control_db')
ORDER BY user_seeks + user_scans + user_lookups DESC;
```

### Configuration Tuning

#### 1. Batch Sizes
- **Small datasets** (<100K records): Use INSERT SELECT
- **Medium datasets** (100K-1M records): Use BULK INSERT with 50K batch size
- **Large datasets** (>1M records): Use BCP or partition switching

#### 2. Memory Settings
```sql
-- Check memory configuration
SELECT 
    name,
    value,
    value_in_use,
    description
FROM sys.configurations
WHERE name IN (
    'max server memory (MB)',
    'min server memory (MB)',
    'max worker threads'
);
```

## Security Considerations

### Access Control

#### 1. Database Permissions
```sql
-- Create dedicated service account
CREATE LOGIN [archival_service] WITH PASSWORD = 'StrongPassword123!';

-- Grant necessary permissions
USE control_db;
CREATE USER [archival_service] FOR LOGIN [archival_service];
ALTER ROLE db_datareader ADD MEMBER [archival_service];
ALTER ROLE db_datawriter ADD MEMBER [archival_service];

USE archive_db;
CREATE USER [archival_service] FOR LOGIN [archival_service];
ALTER ROLE db_datareader ADD MEMBER [archival_service];
ALTER ROLE db_datawriter ADD MEMBER [archival_service];
```

#### 2. Audit Logging
```sql
-- Enable audit logging
CREATE SERVER AUDIT [DataRetentionAudit]
TO FILE (FILEPATH = '/var/opt/mssql/audit/');

ALTER SERVER AUDIT [DataRetentionAudit] WITH (STATE = ON);

-- Audit data modifications
CREATE DATABASE AUDIT SPECIFICATION [DataRetentionDBSpec]
FOR SERVER AUDIT [DataRetentionAudit]
ADD (INSERT, UPDATE, DELETE ON control.archival_table_list BY public);
```

### Data Protection

#### 1. Encryption
```sql
-- Enable TDE for archive database
USE archive_db;
CREATE DATABASE ENCRYPTION KEY
WITH ALGORITHM = AES_256
ENCRYPTION BY SERVER CERTIFICATE [DataRetentionCert];

ALTER DATABASE archive_db SET ENCRYPTION ON;
```

#### 2. Compliance Holds
```sql
-- Set compliance hold
EXEC control.sp_Set_Compliance_Hold 
    @archive_schema = 'dbo',
    @archive_table = 'YourTable',
    @hold_enabled = 1,
    @compliance_reason = 'Legal hold for litigation',
    @approved_by = 'Legal Department';
```

## Backup and Restore

### Backup Strategy

#### 1. Control Database
```sql
-- Full backup
BACKUP DATABASE control_db
TO DISK = '/var/opt/mssql/backup/control_db_full.bak'
WITH FORMAT, INIT, COMPRESSION;

-- Transaction log backup
BACKUP LOG control_db
TO DISK = '/var/opt/mssql/backup/control_db_log.trn'
WITH FORMAT, INIT, COMPRESSION;
```

#### 2. Archive Database
```sql
-- Full backup
BACKUP DATABASE archive_db
TO DISK = '/var/opt/mssql/backup/archive_db_full.bak'
WITH FORMAT, INIT, COMPRESSION;
```

### Restore Procedures

#### 1. Restore Control Database
```sql
-- Restore control database
RESTORE DATABASE control_db
FROM DISK = '/var/opt/mssql/backup/control_db_full.bak'
WITH REPLACE, RECOVERY;
```

#### 2. Restore Archive Database
```sql
-- Restore archive database
RESTORE DATABASE archive_db
FROM DISK = '/var/opt/mssql/backup/archive_db_full.bak'
WITH REPLACE, RECOVERY;
```

### Disaster Recovery

#### 1. Recovery Time Objective (RTO)
- **Control Database**: 15 minutes
- **Archive Database**: 30 minutes
- **Complete System**: 45 minutes

#### 2. Recovery Point Objective (RPO)
- **Control Database**: 1 hour
- **Archive Database**: 4 hours
- **Complete System**: 4 hours

#### 3. Recovery Procedures
1. Restore control database
2. Restore archive database
3. Validate system prerequisites
4. Resume failed executions
5. Verify data integrity

---

## Emergency Contacts

- **System Administrator**: [Contact Information]
- **Database Administrator**: [Contact Information]
- **Legal/Compliance**: [Contact Information]
- **On-Call Support**: [Contact Information]

## Escalation Procedures

1. **Level 1**: Check logs and basic troubleshooting
2. **Level 2**: Engage system administrator
3. **Level 3**: Engage database administrator
4. **Level 4**: Engage vendor support
5. **Level 5**: Engage legal/compliance team

---

*Last Updated: [Current Date]*
*Version: 1.0*
