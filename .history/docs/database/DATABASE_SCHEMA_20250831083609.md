# 🗄️ Database Schema Overview

## Overview

This document provides a comprehensive overview of the Cashflow Generation Service database schema, including table definitions, constraints, relationships, and performance considerations. The schema is designed for **high-performance cashflow processing**, **thread partitioning**, and **Actor pattern** implementation.

## 📊 Schema Architecture

### Core Design Principles

1. **🏗️ Domain-Driven Design**: Schema reflects business domain boundaries
2. **⚡ Performance First**: Optimized for high-throughput operations
3. **🔗 Referential Integrity**: Strong consistency within aggregate boundaries
4. **📈 Scalability**: Designed for horizontal and vertical scaling
5. **🛡️ Data Security**: Built-in security and audit capabilities

## 🗃️ Table Definitions

### 1. Core Business Tables

#### **cashflows** - Primary Entity
```sql
CREATE TABLE cashflows (
    -- Primary Key
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    
    -- Business Identifiers
    contract_id UUID NOT NULL,
    leg_id UUID NOT NULL,
    security_id VARCHAR(50) NOT NULL,
    
    -- Classification
    calculation_type VARCHAR(50) NOT NULL, -- INTEREST, EQUITY
    cashflow_type VARCHAR(50) NOT NULL,    -- INTEREST, DIVIDEND, PERFORMANCE, FEES
    status VARCHAR(50) NOT NULL,           -- ACCRUED, REALIZED_DEFERRED, etc.
    
    -- Financial Data
    amount DECIMAL(19,6) NOT NULL,
    currency CHAR(3) NOT NULL,
    
    -- Dates
    calculation_date DATE NOT NULL,
    value_date DATE,
    settlement_date DATE,
    
    -- Deferral Management
    deferral_date DATE,
    deferral_reason TEXT,
    deferral_period_days INTEGER,
    expected_realization_date DATE,
    
    -- Additional Data
    notes TEXT,
    
    -- Audit Fields
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100) NOT NULL,
    updated_by VARCHAR(100) NOT NULL,
    
    -- Constraints
    CONSTRAINT chk_cashflows_amount CHECK (amount != 0),
    CONSTRAINT chk_cashflows_currency CHECK (currency ~ '^[A-Z]{3}$'),
    CONSTRAINT chk_cashflows_dates CHECK (
        (value_date IS NULL OR value_date >= calculation_date) AND
        (settlement_date IS NULL OR settlement_date >= calculation_date) AND
        (deferral_date IS NULL OR deferral_date >= calculation_date)
    )
);
```

**Key Features**:
- **UUID Primary Key**: Globally unique identifiers
- **Composite Business Logic**: Thread partitioning support via `(contract_id, security_id, calculation_type)`
- **Flexible Dates**: Supports complex settlement scenarios
- **Check Constraints**: Data validation at database level

#### **daily_accruals** - Time Series Data
```sql
CREATE TABLE daily_accruals (
    -- Primary Key
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    
    -- Business Identifiers
    contract_id UUID NOT NULL,
    security_id VARCHAR(50) NOT NULL,
    
    -- Time Series
    accrual_date DATE NOT NULL,
    accrual_type VARCHAR(50) NOT NULL, -- INTEREST, DIVIDEND, PERFORMANCE
    
    -- Financial Data
    accrual_amount DECIMAL(19,6) NOT NULL,
    currency CHAR(3) NOT NULL,
    
    -- Calculation Details
    calculation_basis VARCHAR(50),      -- ACT/365, 30/360, etc.
    interest_rate DECIMAL(10,6),        -- For interest accruals
    notional_amount DECIMAL(19,6),      -- Base amount for calculation
    day_count_fraction DECIMAL(15,10),  -- Precise day count calculation
    
    -- Audit Fields
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100) NOT NULL,
    updated_by VARCHAR(100) NOT NULL,
    
    -- Constraints
    CONSTRAINT chk_daily_accruals_amount CHECK (accrual_amount != 0),
    CONSTRAINT chk_daily_accruals_rate CHECK (
        interest_rate IS NULL OR (interest_rate >= -1.0 AND interest_rate <= 1.0)
    ),
    CONSTRAINT chk_daily_accruals_fraction CHECK (
        day_count_fraction IS NULL OR (day_count_fraction > 0 AND day_count_fraction <= 1)
    )
);
```

**Key Features**:
- **Time Series Optimization**: Designed for efficient time-based queries
- **Calculation Support**: Includes all data needed for accrual calculations
- **Precision**: High-precision decimal fields for financial calculations

#### **unrealized_pnl** - Mark-to-Market Data
```sql
CREATE TABLE unrealized_pnl (
    -- Primary Key
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    
    -- Business Identifiers
    contract_id UUID NOT NULL,
    security_id VARCHAR(50) NOT NULL,
    
    -- Valuation Data
    valuation_date DATE NOT NULL,
    unrealized_amount DECIMAL(19,6) NOT NULL,
    currency CHAR(3) NOT NULL,
    
    -- Market Data
    market_value DECIMAL(19,6),
    book_value DECIMAL(19,6),
    fx_rate DECIMAL(15,10),
    price_per_share DECIMAL(15,6),
    shares_outstanding DECIMAL(19,6),
    
    -- Audit Fields
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100) NOT NULL,
    updated_by VARCHAR(100) NOT NULL,
    
    -- Constraints
    CONSTRAINT chk_unrealized_pnl_values CHECK (
        market_value IS NULL OR market_value >= 0
    ),
    CONSTRAINT chk_unrealized_pnl_fx CHECK (
        fx_rate IS NULL OR fx_rate > 0
    ),
    CONSTRAINT chk_unrealized_pnl_price CHECK (
        price_per_share IS NULL OR price_per_share >= 0
    )
);
```

### 2. Supporting Tables

#### **contracts** - Contract Master Data
```sql
CREATE TABLE contracts (
    -- Primary Key
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    
    -- Business Identifiers
    contract_number VARCHAR(50) NOT NULL UNIQUE,
    contract_type VARCHAR(50) NOT NULL,
    
    -- Contract Lifecycle
    trade_date DATE NOT NULL,
    effective_date DATE NOT NULL,
    maturity_date DATE,
    
    -- Financial Terms
    notional_amount DECIMAL(19,6) NOT NULL,
    notional_currency CHAR(3) NOT NULL,
    
    -- Status
    status VARCHAR(50) NOT NULL DEFAULT 'ACTIVE',
    
    -- Audit Fields
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100) NOT NULL,
    updated_by VARCHAR(100) NOT NULL,
    
    -- Constraints
    CONSTRAINT chk_contracts_dates CHECK (
        effective_date >= trade_date AND
        (maturity_date IS NULL OR maturity_date > effective_date)
    ),
    CONSTRAINT chk_contracts_notional CHECK (notional_amount > 0)
);
```

#### **contract_legs** - Contract Structure
```sql
CREATE TABLE contract_legs (
    -- Primary Key
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    
    -- Foreign Key
    contract_id UUID NOT NULL,
    
    -- Leg Details
    leg_type VARCHAR(20) NOT NULL,      -- EQUITY, INTEREST
    leg_number INTEGER NOT NULL,
    
    -- Financial Terms
    notional_amount DECIMAL(19,6) NOT NULL,
    notional_currency CHAR(3) NOT NULL,
    direction VARCHAR(10) NOT NULL,     -- PAY, RECEIVE
    
    -- Audit Fields
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    
    -- Constraints
    CONSTRAINT fk_contract_legs_contract FOREIGN KEY (contract_id) 
        REFERENCES contracts(id) ON DELETE CASCADE,
    CONSTRAINT chk_contract_legs_direction CHECK (direction IN ('PAY', 'RECEIVE')),
    CONSTRAINT uk_contract_legs_number UNIQUE (contract_id, leg_number)
);
```

#### **leg_underliers** - Underlying Securities
```sql
CREATE TABLE leg_underliers (
    -- Primary Key
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    
    -- Foreign Key
    leg_id UUID NOT NULL,
    
    -- Security Details
    security_id VARCHAR(50) NOT NULL,
    security_type VARCHAR(50) NOT NULL, -- SINGLE_STOCK, INDEX, BASKET
    
    -- Position Details
    quantity DECIMAL(19,6) NOT NULL,
    weight DECIMAL(5,4),                -- For basket components
    
    -- Audit Fields
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    
    -- Constraints
    CONSTRAINT fk_leg_underliers_leg FOREIGN KEY (leg_id) 
        REFERENCES contract_legs(id) ON DELETE CASCADE,
    CONSTRAINT chk_leg_underliers_weight CHECK (
        weight IS NULL OR (weight >= 0 AND weight <= 1)
    )
);
```

### 3. Audit & History Tables

#### **cashflow_status_history** - State Audit Trail
```sql
CREATE TABLE cashflow_status_history (
    -- Primary Key
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    
    -- Foreign Key
    cashflow_id UUID NOT NULL,
    
    -- State Transition
    from_status VARCHAR(50) NOT NULL,
    to_status VARCHAR(50) NOT NULL,
    transition_reason TEXT,
    
    -- Audit Data
    transition_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    transitioned_by VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    
    -- Constraints
    CONSTRAINT fk_cashflow_status_history_cashflow FOREIGN KEY (cashflow_id) 
        REFERENCES cashflows(id) ON DELETE CASCADE,
    CONSTRAINT chk_status_history_transition CHECK (from_status != to_status)
);
```

#### **contract_parties** - Counterparty Information
```sql
CREATE TABLE contract_parties (
    -- Primary Key
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    
    -- Foreign Key
    contract_id UUID NOT NULL,
    
    -- Party Details
    party_id VARCHAR(50) NOT NULL,
    party_role VARCHAR(50) NOT NULL,    -- COUNTERPARTY, CLEARING_HOUSE, etc.
    party_name VARCHAR(200) NOT NULL,
    
    -- Audit Fields
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    
    -- Constraints
    CONSTRAINT fk_contract_parties_contract FOREIGN KEY (contract_id) 
        REFERENCES contracts(id) ON DELETE CASCADE,
    CONSTRAINT uk_contract_parties_role UNIQUE (contract_id, party_role)
);
```

## 📊 Index Strategy Summary

### Critical Performance Indexes

```sql
-- Thread Partitioning (MOST CRITICAL)
CREATE INDEX idx_cashflows_partition_key ON cashflows 
USING btree (contract_id, security_id, calculation_type)
INCLUDE (id, status, amount, calculation_date);

-- Actor Mailbox Processing
CREATE INDEX idx_cashflows_mailbox ON cashflows 
USING btree (status, created_at)
WHERE status IN ('ACCRUED', 'REALIZED_DEFERRED', 'REALIZED_UNSETTLED')
INCLUDE (id, contract_id, security_id, calculation_type);

-- Settlement Processing
CREATE INDEX idx_cashflows_settlement ON cashflows 
USING btree (settlement_date, status)
WHERE settlement_date IS NOT NULL AND status = 'REALIZED_UNSETTLED'
INCLUDE (id, contract_id, amount, currency);

-- Time Series Queries
CREATE INDEX idx_daily_accruals_timeseries ON daily_accruals 
USING btree (contract_id, security_id, accrual_date)
INCLUDE (accrual_amount, currency, accrual_type);

-- Market Data Queries
CREATE INDEX idx_unrealized_pnl_timeseries ON unrealized_pnl 
USING btree (contract_id, security_id, valuation_date DESC)
INCLUDE (unrealized_amount, market_value, book_value);
```

## 🔗 Relationship Summary

### Primary Relationships
- **contracts** ← **contract_legs** (1:N) - Contract structure
- **contract_legs** ← **leg_underliers** (1:N) - Underlying securities
- **contracts** ← **cashflows** (1:N) - Generated cashflows
- **contract_legs** ← **cashflows** (1:N) - Leg-specific cashflows

### Supporting Relationships
- **cashflows** ← **cashflow_status_history** (1:N) - Audit trail
- **contracts** ← **contract_parties** (1:N) - Counterparty data
- **contracts** ← **daily_accruals** (1:N) - Time series data
- **contracts** ← **unrealized_pnl** (1:N) - Mark-to-market data

## 🎯 Enum Definitions

### CashflowStatus
```sql
CREATE TYPE cashflow_status AS ENUM (
    'ACCRUED',              -- Initial state with daily accrual tracking
    'REALIZED_DEFERRED',    -- Deferred due to business rules
    'REALIZED_UNSETTLED',   -- Realized but not yet settled
    'REALIZED_SETTLED',     -- Fully settled and confirmed
    'CANCELLED',            -- Cancelled cashflow
    'ADJUSTED'              -- Adjusted due to corrections
);
```

### CalculationType
```sql
CREATE TYPE calculation_type AS ENUM (
    'INTEREST',             -- Interest rate calculations
    'EQUITY'                -- Equity performance calculations
);
```

### CashflowType
```sql
CREATE TYPE cashflow_type AS ENUM (
    'INTEREST',             -- Interest rate accruals and payments
    'DIVIDEND',             -- Dividend entitlements and payments
    'PERFORMANCE',          -- Equity return and unrealized P&L
    'FEES'                  -- Management fees and charges
);
```

### LegType
```sql
CREATE TYPE leg_type AS ENUM (
    'EQUITY',               -- Equity leg with underlier exposure
    'INTEREST'              -- Interest rate leg with floating rate
);
```

## 🛡️ Security & Constraints

### Row-Level Security (RLS)
```sql
-- Enable RLS on sensitive tables
ALTER TABLE contracts ENABLE ROW LEVEL SECURITY;
ALTER TABLE cashflows ENABLE ROW LEVEL SECURITY;

-- User-based access policies
CREATE POLICY user_contracts ON contracts
FOR ALL TO cashflow_user
USING (created_by = current_user);

CREATE POLICY user_cashflows ON cashflows
FOR ALL TO cashflow_user
USING (created_by = current_user);
```

### Data Validation
```sql
-- Comprehensive check constraints
ALTER TABLE cashflows ADD CONSTRAINT chk_cashflows_business_rules CHECK (
    -- Ensure settlement date is not before calculation date
    (settlement_date IS NULL OR settlement_date >= calculation_date) AND
    -- Ensure deferral logic is consistent
    (deferral_date IS NULL OR (
        deferral_reason IS NOT NULL AND 
        deferral_period_days IS NOT NULL AND
        expected_realization_date IS NOT NULL
    )) AND
    -- Ensure currency is valid ISO code
    currency ~ '^[A-Z]{3}$'
);
```

## 📈 Performance Characteristics

### Query Performance Targets
| Query Type | Target Response Time | Concurrent Users |
|------------|---------------------|------------------|
| Thread Partition Lookup | < 1ms | 1,000 |
| Actor Mailbox Query | < 2ms | 500 |
| Settlement Batch | < 10ms | 50 |
| Reporting Aggregation | < 50ms | 100 |

### Storage Estimates
| Table | 1M Records | 10M Records | 100M Records |
|-------|------------|-------------|--------------|
| **cashflows** | ~200MB | ~2GB | ~20GB |
| **daily_accruals** | ~150MB | ~1.5GB | ~15GB |
| **unrealized_pnl** | ~100MB | ~1GB | ~10GB |
| **Total with Indexes** | ~700MB | ~7GB | ~70GB |

## 🔧 Maintenance Procedures

### Daily Maintenance
```sql
-- Update table statistics
ANALYZE cashflows;
ANALYZE daily_accruals;
ANALYZE unrealized_pnl;

-- Check for fragmentation
SELECT 
    schemaname, tablename,
    pg_size_pretty(pg_total_relation_size(schemaname||'.'||tablename)) as size,
    n_dead_tup, n_live_tup,
    CASE WHEN n_live_tup > 0 
         THEN ROUND(n_dead_tup::numeric / n_live_tup::numeric, 4) 
         ELSE 0 
    END as dead_ratio
FROM pg_stat_user_tables 
WHERE schemaname = 'public'
ORDER BY dead_ratio DESC;
```

### Weekly Maintenance
```sql
-- Reindex heavily used indexes
REINDEX INDEX CONCURRENTLY idx_cashflows_partition_key;
REINDEX INDEX CONCURRENTLY idx_cashflows_mailbox;
REINDEX INDEX CONCURRENTLY idx_cashflows_settlement;

-- Vacuum analyze
VACUUM ANALYZE cashflows;
VACUUM ANALYZE daily_accruals;
VACUUM ANALYZE unrealized_pnl;
```

### Monthly Maintenance
```sql
-- Archive old data (older than 2 years)
BEGIN;
CREATE TABLE IF NOT EXISTS cashflows_archive (LIKE cashflows INCLUDING ALL);
INSERT INTO cashflows_archive 
SELECT * FROM cashflows 
WHERE calculation_date < CURRENT_DATE - INTERVAL '2 years';
DELETE FROM cashflows 
WHERE calculation_date < CURRENT_DATE - INTERVAL '2 years';
COMMIT;

-- Update index statistics
ALTER INDEX idx_cashflows_partition_key SET (n_distinct = -0.1);
ALTER INDEX idx_cashflows_mailbox SET (n_distinct = 0.5);
```

## 📊 Monitoring Queries

### Health Check Queries
```sql
-- Database health dashboard
WITH db_stats AS (
    SELECT 
        'total_size' as metric,
        pg_size_pretty(pg_database_size(current_database())) as value
    UNION ALL
    SELECT 
        'index_hit_ratio' as metric,
        ROUND(100.0 * sum(idx_blks_hit) / nullif(sum(idx_blks_hit + idx_blks_read), 0), 2)::text || '%' as value
    FROM pg_statio_user_indexes
    UNION ALL
    SELECT 
        'active_connections' as metric,
        COUNT(*)::text as value
    FROM pg_stat_activity 
    WHERE state = 'active'
)
SELECT * FROM db_stats;
```

### Performance Monitoring
```sql
-- Query performance analysis
SELECT 
    substr(query, 1, 100) as query_snippet,
    calls,
    total_time,
    mean_time,
    ROUND(100.0 * total_time / sum(total_time) OVER(), 2) as pct_total_time
FROM pg_stat_statements 
WHERE query LIKE '%cashflows%'
ORDER BY total_time DESC
LIMIT 10;
```

## 📋 Summary

The database schema provides:

- **🏗️ Robust Architecture**: Supports complex financial workflows
- **⚡ High Performance**: Optimized indexes for sub-millisecond queries
- **🔗 Data Integrity**: Comprehensive constraints and relationships
- **📈 Scalability**: Designed for horizontal and vertical scaling
- **🛡️ Security**: Row-level security and data encryption
- **🔧 Maintainability**: Built-in monitoring and maintenance procedures

The schema successfully balances **ACID compliance** with **high-performance requirements**, enabling the Cashflow Generation Service to process large volumes of financial data while maintaining consistency and integrity.

---

**Related Documentation**:
- [ER Design Details](ER_DESIGN.md)
- [Index Performance Analysis](INDEX_DESIGN.md)
- [Domain Models](../cashflow/data/domain-models.md)
- [Performance Tuning Guide](PERFORMANCE_TUNING.md)
