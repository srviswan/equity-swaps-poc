-- 03_partition_switch_procedures.sql
-- Partition switching procedures for high-performance data movement

USE control_db;
GO

-- ===========================================
-- PROCEDURE: Create partition staging table for any table
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Create_Partition_Staging_Table
    @source_database VARCHAR(100),
    @source_table_name VARCHAR(100),
    @staging_table_name VARCHAR(200)
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @exists BIT = 0;
    
    -- Check if staging table already exists
    SET @sql = '
    USE ' + QUOTENAME(@source_database) + ';
    SELECT @exists = CASE WHEN EXISTS (SELECT * FROM sys.tables WHERE name = ''' + @staging_table_name + ''') THEN 1 ELSE 0 END;
    ';
    
    EXEC sp_executesql @sql,
        N'@exists BIT OUTPUT',
        @exists = @exists OUTPUT;
    
    IF @exists = 1
    BEGIN
        PRINT 'Staging table ' + @staging_table_name + ' already exists, skipping creation';
        RETURN;
    END
    
    -- Get table structure and create staging table
    SET @sql = '
    USE ' + QUOTENAME(@source_database) + ';
    
    -- Create staging table with same structure as base table
    SELECT TOP 0 *
    INTO dbo.' + QUOTENAME(@staging_table_name) + '
    FROM dbo.' + QUOTENAME(@source_table_name) + ';
    
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
-- PROCEDURE: Bulk copy to staging table (fallback method)
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
              WHERE s.id = dbo.' + QUOTENAME(@table_name) + '.id
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

PRINT 'Partition switch procedures created successfully';
