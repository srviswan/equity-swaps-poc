-- 04_partition_detection_procedures.sql
-- Partition detection and analysis procedures

USE control_db;
GO

-- ===========================================
-- PROCEDURE: Detect partition information for a table
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Detect_Partition_Info
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @has_partition BIT OUTPUT,
    @partition_function VARCHAR(200) OUTPUT,
    @partition_scheme VARCHAR(200) OUTPUT,
    @partition_number INT OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    
    -- Initialize outputs
    SET @has_partition = 0;
    SET @partition_function = NULL;
    SET @partition_scheme = NULL;
    SET @partition_number = NULL;
    
    DECLARE @sql NVARCHAR(MAX);
    
    -- Check if table has partition on archival_flag column
    SET @sql = '
    USE ' + QUOTENAME(@source_database) + ';
    
    SELECT 
        @has_partition = CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END,
        @partition_function = pf.name,
        @partition_scheme = ps.name,
        @partition_number = p.partition_number
    FROM sys.partitions p
    JOIN sys.indexes i ON p.object_id = i.object_id AND p.index_id = i.index_id
    JOIN sys.partition_schemes ps ON i.data_space_id = ps.data_space_id
    JOIN sys.partition_functions pf ON ps.function_id = pf.function_id
    WHERE p.object_id = OBJECT_ID(''dbo.' + QUOTENAME(@table_name) + ''')
      AND i.index_id IN (0,1)  -- Heap or clustered index
      AND pf.name LIKE ''%' + @table_name + '%'';
    ';
    
    EXEC sp_executesql @sql,
        N'@has_partition BIT OUTPUT, @partition_function VARCHAR(200) OUTPUT, @partition_scheme VARCHAR(200) OUTPUT, @partition_number INT OUTPUT',
        @has_partition = @has_partition OUTPUT,
        @partition_function = @partition_function OUTPUT,
        @partition_scheme = @partition_scheme OUTPUT,
        @partition_number = @partition_number OUTPUT;
    
    PRINT 'Partition detection completed for ' + @source_database + '.' + @table_name;
    PRINT 'Has partition: ' + CAST(@has_partition AS VARCHAR);
    IF @has_partition = 1
    BEGIN
        PRINT 'Partition function: ' + ISNULL(@partition_function, 'NULL');
        PRINT 'Partition scheme: ' + ISNULL(@partition_scheme, 'NULL');
        PRINT 'Partition number: ' + ISNULL(CAST(@partition_number AS VARCHAR), 'NULL');
    END
END;
GO

-- ===========================================
-- PROCEDURE: Show detailed partition information
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
        pf.fanout as partition_count,
        pf.boundary_value_on_right
    FROM sys.partition_functions pf
    WHERE pf.name LIKE ''%' + @table_name + '%'';
    
    -- Show partition scheme information
    SELECT 
        ps.name as partition_scheme,
        ps.type_desc,
        fg.name as filegroup_name,
        dds.destination_id as partition_number
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

-- ===========================================
-- PROCEDURE: Validate partition alignment
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Validate_Partition_Alignment
    @source_database VARCHAR(100),
    @table_name VARCHAR(100),
    @is_aligned BIT OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    
    SET @is_aligned = 0;
    
    DECLARE @sql NVARCHAR(MAX);
    
    -- Check if table and indexes are aligned with partition scheme
    SET @sql = '
    USE ' + QUOTENAME(@source_database) + ';
    
    SELECT @is_aligned = CASE WHEN COUNT(*) = 0 THEN 1 ELSE 0 END
    FROM sys.indexes i
    WHERE i.object_id = OBJECT_ID(''dbo.' + QUOTENAME(@table_name) + ''')
      AND i.data_space_id NOT IN (
          SELECT ps.data_space_id 
          FROM sys.partition_schemes ps 
          WHERE ps.name LIKE ''%' + @table_name + '%''
      );
    ';
    
    EXEC sp_executesql @sql,
        N'@is_aligned BIT OUTPUT',
        @is_aligned = @is_aligned OUTPUT;
    
    PRINT 'Partition alignment check for ' + @source_database + '.' + @table_name + ': ' + 
          CASE WHEN @is_aligned = 1 THEN 'ALIGNED' ELSE 'MISALIGNED' END;
END;
GO

PRINT 'Partition detection procedures created successfully';
