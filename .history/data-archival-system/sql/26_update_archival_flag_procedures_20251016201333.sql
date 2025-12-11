-- 26_update_archival_flag_procedures.sql
-- Procedures to manage archival_flag column in source tables

USE control_db;
GO

-- Procedure to mark records for archival by setting archival_flag = 1
CREATE PROCEDURE control.sp_Mark_Archival_Eligible
    @batch_id UNIQUEIDENTIFIER,
    @source_db VARCHAR(100),
    @table_schema VARCHAR(50),
    @table_name VARCHAR(100)
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @archival_logic VARCHAR(50);
    DECLARE @join_clause VARCHAR(500);
    DECLARE @months_retention INT;
    DECLARE @date_column VARCHAR(100);
    DECLARE @start_time DATETIME = GETDATE();
    DECLARE @rows_marked INT = 0;
    
    -- Get configuration
    SELECT 
        @archival_logic = archival_logic,
        @join_clause = join_to_contract,
        @months_retention = months_retention,
        @date_column = date_column
    FROM control.archival_table_config
    WHERE source_database = @source_db 
      AND table_schema = @table_schema 
      AND table_name = @table_name 
      AND active = 1;
    
    IF @archival_logic IS NULL
    BEGIN
        PRINT 'Table not configured: ' + @source_db + '.' + @table_schema + '.' + @table_name;
        RETURN;
    END
    
    -- Build dynamic SQL based on archival logic
    IF @archival_logic = 'CONTRACT_MATURITY'
    BEGIN
        -- Mark based on contract maturity (13+ months post-maturity)
        SET @sql = '
        UPDATE t
        SET t.archival_flag = 1
        FROM ' + QUOTENAME(@source_db) + '.' + QUOTENAME(@table_schema) + '.' + QUOTENAME(@table_name) + ' t
        ' + @join_clause + '
        WHERE t.archival_flag = 0
          AND c.status = ''MATURED''
          AND DATEDIFF(MONTH, c.maturity_date, GETDATE()) >= ' + CAST(@months_retention AS VARCHAR) + ';';
    END
    ELSE IF @archival_logic = 'DATE_BASED'
    BEGIN
        -- Mark based on date column
        SET @sql = '
        UPDATE t
        SET t.archival_flag = 1
        FROM ' + QUOTENAME(@source_db) + '.' + QUOTENAME(@table_schema) + '.' + QUOTENAME(@table_name) + ' t
        WHERE t.archival_flag = 0
          AND DATEDIFF(MONTH, t.' + @date_column + ', GETDATE()) >= ' + CAST(@months_retention AS VARCHAR) + ';';
    END
    
    -- Execute the update
    EXEC sp_executesql @sql;
    SET @rows_marked = @@ROWCOUNT;
    
    -- Log maintenance activity
    EXEC control.sp_Log_Maintenance_Activity
        @maintenance_type = 'MARKING',
        @filegroup_name = 'PRIMARY',
        @start_time = @start_time,
        @end_time = GETDATE(),
        @status = 'SUCCESS',
        @records_processed = @rows_marked;
    
    PRINT 'Marked ' + CAST(@rows_marked AS VARCHAR) + ' records for ' + @source_db + '.' + @table_schema + '.' + @table_name;
END;
GO

-- Procedure to delete archived records from source tables
CREATE PROCEDURE control.sp_Delete_Archived_Records
    @batch_id UNIQUEIDENTIFIER,
    @source_db VARCHAR(100),
    @table_schema VARCHAR(50),
    @table_name VARCHAR(100)
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @start_time DATETIME = GETDATE();
    DECLARE @rows_deleted INT = 0;
    
    -- Delete records where archival_flag = 1 (already archived)
    SET @sql = '
    DELETE FROM ' + QUOTENAME(@source_db) + '.' + QUOTENAME(@table_schema) + '.' + QUOTENAME(@table_name) + '
    WHERE archival_flag = 1;';
    
    -- Execute the delete
    EXEC sp_executesql @sql;
    SET @rows_deleted = @@ROWCOUNT;
    
    -- Log maintenance activity
    EXEC control.sp_Log_Maintenance_Activity
        @maintenance_type = 'DELETE_SOURCE',
        @filegroup_name = 'PRIMARY',
        @start_time = @start_time,
        @end_time = GETDATE(),
        @status = 'SUCCESS',
        @records_processed = @rows_deleted;
    
    PRINT 'Deleted ' + CAST(@rows_deleted AS VARCHAR) + ' archived records from ' + @source_db + '.' + @table_schema + '.' + @table_name;
END;
GO

-- Procedure to cleanup old archives from source database (move to archive_db)
CREATE PROCEDURE control.sp_Cleanup_Old_Archives
    @months_old INT = 3,
    @batch_size INT = 1000000
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @source_db VARCHAR(100);
    DECLARE @table_name VARCHAR(100);
    DECLARE @start_time DATETIME = GETDATE();
    
    PRINT 'Starting cleanup of archives older than ' + CAST(@months_old AS VARCHAR) + ' months...';
    
    -- Create temporary table for tracking
    CREATE TABLE #ArchivedTables (
        source_database VARCHAR(100),
        table_name VARCHAR(100),
        archived_date DATETIME
    );
    
    -- Find archived tables older than threshold (example logic)
    INSERT INTO #ArchivedTables (source_database, table_name, archived_date)
    SELECT DISTINCT 
        source_database,
        base_table_name,
        archived_date
    FROM control.archived_tables
    WHERE moved_to_archive_db = 0
      AND DATEDIFF(MONTH, archived_date, GETDATE()) >= @months_old;
    
    -- Process each table
    DECLARE table_cursor CURSOR FOR
        SELECT source_database, table_name FROM #ArchivedTables;
    
    OPEN table_cursor;
    FETCH NEXT FROM table_cursor INTO @source_db, @table_name;
    
    WHILE @@FETCH_STATUS = 0
    BEGIN
        PRINT 'Moving old archives for ' + @source_db + '.' + @table_name + ' to archive_db...';
        
        -- Logic to move data would go here (simplified for now)
        -- In real implementation, this would:
        -- 1. Copy data to archive_db
        -- 2. Verify data integrity
        -- 3. Delete from source
        -- 4. Update control.archived_tables
        
        FETCH NEXT FROM table_cursor INTO @source_db, @table_name;
    END
    
    CLOSE table_cursor;
    DEALLOCATE table_cursor;
    
    DROP TABLE #ArchivedTables;
    
    -- Log maintenance activity
    EXEC control.sp_Log_Maintenance_Activity
        @maintenance_type = 'CLEANUP',
        @filegroup_name = 'ARCHIVE_FG',
        @start_time = @start_time,
        @end_time = GETDATE(),
        @status = 'SUCCESS';
    
    PRINT 'Cleanup completed';
END;
GO

-- Procedure to add archival_flag to a table (for new tables)
CREATE PROCEDURE control.sp_Add_Archival_Flag
    @source_db VARCHAR(100),
    @table_schema VARCHAR(50),
    @table_name VARCHAR(100)
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    
    -- Check if column already exists
    DECLARE @column_exists BIT = 0;
    SET @sql = '
    SELECT @exists = CASE WHEN EXISTS (
        SELECT 1 FROM ' + QUOTENAME(@source_db) + '.sys.columns c
        JOIN ' + QUOTENAME(@source_db) + '.sys.tables t ON c.object_id = t.object_id
        JOIN ' + QUOTENAME(@source_db) + '.sys.schemas s ON t.schema_id = s.schema_id
        WHERE s.name = @table_schema AND t.name = @table_name AND c.name = ''archival_flag''
    ) THEN 1 ELSE 0 END';
    
    EXEC sp_executesql @sql, 
        N'@table_schema VARCHAR(50), @table_name VARCHAR(100), @exists BIT OUTPUT',
        @table_schema = @table_schema, 
        @table_name = @table_name, 
        @exists = @column_exists OUTPUT;
    
    IF @column_exists = 1
    BEGIN
        PRINT 'archival_flag already exists on ' + @source_db + '.' + @table_schema + '.' + @table_name;
        RETURN;
    END
    
    -- Add the column with default value 0
    SET @sql = '
    ALTER TABLE ' + QUOTENAME(@source_db) + '.' + QUOTENAME(@table_schema) + '.' + QUOTENAME(@table_name) + '
    ADD archival_flag BIT DEFAULT 0 NOT NULL;';
    
    EXEC sp_executesql @sql;
    
    PRINT 'Added archival_flag to ' + @source_db + '.' + @table_schema + '.' + @table_name;
END;
GO

-- Procedure to remove archival_flag from a table (cleanup if needed)
CREATE PROCEDURE control.sp_Remove_Archival_Flag
    @source_db VARCHAR(100),
    @table_schema VARCHAR(50),
    @table_name VARCHAR(100)
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    
    -- Drop the column
    SET @sql = '
    ALTER TABLE ' + QUOTENAME(@source_db) + '.' + QUOTENAME(@table_schema) + '.' + QUOTENAME(@table_name) + '
    DROP COLUMN archival_flag;';
    
    BEGIN TRY
        EXEC sp_executesql @sql;
        PRINT 'Removed archival_flag from ' + @source_db + '.' + @table_schema + '.' + @table_name;
    END TRY
    BEGIN CATCH
        PRINT 'ERROR removing archival_flag: ' + ERROR_MESSAGE();
    END CATCH
END;
GO

-- Procedure to reset archival_flag for testing or recovery
CREATE PROCEDURE control.sp_Reset_Archival_Flags
    @source_db VARCHAR(100),
    @table_schema VARCHAR(50),
    @table_name VARCHAR(100)
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    
    -- Reset all flags to 0
    SET @sql = '
    UPDATE ' + QUOTENAME(@source_db) + '.' + QUOTENAME(@table_schema) + '.' + QUOTENAME(@table_name) + '
    SET archival_flag = 0;';
    
    EXEC sp_executesql @sql;
    
    PRINT 'Reset archival_flag for ' + @source_db + '.' + @table_schema + '.' + @table_name;
END;
GO

PRINT 'Archival flag management procedures created successfully';
