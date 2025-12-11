-- 06_create_procedures.sql
-- Create stored procedures for archival operations

USE control_db;
GO

-- ===========================================
-- PROCEDURE 1: Mark records for archival
-- Sets archival_flag = 1 and archival_month
-- ===========================================
CREATE PROCEDURE control.sp_Mark_Records_For_Archival
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @batch_id UNIQUEIDENTIFIER
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @date_column VARCHAR(100);
    DECLARE @months_before_archival INT;
    DECLARE @archival_type VARCHAR(50);
    DECLARE @records_marked INT = 0;
    
    -- Get configuration
    SELECT 
        @date_column = date_column,
        @months_before_archival = months_before_archival,
        @archival_type = archival_type
    FROM control.archival_table_list
    WHERE source_database = @source_database 
      AND table_name = @table_name
      AND archival_enabled = 1;
    
    IF @date_column IS NULL
    BEGIN
        PRINT 'Table not configured or not enabled: ' + @source_database + '.' + @table_name;
        RETURN;
    END
    
    -- Mark records for archival (DATE_BASED logic)
    IF @archival_type = 'DATE_BASED'
    BEGIN
        SET @sql = '
        UPDATE ' + QUOTENAME(@source_database) + '.dbo.' + QUOTENAME(@table_name) + '
        SET archival_flag = 1,
            archival_month = FORMAT(' + @date_column + ', ''yyyyMM'')
        WHERE archival_flag = 0
          AND ' + @date_column + ' < DATEADD(MONTH, -' + CAST(@months_before_archival AS VARCHAR) + ', GETDATE());
        ';
        
        EXEC sp_executesql @sql;
        SET @records_marked = @@ROWCOUNT;
    END
    
    -- Log execution
    INSERT INTO control.archival_execution_log (
        batch_id, operation, source_database, table_name,
        records_affected, status, execution_end, duration_seconds
    )
    VALUES (
        @batch_id, 'MARK', @source_database, @table_name,
        @records_marked, 'SUCCESS', GETDATE(), 
        DATEDIFF(SECOND, GETDATE(), GETDATE())
    );
    
    PRINT 'Marked ' + CAST(@records_marked AS VARCHAR) + ' records in ' + @source_database + '.' + @table_name;
END;
GO

-- ===========================================
-- PROCEDURE 2: Create monthly archival table
-- Creates a new monthly archival table if not exists
-- ===========================================
CREATE PROCEDURE control.sp_Create_Monthly_Archival_Table
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @archival_month VARCHAR(6) -- YYYYMM
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @monthly_table_name VARCHAR(200);
    DECLARE @monthly_table_pattern VARCHAR(200);
    
    -- Get pattern from configuration
    SELECT @monthly_table_pattern = monthly_archival_table_pattern
    FROM control.archival_table_list
    WHERE source_database = @source_database AND table_name = @table_name;
    
    -- Generate monthly table name
    SET @monthly_table_name = REPLACE(@monthly_table_pattern, '{table_name}', @table_name);
    SET @monthly_table_name = REPLACE(@monthly_table_name, '{YYYYMM}', @archival_month);
    
    -- Check if table already exists
    SET @sql = '
    IF NOT EXISTS (
        SELECT * FROM ' + QUOTENAME(@source_database) + '.sys.tables 
        WHERE name = ''' + @monthly_table_name + '''
    )
    BEGIN
        SELECT * 
        INTO ' + QUOTENAME(@source_database) + '.dbo.' + QUOTENAME(@monthly_table_name) + '
        FROM ' + QUOTENAME(@source_database) + '.dbo.' + QUOTENAME(@table_name) + '
        WHERE 1 = 0; -- Create empty table with same structure
    END
    ';
    
    EXEC sp_executesql @sql;
    
    -- Track the monthly archival table
    IF NOT EXISTS (
        SELECT * FROM control.monthly_archival_tracking
        WHERE source_database = @source_database 
          AND base_table_name = @table_name
          AND archival_month = @archival_month
    )
    BEGIN
        INSERT INTO control.monthly_archival_tracking (
            source_database, table_schema, base_table_name,
            archival_month, monthly_table_name
        )
        VALUES (
            @source_database, 'dbo', @table_name,
            @archival_month, @monthly_table_name
        );
    END
    
    PRINT 'Created/verified monthly archival table: ' + @monthly_table_name;
END;
GO

-- ===========================================
-- PROCEDURE 3: Move data to monthly archival table using PARTITION SWITCH
-- Much faster than INSERT/DELETE - metadata operation only
-- ===========================================
CREATE PROCEDURE control.sp_Move_To_Monthly_Archival
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
    
    -- Get pattern from configuration
    SELECT @monthly_table_pattern = monthly_archival_table_pattern
    FROM control.archival_table_list
    WHERE source_database = @source_database AND table_name = @table_name;
    
    -- Generate table names
    SET @monthly_table_name = REPLACE(@monthly_table_pattern, '{table_name}', @table_name);
    SET @monthly_table_name = REPLACE(@monthly_table_name, '{YYYYMM}', @archival_month);
    SET @staging_table_name = @monthly_table_name + '_Staging';
    
    -- Step 1: Create staging table with same structure
    SET @sql = 'EXEC ' + QUOTENAME(@source_database) + '.dbo.sp_Create_Staging_Table_For_Partition_Switch @staging_table_name = ''' + @staging_table_name + ''';';
    EXEC sp_executesql @sql;
    
    -- Step 2: PARTITION SWITCH - Move archival partition to staging table
    -- This is a metadata operation - very fast, no data movement!
    SET @sql = '
    USE ' + QUOTENAME(@source_database) + ';
    
    -- Get partition number for archival_flag = 1
    DECLARE @partition_number INT;
    SELECT @partition_number = $PARTITION.PF_' + @table_name + '_ArchivalFlag(1);
    
    -- Switch partition from base table to staging table
    ALTER TABLE dbo.' + QUOTENAME(@table_name) + '
    SWITCH PARTITION @partition_number
    TO dbo.' + QUOTENAME(@staging_table_name) + ';
    
    PRINT ''Partition switched to staging table'';
    ';
    
    BEGIN TRY
        EXEC sp_executesql @sql;
    END TRY
    BEGIN CATCH
        -- If partition switch fails, log error and exit
        DECLARE @error_msg NVARCHAR(MAX) = ERROR_MESSAGE();
        
        INSERT INTO control.archival_execution_log (
            batch_id, operation, source_database, table_name, archival_month,
            records_affected, status, execution_end, error_message
        )
        VALUES (
            @batch_id, 'PARTITION_SWITCH_FAILED', @source_database, @table_name, @archival_month,
            0, 'FAILED', GETDATE(), @error_msg
        );
        
        PRINT 'ERROR: Partition switch failed - ' + @error_msg;
        RETURN;
    END CATCH
    
    -- Step 3: Get count from staging table
    SET @sql = 'SELECT @count = COUNT(*) FROM ' + QUOTENAME(@source_database) + '.dbo.' + QUOTENAME(@staging_table_name) + ';';
    EXEC sp_executesql @sql, N'@count INT OUTPUT', @count = @records_moved OUTPUT;
    
    -- Step 4: Filter by archival_month and move to monthly table
    -- Ensure monthly table exists
    EXEC control.sp_Create_Monthly_Archival_Table @source_database, @table_name, @archival_month;
    
    -- Insert only the records for this archival_month into monthly table
    SET @sql = '
    INSERT INTO ' + QUOTENAME(@source_database) + '.dbo.' + QUOTENAME(@monthly_table_name) + '
    SELECT *
    FROM ' + QUOTENAME(@source_database) + '.dbo.' + QUOTENAME(@staging_table_name) + '
    WHERE archival_month = ''' + @archival_month + ''';
    ';
    EXEC sp_executesql @sql;
    
    -- Step 5: Move remaining records (other months) back to base table
    SET @sql = '
    INSERT INTO ' + QUOTENAME(@source_database) + '.dbo.' + QUOTENAME(@table_name) + '
    SELECT *
    FROM ' + QUOTENAME(@source_database) + '.dbo.' + QUOTENAME(@staging_table_name) + '
    WHERE archival_month != ''' + @archival_month + ''' OR archival_month IS NULL;
    ';
    EXEC sp_executesql @sql;
    
    -- Step 6: Drop staging table
    SET @sql = 'DROP TABLE ' + QUOTENAME(@source_database) + '.dbo.' + QUOTENAME(@staging_table_name) + ';';
    EXEC sp_executesql @sql;
    
    -- Update tracking
    UPDATE control.monthly_archival_tracking
    SET record_count = @records_moved
    WHERE source_database = @source_database 
      AND base_table_name = @table_name
      AND archival_month = @archival_month;
    
    -- Log execution
    INSERT INTO control.archival_execution_log (
        batch_id, operation, source_database, table_name, archival_month,
        records_affected, status, execution_end
    )
    VALUES (
        @batch_id, 'PARTITION_SWITCH', @source_database, @table_name, @archival_month,
        @records_moved, 'SUCCESS', GETDATE()
    );
    
    PRINT 'Partition switched: Moved ' + CAST(@records_moved AS VARCHAR) + ' records to ' + @monthly_table_name;
END;
GO

-- ===========================================
-- PROCEDURE 4: Move monthly archival table to archive DB
-- Moves entire monthly table to archive database
-- ===========================================
CREATE PROCEDURE control.sp_Move_To_Archive_DB
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
    DECLARE @archive_schema VARCHAR(100);
    DECLARE @archive_table VARCHAR(100);
    DECLARE @records_moved INT = 0;
    
    -- Get configuration
    SELECT 
        @monthly_table_pattern = monthly_archival_table_pattern,
        @archive_schema = archive_db_schema,
        @archive_table = archive_db_table
    FROM control.archival_table_list
    WHERE source_database = @source_database AND table_name = @table_name;
    
    -- Generate monthly table name
    SET @monthly_table_name = REPLACE(@monthly_table_pattern, '{table_name}', @table_name);
    SET @monthly_table_name = REPLACE(@monthly_table_name, '{YYYYMM}', @archival_month);
    
    -- Create archive schema if not exists
    SET @sql = '
    IF NOT EXISTS (SELECT * FROM archive_db.sys.schemas WHERE name = ''' + @archive_schema + ''')
    BEGIN
        EXEC(''CREATE SCHEMA ' + QUOTENAME(@archive_schema) + ''');
    END
    ';
    EXEC sp_executesql @sql;
    
    -- Create archive table if not exists
    SET @sql = '
    IF NOT EXISTS (
        SELECT * FROM archive_db.sys.tables t
        JOIN archive_db.sys.schemas s ON t.schema_id = s.schema_id
        WHERE s.name = ''' + @archive_schema + ''' AND t.name = ''' + @archive_table + '''
    )
    BEGIN
        SELECT *, GETDATE() AS archived_date, ''' + @archival_month + ''' AS archival_month
        INTO archive_db.' + QUOTENAME(@archive_schema) + '.' + QUOTENAME(@archive_table) + '
        FROM ' + QUOTENAME(@source_database) + '.dbo.' + QUOTENAME(@monthly_table_name) + '
        WHERE 1 = 0; -- Create empty table with structure
    END
    ';
    EXEC sp_executesql @sql;
    
    -- Move data to archive DB
    SET @sql = '
    INSERT INTO archive_db.' + QUOTENAME(@archive_schema) + '.' + QUOTENAME(@archive_table) + '
    SELECT *, GETDATE() AS archived_date, ''' + @archival_month + ''' AS archival_month
    FROM ' + QUOTENAME(@source_database) + '.dbo.' + QUOTENAME(@monthly_table_name) + ';
    ';
    
    EXEC sp_executesql @sql;
    SET @records_moved = @@ROWCOUNT;
    
    -- Drop monthly archival table after successful move
    IF @records_moved > 0
    BEGIN
        SET @sql = 'DROP TABLE ' + QUOTENAME(@source_database) + '.dbo.' + QUOTENAME(@monthly_table_name) + ';';
        EXEC sp_executesql @sql;
    END
    
    -- Update tracking
    UPDATE control.monthly_archival_tracking
    SET moved_to_archive_db = 1,
        archive_db_date = GETDATE()
    WHERE source_database = @source_database 
      AND base_table_name = @table_name
      AND archival_month = @archival_month;
    
    -- Log execution
    INSERT INTO control.archival_execution_log (
        batch_id, operation, source_database, table_name, archival_month,
        records_affected, status, execution_end
    )
    VALUES (
        @batch_id, 'MOVE_TO_ARCHIVE_DB', @source_database, @table_name, @archival_month,
        @records_moved, 'SUCCESS', GETDATE()
    );
    
    PRINT 'Moved ' + CAST(@records_moved AS VARCHAR) + ' records to archive_db.' + @archive_schema + '.' + @archive_table;
END;
GO

PRINT 'All stored procedures created successfully';
