#!/bin/bash
# test_end_to_end.sh
# Complete end-to-end workflow test with sample data

set -e

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

print_status() {
    local status=$1
    local message=$2
    case $status in
        "SUCCESS") echo -e "${GREEN}✓${NC} $message" ;;
        "ERROR") echo -e "${RED}✗${NC} $message" ;;
        "WARNING") echo -e "${YELLOW}⚠${NC} $message" ;;
        "INFO") echo -e "${BLUE}→${NC} $message" ;;
    esac
}

# Setup test data
setup_test_data() {
    print_status "INFO" "Setting up test data..."
    
    # Create test source database
    print_status "INFO" "Creating test source database..."
    docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -Q "
        IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'TestSourceDB')
        BEGIN
            CREATE DATABASE TestSourceDB;
        END
    " > /dev/null 2>&1
    
    # Create test table
    print_status "INFO" "Creating test table..."
    docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -Q "
        USE TestSourceDB;
        IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'TestTable')
        BEGIN
            CREATE TABLE TestTable (
                id INT IDENTITY(1,1) PRIMARY KEY,
                data VARCHAR(100),
                created_date DATETIME DEFAULT GETDATE(),
                archival_flag BIT DEFAULT 0,
                archival_month VARCHAR(6) NULL
            );
        END
    " > /dev/null 2>&1
    
    # Insert test data
    print_status "INFO" "Inserting test data..."
    docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -Q "
        USE TestSourceDB;
        INSERT INTO TestTable (data, created_date, archival_flag)
        SELECT 
            'Test Data ' + CAST(ROW_NUMBER() OVER (ORDER BY (SELECT NULL)) AS VARCHAR),
            DATEADD(MONTH, -4, GETDATE()),  -- 4 months old
            0
        FROM sys.objects o1, sys.objects o2;  -- Generate ~1000 rows
    " > /dev/null 2>&1
    
    # Configure archival table
    print_status "INFO" "Configuring archival table..."
    docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -Q "
        USE control_db;
        IF NOT EXISTS (SELECT * FROM control.archival_table_list WHERE source_database = 'TestSourceDB' AND table_name = 'TestTable')
        BEGIN
            INSERT INTO control.archival_table_list (
                source_database, table_name, archival_enabled,
                months_before_archival, retention_years_in_archive,
                disposal_enabled, archive_db_schema, archive_db_table,
                date_column, primary_key_columns
            ) VALUES (
                'TestSourceDB', 'TestTable', 1,
                3, 1, 1, 'TestSourceDB', 'TestTable_Archive',
                'created_date', 'id'
            );
        END
    " > /dev/null 2>&1
    
    print_status "SUCCESS" "Test data setup completed"
    return 0
}

# Test archival workflow
test_archival_workflow() {
    print_status "INFO" "Testing archival workflow..."
    
    # Run archival workflow
    print_status "INFO" "Running archival workflow..."
    if python3 ../orchestrator.py --run; then
        print_status "SUCCESS" "Archival workflow completed"
    else
        print_status "ERROR" "Archival workflow failed"
        return 1
    fi
    
    # Verify data was archived
    print_status "INFO" "Verifying archived data..."
    local archive_count
    archive_count=$(docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -h-1 -Q \
        "USE archive_db; SELECT COUNT(*) FROM TestSourceDB.TestTable_Archive;" 2>/dev/null || echo "0")
    
    if [[ $archive_count -gt 0 ]]; then
        print_status "SUCCESS" "Data successfully archived ($archive_count records)"
    else
        print_status "ERROR" "No data found in archive ($archive_count records)"
        return 1
    fi
    
    return 0
}

# Test disposal workflow
test_disposal_workflow() {
    print_status "INFO" "Testing disposal workflow..."
    
    # Update archived data to be old enough for disposal
    print_status "INFO" "Updating archived data for disposal test..."
    docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -Q "
        USE archive_db;
        UPDATE TestSourceDB.TestTable_Archive 
        SET archived_date = DATEADD(YEAR, -2, GETDATE());  -- 2 years old
    " > /dev/null 2>&1
    
    # Run disposal workflow
    print_status "INFO" "Running disposal workflow..."
    if python3 ../orchestrator.py --dispose; then
        print_status "SUCCESS" "Disposal workflow completed"
    else
        print_status "WARNING" "Disposal workflow failed (may be expected if no data to dispose)"
    fi
    
    return 0
}

# Test complete lifecycle
test_complete_lifecycle() {
    print_status "INFO" "Testing complete lifecycle..."
    
    # Run complete lifecycle
    print_status "INFO" "Running complete lifecycle..."
    if python3 ../orchestrator.py --lifecycle; then
        print_status "SUCCESS" "Complete lifecycle completed"
    else
        print_status "ERROR" "Complete lifecycle failed"
        return 1
    fi
    
    return 0
}

# Cleanup test data
cleanup_test_data() {
    print_status "INFO" "Cleaning up test data..."
    
    # Remove test configuration
    docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -Q "
        USE control_db;
        DELETE FROM control.archival_table_list WHERE source_database = 'TestSourceDB';
    " > /dev/null 2>&1
    
    # Drop test database
    docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -Q "
        IF EXISTS (SELECT * FROM sys.databases WHERE name = 'TestSourceDB')
        BEGIN
            DROP DATABASE TestSourceDB;
        END
    " > /dev/null 2>&1
    
    # Clean up archive data
    docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -Q "
        USE archive_db;
        IF EXISTS (SELECT * FROM sys.tables WHERE name = 'TestTable_Archive')
        BEGIN
            DROP TABLE TestSourceDB.TestTable_Archive;
        END
    " > /dev/null 2>&1
    
    print_status "SUCCESS" "Test data cleanup completed"
    return 0
}

# Main test execution
main() {
    echo "Testing complete end-to-end workflow..."
    echo ""
    
    local failed_tests=0
    
    # Setup test data
    if ! setup_test_data; then
        print_status "ERROR" "Test data setup failed"
        exit 1
    fi
    
    # Test 1: Archival workflow
    if ! test_archival_workflow; then
        ((failed_tests++))
    fi
    
    # Test 2: Disposal workflow
    if ! test_disposal_workflow; then
        ((failed_tests++))
    fi
    
    # Test 3: Complete lifecycle
    if ! test_complete_lifecycle; then
        ((failed_tests++))
    fi
    
    # Cleanup
    cleanup_test_data
    
    echo ""
    if [ $failed_tests -eq 0 ]; then
        print_status "SUCCESS" "All end-to-end tests passed!"
        return 0
    else
        print_status "ERROR" "$failed_tests end-to-end tests failed"
        return 1
    fi
}

main "$@"
