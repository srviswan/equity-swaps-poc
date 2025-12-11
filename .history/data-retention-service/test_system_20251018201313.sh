#!/bin/bash
# test_system.sh
# Comprehensive test system for Data Retention Service

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

# Check prerequisites
check_prerequisites() {
    print_status "INFO" "Checking prerequisites..."
    
    # Check if Docker is running
    if ! docker info > /dev/null 2>&1; then
        print_status "ERROR" "Docker is not running"
        return 1
    fi
    
    # Check if SQL Server container is running
    if ! docker ps | grep -q "archival-sqlserver-v2"; then
        print_status "ERROR" "SQL Server container is not running"
        print_status "ERROR" "Please run './start.sh' first"
        return 1
    fi
    
    # Check if Python dependencies are installed
    if ! python3 -c "import pyodbc" > /dev/null 2>&1; then
        print_status "ERROR" "Python pyodbc module not installed"
        print_status "ERROR" "Please run 'pip install -r requirements.txt'"
        return 1
    fi
    
    print_status "SUCCESS" "Prerequisites check passed"
    return 0
}

# Setup mode - initialize control database
setup_mode() {
    print_status "INFO" "Running in setup mode..."
    
    # Check if control database is already initialized
    if docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -Q \
        "SELECT 1 FROM control_db.sys.tables WHERE name = 'archival_table_list'" > /dev/null 2>&1; then
        print_status "WARNING" "Control database already initialized"
        print_status "INFO" "Skipping setup"
        return 0
    fi
    
    # Run initialization
    print_status "INFO" "Initializing control database..."
    if ./init_control_db.sh; then
        print_status "SUCCESS" "Control database initialized"
        return 0
    else
        print_status "ERROR" "Control database initialization failed"
        return 1
    fi
}

# Test mode - run comprehensive tests
test_mode() {
    print_status "INFO" "Running in test mode..."
    
    # Check if control database is initialized
    if ! docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -Q \
        "SELECT 1 FROM control_db.sys.tables WHERE name = 'archival_table_list'" > /dev/null 2>&1; then
        print_status "ERROR" "Control database not initialized"
        print_status "ERROR" "Please run './init_control_db.sh' first or use --setup mode"
        return 1
    fi
    
    # Run test suite
    print_status "INFO" "Running comprehensive test suite..."
    if ./tests/run_tests.sh; then
        print_status "SUCCESS" "All tests passed"
        return 0
    else
        print_status "ERROR" "Some tests failed"
        return 1
    fi
}

# Full mode - setup and test
full_mode() {
    print_status "INFO" "Running in full mode (setup + test)..."
    
    # Setup
    if ! setup_mode; then
        print_status "ERROR" "Setup failed"
        return 1
    fi
    
    # Test
    if ! test_mode; then
        print_status "ERROR" "Tests failed"
        return 1
    fi
    
    print_status "SUCCESS" "Full mode completed successfully"
    return 0
}

# Show system status
show_status() {
    print_status "INFO" "Showing system status..."
    
    # Check container status
    print_status "INFO" "Container status:"
    docker ps | grep archival-sqlserver-v2 || print_status "WARNING" "Container not running"
    
    # Check database status
    print_status "INFO" "Database status:"
    docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -Q \
        "SELECT name FROM sys.databases WHERE name IN ('control_db', 'archive_db')" 2>/dev/null || print_status "WARNING" "Cannot connect to database"
    
    # Check orchestrator status
    print_status "INFO" "Orchestrator status:"
    if python3 orchestrator.py --status > /dev/null 2>&1; then
        print_status "SUCCESS" "Orchestrator working"
    else
        print_status "WARNING" "Orchestrator not working"
    fi
}

# Main execution
main() {
    echo "========================================"
    echo "Data Retention Service - Test System"
    echo "========================================"
    echo ""
    
    # Check prerequisites
    if ! check_prerequisites; then
        exit 1
    fi
    
    # Handle different modes
    case "${1:-test}" in
        --setup)
            setup_mode
            ;;
        --test)
            test_mode
            ;;
        --full)
            full_mode
            ;;
        --status)
            show_status
            ;;
        --help|-h)
            echo "Usage: $0 [--setup|--test|--full|--status|--help]"
            echo ""
            echo "Modes:"
            echo "  --setup    Initialize control database only"
            echo "  --test     Run tests only (requires setup)"
            echo "  --full     Setup and test (default)"
            echo "  --status   Show system status"
            echo "  --help     Show this help"
            echo ""
            echo "Prerequisites:"
            echo "  - Docker running"
            echo "  - SQL Server container running (run './start.sh')"
            echo "  - Python dependencies installed"
            exit 0
            ;;
        *)
            print_status "ERROR" "Unknown mode: $1"
            print_status "ERROR" "Use --help for usage information"
            exit 1
            ;;
    esac
}

main "$@"
