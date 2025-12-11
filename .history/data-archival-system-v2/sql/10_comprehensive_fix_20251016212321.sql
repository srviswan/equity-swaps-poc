-- 10_comprehensive_fix.sql
-- Comprehensive fix for all archival issues

USE control_db;
GO

-- ===========================================
-- PROCEDURE: Complete Archival Workflow
-- Handles marking, moving, and archiving in one procedure
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Complete_Archival_Workflow
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @batch_id UNIQUEIDENTIFIER
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @monthly_table_pattern VARCHAR(200);
    DECLARE @archive_schema VARCHAR(100);
    DECLARE @archive_table VARCHAR(100);
    DECLARE @date_column VARCHAR(100);
    DECLARE @months_before_archival INT;
    DECLARE @records_marked INT = 0;
    DECLARE @records_archived INT = 0;
    DECLARE @error_msg NVARCHAR(MAX);
    
    -- Get configuration
    SELECT 
        @monthly_table_pattern = monthly_archival_table_pattern,
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
        
        -- Step 3: Move marked records directly to archive database
        IF @records_marked > 0
        BEGIN
            SET @sql = '
            USE archive_db;
            INSERT INTO ' + QUOTENAME(@archive_schema) + '.' + QUOTENAME(@archive_table) + '
            SELECT *, GETDATE() AS archived_date
            FROM ' + QUOTENAME(@source_database) + '.dbo.' + QUOTENAME(@table_name) + '
            WHERE archival_flag = 1;
            ';
            
            EXEC sp_executesql @sql;
            SET @records_archived = @@ROWCOUNT;
            
            -- Step 4: Delete archived records from source table
            SET @sql = '
            USE ' + QUOTENAME(@source_database) + ';
            DELETE FROM dbo.' + QUOTENAME(@table_name) + '
            WHERE archival_flag = 1;
            ';
            
            EXEC sp_executesql @sql;
        END
        
        -- Log success
        INSERT INTO control.archival_execution_log (
            batch_id, operation, source_database, table_name,
            records_affected, status, execution_end
        )
        VALUES (
            @batch_id, 'COMPLETE_ARCHIVAL', @source_database, @table_name,
            @records_archived, 'SUCCESS', GETDATE()
        );
        
        PRINT 'Successfully archived ' + CAST(@records_archived AS VARCHAR) + ' records from ' + @source_database + '.' + @table_name;
        
    END TRY
    BEGIN CATCH
        SET @error_msg = ERROR_MESSAGE();
        
        -- Log error
        INSERT INTO control.archival_execution_log (
            batch_id, operation, source_database, table_name,
            records_affected, status, execution_end, error_message
        )
        VALUES (
            @batch_id, 'COMPLETE_ARCHIVAL_FAILED', @source_database, @table_name,
            0, 'FAILED', GETDATE(), @error_msg
        );
        
        PRINT 'ERROR: ' + @error_msg;
    END CATCH
END;
GO

-- ===========================================
-- PROCEDURE: Reset Archival System
-- Clears all archival flags and resets the system
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Reset_Archival_System
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    
    -- Reset archival flags in all source tables
    SET @sql = '
    USE SourceDB1;
    UPDATE dbo.Position SET archival_flag = 0, archival_month = NULL WHERE archival_flag = 1;
    
    USE SourceDB2;
    UPDATE dbo.Trade SET archival_flag = 0, archival_month = NULL WHERE archival_flag = 1;
    
    USE SourceDB3;
    UPDATE dbo.PriceHistory SET archival_flag = 0, archival_month = NULL WHERE archival_flag = 1;
    ';
    
    EXEC sp_executesql @sql;
    
    -- Clear execution log
    DELETE FROM control.archival_execution_log;
    
    -- Clear monthly tracking
    DELETE FROM control.monthly_archival_tracking;
    
    PRINT 'Archival system reset successfully';
END;
GO

-- ===========================================
-- PROCEDURE: Show Archive Database Status
-- Shows what data is in the archive database
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Show_Archive_Status
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    
    SET @sql = '
    USE archive_db;
    
    SELECT 
        s.name as schema_name,
        t.name as table_name,
        p.rows as record_count
    FROM sys.tables t
    JOIN sys.schemas s ON t.schema_id = s.schema_id
    LEFT JOIN sys.partitions p ON t.object_id = p.object_id AND p.index_id IN (0,1)
    ORDER BY s.name, t.name;
    ';
    
    EXEC sp_executesql @sql;
END;
GO

PRINT 'Comprehensive fix procedures created successfully';
