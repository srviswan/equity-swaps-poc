-- 25_monitoring_and_alerts.sql
-- Monitoring queries and alert configurations for filegroup maintenance

USE control_db;
GO

-- Create monitoring views for filegroup performance
CREATE VIEW control.vw_Filegroup_Monitoring
AS
SELECT 
    fg.name AS FileGroupName,
    SUM(f.size * 8 / 1024 / 1024) AS SizeGB,
    SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024 / 1024) AS UsedGB,
    SUM(f.size * 8 / 1024 / 1024) - SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024 / 1024) AS FreeGB,
    CAST((SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024 / 1024) * 100.0) / 
         (SUM(f.size * 8 / 1024 / 1024)) AS DECIMAL(5,2)) AS PercentUsed,
    CASE 
        WHEN (SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024 / 1024) * 100.0) / 
             (SUM(f.size * 8 / 1024 / 1024)) > 90 THEN 'CRITICAL'
        WHEN (SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024 / 1024) * 100.0) / 
             (SUM(f.size * 8 / 1024 / 1024)) > 80 THEN 'WARNING'
        ELSE 'OK'
    END AS Status
FROM sys.filegroups fg
JOIN sys.database_files f ON fg.data_space_id = f.data_space_id
GROUP BY fg.name;
GO

-- Create view for index fragmentation monitoring
CREATE VIEW control.vw_Index_Fragmentation_Monitoring
AS
SELECT 
    ds.name AS FileGroupName,
    t.name AS TableName,
    i.name AS IndexName,
    ps.avg_fragmentation_in_percent,
    ps.page_count,
    ps.record_count,
    CASE 
        WHEN ps.avg_fragmentation_in_percent > 50 THEN 'CRITICAL'
        WHEN ps.avg_fragmentation_in_percent > 30 THEN 'WARNING'
        ELSE 'OK'
    END AS Status,
    CASE 
        WHEN ps.avg_fragmentation_in_percent > 30 THEN 'REBUILD'
        WHEN ps.avg_fragmentation_in_percent > 10 THEN 'REORGANIZE'
        ELSE 'NO ACTION'
    END AS RecommendedAction
FROM sys.dm_db_index_physical_stats(DB_ID(), NULL, NULL, NULL, 'SAMPLED') ps
JOIN sys.tables t ON ps.object_id = t.object_id
JOIN sys.indexes i ON ps.object_id = i.object_id AND ps.index_id = i.index_id
JOIN sys.data_spaces ds ON i.data_space_id = ds.data_space_id
WHERE ps.avg_fragmentation_in_percent > 5
  AND i.type_desc != 'HEAP';
GO

-- Create view for backup monitoring
CREATE VIEW control.vw_Backup_Monitoring
AS
SELECT 
    database_name,
    backup_type,
    backup_start_date,
    backup_finish_date,
    DATEDIFF(minute, backup_start_date, backup_finish_date) AS DurationMinutes,
    backup_size / 1024 / 1024 AS BackupSizeMB,
    DATEDIFF(hour, backup_finish_date, GETDATE()) AS HoursSinceBackup,
    CASE 
        WHEN database_name IN ('SourceDB1', 'SourceDB2', 'SourceDB3') 
             AND DATEDIFF(hour, backup_finish_date, GETDATE()) > 25 THEN 'CRITICAL'
        WHEN database_name = 'archive_db' 
             AND DATEDIFF(hour, backup_finish_date, GETDATE()) > 168 THEN 'WARNING'
        ELSE 'OK'
    END AS Status
FROM msdb.dbo.backupset
WHERE backup_finish_date = (
    SELECT MAX(backup_finish_date) 
    FROM msdb.dbo.backupset bs2 
    WHERE bs2.database_name = backupset.database_name
      AND bs2.type = backupset.type
);
GO

-- Create stored procedure for comprehensive monitoring report
CREATE PROCEDURE control.sp_Comprehensive_Monitoring_Report
AS
BEGIN
    SET NOCOUNT ON;
    
    PRINT '========================================';
    PRINT 'COMPREHENSIVE MONITORING REPORT';
    PRINT 'Generated: ' + CONVERT(VARCHAR, GETDATE(), 120);
    PRINT '========================================';
    
    PRINT '';
    PRINT 'FILEGROUP SIZE MONITORING:';
    PRINT '========================';
    SELECT * FROM control.vw_Filegroup_Monitoring
    ORDER BY PercentUsed DESC;
    
    PRINT '';
    PRINT 'INDEX FRAGMENTATION MONITORING:';
    PRINT '==============================';
    SELECT * FROM control.vw_Index_Fragmentation_Monitoring
    WHERE Status IN ('CRITICAL', 'WARNING')
    ORDER BY avg_fragmentation_in_percent DESC;
    
    PRINT '';
    PRINT 'BACKUP MONITORING:';
    PRINT '=================';
    SELECT * FROM control.vw_Backup_Monitoring
    WHERE Status IN ('CRITICAL', 'WARNING')
    ORDER BY HoursSinceBackup DESC;
    
    PRINT '';
    PRINT 'MAINTENANCE JOB STATUS:';
    PRINT '======================';
    SELECT 
        j.name AS JobName,
        h.step_name,
        h.run_date,
        h.run_time,
        h.run_duration,
        CASE h.run_status
            WHEN 0 THEN 'Failed'
            WHEN 1 THEN 'Succeeded'
            WHEN 2 THEN 'Retry'
            WHEN 3 THEN 'Canceled'
            WHEN 4 THEN 'In Progress'
            ELSE 'Unknown'
        END AS Status
    FROM msdb.dbo.sysjobs j
    LEFT JOIN msdb.dbo.sysjobhistory h ON j.job_id = h.job_id
    WHERE j.name LIKE '%Maintenance%'
      AND h.run_date = (
          SELECT MAX(run_date) 
          FROM msdb.dbo.sysjobhistory h2 
          WHERE h2.job_id = j.job_id
      )
    ORDER BY j.name;
END;
GO

-- Create alert for filegroup space usage
EXEC msdb.dbo.sp_add_alert 
    @name = 'Filegroup Space Critical',
    @message_id = 0,
    @severity = 0,
    @enabled = 1,
    @delay_between_responses = 300,
    @include_event_description_in = 1,
    @job_name = 'Filegroup Space Alert Job';

-- Create alert for index fragmentation
EXEC msdb.dbo.sp_add_alert 
    @name = 'Index Fragmentation Critical',
    @message_id = 0,
    @severity = 0,
    @enabled = 1,
    @delay_between_responses = 300,
    @include_event_description_in = 1,
    @job_name = 'Index Fragmentation Alert Job';

-- Create alert for backup failures
EXEC msdb.dbo.sp_add_alert 
    @name = 'Backup Failure',
    @message_id = 0,
    @severity = 0,
    @enabled = 1,
    @delay_between_responses = 300,
    @include_event_description_in = 1,
    @job_name = 'Backup Failure Alert Job';

-- Create job for filegroup space monitoring
EXEC msdb.dbo.sp_add_job
    @job_name = 'Filegroup Space Monitor',
    @enabled = 1,
    @description = 'Monitor filegroup space usage and send alerts';

EXEC msdb.dbo.sp_add_jobstep
    @job_name = 'Filegroup Space Monitor',
    @step_name = 'Check Filegroup Space',
    @command = 'EXEC control_db.control.sp_Check_Filegroup_Space',
    @database_name = 'control_db';

EXEC msdb.dbo.sp_add_schedule
    @schedule_name = 'Filegroup Space Monitor Schedule',
    @freq_type = 4,
    @freq_interval = 1,
    @freq_subday_type = 4,
    @freq_subday_interval = 1,
    @active_start_time = 0;

EXEC msdb.dbo.sp_attach_schedule
    @job_name = 'Filegroup Space Monitor',
    @schedule_name = 'Filegroup Space Monitor Schedule';

-- Create job for index fragmentation monitoring
EXEC msdb.dbo.sp_add_job
    @job_name = 'Index Fragmentation Monitor',
    @enabled = 1,
    @description = 'Monitor index fragmentation and send alerts';

EXEC msdb.dbo.sp_add_jobstep
    @job_name = 'Index Fragmentation Monitor',
    @step_name = 'Check Index Fragmentation',
    @command = 'EXEC control_db.control.sp_Check_Index_Fragmentation',
    @database_name = 'control_db';

EXEC msdb.dbo.sp_add_schedule
    @schedule_name = 'Index Fragmentation Monitor Schedule',
    @freq_type = 4,
    @freq_interval = 1,
    @freq_subday_type = 8,
    @freq_subday_interval = 6,
    @active_start_time = 0;

EXEC msdb.dbo.sp_attach_schedule
    @job_name = 'Index Fragmentation Monitor',
    @schedule_name = 'Index Fragmentation Monitor Schedule';

-- Create stored procedure to check filegroup space
CREATE PROCEDURE control.sp_Check_Filegroup_Space
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @CriticalCount INT;
    DECLARE @WarningCount INT;
    
    -- Check for critical space usage
    SELECT @CriticalCount = COUNT(*)
    FROM control.vw_Filegroup_Monitoring
    WHERE Status = 'CRITICAL';
    
    -- Check for warning space usage
    SELECT @WarningCount = COUNT(*)
    FROM control.vw_Filegroup_Monitoring
    WHERE Status = 'WARNING';
    
    -- Send alert if critical
    IF @CriticalCount > 0
    BEGIN
        RAISERROR('CRITICAL: %d filegroups are over 90%% full', 16, 1, @CriticalCount);
    END
    
    -- Send alert if warning
    IF @WarningCount > 0
    BEGIN
        RAISERROR('WARNING: %d filegroups are over 80%% full', 16, 1, @WarningCount);
    END
END;
GO

-- Create stored procedure to check index fragmentation
CREATE PROCEDURE control.sp_Check_Index_Fragmentation
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @CriticalCount INT;
    DECLARE @WarningCount INT;
    
    -- Check for critical fragmentation
    SELECT @CriticalCount = COUNT(*)
    FROM control.vw_Index_Fragmentation_Monitoring
    WHERE Status = 'CRITICAL';
    
    -- Check for warning fragmentation
    SELECT @WarningCount = COUNT(*)
    FROM control.vw_Index_Fragmentation_Monitoring
    WHERE Status = 'WARNING';
    
    -- Send alert if critical
    IF @CriticalCount > 0
    BEGIN
        RAISERROR('CRITICAL: %d indexes have fragmentation over 50%%', 16, 1, @CriticalCount);
    END
    
    -- Send alert if warning
    IF @WarningCount > 0
    BEGIN
        RAISERROR('WARNING: %d indexes have fragmentation over 30%%', 16, 1, @WarningCount);
    END
END;
GO

-- Create performance monitoring view
CREATE VIEW control.vw_Performance_Monitoring
AS
SELECT 
    'PRIMARY' AS FileGroupName,
    AVG(avg_cpu_time) AS AvgCPUTime,
    AVG(avg_logical_io_reads) AS AvgLogicalReads,
    AVG(avg_logical_io_writes) AS AvgLogicalWrites,
    AVG(avg_elapsed_time) AS AvgElapsedTime,
    COUNT(*) AS QueryCount
FROM sys.dm_exec_query_stats qs
JOIN sys.dm_exec_sql_text(qs.sql_handle) st ON 1=1
WHERE st.dbid = DB_ID('SourceDB1')
  AND qs.creation_time >= DATEADD(hour, -24, GETDATE());
GO

-- Create maintenance history tracking table
CREATE TABLE control.maintenance_history (
    history_id INT IDENTITY(1,1) PRIMARY KEY,
    maintenance_type VARCHAR(50) NOT NULL,
    filegroup_name VARCHAR(50) NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NULL,
    duration_minutes INT NULL,
    status VARCHAR(20) NOT NULL,
    records_processed INT NULL,
    error_message NVARCHAR(MAX) NULL,
    created_date DATETIME DEFAULT GETDATE()
);

-- Create procedure to log maintenance activities
CREATE PROCEDURE control.sp_Log_Maintenance_Activity
    @maintenance_type VARCHAR(50),
    @filegroup_name VARCHAR(50) = NULL,
    @start_time DATETIME,
    @end_time DATETIME = NULL,
    @status VARCHAR(20),
    @records_processed INT = NULL,
    @error_message NVARCHAR(MAX) = NULL
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @duration_minutes INT = NULL;
    
    IF @end_time IS NOT NULL
        SET @duration_minutes = DATEDIFF(minute, @start_time, @end_time);
    
    INSERT INTO control.maintenance_history
    (maintenance_type, filegroup_name, start_time, end_time, 
     duration_minutes, status, records_processed, error_message)
    VALUES
    (@maintenance_type, @filegroup_name, @start_time, @end_time,
     @duration_minutes, @status, @records_processed, @error_message);
END;
GO

-- Create view for maintenance history analysis
CREATE VIEW control.vw_Maintenance_History_Analysis
AS
SELECT 
    maintenance_type,
    filegroup_name,
    COUNT(*) AS ExecutionCount,
    AVG(duration_minutes) AS AvgDurationMinutes,
    MAX(duration_minutes) AS MaxDurationMinutes,
    MIN(duration_minutes) AS MinDurationMinutes,
    SUM(CASE WHEN status = 'SUCCESS' THEN 1 ELSE 0 END) AS SuccessCount,
    SUM(CASE WHEN status = 'FAILED' THEN 1 ELSE 0 END) AS FailedCount,
    CAST(SUM(CASE WHEN status = 'SUCCESS' THEN 1 ELSE 0 END) * 100.0 / 
         COUNT(*) AS DECIMAL(5,2)) AS SuccessRate
FROM control.maintenance_history
WHERE start_time >= DATEADD(month, -3, GETDATE())
GROUP BY maintenance_type, filegroup_name
ORDER BY maintenance_type, filegroup_name;
GO

PRINT 'Monitoring and alerting system created successfully';
