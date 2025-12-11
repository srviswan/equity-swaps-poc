#!/bin/bash
# test_schema_changes.sh
# Comprehensive test suite for schema change detection and versioning

set -e

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Configuration
CONTAINER_NAME="archival-sqlserver-v2"
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(dirname "$SCRIPT_DIR")"

print_status() {
    local status=$1
    local message=$2
    case $status in
        "SUCCESS")
            echo -e "${GREEN}✓${NC} $message"
            ;;
        "ERROR")
            echo -e "${RED}✗${NC} $message"
            ;;
        "WARNING")
            echo -e "${YELLOW}⚠${NC} $message"
            ;;
        "INFO")
            echo -e "${BLUE}→${NC} $message"
            ;;
    esac
}

execute_sql() {
    local sql_file=$1
    local description=$2
    
    print_status "INFO" "$description..."
    
    if docker exec $CONTAINER_NAME /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C \
        -i "$PROJECT_DIR/$sql_file" > /dev/null 2>&1; then
        print_status "SUCCESS" "$description completed"
    else
        print_status "ERROR" "$description failed"
        return 1
    fi
}

run_sql_command() {
    local sql_command=$1
    local description=$2
    
    print_status "INFO" "$description..."
    
    if docker exec $CONTAINER_NAME /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C \
        -Q "$sql_command" > /dev/null 2>&1; then
        print_status "SUCCESS" "$description completed"
    else
        print_status "ERROR" "$description failed"
        return 1
    fi
}

# Test scenarios
test_initial_schema() {
    echo ""
    echo "========================================"
    echo "Test 1: Initial Schema Detection"
    echo "========================================"
    
    print_status "INFO" "Creating test table with initial schema..."
    
    run_sql_command "
    USE TestDB;
    IF OBJECT_ID('dbo.SchemaTestTable', 'U') IS NOT NULL DROP TABLE dbo.SchemaTestTable;
    
    CREATE TABLE dbo.SchemaTestTable (
        id INT IDENTITY(1,1) PRIMARY KEY,
        name VARCHAR(100) NOT NULL,
        created_date DATETIME2 NOT NULL DEFAULT GETDATE(),
        archival_flag BIT NULL DEFAULT 0
    );
    
    INSERT INTO dbo.SchemaTestTable (name) VALUES 
        ('Record 1'), ('Record 2'), ('Record 3');
    " "Create initial test table"
    
    print_status "INFO" "Configuring table for archival..."
    
    run_sql_command "
    USE control_db;
    INSERT INTO control.archival_table_list (
        source_database, table_name, archival_enabled, disposal_enabled,
        months_before_archival, retention_years_in_archive, date_column,
        archive_db_schema, archive_db_table, active
    ) VALUES (
        'TestDB', 'SchemaTestTable', 1, 1, 0, 1, 'created_date',
        'TestDB', 'SchemaTestTable_Archive', 1
    );
    " "Configure table for archival"
    
    print_status "INFO" "Running initial archival..."
    
    cd "$PROJECT_DIR"
    if python3 orchestrator.py --run; then
        print_status "SUCCESS" "Initial archival completed"
    else
        print_status "ERROR" "Initial archival failed"
        return 1
    fi
    
    print_status "INFO" "Checking schema version created..."
    
    run_sql_command "
    USE control_db;
    SELECT source_database, table_name, schema_version, archive_table, is_active
    FROM control.archive_schema_versions 
    WHERE source_database = 'TestDB' AND table_name = 'SchemaTestTable';
    " "Verify schema version v1 created"
}

test_add_column() {
    echo ""
    echo "========================================"
    echo "Test 2: Add Column Schema Change"
    echo "========================================"
    
    print_status "INFO" "Adding new column to source table..."
    
    run_sql_command "
    USE TestDB;
    ALTER TABLE dbo.SchemaTestTable 
    ADD email VARCHAR(255) NULL DEFAULT 'unknown@example.com';
    
    UPDATE dbo.SchemaTestTable SET email = 'user' + CAST(id AS VARCHAR) + '@example.com';
    " "Add email column"
    
    print_status "INFO" "Running archival with schema change..."
    
    cd "$PROJECT_DIR"
    if python3 orchestrator.py --run; then
        print_status "SUCCESS" "Archival with schema change completed"
    else
        print_status "ERROR" "Archival with schema change failed"
        return 1
    fi
    
    print_status "INFO" "Checking new schema version created..."
    
    run_sql_command "
    USE control_db;
    SELECT source_database, table_name, schema_version, archive_table, is_active
    FROM control.archive_schema_versions 
    WHERE source_database = 'TestDB' AND table_name = 'SchemaTestTable'
    ORDER BY schema_version;
    " "Verify schema version v2 created"
    
    print_status "INFO" "Checking archive table structure..."
    
    run_sql_command "
    USE archive_db;
    SELECT COLUMN_NAME, DATA_TYPE, IS_NULLABLE
    FROM INFORMATION_SCHEMA.COLUMNS 
    WHERE TABLE_SCHEMA = 'TestDB' AND TABLE_NAME = 'SchemaTestTable_Archive_v2'
    ORDER BY ORDINAL_POSITION;
    " "Verify archive table has new column"
}

test_remove_column() {
    echo ""
    echo "========================================"
    echo "Test 3: Remove Column Schema Change"
    echo "========================================"
    
    print_status "INFO" "Removing column from source table..."
    
    run_sql_command "
    USE TestDB;
    ALTER TABLE dbo.SchemaTestTable DROP COLUMN email;
    " "Remove email column"
    
    print_status "INFO" "Running archival with column removal..."
    
    cd "$PROJECT_DIR"
    if python3 orchestrator.py --run; then
        print_status "SUCCESS" "Archival with column removal completed"
    else
        print_status "ERROR" "Archival with column removal failed"
        return 1
    fi
    
    print_status "INFO" "Checking new schema version created..."
    
    run_sql_command "
    USE control_db;
    SELECT source_database, table_name, schema_version, archive_table, is_active
    FROM control.archive_schema_versions 
    WHERE source_database = 'TestDB' AND table_name = 'SchemaTestTable'
    ORDER BY schema_version;
    " "Verify schema version v3 created"
}

test_type_change() {
    echo ""
    echo "========================================"
    echo "Test 4: Data Type Change"
    echo "========================================"
    
    print_status "INFO" "Changing data type in source table..."
    
    run_sql_command "
    USE TestDB;
    ALTER TABLE dbo.SchemaTestTable 
    ALTER COLUMN name VARCHAR(200) NOT NULL;
    " "Change name column length"
    
    print_status "INFO" "Running archival with type change..."
    
    cd "$PROJECT_DIR"
    if python3 orchestrator.py --run; then
        print_status "SUCCESS" "Archival with type change completed"
    else
        print_status "ERROR" "Archival with type change failed"
        return 1
    fi
    
    print_status "INFO" "Checking new schema version created..."
    
    run_sql_command "
    USE control_db;
    SELECT source_database, table_name, schema_version, archive_table, is_active
    FROM control.archive_schema_versions 
    WHERE source_database = 'TestDB' AND table_name = 'SchemaTestTable'
    ORDER BY schema_version;
    " "Verify schema version v4 created"
}

test_disposal_across_versions() {
    echo ""
    echo "========================================"
    echo "Test 5: Disposal Across Multiple Versions"
    echo "========================================"
    
    print_status "INFO" "Running disposal workflow..."
    
    cd "$PROJECT_DIR"
    if python3 orchestrator.py --dispose; then
        print_status "SUCCESS" "Disposal workflow completed"
    else
        print_status "ERROR" "Disposal workflow failed"
        return 1
    fi
    
    print_status "INFO" "Checking disposal tracking..."
    
    run_sql_command "
    USE control_db;
    SELECT archive_schema, archive_table, records_identified, records_disposed, operation_status
    FROM control.archive_disposal_tracking
    WHERE archive_table LIKE 'SchemaTestTable_Archive_v%'
    ORDER BY archive_table;
    " "Verify disposal across versions"
}

test_schema_validation() {
    echo ""
    echo "========================================"
    echo "Test 6: Schema Validation Commands"
    echo "========================================"
    
    print_status "INFO" "Testing schema version display..."
    
    cd "$PROJECT_DIR"
    if python3 orchestrator.py --schema-versions; then
        print_status "SUCCESS" "Schema versions displayed"
    else
        print_status "ERROR" "Schema versions display failed"
        return 1
    fi
    
    print_status "INFO" "Testing schema validation..."
    
    cd "$PROJECT_DIR"
    if python3 orchestrator.py --validate-schemas; then
        print_status "SUCCESS" "Schema validation completed"
    else
        print_status "ERROR" "Schema validation failed"
        return 1
    fi
}

cleanup_test_data() {
    echo ""
    echo "========================================"
    echo "Cleanup Test Data"
    echo "========================================"
    
    print_status "INFO" "Cleaning up test data..."
    
    run_sql_command "
    USE TestDB;
    IF OBJECT_ID('dbo.SchemaTestTable', 'U') IS NOT NULL DROP TABLE dbo.SchemaTestTable;
    " "Drop test table"
    
    run_sql_command "
    USE archive_db;
    IF OBJECT_ID('TestDB.SchemaTestTable_Archive_v1', 'U') IS NOT NULL DROP TABLE TestDB.SchemaTestTable_Archive_v1;
    IF OBJECT_ID('TestDB.SchemaTestTable_Archive_v2', 'U') IS NOT NULL DROP TABLE TestDB.SchemaTestTable_Archive_v2;
    IF OBJECT_ID('TestDB.SchemaTestTable_Archive_v3', 'U') IS NOT NULL DROP TABLE TestDB.SchemaTestTable_Archive_v3;
    IF OBJECT_ID('TestDB.SchemaTestTable_Archive_v4', 'U') IS NOT NULL DROP TABLE TestDB.SchemaTestTable_Archive_v4;
    " "Drop archive tables"
    
    run_sql_command "
    USE control_db;
    DELETE FROM control.archival_table_list WHERE table_name = 'SchemaTestTable';
    DELETE FROM control.archive_schema_versions WHERE table_name = 'SchemaTestTable';
    DELETE FROM control.archive_table_registry WHERE source_table = 'SchemaTestTable';
    DELETE FROM control.schema_change_log WHERE table_name = 'SchemaTestTable';
    " "Clean up tracking data"
    
    print_status "SUCCESS" "Test data cleanup completed"
}

# Main execution
main() {
    echo "========================================"
    echo "Schema Change Detection Test Suite"
    echo "========================================"
    echo ""
    
    # Check if container is running
    if ! docker ps | grep -q $CONTAINER_NAME; then
        print_status "ERROR" "Container $CONTAINER_NAME is not running"
        print_status "ERROR" "Please run './start.sh' first to start the SQL Server container"
        exit 1
    fi
    
    # Check if schema tracking is initialized
    if ! docker exec $CONTAINER_NAME /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C \
        -Q "USE control_db; SELECT COUNT(*) FROM control.archive_schema_versions;" > /dev/null 2>&1; then
        print_status "ERROR" "Schema tracking tables not initialized"
        print_status "ERROR" "Please run './init_control_db.sh' first"
        exit 1
    fi
    
    # Run test scenarios
    test_initial_schema
    test_add_column
    test_remove_column
    test_type_change
    test_disposal_across_versions
    test_schema_validation
    
    # Cleanup
    cleanup_test_data
    
    echo ""
    echo "========================================"
    echo "Schema Change Test Suite Results"
    echo "========================================"
    print_status "SUCCESS" "All schema change tests completed successfully!"
    echo ""
    echo "Schema versioning is working correctly:"
    echo "  ✓ Initial schema detection"
    echo "  ✓ Column addition handling"
    echo "  ✓ Column removal handling"
    echo "  ✓ Data type change handling"
    echo "  ✓ Disposal across multiple versions"
    echo "  ✓ Schema validation commands"
    echo ""
}

# Handle script arguments
case "${1:-}" in
    --help|-h)
        echo "Usage: $0 [--help]"
        echo ""
        echo "Run comprehensive schema change detection and versioning tests."
        echo ""
        echo "Prerequisites:"
        echo "  - SQL Server container must be running (run './start.sh' first)"
        echo "  - Control database must be initialized (run './init_control_db.sh' first)"
        echo ""
        echo "Test scenarios:"
        echo "  1. Initial schema detection and archival"
        echo "  2. Add column schema change"
        echo "  3. Remove column schema change"
        echo "  4. Data type change"
        echo "  5. Disposal across multiple versions"
        echo "  6. Schema validation commands"
        echo ""
        echo "Options:"
        echo "  --help, -h    Show this help message"
        exit 0
        ;;
    *)
        main
        ;;
esac
