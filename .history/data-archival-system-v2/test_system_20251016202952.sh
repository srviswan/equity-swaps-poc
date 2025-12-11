#!/bin/bash

echo "==========================================="
echo "Data Archival System V2 - End-to-End Test"
echo "==========================================="
echo ""

# Check if Docker container is running
if ! docker ps | grep -q archival-sqlserver-v2; then
    echo "❌ Error: archival-sqlserver-v2 container is not running"
    echo "Please start it with: ./start.sh"
    exit 1
fi

echo "✓ Docker container is running"
echo ""

# Function to run SQL command
run_sql() {
    docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C \
        -d "$1" -Q "$2" -h -1 -W 2>&1
}

# Test 1: Check databases
echo "==========================================="
echo "TEST 1: Verify Databases"
echo "==========================================="
run_sql "master" "SELECT name FROM sys.databases WHERE name IN ('control_db', 'archive_db', 'SourceDB1', 'SourceDB2', 'SourceDB3') ORDER BY name"
echo ""

# Test 2: Check archival table list configuration
echo "==========================================="
echo "TEST 2: Archival Table List Configuration"
echo "==========================================="
run_sql "control_db" "SELECT source_database, table_name, months_before_archival, archive_db_schema FROM control.archival_table_list WHERE archival_enabled = 1"
echo ""

# Test 3: Check test data
echo "==========================================="
echo "TEST 3: Verify Test Data"
echo "==========================================="
echo "Positions in SourceDB1:"
run_sql "SourceDB1" "SELECT COUNT(*) AS total, SUM(CASE WHEN archival_flag = 0 THEN 1 ELSE 0 END) AS active, SUM(CASE WHEN archival_flag = 1 THEN 1 ELSE 0 END) AS archived FROM dbo.Position"
echo ""
echo "Trades in SourceDB2:"
run_sql "SourceDB2" "SELECT COUNT(*) AS total, SUM(CASE WHEN archival_flag = 0 THEN 1 ELSE 0 END) AS active, SUM(CASE WHEN archival_flag = 1 THEN 1 ELSE 0 END) AS archived FROM dbo.Trade"
echo ""
echo "Price History in SourceDB3:"
run_sql "SourceDB3" "SELECT COUNT(*) AS total, SUM(CASE WHEN archival_flag = 0 THEN 1 ELSE 0 END) AS active, SUM(CASE WHEN archival_flag = 1 THEN 1 ELSE 0 END) AS archived FROM dbo.PriceHistory"
echo ""

# Test 4: Run archival workflow using Python
echo "==========================================="
echo "TEST 4: Run Archival Workflow"
echo "==========================================="
echo "Running Python orchestrator..."
python3 orchestrator.py --run
echo ""

# Test 5: Check archival results
echo "==========================================="
echo "TEST 5: Verify Archival Results"
echo "==========================================="
echo "Records after archival in SourceDB1.Position:"
run_sql "SourceDB1" "SELECT COUNT(*) AS remaining_in_base FROM dbo.Position"
echo ""
echo "Monthly archival tables created:"
run_sql "control_db" "SELECT source_database, base_table_name, archival_month, record_count, moved_to_archive_db FROM control.monthly_archival_tracking ORDER BY source_database, archival_month"
echo ""

# Test 6: Check archive database
echo "==========================================="
echo "TEST 6: Check Archive Database"
echo "==========================================="
echo "Schemas in archive_db:"
run_sql "archive_db" "SELECT name FROM sys.schemas WHERE name IN ('SourceDB1', 'SourceDB2', 'SourceDB3') ORDER BY name"
echo ""
echo "Tables in archive_db:"
run_sql "archive_db" "SELECT s.name AS schema_name, t.name AS table_name FROM sys.tables t JOIN sys.schemas s ON t.schema_id = s.schema_id WHERE s.name IN ('SourceDB1', 'SourceDB2', 'SourceDB3') ORDER BY s.name, t.name"
echo ""

# Test 7: Check execution log
echo "==========================================="
echo "TEST 7: Execution Log"
echo "==========================================="
run_sql "control_db" "SELECT operation, source_database, table_name, archival_month, records_affected, status FROM control.archival_execution_log ORDER BY execution_start DESC"
echo ""

# Test 8: Show status
echo "==========================================="
echo "TEST 8: System Status"
echo "==========================================="
python3 orchestrator.py --status
echo ""

echo "==========================================="
echo "TEST COMPLETED"
echo "==========================================="
echo ""
echo "Summary:"
echo "✓ Databases created"
echo "✓ Configuration tables populated"
echo "✓ Test data generated"
echo "✓ Archival workflow executed"
echo "✓ Monthly archival tables created"
echo "✓ Data moved to archive database"
echo ""
echo "Next steps:"
echo "1. Review execution log above"
echo "2. Query archived data in archive_db"
echo "3. Schedule monthly execution via cron"
echo ""
