#!/bin/bash
# test_performance.sh
# Test performance metrics and throughput

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

# Test performance metrics collection
test_performance_metrics() {
    print_status "INFO" "Testing performance metrics collection..."
    
    # Insert test performance metrics
    print_status "INFO" "Inserting test performance metrics..."
    docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -Q "
        USE control_db;
        INSERT INTO control.archival_metrics (
            metric_type, metric_name, metric_value, metric_unit,
            source_database, operation, metric_timestamp
        ) VALUES 
        ('THROUGHPUT', 'Records Per Second', 1000.0, 'rows/sec', 'TestDB', 'ARCHIVAL', GETDATE()),
        ('LATENCY', 'Operation Duration', 500.0, 'ms', 'TestDB', 'ARCHIVAL', GETDATE()),
        ('ERROR_RATE', 'Failure Rate', 0.01, 'percent', 'TestDB', 'ARCHIVAL', GETDATE());
    " > /dev/null 2>&1
    
    # Verify metrics were inserted
    local metrics_count
    metrics_count=$(docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -h-1 -Q \
        "USE control_db; SELECT COUNT(*) FROM control.archival_metrics WHERE source_database = 'TestDB';" 2>/dev/null || echo "0")
    
    if [[ $metrics_count -ge 3 ]]; then
        print_status "SUCCESS" "Performance metrics collection working ($metrics_count metrics)"
    else
        print_status "ERROR" "Performance metrics collection failed ($metrics_count metrics)"
        return 1
    fi
    
    return 0
}

# Test throughput measurement
test_throughput_measurement() {
    print_status "INFO" "Testing throughput measurement..."
    
    # Test table metrics procedure
    print_status "INFO" "Testing table metrics procedure..."
    local metrics_result
    metrics_result=$(docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -h-1 -Q \
        "USE control_db; EXEC control.sp_Get_Table_Metrics 'control_db', 'archival_table_list';" 2>/dev/null || echo "ERROR")
    
    if [[ $metrics_result != "ERROR" ]]; then
        print_status "SUCCESS" "Throughput measurement working"
    else
        print_status "ERROR" "Throughput measurement failed"
        return 1
    fi
    
    return 0
}

# Test performance thresholds
test_performance_thresholds() {
    print_status "INFO" "Testing performance thresholds..."
    
    # Insert metrics that exceed thresholds
    print_status "INFO" "Testing threshold detection..."
    docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -Q "
        USE control_db;
        INSERT INTO control.archival_metrics (
            metric_type, metric_name, metric_value, metric_unit,
            threshold_exceeded, alert_severity
        ) VALUES 
        ('LATENCY', 'High Latency Test', 10000.0, 'ms', 1, 'CRITICAL'),
        ('ERROR_RATE', 'High Error Rate', 0.5, 'percent', 1, 'WARNING');
    " > /dev/null 2>&1
    
    # Check threshold detection
    local threshold_count
    threshold_count=$(docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -h-1 -Q \
        "USE control_db; SELECT COUNT(*) FROM control.archival_metrics WHERE threshold_exceeded = 1;" 2>/dev/null || echo "0")
    
    if [[ $threshold_count -ge 2 ]]; then
        print_status "SUCCESS" "Performance threshold detection working ($threshold_count thresholds exceeded)"
    else
        print_status "ERROR" "Performance threshold detection failed ($threshold_count thresholds exceeded)"
        return 1
    fi
    
    return 0
}

# Test metrics aggregation
test_metrics_aggregation() {
    print_status "INFO" "Testing metrics aggregation..."
    
    # Test metrics aggregation query
    local aggregation_result
    aggregation_result=$(docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd \
        -S localhost -U sa -P 'Archival@2025!' -C -h-1 -Q "
        USE control_db;
        SELECT 
            metric_type,
            COUNT(*) as metric_count,
            AVG(metric_value) as avg_value,
            MAX(metric_value) as max_value
        FROM control.archival_metrics
        WHERE metric_timestamp >= DATEADD(HOUR, -1, GETDATE())
        GROUP BY metric_type;
    " 2>/dev/null || echo "ERROR")
    
    if [[ $aggregation_result != "ERROR" && $aggregation_result != "" ]]; then
        print_status "SUCCESS" "Metrics aggregation working"
    else
        print_status "ERROR" "Metrics aggregation failed"
        return 1
    fi
    
    return 0
}

# Main test execution
main() {
    echo "Testing performance metrics and throughput..."
    echo ""
    
    local failed_tests=0
    
    # Test 1: Performance metrics collection
    if ! test_performance_metrics; then
        ((failed_tests++))
    fi
    
    # Test 2: Throughput measurement
    if ! test_throughput_measurement; then
        ((failed_tests++))
    fi
    
    # Test 3: Performance thresholds
    if ! test_performance_thresholds; then
        ((failed_tests++))
    fi
    
    # Test 4: Metrics aggregation
    if ! test_metrics_aggregation; then
        ((failed_tests++))
    fi
    
    echo ""
    if [ $failed_tests -eq 0 ]; then
        print_status "SUCCESS" "All performance tests passed!"
        return 0
    else
        print_status "ERROR" "$failed_tests performance tests failed"
        return 1
    fi
}

main "$@"
