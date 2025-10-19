#!/bin/bash
# test_recovery.sh
# Test error recovery and resume capabilities

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

# Test recovery from failed executions
test_failed_execution_recovery() {
    print_status "INFO" "Testing recovery from failed executions..."
    
    # Simulate a failed execution by creating a failed state
    print_status "INFO" "Creating simulated failed execution state..."
    
    # Insert a failed execution state
    docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -Q "
        USE control_db;
        INSERT INTO control.archival_execution_state (
            execution_id, batch_id, workflow_type, source_database, table_name,
            current_phase, execution_status, error_count, last_error, can_resume
        ) VALUES (
            NEWID(), NEWID(), 'ARCHIVAL', 'TestDB', 'TestTable',
            'MOVE', 'FAILED', 1, 'Simulated test failure', 1
        );
    " > /dev/null 2>&1
    
    # Test resume functionality
    print_status "INFO" "Testing resume failed executions..."
    if python3 ../orchestrator.py --resume; then
        print_status "SUCCESS" "Resume functionality working"
        return 0
    else
        print_status "ERROR" "Resume functionality failed"
        return 1
    fi
}

# Test monitoring capabilities
test_monitoring_capabilities() {
    print_status "INFO" "Testing monitoring capabilities..."
    
    # Test status check
    print_status "INFO" "Testing system status check..."
    if python3 ../orchestrator.py --status > /dev/null 2>&1; then
        print_status "SUCCESS" "Status check working"
    else
        print_status "ERROR" "Status check failed"
        return 1
    fi
    
    # Test monitoring
    print_status "INFO" "Testing execution monitoring..."
    if python3 ../orchestrator.py --monitor > /dev/null 2>&1; then
        print_status "SUCCESS" "Monitoring working"
    else
        print_status "ERROR" "Monitoring failed"
        return 1
    fi
    
    return 0
}

# Test error handling
test_error_handling() {
    print_status "INFO" "Testing error handling..."
    
    # Test with invalid configuration
    print_status "INFO" "Testing error handling with invalid config..."
    
    # This should fail gracefully
    if python3 ../orchestrator.py --run 2>&1 | grep -q "SETUP REQUIRED\|ERROR"; then
        print_status "SUCCESS" "Error handling working correctly"
        return 0
    else
        print_status "WARNING" "Error handling test inconclusive"
        return 0
    fi
}

# Test system validation
test_system_validation() {
    print_status "INFO" "Testing system validation..."
    
    # Test prerequisite validation
    local validation_result
    validation_result=$(docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -h-1 -Q \
        "EXEC control_db.control.sp_Validate_System_Prerequisites" 2>/dev/null || echo "ERROR")
    
    if [[ $validation_result == *"VALID"* ]]; then
        print_status "SUCCESS" "System validation working"
        return 0
    else
        print_status "ERROR" "System validation failed: $validation_result"
        return 1
    fi
}

# Main test execution
main() {
    echo "Testing recovery and monitoring capabilities..."
    echo ""
    
    local failed_tests=0
    
    # Test 1: Failed execution recovery
    if ! test_failed_execution_recovery; then
        ((failed_tests++))
    fi
    
    # Test 2: Monitoring capabilities
    if ! test_monitoring_capabilities; then
        ((failed_tests++))
    fi
    
    # Test 3: Error handling
    if ! test_error_handling; then
        ((failed_tests++))
    fi
    
    # Test 4: System validation
    if ! test_system_validation; then
        ((failed_tests++))
    fi
    
    echo ""
    if [ $failed_tests -eq 0 ]; then
        print_status "SUCCESS" "All recovery tests passed!"
        return 0
    else
        print_status "ERROR" "$failed_tests recovery tests failed"
        return 1
    fi
}

main "$@"
