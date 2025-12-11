-- 01_archival_utilities.sql
-- Utility procedures for archival operations

USE control_db;
GO

-- ===========================================
-- PROCEDURE: Get table metrics for performance decisions
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Get_Table_Metrics
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @record_count BIGINT OUTPUT,
    @data_size_mb DECIMAL(18,2) OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    
    -- Get record count and data size
    SET @sql = '
    USE ' + QUOTENAME(@source_database) + ';
    
    SELECT 
        @record_count = SUM(p.rows),
        @data_size_mb = SUM(au.total_pages) * 8.0 / 1024.0
    FROM sys.partitions p
    JOIN sys.allocation_units au ON p.partition_id = au.container_id
    WHERE p.object_id = OBJECT_ID(''dbo.' + QUOTENAME(@table_name) + ''')
      AND p.index_id IN (0,1);  -- Heap or clustered index
    ';
    
    EXEC sp_executesql @sql,
        N'@record_count BIGINT OUTPUT, @data_size_mb DECIMAL(18,2) OUTPUT',
        @record_count = @record_count OUTPUT,
        @data_size_mb = @data_size_mb OUTPUT;
    
    -- Log metrics
    INSERT INTO control.archival_metrics (
        metric_type, metric_name, metric_value, metric_unit,
        source_database, table_name, operation
    ) VALUES (
        'THROUGHPUT', 'Table Size MB', @data_size_mb, 'MB',
        @source_database, @table_name, 'METRICS'
    );
    
    INSERT INTO control.archival_metrics (
        metric_type, metric_name, metric_value, metric_unit,
        source_database, table_name, operation
    ) VALUES (
        'THROUGHPUT', 'Record Count', @record_count, 'rows',
        @source_database, @table_name, 'METRICS'
    );
END;
GO

-- ===========================================
-- PROCEDURE: Check if archival is already complete (idempotency)
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Check_Archival_Status
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @batch_id UNIQUEIDENTIFIER,
    @is_complete BIT OUTPUT,
    @execution_id UNIQUEIDENTIFIER OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    
    SET @is_complete = 0;
    SET @execution_id = NULL;
    
    -- Check if there's a successful execution for this batch
    SELECT @execution_id = execution_id, @is_complete = is_complete
    FROM control.archival_execution_state
    WHERE batch_id = @batch_id
      AND source_database = @source_database
      AND table_name = @table_name
      AND execution_status = 'SUCCESS';
    
    IF @is_complete = 1
    BEGIN
        PRINT 'Archival already completed for ' + @source_database + '.' + @table_name + ' in batch ' + CAST(@batch_id AS VARCHAR(36));
    END
END;
GO

-- ===========================================
-- PROCEDURE: Create staging table for partition switch (idempotent)
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Create_Partition_Staging_Table
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @staging_table_name VARCHAR(200),
    @batch_id UNIQUEIDENTIFIER
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @exists BIT = 0;
    
    -- Check if staging table already exists
    SET @sql = '
    USE ' + QUOTENAME(@source_database) + ';
    SELECT @exists = CASE WHEN EXISTS (SELECT * FROM sys.tables WHERE name = ''' + @staging_table_name + ''') THEN 1 ELSE 0 END;
    ';
    
    EXEC sp_executesql @sql,
        N'@exists BIT OUTPUT',
        @exists = @exists OUTPUT;
    
    IF @exists = 1
    BEGIN
        PRINT 'Staging table ' + @staging_table_name + ' already exists, skipping creation';
        RETURN;
    END
    
    -- Step 1: Create staging table with same structure as base table
    SET @sql = '
    USE ' + QUOTENAME(@source_database) + ';
    
    -- Create staging table with same structure
    SELECT TOP 0 *
    INTO dbo.' + QUOTENAME(@staging_table_name) + '
    FROM dbo.' + QUOTENAME(@table_name) + ';
    
    -- Add constraint to ensure only archival_flag = 1 records
    ALTER TABLE dbo.' + QUOTENAME(@staging_table_name) + '
    ADD CONSTRAINT CK_' + REPLACE(@staging_table_name, '_', '_') + '_archival_flag 
    CHECK (archival_flag = 1);
    ';
    
    EXEC sp_executesql @sql;
    
    -- Log staging table creation
    INSERT INTO control.partition_switch_tracking (
        batch_id, source_database, table_name, staging_table_name,
        staging_table_created, operation_status
    ) VALUES (
        @batch_id, @source_database, @table_name, @staging_table_name,
        GETDATE(), 'SUCCESS'
    );
    
    PRINT 'Created partition staging table: ' + @source_database + '.dbo.' + @staging_table_name;
END;
GO

-- ===========================================
-- PROCEDURE: Drop staging table safely (idempotent)
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Drop_Staging_Table_Safe
    @source_database VARCHAR(100),
    @staging_table_name VARCHAR(200),
    @batch_id UNIQUEIDENTIFIER
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @exists BIT = 0;
    
    -- Check if staging table exists
    SET @sql = '
    USE ' + QUOTENAME(@source_database) + ';
    SELECT @exists = CASE WHEN EXISTS (SELECT * FROM sys.tables WHERE name = ''' + @staging_table_name + ''') THEN 1 ELSE 0 END;
    ';
    
    EXEC sp_executesql @sql,
        N'@exists BIT OUTPUT',
        @exists = @exists OUTPUT;
    
    IF @exists = 0
    BEGIN
        PRINT 'Staging table ' + @staging_table_name + ' does not exist, skipping drop';
        RETURN;
    END
    
    -- Drop staging table
    SET @sql = '
    USE ' + QUOTENAME(@source_database) + ';
    DROP TABLE dbo.' + QUOTENAME(@staging_table_name) + ';
    ';
    
    EXEC sp_executesql @sql;
    
    -- Update tracking
    UPDATE control.archive_data_movement_tracking
    SET staging_table_dropped = 1,
        staging_drop_date = GETDATE()
    WHERE batch_id = @batch_id
      AND staging_table_name = @staging_table_name;
    
    PRINT 'Dropped staging table: ' + @source_database + '.dbo.' + @staging_table_name;
END;
GO

-- ===========================================
-- PROCEDURE: Log execution step (idempotent)
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Log_Execution_Step
    @execution_id UNIQUEIDENTIFIER,
    @current_step VARCHAR(100),
    @step_sequence INT = NULL
AS
BEGIN
    SET NOCOUNT ON;
    
    UPDATE control.archival_execution_state
    SET current_step = @current_step,
        step_sequence = ISNULL(@step_sequence, step_sequence),
        last_heartbeat = GETDATE()
    WHERE execution_id = @execution_id;
    
    PRINT 'Execution step logged: ' + @current_step;
END;
GO

-- ===========================================
-- PROCEDURE: Update execution status (idempotent)
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Update_Execution_Status
    @execution_id UNIQUEIDENTIFIER,
    @status VARCHAR(50),
    @error_message NVARCHAR(MAX) = NULL,
    @is_complete BIT = 0
AS
BEGIN
    SET NOCOUNT ON;
    
    UPDATE control.archival_execution_state
    SET execution_status = @status,
        last_error = @error_message,
        is_complete = @is_complete,
        completed_at = CASE WHEN @is_complete = 1 THEN GETDATE() ELSE completed_at END,
        last_heartbeat = GETDATE()
    WHERE execution_id = @execution_id;
    
    PRINT 'Execution status updated: ' + @status;
END;
GO

PRINT 'Archival utility procedures created successfully';
