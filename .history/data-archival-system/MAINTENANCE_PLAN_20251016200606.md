# Maintenance Plan for Filegroup-Based Archival System

## Overview

Filegroup-specific maintenance strategies to optimize performance while minimizing impact on active operations.

## Daily Maintenance Schedule

### Window: 12:00 AM - 4:00 AM (4 hours)

#### Phase 1: Active Data Maintenance (PRIMARY Filegroup Only)
Duration: 1-2 hours

```sql
-- Index maintenance for PRIMARY filegroup only
DECLARE @TableName NVARCHAR(128);
DECLARE @IndexName NVARCHAR(128);
DECLARE @Fragmentation FLOAT;

-- Only rebuild indexes on PRIMARY filegroup
SELECT 
    t.name AS TableName,
    i.name AS IndexName,
    ps.avg_fragmentation_in_percent
FROM sys.dm_db_index_physical_stats(DB_ID(), NULL, NULL, NULL, 'LIMITED') ps
JOIN sys.tables t ON ps.object_id = t.object_id
JOIN sys.indexes i ON ps.object_id = i.object_id AND ps.index_id = i.index_id
JOIN sys.data_spaces ds ON i.data_space_id = ds.data_space_id
WHERE ds.name = 'PRIMARY'  -- Only PRIMARY filegroup
  AND ps.avg_fragmentation_in_percent > 10
  AND i.type_desc != 'HEAP'
ORDER BY ps.avg_fragmentation_in_percent DESC;

-- Rebuild with ONLINE=ON to minimize blocking
DECLARE index_cursor CURSOR FOR
SELECT TableName, IndexName FROM #IndexesToRebuild;

OPEN index_cursor;
FETCH NEXT FROM index_cursor INTO @TableName, @IndexName;

WHILE @@FETCH_STATUS = 0
BEGIN
    EXEC('ALTER INDEX ' + @IndexName + ' ON ' + @TableName + 
         ' REBUILD WITH (ONLINE = ON, MAXDOP = 4)');
    FETCH NEXT FROM index_cursor INTO @TableName, @IndexName;
END
```

#### Phase 2: Statistics Update (PRIMARY Filegroup)
Duration: 30 minutes

```sql
-- Update statistics for PRIMARY filegroup tables only
EXEC sp_MSforeachtable 
'UPDATE STATISTICS ? WITH FULLSCAN',
'? IN (SELECT name FROM sys.tables WHERE data_space_id = 
    (SELECT data_space_id FROM sys.data_spaces WHERE name = ''PRIMARY''))';
```

#### Phase 3: Consistency Check (PRIMARY Filegroup)
Duration: 30-60 minutes

```sql
-- Check PRIMARY filegroup only
DBCC CHECKDB (SourceDB1, FILEGROUP = 'PRIMARY') 
WITH NO_INFOMSGS, ALL_ERRORMSGS;
```

#### Phase 4: Backup (PRIMARY Filegroup)
Duration: 30-60 minutes

```sql
-- Daily full backup of PRIMARY filegroup
BACKUP DATABASE SourceDB1
FILEGROUP = 'PRIMARY'
TO DISK = 'D:\Backups\SourceDB1_Primary_Full.bak'
WITH COMPRESSION, CHECKSUM, STATS = 10;
```

Total Duration: 2.5-4 hours (fits in 4-hour window!)

## Weekly Maintenance Schedule

### Saturday Night: 10:00 PM - 6:00 AM (8 hours)

#### Extended Maintenance Tasks

##### Week 1: Archive Filegroup Maintenance
```sql
-- Rebuild indexes on ARCHIVE_FG (once per month)
ALTER INDEX ALL ON archive.Position_20250116 REBUILD
WITH (ONLINE = ON, MAXDOP = 8, SORT_IN_TEMPDB = ON);

-- Update statistics for archived tables
UPDATE STATISTICS archive.Position_20250116 WITH FULLSCAN;

-- Consistency check for ARCHIVE_FG
DBCC CHECKDB (SourceDB1, FILEGROUP = 'ARCHIVE_FG')
WITH NO_INFOMSGS;

-- Differential backup of ARCHIVE_FG
BACKUP DATABASE SourceDB1
FILEGROUP = 'ARCHIVE_FG'
TO DISK = 'E:\Backups\SourceDB1_Archive_Diff.bak'
WITH DIFFERENTIAL, COMPRESSION;
```

##### Week 2-4: Archive Cleanup and Optimization
```sql
-- Move old archives to archive_db
EXEC control_db.control.sp_Cleanup_Old_Archives 3, 1000000;

-- Shrink ARCHIVE_FG if needed (after moving data)
DBCC SHRINKFILE (SourceDB1_Archive1, 10);  -- Leave 10% free space
```

## Monthly Maintenance Schedule

### First Sunday: Full Maintenance

#### All Filegroups Full Maintenance
```sql
-- Full consistency check (all filegroups)
DBCC CHECKDB (SourceDB1) WITH NO_INFOMSGS;

-- Rebuild all indexes (all filegroups)
EXEC sp_MSforeachtable 'ALTER INDEX ALL ON ? REBUILD WITH (ONLINE = ON)';

-- Update all statistics
EXEC sp_updatestats;

-- Full backup (all filegroups)
BACKUP DATABASE SourceDB1
TO DISK = 'D:\Backups\SourceDB1_Full.bak'
WITH COMPRESSION, CHECKSUM;
```

## Maintenance Exclusions

### Exclude ARCHIVE_FG from Daily Maintenance Plans

```sql
-- Create maintenance plan that excludes ARCHIVE_FG
USE msdb;
GO

-- Add job to exclude archive filegroup from daily index maintenance
EXEC dbo.sp_add_jobstep
    @job_name = N'Daily Index Maintenance',
    @step_name = N'Rebuild Indexes - PRIMARY Only',
    @command = N'
    -- Only process PRIMARY filegroup
    EXECUTE master.dbo.xp_sqlmaint 
    ''-PlanID [...] -RebuildIndex -FileGroup PRIMARY''
    ';
```

## Backup Strategy by Filegroup

### PRIMARY Filegroup (Active Data)
- Daily: Full backup (1-2 hours)
- Hourly: Transaction log backup (5-10 minutes)
- RPO: 1 hour
- RTO: 2 hours

### ARCHIVE_FG Filegroup (Recent Archives)
- Weekly: Full backup (2-4 hours)
- Daily: Differential backup (30-60 minutes)
- RPO: 24 hours (acceptable for archives)
- RTO: 6 hours

### Archive_DB (Old Archives)
- Monthly: Full backup (8-12 hours)
- Weekly: Differential backup (1-2 hours)
- RPO: 1 week (acceptable for cold storage)
- RTO: 24 hours

## Capacity Planning

### Growth Projections

| Filegroup | Current Size | Monthly Growth | 12-Month Projection |
|-----------|--------------|----------------|---------------------|
| PRIMARY | 3TB | 100GB | 4.2TB |
| ARCHIVE_FG | 6TB | 200GB | 8.4TB |
| archive_db | 21TB | 150GB | 22.8TB |

### Storage Cost Comparison

| Scenario | Storage Strategy | Annual Cost |
|----------|-----------------|-------------|
| All on Fast SSD | 30TB x $500/TB | $15,000 |
| Filegroup Strategy | 3TB x $500 + 6TB x $200 + 21TB x $50 | $3,200 |
| **Savings** | | **$11,800 (79%)** |

## Monitoring and Alerts

### Key Metrics to Monitor

```sql
-- Monitor filegroup sizes and growth
SELECT 
    fg.name AS FileGroupName,
    SUM(f.size * 8 / 1024 / 1024) AS SizeGB,
    SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024 / 1024) AS UsedGB,
    SUM(f.size * 8 / 1024 / 1024) - SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024 / 1024) AS FreeGB
FROM sys.filegroups fg
JOIN sys.database_files f ON fg.data_space_id = f.data_space_id
GROUP BY fg.name
ORDER BY fg.name;

-- Monitor index fragmentation by filegroup
SELECT 
    ds.name AS FileGroupName,
    t.name AS TableName,
    i.name AS IndexName,
    ps.avg_fragmentation_in_percent,
    ps.page_count
FROM sys.dm_db_index_physical_stats(DB_ID(), NULL, NULL, NULL, 'SAMPLED') ps
JOIN sys.tables t ON ps.object_id = t.object_id
JOIN sys.indexes i ON ps.object_id = i.object_id AND ps.index_id = i.index_id
JOIN sys.data_spaces ds ON i.data_space_id = ds.data_space_id
WHERE ps.avg_fragmentation_in_percent > 30
ORDER BY ps.avg_fragmentation_in_percent DESC;
```

### Alerts Configuration

1. Filegroup > 80% full: Warning
2. Filegroup > 90% full: Critical
3. Index fragmentation > 50% on PRIMARY: Warning
4. Backup older than 25 hours (PRIMARY): Critical
5. Backup older than 8 days (ARCHIVE_FG): Warning

## Performance Tuning Guidelines

### I/O Optimization

1. Multiple files per filegroup for parallel I/O
2. Separate physical disks for each filegroup
3. Use instant file initialization
4. Pre-size files to avoid autogrowth during operations

### Query Optimization for Archived Data

```sql
-- Create filtered statistics for archived partitions
CREATE STATISTICS stat_archive_position_date
ON dbo.Position (businessDate)
WHERE archival_flag = 1
WITH FULLSCAN;

-- Create filtered index for archive queries
CREATE INDEX IX_Position_Archive_Filtered
ON dbo.Position (businessDate, contractId)
WHERE archival_flag = 1;
```

## Maintenance Windows Summary

| Task | Frequency | Duration | Window | Filegroup |
|------|-----------|----------|--------|-----------|
| Index Rebuild | Daily | 1-2h | Night | PRIMARY |
| Stats Update | Daily | 30min | Night | PRIMARY |
| DBCC CHECK | Daily | 30-60min | Night | PRIMARY |
| Full Backup | Daily | 30-60min | Night | PRIMARY |
| Archive Index | Monthly | 4-6h | Weekend | ARCHIVE_FG |
| Archive Backup | Weekly | 2-4h | Weekend | ARCHIVE_FG |
| Full DB Check | Monthly | 12-24h | Weekend | ALL |
| Archive Cleanup | Monthly | 6-8h | Weekend | ALL |

Total Daily Impact: 2.5-4 hours (PRIMARY only)
Total Weekly Impact: 6-10 hours (includes ARCHIVE_FG)
Total Monthly Impact: 18-32 hours (includes full maintenance)

## Automated Maintenance Scripts

### Daily Maintenance Job

```sql
-- Daily maintenance stored procedure
CREATE PROCEDURE sp_Daily_Maintenance_PRIMARY
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @StartTime DATETIME = GETDATE();
    DECLARE @EndTime DATETIME;
    
    PRINT 'Starting daily maintenance for PRIMARY filegroup...';
    
    -- Phase 1: Index maintenance
    EXEC sp_Index_Maintenance_PRIMARY;
    
    -- Phase 2: Statistics update
    EXEC sp_Statistics_Update_PRIMARY;
    
    -- Phase 3: Consistency check
    EXEC sp_Consistency_Check_PRIMARY;
    
    -- Phase 4: Backup
    EXEC sp_Backup_PRIMARY;
    
    SET @EndTime = GETDATE();
    PRINT 'Daily maintenance completed in ' + 
          CAST(DATEDIFF(minute, @StartTime, @EndTime) AS VARCHAR) + ' minutes';
END;
```

### Weekly Maintenance Job

```sql
-- Weekly maintenance stored procedure
CREATE PROCEDURE sp_Weekly_Maintenance_ARCHIVE_FG
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @StartTime DATETIME = GETDATE();
    
    PRINT 'Starting weekly maintenance for ARCHIVE_FG filegroup...';
    
    -- Archive filegroup maintenance
    EXEC sp_Archive_Maintenance;
    
    -- Archive cleanup
    EXEC sp_Archive_Cleanup;
    
    PRINT 'Weekly maintenance completed';
END;
```

## Troubleshooting Guide

### Common Issues

1. **Maintenance Window Exceeded**
   - Reduce MAXDOP for index rebuilds
   - Use ONLINE rebuilds to reduce blocking
   - Split large operations across multiple nights

2. **High I/O During Maintenance**
   - Schedule during off-peak hours
   - Use separate disks for maintenance operations
   - Consider maintenance during low activity periods

3. **Backup Failures**
   - Check disk space availability
   - Verify backup permissions
   - Monitor backup compression ratios

### Performance Monitoring

```sql
-- Monitor maintenance job performance
SELECT 
    job_name,
    step_name,
    run_date,
    run_time,
    run_duration,
    run_status
FROM msdb.dbo.sysjobhistory
WHERE job_name LIKE '%Maintenance%'
ORDER BY run_date DESC, run_time DESC;
```

## Emergency Procedures

### Maintenance Failure Recovery

1. **Index Rebuild Failure**
   - Check disk space and permissions
   - Review error logs for specific issues
   - Consider offline rebuilds for critical indexes

2. **Backup Failure**
   - Verify backup destination availability
   - Check SQL Server service account permissions
   - Review backup compression settings

3. **Consistency Check Failure**
   - Review corruption details
   - Plan repair operations during maintenance window
   - Consider data recovery options

## Maintenance Validation

### Post-Maintenance Checks

```sql
-- Validate maintenance completion
SELECT 
    'Index Fragmentation' AS CheckType,
    COUNT(*) AS TablesChecked,
    AVG(avg_fragmentation_in_percent) AS AvgFragmentation
FROM sys.dm_db_index_physical_stats(DB_ID(), NULL, NULL, NULL, 'LIMITED')
WHERE avg_fragmentation_in_percent > 10

UNION ALL

SELECT 
    'Statistics Age' AS CheckType,
    COUNT(*) AS TablesChecked,
    AVG(DATEDIFF(day, STATS_DATE(object_id, stats_id), GETDATE())) AS AvgAge
FROM sys.stats
WHERE is_auto_created = 0;
```
