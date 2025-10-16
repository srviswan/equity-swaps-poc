# SQL Server Permission Requirements Summary

## 🎯 **Quick Answer: What Permissions Does the User Need?**

For the **data archival system** to work properly, you need **5 different user roles** with specific permission levels:

### 1. 🚀 **ARCHIVAL_SERVICE** (Primary Service Account)
**Used by**: Python orchestrator, main archival operations

**Required Permissions**:
- **Server Level**: `VIEW SERVER STATE`, `VIEW ANY DEFINITION`
- **Source Databases**: `db_datareader`, `db_datawriter`, `CREATE TABLE`, `CREATE PROCEDURE`, `CREATE FUNCTION`, `CREATE SCHEMA`
- **Archive Database**: `db_owner` (full control)
- **Control Database**: `db_owner` (full control)

### 2. 📖 **ARCHIVE_READER** (Read-Only Query User)
**Used by**: Users querying archived data, reporting systems

**Required Permissions**:
- **Server Level**: `VIEW SERVER STATE`
- **Archive Database**: `db_datareader`, `SELECT` on all schemas
- **Control Database**: `db_datareader`, `SELECT` on control schema

### 3. 📊 **ARCHIVAL_MONITOR** (Monitoring System)
**Used by**: Monitoring systems, dashboards, alerting

**Required Permissions**:
- **Server Level**: `VIEW SERVER STATE`
- **Archive Database**: `db_datareader`, `SELECT` on control schema
- **Control Database**: `db_datareader`, `SELECT` on control schema

### 4. 🛡️ **DISPOSAL_MANAGER** (Hold Management)
**Used by**: Legal compliance, disposal hold management

**Required Permissions**:
- **Archive Database**: `db_datareader`, `INSERT/UPDATE/DELETE` on hold tables

### 5. 🔧 **ARCHIVAL_ADMIN** (System Administrator)
**Used by**: System administrators, maintenance

**Required Permissions**:
- **Server Level**: `sysadmin` (full control)

## 📋 **Permission Matrix**

| User Role | Server Permissions | Source DBs | Archive DB | Control DB | Purpose |
|-----------|-------------------|------------|------------|------------|---------|
| **archival_service** | VIEW SERVER STATE<br>VIEW ANY DEFINITION | db_datareader<br>db_datawriter<br>CREATE objects | db_owner | db_owner | Main service account |
| **archive_reader** | VIEW SERVER STATE | None | db_datareader<br>SELECT schemas | db_datareader | Query archived data |
| **archival_monitor** | VIEW SERVER STATE | None | db_datareader<br>SELECT control | db_datareader | Monitor system status |
| **disposal_manager** | None | None | db_datareader<br>INSERT/UPDATE/DELETE holds | None | Manage disposal holds |
| **archival_admin** | sysadmin | Full control | Full control | Full control | System administration |

## 🔧 **Implementation Commands**

### Create Service Account:
```sql
CREATE LOGIN [archival_service] WITH PASSWORD = 'StrongPassword123!', 
    DEFAULT_DATABASE = [control_db],
    CHECK_EXPIRATION = ON,
    CHECK_POLICY = ON;
```

### Grant Database Permissions:
```sql
-- For each source database
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

-- For archive database
USE archive_db;
CREATE USER [archival_service] FOR LOGIN [archival_service];
ALTER ROLE db_owner ADD MEMBER [archival_service];

-- For control database
USE control_db;
CREATE USER [archival_service] FOR LOGIN [archival_service];
ALTER ROLE db_owner ADD MEMBER [archival_service];
```

### Grant Server Permissions:
```sql
USE master;
GRANT VIEW SERVER STATE TO [archival_service];
GRANT VIEW ANY DEFINITION TO [archival_service];
```

## 🔒 **Security Best Practices**

1. **Use Strong Passwords**: Minimum 12 characters with complexity
2. **Enable Password Expiration**: Regular password rotation
3. **Principle of Least Privilege**: Grant only necessary permissions
4. **Enable Auditing**: Track all permission changes
5. **Use Windows Authentication**: When possible, prefer Windows auth
6. **Regular Permission Reviews**: Audit permissions quarterly

## 🚨 **Common Permission Issues**

| Error | Solution |
|-------|----------|
| "SELECT permission denied" | Grant `SELECT` or add to `db_datareader` |
| "INSERT permission denied" | Grant `INSERT` or add to `db_datawriter` |
| "EXECUTE permission denied" | Grant `EXECUTE` on stored procedures |
| "CREATE TABLE permission denied" | Grant `CREATE TABLE` or add to `db_ddladmin` |

## ✅ **Verification Commands**

### Test Service Account:
```sql
EXECUTE AS USER = 'archival_service';
SELECT COUNT(*) FROM SourceDB1.dbo.Position;
SELECT COUNT(*) FROM archive_db.SourceDB1.Position;
SELECT COUNT(*) FROM control_db.control.archival_table_config;
REVERT;
```

### Check Permissions:
```sql
SELECT 
    p.state_desc,
    p.permission_name,
    s.name AS schema_name,
    o.name AS object_name
FROM sys.database_permissions p
LEFT JOIN sys.objects o ON p.major_id = o.object_id
LEFT JOIN sys.schemas s ON o.schema_id = s.schema_id
WHERE p.grantee_principal_id = USER_ID('archival_service');
```

## 🎯 **Production Recommendations**

1. **Use Dedicated Service Accounts**: Never use personal accounts
2. **Implement Service Account Lifecycle**: Regular rotation and monitoring
3. **Use Azure AD MSI**: For cloud deployments
4. **Enable TDE**: Transparent Data Encryption for data at rest
5. **Implement Row-Level Security**: For sensitive data
6. **Regular Security Assessments**: Quarterly permission audits

## 📊 **Current System Status**

✅ **Permissions Successfully Configured**:
- `archival_service`: Full control over archival operations
- `archive_reader`: Read-only access to archived data
- `archival_monitor`: Monitoring and status access
- `disposal_manager`: Hold management capabilities
- `archival_admin`: Full administrative control

The system is now ready for production deployment with proper security controls! 🎉
