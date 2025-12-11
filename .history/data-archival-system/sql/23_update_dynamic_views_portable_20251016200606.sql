-- 23_update_dynamic_views_portable.sql
-- Update dynamic view procedures for database portability

USE control_db;
GO

-- Updated procedure with database portability
CREATE OR ALTER PROCEDURE control.sp_Update_Archive_Views
    @source_db VARCHAR(100),
    @base_table_name VARCHAR(100)
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @view_sql NVARCHAR(MAX) = '';
    DECLARE @union_count INT = 0;
    DECLARE @archive_db_ref NVARCHAR(500);
    
    -- Get archive database reference (local or remote)
    SET @archive_db_ref = control.fn_Get_Database_Reference('ARCHIVE', 'archive_db');
    
    -- Build view SQL dynamically
    SET @view_sql = 'CREATE OR ALTER VIEW ' + @archive_db_ref + '.' + 
                    QUOTENAME(@source_db) + '.' + QUOTENAME(@base_table_name) + ' AS ';
    
    -- Add archived tables still in source DB
    SELECT @view_sql = @view_sql + 
        CASE WHEN @union_count > 0 THEN ' UNION ALL ' ELSE '' END +
        'SELECT * FROM ' + QUOTENAME(source_database) + '.archive.' + QUOTENAME(table_name),
        @union_count = @union_count + 1
    FROM control.archived_tables
    WHERE source_database = @source_db
      AND base_table_name = @base_table_name
      AND moved_to_archive_db = 0
    ORDER BY archived_date;
    
    -- Add archived table in archive_db (using topology reference)
    IF EXISTS (
        SELECT 1 FROM control.archived_tables
        WHERE source_database = @source_db
          AND base_table_name = @base_table_name
          AND moved_to_archive_db = 1
    )
    BEGIN
        SET @view_sql = @view_sql + 
            CASE WHEN @union_count > 0 THEN ' UNION ALL ' ELSE '' END +
            'SELECT * FROM ' + @archive_db_ref + '.' + 
            QUOTENAME(@source_db) + '.' + QUOTENAME(@base_table_name) + '_Old';
    END
    
    -- Execute view creation
    EXEC sp_executesql @view_sql;
    
    PRINT 'Archive view updated for ' + @source_db + '.' + @base_table_name;
END;
GO

PRINT 'Portable dynamic view procedure updated';
