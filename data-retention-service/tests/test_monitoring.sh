#!/bin/bash
# test_monitoring.sh
# Test monitoring and health check procedures

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

# Test health check procedures
test_health_checks() {
    print_status "INFO" "Testing health check procedures..."
    
    # Test system prerequisites validation
    print_status "INFO" "Testing system prerequisites validation..."
    local validation_result
    validation_result=$(docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -h-1 -Q \
        "EXEC control_db.control.sp_Validate_System_Prerequisites" 2>/dev/null || echo "ERROR")
    
    if [[ $validation_result == *"VALID"* ]]; then
        print_status "SUCCESS" "System prerequisites validation working"
    else
        print_status "ERROR" "System prerequisites validation failed: $validation_result"
        return 1
    fi
    
    # Test system health metrics
    print_status "INFO" "Testing system health metrics..."
    local health_result
    health_result=$(docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -h-1 -Q \
        "EXEC control_db.control.sp_Show_System_Health" 2>/dev/null || echo "ERROR")
    
    if [[ $health_result != "ERROR" ]]; then
        print_status "SUCCESS" "System health metrics working"
    else
        print_status "ERROR" "System health metrics failed"
        return 1
    fi
    
    return 0
}

# Test monitoring procedures
test_monitoring_procedures() {
    print_status "INFO" "Testing monitoring procedures..."
    
    # Test execution monitoring
    print_status "INFO" "Testing execution monitoring..."
    local monitor_result
    monitor_result=$(docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -h-1 -Q \
        "EXEC control_db.control.sp_Monitor_Executions" 2>/dev/null || echo "ERROR")
    
    if [[ $monitor_result != "ERROR" ]]; then
        print_status "SUCCESS" "Execution monitoring working"
    else
        print_status "ERROR" "Execution monitoring failed"
        return 1
    fi
    
    # Test archive status
    print_status "INFO" "Testing archive status check..."
    local archive_result
    archive_result=$(docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -h-1 -Q \
        "EXEC control_db.control.sp_Show_Archive_Status" 2>/dev/null || echo "ERROR")
    
    if [[ $archive_result != "ERROR" ]]; then
        print_status "SUCCESS" "Archive status check working"
    else
        print_status "ERROR" "Archive status check failed"
        return 1
    fi
    
    return 0
}

# Test metrics collection
test_metrics_collection() {
    print_status "INFO" "Testing metrics collection..."
    
    # Insert test metrics
    print_status "INFO" "Inserting test metrics..."
    docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -Q "
        USE control_db;
        INSERT INTO control.archival_metrics (
            metric_type, metric_name, metric_value, metric_unit,
            source_database, operation
        ) VALUES (
            'THROUGHPUT', 'Test Metric', 100.0, 'rows/sec',
            'TestDB', 'TEST'
        );
    " > /dev/null 2>&1
    
    # Verify metrics were inserted
    local metrics_count
    metrics_count=$(docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -h-1 -Q \
        "USE control_db; SELECT COUNT(*) FROM control.archival_metrics WHERE metric_name = 'Test Metric';" 2>/dev/null || echo "0")
    
    if [[ $metrics_count -gt 0 ]]; then
        print_status "SUCCESS" "Metrics collection working"
    else
        print_status "ERROR" "Metrics collection failed"
        return 1
    fi
    
    return 0
}

# Test duplicate validation
test_duplicate_validation() {
    print_status "INFO" "Testing duplicate validation..."
    
    # Test duplicate validation procedure
    local duplicate_result
    duplicate_result=$(docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -h-1 -Q \
        "EXEC control_db.control.sp_Validate_No_Duplicates" 2>/dev/null || echo "ERROR")
    
    if [[ $duplicate_result == *"VALID"* ]]; then
        print_status "SUCCESS" "Duplicate validation working"
    else
        print_status "ERROR" "Duplicate validation failed: $duplicate_result"
        return 1
    fi
    
    return 0
}

# Main test execution
main() {
    echo "Testing monitoring and health check procedures..."
    echo ""
    
    local failed_tests=0
    
    # Test 1: Health checks
    if ! test_health_checks; then
        ((failed_tests++))
    fi
    
    # Test 2: Monitoring procedures
    if ! test_monitoring_procedures; then
        ((failed_tests++))
    fi
    
    # Test 3: Metrics collection
    if ! test_metrics_collection; then
        ((failed_tests++))
    fi
    
    # Test 4: Duplicate validation
    if ! test_duplicate_validation; then
        ((failed_tests++))
    fi
    
    echo ""
    if [ $failed_tests -eq 0 ]; then
        print_status "SUCCESS" "All monitoring tests passed!"
        return 0
    else
        print_status "ERROR" "$failed_tests monitoring tests failed"
        return 1
    fi
}

main "$@"
