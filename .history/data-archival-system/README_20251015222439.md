# Data Archival System

A metadata-driven archival framework for 100+ tables across multiple databases, designed for SQL Server 2019 with Python orchestration.

## Features

- **Multi-database support**: Archive from multiple source databases to a single archive database
- **Metadata-driven**: Configuration-based approach, no hardcoded table names
- **Fail-safe**: Cumulative archival with idempotent operations
- **Recovery support**: Resume incomplete operations
- **Disposal holds**: Legal/operational holds to prevent deletion
- **Query access**: Read-only access to archived data
- **Python orchestration**: Parallel processing with retry logic

## Architecture

```
┌──────────────────────────────────────────────────────────────┐
│  Python Orchestrator (Weekly Cron)                           │
│  - Parallel marking and archival                             │
│  - Recovery management                                       │
│  - Status monitoring                                         │
└──────────────────────────────────────────────────────────────┘
                            │
            ┌───────────────┼───────────────┐
            │               │               │
            ▼               ▼               ▼
┌─────────────────┐ ┌──────────────┐ ┌─────────────────┐
│  SourceDB1      │ │  SourceDB2   │ │  SourceDB3      │
│  - Position     │ │  - Trade     │ │  - PriceHistory │
│  - Contract     │ │  - Contract  │ │                 │
└─────────────────┘ └──────────────┘ └─────────────────┘
            │               │               │
            └───────────────┼───────────────┘
                            ▼
┌──────────────────────────────────────────────────────────────┐
│  Archive Database                                            │
│  - SourceDB1 schema (Position)                               │
│  - SourceDB2 schema (Trade)                                 │
│  - SourceDB3 schema (PriceHistory)                          │
│  - control schema (disposal_queue, hold, etc.)              │
└──────────────────────────────────────────────────────────────┘
                            │
                            ▼
┌──────────────────────────────────────────────────────────────┐
│  Control Database                                            │
│  - archival_table_config (metadata)                         │
│  - archival_marker (eligibility tracking)                   │
│  - archival_execution_log (audit trail)                     │
│  - recovery_state (resume support)                         │
└──────────────────────────────────────────────────────────────┘
```

## Quick Start

### 1. Start the System

```bash
# Start SQL Server in Docker
./start.sh

# Wait for SQL Server to be ready (about 30 seconds)
```

### 2. Install Python Dependencies

```bash
pip install -r requirements.txt
```

### 3. Test the System

```bash
python test_system.py
```

### 4. Run Archival

```bash
# Show status
python archival_orchestrator.py --status

# Run archival
python archival_orchestrator.py --run
```

## Configuration

Tables are configured in `control_db.control.archival_table_config`:

```sql
-- Example configuration
INSERT INTO control.archival_table_config (
    source_database, table_schema, table_name, table_type, 
    archival_logic, join_to_contract, months_retention, 
    years_retention_archive, primary_key_columns, execution_priority
)
VALUES 
('SourceDB1', 'dbo', 'Position', 'FUNCTIONAL', 'CONTRACT_MATURITY', 
 'INNER JOIN SourceDB1.dbo.Contract c ON t.contractId = c.contractId', 
 13, 7, 'basketId,positionId,businessDate', 10);
```

### Archival Logic Types

- **CONTRACT_MATURITY**: Archive based on contract maturity date (13+ months)
- **DATE_BASED**: Archive based on a date column (e.g., asOfDate)

### Table Types

- **FUNCTIONAL**: Business data with contract relationships
- **REFERENCE**: Reference data with shorter retention
- **OPERATIONAL**: Audit/debug data with very short retention

## Usage Examples

### Check Status

```bash
python archival_orchestrator.py --status
```

### Run Weekly Archival

```bash
python archival_orchestrator.py --run
```

### Resume Incomplete Operations

```bash
python archival_orchestrator.py --resume
```

## SQL Examples

### Query Archived Data

```sql
-- Query archived positions
SELECT * FROM archive_db.SourceDB1.Position 
WHERE contractId = 'your-contract-id';

-- Query with metadata
SELECT p.*, a.archived_date, a.retention_expiry_date
FROM archive_db.SourceDB1.Position p
INNER JOIN archive_db.SourceDB1.Position a ON p.basketId = a.basketId
WHERE a.archived_date > '2024-01-01';
```

### Place Disposal Hold

```sql
-- Hold specific contract
INSERT INTO archive_db.control.hold (
    schema_name, table_name, scope_type, contractId, 
    reason, placed_by, hold_until
)
VALUES (
    'SourceDB1', 'Position', 'CONTRACT', 
    'your-contract-id', 'Legal hold', 'admin', '2026-12-31'
);
```

### Check Archival Status

```sql
-- View configuration
SELECT * FROM control_db.control.archival_table_config 
WHERE active = 1;

-- View recent executions
SELECT * FROM control_db.control.archival_execution_log 
ORDER BY execution_start DESC;

-- View recovery state
SELECT * FROM control_db.control.recovery_state 
WHERE phase NOT IN ('COMPLETED', 'STAGING_TRUNCATED');
```

## File Structure

```
data-archival-system/
├── docker-compose.yml          # Docker setup
├── start.sh                    # Startup script
├── archival_orchestrator.py    # Main Python orchestrator
├── test_system.py             # Test script
├── requirements.txt           # Python dependencies
├── README.md                  # This file
└── sql/                       # SQL initialization scripts
    ├── 01_create_databases.sql
    ├── 02_create_control_tables.sql
    ├── 03_create_archive_tables.sql
    ├── 04_create_helper_functions.sql
    ├── 05_create_test_tables.sql
    ├── 06_create_archive_schemas.sql
    ├── 07_create_stored_procedures.sql
    ├── 08_populate_config.sql
    └── 09_generate_test_data.sql
```

## Monitoring

### Logs

- Python logs: `archival_YYYYMMDD.log`
- SQL Server logs: Available via Docker logs

### Key Metrics

- Records marked per table
- Records archived per table
- Execution duration
- Error rates
- Recovery operations

### Alerts

Monitor for:
- Failed archival operations
- Long-running processes (>60 minutes)
- Recovery state inconsistencies
- Disposal hold violations

## Troubleshooting

### Common Issues

1. **Connection refused**: Wait for SQL Server to start (30+ seconds)
2. **Permission denied**: Ensure Docker has proper permissions
3. **Missing tables**: Run SQL scripts in order
4. **Archival failures**: Check recovery state and resume

### Recovery Commands

```bash
# Check status
python archival_orchestrator.py --status

# Resume incomplete operations
python archival_orchestrator.py --resume

# Check Docker logs
docker logs archival-sqlserver
```

## Production Deployment

### Docker Compose (Recommended)

```yaml
version: '3.8'
services:
  sqlserver:
    image: mcr.microsoft.com/mssql/server:2019-latest
    environment:
      - ACCEPT_EULA=Y
      - SA_PASSWORD=YourSecurePassword!
    volumes:
      - sqlserver_data:/var/opt/mssql
      - ./sql:/docker-entrypoint-initdb.d
    ports:
      - "1433:1433"
```

### Kubernetes CronJob

```yaml
apiVersion: batch/v1
kind: CronJob
metadata:
  name: weekly-archival
spec:
  schedule: "0 2 * * 0"  # Sundays at 2 AM
  jobTemplate:
    spec:
      template:
        spec:
          containers:
          - name: archival-orchestrator
            image: your-registry/archival-orchestrator:latest
            env:
            - name: DB_CONNECTION_STRING
              valueFrom:
                secretKeyRef:
                  name: db-credentials
                  key: connection-string
```

## Performance

### Expected Performance

- **Marking**: 20 tables in parallel (~5-10 minutes)
- **Archival**: 10 tables in parallel (~15-30 minutes)
- **Disposal**: Sequential processing (~5-10 minutes)
- **Total**: <60 minutes for 100+ tables

### Optimization Tips

1. Use partitioning for high-volume tables
2. Adjust `max_workers` based on system resources
3. Schedule during low-traffic windows
4. Monitor and tune batch sizes

## Security

- Use strong passwords for SQL Server
- Restrict network access to SQL Server
- Use read-only accounts for query access
- Encrypt sensitive configuration data
- Regular security updates

## License

This project is provided as-is for demonstration purposes.
