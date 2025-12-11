-- 07_create_stored_procedures.sql
-- Create core stored procedures for archival operations

USE control_db;
GO

-- Generic eligibility marking procedure
CREATE PROCEDURE control.sp_Mark_Table_Archival_Eligible
    @source_db VARCHAR(100),
    @schema VARCHAR(50),
    @table VARCHAR(100)
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @pk_columns VARCHAR(500);
    DECLARE @archival_logic VARCHAR(50);
    DECLARE @join_clause VARCHAR(500);
    DECLARE @months_retention INT;
    DECLARE @table_type VARCHAR(20);
    DECLARE @date_column VARCHAR(100);
    DECLARE @years_retention INT;
    
    -- Get configuration
    SELECT 
        @pk_columns = primary_key_columns,
        @archival_logic = archival_logic,
        @join_clause = join_to_contract,
        @months_retention = months_retention,
        @table_type = table_type,
        @date_column = date_column,
        @years_retention = years_retention_archive
    FROM control.archival_table_config
    WHERE source_database = @source_db AND table_schema = @schema AND table_name = @table AND active = 1;
    
    IF @pk_columns IS NULL
    BEGIN
        PRINT 'Table not configured: ' + @source_db + '.' + @schema + '.' + @table;
        RETURN;
    END
    
    -- Build dynamic SQL based on archival logic
    IF @archival_logic = 'CONTRACT_MATURITY'
    BEGIN
        -- Mark based on contract maturity (13+ months post-maturity)
        SET @sql = '
        INSERT INTO control.archival_marker (source_database, table_schema, table_name, primary_key_hash, primary_key_values, contractId, archival_eligible, retention_expiry_date)
        SELECT 
            ''' + @source_db + ''',
            ''' + @schema + ''',
            ''' + @table + ''',
            HASHBYTES(''SHA2_256'', ' + control.fn_Build_PK_String(@pk_columns, 't') + '),
            ' + control.fn_Build_PK_String(@pk_columns, 't') + ',
            c.contractId,
            CASE WHEN DATEDIFF(MONTH, c.maturity_date, GETDATE()) >= ' + CAST(@months_retention AS VARCHAR) + ' THEN 1 ELSE 0 END,
            DATEADD(YEAR, ' + CAST(@years_retention AS VARCHAR) + ', GETDATE())
        FROM ' + QUOTENAME(@source_db) + '.' + QUOTENAME(@schema) + '.' + QUOTENAME(@table) + ' t
        ' + @join_clause + '
        WHERE NOT EXISTS (
            SELECT 1 FROM control.archival_marker m 
            WHERE m.source_database = ''' + @source_db + ''' 
              AND m.table_schema = ''' + @schema + ''' 
              AND m.table_name = ''' + @table + '''
              AND m.primary_key_hash = HASHBYTES(''SHA2_256'', ' + control.fn_Build_PK_String(@pk_columns, 't') + ')
        )
        AND c.status = ''MATURED'';
        
        -- Update existing markers
        UPDATE m
        SET m.archival_eligible = 1, m.marked_date = GETDATE()
        FROM control.archival_marker m
        INNER JOIN ' + QUOTENAME(@source_db) + '.' + QUOTENAME(@schema) + '.' + QUOTENAME(@table) + ' t 
            ON m.primary_key_hash = HASHBYTES(''SHA2_256'', ' + control.fn_Build_PK_String(@pk_columns, 't') + ')
        ' + @join_clause + '
        WHERE m.source_database = ''' + @source_db + ''' 
          AND m.table_schema = ''' + @schema + ''' 
          AND m.table_name = ''' + @table + '''
          AND m.archival_eligible = 0
          AND c.status = ''MATURED''
          AND DATEDIFF(MONTH, c.maturity_date, GETDATE()) >= ' + CAST(@months_retention AS VARCHAR) + ';';
    END
    ELSE IF @archival_logic = 'DATE_BASED'
    BEGIN
        -- Mark based on date column
        SET @sql = '
        INSERT INTO control.archival_marker (source_database, table_schema, table_name, primary_key_hash, primary_key_values, archival_eligible, retention_expiry_date)
        SELECT 
            ''' + @source_db + ''',
            ''' + @schema + ''',
            ''' + @table + ''',
            HASHBYTES(''SHA2_256'', ' + control.fn_Build_PK_String(@pk_columns, 't') + '),
            ' + control.fn_Build_PK_String(@pk_columns, 't') + ',
            CASE WHEN DATEDIFF(MONTH, t.' + @date_column + ', GETDATE()) >= ' + CAST(@months_retention AS VARCHAR) + ' THEN 1 ELSE 0 END,
            DATEADD(YEAR, ' + CAST(@years_retention AS VARCHAR) + ', GETDATE())
        FROM ' + QUOTENAME(@source_db) + '.' + QUOTENAME(@schema) + '.' + QUOTENAME(@table) + ' t
        WHERE NOT EXISTS (
            SELECT 1 FROM control.archival_marker m 
            WHERE m.source_database = ''' + @source_db + ''' 
              AND m.table_schema = ''' + @schema + ''' 
              AND m.table_name = ''' + @table + '''
              AND m.primary_key_hash = HASHBYTES(''SHA2_256'', ' + control.fn_Build_PK_String(@pk_columns, 't') + ')
        );';
    END
    
    EXEC sp_executesql @sql;
    
    PRINT 'Marked records for ' + @source_db + '.' + @schema + '.' + @table;
END;
GO

-- Generic bulk copy archival procedure
CREATE PROCEDURE control.sp_Archive_Table_Bulk_Copy
    @batch_id UNIQUEIDENTIFIER,
    @source_db VARCHAR(100),
    @table_schema VARCHAR(50),
    @table_name VARCHAR(100)
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @src NVARCHAR(512), @dst NVARCHAR(512);
    DECLARE @pk_csv VARCHAR(500);
    DECLARE @years_retention INT;
    
    -- Build source and destination names
    EXEC control.sp_Fqn @source_db, @table_schema, @table_name, @out=@src OUTPUT;
    SET @dst = N'archive_db.' + QUOTENAME(@source_db) + N'.' + QUOTENAME(@table_name);
    
    -- Get configuration
    SELECT @pk_csv = primary_key_columns, @years_retention = years_retention_archive
    FROM control.archival_table_config
    WHERE source_database=@source_db AND table_schema=@table_schema AND table_name=@table_name;
    
    -- Build column list excluding archive-only metadata
    DECLARE @cols NVARCHAR(MAX) = (
        SELECT STRING_AGG(QUOTENAME(name), ',')
        FROM sys.columns c
        JOIN sys.tables t ON t.object_id=c.object_id
        JOIN sys.schemas s ON s.schema_id=t.schema_id
        WHERE s.name=@table_schema AND t.name=@table_name
          AND name NOT IN ('archived_date','archive_batch_id','retention_expiry_date')
    );
    
    DECLARE @pk_join NVARCHAR(MAX) = control.fn_Build_PK_Join(@pk_csv, 's', 'd');
    
    -- Insert with idempotent check
    DECLARE @insert NVARCHAR(MAX) = N'INSERT INTO ' + @dst +
        N' (' + @cols + N', archived_date, archive_batch_id, retention_expiry_date) ' +
        N' SELECT ' + @cols + N', GETDATE(), @batch_id, DATEADD(YEAR, @years_retention, GETDATE())' +
        N' FROM ' + @src + N' s ' +
        N' INNER JOIN control_db.control.archival_marker m ON m.source_database = @source_db ' +
        N'   AND m.table_schema = @table_schema AND m.table_name = @table_name ' +
        N'   AND m.primary_key_hash = HASHBYTES(''SHA2_256'', ' + control.fn_Build_PK_String(@pk_csv, 's') + ') ' +
        N'   AND m.archival_eligible = 1 AND m.archived_date IS NULL ' +
        N' WHERE NOT EXISTS (SELECT 1 FROM ' + @dst + N' d WHERE ' + @pk_join + N');';
    
    EXEC sp_executesql @insert,
        N'@batch_id UNIQUEIDENTIFIER, @source_db VARCHAR(100), @table_schema VARCHAR(50), @table_name VARCHAR(100), @years_retention INT',
        @batch_id=@batch_id, @source_db=@source_db, @table_schema=@table_schema, @table_name=@table_name, @years_retention=@years_retention;
    
    -- Update markers
    UPDATE control.archival_marker
    SET archived_date = GETDATE()
    WHERE source_database = @source_db AND table_schema = @table_schema AND table_name = @table_name
      AND archival_eligible = 1 AND archived_date IS NULL;
    
    PRINT 'Bulk copy archival completed for ' + @source_db + '.' + @table_schema + '.' + @table_name;
END;
GO

-- Disposal procedure
CREATE PROCEDURE control.sp_Dispose_Expired_Records
    @batch_id UNIQUEIDENTIFIER
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @deleted_count INT = 0;
    DECLARE @source_db VARCHAR(100), @schema VARCHAR(50), @table VARCHAR(100);
    
    -- Process each configured table
    DECLARE table_cursor CURSOR FOR
        SELECT source_database, table_schema, table_name
        FROM control.archival_table_config
        WHERE active = 1 AND archival_enabled = 1;
    
    OPEN table_cursor;
    FETCH NEXT FROM table_cursor INTO @source_db, @schema, @table;
    
    WHILE @@FETCH_STATUS = 0
    BEGIN
        DECLARE @delete_sql NVARCHAR(MAX) = N'
        DELETE TOP (10000) 
        FROM archive_db.' + QUOTENAME(@source_db) + N'.' + QUOTENAME(@table) + N'
        WHERE retention_expiry_date < GETDATE();';
        
        EXEC sp_executesql @delete_sql;
        SET @deleted_count = @deleted_count + @@ROWCOUNT;
        
        FETCH NEXT FROM table_cursor INTO @source_db, @schema, @table;
    END
    
    CLOSE table_cursor;
    DEALLOCATE table_cursor;
    
    -- Log disposal
    INSERT INTO control.archival_execution_log (batch_id, operation, records_affected, execution_end, status)
    VALUES (@batch_id, 'DISPOSE', @deleted_count, GETDATE(), 'SUCCESS');
    
    PRINT 'Disposed ' + CAST(@deleted_count AS VARCHAR) + ' expired records';
END;
GO

PRINT 'Stored procedures created successfully';
