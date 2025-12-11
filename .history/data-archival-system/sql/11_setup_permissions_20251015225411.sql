-- Practical Permission Setup for Current Archival System
-- =====================================================

-- Step 1: Create the archival service account
CREATE LOGIN [archival_service] WITH PASSWORD = 'ArchivalService@2025!', 
    DEFAULT_DATABASE = [control_db],
    CHECK_EXPIRATION = ON,
    CHECK_POLICY = ON;

-- Step 2: Create users in each database
USE SourceDB1;
CREATE USER [archival_service] FOR LOGIN [archival_service];
ALTER ROLE db_datareader ADD MEMBER [archival_service];
ALTER ROLE db_datawriter ADD MEMBER [archival_service];
GRANT CREATE TABLE TO [archival_service];
GRANT CREATE PROCEDURE TO [archival_service];
GRANT CREATE FUNCTION TO [archival_service];
GRANT CREATE SCHEMA TO [archival_service];
GRANT ALTER ON SCHEMA::dbo TO [archival_service];
GRANT EXECUTE ON SCHEMA::dbo TO [archival_service];

USE SourceDB2;
CREATE USER [archival_service] FOR LOGIN [archival_service];
ALTER ROLE db_datareader ADD MEMBER [archival_service];
ALTER ROLE db_datawriter ADD MEMBER [archival_service];
GRANT CREATE TABLE TO [archival_service];
GRANT CREATE PROCEDURE TO [archival_service];
GRANT CREATE FUNCTION TO [archival_service];
GRANT CREATE SCHEMA TO [archival_service];
GRANT ALTER ON SCHEMA::dbo TO [archival_service];
GRANT EXECUTE ON SCHEMA::dbo TO [archival_service];

USE SourceDB3;
CREATE USER [archival_service] FOR LOGIN [archival_service];
ALTER ROLE db_datareader ADD MEMBER [archival_service];
ALTER ROLE db_datawriter ADD MEMBER [archival_service];
GRANT CREATE TABLE TO [archival_service];
GRANT CREATE PROCEDURE TO [archival_service];
GRANT CREATE FUNCTION TO [archival_service];
GRANT CREATE SCHEMA TO [archival_service];
GRANT ALTER ON SCHEMA::dbo TO [archival_service];
GRANT EXECUTE ON SCHEMA::dbo TO [archival_service];

-- Step 3: Full control on archive and control databases
USE archive_db;
CREATE USER [archival_service] FOR LOGIN [archival_service];
ALTER ROLE db_owner ADD MEMBER [archival_service];

USE control_db;
CREATE USER [archival_service] FOR LOGIN [archival_service];
ALTER ROLE db_owner ADD MEMBER [archival_service];

-- Step 4: Grant server-level permissions
GRANT VIEW SERVER STATE TO [archival_service];
GRANT VIEW ANY DEFINITION TO [archival_service];

-- Step 5: Create read-only user for archive queries
CREATE LOGIN [archive_reader] WITH PASSWORD = 'ArchiveReader@2025!', 
    DEFAULT_DATABASE = [archive_db],
    CHECK_EXPIRATION = ON,
    CHECK_POLICY = ON;

USE archive_db;
CREATE USER [archive_reader] FOR LOGIN [archive_reader];
ALTER ROLE db_datareader ADD MEMBER [archive_reader];
GRANT SELECT ON SCHEMA::SourceDB1 TO [archive_reader];
GRANT SELECT ON SCHEMA::SourceDB2 TO [archive_reader];
GRANT SELECT ON SCHEMA::SourceDB3 TO [archive_reader];
GRANT SELECT ON SCHEMA::control TO [archive_reader];

USE control_db;
CREATE USER [archive_reader] FOR LOGIN [archive_reader];
ALTER ROLE db_datareader ADD MEMBER [archive_reader];
GRANT SELECT ON SCHEMA::control TO [archive_reader];

-- Step 6: Create monitoring user
CREATE LOGIN [archival_monitor] WITH PASSWORD = 'ArchivalMonitor@2025!', 
    DEFAULT_DATABASE = [control_db],
    CHECK_EXPIRATION = ON,
    CHECK_POLICY = ON;

USE control_db;
CREATE USER [archival_monitor] FOR LOGIN [archival_monitor];
ALTER ROLE db_datareader ADD MEMBER [archival_monitor];
GRANT SELECT ON SCHEMA::control TO [archival_monitor];

USE archive_db;
CREATE USER [archival_monitor] FOR LOGIN [archival_monitor];
ALTER ROLE db_datareader ADD MEMBER [archival_monitor];
GRANT SELECT ON SCHEMA::control TO [archival_monitor];

-- Step 7: Test the permissions
PRINT 'Testing archival_service permissions...';

-- Test source database access
USE SourceDB1;
EXECUTE AS USER = 'archival_service';
SELECT COUNT(*) as PositionCount FROM dbo.Position;
REVERT;

-- Test archive database access
USE archive_db;
EXECUTE AS USER = 'archival_service';
SELECT COUNT(*) as ArchivedCount FROM SourceDB1.Position;
REVERT;

-- Test control database access
USE control_db;
EXECUTE AS USER = 'archival_service';
SELECT COUNT(*) as ConfigCount FROM control.archival_table_config;
REVERT;

-- Test read-only user
USE archive_db;
EXECUTE AS USER = 'archive_reader';
SELECT COUNT(*) as ReadOnlyCount FROM SourceDB1.Position;
REVERT;

PRINT 'Permission setup completed successfully!';
