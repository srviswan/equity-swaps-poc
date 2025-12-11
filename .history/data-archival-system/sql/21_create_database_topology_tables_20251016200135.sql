-- 21_create_database_topology_tables.sql
-- Create database topology configuration for archive database portability

USE control_db;
GO

-- Database topology configuration
CREATE TABLE control.database_topology (
    topology_id INT IDENTITY(1,1) PRIMARY KEY,
    database_type VARCHAR(50) NOT NULL,  -- 'SOURCE', 'ARCHIVE', 'CONTROL'
    database_name VARCHAR(100) NOT NULL,
    server_name VARCHAR(200) NOT NULL,
    server_instance VARCHAR(200) NULL,
    linked_server_name VARCHAR(200) NULL,
    is_local BIT DEFAULT 1,
    connection_string VARCHAR(500) NULL,
    active BIT DEFAULT 1,
    created_date DATETIME DEFAULT GETDATE(),
    updated_date DATETIME NULL,
    INDEX idx_db_type (database_type, active),
    UNIQUE (database_type, database_name, active)
);

-- Initial configuration (archive_db is local)
INSERT INTO control.database_topology 
(database_type, database_name, server_name, is_local, active)
VALUES 
('SOURCE', 'SourceDB1', @@SERVERNAME, 1, 1),
('SOURCE', 'SourceDB2', @@SERVERNAME, 1, 1),
('SOURCE', 'SourceDB3', @@SERVERNAME, 1, 1),
('ARCHIVE', 'archive_db', @@SERVERNAME, 1, 1),
('CONTROL', 'control_db', @@SERVERNAME, 1, 1);

PRINT 'Database topology configuration created';
GO

-- Helper function to get database reference
CREATE FUNCTION control.fn_Get_Database_Reference
(
    @database_type VARCHAR(50),
    @database_name VARCHAR(100)
)
RETURNS NVARCHAR(500)
AS
BEGIN
    DECLARE @reference NVARCHAR(500);
    DECLARE @is_local BIT;
    DECLARE @linked_server VARCHAR(200);
    
    SELECT 
        @is_local = is_local,
        @linked_server = linked_server_name
    FROM control.database_topology
    WHERE database_type = @database_type 
      AND database_name = @database_name 
      AND active = 1;
    
    IF @is_local = 1
        SET @reference = QUOTENAME(@database_name);
    ELSE
        SET @reference = QUOTENAME(@linked_server) + '.' + QUOTENAME(@database_name);
    
    RETURN @reference;
END;
GO

PRINT 'Database reference helper function created';
