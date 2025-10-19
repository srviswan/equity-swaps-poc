-- 08_schema_management_procedures.sql
-- Schema detection, validation, and versioning procedures

USE control_db;
GO

-- ===========================================
-- PROCEDURE: Get table schema information
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Get_Table_Schema_Info
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @schema_hash VARCHAR(32) OUTPUT,
    @column_list NVARCHAR(MAX) OUTPUT,
    @column_types NVARCHAR(MAX) OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @temp_table VARCHAR(100) = '#temp_schema_' + REPLACE(CAST(NEWID() AS VARCHAR(36)), '-', '');
    
    -- Create temporary table to hold schema information
    SET @sql = '
    USE ' + QUOTENAME(@source_database) + ';
    
    CREATE TABLE ' + @temp_table + ' (
        column_name VARCHAR(100),
        data_type VARCHAR(50),
        max_length INT,
        precision_val INT,
        scale_val INT,
        is_nullable VARCHAR(3),
        ordinal_position INT
    );
    
    INSERT INTO ' + @temp_table + '
    SELECT 
        COLUMN_NAME,
        DATA_TYPE,
        CHARACTER_MAXIMUM_LENGTH,
        NUMERIC_PRECISION,
        NUMERIC_SCALE,
        IS_NULLABLE,
        ORDINAL_POSITION
    FROM INFORMATION_SCHEMA.COLUMNS
    WHERE TABLE_NAME = ''' + @table_name + '''
    ORDER BY ORDINAL_POSITION;
    
    -- Generate schema hash
    SELECT @schema_hash = LOWER(CONVERT(VARCHAR(32), HASHBYTES(''MD5'', 
        STRING_AGG(
            column_name + ''|'' + data_type + ''|'' + 
            CAST(ISNULL(max_length, 0) AS VARCHAR) + ''|'' +
            CAST(ISNULL(precision_val, 0) AS VARCHAR) + ''|'' +
            CAST(ISNULL(scale_val, 0) AS VARCHAR) + ''|'' +
            is_nullable, 
            '',''
        ) WITHIN GROUP (ORDER BY ordinal_position)
    ), 2))
    FROM ' + @temp_table + ';
    
    -- Generate column list
    SELECT @column_list = STRING_AGG(QUOTENAME(column_name), '', '') WITHIN GROUP (ORDER BY ordinal_position)
    FROM ' + @temp_table + ';
    
    -- Generate column types
    SELECT @column_types = STRING_AGG(
        QUOTENAME(column_name) + '' '' + 
        CASE 
            WHEN data_type IN (''varchar'', ''char'', ''nvarchar'', ''nchar'') 
                THEN data_type + ''('' + CAST(max_length AS VARCHAR) + '')''
            WHEN data_type IN (''decimal'', ''numeric'') 
                THEN data_type + ''('' + CAST(precision_val AS VARCHAR) + '','' + CAST(scale_val AS VARCHAR) + '')''
            ELSE data_type
        END +
        CASE WHEN is_nullable = ''NO'' THEN '' NOT NULL'' ELSE '' NULL'' END,
        '', ''
    ) WITHIN GROUP (ORDER BY ordinal_position)
    FROM ' + @temp_table + ';
    
    DROP TABLE ' + @temp_table + ';
    ';
    
    EXEC sp_executesql @sql,
        N'@schema_hash VARCHAR(32) OUTPUT, @column_list NVARCHAR(MAX) OUTPUT, @column_types NVARCHAR(MAX) OUTPUT',
        @schema_hash = @schema_hash OUTPUT,
        @column_list = @column_list OUTPUT,
        @column_types = @column_types OUTPUT;
    
    PRINT 'Schema info extracted for ' + @source_database + '.' + @table_name + ' - Hash: ' + @schema_hash;
END;
GO

-- ===========================================
-- PROCEDURE: Detect schema changes
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Detect_Schema_Changes
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @change_detected BIT OUTPUT,
    @change_type VARCHAR(50) OUTPUT,
    @change_details NVARCHAR(MAX) OUTPUT,
    @old_version INT OUTPUT,
    @new_version INT OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @current_hash VARCHAR(32);
    DECLARE @current_column_list NVARCHAR(MAX);
    DECLARE @current_column_types NVARCHAR(MAX);
    DECLARE @last_hash VARCHAR(32);
    DECLARE @last_column_list NVARCHAR(MAX);
    DECLARE @last_column_types NVARCHAR(MAX);
    DECLARE @last_version INT;
    
    -- Get current schema
    EXEC control.sp_Get_Table_Schema_Info 
        @source_database, @table_name,
        @current_hash OUTPUT, @current_column_list OUTPUT, @current_column_types OUTPUT;
    
    -- Get last known schema
    SELECT TOP 1 
        @last_hash = schema_hash,
        @last_column_list = column_list,
        @last_column_types = column_types,
        @last_version = schema_version
    FROM control.archive_schema_versions
    WHERE source_database = @source_database AND table_name = @table_name
    ORDER BY schema_version DESC;
    
    -- Check if schema has changed
    IF @last_hash IS NULL
    BEGIN
        -- First time - no previous schema
        SET @change_detected = 1;
        SET @change_type = 'INITIAL_SCHEMA';
        SET @change_details = 'First schema detection for table';
        SET @old_version = 0;
        SET @new_version = 1;
    END
    ELSE IF @current_hash != @last_hash
    BEGIN
        -- Schema has changed
        SET @change_detected = 1;
        SET @change_type = 'SCHEMA_CHANGED';
        SET @change_details = 'Schema hash changed from ' + @last_hash + ' to ' + @current_hash;
        SET @old_version = @last_version;
        SET @new_version = @last_version + 1;
        
        -- Try to determine specific change type
        IF LEN(@current_column_list) > LEN(@last_column_list)
            SET @change_type = 'COLUMN_ADDED';
        ELSE IF LEN(@current_column_list) < LEN(@last_column_list)
            SET @change_type = 'COLUMN_REMOVED';
        ELSE IF @current_column_types != @last_column_types
            SET @change_type = 'TYPE_CHANGED';
    END
    ELSE
    BEGIN
        -- No change
        SET @change_detected = 0;
        SET @change_type = 'NO_CHANGE';
        SET @change_details = 'Schema unchanged';
        SET @old_version = @last_version;
        SET @new_version = @last_version;
    END
    
    PRINT 'Schema change detection for ' + @source_database + '.' + @table_name + ': ' + @change_type;
END;
GO

-- ===========================================
-- PROCEDURE: Create versioned archive table
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Create_Versioned_Archive_Table
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @schema_version INT,
    @schema_hash VARCHAR(32),
    @column_list NVARCHAR(MAX),
    @column_types NVARCHAR(MAX),
    @archive_schema VARCHAR(100),
    @archive_table VARCHAR(200) OUTPUT,
    @batch_id UNIQUEIDENTIFIER
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @exists BIT = 0;
    
    -- Generate archive table name with version
    SET @archive_table = @table_name + '_Archive_v' + CAST(@schema_version AS VARCHAR);
    
    -- Check if archive table already exists
    SET @sql = '
    USE archive_db;
    SELECT @exists = CASE WHEN EXISTS (SELECT * FROM sys.tables WHERE name = ''' + @archive_table + ''') THEN 1 ELSE 0 END;
    ';
    
    EXEC sp_executesql @sql, N'@exists BIT OUTPUT', @exists = @exists OUTPUT;
    
    IF @exists = 1
    BEGIN
        PRINT 'Archive table ' + @archive_table + ' already exists, skipping creation';
        RETURN;
    END
    
    -- Create archive schema if it doesn't exist
    SET @sql = '
    USE archive_db;
    IF NOT EXISTS (SELECT * FROM sys.schemas WHERE name = ''' + @archive_schema + ''')
    BEGIN
        EXEC(''CREATE SCHEMA ' + @archive_schema + ''');
        PRINT ''Created schema ' + @archive_schema + ' in archive_db'';
    END
    ';
    
    EXEC sp_executesql @sql;
    
    -- Create versioned archive table
    SET @sql = '
    USE archive_db;
    
    CREATE TABLE ' + QUOTENAME(@archive_schema) + '.' + QUOTENAME(@archive_table) + ' (
        ' + @column_types + ',
        archived_date DATETIME2 NOT NULL DEFAULT GETDATE(),
        archival_month VARCHAR(7) NOT NULL DEFAULT FORMAT(GETDATE(), ''yyyy-MM''),
        batch_id UNIQUEIDENTIFIER NULL,
        execution_id UNIQUEIDENTIFIER NULL,
        schema_version INT NOT NULL DEFAULT ' + CAST(@schema_version AS VARCHAR) + '
    );
    
    -- Create primary key (assuming first column is ID)
    DECLARE @pk_column VARCHAR(100);
    SELECT TOP 1 @pk_column = COLUMN_NAME 
    FROM INFORMATION_SCHEMA.COLUMNS 
    WHERE TABLE_NAME = ''' + @archive_table + ''' AND ORDINAL_POSITION = 1;
    
    IF @pk_column IS NOT NULL
    BEGIN
        EXEC(''ALTER TABLE ' + QUOTENAME(@archive_schema) + '.' + QUOTENAME(@archive_table) + ' ADD CONSTRAINT PK_' + @archive_table + ' PRIMARY KEY ('' + @pk_column + '', archived_date)'');
    END
    
    -- Create index on archival_month for partitioning
    CREATE INDEX IX_' + @archive_table + '_archival_month 
    ON ' + QUOTENAME(@archive_schema) + '.' + QUOTENAME(@archive_table) + ' (archival_month);
    
    -- Create index on archived_date for disposal
    CREATE INDEX IX_' + @archive_table + '_archived_date 
    ON ' + QUOTENAME(@archive_schema) + '.' + QUOTENAME(@archive_table) + ' (archived_date);
    ';
    
    EXEC sp_executesql @sql;
    
    -- Register schema version
    INSERT INTO control.archive_schema_versions (
        source_database, table_name, schema_version, schema_hash,
        column_list, column_types, archive_schema, archive_table
    ) VALUES (
        @source_database, @table_name, @schema_version, @schema_hash,
        @column_list, @column_types, @archive_schema, @archive_table
    );
    
    -- Register archive table
    INSERT INTO control.archive_table_registry (
        source_database, source_table, archive_schema, archive_table,
        schema_version
    ) VALUES (
        @source_database, @table_name, @archive_schema, @archive_table,
        @schema_version
    );
    
    -- Deactivate previous versions
    UPDATE control.archive_schema_versions
    SET is_active = 0
    WHERE source_database = @source_database 
    AND table_name = @table_name 
    AND schema_version < @schema_version;
    
    PRINT 'Created versioned archive table: ' + @archive_schema + '.' + @archive_table + ' (v' + CAST(@schema_version AS VARCHAR) + ')';
END;
GO

-- ===========================================
-- PROCEDURE: Validate schema before archival
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Validate_Schema_Before_Archival
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @archive_table_versioned VARCHAR(200) OUTPUT,
    @schema_version INT OUTPUT,
    @validation_status VARCHAR(50) OUTPUT,
    @batch_id UNIQUEIDENTIFIER = NULL
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @change_detected BIT;
    DECLARE @change_type VARCHAR(50);
    DECLARE @change_details NVARCHAR(MAX);
    DECLARE @old_version INT;
    DECLARE @new_version INT;
    DECLARE @current_hash VARCHAR(32);
    DECLARE @current_column_list NVARCHAR(MAX);
    DECLARE @current_column_types NVARCHAR(MAX);
    DECLARE @archive_schema VARCHAR(100);
    DECLARE @archive_table VARCHAR(200);
    
    -- Get archive configuration
    SELECT 
        @archive_schema = archive_db_schema,
        @archive_table = archive_db_table
    FROM control.archival_table_list
    WHERE source_database = @source_database AND table_name = @table_name;
    
    IF @archive_schema IS NULL
    BEGIN
        SET @validation_status = 'CONFIG_ERROR';
        SET @archive_table_versioned = NULL;
        SET @schema_version = 0;
        PRINT 'ERROR: Table not configured for archival: ' + @source_database + '.' + @table_name;
        RETURN;
    END
    
    -- Detect schema changes
    EXEC control.sp_Detect_Schema_Changes 
        @source_database, @table_name,
        @change_detected OUTPUT, @change_type OUTPUT, @change_details OUTPUT,
        @old_version OUTPUT, @new_version OUTPUT;
    
    IF @change_detected = 1
    BEGIN
        -- Schema has changed - create new version
        EXEC control.sp_Get_Table_Schema_Info 
            @source_database, @table_name,
            @current_hash OUTPUT, @current_column_list OUTPUT, @current_column_types OUTPUT;
        
        -- Create new versioned archive table
        EXEC control.sp_Create_Versioned_Archive_Table
            @source_database, @table_name, @new_version, @current_hash,
            @current_column_list, @current_column_types, @archive_schema,
            @archive_table_versioned OUTPUT, @batch_id;
        
        -- Log the schema change
        INSERT INTO control.schema_change_log (
            source_database, table_name, old_version, new_version,
            change_type, change_details, old_schema_hash, new_schema_hash,
            status, batch_id
        ) VALUES (
            @source_database, @table_name, @old_version, @new_version,
            @change_type, @change_details, NULL, @current_hash,
            'HANDLED', @batch_id
        );
        
        SET @validation_status = 'SCHEMA_CHANGED';
        SET @schema_version = @new_version;
        
        PRINT 'Schema change detected and handled. New archive table: ' + @archive_table_versioned;
    END
    ELSE
    BEGIN
        -- No change - get current active archive table
        SELECT TOP 1 
            @archive_table_versioned = archive_table,
            @schema_version = schema_version
        FROM control.archive_schema_versions
        WHERE source_database = @source_database 
        AND table_name = @table_name 
        AND is_active = 1;
        
        IF @archive_table_versioned IS NULL
        BEGIN
            -- No schema version exists - create initial version
            EXEC control.sp_Get_Table_Schema_Info 
                @source_database, @table_name,
                @current_hash OUTPUT, @current_column_list OUTPUT, @current_column_types OUTPUT;
            
            EXEC control.sp_Create_Versioned_Archive_Table
                @source_database, @table_name, 1, @current_hash,
                @current_column_list, @current_column_types, @archive_schema,
                @archive_table_versioned OUTPUT, @batch_id;
            
            SET @validation_status = 'INITIAL_SCHEMA';
            SET @schema_version = 1;
        END
        ELSE
        BEGIN
            SET @validation_status = 'NO_CHANGE';
        END
    END
    
    PRINT 'Schema validation completed: ' + @validation_status + ' - Using table: ' + @archive_table_versioned;
END;
GO

-- ===========================================
-- PROCEDURE: Get active archive table
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Get_Active_Archive_Table
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @archive_table_versioned VARCHAR(200) OUTPUT,
    @schema_version INT OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    
    SELECT TOP 1 
        @archive_table_versioned = archive_table,
        @schema_version = schema_version
    FROM control.archive_schema_versions
    WHERE source_database = @source_database 
    AND table_name = @table_name 
    AND is_active = 1;
    
    IF @archive_table_versioned IS NULL
    BEGIN
        PRINT 'WARNING: No active archive table found for ' + @source_database + '.' + @table_name;
        SET @archive_table_versioned = @table_name + '_Archive_v1';
        SET @schema_version = 1;
    END
END;
GO

-- ===========================================
-- PROCEDURE: Get column list for insert
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Get_Column_List_For_Insert
    @source_database VARCHAR(100),
    @staging_table_name VARCHAR(200),
    @archive_schema VARCHAR(100),
    @archive_table VARCHAR(200),
    @column_list NVARCHAR(MAX) OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    
    -- Get common columns between staging and archive tables
    SET @sql = '
    USE archive_db;
    
    SELECT @column_list = STRING_AGG(QUOTENAME(s.COLUMN_NAME), '', '') WITHIN GROUP (ORDER BY s.ORDINAL_POSITION)
    FROM INFORMATION_SCHEMA.COLUMNS s
    INNER JOIN INFORMATION_SCHEMA.COLUMNS a 
        ON s.COLUMN_NAME = a.COLUMN_NAME 
        AND s.DATA_TYPE = a.DATA_TYPE
        AND ISNULL(s.CHARACTER_MAXIMUM_LENGTH, 0) = ISNULL(a.CHARACTER_MAXIMUM_LENGTH, 0)
    WHERE s.TABLE_NAME = ''' + @staging_table_name + '''
    AND a.TABLE_SCHEMA = ''' + @archive_schema + '''
    AND a.TABLE_NAME = ''' + @archive_table + '''
    AND s.COLUMN_NAME NOT IN (''archived_date'', ''archival_month'', ''batch_id'', ''execution_id'', ''schema_version'');
    ';
    
    EXEC sp_executesql @sql, N'@column_list NVARCHAR(MAX) OUTPUT', @column_list = @column_list OUTPUT;
    
    IF @column_list IS NULL
    BEGIN
        SET @column_list = 'id'; -- Fallback to first column
        PRINT 'WARNING: Could not determine column mapping, using fallback: ' + @column_list;
    END
END;
GO

-- ===========================================
-- PROCEDURE: Show schema versions
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Show_Schema_Versions
    @source_database VARCHAR(100) = NULL,
    @table_name VARCHAR(100) = NULL
AS
BEGIN
    SET NOCOUNT ON;
    
    SELECT 
        sv.source_database,
        sv.table_name,
        sv.schema_version,
        sv.schema_hash,
        sv.archive_schema,
        sv.archive_table,
        sv.created_date,
        sv.is_active,
        atr.record_count,
        atr.data_size_mb,
        atr.last_archived_date
    FROM control.archive_schema_versions sv
    LEFT JOIN control.archive_table_registry atr 
        ON sv.source_database = atr.source_database 
        AND sv.table_name = atr.source_table 
        AND sv.schema_version = atr.schema_version
    WHERE (@source_database IS NULL OR sv.source_database = @source_database)
    AND (@table_name IS NULL OR sv.table_name = @table_name)
    ORDER BY sv.source_database, sv.table_name, sv.schema_version DESC;
END;
GO

-- ===========================================
-- PROCEDURE: Show schema changes
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Show_Schema_Changes
    @source_database VARCHAR(100) = NULL,
    @table_name VARCHAR(100) = NULL,
    @days_back INT = 30
AS
BEGIN
    SET NOCOUNT ON;
    
    SELECT 
        scl.source_database,
        scl.table_name,
        scl.change_type,
        scl.change_details,
        scl.old_version,
        scl.new_version,
        scl.detected_date,
        scl.handled_date,
        scl.status,
        scl.error_message
    FROM control.schema_change_log scl
    WHERE (@source_database IS NULL OR scl.source_database = @source_database)
    AND (@table_name IS NULL OR scl.table_name = @table_name)
    AND scl.detected_date >= DATEADD(DAY, -@days_back, GETDATE())
    ORDER BY scl.detected_date DESC;
END;
GO

PRINT 'Schema management procedures created successfully';
PRINT '- sp_Get_Table_Schema_Info: Extract schema information and hash';
PRINT '- sp_Detect_Schema_Changes: Detect schema changes';
PRINT '- sp_Create_Versioned_Archive_Table: Create versioned archive tables';
PRINT '- sp_Validate_Schema_Before_Archival: Main validation procedure';
PRINT '- sp_Get_Active_Archive_Table: Get current active archive table';
PRINT '- sp_Get_Column_List_For_Insert: Generate column lists for inserts';
PRINT '- sp_Show_Schema_Versions: Display schema version information';
PRINT '- sp_Show_Schema_Changes: Display schema change history';
