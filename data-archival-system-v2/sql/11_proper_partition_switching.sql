-- 11_proper_partition_switching.sql
-- Proper partition switching implementation for high-performance archival

USE control_db;
GO

-- ===========================================
-- PROCEDURE: Create staging table for partition switch
-- Creates staging table with exact same structure and constraints
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Create_Partition_Staging_Table
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @staging_table_name VARCHAR(200)
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    
    -- Step 1: Drop staging table if exists
    SET @sql = '
    USE ' + QUOTENAME(@source_database) + ';
    IF EXISTS (SELECT * FROM sys.tables WHERE name = ''' + @staging_table_name + ''')
        DROP TABLE dbo.' + QUOTENAME(@staging_table_name) + ';
    ';
    EXEC sp_executesql @sql;
    
    -- Step 2: Create staging table with same structure as base table
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
    
    PRINT 'Created partition staging table: ' + @source_database + '.dbo.' + @staging_table_name;
END;
GO

-- ===========================================
-- PROCEDURE: Partition Switch Archival
-- Uses partition switching for high-performance data movement
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Partition_Switch_Archival
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @batch_id UNIQUEIDENTIFIER
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @staging_table_name VARCHAR(200);
    DECLARE @archive_schema VARCHAR(100);
    DECLARE @archive_table VARCHAR(100);
    DECLARE @date_column VARCHAR(100);
    DECLARE @months_before_archival INT;
    DECLARE @records_marked INT = 0;
    DECLARE @records_archived INT = 0;
    DECLARE @error_msg NVARCHAR(MAX);
    
    -- Generate staging table name
    SET @staging_table_name = @table_name + '_Archive_Staging_' + FORMAT(GETDATE(), 'yyyyMMdd_HHmmss');
    
    -- Get configuration
    SELECT 
        @archive_schema = archive_db_schema,
        @archive_table = archive_db_table,
        @date_column = date_column,
        @months_before_archival = months_before_archival
    FROM control.archival_table_list
    WHERE source_database = @source_database AND table_name = @table_name;
    
    IF @date_column IS NULL
    BEGIN
        PRINT 'Table not configured: ' + @source_database + '.' + @table_name;
        RETURN;
    END
    
    BEGIN TRY
        -- Step 1: Create archive schema and table if not exists
        SET @sql = '
        USE archive_db;
        IF NOT EXISTS (SELECT * FROM sys.schemas WHERE name = ''' + @archive_schema + ''')
        BEGIN
            EXEC(''CREATE SCHEMA ' + QUOTENAME(@archive_schema) + ''');
        END
        
        IF NOT EXISTS (
            SELECT * FROM sys.tables t
            JOIN sys.schemas s ON t.schema_id = s.schema_id
            WHERE s.name = ''' + @archive_schema + ''' AND t.name = ''' + @archive_table + '''
        )
        BEGIN
            SELECT TOP 0 *, GETDATE() AS archived_date
            INTO ' + QUOTENAME(@archive_schema) + '.' + QUOTENAME(@archive_table) + '
            FROM ' + QUOTENAME(@source_database) + '.dbo.' + QUOTENAME(@table_name) + ';
        END
        ';
        EXEC sp_executesql @sql;
        
        -- Step 2: Mark records for archival
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
            )
            VALUES (
                @batch_id, 'PARTITION_SWITCH_ARCHIVAL', @source_database, @table_name,
                0, 'SUCCESS', GETDATE()
            );
            RETURN;
        END
        
        -- Step 3: Create staging table for partition switch
        EXEC control.sp_Create_Partition_Staging_Table @source_database, @table_name, @staging_table_name;
        
        -- Step 4: PARTITION SWITCH - Move archival partition to staging table
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
        
        EXEC sp_executesql @sql;
        
        -- Step 5: Move data from staging table to archive database
        SET @sql = '
        USE archive_db;
        INSERT INTO ' + QUOTENAME(@archive_schema) + '.' + QUOTENAME(@archive_table) + '
        SELECT *, GETDATE() AS archived_date
        FROM ' + QUOTENAME(@source_database) + '.dbo.' + QUOTENAME(@staging_table_name) + ';
        ';
        
        EXEC sp_executesql @sql;
        SET @records_archived = @@ROWCOUNT;
        
        -- Step 6: Drop staging table
        SET @sql = '
        USE ' + QUOTENAME(@source_database) + ';
        DROP TABLE dbo.' + QUOTENAME(@staging_table_name) + ';
        ';
        
        EXEC sp_executesql @sql;
        
        -- Log success
        INSERT INTO control.archival_execution_log (
            batch_id, operation, source_database, table_name,
            records_affected, status, execution_end
        )
        VALUES (
            @batch_id, 'PARTITION_SWITCH_ARCHIVAL', @source_database, @table_name,
            @records_archived, 'SUCCESS', GETDATE()
        );
        
        PRINT 'Successfully archived ' + CAST(@records_archived AS VARCHAR) + ' records using partition switching from ' + @source_database + '.' + @table_name;
        
    END TRY
    BEGIN CATCH
        SET @error_msg = ERROR_MESSAGE();
        
        -- Log error
        INSERT INTO control.archival_execution_log (
            batch_id, operation, source_database, table_name,
            records_affected, status, execution_end, error_message
        )
        VALUES (
            @batch_id, 'PARTITION_SWITCH_FAILED', @source_database, @table_name,
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
        
        PRINT 'ERROR: Partition switch failed - ' + @error_msg;
    END CATCH
END;
GO

-- ===========================================
-- PROCEDURE: Show Partition Information
-- Shows partition information for debugging
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Show_Partition_Info
    @source_database VARCHAR(100),
    @table_name VARCHAR(100)
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    
    SET @sql = '
    USE ' + QUOTENAME(@source_database) + ';
    
    -- Show partition function information
    SELECT 
        pf.name as partition_function,
        pf.type_desc,
        pf.fanout as partition_count
    FROM sys.partition_functions pf
    WHERE pf.name LIKE ''%' + @table_name + '%'';
    
    -- Show partition scheme information
    SELECT 
        ps.name as partition_scheme,
        ps.type_desc,
        fg.name as filegroup_name
    FROM sys.partition_schemes ps
    JOIN sys.destination_data_spaces dds ON ps.data_space_id = dds.partition_scheme_id
    JOIN sys.filegroups fg ON dds.data_space_id = fg.data_space_id
    WHERE ps.name LIKE ''%' + @table_name + '%'';
    
    -- Show table partition information
    SELECT 
        p.partition_number,
        p.rows,
        fg.name as filegroup_name,
        CASE WHEN p.partition_number = 1 THEN ''Active (archival_flag = 0)''
             WHEN p.partition_number = 2 THEN ''Archival (archival_flag = 1)''
             ELSE ''Unknown''
        END as partition_description
    FROM sys.partitions p
    JOIN sys.allocation_units au ON p.partition_id = au.container_id
    JOIN sys.filegroups fg ON au.data_space_id = fg.data_space_id
    WHERE p.object_id = OBJECT_ID(''dbo.' + QUOTENAME(@table_name) + ''')
      AND p.index_id IN (0,1)
    ORDER BY p.partition_number;
    ';
    
    EXEC sp_executesql @sql;
END;
GO

PRINT 'Proper partition switching procedures created successfully';
