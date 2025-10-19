-- 02_prepare_archival_records.sql
-- Intelligent record preparation with partition detection and fallback

USE control_db;
GO

-- ===========================================
-- PROCEDURE: Prepare archival records (idempotent)
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Prepare_Archival_Records_Idempotent
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @batch_id UNIQUEIDENTIFIER,
    @staging_table_name VARCHAR(200) OUTPUT,
    @archive_table_versioned VARCHAR(200) OUTPUT,
    @schema_version INT OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @has_partition BIT = 0;
    DECLARE @partition_function VARCHAR(200);
    DECLARE @partition_scheme VARCHAR(200);
    DECLARE @partition_number INT;
    DECLARE @records_marked INT = 0;
    DECLARE @records_moved INT = 0;
    DECLARE @date_column VARCHAR(100);
    DECLARE @months_before_archival INT;
    DECLARE @error_msg NVARCHAR(MAX);
    DECLARE @archive_table_versioned VARCHAR(200);
    DECLARE @schema_version INT;
    DECLARE @validation_status VARCHAR(50);
    
    -- Generate staging table name
    SET @staging_table_name = @table_name + '_Archive_Staging_' + FORMAT(GETDATE(), 'yyyyMMdd_HHmmss');
    
    -- Get configuration
    SELECT 
        @date_column = date_column,
        @months_before_archival = months_before_archival
    FROM control.archival_table_list
    WHERE source_database = @source_database AND table_name = @table_name;
    
    IF @date_column IS NULL
    BEGIN
        SET @error_msg = 'Table not configured: ' + @source_database + '.' + @table_name;
        PRINT @error_msg;
        THROW 50001, @error_msg, 1;
    END
    
    -- Validate schema before archival
    EXEC control.sp_Validate_Schema_Before_Archival 
        @source_database, @table_name,
        @archive_table_versioned OUTPUT,
        @schema_version OUTPUT,
        @validation_status OUTPUT,
        @batch_id;
    
    IF @validation_status = 'SCHEMA_CHANGED'
    BEGIN
        PRINT 'Schema change detected. Using new archive table: ' + @archive_table_versioned;
    END
    ELSE IF @validation_status = 'INITIAL_SCHEMA'
    BEGIN
        PRINT 'Initial schema detected. Created archive table: ' + @archive_table_versioned;
    END
    ELSE IF @validation_status = 'CONFIG_ERROR'
    BEGIN
        SET @error_msg = 'Schema validation failed: ' + @validation_status;
        PRINT @error_msg;
        THROW 50002, @error_msg, 1;
    END
    
    BEGIN TRY
        -- Step 1: Detect partition information
        EXEC control.sp_Detect_Partition_Info 
            @source_database, @table_name,
            @has_partition OUTPUT, @partition_function OUTPUT, 
            @partition_scheme OUTPUT, @partition_number OUTPUT;
        
        -- Step 2: Mark records for archival (idempotent - only mark if not already marked)
        SET @sql = '
        USE ' + QUOTENAME(@source_database) + ';
        UPDATE dbo.' + QUOTENAME(@table_name) + '
        SET archival_flag = 1,
            archival_month = FORMAT(' + @date_column + ', ''yyyyMM'')
        WHERE archival_flag = 0
          AND ' + @date_column + ' < DATEADD(MONTH, -' + CAST(@months_before_archival AS VARCHAR) + ', GETDATE());
        ';
        
        EXEC sp_executesql @sql;
        SET @records_marked = @@ROWCOUNT;
        
        IF @records_marked = 0
        BEGIN
            PRINT 'No records marked for archival in ' + @source_database + '.' + @table_name;
            
            -- Log success with 0 records
            INSERT INTO control.archival_execution_log (
                batch_id, operation, source_database, table_name,
                records_affected, status, execution_end
            ) VALUES (
                @batch_id, 'PREPARE_RECORDS', @source_database, @table_name,
                0, 'SUCCESS', GETDATE()
            );
            RETURN;
        END
        
        -- Step 3: Create staging table
        EXEC control.sp_Create_Partition_Staging_Table 
            @source_database, @table_name, @staging_table_name, @batch_id;
        
        -- Step 4: Choose operation method and execute
        IF @has_partition = 1
        BEGIN
            -- Use partition switching (fastest)
            EXEC control.sp_Partition_Switch_To_Staging
                @source_database, @table_name, @staging_table_name, 
                @partition_number, @batch_id, @records_moved OUTPUT;
            
            -- Log partition switch operation
            UPDATE control.partition_switch_tracking
            SET operation_method = 'PARTITION_SWITCH',
                operation_reason = 'Table is partitioned, using high-performance partition switch',
                records_moved = @records_moved,
                operation_status = 'SUCCESS',
                completed_at = GETDATE(),
                duration_ms = DATEDIFF(MILLISECOND, started_at, GETDATE())
            WHERE batch_id = @batch_id AND staging_table_name = @staging_table_name;
        END
        ELSE
        BEGIN
            -- Use bulk copy (fallback)
            EXEC control.sp_Bulk_Copy_To_Staging
                @source_database, @table_name, @staging_table_name, 
                @batch_id, @records_moved OUTPUT;
            
            -- Log bulk copy operation
            UPDATE control.partition_switch_tracking
            SET operation_method = 'BULK_COPY',
                operation_reason = 'Table not partitioned, using bulk copy fallback',
                records_moved = @records_moved,
                operation_status = 'SUCCESS',
                completed_at = GETDATE(),
                duration_ms = DATEDIFF(MILLISECOND, started_at, GETDATE())
            WHERE batch_id = @batch_id AND staging_table_name = @staging_table_name;
        END
        
        -- Step 5: Log success
        INSERT INTO control.archival_execution_log (
            batch_id, operation, source_database, table_name,
            records_affected, status, execution_end
        ) VALUES (
            @batch_id, 'PREPARE_RECORDS', @source_database, @table_name,
            @records_moved, 'SUCCESS', GETDATE()
        );
        
        PRINT 'Successfully prepared ' + CAST(@records_moved AS VARCHAR) + ' records for archival from ' + @source_database + '.' + @table_name;
        
    END TRY
    BEGIN CATCH
        SET @error_msg = ERROR_MESSAGE();
        
        -- Log error
        INSERT INTO control.archival_execution_log (
            batch_id, operation, source_database, table_name,
            records_affected, status, execution_end, error_message
        ) VALUES (
            @batch_id, 'PREPARE_RECORDS_FAILED', @source_database, @table_name,
            0, 'FAILED', GETDATE(), @error_msg
        );
        
        -- Update partition tracking
        UPDATE control.partition_switch_tracking
        SET operation_status = 'FAILED',
            error_message = @error_msg,
            retry_count = retry_count + 1
        WHERE batch_id = @batch_id AND staging_table_name = @staging_table_name;
        
        -- Clean up staging table if exists
        BEGIN TRY
            EXEC control.sp_Drop_Staging_Table_Safe @source_database, @staging_table_name, @batch_id;
        END TRY
        BEGIN CATCH
            -- Ignore cleanup errors
        END CATCH
        
        PRINT 'ERROR: Record preparation failed - ' + @error_msg;
        THROW;
    END CATCH
END;
GO

-- ===========================================
-- PROCEDURE: Partition switch to staging table
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Partition_Switch_To_Staging
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @staging_table_name VARCHAR(200),
    @partition_number INT,
    @batch_id UNIQUEIDENTIFIER,
    @records_moved INT OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    
    -- Get record count before switch
    SET @sql = '
    USE ' + QUOTENAME(@source_database) + ';
    SELECT @count = COUNT(*)
    FROM dbo.' + QUOTENAME(@table_name) + '
    WHERE archival_flag = 1;
    ';
    
    DECLARE @count INT;
    EXEC sp_executesql @sql, N'@count INT OUTPUT', @count = @count OUTPUT;
    
    -- Perform partition switch (metadata operation - very fast!)
    SET @sql = '
    USE ' + QUOTENAME(@source_database) + ';
    
    -- Switch partition from base table to staging table
    ALTER TABLE dbo.' + QUOTENAME(@table_name) + '
    SWITCH PARTITION ' + CAST(@partition_number AS VARCHAR) + '
    TO dbo.' + QUOTENAME(@staging_table_name) + ';
    
    PRINT ''Partition switched to staging table'';
    ';
    
    EXEC sp_executesql @sql;
    
    SET @records_moved = @count;
    
    PRINT 'Partition switch completed: ' + CAST(@records_moved AS VARCHAR) + ' records moved to staging table';
END;
GO

-- ===========================================
-- PROCEDURE: Bulk copy to staging table (fallback)
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Bulk_Copy_To_Staging
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @staging_table_name VARCHAR(200),
    @batch_id UNIQUEIDENTIFIER,
    @records_moved INT OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @batch_size INT = 10000;
    DECLARE @total_moved INT = 0;
    DECLARE @batch_moved INT;
    
    -- Insert records in batches to avoid long locks
    WHILE 1 = 1
    BEGIN
        SET @sql = '
        USE ' + QUOTENAME(@source_database) + ';
        
        INSERT TOP(' + CAST(@batch_size AS VARCHAR) + ') INTO dbo.' + QUOTENAME(@staging_table_name) + '
        SELECT TOP(' + CAST(@batch_size AS VARCHAR) + ') *
        FROM dbo.' + QUOTENAME(@table_name) + '
        WHERE archival_flag = 1
          AND NOT EXISTS (
              SELECT 1 FROM dbo.' + QUOTENAME(@staging_table_name) + ' s
              WHERE s.' + @table_name + 'Id = dbo.' + QUOTENAME(@table_name) + '.' + @table_name + 'Id
          );
        ';
        
        EXEC sp_executesql @sql;
        SET @batch_moved = @@ROWCOUNT;
        SET @total_moved = @total_moved + @batch_moved;
        
        -- Break if no more records
        IF @batch_moved = 0 BREAK;
        
        -- Small delay to avoid overwhelming system
        WAITFOR DELAY '00:00:00.100';
    END
    
    SET @records_moved = @total_moved;
    
    PRINT 'Bulk copy completed: ' + CAST(@records_moved AS VARCHAR) + ' records moved to staging table';
END;
GO

PRINT 'Record preparation procedures created successfully';
