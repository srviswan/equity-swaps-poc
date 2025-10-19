# Data Retention Service

A production-ready data archival and retention system with comprehensive lifecycle management, resilience, and monitoring capabilities.

## Features

- **Complete Lifecycle Management**: Archive → Retain → Dispose
- **High-Performance Data Movement**: Partition switching, BCP, bulk operations
- **Resilience & Recovery**: Idempotent operations, automatic retry, resume capability
- **Comprehensive Monitoring**: Real-time metrics, health checks, alerting
- **Retention Policies**: Configurable retention periods with compliance holds
- **Partition Support**: Automatic partition detection and switching
- **Audit Trail**: Complete tracking of all operations
- **Test Suite**: Comprehensive testing with failure injection

## Architecture

### Core Components

1. **Control Database**: Configuration, tracking, and monitoring
2. **Archive Database**: Long-term storage of archived data
3. **Source Databases**: Original data sources
4. **Orchestrator**: Python-based workflow management
5. **Monitoring**: Real-time health checks and metrics

### Data Flow

```
Source DB → Staging Table → Archive DB → Disposal
    ↓           ↓            ↓          ↓
  Mark      Partition     Retain     Dispose
 Records    Switch/Copy   Data       Old Data
```

## Quick Start

### Prerequisites

- Docker and Docker Compose
- Python 3.8+
- SQL Server 2022 (via Docker)

### Installation

1. **Start SQL Server**
   ```bash
   ./start.sh
   ```

2. **Initialize Control Database**
   ```bash
   ./init_control_db.sh
   ```

3. **Configure Archival Tables**
   ```sql
   INSERT INTO control.archival_table_list (
       source_database, table_name, archival_enabled,
       months_before_archival, retention_years_in_archive,
       disposal_enabled, archive_db_schema, archive_db_table
   ) VALUES (
       'YourDB', 'YourTable', 1,
       3, 7, 1, 'YourDB', 'YourTable_Archive'
   );
   ```

4. **Run Archival Workflow**
   ```bash
   python3 orchestrator.py --run
   ```

## Usage

### Basic Operations

```bash
# Run monthly archival
python3 orchestrator.py --run

# Run disposal only
python3 orchestrator.py --dispose

# Run complete lifecycle
python3 orchestrator.py --lifecycle

# Check system status
python3 orchestrator.py --status

# Monitor running operations
python3 orchestrator.py --monitor

# Resume failed operations
python3 orchestrator.py --resume
```

### Advanced Operations

```bash
# Run with custom connection string
python3 orchestrator.py --run --connection-string "Server=..."

# Run tests
./tests/run_tests.sh

# Test idempotency
./tests/test_idempotency.sh
```

## Configuration

### Archival Table Configuration

```sql
-- Configure table for archival
INSERT INTO control.archival_table_list (
    source_database,           -- Source database name
    table_name,                -- Table to archive
    archival_enabled,          -- Enable archival (1/0)
    months_before_archival,    -- Months before eligible (default: 3)
    retention_years_in_archive, -- Years to keep in archive (default: 7)
    disposal_enabled,          -- Enable disposal (1/0)
    disposal_method,           -- 'DELETE' or 'PARTITION_DROP'
    archive_db_schema,         -- Schema in archive_db
    archive_db_table           -- Table name in archive_db
) VALUES (
    'SourceDB1', 'Trade', 1,
    3, 7, 1, 'DELETE',
    'SourceDB1', 'Trade_Archive'
);
```

### Retention Policies

- **Archival**: Move data older than N months to archive
- **Retention**: Keep archived data for N years
- **Disposal**: Remove data older than retention period
- **Compliance**: Legal holds prevent disposal

## Performance

### Data Movement Strategies

1. **Partition Switching** (Fastest)
   - Instant metadata operation
   - Best for any dataset size
   - Requires partitioned tables

2. **BCP** (Large datasets >1GB)
   - 100,000+ rows/second
   - File-based transfer
   - Minimal logging

3. **BULK INSERT** (Medium datasets)
   - 50,000+ rows/second
   - Batch operations
   - Table hints for performance

4. **INSERT SELECT** (Small datasets <100K)
   - 10,000+ rows/second
   - Simple single transaction
   - Good for small tables

### Performance Expectations

| Dataset Size | Strategy | Throughput | Use Case |
|-------------|----------|------------|----------|
| <100K records | INSERT SELECT | 10K rows/sec | Small tables |
| 100K-1M records | BULK INSERT | 50K rows/sec | Medium tables |
| >1M records | BCP | 100K+ rows/sec | Large tables |
| Any size | Partition Switch | Instant | Partitioned tables |

## Monitoring

### Health Checks

```sql
-- Validate system prerequisites
EXEC control.sp_Validate_System_Prerequisites

-- Show system health
EXEC control.sp_Show_System_Health

-- Monitor running executions
EXEC control.sp_Monitor_Executions
```

### Key Metrics

- **Throughput**: Records processed per second
- **Latency**: Operation completion time
- **Error Rate**: Failed operation percentage
- **Storage**: Archive database size and growth

### Alerting

The system tracks metrics and can alert on:
- Failed executions
- Performance degradation
- Storage thresholds
- Compliance violations

## Resilience Features

### Idempotency

All operations are idempotent and safe to run multiple times:
- No duplicate data creation
- State tracking prevents re-processing
- Automatic skip of completed operations

### Recovery

- **Automatic Resume**: Failed operations can be resumed
- **State Management**: Execution state is preserved
- **Error Handling**: Comprehensive error logging and recovery
- **Retry Logic**: Exponential backoff with max retry limits

### Monitoring

- **Real-time Status**: Current execution state
- **Health Checks**: System prerequisite validation
- **Performance Metrics**: Throughput and latency tracking
- **Audit Trail**: Complete operation history

## Directory Structure

```
data-retention-service/
├── setup/                          # Control database setup
│   ├── 01_create_databases.sql
│   ├── 02_create_archival_table_list.sql
│   ├── 03_create_marker_tables.sql
│   ├── 04_partition_detection_procedures.sql
│   └── 05_monitoring_procedures.sql
├── archival/                       # Archival procedures
│   ├── 01_archival_utilities.sql
│   ├── 02_prepare_archival_records.sql
│   ├── 05_archive_movement_procedures.sql
│   ├── 06_master_archival_procedure.sql
│   └── 07_disposal_procedures.sql
├── tests/                          # Test suite
│   ├── run_tests.sh
│   ├── test_idempotency.sh
│   └── test_recovery.sh
├── start.sh                        # Start SQL Server
├── init_control_db.sh              # Initialize control database
├── orchestrator.py                 # Python orchestrator
├── docker-compose.yml              # SQL Server container
├── OPERATIONS.md                   # Operations guide
└── README.md                       # This file
```

## Testing

### Test Suite

```bash
# Run all tests
./tests/run_tests.sh

# Test idempotency
./tests/test_idempotency.sh

# Test recovery
./tests/test_recovery.sh

# Test monitoring
./tests/test_monitoring.sh
```

### Test Coverage

- **Idempotency**: Operations can be run multiple times safely
- **Recovery**: Error handling and resume capabilities
- **Monitoring**: Health checks and metrics collection
- **Performance**: Throughput and latency validation
- **End-to-End**: Complete workflow testing

## Troubleshooting

### Common Issues

1. **"SETUP REQUIRED" Error**
   - Run `./init_control_db.sh` to initialize

2. **"SQL Server not responding"**
   - Check container status: `docker ps`
   - Start container: `./start.sh`

3. **"No tables configured"**
   - Add entries to `control.archival_table_list`

4. **Partition switch failures**
   - Check partition alignment
   - Verify staging table creation

### Log Analysis

```sql
-- Check recent errors
SELECT TOP 20 *
FROM control.archival_execution_log
WHERE status = 'FAILED'
ORDER BY execution_start DESC;

-- Check performance metrics
SELECT *
FROM control.archival_metrics
WHERE metric_timestamp >= DATEADD(HOUR, -1, GETDATE())
ORDER BY metric_timestamp DESC;
```

## Operations

See [OPERATIONS.md](OPERATIONS.md) for detailed operational procedures including:
- System monitoring
- Recovery procedures
- Troubleshooting guides
- Maintenance tasks
- Performance tuning
- Security considerations
- Backup and restore

## Security

### Access Control

- Dedicated service accounts
- Principle of least privilege
- Audit logging enabled
- Encrypted connections

### Data Protection

- TDE encryption for archive database
- Compliance hold capabilities
- Audit trail for all operations
- Secure credential management

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## License

[Add your license information here]

## Support

For issues and questions:
1. Check [OPERATIONS.md](OPERATIONS.md) for troubleshooting
2. Review execution logs
3. Run health checks
4. Contact system administrator

---

*Last Updated: [Current Date]*
*Version: 1.0*
