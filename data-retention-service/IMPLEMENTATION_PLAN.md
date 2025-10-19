# Production-Ready Data Retention Service - Complete Lifecycle with Resilience

## Overview

Complete data archival lifecycle system with idempotency, resilience, comprehensive monitoring, error recovery, and proper state management. All operations are re-runnable and self-healing.

## Core Principles

1. **Idempotency**: All operations can be run multiple times safely
2. **Resilience**: Automatic error detection and recovery
3. **Monitoring**: Comprehensive tracking and alerting
4. **Recoverability**: Resume from any failure point
5. **Separation**: Test suite completely separate from core system

## Architecture

### Phase 1: Control Database Setup (Prerequisites)
- Control database initialization
- Configuration tables
- Tracking and monitoring tables
- Validation procedures

### Phase 2: Intelligent Record Preparation
- Partition detection
- Staging table creation
- Partition switching (high-performance) or bulk copy (fallback)
- Comprehensive tracking

### Phase 3: High-Performance Data Movement
- Strategy selection (BCP, INSERT SELECT, BULK INSERT)
- Optimized data movement to archive_db
- Staging table cleanup
- Performance metrics

### Phase 4: Retention-Based Disposal
- Retention policy enforcement
- Batch deletion or partition drop
- Compliance hold management
- Audit trail

## Directory Structure

```
data-retention-service/
├── setup/                          # Phase 1: Control DB setup
│   ├── 01_create_databases.sql
│   ├── 02_create_archival_table_list.sql
│   ├── 03_create_marker_tables.sql
│   ├── 04_partition_detection_procedures.sql
│   ├── 05_monitoring_procedures.sql
│   └── README_SETUP.md
├── archival/                       # Phase 2-4: Archival operations
│   ├── 01_archival_utilities.sql
│   ├── 02_prepare_archival_records.sql
│   ├── 03_partition_switch_procedures.sql
│   ├── 04_bulk_copy_procedures.sql
│   ├── 05_archive_movement_procedures.sql
│   ├── 06_master_archival_procedure.sql
│   ├── 07_disposal_procedures.sql
│   └── README_ARCHIVAL.md
├── tests/                          # Separate test suite
│   ├── setup/
│   ├── run_tests.sh
│   ├── test_idempotency.sh
│   ├── test_recovery.sh
│   └── test_monitoring.sh
├── docker-compose.yml              # SQL Server container
├── start.sh                        # Start Docker only
├── init_control_db.sh              # Initialize control database
├── orchestrator.py                 # Python orchestrator
├── README.md                       # Main documentation
└── OPERATIONS.md                   # Operations guide
```

## Implementation Phases

### Phase 1: Control Database Setup

**Prerequisites**: Docker, SQL Server 2022

**Scripts**:
1. `start.sh` - Start SQL Server container
2. `init_control_db.sh` - Initialize control database (idempotent)

**Key Tables**:
- `control.archival_table_list` - Configuration with retention policies
- `control.archival_execution_state` - State management for resumability
- `control.partition_switch_tracking` - Partition operation tracking
- `control.archive_data_movement_tracking` - Data movement metrics
- `control.archive_disposal_tracking` - Disposal audit trail
- `control.archival_metrics` - Performance and monitoring metrics

### Phase 2: Record Preparation

**Features**:
- Automatic partition detection
- Dynamic staging table creation
- Partition switching (instant, metadata-only operation)
- Fallback to batch-based bulk copy
- Comprehensive error handling and logging

**Key Procedures**:
- `sp_Detect_Partition_Info` - Detect table partitioning
- `sp_Prepare_Archival_Records` - Mark and prepare records
- `sp_Create_Partition_Staging_Table` - Create staging with constraints

### Phase 3: Data Movement

**Strategies**:
1. **BCP** (fastest for large datasets >1GB)
   - Export to file, bulk insert to archive
   - 100,000+ rows/second throughput
   
2. **INSERT SELECT** (simple for small datasets <100K records)
   - Single transaction
   - Good for small to medium datasets
   
3. **BULK INSERT** (balanced for medium datasets)
   - Batch operations with table hints
   - Minimal logging option

**Key Procedures**:
- `sp_Select_Movement_Strategy` - Choose optimal strategy
- `sp_Move_To_Archive_BCP` - BCP-based movement
- `sp_Move_To_Archive_Insert` - Simple INSERT movement
- `sp_Move_To_Archive_Bulk` - Batch INSERT movement

### Phase 4: Disposal

**Features**:
- Configurable retention periods (years)
- Multiple disposal methods (DELETE, PARTITION_DROP)
- Compliance hold management
- Full audit trail

**Key Procedures**:
- `sp_Identify_Records_For_Disposal` - Find expired records
- `sp_Dispose_Records_Batch_Delete` - Batch deletion
- `sp_Dispose_Records_Partition_Drop` - Fast partition drop
- `sp_Set_Compliance_Hold` - Prevent disposal for legal holds

## Resilience Features

### Idempotency
- All operations check state before executing
- Safe to run multiple times
- No duplicate data or errors

### State Management
- `archival_execution_state` tracks current phase
- Resume from exact failure point
- Automatic retry with exponential backoff

### Monitoring
- Real-time metrics collection
- Performance tracking (throughput, latency)
- Alert thresholds for critical issues
- Health check procedures

### Recovery
- `sp_Monitor_Executions` - View running operations
- `sp_Resume_Failed_Executions` - Auto-resume failed jobs
- Maximum retry limits to prevent infinite loops
- Detailed error logging

## Usage

### Initial Setup
```bash
# Start SQL Server
./start.sh

# Initialize control database (run once, idempotent)
./init_control_db.sh
```

### Run Archival
```bash
# Run monthly archival (idempotent, resumable)
python3 orchestrator.py --run

# Run disposal only
python3 orchestrator.py --dispose

# Run complete lifecycle
python3 orchestrator.py --lifecycle
```

### Monitoring
```bash
# Check system health
python3 orchestrator.py --status

# View running operations
python3 orchestrator.py --monitor

# Resume failed operations
python3 orchestrator.py --resume
```

### Testing
```bash
# Run complete test suite
./tests/run_tests.sh

# Test idempotency
./tests/test_idempotency.sh

# Test recovery
./tests/test_recovery.sh
```

## Configuration

Configuration is stored in `control.archival_table_list`:

```sql
INSERT INTO control.archival_table_list (
    source_database,
    table_name,
    months_before_archival,
    retention_years_in_archive,
    disposal_enabled,
    disposal_method,
    archive_db_schema,
    archive_db_table
) VALUES (
    'SourceDB1',
    'Trade',
    3,                    -- Archive after 3 months
    7,                    -- Keep in archive for 7 years
    1,                    -- Enable disposal
    'PARTITION_DROP',     -- Fast disposal method
    'SourceDB1',
    'Trade_Archive'
);
```

## Performance Expectations

### Partition Switching
- **Speed**: Instant (metadata operation)
- **Best for**: Any dataset size
- **Requirement**: Table must be partitioned

### Data Movement (to archive_db)
- **BCP**: 100,000+ rows/second (large datasets)
- **BULK INSERT**: 50,000+ rows/second (medium datasets)
- **INSERT SELECT**: 10,000+ rows/second (small datasets)

### Disposal
- **Partition Drop**: Instant (millions of records in seconds)
- **Batch Delete**: 10,000 rows/second

## Next Steps

1. Review implementation plan
2. Set up development environment
3. Initialize control database
4. Configure archival tables
5. Test with sample data
6. Monitor and tune performance
7. Deploy to production

## Support

For issues or questions:
1. Check OPERATIONS.md for troubleshooting
2. Review execution logs in control.archival_execution_log
3. Run health checks: `sp_Validate_System_Prerequisites`
4. Monitor executions: `sp_Monitor_Executions`

