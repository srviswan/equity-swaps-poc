#!/bin/bash
# run_tests.sh
# Comprehensive test suite for Data Retention Service

set -e

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

# Function to run a test
run_test() {
    local test_name=$1
    local test_script=$2
    
    print_status "INFO" "Running test: $test_name"
    
    if [ -f "$test_script" ]; then
        if bash "$test_script"; then
            print_status "SUCCESS" "$test_name passed"
            return 0
        else
            print_status "ERROR" "$test_name failed"
            return 1
        fi
    else
        print_status "ERROR" "Test script not found: $test_script"
        return 1
    fi
}

# Function to setup test environment
setup_test_env() {
    print_status "INFO" "Setting up test environment..."
    
    # Check if SQL Server is running
    if ! docker ps | grep -q "archival-sqlserver-v2"; then
        print_status "ERROR" "SQL Server container is not running"
        print_status "ERROR" "Please run './start.sh' first"
        return 1
    fi
    
    # Check if control database is initialized
    if ! docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -Q \
        "SELECT 1 FROM control_db.sys.tables WHERE name = 'archival_table_list'" > /dev/null 2>&1; then
        print_status "ERROR" "Control database is not initialized"
        print_status "ERROR" "Please run './init_control_db.sh' first"
        return 1
    fi
    
    print_status "SUCCESS" "Test environment is ready"
    return 0
}

# Main test execution
main() {
    echo "========================================"
    echo "Data Retention Service - Test Suite"
    echo "========================================"
    echo "Running comprehensive tests for the Data Retention Service"
    echo ""
    
    local failed_tests=0
    local total_tests=0
    
    # Setup test environment
    if ! setup_test_env; then
        exit 1
    fi
    
    echo ""
    echo "========================================"
    echo "Running Tests"
    echo "========================================"
    
    # Test 1: Idempotency
    ((total_tests++))
    if ! run_test "Idempotency Test" "test_idempotency.sh"; then
        ((failed_tests++))
    fi
    
    # Test 2: Recovery
    ((total_tests++))
    if ! run_test "Recovery Test" "test_recovery.sh"; then
        ((failed_tests++))
    fi
    
    # Test 3: Monitoring
    ((total_tests++))
    if ! run_test "Monitoring Test" "test_monitoring.sh"; then
        ((failed_tests++))
    fi
    
    # Test 4: Performance
    ((total_tests++))
    if ! run_test "Performance Test" "test_performance.sh"; then
        ((failed_tests++))
    fi
    
    # Test 5: End-to-End
    ((total_tests++))
    if ! run_test "End-to-End Test" "test_end_to_end.sh"; then
        ((failed_tests++))
    fi
    
    echo ""
    echo "========================================"
    echo "Test Results"
    echo "========================================"
    
    if [ $failed_tests -eq 0 ]; then
        print_status "SUCCESS" "All $total_tests tests passed!"
        echo ""
        echo "The Data Retention Service is working correctly."
        return 0
    else
        print_status "ERROR" "$failed_tests out of $total_tests tests failed"
        echo ""
        echo "Please review the failed tests and fix any issues."
        return 1
    fi
}

# Handle script arguments
case "${1:-}" in
    --help|-h)
        echo "Usage: $0 [--help]"
        echo ""
        echo "Run comprehensive tests for the Data Retention Service."
        echo ""
        echo "Prerequisites:"
        echo "  - SQL Server container must be running (run './start.sh')"
        echo "  - Control database must be initialized (run './init_control_db.sh')"
        echo ""
        echo "Tests included:"
        echo "  - Idempotency: Verify operations can be run multiple times safely"
        echo "  - Recovery: Test error recovery and resume capabilities"
        echo "  - Monitoring: Verify monitoring and health check procedures"
        echo "  - Performance: Test performance metrics and throughput"
        echo "  - End-to-End: Complete workflow test with sample data"
        echo ""
        echo "Options:"
        echo "  --help, -h    Show this help message"
        exit 0
        ;;
    *)
        main
        ;;
esac
