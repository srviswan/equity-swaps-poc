-- 09_fix_staging_procedures.sql
-- Fix staging table creation for partition switching

USE control_db;
GO

-- ===========================================
-- PROCEDURE: Create staging table for any table
-- Dynamically creates staging table with same structure
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Create_Staging_Table_For_Partition_Switch
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @staging_table_name VARCHAR(200)
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @drop_sql NVARCHAR(MAX);
    DECLARE @create_sql NVARCHAR(MAX);
    
    -- Step 1: Drop staging table if exists
    SET @drop_sql = '
    USE ' + QUOTENAME(@source_database) + ';
    IF EXISTS (SELECT * FROM sys.tables WHERE name = ''' + @staging_table_name + ''')
        DROP TABLE dbo.' + QUOTENAME(@staging_table_name) + ';
    ';
    EXEC sp_executesql @drop_sql;
    
    -- Step 2: Create staging table with same structure as base table
    SET @create_sql = '
    USE ' + QUOTENAME(@source_database) + ';
    
    -- Create staging table with same structure as base table
    SELECT TOP 0 *
    INTO dbo.' + QUOTENAME(@staging_table_name) + '
    FROM dbo.' + QUOTENAME(@table_name) + ';
    
    -- Add constraint to ensure only archival_flag = 1 records
    ALTER TABLE dbo.' + QUOTENAME(@staging_table_name) + '
    ADD CONSTRAINT CK_' + REPLACE(@staging_table_name, '_', '_') + '_archival_flag 
    CHECK (archival_flag = 1);
    ';
    
    EXEC sp_executesql @create_sql;
    
    PRINT 'Created staging table: ' + @source_database + '.dbo.' + @staging_table_name;
END;
GO

-- ===========================================
-- PROCEDURE: Fixed Move to Monthly Archival
-- Uses proper staging table creation
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Move_To_Monthly_Archival_Fixed
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @archival_month VARCHAR(6),
    @batch_id UNIQUEIDENTIFIER
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @monthly_table_name VARCHAR(200);
    DECLARE @monthly_table_pattern VARCHAR(200);
    DECLARE @staging_table_name VARCHAR(200);
    DECLARE @records_moved INT = 0;
    DECLARE @error_msg NVARCHAR(MAX);
    
    -- Get pattern from configuration
    SELECT @monthly_table_pattern = monthly_archival_table_pattern
    FROM control.archival_table_list
    WHERE source_database = @source_database AND table_name = @table_name;
    
    -- Generate table names
    SET @monthly_table_name = REPLACE(@monthly_table_pattern, '{table_name}', @table_name);
    SET @monthly_table_name = REPLACE(@monthly_table_name, '{YYYYMM}', @archival_month);
    SET @staging_table_name = @monthly_table_name + '_Staging';
    
    BEGIN TRY
        -- Step 1: Create staging table with proper structure
        EXEC control.sp_Create_Staging_Table_For_Partition_Switch 
            @source_database, @table_name, @staging_table_name;
        
        -- Step 2: Create monthly archival table if not exists
        EXEC control.sp_Create_Monthly_Archival_Table @source_database, @table_name, @archival_month;
        
        -- Step 3: Move records for this month from base table to staging table
        SET @sql = '
        USE ' + QUOTENAME(@source_database) + ';
        
        INSERT INTO dbo.' + QUOTENAME(@staging_table_name) + '
        SELECT *
        FROM dbo.' + QUOTENAME(@table_name) + '
        WHERE archival_flag = 1 
          AND archival_month = ''' + @archival_month + ''';
        ';
        
        EXEC sp_executesql @sql;
        SET @records_moved = @@ROWCOUNT;
        
        -- Step 4: Move records from staging to monthly table
        SET @sql = '
        USE ' + QUOTENAME(@source_database) + ';
        
        INSERT INTO dbo.' + QUOTENAME(@monthly_table_name) + '
        SELECT *
        FROM dbo.' + QUOTENAME(@staging_table_name) + ';
        ';
        
        EXEC sp_executesql @sql;
        
        -- Step 5: Delete records from base table
        SET @sql = '
        USE ' + QUOTENAME(@source_database) + ';
        
        DELETE FROM dbo.' + QUOTENAME(@table_name) + '
        WHERE archival_flag = 1 
          AND archival_month = ''' + @archival_month + ''';
        ';
        
        EXEC sp_executesql @sql;
        
        -- Step 6: Drop staging table
        SET @sql = '
        USE ' + QUOTENAME(@source_database) + ';
        DROP TABLE dbo.' + QUOTENAME(@staging_table_name) + ';
        ';
        
        EXEC sp_executesql @sql;
        
        -- Update tracking
        UPDATE control.monthly_archival_tracking
        SET record_count = @records_moved
        WHERE source_database = @source_database 
          AND base_table_name = @table_name
          AND archival_month = @archival_month;
        
        -- Log success
        INSERT INTO control.archival_execution_log (
            batch_id, operation, source_database, table_name, archival_month,
            records_affected, status, execution_end
        )
        VALUES (
            @batch_id, 'PARTITION_SWITCH_FIXED', @source_database, @table_name, @archival_month,
            @records_moved, 'SUCCESS', GETDATE()
        );
        
        PRINT 'Successfully moved ' + CAST(@records_moved AS VARCHAR) + ' records to ' + @monthly_table_name;
        
    END TRY
    BEGIN CATCH
        SET @error_msg = ERROR_MESSAGE();
        
        -- Log error
        INSERT INTO control.archival_execution_log (
            batch_id, operation, source_database, table_name, archival_month,
            records_affected, status, execution_end, error_message
        )
        VALUES (
            @batch_id, 'PARTITION_SWITCH_FAILED', @source_database, @table_name, @archival_month,
            0, 'FAILED', GETDATE(), @error_msg
        );
        
        -- Clean up staging table if exists
        BEGIN TRY
            SET @sql = '
            USE ' + QUOTENAME(@source_database) + ';
            IF EXISTS (SELECT * FROM sys.tables WHERE name = ''' + @staging_table_name + ''')
                DROP TABLE dbo.' + QUOTENAME(@staging_table_name) + ';
            ';
            EXEC sp_executesql @sql;
        END TRY
        BEGIN CATCH
            -- Ignore cleanup errors
        END CATCH
        
        PRINT 'ERROR: ' + @error_msg;
    END CATCH
END;
GO

PRINT 'Fixed staging procedures created successfully';
