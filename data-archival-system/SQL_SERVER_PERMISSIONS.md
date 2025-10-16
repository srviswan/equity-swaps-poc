# SQL Server Permission Requirements for Data Archival System

## Overview

The data archival system requires specific SQL Server permissions to operate effectively and securely. This document outlines the permission matrix for different user roles and provides implementation guidance.

## User Roles and Permission Requirements

### 1. 🚀 **ARCHIVAL_SERVICE** (Primary Service Account)
**Purpose**: Main service account that runs the Python orchestrator

**Server-Level Permissions**:
- `VIEW SERVER STATE` - Monitor server health and performance
- `VIEW ANY DEFINITION` - Access metadata for dynamic SQL generation

**Database-Level Permissions**:

| Database | Permissions | Purpose |
|----------|-------------|---------|
| **SourceDB1, SourceDB2, SourceDB3** | `db_datareader`, `db_datawriter`<br>`CREATE TABLE`, `CREATE PROCEDURE`<br>`CREATE FUNCTION`, `CREATE SCHEMA`<br>`ALTER ON SCHEMA::dbo`<br>`EXECUTE ON SCHEMA::dbo` | Read source data, create staging tables, execute archival procedures |
| **archive_db** | `db_owner` | Full control over archive database |
| **control_db** | `db_owner` | Full control over control database |

**Specific Table Permissions**:
- **Control Tables**: `SELECT`, `INSERT`, `UPDATE`, `DELETE` on all control tables
- **Archive Tables**: `SELECT`, `INSERT`, `UPDATE`, `DELETE` on all archive tables
- **Stored Procedures**: `EXECUTE` on all archival procedures
- **Functions**: `EXECUTE` on all helper functions

### 2. 📖 **ARCHIVE_READER** (Read-Only Query User)
**Purpose**: Users who need to query archived data but not modify anything

**Server-Level Permissions**:
- `VIEW SERVER STATE` - Basic server monitoring

**Database-Level Permissions**:

| Database | Permissions | Purpose |
|----------|-------------|---------|
| **archive_db** | `db_datareader`<br>`SELECT ON SCHEMA::SourceDB1`<br>`SELECT ON SCHEMA::SourceDB2`<br>`SELECT ON SCHEMA::SourceDB3`<br>`SELECT ON SCHEMA::control` | Query archived data and metadata |
| **control_db** | `db_datareader`<br>`SELECT ON SCHEMA::control` | Read configuration and logs |

### 3. 🔧 **ARCHIVAL_ADMIN** (System Administrator)
**Purpose**: System administrators who need full control

**Server-Level Permissions**:
- `sysadmin` - Full server control

### 4. 📊 **ARCHIVAL_MONITOR** (Monitoring System)
**Purpose**: Monitoring systems that check status and logs

**Server-Level Permissions**:
- `VIEW SERVER STATE` - Server health monitoring

**Database-Level Permissions**:

| Database | Permissions | Purpose |
|----------|-------------|---------|
| **archive_db** | `db_datareader`<br>`SELECT ON SCHEMA::control` | Monitor archive status |
| **control_db** | `db_datareader`<br>`SELECT ON SCHEMA::control` | Monitor execution logs |

### 5. 🛡️ **DISPOSAL_MANAGER** (Hold Management)
**Purpose**: Users who manage disposal holds for legal compliance

**Database-Level Permissions**:

| Database | Permissions | Purpose |
|----------|-------------|---------|
| **archive_db** | `db_datareader`<br>`INSERT`, `UPDATE`, `DELETE` on `control.hold`<br>`INSERT`, `UPDATE`, `DELETE` on `control.hold_audit`<br>`SELECT ON SCHEMA::control` | Manage disposal holds |

## Implementation Steps

### Step 1: Create Logins
```sql
-- Create service account
CREATE LOGIN [archival_service] WITH PASSWORD = 'StrongPassword123!', 
    DEFAULT_DATABASE = [control_db],
    CHECK_EXPIRATION = ON,
    CHECK_POLICY = ON;

-- Create read-only user
CREATE LOGIN [archive_reader] WITH PASSWORD = 'ReadOnlyPassword123!', 
    DEFAULT_DATABASE = [archive_db],
    CHECK_EXPIRATION = ON,
    CHECK_POLICY = ON;

-- Create monitoring user
CREATE LOGIN [archival_monitor] WITH PASSWORD = 'MonitorPassword123!', 
    DEFAULT_DATABASE = [control_db],
    CHECK_EXPIRATION = ON,
    CHECK_POLICY = ON;

-- Create disposal manager
CREATE LOGIN [disposal_manager] WITH PASSWORD = 'DisposalPassword123!', 
    DEFAULT_DATABASE = [archive_db],
    CHECK_EXPIRATION = ON,
    CHECK_POLICY = ON;
```

### Step 2: Create Database Users
```sql
-- For each database
USE [database_name];
CREATE USER [archival_service] FOR LOGIN [archival_service];
CREATE USER [archive_reader] FOR LOGIN [archive_reader];
CREATE USER [archival_monitor] FOR LOGIN [archival_monitor];
CREATE USER [disposal_manager] FOR LOGIN [disposal_manager];
```

### Step 3: Assign Roles and Permissions
```sql
-- Assign database roles
ALTER ROLE db_datareader ADD MEMBER [archival_service];
ALTER ROLE db_datawriter ADD MEMBER [archival_service];
ALTER ROLE db_owner ADD MEMBER [archival_service]; -- For archive and control DBs

-- Grant specific permissions
GRANT CREATE TABLE TO [archival_service];
GRANT CREATE PROCEDURE TO [archival_service];
GRANT CREATE FUNCTION TO [archival_service];
GRANT CREATE SCHEMA TO [archival_service];
GRANT EXECUTE ON SCHEMA::dbo TO [archival_service];
```

## Security Best Practices

### 1. **Password Management**
- Use strong passwords (minimum 12 characters)
- Enable password expiration and complexity
- Rotate passwords regularly
- Use Windows Authentication when possible

### 2. **Principle of Least Privilege**
- Grant only necessary permissions
- Use specific database roles
- Avoid granting `sysadmin` unless absolutely necessary
- Regularly review and audit permissions

### 3. **Audit and Monitoring**
```sql
-- Enable SQL Server Audit
CREATE SERVER AUDIT [ArchivalAudit] TO FILE (FILEPATH = 'C:\Audit\');
ALTER SERVER AUDIT [ArchivalAudit] WITH (STATE = ON);

-- Create database audit specification
CREATE DATABASE AUDIT SPECIFICATION [ArchivalDBAudit] FOR SERVER AUDIT [ArchivalAudit]
ADD (SELECT, INSERT, UPDATE, DELETE ON control.archival_table_config BY [archival_service]),
ADD (SELECT, INSERT, UPDATE, DELETE ON control.archival_marker BY [archival_service]);
```

### 4. **Network Security**
- Restrict network access to SQL Server
- Use encrypted connections (TLS/SSL)
- Implement firewall rules
- Use VPN for remote access

### 5. **Data Protection**
- Enable Transparent Data Encryption (TDE)
- Use Always Encrypted for sensitive columns
- Implement row-level security for sensitive data
- Regular backup and recovery testing

## Production Deployment Considerations

### 1. **Service Account Management**
- Use dedicated service accounts (not personal accounts)
- Implement service account lifecycle management
- Use Azure AD Managed Service Identity (MSI) for cloud deployments
- Consider using SQL Server Authentication with certificate-based login

### 2. **Environment Separation**
- Use different service accounts for different environments
- Implement environment-specific permission sets
- Use separate databases for dev/test/prod
- Implement data masking for non-production environments

### 3. **Compliance Requirements**
- Implement GDPR compliance for data retention
- Enable audit logging for regulatory requirements
- Implement data classification and handling policies
- Regular security assessments and penetration testing

## Troubleshooting Permission Issues

### Common Permission Errors:

1. **"The SELECT permission was denied"**
   - Grant `SELECT` permission on specific tables
   - Add user to `db_datareader` role

2. **"The INSERT permission was denied"**
   - Grant `INSERT` permission on specific tables
   - Add user to `db_datawriter` role

3. **"The EXECUTE permission was denied"**
   - Grant `EXECUTE` permission on stored procedures
   - Add user to `db_ddladmin` role for schema changes

4. **"The CREATE TABLE permission was denied"**
   - Grant `CREATE TABLE` permission
   - Add user to `db_ddladmin` role

### Permission Verification Queries:
```sql
-- Check user permissions
SELECT 
    p.state_desc,
    p.permission_name,
    s.name AS schema_name,
    o.name AS object_name
FROM sys.database_permissions p
LEFT JOIN sys.objects o ON p.major_id = o.object_id
LEFT JOIN sys.schemas s ON o.schema_id = s.schema_id
WHERE p.grantee_principal_id = USER_ID('archival_service');

-- Check role membership
SELECT 
    r.name AS role_name,
    m.name AS member_name
FROM sys.database_role_members rm
JOIN sys.database_principals r ON rm.role_principal_id = r.principal_id
JOIN sys.database_principals m ON rm.member_principal_id = m.principal_id
WHERE m.name = 'archival_service';
```

## Summary

The data archival system requires a well-structured permission model to ensure:
- **Security**: Least privilege access with proper audit trails
- **Functionality**: Sufficient permissions for all operations
- **Compliance**: Meeting regulatory and organizational requirements
- **Maintainability**: Clear role separation and easy management

Implement the permission matrix gradually, starting with the service account and adding other roles as needed. Regular permission audits and reviews are essential for maintaining security and compliance.
