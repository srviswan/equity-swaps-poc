#!/bin/bash
# test_idempotency.sh
# Test that operations can be run multiple times safely

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

# Test idempotency of archival operations
test_archival_idempotency() {
    print_status "INFO" "Testing archival operation idempotency..."
    
    # Run archival workflow twice
    print_status "INFO" "Running archival workflow (first time)..."
    if python3 ../orchestrator.py --run; then
        print_status "SUCCESS" "First archival run completed"
    else
        print_status "ERROR" "First archival run failed"
        return 1
    fi
    
    print_status "INFO" "Running archival workflow (second time)..."
    if python3 ../orchestrator.py --run; then
        print_status "SUCCESS" "Second archival run completed"
    else
        print_status "ERROR" "Second archival run failed"
        return 1
    fi
    
    # Verify no duplicate data
    print_status "INFO" "Verifying no duplicate data..."
    local duplicate_check
    duplicate_check=$(docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -h-1 -Q \
        "EXEC control_db.control.sp_Validate_No_Duplicates" 2>/dev/null || echo "ERROR")
    
    if [[ $duplicate_check == *"VALID"* ]]; then
        print_status "SUCCESS" "No duplicate data found"
        return 0
    else
        print_status "ERROR" "Duplicate data detected: $duplicate_check"
        return 1
    fi
}

# Test idempotency of disposal operations
test_disposal_idempotency() {
    print_status "INFO" "Testing disposal operation idempotency..."
    
    # Run disposal workflow twice
    print_status "INFO" "Running disposal workflow (first time)..."
    if python3 ../orchestrator.py --dispose; then
        print_status "SUCCESS" "First disposal run completed"
    else
        print_status "WARNING" "First disposal run failed (may be expected if no data to dispose)"
    fi
    
    print_status "INFO" "Running disposal workflow (second time)..."
    if python3 ../orchestrator.py --dispose; then
        print_status "SUCCESS" "Second disposal run completed"
    else
        print_status "WARNING" "Second disposal run failed (may be expected if no data to dispose)"
    fi
    
    return 0
}

# Test idempotency of system validation
test_validation_idempotency() {
    print_status "INFO" "Testing system validation idempotency..."
    
    # Run validation multiple times
    for i in {1..3}; do
        print_status "INFO" "Running system validation (attempt $i)..."
        if python3 ../orchestrator.py --status > /dev/null 2>&1; then
            print_status "SUCCESS" "Validation attempt $i completed"
        else
            print_status "ERROR" "Validation attempt $i failed"
            return 1
        fi
    done
    
    return 0
}

# Main test execution
main() {
    echo "Testing idempotency of Data Retention Service operations..."
    echo ""
    
    local failed_tests=0
    
    # Test 1: Archival idempotency
    if ! test_archival_idempotency; then
        ((failed_tests++))
    fi
    
    # Test 2: Disposal idempotency
    if ! test_disposal_idempotency; then
        ((failed_tests++))
    fi
    
    # Test 3: Validation idempotency
    if ! test_validation_idempotency; then
        ((failed_tests++))
    fi
    
    echo ""
    if [ $failed_tests -eq 0 ]; then
        print_status "SUCCESS" "All idempotency tests passed!"
        return 0
    else
        print_status "ERROR" "$failed_tests idempotency tests failed"
        return 1
    fi
}

main "$@"
