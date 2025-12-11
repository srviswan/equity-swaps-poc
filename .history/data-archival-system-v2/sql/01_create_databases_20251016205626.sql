-- 01_create_databases.sql
-- Create core databases for archival system

-- Create control database
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'control_db')
BEGIN
    CREATE DATABASE control_db;
    PRINT 'Created control_db database';
END
ELSE
BEGIN
    PRINT 'control_db database already exists';
END
GO

-- Create archive database
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'archive_db')
BEGIN
    CREATE DATABASE archive_db;
    PRINT 'Created archive_db database';
END
ELSE
BEGIN
    PRINT 'archive_db database already exists';
END
GO

-- Create source databases
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'SourceDB1')
BEGIN
    CREATE DATABASE SourceDB1;
    PRINT 'Created SourceDB1 database';
END
ELSE
BEGIN
    PRINT 'SourceDB1 database already exists';
END
GO

IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'SourceDB2')
BEGIN
    CREATE DATABASE SourceDB2;
    PRINT 'Created SourceDB2 database';
END
ELSE
BEGIN
    PRINT 'SourceDB2 database already exists';
END
GO

IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'SourceDB3')
BEGIN
    CREATE DATABASE SourceDB3;
    PRINT 'Created SourceDB3 database';
END
ELSE
BEGIN
    PRINT 'SourceDB3 database already exists';
END
GO

PRINT 'All databases created successfully';

