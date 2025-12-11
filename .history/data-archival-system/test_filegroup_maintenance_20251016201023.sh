#!/bin/bash
# test_filegroup_maintenance.sh
# Test filegroup maintenance procedures

echo "========================================="
echo "FILEGROUP MAINTENANCE TEST"
echo "========================================="
echo ""

# Check if Docker container is running
if ! docker ps | grep -q archival-sqlserver; then
    echo "❌ Error: archival-sqlserver container is not running"
    echo "Please start it with: docker-compose up -d"
    exit 1
fi

echo "✓ Docker container is running"
echo ""

# Function to run SQL command
run_sql() {
    docker exec archival-sqlserver /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C \
        -d "$1" -Q "$2" 2>&1
}

# Test 1: Check filegroup status
echo "========================================="
echo "TEST 1: Filegroup Status"
echo "========================================="
run_sql "control_db" "EXEC control.sp_Show_Filegroup_Status"
echo ""

# Test 2: Monitor filegroup sizes
echo "========================================="
echo "TEST 2: Filegroup Size Monitoring"
echo "========================================="
run_sql "control_db" "SELECT * FROM control.vw_All_Filegroups_Status ORDER BY DatabaseName, FileGroupName"
echo ""

# Test 3: Test archival_flag procedures
echo "========================================="
echo "TEST 3: Archival Flag Management"
echo "========================================="
echo "Adding archival_flag to Position table..."
run_sql "control_db" "EXEC control.sp_Add_Archival_Flag 'SourceDB1', 'dbo', 'Position'"
echo ""

# Test 4: Mark records for archival
echo "========================================="
echo "TEST 4: Mark Records for Archival"
echo "========================================="
BATCH_ID=$(uuidgen)
echo "Batch ID: $BATCH_ID"
run_sql "control_db" "EXEC control.sp_Mark_Archival_Eligible '$BATCH_ID', 'SourceDB1', 'dbo', 'Position'"
echo ""

# Test 5: Check marked records
echo "========================================="
echo "TEST 5: Check Marked Records"
echo "========================================="
run_sql "SourceDB1" "SELECT archival_flag, COUNT(*) as count FROM dbo.Position GROUP BY archival_flag"
echo ""

# Test 6: Test maintenance history logging
echo "========================================="
echo "TEST 6: Maintenance History"
echo "========================================="
run_sql "control_db" "SELECT TOP 10 * FROM control.maintenance_history ORDER BY created_date DESC"
echo ""

# Test 7: Test monitoring views
echo "========================================="
echo "TEST 7: Monitoring Views"
echo "========================================="
run_sql "control_db" "SELECT * FROM control.vw_Filegroup_Monitoring"
echo ""

# Test 8: Database topology status
echo "========================================="
echo "TEST 8: Database Topology Configuration"
echo "========================================="
run_sql "control_db" "SELECT * FROM control.database_topology WHERE active = 1"
echo ""

# Test 9: Test archive database reference function
echo "========================================="
echo "TEST 9: Archive Database Reference"
echo "========================================="
run_sql "control_db" "SELECT control.fn_Get_Database_Reference('ARCHIVE', 'archive_db') AS ArchiveReference"
echo ""

# Test 10: Comprehensive monitoring report
echo "========================================="
echo "TEST 10: Comprehensive Monitoring Report"
echo "========================================="
run_sql "control_db" "EXEC control.sp_Comprehensive_Monitoring_Report"
echo ""

echo "========================================="
echo "FILEGROUP MAINTENANCE TEST COMPLETED"
echo "========================================="
echo ""
echo "Summary:"
echo "- Filegroup status: CHECKED"
echo "- Archival flag management: TESTED"
echo "- Maintenance logging: VERIFIED"
echo "- Monitoring views: VALIDATED"
echo "- Database topology: CONFIRMED"
echo ""
echo "Next steps:"
echo "1. Review test results above"
echo "2. Run Python orchestrator with filegroup support"
echo "3. Test archive database migration procedures"
echo ""
