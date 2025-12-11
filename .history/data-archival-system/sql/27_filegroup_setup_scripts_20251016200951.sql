-- 27_filegroup_setup_scripts.sql
-- Scripts to create filegroups for the archival system

-- ====================================================================
-- CREATE FILEGROUPS FOR SOURCE DATABASES
-- ====================================================================

-- SourceDB1 Filegroup Setup
USE SourceDB1;
GO

-- Add ARCHIVE_FG filegroup if it doesn't exist
IF NOT EXISTS (SELECT * FROM sys.filegroups WHERE name = 'ARCHIVE_FG')
BEGIN
    ALTER DATABASE SourceDB1 ADD FILEGROUP ARCHIVE_FG;
    PRINT 'Created ARCHIVE_FG filegroup in SourceDB1';
END
ELSE
BEGIN
    PRINT 'ARCHIVE_FG filegroup already exists in SourceDB1';
END
GO

-- Note: File paths would be customized for production environment
-- This is a template showing the structure

/*
-- Add files to ARCHIVE_FG filegroup (uncomment and customize paths for production)
IF NOT EXISTS (SELECT * FROM sys.database_files WHERE name = 'SourceDB1_Archive1')
BEGIN
    ALTER DATABASE SourceDB1 ADD FILE 
    (
        NAME = SourceDB1_Archive1,
        FILENAME = '/var/opt/mssql/data/SourceDB1_Archive1.ndf',
        SIZE = 100MB,
        MAXSIZE = UNLIMITED,
        FILEGROWTH = 10MB
    ) TO FILEGROUP ARCHIVE_FG;
    PRINT 'Added SourceDB1_Archive1 file to ARCHIVE_FG';
END

IF NOT EXISTS (SELECT * FROM sys.database_files WHERE name = 'SourceDB1_Archive2')
BEGIN
    ALTER DATABASE SourceDB1 ADD FILE 
    (
        NAME = SourceDB1_Archive2,
        FILENAME = '/var/opt/mssql/data/SourceDB1_Archive2.ndf',
        SIZE = 100MB,
        MAXSIZE = UNLIMITED,
        FILEGROWTH = 10MB
    ) TO FILEGROUP ARCHIVE_FG;
    PRINT 'Added SourceDB1_Archive2 file to ARCHIVE_FG';
END
*/

-- SourceDB2 Filegroup Setup
USE SourceDB2;
GO

IF NOT EXISTS (SELECT * FROM sys.filegroups WHERE name = 'ARCHIVE_FG')
BEGIN
    ALTER DATABASE SourceDB2 ADD FILEGROUP ARCHIVE_FG;
    PRINT 'Created ARCHIVE_FG filegroup in SourceDB2';
END
ELSE
BEGIN
    PRINT 'ARCHIVE_FG filegroup already exists in SourceDB2';
END
GO

-- SourceDB3 Filegroup Setup
USE SourceDB3;
GO

IF NOT EXISTS (SELECT * FROM sys.filegroups WHERE name = 'ARCHIVE_FG')
BEGIN
    ALTER DATABASE SourceDB3 ADD FILEGROUP ARCHIVE_FG;
    PRINT 'Created ARCHIVE_FG filegroup in SourceDB3';
END
ELSE
BEGIN
    PRINT 'ARCHIVE_FG filegroup already exists in SourceDB3';
END
GO

-- ====================================================================
-- CREATE ARCHIVE SCHEMA IN SOURCE DATABASES
-- ====================================================================

-- Create archive schema in SourceDB1
USE SourceDB1;
GO

IF NOT EXISTS (SELECT * FROM sys.schemas WHERE name = 'archive')
BEGIN
    EXEC('CREATE SCHEMA archive');
    PRINT 'Created archive schema in SourceDB1';
END
ELSE
BEGIN
    PRINT 'archive schema already exists in SourceDB1';
END
GO

-- Create archive schema in SourceDB2
USE SourceDB2;
GO

IF NOT EXISTS (SELECT * FROM sys.schemas WHERE name = 'archive')
BEGIN
    EXEC('CREATE SCHEMA archive');
    PRINT 'Created archive schema in SourceDB2';
END
ELSE
BEGIN
    PRINT 'archive schema already exists in SourceDB2';
END
GO

-- Create archive schema in SourceDB3
USE SourceDB3;
GO

IF NOT EXISTS (SELECT * FROM sys.schemas WHERE name = 'archive')
BEGIN
    EXEC('CREATE SCHEMA archive');
    PRINT 'Created archive schema in SourceDB3';
END
ELSE
BEGIN
    PRINT 'archive schema already exists in SourceDB3';
END
GO

-- ====================================================================
-- FILEGROUP MONITORING VIEW
-- ====================================================================

USE control_db;
GO

-- Create view to monitor filegroup usage across all databases
CREATE OR ALTER VIEW control.vw_All_Filegroups_Status
AS
-- SourceDB1 filegroups
SELECT 
    'SourceDB1' AS DatabaseName,
    fg.name AS FileGroupName,
    SUM(f.size * 8 / 1024) AS SizeMB,
    SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024) AS UsedMB,
    SUM(f.size * 8 / 1024) - SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024) AS FreeMB,
    CAST((SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024) * 100.0) / 
         (SUM(f.size * 8 / 1024)) AS DECIMAL(5,2)) AS PercentUsed
FROM SourceDB1.sys.filegroups fg
JOIN SourceDB1.sys.database_files f ON fg.data_space_id = f.data_space_id
GROUP BY fg.name

UNION ALL

-- SourceDB2 filegroups
SELECT 
    'SourceDB2' AS DatabaseName,
    fg.name AS FileGroupName,
    SUM(f.size * 8 / 1024) AS SizeMB,
    SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024) AS UsedMB,
    SUM(f.size * 8 / 1024) - SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024) AS FreeMB,
    CAST((SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024) * 100.0) / 
         (SUM(f.size * 8 / 1024)) AS DECIMAL(5,2)) AS PercentUsed
FROM SourceDB2.sys.filegroups fg
JOIN SourceDB2.sys.database_files f ON fg.data_space_id = f.data_space_id
GROUP BY fg.name

UNION ALL

-- SourceDB3 filegroups
SELECT 
    'SourceDB3' AS DatabaseName,
    fg.name AS FileGroupName,
    SUM(f.size * 8 / 1024) AS SizeMB,
    SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024) AS UsedMB,
    SUM(f.size * 8 / 1024) - SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024) AS FreeMB,
    CAST((SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024) * 100.0) / 
         (SUM(f.size * 8 / 1024)) AS DECIMAL(5,2)) AS PercentUsed
FROM SourceDB3.sys.filegroups fg
JOIN SourceDB3.sys.database_files f ON fg.data_space_id = f.data_space_id
GROUP BY fg.name

UNION ALL

-- archive_db filegroups
SELECT 
    'archive_db' AS DatabaseName,
    fg.name AS FileGroupName,
    SUM(f.size * 8 / 1024) AS SizeMB,
    SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024) AS UsedMB,
    SUM(f.size * 8 / 1024) - SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024) AS FreeMB,
    CAST((SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024) * 100.0) / 
         (SUM(f.size * 8 / 1024)) AS DECIMAL(5,2)) AS PercentUsed
FROM archive_db.sys.filegroups fg
JOIN archive_db.sys.database_files f ON fg.data_space_id = f.data_space_id
GROUP BY fg.name;
GO

-- Procedure to show filegroup status summary
CREATE OR ALTER PROCEDURE control.sp_Show_Filegroup_Status
AS
BEGIN
    SET NOCOUNT ON;
    
    PRINT '========================================';
    PRINT 'FILEGROUP STATUS SUMMARY';
    PRINT 'Generated: ' + CONVERT(VARCHAR, GETDATE(), 120);
    PRINT '========================================';
    PRINT '';
    
    SELECT 
        DatabaseName,
        FileGroupName,
        SizeMB,
        UsedMB,
        FreeMB,
        PercentUsed,
        CASE 
            WHEN PercentUsed > 90 THEN 'CRITICAL'
            WHEN PercentUsed > 80 THEN 'WARNING'
            ELSE 'OK'
        END AS Status
    FROM control.vw_All_Filegroups_Status
    ORDER BY DatabaseName, FileGroupName;
END;
GO

PRINT 'Filegroup setup scripts completed successfully';
PRINT 'Run sp_Show_Filegroup_Status to view current filegroup status';
