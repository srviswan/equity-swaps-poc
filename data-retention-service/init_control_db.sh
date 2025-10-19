#!/bin/bash
# init_control_db.sh
# Initialize control database with comprehensive validation

set -e

echo "========================================"
echo "Data Retention Service - Control DB Setup"
echo "========================================"
echo "This script initializes the control database with all required tables and procedures."
echo "It is idempotent and safe to run multiple times."
echo ""

# Configuration
CONTAINER_NAME="archival-sqlserver-v2"
SQL_SERVER="localhost"
SQL_USER="sa"
SQL_PASSWORD="Archival@2025!"
SCRIPT_DIR="/docker-entrypoint-initdb.d"

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Function to print colored output
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

# Function to execute SQL with validation
execute_sql() {
    local script=$1
    local description=$2
    local is_critical=${3:-true}
    
    print_status "INFO" "$description"
    
    # Check if script exists
    if [ ! -f "setup/$script" ]; then
        print_status "ERROR" "Script not found: setup/$script"
        if [ "$is_critical" = true ]; then
            exit 1
        else
            return 1
        fi
    fi
    
    # Execute SQL script
    if docker exec $CONTAINER_NAME /opt/mssql-tools18/bin/sqlcmd \
        -S $SQL_SERVER -U $SQL_USER -P "$SQL_PASSWORD" -C \
        -i "$SCRIPT_DIR/setup/$script" > /dev/null 2>&1; then
        print_status "SUCCESS" "$description"
        return 0
    else
        print_status "ERROR" "Failed: $description"
        if [ "$is_critical" = true ]; then
            print_status "ERROR" "Critical script failed. Exiting."
            exit 1
        else
            print_status "WARNING" "Non-critical script failed. Continuing."
            return 1
        fi
    fi
}

# Function to check if SQL Server is ready
check_sql_server() {
    print_status "INFO" "Checking SQL Server connectivity..."
    
    local max_attempts=30
    local attempt=1
    
    while [ $attempt -le $max_attempts ]; do
        if docker exec $CONTAINER_NAME /opt/mssql-tools18/bin/sqlcmd \
            -S $SQL_SERVER -U $SQL_USER -P "$SQL_PASSWORD" -C \
            -Q "SELECT 1" > /dev/null 2>&1; then
            print_status "SUCCESS" "SQL Server is ready"
            return 0
        fi
        
        print_status "INFO" "Waiting for SQL Server... (attempt $attempt/$max_attempts)"
        sleep 2
        ((attempt++))
    done
    
    print_status "ERROR" "SQL Server is not responding after $max_attempts attempts"
    print_status "ERROR" "Please check that the container is running: docker ps"
    exit 1
}

# Function to validate setup
validate_setup() {
    print_status "INFO" "Validating setup..."
    
    local validation_result
    validation_result=$(docker exec $CONTAINER_NAME /opt/mssql-tools18/bin/sqlcmd \
        -S $SQL_SERVER -U $SQL_USER -P "$SQL_PASSWORD" -C -h-1 -Q \
        "EXEC control_db.control.sp_Validate_System_Prerequisites" 2>/dev/null || echo "ERROR")
    
    if [[ $validation_result == *"VALID"* ]]; then
        print_status "SUCCESS" "All prerequisites validated successfully"
        return 0
    else
        print_status "ERROR" "Validation failed: $validation_result"
        return 1
    fi
}

# Function to show system information
show_system_info() {
    echo ""
    echo "========================================"
    echo "System Information"
    echo "========================================"
    
    # Show databases
    print_status "INFO" "Databases:"
    docker exec $CONTAINER_NAME /opt/mssql-tools18/bin/sqlcmd \
        -S $SQL_SERVER -U $SQL_USER -P "$SQL_PASSWORD" -C -Q \
        "SELECT name FROM sys.databases WHERE name IN ('control_db', 'archive_db')" 2>/dev/null || true
    
    # Show tables in control_db
    print_status "INFO" "Control database tables:"
    docker exec $CONTAINER_NAME /opt/mssql-tools18/bin/sqlcmd \
        -S $SQL_SERVER -U $SQL_USER -P "$SQL_PASSWORD" -C -Q \
        "USE control_db; SELECT name FROM sys.tables ORDER BY name" 2>/dev/null || true
    
    # Show procedures in control_db
    print_status "INFO" "Control database procedures:"
    docker exec $CONTAINER_NAME /opt/mssql-tools18/bin/sqlcmd \
        -S $SQL_SERVER -U $SQL_USER -P "$SQL_PASSWORD" -C -Q \
        "USE control_db; SELECT name FROM sys.procedures WHERE schema_name(schema_id) = 'control' ORDER BY name" 2>/dev/null || true
}

# Main execution
main() {
    echo "Starting control database initialization..."
    echo ""
    
    # Check if container is running
    if ! docker ps | grep -q $CONTAINER_NAME; then
        print_status "ERROR" "Container $CONTAINER_NAME is not running"
        print_status "ERROR" "Please run './start.sh' first to start the SQL Server container"
        exit 1
    fi
    
    # Check SQL Server connectivity
    check_sql_server
    
    echo ""
    echo "========================================"
    echo "Executing Setup Scripts"
    echo "========================================"
    
    # Execute setup scripts (all are idempotent)
    execute_sql "01_create_databases.sql" "Create control_db and archive_db"
    execute_sql "02_create_archival_table_list.sql" "Create configuration table"
    execute_sql "03_create_marker_tables.sql" "Create tracking tables"
    execute_sql "04_partition_detection_procedures.sql" "Create partition detection procedures"
    execute_sql "05_monitoring_procedures.sql" "Create monitoring procedures"
    
    echo ""
    echo "========================================"
    echo "Executing Archival Procedures"
    echo "========================================"
    
    # Execute archival procedures
    execute_sql "../archival/01_archival_utilities.sql" "Create archival utility procedures"
    execute_sql "../archival/02_prepare_archival_records.sql" "Create record preparation procedures"
    execute_sql "../archival/05_archive_movement_procedures.sql" "Create data movement procedures"
    execute_sql "../archival/07_disposal_procedures.sql" "Create disposal procedures"
    execute_sql "../archival/06_master_archival_procedure.sql" "Create master orchestration procedures"
    
    echo ""
    echo "========================================"
    echo "Validating Setup"
    echo "========================================"
    
    # Validate setup
    if validate_setup; then
        echo ""
        print_status "SUCCESS" "Control database initialization completed successfully!"
        echo ""
        echo "System is ready for archival operations!"
        echo ""
        echo "Next steps:"
        echo "  1. Configure tables: Add entries to control.archival_table_list"
        echo "  2. Run archival: python3 orchestrator.py --run"
        echo "  3. Monitor: python3 orchestrator.py --status"
        echo ""
        
        # Show system information
        show_system_info
        
    else
        print_status "ERROR" "Setup validation failed"
        print_status "ERROR" "Please check the error messages above and retry"
        exit 1
    fi
}

# Handle script arguments
case "${1:-}" in
    --help|-h)
        echo "Usage: $0 [--help]"
        echo ""
        echo "Initialize the control database for the Data Retention Service."
        echo "This script is idempotent and safe to run multiple times."
        echo ""
        echo "Prerequisites:"
        echo "  - SQL Server container must be running (run './start.sh' first)"
        echo "  - All SQL scripts must be present in setup/ and archival/ directories"
        echo ""
        echo "Options:"
        echo "  --help, -h    Show this help message"
        exit 0
        ;;
    *)
        main
        ;;
esac
