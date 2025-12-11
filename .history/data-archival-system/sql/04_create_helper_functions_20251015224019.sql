-- 04_create_helper_functions.sql
-- Create helper functions for dynamic SQL generation

USE control_db;
GO

-- Build PK concatenation string dynamically
CREATE FUNCTION control.fn_Build_PK_String(@pk_columns VARCHAR(500), @alias VARCHAR(10))
RETURNS NVARCHAR(MAX)
AS
BEGIN
    DECLARE @result NVARCHAR(MAX) = '';
    DECLARE @col VARCHAR(100);
    DECLARE @pos INT;
    
    -- Parse comma-separated PK columns and build CONCAT expression
    WHILE LEN(@pk_columns) > 0
    BEGIN
        SET @pos = CHARINDEX(',', @pk_columns);
        IF @pos = 0
        BEGIN
            SET @col = LTRIM(RTRIM(@pk_columns));
            SET @pk_columns = '';
        END
        ELSE
        BEGIN
            SET @col = LTRIM(RTRIM(SUBSTRING(@pk_columns, 1, @pos - 1)));
            SET @pk_columns = SUBSTRING(@pk_columns, @pos + 1, LEN(@pk_columns));
        END
        
        IF LEN(@result) > 0
            SET @result = @result + ' + ''|'' + ';
        
        SET @result = @result + 'CAST(' + @alias + '.' + @col + ' AS NVARCHAR(100))';
    END
    
    RETURN @result;
END;
GO

-- Build PK hash dynamically
CREATE FUNCTION control.fn_Build_PK_Hash(@pk_values NVARCHAR(MAX))
RETURNS VARBINARY(32) AS
BEGIN 
    RETURN HASHBYTES('SHA2_256', @pk_values); 
END;
GO

-- Build PK join condition dynamically
CREATE FUNCTION control.fn_Build_PK_Join(@pk_csv VARCHAR(500), @left_alias SYSNAME, @right_alias SYSNAME)
RETURNS NVARCHAR(MAX)
AS
BEGIN
    DECLARE @res NVARCHAR(MAX)=''; 
    DECLARE @pos INT; 
    DECLARE @col SYSNAME;
    
    WHILE LEN(@pk_csv)>0 
    BEGIN
        SET @pos = CHARINDEX(',', @pk_csv);
        IF @pos=0 
        BEGIN 
            SET @col = LTRIM(RTRIM(@pk_csv)); 
            SET @pk_csv=''; 
        END
        ELSE 
        BEGIN 
            SET @col = LTRIM(RTRIM(SUBSTRING(@pk_csv,1,@pos-1))); 
            SET @pk_csv=SUBSTRING(@pk_csv,@pos+1,LEN(@pk_csv)); 
        END
        
        SET @res = @res + CASE WHEN LEN(@res)>0 THEN N' AND ' ELSE N'' END +
                   QUOTENAME(@left_alias) + N'.' + QUOTENAME(@col) + N' = ' + QUOTENAME(@right_alias) + N'.' + QUOTENAME(@col);
    END
    
    RETURN @res;
END;
GO

-- Build fully qualified name safely
CREATE PROCEDURE control.sp_Fqn
    @db SYSNAME, @schema SYSNAME, @table SYSNAME,
    @out NVARCHAR(512) OUTPUT
AS
BEGIN
    SET @out = QUOTENAME(@db) + N'.' + QUOTENAME(@schema) + N'.' + QUOTENAME(@table);
END;
GO

PRINT 'Helper functions created successfully';
