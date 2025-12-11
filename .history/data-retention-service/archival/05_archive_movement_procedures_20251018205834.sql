-- 05_archive_movement_procedures.sql
-- High-performance data movement strategies to archive_db

USE control_db;
GO

-- ===========================================
-- PROCEDURE: Select optimal movement strategy
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Select_Movement_Strategy
    @source_database VARCHAR(100),
    @staging_table_name VARCHAR(200),
    @record_count BIGINT,
    @data_size_mb DECIMAL(18,2),
    @selected_strategy VARCHAR(50) OUTPUT,
    @strategy_reason VARCHAR(200) OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    
    -- Decision logic based on data size and record count
    IF @record_count < 100000 AND @data_size_mb < 100
    BEGIN
        SET @selected_strategy = 'INSERT_SELECT';
        SET @strategy_reason = 'Small dataset (<100K records, <100MB) - using simple INSERT SELECT';
    END
    ELSE IF @data_size_mb > 1000
    BEGIN
        SET @selected_strategy = 'BCP';
        SET @strategy_reason = 'Large dataset (>1GB) - using BCP for maximum performance';
    END
    ELSE
    BEGIN
        SET @selected_strategy = 'BULK_INSERT';
        SET @strategy_reason = 'Medium dataset - using BULK INSERT with table hints';
    END
    
    PRINT 'Selected movement strategy: ' + @selected_strategy + ' - ' + @strategy_reason;
END;
GO

-- ===========================================
-- PROCEDURE: Move data using INSERT SELECT (simple)
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Move_To_Archive_Insert
    @source_database VARCHAR(100),
    @staging_table_name VARCHAR(200),
    @archive_schema VARCHAR(100),
    @archive_table VARCHAR(100),
    @batch_id UNIQUEIDENTIFIER,
    @records_moved BIGINT OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @start_time DATETIME = GETDATE();
    DECLARE @column_list NVARCHAR(MAX);
    
    -- Get column list for explicit insert
    EXEC control.sp_Get_Column_List_For_Insert 
        @source_database, @staging_table_name, @archive_schema, @archive_table,
        @column_list OUTPUT;
    
    -- Simple INSERT INTO archive_db...SELECT FROM staging with explicit columns
    SET @sql = '
    USE archive_db;
    INSERT INTO ' + QUOTENAME(@archive_schema) + '.' + QUOTENAME(@archive_table) + ' 
        (' + @column_list + ', archived_date)
    SELECT ' + @column_list + ', GETDATE()
    FROM ' + QUOTENAME(@source_database) + '.dbo.' + QUOTENAME(@staging_table_name) + ';
    ';
    
    EXEC sp_executesql @sql;
    SET @records_moved = @@ROWCOUNT;
    
    -- Log performance metrics
    DECLARE @duration_ms INT = DATEDIFF(MILLISECOND, @start_time, GETDATE());
    DECLARE @throughput DECIMAL(18,2) = CASE WHEN @duration_ms > 0 THEN (@records_moved * 8.0 / 1024.0) / (@duration_ms / 1000.0) ELSE 0 END;
    
    -- Update tracking
    UPDATE control.archive_data_movement_tracking
    SET records_moved = @records_moved,
        operation_status = 'SUCCESS',
        completed_at = GETDATE(),
        duration_ms = @duration_ms,
        throughput_mb_per_sec = @throughput
    WHERE batch_id = @batch_id AND staging_table_name = @staging_table_name;
    
    -- Log metrics
    INSERT INTO control.archival_metrics (
        metric_type, metric_name, metric_value, metric_unit,
        source_database, operation
    ) VALUES (
        'THROUGHPUT', 'INSERT_SELECT Duration', @duration_ms, 'ms',
        @source_database, 'MOVE_TO_ARCHIVE'
    );
    
    PRINT 'INSERT SELECT completed: ' + CAST(@records_moved AS VARCHAR) + ' records in ' + CAST(@duration_ms AS VARCHAR) + 'ms';
END;
GO

-- ===========================================
-- PROCEDURE: Move data using BULK INSERT (balanced)
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Move_To_Archive_Bulk
    @source_database VARCHAR(100),
    @staging_table_name VARCHAR(200),
    @archive_schema VARCHAR(100),
    @archive_table VARCHAR(100),
    @batch_id UNIQUEIDENTIFIER,
    @batch_size INT = 50000,
    @records_moved BIGINT OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @start_time DATETIME = GETDATE();
    DECLARE @total_moved BIGINT = 0;
    DECLARE @batch_moved INT;
    DECLARE @column_list NVARCHAR(MAX);
    
    -- Get column list for explicit insert
    EXEC control.sp_Get_Column_List_For_Insert 
        @source_database, @staging_table_name, @archive_schema, @archive_table,
        @column_list OUTPUT;
    
    -- Batch INSERT with table hints for performance
    WHILE 1 = 1
    BEGIN
        SET @sql = '
        USE archive_db;
        
        INSERT TOP(' + CAST(@batch_size AS VARCHAR) + ') INTO ' + QUOTENAME(@archive_schema) + '.' + QUOTENAME(@archive_table) + ' WITH (TABLOCK, BULK)
            (' + @column_list + ', archived_date)
        SELECT TOP(' + CAST(@batch_size AS VARCHAR) + ') ' + @column_list + ', GETDATE()
        FROM ' + QUOTENAME(@source_database) + '.dbo.' + QUOTENAME(@staging_table_name) + ' s
        WHERE NOT EXISTS (
            SELECT 1 FROM ' + QUOTENAME(@archive_schema) + '.' + QUOTENAME(@archive_table) + ' a
            WHERE a.id = s.id
        );
        ';
        
        EXEC sp_executesql @sql;
        SET @batch_moved = @@ROWCOUNT;
        SET @total_moved = @total_moved + @batch_moved;
        
        -- Break if no more records
        IF @batch_moved = 0 BREAK;
        
        -- Update progress every 10 batches
        IF @total_moved % (@batch_size * 10) = 0
        BEGIN
            UPDATE control.archive_data_movement_tracking
            SET records_moved = @total_moved
            WHERE batch_id = @batch_id AND staging_table_name = @staging_table_name;
        END
        
        -- Small delay to avoid overwhelming system
        WAITFOR DELAY '00:00:00.050';
    END
    
    SET @records_moved = @total_moved;
    
    -- Log performance metrics
    DECLARE @duration_ms INT = DATEDIFF(MILLISECOND, @start_time, GETDATE());
    DECLARE @throughput DECIMAL(18,2) = CASE WHEN @duration_ms > 0 THEN (@records_moved * 8.0 / 1024.0) / (@duration_ms / 1000.0) ELSE 0 END;
    
    -- Update tracking
    UPDATE control.archive_data_movement_tracking
    SET records_moved = @records_moved,
        operation_status = 'SUCCESS',
        completed_at = GETDATE(),
        duration_ms = @duration_ms,
        throughput_mb_per_sec = @throughput
    WHERE batch_id = @batch_id AND staging_table_name = @staging_table_name;
    
    -- Log metrics
    INSERT INTO control.archival_metrics (
        metric_type, metric_name, metric_value, metric_unit,
        source_database, operation
    ) VALUES (
        'THROUGHPUT', 'BULK_INSERT Duration', @duration_ms, 'ms',
        @source_database, 'MOVE_TO_ARCHIVE'
    );
    
    PRINT 'BULK INSERT completed: ' + CAST(@records_moved AS VARCHAR) + ' records in ' + CAST(@duration_ms AS VARCHAR) + 'ms';
END;
GO

-- ===========================================
-- PROCEDURE: Move data using BCP (fastest for large datasets)
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Move_To_Archive_BCP
    @source_database VARCHAR(100),
    @staging_table_name VARCHAR(200),
    @archive_schema VARCHAR(100),
    @archive_table VARCHAR(100),
    @batch_id UNIQUEIDENTIFIER,
    @records_moved BIGINT OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @start_time DATETIME = GETDATE();
    DECLARE @temp_file VARCHAR(500) = '/tmp/archive_' + CAST(@batch_id AS VARCHAR(36)) + '.dat';
    
    -- Step 1: Export staging table to file using BCP
    SET @sql = '
    DECLARE @bcp_cmd VARCHAR(1000);
    SET @bcp_cmd = ''bcp "SELECT * FROM ' + @source_database + '.dbo.' + @staging_table_name + '" queryout "' + @temp_file + '" -S localhost -U sa -P "Archival@2025!" -c -T'';
    EXEC xp_cmdshell @bcp_cmd;
    ';
    
    EXEC sp_executesql @sql;
    
    -- Step 2: Import into archive_db using BULK INSERT
    SET @sql = '
    USE archive_db;
    
    BULK INSERT ' + QUOTENAME(@archive_schema) + '.' + QUOTENAME(@archive_table) + '
    FROM "' + @temp_file + '"
    WITH (
        FIELDTERMINATOR = ''\t'',
        ROWTERMINATOR = ''\n'',
        TABLOCK,
        BATCHSIZE = 10000
    );
    ';
    
    EXEC sp_executesql @sql;
    SET @records_moved = @@ROWCOUNT;
    
    -- Step 3: Clean up temp file
    SET @sql = 'EXEC xp_cmdshell ''del "' + @temp_file + '"''';
    EXEC sp_executesql @sql;
    
    -- Log performance metrics
    DECLARE @duration_ms INT = DATEDIFF(MILLISECOND, @start_time, GETDATE());
    DECLARE @throughput DECIMAL(18,2) = CASE WHEN @duration_ms > 0 THEN (@records_moved * 8.0 / 1024.0) / (@duration_ms / 1000.0) ELSE 0 END;
    
    -- Update tracking
    UPDATE control.archive_data_movement_tracking
    SET records_moved = @records_moved,
        operation_status = 'SUCCESS',
        completed_at = GETDATE(),
        duration_ms = @duration_ms,
        throughput_mb_per_sec = @throughput
    WHERE batch_id = @batch_id AND staging_table_name = @staging_table_name;
    
    -- Log metrics
    INSERT INTO control.archival_metrics (
        metric_type, metric_name, metric_value, metric_unit,
        source_database, operation
    ) VALUES (
        'THROUGHPUT', 'BCP Duration', @duration_ms, 'ms',
        @source_database, 'MOVE_TO_ARCHIVE'
    );
    
    PRINT 'BCP completed: ' + CAST(@records_moved AS VARCHAR) + ' records in ' + CAST(@duration_ms AS VARCHAR) + 'ms';
END;
GO

-- ===========================================
-- PROCEDURE: Master data movement procedure
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Move_To_Archive_Master
    @source_database VARCHAR(100),
    @staging_table_name VARCHAR(200),
    @archive_schema VARCHAR(100),
    @archive_table VARCHAR(100),
    @batch_id UNIQUEIDENTIFIER,
    @records_moved BIGINT OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @record_count BIGINT;
    DECLARE @data_size_mb DECIMAL(18,2);
    DECLARE @selected_strategy VARCHAR(50);
    DECLARE @strategy_reason VARCHAR(200);
    DECLARE @start_time DATETIME = GETDATE();
    
    -- Get table metrics
    EXEC control.sp_Get_Table_Metrics @source_database, @staging_table_name, @record_count OUTPUT, @data_size_mb OUTPUT;
    
    -- Select optimal strategy
    EXEC control.sp_Select_Movement_Strategy 
        @source_database, @staging_table_name, @record_count, @data_size_mb,
        @selected_strategy OUTPUT, @strategy_reason OUTPUT;
    
    -- Log movement start
    INSERT INTO control.archive_data_movement_tracking (
        batch_id, source_database, staging_table_name, archive_table_name,
        movement_strategy, movement_reason, records_to_move, data_size_mb,
        started_at, operation_status
    ) VALUES (
        @batch_id, @source_database, @staging_table_name, @archive_table_name,
        @selected_strategy, @strategy_reason, @record_count, @data_size_mb,
        @start_time, 'IN_PROGRESS'
    );
    
    -- Execute movement based on strategy
    IF @selected_strategy = 'BCP'
        EXEC control.sp_Move_To_Archive_BCP @source_database, @staging_table_name, @archive_schema, @archive_table, @batch_id, @records_moved OUTPUT;
    ELSE IF @selected_strategy = 'INSERT_SELECT'
        EXEC control.sp_Move_To_Archive_Insert @source_database, @staging_table_name, @archive_schema, @archive_table, @batch_id, @records_moved OUTPUT;
    ELSE
        EXEC control.sp_Move_To_Archive_Bulk @source_database, @staging_table_name, @archive_schema, @archive_table, @batch_id, 50000, @records_moved OUTPUT;
    
    -- Verify record counts match
    IF @records_moved != @record_count
    BEGIN
        PRINT 'WARNING: Record count mismatch. Expected: ' + CAST(@record_count AS VARCHAR) + ', Moved: ' + CAST(@records_moved AS VARCHAR);
    END
    
    PRINT 'Data movement completed successfully using ' + @selected_strategy + ' strategy';
END;
GO

PRINT 'Archive movement procedures created successfully';
