-- SQL Server Permission Matrix for Data Archival System
-- =====================================================

-- ==========================================
-- 1. ARCHIVAL SERVICE ACCOUNT (Primary User)
-- ==========================================
-- This is the main service account that runs the Python orchestrator
-- Needs comprehensive permissions across all databases

-- Server-level permissions
GRANT VIEW SERVER STATE TO [archival_service];
GRANT VIEW ANY DEFINITION TO [archival_service];

-- Database-level permissions for each source database
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

-- Archive database permissions (full control)
USE archive_db;
CREATE USER [archival_service] FOR LOGIN [archival_service];
ALTER ROLE db_owner ADD MEMBER [archival_service];

-- Control database permissions (full control)
USE control_db;
CREATE USER [archival_service] FOR LOGIN [archival_service];
ALTER ROLE db_owner ADD MEMBER [archival_service];

-- ==========================================
-- 2. READ-ONLY QUERY USER (Archive Access)
-- ==========================================
-- For users who need to query archived data but not modify anything

-- Server-level permissions
GRANT VIEW SERVER STATE TO [archive_reader];

-- Archive database permissions (read-only)
USE archive_db;
CREATE USER [archive_reader] FOR LOGIN [archive_reader];
ALTER ROLE db_datareader ADD MEMBER [archive_reader];
GRANT SELECT ON SCHEMA::SourceDB1 TO [archive_reader];
GRANT SELECT ON SCHEMA::SourceDB2 TO [archive_reader];
GRANT SELECT ON SCHEMA::SourceDB3 TO [archive_reader];
GRANT SELECT ON SCHEMA::control TO [archive_reader];

-- Control database permissions (read-only for monitoring)
USE control_db;
CREATE USER [archive_reader] FOR LOGIN [archive_reader];
ALTER ROLE db_datareader ADD MEMBER [archive_reader];
GRANT SELECT ON SCHEMA::control TO [archive_reader];

-- ==========================================
-- 3. ADMINISTRATOR USER (Full Control)
-- ==========================================
-- For system administrators who need full control

-- Server-level permissions
ALTER SERVER ROLE sysadmin ADD MEMBER [archival_admin];

-- ==========================================
-- 4. MONITORING USER (Status & Logs)
-- ==========================================
-- For monitoring systems that need to check status and logs

-- Server-level permissions
GRANT VIEW SERVER STATE TO [archival_monitor];

-- Control database permissions (read-only for monitoring)
USE control_db;
CREATE USER [archival_monitor] FOR LOGIN [archival_monitor];
ALTER ROLE db_datareader ADD MEMBER [archival_monitor];
GRANT SELECT ON SCHEMA::control TO [archival_monitor];

-- Archive database permissions (read-only for monitoring)
USE archive_db;
CREATE USER [archival_monitor] FOR LOGIN [archival_monitor];
ALTER ROLE db_datareader ADD MEMBER [archival_monitor];
GRANT SELECT ON SCHEMA::control TO [archival_monitor];

-- ==========================================
-- 5. DISPOSAL HOLD MANAGER
-- ==========================================
-- For users who need to manage disposal holds

-- Archive database permissions (hold management)
USE archive_db;
CREATE USER [disposal_manager] FOR LOGIN [disposal_manager];
ALTER ROLE db_datareader ADD MEMBER [disposal_manager];
GRANT INSERT, UPDATE, DELETE ON control.hold TO [disposal_manager];
GRANT INSERT, UPDATE, DELETE ON control.hold_audit TO [disposal_manager];
GRANT SELECT ON SCHEMA::control TO [disposal_manager];

-- ==========================================
-- SPECIFIC TABLE-LEVEL PERMISSIONS
-- ==========================================

-- Control tables permissions
USE control_db;
-- Archival service needs full control
GRANT SELECT, INSERT, UPDATE, DELETE ON control.archival_table_config TO [archival_service];
GRANT SELECT, INSERT, UPDATE, DELETE ON control.archival_marker TO [archival_service];
GRANT SELECT, INSERT, UPDATE, DELETE ON control.archival_execution_log TO [archival_service];
GRANT SELECT, INSERT, UPDATE, DELETE ON control.recovery_state TO [archival_service];

-- Archive tables permissions
USE archive_db;
-- Archival service needs full control
GRANT SELECT, INSERT, UPDATE, DELETE ON SourceDB1.Position TO [archival_service];
GRANT SELECT, INSERT, UPDATE, DELETE ON SourceDB2.Trade TO [archival_service];
GRANT SELECT, INSERT, UPDATE, DELETE ON SourceDB3.PriceHistory TO [archival_service];

-- Control tables in archive database
GRANT SELECT, INSERT, UPDATE, DELETE ON control.disposal_queue TO [archival_service];
GRANT SELECT, INSERT, UPDATE, DELETE ON control.quarantine TO [archival_service];
GRANT SELECT, INSERT, UPDATE, DELETE ON control.merge_audit TO [archival_service];
GRANT SELECT, INSERT, UPDATE, DELETE ON control.hold TO [archival_service];
GRANT SELECT, INSERT, UPDATE, DELETE ON control.hold_audit TO [archival_service];

-- ==========================================
-- STORED PROCEDURE PERMISSIONS
-- ==========================================

-- Control database procedures
USE control_db;
GRANT EXECUTE ON control.sp_Mark_Table_Archival_Eligible TO [archival_service];
GRANT EXECUTE ON control.sp_Archive_Table_Bulk_Copy TO [archival_service];
GRANT EXECUTE ON control.sp_Dispose_Expired_Records TO [archival_service];
GRANT EXECUTE ON control.sp_Fqn TO [archival_service];

-- ==========================================
-- FUNCTION PERMISSIONS
-- ==========================================

-- Control database functions
USE control_db;
GRANT EXECUTE ON control.fn_Build_PK_String TO [archival_service];
GRANT EXECUTE ON control.fn_Build_PK_Hash TO [archival_service];
GRANT EXECUTE ON control.fn_Build_PK_Join TO [archival_service];

-- ==========================================
-- SECURITY BEST PRACTICES
-- ==========================================

-- 1. Create the login first
CREATE LOGIN [archival_service] WITH PASSWORD = 'StrongPassword123!', 
    DEFAULT_DATABASE = [control_db],
    CHECK_EXPIRATION = ON,
    CHECK_POLICY = ON;

CREATE LOGIN [archive_reader] WITH PASSWORD = 'ReadOnlyPassword123!', 
    DEFAULT_DATABASE = [archive_db],
    CHECK_EXPIRATION = ON,
    CHECK_POLICY = ON;

CREATE LOGIN [archival_admin] WITH PASSWORD = 'AdminPassword123!', 
    DEFAULT_DATABASE = [control_db],
    CHECK_EXPIRATION = ON,
    CHECK_POLICY = ON;

CREATE LOGIN [archival_monitor] WITH PASSWORD = 'MonitorPassword123!', 
    DEFAULT_DATABASE = [control_db],
    CHECK_EXPIRATION = ON,
    CHECK_POLICY = ON;

CREATE LOGIN [disposal_manager] WITH PASSWORD = 'DisposalPassword123!', 
    DEFAULT_DATABASE = [archive_db],
    CHECK_EXPIRATION = ON,
    CHECK_POLICY = ON;

-- 2. Enable contained database authentication (optional)
-- ALTER DATABASE control_db SET CONTAINMENT = PARTIAL;
-- ALTER DATABASE archive_db SET CONTAINMENT = PARTIAL;

-- 3. Create database roles for better management
USE control_db;
CREATE ROLE archival_operators;
CREATE ROLE archival_readers;
CREATE ROLE archival_monitors;

-- Add users to roles
ALTER ROLE archival_operators ADD MEMBER [archival_service];
ALTER ROLE archival_readers ADD MEMBER [archive_reader];
ALTER ROLE archival_monitors ADD MEMBER [archival_monitor];

-- Grant permissions to roles
GRANT SELECT, INSERT, UPDATE, DELETE ON SCHEMA::control TO archival_operators;
GRANT SELECT ON SCHEMA::control TO archival_readers;
GRANT SELECT ON SCHEMA::control TO archival_monitors;

-- ==========================================
-- AUDIT PERMISSIONS
-- ==========================================

-- Enable SQL Server Audit (if available)
-- CREATE SERVER AUDIT [ArchivalAudit] TO FILE (FILEPATH = 'C:\Audit\');
-- ALTER SERVER AUDIT [ArchivalAudit] WITH (STATE = ON);

-- Create database audit specification
-- USE control_db;
-- CREATE DATABASE AUDIT SPECIFICATION [ArchivalDBAudit] FOR SERVER AUDIT [ArchivalAudit]
-- ADD (SELECT, INSERT, UPDATE, DELETE ON control.archival_table_config BY [archival_service]),
-- ADD (SELECT, INSERT, UPDATE, DELETE ON control.archival_marker BY [archival_service]),
-- ADD (SELECT, INSERT, UPDATE, DELETE ON control.archival_execution_log BY [archival_service]);
-- ALTER DATABASE AUDIT SPECIFICATION [ArchivalDBAudit] WITH (STATE = ON);

-- ==========================================
-- PERMISSION SUMMARY
-- ==========================================

/*
PERMISSION SUMMARY BY USER ROLE:

1. ARCHIVAL_SERVICE (Primary Service Account):
   - Server: VIEW SERVER STATE, VIEW ANY DEFINITION
   - Source DBs: db_datareader, db_datawriter, CREATE TABLE/PROCEDURE/FUNCTION/SCHEMA
   - Archive DB: db_owner (full control)
   - Control DB: db_owner (full control)
   - All stored procedures and functions

2. ARCHIVE_READER (Read-Only Query User):
   - Server: VIEW SERVER STATE
   - Archive DB: db_datareader, SELECT on all schemas
   - Control DB: db_datareader, SELECT on control schema

3. ARCHIVAL_ADMIN (System Administrator):
   - Server: sysadmin (full control)

4. ARCHIVAL_MONITOR (Monitoring System):
   - Server: VIEW SERVER STATE
   - Archive DB: db_datareader, SELECT on control schema
   - Control DB: db_datareader, SELECT on control schema

5. DISPOSAL_MANAGER (Hold Management):
   - Archive DB: db_datareader, INSERT/UPDATE/DELETE on hold tables

SECURITY NOTES:
- All passwords should be strong and rotated regularly
- Use Windows Authentication when possible
- Enable SQL Server Audit for compliance
- Consider using Azure AD authentication for cloud deployments
- Implement row-level security for sensitive data
- Use encryption for data at rest and in transit
*/
