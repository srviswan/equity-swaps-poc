-- 05_monitoring_procedures.sql
-- Health checks, monitoring, and validation procedures

USE control_db;
GO

-- ===========================================
-- PROCEDURE: Validate system prerequisites (idempotent)
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Validate_System_Prerequisites
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @result TABLE (check_name VARCHAR(100), status VARCHAR(20), details VARCHAR(200));
    DECLARE @all_passed BIT = 1;
    
    -- Check databases
    INSERT INTO @result
    SELECT 'control_db exists', 
        CASE WHEN EXISTS (SELECT 1 FROM sys.databases WHERE name = 'control_db') THEN 'PASS' ELSE 'FAIL' END,
        CASE WHEN EXISTS (SELECT 1 FROM sys.databases WHERE name = 'control_db') THEN 'Database exists' ELSE 'Database missing' END;
    
    INSERT INTO @result
    SELECT 'archive_db exists', 
        CASE WHEN EXISTS (SELECT 1 FROM sys.databases WHERE name = 'archive_db') THEN 'PASS' ELSE 'FAIL' END,
        CASE WHEN EXISTS (SELECT 1 FROM sys.databases WHERE name = 'archive_db') THEN 'Database exists' ELSE 'Database missing' END;
    
    -- Check control schema
    INSERT INTO @result
    SELECT 'control schema exists',
        CASE WHEN EXISTS (SELECT 1 FROM sys.schemas WHERE name = 'control') THEN 'PASS' ELSE 'FAIL' END,
        CASE WHEN EXISTS (SELECT 1 FROM sys.schemas WHERE name = 'control') THEN 'Schema exists' ELSE 'Schema missing' END;
    
    -- Check tables
    INSERT INTO @result
    SELECT 'archival_table_list exists', 
        CASE WHEN EXISTS (SELECT 1 FROM sys.tables WHERE name = 'archival_table_list') THEN 'PASS' ELSE 'FAIL' END,
        CASE WHEN EXISTS (SELECT 1 FROM sys.tables WHERE name = 'archival_table_list') THEN 'Table exists' ELSE 'Table missing' END;
    
    INSERT INTO @result
    SELECT 'archival_execution_state exists',
        CASE WHEN EXISTS (SELECT 1 FROM sys.tables WHERE name = 'archival_execution_state') THEN 'PASS' ELSE 'FAIL' END,
        CASE WHEN EXISTS (SELECT 1 FROM sys.tables WHERE name = 'archival_execution_state') THEN 'Table exists' ELSE 'Table missing' END;
    
    INSERT INTO @result
    SELECT 'partition_switch_tracking exists',
        CASE WHEN EXISTS (SELECT 1 FROM sys.tables WHERE name = 'partition_switch_tracking') THEN 'PASS' ELSE 'FAIL' END,
        CASE WHEN EXISTS (SELECT 1 FROM sys.tables WHERE name = 'partition_switch_tracking') THEN 'Table exists' ELSE 'Table missing' END;
    
    INSERT INTO @result
    SELECT 'archive_data_movement_tracking exists',
        CASE WHEN EXISTS (SELECT 1 FROM sys.tables WHERE name = 'archive_data_movement_tracking') THEN 'PASS' ELSE 'FAIL' END,
        CASE WHEN EXISTS (SELECT 1 FROM sys.tables WHERE name = 'archive_data_movement_tracking') THEN 'Table exists' ELSE 'Table missing' END;
    
    INSERT INTO @result
    SELECT 'archive_disposal_tracking exists',
        CASE WHEN EXISTS (SELECT 1 FROM sys.tables WHERE name = 'archive_disposal_tracking') THEN 'PASS' ELSE 'FAIL' END,
        CASE WHEN EXISTS (SELECT 1 FROM sys.tables WHERE name = 'archive_disposal_tracking') THEN 'Table exists' ELSE 'Table missing' END;
    
    -- Check procedures
    INSERT INTO @result
    SELECT 'sp_Detect_Partition_Info exists',
        CASE WHEN EXISTS (SELECT 1 FROM sys.procedures WHERE name = 'sp_Detect_Partition_Info') THEN 'PASS' ELSE 'FAIL' END,
        CASE WHEN EXISTS (SELECT 1 FROM sys.procedures WHERE name = 'sp_Detect_Partition_Info') THEN 'Procedure exists' ELSE 'Procedure missing' END;
    
    -- Check for any failures
    IF EXISTS (SELECT 1 FROM @result WHERE status = 'FAIL')
        SET @all_passed = 0;
    
    -- Return results
    SELECT * FROM @result ORDER BY check_name;
    
    IF @all_passed = 1
    BEGIN
        PRINT 'VALID: All prerequisites met';
        RETURN 0;
    END
    ELSE
    BEGIN
        PRINT 'INVALID: One or more checks failed';
        RETURN 1;
    END
END;
GO

-- ===========================================
-- PROCEDURE: Monitor running executions
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Monitor_Executions
AS
BEGIN
    SET NOCOUNT ON;
    
    SELECT 
        execution_id,
        batch_id,
        workflow_type,
        source_database,
        table_name,
        current_phase,
        current_step,
        execution_status,
        DATEDIFF(MINUTE, started_at, GETDATE()) as running_minutes,
        DATEDIFF(SECOND, last_heartbeat, GETDATE()) as seconds_since_heartbeat,
        error_count,
        last_error,
        can_resume,
        is_complete
    FROM control.archival_execution_state
    WHERE is_complete = 0 OR execution_status = 'FAILED'
    ORDER BY started_at DESC;
    
    -- Show summary
    SELECT 
        execution_status,
        COUNT(*) as count,
        AVG(DATEDIFF(MINUTE, started_at, ISNULL(completed_at, GETDATE()))) as avg_duration_minutes
    FROM control.archival_execution_state
    WHERE started_at >= DATEADD(DAY, -1, GETDATE())  -- Last 24 hours
    GROUP BY execution_status
    ORDER BY execution_status;
END;
GO

-- ===========================================
-- PROCEDURE: Resume failed executions (idempotent)
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Resume_Failed_Executions
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @resumed_count INT = 0;
    
    -- Find resumable failed executions
    DECLARE @resumable_executions TABLE (
        execution_id UNIQUEIDENTIFIER,
        batch_id UNIQUEIDENTIFIER,
        workflow_type VARCHAR(50),
        source_database VARCHAR(100),
        table_name VARCHAR(100),
        resume_point VARCHAR(200)
    );
    
    INSERT INTO @resumable_executions
    SELECT execution_id, batch_id, workflow_type, source_database, table_name, resume_point
    FROM control.archival_execution_state
    WHERE execution_status = 'FAILED'
      AND can_resume = 1
      AND error_count < 3; -- Max retry limit
    
    -- Resume each execution
    DECLARE @execution_id UNIQUEIDENTIFIER;
    DECLARE @batch_id UNIQUEIDENTIFIER;
    DECLARE @workflow_type VARCHAR(50);
    DECLARE @source_database VARCHAR(100);
    DECLARE @table_name VARCHAR(100);
    
    DECLARE resume_cursor CURSOR FOR
    SELECT execution_id, batch_id, workflow_type, source_database, table_name 
    FROM @resumable_executions;
    
    OPEN resume_cursor;
    FETCH NEXT FROM resume_cursor INTO @execution_id, @batch_id, @workflow_type, @source_database, @table_name;
    
    WHILE @@FETCH_STATUS = 0
    BEGIN
        -- Reset status for retry
        UPDATE control.archival_execution_state
        SET execution_status = 'RUNNING',
            error_count = error_count + 1,
            last_heartbeat = GETDATE(),
            last_error = NULL
        WHERE execution_id = @execution_id;
        
        PRINT 'Resuming execution: ' + CAST(@execution_id AS VARCHAR(36)) + 
              ' for ' + ISNULL(@source_database, '') + '.' + ISNULL(@table_name, '');
        
        -- Log resume attempt
        INSERT INTO control.archival_execution_log (
            batch_id, operation, source_database, table_name,
            records_affected, status, execution_end
        ) VALUES (
            @batch_id, 'RESUME_ATTEMPT', @source_database, @table_name,
            0, 'SUCCESS', GETDATE()
        );
        
        SET @resumed_count = @resumed_count + 1;
        
        FETCH NEXT FROM resume_cursor INTO @execution_id, @batch_id, @workflow_type, @source_database, @table_name;
    END
    
    CLOSE resume_cursor;
    DEALLOCATE resume_cursor;
    
    PRINT 'Resumed ' + CAST(@resumed_count AS VARCHAR) + ' failed executions';
END;
GO

-- ===========================================
-- PROCEDURE: Show system health metrics
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Show_System_Health
AS
BEGIN
    SET NOCOUNT ON;
    
    -- Recent execution summary
    SELECT 
        'Recent Executions (Last 24h)' as metric_category,
        execution_status as metric_name,
        COUNT(*) as metric_value,
        'count' as metric_unit
    FROM control.archival_execution_state
    WHERE started_at >= DATEADD(DAY, -1, GETDATE())
    GROUP BY execution_status
    
    UNION ALL
    
    -- Performance metrics
    SELECT 
        'Performance Metrics' as metric_category,
        metric_name,
        AVG(metric_value) as metric_value,
        metric_unit
    FROM control.archival_metrics
    WHERE metric_timestamp >= DATEADD(HOUR, -1, GETDATE())
    GROUP BY metric_name, metric_unit
    
    UNION ALL
    
    -- Error rates
    SELECT 
        'Error Rates' as metric_category,
        'Failed Executions' as metric_name,
        COUNT(*) as metric_value,
        'count' as metric_unit
    FROM control.archival_execution_state
    WHERE execution_status = 'FAILED'
      AND started_at >= DATEADD(DAY, -1, GETDATE())
    
    ORDER BY metric_category, metric_name;
END;
GO

-- ===========================================
-- PROCEDURE: Clean up old execution data
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Cleanup_Old_Data
    @days_to_keep INT = 30
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @cutoff_date DATETIME = DATEADD(DAY, -@days_to_keep, GETDATE());
    DECLARE @deleted_count INT = 0;
    
    -- Clean up old execution logs
    DELETE FROM control.archival_execution_log
    WHERE execution_start < @cutoff_date;
    SET @deleted_count = @deleted_count + @@ROWCOUNT;
    
    -- Clean up old metrics
    DELETE FROM control.archival_metrics
    WHERE metric_timestamp < @cutoff_date;
    SET @deleted_count = @deleted_count + @@ROWCOUNT;
    
    -- Clean up completed execution states
    DELETE FROM control.archival_execution_state
    WHERE is_complete = 1 
      AND completed_at < @cutoff_date;
    SET @deleted_count = @deleted_count + @@ROWCOUNT;
    
    PRINT 'Cleaned up ' + CAST(@deleted_count AS VARCHAR) + ' old records (older than ' + CAST(@days_to_keep AS VARCHAR) + ' days)';
END;
GO

-- ===========================================
-- PROCEDURE: Validate no duplicate data
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Validate_No_Duplicates
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @duplicate_count INT = 0;
    
    -- Check for duplicate markers
    SELECT @duplicate_count = COUNT(*) - COUNT(DISTINCT source_database + '.' + table_name + '.' + primary_key_hash)
    FROM control.archival_marker;
    
    IF @duplicate_count > 0
    BEGIN
        PRINT 'INVALID: Found ' + CAST(@duplicate_count AS VARCHAR) + ' duplicate archival markers';
        RETURN 1;
    END
    
    -- Check for duplicate execution states
    SELECT @duplicate_count = COUNT(*) - COUNT(DISTINCT batch_id + '.' + CAST(execution_id AS VARCHAR(36)))
    FROM control.archival_execution_state;
    
    IF @duplicate_count > 0
    BEGIN
        PRINT 'INVALID: Found ' + CAST(@duplicate_count AS VARCHAR) + ' duplicate execution states';
        RETURN 1;
    END
    
    PRINT 'VALID: No duplicate data found';
    RETURN 0;
END;
GO

PRINT 'Monitoring and validation procedures created successfully';
