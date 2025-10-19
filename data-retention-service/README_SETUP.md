# Data Retention Service - Setup Guide

This guide provides step-by-step instructions for setting up the Data Retention Service.

## Prerequisites

- Docker and Docker Compose
- Python 3.8+
- SQL Server 2022 (via Docker)

## Quick Setup

### 1. Start SQL Server Container

```bash
./start.sh
```

This will:
- Start SQL Server 2022 container
- Create necessary volumes
- Wait for SQL Server to be ready
- Show connection information

### 2. Initialize Control Database

```bash
./init_control_db.sh
```

This will:
- Create control_db and archive_db databases
- Create all required tables and procedures
- Validate the setup
- Show system information

### 3. Configure Archival Tables

Add entries to the archival configuration:

```sql
-- Connect to SQL Server and run:
USE control_db;

INSERT INTO control.archival_table_list (
    source_database, table_name, archival_enabled,
    months_before_archival, retention_years_in_archive,
    disposal_enabled, archive_db_schema, archive_db_table,
    date_column, primary_key_columns
) VALUES (
    'YourDB', 'YourTable', 1,
    3, 7, 1, 'YourDB', 'YourTable_Archive',
    'created_date', 'id'
);
```

### 4. Test the System

```bash
# Run comprehensive tests
./test_system.sh --full

# Or run tests only (if already setup)
./test_system.sh --test
```

## Detailed Setup

### Phase 1: Infrastructure Setup

#### Start SQL Server
```bash
./start.sh
```

**What it does:**
- Creates Docker container with SQL Server 2022
- Sets up persistent volumes
- Configures health checks
- Waits for SQL Server to be ready

**Verification:**
```bash
docker ps | grep archival-sqlserver-v2
```

#### Initialize Control Database
```bash
./init_control_db.sh
```

**What it does:**
- Creates control_db and archive_db databases
- Creates control schema and tables
- Creates all stored procedures
- Validates the setup

**Verification:**
```sql
EXEC control_db.control.sp_Validate_System_Prerequisites
```

### Phase 2: Configuration

#### Configure Archival Tables

For each table you want to archive:

```sql
USE control_db;

INSERT INTO control.archival_table_list (
    source_database,           -- Source database name
    table_name,                -- Table to archive
    archival_enabled,          -- Enable archival (1/0)
    months_before_archival,    -- Months before eligible (default: 3)
    retention_years_in_archive, -- Years to keep in archive (default: 7)
    disposal_enabled,          -- Enable disposal (1/0)
    disposal_method,           -- 'DELETE' or 'PARTITION_DROP'
    archive_db_schema,         -- Schema in archive_db
    archive_db_table,          -- Table name in archive_db
    date_column,               -- Column to check for date-based archival
    primary_key_columns        -- Comma-separated PK columns
) VALUES (
    'SourceDB1', 'Trade', 1,
    3, 7, 1, 'DELETE',
    'SourceDB1', 'Trade_Archive',
    'tradeDate', 'tradeId'
);
```

#### Configure Partitioning (Optional)

For high-performance archival, configure partitioning:

```sql
-- Create partition function
CREATE PARTITION FUNCTION PF_Trade_ArchivalFlag (BIT)
AS RANGE LEFT FOR VALUES (0);

-- Create partition scheme
CREATE PARTITION SCHEME PS_Trade_ArchivalFlag
AS PARTITION PF_Trade_ArchivalFlag
TO ([PRIMARY], [PRIMARY]);

-- Apply partitioning to table
ALTER TABLE Trade DROP CONSTRAINT PK_Trade;
ALTER TABLE Trade ADD CONSTRAINT PK_Trade PRIMARY KEY (tradeId, archival_flag)
ON PS_Trade_ArchivalFlag(archival_flag);
```

### Phase 3: Testing

#### Run Test Suite
```bash
./test_system.sh --full
```

**Tests included:**
- Idempotency testing
- Recovery testing
- Monitoring testing
- Performance testing
- End-to-end testing

#### Manual Testing
```bash
# Test archival workflow
python3 orchestrator.py --run

# Test disposal workflow
python3 orchestrator.py --dispose

# Test complete lifecycle
python3 orchestrator.py --lifecycle

# Check system status
python3 orchestrator.py --status
```

## Troubleshooting

### Common Issues

#### "SETUP REQUIRED" Error
**Cause:** Control database not initialized
**Solution:**
```bash
./init_control_db.sh
```

#### "SQL Server not responding"
**Cause:** Container not running or not ready
**Solution:**
```bash
# Check container status
docker ps | grep archival-sqlserver-v2

# Start container if needed
./start.sh

# Check container logs
docker logs archival-sqlserver-v2
```

#### "No tables configured for archival"
**Cause:** No entries in archival_table_list
**Solution:**
```sql
-- Add table configuration
INSERT INTO control.archival_table_list (...) VALUES (...);
```

#### "Partition function not found"
**Cause:** Table not partitioned or partition function missing
**Solution:**
```sql
-- Check if table is partitioned
EXEC control.sp_Detect_Partition_Info 'YourDB', 'YourTable'

-- Create partition function if needed
CREATE PARTITION FUNCTION PF_YourTable_ArchivalFlag (BIT)
AS RANGE LEFT FOR VALUES (0);
```

### Validation Commands

#### Check System Health
```sql
-- Validate prerequisites
EXEC control.sp_Validate_System_Prerequisites

-- Show system health
EXEC control.sp_Show_System_Health

-- Monitor executions
EXEC control.sp_Monitor_Executions
```

#### Check Configuration
```sql
-- List configured tables
SELECT * FROM control.archival_table_list WHERE active = 1;

-- Check recent executions
SELECT TOP 10 * FROM control.archival_execution_log 
ORDER BY execution_start DESC;
```

## Next Steps

After successful setup:

1. **Configure Production Tables**: Add your actual tables to archival_table_list
2. **Set Up Monitoring**: Configure alerting for failed executions
3. **Schedule Operations**: Set up automated archival schedules
4. **Backup Strategy**: Implement backup procedures for control and archive databases
5. **Security**: Configure access controls and audit logging

## Support

For issues and questions:
1. Check [OPERATIONS.md](OPERATIONS.md) for troubleshooting
2. Review execution logs
3. Run health checks
4. Contact system administrator

---

*Last Updated: [Current Date]*
*Version: 1.0*
