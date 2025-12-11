# Filegroup Implementation Guide

## Overview

This guide provides step-by-step instructions for implementing the filegroup-based archival system with maintenance plans and database portability features.

## Implementation Phases

### Phase 1: Filegroup Setup

#### 1.1 Create Filegroups

```sql
-- For each source database (SourceDB1, SourceDB2, SourceDB3)
USE SourceDB1;
GO

-- Add ARCHIVE_FG filegroup
ALTER DATABASE SourceDB1 ADD FILEGROUP ARCHIVE_FG;

-- Add files to ARCHIVE_FG
ALTER DATABASE SourceDB1 ADD FILE 
(
    NAME = SourceDB1_Archive1,
    FILENAME = 'E:\ArchiveData\SourceDB1_Archive1.ndf',
    SIZE = 1TB,
    MAXSIZE = UNLIMITED,
    FILEGROWTH = 100GB
) TO FILEGROUP ARCHIVE_FG;

ALTER DATABASE SourceDB1 ADD FILE 
(
    NAME = SourceDB1_Archive2,
    FILENAME = 'E:\ArchiveData\SourceDB1_Archive2.ndf',
    SIZE = 1TB,
    MAXSIZE = UNLIMITED,
    FILEGROWTH = 100GB
) TO FILEGROUP ARCHIVE_FG;
```

#### 1.2 Configure Archive Database Filegroups

```sql
-- For archive_db
USE archive_db;
GO

-- Ensure PRIMARY filegroup is on cheap storage
-- Move existing data files to appropriate storage tier
ALTER DATABASE archive_db MODIFY FILE 
(
    NAME = archive_db,
    FILENAME = 'F:\CheapStorage\archive_db.mdf'
);
```

### Phase 2: Maintenance Scripts Installation

#### 2.1 Install Maintenance Procedures

Execute the following SQL scripts in order:

1. `21_create_database_topology_tables.sql`
2. `22_archive_db_migration_procedures.sql`
3. `23_update_dynamic_views_portable.sql`
4. `24_filegroup_maintenance_scripts.sql`
5. `25_monitoring_and_alerts.sql`

#### 2.2 Create Maintenance Jobs

```sql
-- Daily maintenance job for PRIMARY filegroup
EXEC msdb.dbo.sp_add_job
    @job_name = 'Daily Maintenance - PRIMARY',
    @enabled = 1,
    @description = 'Daily maintenance for PRIMARY filegroup';

EXEC msdb.dbo.sp_add_jobstep
    @job_name = 'Daily Maintenance - PRIMARY',
    @step_name = 'Run Daily Maintenance',
    @command = 'EXEC control_db.control.sp_Daily_Maintenance_PRIMARY',
    @database_name = 'control_db';

-- Schedule for 12:00 AM daily
EXEC msdb.dbo.sp_add_schedule
    @schedule_name = 'Daily Maintenance Schedule',
    @freq_type = 4,
    @freq_interval = 1,
    @active_start_time = 0;

EXEC msdb.dbo.sp_attach_schedule
    @job_name = 'Daily Maintenance - PRIMARY',
    @schedule_name = 'Daily Maintenance Schedule';
```

### Phase 3: Monitoring Setup

#### 3.1 Configure Alerts

```sql
-- Filegroup space alert
EXEC msdb.dbo.sp_add_alert 
    @name = 'Filegroup Space Critical',
    @message_id = 0,
    @severity = 0,
    @enabled = 1,
    @delay_between_responses = 300;

-- Index fragmentation alert
EXEC msdb.dbo.sp_add_alert 
    @name = 'Index Fragmentation Critical',
    @message_id = 0,
    @severity = 0,
    @enabled = 1,
    @delay_between_responses = 300;
```

#### 3.2 Create Monitoring Dashboard

```sql
-- Run comprehensive monitoring report
EXEC control_db.control.sp_Comprehensive_Monitoring_Report;
```

### Phase 4: Testing and Validation

#### 4.1 Test Filegroup Operations

```sql
-- Test filegroup size monitoring
EXEC control_db.control.sp_Monitor_Filegroup_Sizes;

-- Test index fragmentation monitoring
EXEC control_db.control.sp_Monitor_Index_Fragmentation;

-- Test maintenance procedures
EXEC control_db.control.sp_Daily_Maintenance_PRIMARY;
```

#### 4.2 Validate Maintenance Jobs

```sql
-- Check job status
SELECT 
    j.name AS JobName,
    j.enabled,
    j.date_created,
    j.date_modified
FROM msdb.dbo.sysjobs j
WHERE j.name LIKE '%Maintenance%';

-- Check job history
SELECT 
    j.name AS JobName,
    h.step_name,
    h.run_date,
    h.run_time,
    h.run_duration,
    h.run_status
FROM msdb.dbo.sysjobs j
JOIN msdb.dbo.sysjobhistory h ON j.job_id = h.job_id
WHERE j.name LIKE '%Maintenance%'
ORDER BY h.run_date DESC, h.run_time DESC;
```

### Phase 5: Database Portability Setup

#### 5.1 Configure Topology

```sql
-- Initialize database topology
INSERT INTO control_db.control.database_topology 
(database_type, database_name, server_name, is_local, active)
VALUES 
('SOURCE', 'SourceDB1', @@SERVERNAME, 1, 1),
('SOURCE', 'SourceDB2', @@SERVERNAME, 1, 1),
('SOURCE', 'SourceDB3', @@SERVERNAME, 1, 1),
('ARCHIVE', 'archive_db', @@SERVERNAME, 1, 1),
('CONTROL', 'control_db', @@SERVERNAME, 1, 1);
```

#### 5.2 Test Migration Procedures

```sql
-- Test migration in test mode
EXEC control_db.control.sp_Migrate_Archive_Database
    @target_server = 'TestServer',
    @target_linked_server = 'TestServer_Link',
    @test_mode = 1;
```

## Configuration Parameters

### Filegroup Sizing Guidelines

| Database Size | PRIMARY Size | ARCHIVE_FG Size | Archive_DB Size |
|---------------|--------------|-----------------|-----------------|
| 1TB | 100GB | 200GB | 700GB |
| 10TB | 1TB | 2TB | 7TB |
| 30TB | 3TB | 6TB | 21TB |
| 100TB | 10TB | 20TB | 70TB |

### Maintenance Windows

| Task | Frequency | Duration | Window |
|------|-----------|----------|--------|
| Daily Maintenance | Daily | 2-4 hours | 12:00 AM - 4:00 AM |
| Weekly Maintenance | Weekly | 6-10 hours | Saturday 10:00 PM - Sunday 6:00 AM |
| Monthly Maintenance | Monthly | 18-32 hours | First Sunday |

### Alert Thresholds

| Metric | Warning | Critical |
|--------|---------|----------|
| Filegroup Space | 80% | 90% |
| Index Fragmentation | 30% | 50% |
| Backup Age (PRIMARY) | 25 hours | 26 hours |
| Backup Age (ARCHIVE_FG) | 7 days | 8 days |

## Troubleshooting Guide

### Common Issues

#### 1. Filegroup Creation Failure

**Error**: Cannot add file to filegroup
**Solution**: 
- Verify disk space availability
- Check file path permissions
- Ensure filegroup doesn't already exist

#### 2. Maintenance Job Failure

**Error**: Maintenance job fails with timeout
**Solution**:
- Reduce MAXDOP for index rebuilds
- Increase job timeout settings
- Check for blocking processes

#### 3. Monitoring Alert False Positives

**Error**: Alerts firing too frequently
**Solution**:
- Adjust alert thresholds
- Increase delay between responses
- Review monitoring query logic

### Performance Optimization

#### 1. Index Maintenance Optimization

```sql
-- Use ONLINE rebuilds to reduce blocking
ALTER INDEX IX_Position_Clustered ON dbo.Position
REBUILD WITH (ONLINE = ON, MAXDOP = 4);

-- Use SORT_IN_TEMPDB for better performance
ALTER INDEX IX_Position_Clustered ON dbo.Position
REBUILD WITH (SORT_IN_TEMPDB = ON, MAXDOP = 8);
```

#### 2. Backup Optimization

```sql
-- Use compression for faster backups
BACKUP DATABASE SourceDB1
FILEGROUP = 'PRIMARY'
TO DISK = 'D:\Backups\SourceDB1_Primary.bak'
WITH COMPRESSION, CHECKSUM, STATS = 10;

-- Use multiple backup devices for parallel I/O
BACKUP DATABASE SourceDB1
FILEGROUP = 'ARCHIVE_FG'
TO DISK = 'E:\Backups\SourceDB1_Archive1.bak',
    DISK = 'E:\Backups\SourceDB1_Archive2.bak'
WITH COMPRESSION, CHECKSUM;
```

## Maintenance Procedures

### Daily Maintenance Checklist

- [ ] Check job execution status
- [ ] Review alert notifications
- [ ] Monitor filegroup space usage
- [ ] Verify backup completion
- [ ] Check index fragmentation levels

### Weekly Maintenance Checklist

- [ ] Run comprehensive monitoring report
- [ ] Review maintenance history
- [ ] Check archive cleanup status
- [ ] Validate backup integrity
- [ ] Update maintenance statistics

### Monthly Maintenance Checklist

- [ ] Review capacity planning projections
- [ ] Analyze performance trends
- [ ] Update maintenance procedures
- [ ] Test disaster recovery procedures
- [ ] Review alert configurations

## Security Considerations

### Access Control

```sql
-- Grant permissions for maintenance operations
GRANT EXECUTE ON control.sp_Daily_Maintenance_PRIMARY TO [MaintenanceUser];
GRANT EXECUTE ON control.sp_Weekly_Maintenance_ARCHIVE_FG TO [MaintenanceUser];
GRANT SELECT ON control.vw_Filegroup_Monitoring TO [MonitoringUser];
```

### Audit Trail

```sql
-- Enable audit for maintenance operations
CREATE SERVER AUDIT MaintenanceAudit
TO FILE (FILEPATH = 'D:\Audits\Maintenance\');

CREATE DATABASE AUDIT SPECIFICATION MaintenanceAuditSpec
FOR SERVER AUDIT MaintenanceAudit
ADD (EXECUTE ON control.sp_Daily_Maintenance_PRIMARY),
ADD (EXECUTE ON control.sp_Weekly_Maintenance_ARCHIVE_FG);

ALTER SERVER AUDIT MaintenanceAudit WITH (STATE = ON);
ALTER DATABASE AUDIT SPECIFICATION MaintenanceAuditSpec WITH (STATE = ON);
```

## Backup and Recovery

### Backup Strategy

1. **PRIMARY Filegroup**: Daily full backup + hourly log backup
2. **ARCHIVE_FG Filegroup**: Weekly full backup + daily differential
3. **Archive_DB**: Monthly full backup + weekly differential

### Recovery Procedures

```sql
-- Restore PRIMARY filegroup
RESTORE DATABASE SourceDB1
FILEGROUP = 'PRIMARY'
FROM DISK = 'D:\Backups\SourceDB1_Primary.bak'
WITH NORECOVERY;

-- Restore transaction logs
RESTORE LOG SourceDB1
FROM DISK = 'D:\Backups\SourceDB1_Log.trn'
WITH NORECOVERY;

-- Complete recovery
RESTORE DATABASE SourceDB1 WITH RECOVERY;
```

## Performance Monitoring

### Key Performance Indicators

1. **Filegroup Space Utilization**: Target < 80%
2. **Index Fragmentation**: Target < 10%
3. **Backup Duration**: Target < 2 hours for PRIMARY
4. **Maintenance Window**: Target < 4 hours daily

### Monitoring Queries

```sql
-- Filegroup performance monitoring
SELECT 
    fg.name AS FileGroupName,
    SUM(f.size * 8 / 1024 / 1024) AS SizeGB,
    SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024 / 1024) AS UsedGB,
    CAST((SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024 / 1024) * 100.0) / 
         (SUM(f.size * 8 / 1024 / 1024)) AS DECIMAL(5,2)) AS PercentUsed
FROM sys.filegroups fg
JOIN sys.database_files f ON fg.data_space_id = f.data_space_id
GROUP BY fg.name
ORDER BY PercentUsed DESC;

-- Maintenance history analysis
SELECT 
    maintenance_type,
    filegroup_name,
    AVG(duration_minutes) AS AvgDuration,
    COUNT(*) AS ExecutionCount,
    SUM(CASE WHEN status = 'SUCCESS' THEN 1 ELSE 0 END) * 100.0 / COUNT(*) AS SuccessRate
FROM control.maintenance_history
WHERE start_time >= DATEADD(month, -1, GETDATE())
GROUP BY maintenance_type, filegroup_name
ORDER BY maintenance_type, filegroup_name;
```

## Success Criteria

### Technical Validation

- [ ] All filegroups created successfully
- [ ] Maintenance jobs running without errors
- [ ] Monitoring alerts configured and tested
- [ ] Backup procedures validated
- [ ] Performance within acceptable limits

### Business Validation

- [ ] Maintenance windows respected
- [ ] No impact on active operations
- [ ] Archive queries performing adequately
- [ ] Disaster recovery procedures tested
- [ ] Documentation complete and current

## Support and Maintenance

### Regular Tasks

1. **Weekly**: Review monitoring reports
2. **Monthly**: Analyze performance trends
3. **Quarterly**: Update capacity planning
4. **Annually**: Review and update procedures

### Emergency Contacts

- **Database Administrator**: [Contact Info]
- **System Administrator**: [Contact Info]
- **Storage Administrator**: [Contact Info]
- **Network Administrator**: [Contact Info]

### Documentation Updates

- Update this guide quarterly
- Review and update procedures annually
- Maintain change log for all modifications
- Keep emergency procedures current
