-- 07_disposal_procedures.sql
-- Retention-based disposal procedures with compliance tracking

USE control_db;
GO

-- ===========================================
-- PROCEDURE: Identify records for disposal
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Identify_Records_For_Disposal
    @archive_schema VARCHAR(100),
    @archive_table VARCHAR(100),
    @retention_years INT,
    @batch_id UNIQUEIDENTIFIER,
    @records_identified BIGINT OUTPUT,
    @disposal_cutoff_date DATE OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    
    -- Calculate cutoff date (today - retention_years)
    SET @disposal_cutoff_date = DATEADD(YEAR, -@retention_years, GETDATE());
    
    -- Count records in archive_db older than cutoff
    SET @sql = '
    SELECT @count = COUNT(*)
    FROM archive_db.' + QUOTENAME(@archive_schema) + '.' + QUOTENAME(@archive_table) + '
    WHERE archived_date < @cutoff_date;
    ';
    
    EXEC sp_executesql @sql, 
        N'@cutoff_date DATE, @count BIGINT OUTPUT',
        @cutoff_date = @disposal_cutoff_date,
        @count = @records_identified OUTPUT;
    
    -- Log to archive_disposal_tracking
    INSERT INTO control.archive_disposal_tracking (
        batch_id, archive_schema, archive_table,
        retention_years, disposal_cutoff_date,
        records_identified, operation_status
    ) VALUES (
        @batch_id, @archive_schema, @archive_table,
        @retention_years, @disposal_cutoff_date,
        @records_identified, 'PENDING'
    );
    
    PRINT 'Identified ' + CAST(@records_identified AS VARCHAR) + ' records for disposal (older than ' + CAST(@disposal_cutoff_date AS VARCHAR) + ')';
END;
GO

-- ===========================================
-- PROCEDURE: Dispose records using batch deletion
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Dispose_Records_Batch_Delete
    @archive_schema VARCHAR(100),
    @archive_table VARCHAR(100),
    @disposal_cutoff_date DATE,
    @batch_id UNIQUEIDENTIFIER,
    @batch_size INT = 10000
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @records_deleted BIGINT = 0;
    DECLARE @batch_count INT = 0;
    DECLARE @start_time DATETIME = GETDATE();
    
    -- Update disposal_tracking to IN_PROGRESS
    UPDATE control.archive_disposal_tracking
    SET operation_status = 'IN_PROGRESS', started_at = @start_time
    WHERE batch_id = @batch_id;
    
    -- Delete in batches to avoid long locks
    WHILE 1 = 1
    BEGIN
        SET @sql = '
        USE archive_db;
        DELETE TOP(' + CAST(@batch_size AS VARCHAR) + ')
        FROM ' + QUOTENAME(@archive_schema) + '.' + QUOTENAME(@archive_table) + '
        WHERE archived_date < @cutoff_date;
        ';
        
        EXEC sp_executesql @sql,
            N'@cutoff_date DATE',
            @cutoff_date = @disposal_cutoff_date;
        
        SET @batch_count = @@ROWCOUNT;
        SET @records_deleted = @records_deleted + @batch_count;
        
        -- Break if no more records
        IF @batch_count = 0 BREAK;
        
        -- Log progress every 10 batches
        IF @records_deleted % (@batch_size * 10) = 0
        BEGIN
            UPDATE control.archive_disposal_tracking
            SET records_disposed = @records_deleted
            WHERE batch_id = @batch_id;
            
            PRINT 'Disposed ' + CAST(@records_deleted AS VARCHAR) + ' records so far...';
        END
        
        -- Small delay to avoid overwhelming system
        WAITFOR DELAY '00:00:00.100';
    END
    
    -- Update disposal_tracking with final results
    DECLARE @duration_ms INT = DATEDIFF(MILLISECOND, @start_time, GETDATE());
    UPDATE control.archive_disposal_tracking
    SET records_disposed = @records_deleted,
        operation_status = 'SUCCESS',
        completed_at = GETDATE(),
        duration_ms = @duration_ms
    WHERE batch_id = @batch_id;
    
    -- Log to archival_execution_log
    INSERT INTO control.archival_execution_log (
        batch_id, operation, table_name,
        records_affected, status, execution_end
    ) VALUES (
        @batch_id, 'DISPOSAL', @archive_table,
        @records_deleted, 'SUCCESS', GETDATE()
    );
    
    PRINT 'Batch deletion completed: ' + CAST(@records_deleted AS VARCHAR) + ' records disposed in ' + CAST(@duration_ms AS VARCHAR) + 'ms';
END;
GO

-- ===========================================
-- PROCEDURE: Dispose records using partition drop (fastest)
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Dispose_Records_Partition_Drop
    @archive_schema VARCHAR(100),
    @archive_table VARCHAR(100),
    @disposal_cutoff_date DATE,
    @batch_id UNIQUEIDENTIFIER
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @start_time DATETIME = GETDATE();
    DECLARE @records_disposed BIGINT = 0;
    
    -- Update disposal_tracking to IN_PROGRESS
    UPDATE control.archive_disposal_tracking
    SET operation_status = 'IN_PROGRESS', started_at = @start_time
    WHERE batch_id = @batch_id;
    
    -- Check if table is partitioned by archived_date
    SET @sql = '
    USE archive_db;
    
    -- Get partition information
    DECLARE @partition_function VARCHAR(200);
    DECLARE @partition_scheme VARCHAR(200);
    DECLARE @partition_number INT;
    
    SELECT 
        @partition_function = pf.name,
        @partition_scheme = ps.name,
        @partition_number = p.partition_number
    FROM sys.partitions p
    JOIN sys.indexes i ON p.object_id = i.object_id AND p.index_id = i.index_id
    JOIN sys.partition_schemes ps ON i.data_space_id = ps.data_space_id
    JOIN sys.partition_functions pf ON ps.function_id = pf.function_id
    WHERE p.object_id = OBJECT_ID(''' + QUOTENAME(@archive_schema) + '.' + QUOTENAME(@archive_table) + ''')
      AND i.index_id IN (0,1)
      AND pf.name LIKE ''%' + @archive_table + '%'';
    
    -- If partitioned, find partitions containing only data before cutoff
    IF @partition_function IS NOT NULL
    BEGIN
        -- Get record count in partition
        SELECT @records_disposed = COUNT(*)
        FROM ' + QUOTENAME(@archive_schema) + '.' + QUOTENAME(@archive_table) + '
        WHERE archived_date < @cutoff_date;
        
        -- Create temp table for partition switch
        DECLARE @temp_table VARCHAR(200) = ''' + @archive_table + '_temp_' + CAST(@batch_id AS VARCHAR(36)) + ''';
        
        -- Switch partition to temp table
        ALTER TABLE ' + QUOTENAME(@archive_schema) + '.' + QUOTENAME(@archive_table) + '
        SWITCH PARTITION @partition_number TO dbo.' + @temp_table + ';
        
        -- Drop temp table (instant)
        DROP TABLE dbo.' + @temp_table + ';
        
        PRINT ''Partition drop completed: '' + CAST(@records_disposed AS VARCHAR) + '' records disposed'';
    END
    ELSE
    BEGIN
        -- Fall back to batch deletion
        EXEC control.sp_Dispose_Records_Batch_Delete @archive_schema, @archive_table, @cutoff_date, @batch_id;
        RETURN;
    END
    ';
    
    EXEC sp_executesql @sql,
        N'@cutoff_date DATE, @records_disposed BIGINT OUTPUT',
        @cutoff_date = @disposal_cutoff_date,
        @records_disposed = @records_disposed OUTPUT;
    
    -- Update disposal_tracking with final results
    DECLARE @duration_ms INT = DATEDIFF(MILLISECOND, @start_time, GETDATE());
    UPDATE control.archive_disposal_tracking
    SET records_disposed = @records_disposed,
        operation_status = 'SUCCESS',
        completed_at = GETDATE(),
        duration_ms = @duration_ms
    WHERE batch_id = @batch_id;
    
    -- Log to archival_execution_log
    INSERT INTO control.archival_execution_log (
        batch_id, operation, table_name,
        records_affected, status, execution_end
    ) VALUES (
        @batch_id, 'DISPOSAL', @archive_table,
        @records_disposed, 'SUCCESS', GETDATE()
    );
    
    PRINT 'Partition drop completed: ' + CAST(@records_disposed AS VARCHAR) + ' records disposed in ' + CAST(@duration_ms AS VARCHAR) + 'ms';
END;
GO

-- ===========================================
-- PROCEDURE: Set compliance hold
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Set_Compliance_Hold
    @archive_schema VARCHAR(100),
    @archive_table VARCHAR(100),
    @hold_enabled BIT,
    @compliance_reason NVARCHAR(MAX),
    @approved_by VARCHAR(100)
AS
BEGIN
    SET NOCOUNT ON;
    
    -- Prevent disposal for tables under legal hold or audit
    UPDATE control.archive_disposal_tracking
    SET compliance_hold = @hold_enabled,
        compliance_reason = @compliance_reason,
        disposal_approved_by = @approved_by,
        disposal_approved_date = GETDATE()
    WHERE archive_schema = @archive_schema
      AND archive_table = @archive_table
      AND operation_status = 'PENDING';
    
    PRINT 'Compliance hold ' + CASE WHEN @hold_enabled = 1 THEN 'enabled' ELSE 'disabled' END + 
          ' for ' + @archive_schema + '.' + @archive_table;
END;
GO

-- ===========================================
-- PROCEDURE: Master disposal orchestration
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Execute_Disposal_Workflow
    @batch_id UNIQUEIDENTIFIER
AS
BEGIN
    SET NOCOUNT ON;
    
    -- Get all archive table versions eligible for disposal
    DECLARE @tables TABLE (
        archive_schema VARCHAR(100),
        archive_table VARCHAR(200),
        source_database VARCHAR(100),
        schema_version INT,
        retention_years INT,
        disposal_method VARCHAR(50),
        disposal_enabled BIT
    );
    
    INSERT INTO @tables
    SELECT 
        atr.archive_schema,
        atr.archive_table,
        atr.source_database,
        atr.schema_version,
        atr.retention_years,
        COALESCE(atl.disposal_method, 'BATCH_DELETE'),
        atr.disposal_enabled
    FROM control.archive_table_registry atr
    LEFT JOIN control.archival_table_list atl 
        ON atr.source_database = atl.source_database 
        AND atr.source_table = atl.table_name
    WHERE atr.disposal_enabled = 1 
    AND atr.is_active = 1;
    
    -- Process each table version
    DECLARE @archive_schema VARCHAR(100);
    DECLARE @archive_table VARCHAR(200);
    DECLARE @source_database VARCHAR(100);
    DECLARE @schema_version INT;
    DECLARE @retention_years INT;
    DECLARE @disposal_method VARCHAR(50);
    DECLARE @records_identified BIGINT;
    DECLARE @disposal_cutoff_date DATE;
    
    DECLARE disposal_cursor CURSOR FOR
    SELECT archive_schema, archive_table, source_database, schema_version, retention_years, disposal_method
    FROM @tables;
    
    OPEN disposal_cursor;
    FETCH NEXT FROM disposal_cursor 
    INTO @archive_schema, @archive_table, @source_database, @schema_version, @retention_years, @disposal_method;
    
    WHILE @@FETCH_STATUS = 0
    BEGIN
        PRINT 'Processing disposal for ' + @archive_schema + '.' + @archive_table + ' (v' + CAST(@schema_version AS VARCHAR) + ')';
        
        -- Identify records for disposal
        EXEC control.sp_Identify_Records_For_Disposal
            @archive_schema, @archive_table, @retention_years, @batch_id,
            @records_identified OUTPUT, @disposal_cutoff_date OUTPUT,
            @source_database;
        
        -- Skip if no records to dispose
        IF @records_identified > 0
        BEGIN
            -- Check for compliance hold
            IF EXISTS (
                SELECT 1 FROM control.archive_disposal_tracking
                WHERE batch_id = @batch_id AND compliance_hold = 1
            )
            BEGIN
                PRINT 'Skipping disposal for ' + @archive_schema + '.' + @archive_table + ' due to compliance hold';
                
                UPDATE control.archive_disposal_tracking
                SET operation_status = 'CANCELLED'
                WHERE batch_id = @batch_id;
            END
            ELSE
            BEGIN
                -- Execute disposal based on method
                IF @disposal_method = 'PARTITION_DROP'
                    EXEC control.sp_Dispose_Records_Partition_Drop
                        @archive_schema, @archive_table, @disposal_cutoff_date, @batch_id;
                ELSE
                    EXEC control.sp_Dispose_Records_Batch_Delete
                        @archive_schema, @archive_table, @disposal_cutoff_date, @batch_id;
            END
        END
        ELSE
        BEGIN
            PRINT 'No records to dispose for ' + @archive_schema + '.' + @archive_table;
            
            UPDATE control.archive_disposal_tracking
            SET operation_status = 'SUCCESS',
                records_disposed = 0,
                completed_at = GETDATE()
            WHERE batch_id = @batch_id;
        END
        
        FETCH NEXT FROM disposal_cursor 
        INTO @archive_schema, @archive_table, @source_database, @schema_version, @retention_years, @disposal_method;
    END
    
    CLOSE disposal_cursor;
    DEALLOCATE disposal_cursor;
    
    PRINT 'Disposal workflow completed for batch ' + CAST(@batch_id AS VARCHAR(36));
END;
GO

PRINT 'Disposal procedures created successfully';
