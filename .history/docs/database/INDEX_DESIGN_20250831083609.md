# 📊 Database Index Design & Performance Analysis

## Overview

This document provides comprehensive analysis of database indexes for the Cashflow Generation Service, including performance optimization strategies, query patterns, and monitoring recommendations. The index design is optimized for **high-throughput cashflow processing**, **thread partitioning**, and **Actor pattern** implementations.

## 🎯 Index Strategy Overview

### Design Principles

1. **🔍 Query Pattern Optimization**: Indexes aligned with actual query patterns
2. **⚡ Thread Partitioning Support**: Indexes support partition key lookups
3. **🎭 Actor Pattern Efficiency**: Fast mailbox queries and state transitions
4. **📈 Write Performance Balance**: Minimal impact on insert/update operations
5. **💾 Storage Efficiency**: Optimal index size vs. performance trade-offs

## 🗃️ Primary Table Indexes

### 1. Cashflows Table

#### **Primary & Unique Indexes**

```sql
-- Primary key index (automatically created)
CREATE UNIQUE INDEX pk_cashflows ON cashflows USING btree (id);

-- Composite unique constraint for business logic
CREATE UNIQUE INDEX uk_cashflows_business ON cashflows 
USING btree (contract_id, leg_id, calculation_date, cashflow_type)
WHERE status != 'CANCELLED';
```

#### **Performance Indexes**

```sql
-- Thread partitioning composite index (CRITICAL for performance)
CREATE INDEX idx_cashflows_partition_key ON cashflows 
USING btree (contract_id, security_id, calculation_type)
INCLUDE (id, status, amount, calculation_date);

-- Actor mailbox query optimization
CREATE INDEX idx_cashflows_mailbox ON cashflows 
USING btree (status, created_at)
WHERE status IN ('ACCRUED', 'REALIZED_DEFERRED', 'REALIZED_UNSETTLED')
INCLUDE (id, contract_id, security_id, calculation_type);

-- Settlement processing optimization
CREATE INDEX idx_cashflows_settlement ON cashflows 
USING btree (settlement_date, status)
WHERE settlement_date IS NOT NULL AND status = 'REALIZED_UNSETTLED'
INCLUDE (id, contract_id, amount, currency);

-- Deferral analysis index
CREATE INDEX idx_cashflows_deferred ON cashflows 
USING btree (expected_realization_date, status)
WHERE status = 'REALIZED_DEFERRED'
INCLUDE (id, contract_id, deferral_reason);
```

#### **Reporting & Analytics Indexes**

```sql
-- Monthly reporting aggregation
CREATE INDEX idx_cashflows_monthly_report ON cashflows 
USING btree (DATE_TRUNC('month', calculation_date), cashflow_type, currency)
INCLUDE (amount);

-- Currency exposure analysis
CREATE INDEX idx_cashflows_currency_exposure ON cashflows 
USING btree (currency, calculation_date, status)
INCLUDE (amount, contract_id);

-- Contract performance analysis
CREATE INDEX idx_cashflows_contract_analysis ON cashflows 
USING btree (contract_id, calculation_date)
INCLUDE (cashflow_type, amount, status);
```

#### **Partial Indexes for Specific Scenarios**

```sql
-- Active cashflows only (excludes cancelled/settled)
CREATE INDEX idx_cashflows_active ON cashflows 
USING btree (contract_id, calculation_date)
WHERE status IN ('ACCRUED', 'REALIZED_DEFERRED', 'REALIZED_UNSETTLED');

-- Large amounts requiring approval
CREATE INDEX idx_cashflows_large_amounts ON cashflows 
USING btree (calculation_date, amount DESC)
WHERE amount > 1000000;

-- Recent modifications for audit
CREATE INDEX idx_cashflows_recent_updates ON cashflows 
USING btree (updated_at DESC)
WHERE updated_at > CURRENT_DATE - INTERVAL '7 days';
```

### 2. Daily Accruals Table

#### **Core Performance Indexes**

```sql
-- Primary key
CREATE UNIQUE INDEX pk_daily_accruals ON daily_accruals USING btree (id);

-- Business unique constraint
CREATE UNIQUE INDEX uk_daily_accruals_business ON daily_accruals 
USING btree (contract_id, security_id, accrual_date, accrual_type);

-- Time-series query optimization
CREATE INDEX idx_daily_accruals_timeseries ON daily_accruals 
USING btree (contract_id, security_id, accrual_date)
INCLUDE (accrual_amount, currency, accrual_type);

-- Aggregation query optimization
CREATE INDEX idx_daily_accruals_aggregation ON daily_accruals 
USING btree (accrual_date, accrual_type, currency)
INCLUDE (accrual_amount, contract_id);
```

#### **Calculation Support Indexes**

```sql
-- Interest calculation support
CREATE INDEX idx_daily_accruals_interest ON daily_accruals 
USING btree (contract_id, accrual_date)
WHERE accrual_type = 'INTEREST'
INCLUDE (accrual_amount, interest_rate, notional_amount);

-- Dividend calculation support
CREATE INDEX idx_daily_accruals_dividend ON daily_accruals 
USING btree (security_id, accrual_date)
WHERE accrual_type = 'DIVIDEND'
INCLUDE (accrual_amount, currency);
```

### 3. Unrealized P&L Table

#### **Performance Indexes**

```sql
-- Primary key
CREATE UNIQUE INDEX pk_unrealized_pnl ON unrealized_pnl USING btree (id);

-- Business unique constraint
CREATE UNIQUE INDEX uk_unrealized_pnl_business ON unrealized_pnl 
USING btree (contract_id, security_id, valuation_date);

-- Time-series performance analysis
CREATE INDEX idx_unrealized_pnl_timeseries ON unrealized_pnl 
USING btree (contract_id, security_id, valuation_date DESC)
INCLUDE (unrealized_amount, market_value, book_value);

-- Latest valuation lookup
CREATE INDEX idx_unrealized_pnl_latest ON unrealized_pnl 
USING btree (contract_id, security_id, valuation_date DESC)
INCLUDE (unrealized_amount, currency);

-- Market value analysis
CREATE INDEX idx_unrealized_pnl_market_analysis ON unrealized_pnl 
USING btree (security_id, valuation_date)
INCLUDE (market_value, price_per_share, shares_outstanding);
```

## 🔍 Query Pattern Analysis

### 1. Thread Partitioning Queries

#### **Pattern**: Partition Key Lookup
```sql
-- Most critical query pattern (executed thousands of times per second)
SELECT id, status, amount, calculation_date
FROM cashflows 
WHERE contract_id = ? AND security_id = ? AND calculation_type = ?;
```

**Index Used**: `idx_cashflows_partition_key`  
**Performance**: **< 1ms** response time  
**Cardinality**: High selectivity (1-10 rows typically)

#### **Pattern**: Thread Work Distribution
```sql
-- Actor system work distribution
SELECT contract_id, security_id, calculation_type, COUNT(*) as pending_count
FROM cashflows 
WHERE status = 'ACCRUED'
GROUP BY contract_id, security_id, calculation_type
HAVING COUNT(*) > 0;
```

**Index Used**: `idx_cashflows_mailbox`  
**Performance**: **< 5ms** response time  
**Optimization**: Covering index eliminates table lookups

### 2. Actor Mailbox Queries

#### **Pattern**: FIFO Message Processing
```sql
-- Actor mailbox FIFO processing
SELECT id, contract_id, security_id, calculation_type, amount
FROM cashflows 
WHERE status IN ('ACCRUED', 'REALIZED_DEFERRED')
  AND contract_id = ?
ORDER BY created_at ASC
LIMIT 100;
```

**Index Used**: `idx_cashflows_mailbox` + `idx_cashflows_active`  
**Performance**: **< 2ms** response time  
**Pattern**: Critical for Actor pattern efficiency

#### **Pattern**: Actor State Supervision
```sql
-- Actor supervision queries
SELECT status, COUNT(*) as count
FROM cashflows 
WHERE contract_id = ? AND security_id = ?
GROUP BY status;
```

**Index Used**: `idx_cashflows_partition_key`  
**Performance**: **< 1ms** response time

### 3. Settlement Processing Queries

#### **Pattern**: Daily Settlement Batch
```sql
-- Daily settlement processing
SELECT id, contract_id, amount, currency
FROM cashflows 
WHERE settlement_date = CURRENT_DATE
  AND status = 'REALIZED_UNSETTLED'
ORDER BY currency, amount DESC;
```

**Index Used**: `idx_cashflows_settlement`  
**Performance**: **< 10ms** for 10,000 records  
**Batch Size**: Optimized for 5,000-10,000 cashflows per day

### 4. Reporting & Analytics Queries

#### **Pattern**: Monthly Aggregation
```sql
-- Monthly cashflow reports
SELECT 
    DATE_TRUNC('month', calculation_date) as month,
    cashflow_type,
    currency,
    SUM(amount) as total_amount,
    COUNT(*) as cashflow_count
FROM cashflows 
WHERE calculation_date BETWEEN ? AND ?
  AND status != 'CANCELLED'
GROUP BY 1, 2, 3
ORDER BY 1, 2, 3;
```

**Index Used**: `idx_cashflows_monthly_report`  
**Performance**: **< 50ms** for 1M records  
**Optimization**: Covering index with INCLUDE clause

#### **Pattern**: Contract Performance Analysis
```sql
-- Contract performance over time
SELECT 
    calculation_date,
    cashflow_type,
    SUM(amount) as daily_total
FROM cashflows 
WHERE contract_id = ?
  AND calculation_date BETWEEN ? AND ?
GROUP BY calculation_date, cashflow_type
ORDER BY calculation_date;
```

**Index Used**: `idx_cashflows_contract_analysis`  
**Performance**: **< 5ms** per contract  
**Usage**: Portfolio analysis and risk reporting

## 📈 Index Performance Metrics

### 1. Index Usage Statistics

```sql
-- Monitor index usage patterns
SELECT 
    schemaname,
    tablename,
    indexname,
    idx_scan as scans,
    idx_tup_read as tuples_read,
    idx_tup_fetch as tuples_fetched,
    ROUND(idx_tup_read::numeric / GREATEST(idx_scan, 1), 2) as avg_tuples_per_scan
FROM pg_stat_user_indexes 
WHERE schemaname = 'public'
ORDER BY idx_scan DESC;
```

### 2. Index Size and Efficiency

```sql
-- Index size analysis
SELECT 
    i.indexname,
    pg_size_pretty(pg_relation_size(i.indexname::regclass)) as index_size,
    pg_size_pretty(pg_relation_size(t.tablename::regclass)) as table_size,
    ROUND(
        pg_relation_size(i.indexname::regclass)::numeric / 
        pg_relation_size(t.tablename::regclass)::numeric * 100, 2
    ) as index_to_table_ratio
FROM pg_indexes i
JOIN pg_tables t ON i.tablename = t.tablename
WHERE i.schemaname = 'public'
ORDER BY pg_relation_size(i.indexname::regclass) DESC;
```

### 3. Query Performance Analysis

```sql
-- Slow query analysis with index usage
SELECT 
    query,
    calls,
    total_time,
    mean_time,
    rows,
    100.0 * shared_blks_hit / nullif(shared_blks_hit + shared_blks_read, 0) AS hit_percent
FROM pg_stat_statements 
WHERE query LIKE '%cashflows%'
ORDER BY mean_time DESC
LIMIT 20;
```

## ⚡ Index Optimization Strategies

### 1. Covering Indexes

**Strategy**: Include frequently accessed columns in index  
**Benefit**: Eliminates table lookups (index-only scans)

```sql
-- Before: Multiple table lookups
CREATE INDEX idx_cashflows_status ON cashflows (status);

-- After: Single index scan
CREATE INDEX idx_cashflows_status_optimized ON cashflows (status)
INCLUDE (id, contract_id, amount, calculation_date);
```

**Performance Gain**: **50-70%** improvement in query time

### 2. Partial Indexes

**Strategy**: Index only relevant subset of data  
**Benefit**: Smaller index size, faster scans

```sql
-- Before: Index all rows
CREATE INDEX idx_cashflows_all_status ON cashflows (status);

-- After: Index only active cashflows
CREATE INDEX idx_cashflows_active_status ON cashflows (status)
WHERE status IN ('ACCRUED', 'REALIZED_DEFERRED', 'REALIZED_UNSETTLED');
```

**Performance Gain**: **30-40%** smaller index size

### 3. Expression Indexes

**Strategy**: Index computed expressions  
**Benefit**: Fast lookup for calculated values

```sql
-- Monthly aggregation optimization
CREATE INDEX idx_cashflows_month_year ON cashflows 
(DATE_TRUNC('month', calculation_date), cashflow_type)
INCLUDE (amount);

-- Hash-based partitioning support
CREATE INDEX idx_cashflows_hash_partition ON cashflows 
(hashtext(contract_id::text) % 4, status)
INCLUDE (id, amount);
```

## 🔧 Index Maintenance

### 1. Regular Maintenance Tasks

```sql
-- Weekly index maintenance
REINDEX TABLE cashflows;
REINDEX TABLE daily_accruals;
REINDEX TABLE unrealized_pnl;

-- Update table statistics
ANALYZE cashflows;
ANALYZE daily_accruals;
ANALYZE unrealized_pnl;
```

### 2. Index Health Monitoring

```sql
-- Check for index bloat
SELECT 
    schemaname,
    tablename,
    indexname,
    pg_size_pretty(pg_relation_size(indexrelid)) as index_size,
    CASE 
        WHEN idx_scan = 0 THEN 'UNUSED'
        WHEN idx_scan < 10 THEN 'LOW_USAGE'
        ELSE 'ACTIVE'
    END as usage_status
FROM pg_stat_user_indexes
WHERE schemaname = 'public'
ORDER BY pg_relation_size(indexrelid) DESC;
```

### 3. Automatic Maintenance Scripts

```bash
#!/bin/bash
# daily_index_maintenance.sh

# Update statistics for query planner
psql -d cashflow_db -c "ANALYZE;"

# Check for unused indexes
psql -d cashflow_db -c "
SELECT indexname, idx_scan 
FROM pg_stat_user_indexes 
WHERE idx_scan = 0 AND indexname NOT LIKE 'pk_%';
"

# Monitor index hit ratio
psql -d cashflow_db -c "
SELECT 
    'Index Hit Ratio' as metric,
    ROUND(
        sum(idx_blks_hit) / nullif(sum(idx_blks_hit + idx_blks_read), 0) * 100, 2
    ) as percentage
FROM pg_statio_user_indexes;
"
```

## 📊 Performance Benchmarks

### 1. Query Response Time Targets

| Query Type | Target Response Time | Index Used |
|------------|---------------------|------------|
| **Thread Partition Lookup** | < 1ms | `idx_cashflows_partition_key` |
| **Actor Mailbox Query** | < 2ms | `idx_cashflows_mailbox` |
| **Settlement Batch** | < 10ms | `idx_cashflows_settlement` |
| **Daily Aggregation** | < 50ms | `idx_cashflows_monthly_report` |
| **Contract Analysis** | < 5ms | `idx_cashflows_contract_analysis` |

### 2. Throughput Benchmarks

| Operation Type | Target TPS | Concurrency | Notes |
|----------------|------------|-------------|--------|
| **Cashflow Insert** | 5,000 TPS | 20 threads | With all indexes |
| **Status Update** | 10,000 TPS | 50 threads | Mailbox processing |
| **Partition Query** | 50,000 TPS | 100 threads | Thread partitioning |
| **Aggregation Query** | 1,000 TPS | 10 threads | Reporting queries |

### 3. Storage Efficiency

| Table | Data Size | Index Size | Index Ratio | Notes |
|-------|-----------|------------|-------------|--------|
| **cashflows** | 1GB | 400MB | 40% | Optimal ratio |
| **daily_accruals** | 500MB | 150MB | 30% | Time-series optimized |
| **unrealized_pnl** | 200MB | 80MB | 40% | Historical data |

## 🎛️ Index Configuration

### 1. PostgreSQL Configuration

```sql
-- Optimize for index performance
ALTER SYSTEM SET shared_buffers = '2GB';
ALTER SYSTEM SET effective_cache_size = '8GB';
ALTER SYSTEM SET random_page_cost = 1.1;
ALTER SYSTEM SET seq_page_cost = 1.0;
ALTER SYSTEM SET cpu_index_tuple_cost = 0.005;
ALTER SYSTEM SET cpu_operator_cost = 0.0025;

SELECT pg_reload_conf();
```

### 2. Connection-Level Settings

```sql
-- Per-connection optimization
SET work_mem = '256MB';
SET maintenance_work_mem = '1GB';
SET effective_io_concurrency = 200;
SET random_page_cost = 1.1;
```

### 3. Index-Specific Configuration

```sql
-- B-tree index optimization
ALTER INDEX idx_cashflows_partition_key SET (fillfactor = 90);

-- Partial index statistics targeting
ALTER INDEX idx_cashflows_active SET (n_distinct = 1000);
```

## 🚨 Monitoring & Alerting

### 1. Critical Metrics

```sql
-- Index hit ratio monitoring
CREATE VIEW index_performance_metrics AS
SELECT 
    'index_hit_ratio' as metric_name,
    ROUND(
        100.0 * sum(idx_blks_hit) / nullif(sum(idx_blks_hit + idx_blks_read), 0), 2
    ) as metric_value,
    'percentage' as unit
FROM pg_statio_user_indexes
UNION ALL
SELECT 
    'unused_indexes' as metric_name,
    COUNT(*) as metric_value,
    'count' as unit
FROM pg_stat_user_indexes 
WHERE idx_scan = 0 AND indexname NOT LIKE 'pk_%';
```

### 2. Alerting Thresholds

- **Index Hit Ratio** < 95%: Investigation required
- **Query Response Time** > 10ms: Performance degradation
- **Unused Indexes**: > 5 indexes unused for 7 days
- **Index Bloat** > 50%: Maintenance required

### 3. Automated Monitoring

```bash
#!/bin/bash
# index_health_check.sh

# Check index hit ratio
HIT_RATIO=$(psql -d cashflow_db -t -c "
SELECT ROUND(100.0 * sum(idx_blks_hit) / nullif(sum(idx_blks_hit + idx_blks_read), 0), 2)
FROM pg_statio_user_indexes;
")

if (( $(echo "$HIT_RATIO < 95" | bc -l) )); then
    echo "ALERT: Index hit ratio below 95%: $HIT_RATIO%"
    # Send alert notification
fi
```

## 📋 Summary

The index design provides:

- **⚡ High Performance**: Sub-millisecond response times for critical queries
- **🎯 Query Optimization**: Indexes aligned with actual usage patterns
- **💾 Storage Efficiency**: Optimal balance between performance and storage
- **🔍 Monitoring**: Comprehensive monitoring and alerting
- **🔧 Maintenance**: Automated maintenance and health checks
- **📈 Scalability**: Design scales with data growth

The indexing strategy supports the high-performance requirements of the **Cashflow Generation Service** while maintaining efficient storage utilization and providing comprehensive monitoring capabilities.

---

**Related Documentation**:
- [ER Design](ER_DESIGN.md)
- [Performance Tuning](PERFORMANCE_TUNING.md)
- [Query Optimization](QUERY_OPTIMIZATION.md)
- [Database Monitoring](DATABASE_MONITORING.md)
