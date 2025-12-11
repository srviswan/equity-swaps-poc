-- 01_create_databases.sql
-- Create control and archive databases for data retention service

-- Create control_db (if not exists)
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'control_db')
BEGIN
    CREATE DATABASE control_db;
    PRINT 'Created control_db';
END
ELSE
BEGIN
    PRINT 'control_db already exists';
END
GO

-- Create archive_db (if not exists)
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'archive_db')
BEGIN
    CREATE DATABASE archive_db;
    PRINT 'Created archive_db';
END
ELSE
BEGIN
    PRINT 'archive_db already exists';
END
GO

-- Set recovery model for archive_db to minimize logging overhead
ALTER DATABASE archive_db SET RECOVERY SIMPLE;
PRINT 'Set archive_db to SIMPLE recovery model';

-- Create filegroups for archive_db partitioning (optional)
USE archive_db;
GO

-- Create additional filegroup for partitioning (if needed)
IF NOT EXISTS (SELECT * FROM sys.filegroups WHERE name = 'ARCHIVE_FG')
BEGIN
    ALTER DATABASE archive_db ADD FILEGROUP ARCHIVE_FG;
    PRINT 'Created ARCHIVE_FG filegroup';
END
GO

PRINT 'Database setup completed successfully';
