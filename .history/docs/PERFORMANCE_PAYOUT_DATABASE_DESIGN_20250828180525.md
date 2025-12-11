# Performance Payout PostgreSQL Database Design

## Overview

This document designs a comprehensive PostgreSQL database schema for the Performance Payout structure that aligns with FINOS CDM principles while following relational database best practices. The design supports equity swaps with complex underlier structures, return terms, and cashflow generation.

## Database Schema Design

### 1. **Core Tables Structure**

#### **1.1 Performance Payout Master Table**

```sql
-- Main performance payout table
CREATE TABLE performance_payout (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    contract_id UUID NOT NULL,
    leg_id UUID NOT NULL,
    payout_type VARCHAR(50) NOT NULL DEFAULT 'PERFORMANCE_PAYOUT',
    
    -- CDM compliance fields
    cdm_entity_type VARCHAR(100) NOT NULL DEFAULT 'PerformancePayout',
    cdm_global_key VARCHAR(255) UNIQUE,
    
    -- Business fields
    payout_name VARCHAR(255),
    payout_description TEXT,
    is_active BOOLEAN DEFAULT TRUE,
    
    -- Audit fields
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    version INTEGER DEFAULT 1,
    
    -- Constraints
    CONSTRAINT fk_performance_payout_contract 
        FOREIGN KEY (contract_id) REFERENCES contracts(id),
    CONSTRAINT fk_performance_payout_leg 
        FOREIGN KEY (leg_id) REFERENCES contract_legs(id),
    CONSTRAINT uk_performance_payout_contract_leg 
        UNIQUE (contract_id, leg_id)
);

-- Indexes for performance
CREATE INDEX idx_performance_payout_contract_id ON performance_payout(contract_id);
CREATE INDEX idx_performance_payout_leg_id ON performance_payout(leg_id);
CREATE INDEX idx_performance_payout_cdm_global_key ON performance_payout(cdm_global_key);
CREATE INDEX idx_performance_payout_active ON performance_payout(is_active);
```

#### **1.2 Underlier Table**

```sql
-- Underlier table for equity references
CREATE TABLE underliers (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    performance_payout_id UUID NOT NULL,
    
    -- CDM compliance
    cdm_entity_type VARCHAR(100) NOT NULL DEFAULT 'Underlier',
    cdm_global_key VARCHAR(255) UNIQUE,
    
    -- Underlier type and reference
    underlier_type VARCHAR(50) NOT NULL, -- 'SINGLE_STOCK', 'INDEX', 'BASKET'
    underlier_reference VARCHAR(255) NOT NULL, -- ISIN, CUSIP, Index code, etc.
    underlier_name VARCHAR(255),
    underlier_currency VARCHAR(3),
    
    -- Business metadata
    exchange VARCHAR(100),
    sector VARCHAR(100),
    country VARCHAR(100),
    
    -- Audit fields
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    
    -- Constraints
    CONSTRAINT fk_underliers_performance_payout 
        FOREIGN KEY (performance_payout_id) REFERENCES performance_payout(id),
    CONSTRAINT uk_underlier_reference UNIQUE (underlier_reference)
);

-- Indexes
CREATE INDEX idx_underliers_performance_payout_id ON underliers(performance_payout_id);
CREATE INDEX idx_underliers_type ON underliers(underlier_type);
CREATE INDEX idx_underliers_reference ON underliers(underlier_reference);
```

#### **1.3 Basket Constituents Table**

```sql
-- For basket underliers, stores individual components
CREATE TABLE basket_constituents (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    basket_underlier_id UUID NOT NULL,
    
    -- Constituent details
    constituent_underlier_id UUID NOT NULL,
    weight_type VARCHAR(50) NOT NULL, -- 'PERCENTAGE', 'UNITS', 'NOTIONAL'
    weight_value DECIMAL(19,6) NOT NULL,
    weight_currency VARCHAR(3),
    
    -- Business fields
    rebalancing_frequency VARCHAR(50), -- 'DAILY', 'WEEKLY', 'MONTHLY', 'QUARTERLY'
    last_rebalancing_date DATE,
    next_rebalancing_date DATE,
    
    -- Audit fields
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    
    -- Constraints
    CONSTRAINT fk_basket_constituents_basket_underlier 
        FOREIGN KEY (basket_underlier_id) REFERENCES underliers(id),
    CONSTRAINT fk_basket_constituents_constituent 
        FOREIGN KEY (constituent_underlier_id) REFERENCES underliers(id),
    CONSTRAINT uk_basket_constituent UNIQUE (basket_underlier_id, constituent_underlier_id)
);

-- Indexes
CREATE INDEX idx_basket_constituents_basket_id ON basket_constituents(basket_underlier_id);
CREATE INDEX idx_basket_constituents_constituent_id ON basket_constituents(constituent_underlier_id);
```

#### **1.4 Return Terms Table**

```sql
-- Return terms configuration
CREATE TABLE return_terms (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    performance_payout_id UUID NOT NULL,
    
    -- CDM compliance
    cdm_entity_type VARCHAR(100) NOT NULL DEFAULT 'ReturnTerms',
    cdm_global_key VARCHAR(255) UNIQUE,
    
    -- Return type configuration
    return_type VARCHAR(50) NOT NULL, -- 'PRICE', 'DIVIDEND', 'VARIANCE', 'VOLATILITY', 'CORRELATION'
    return_subtype VARCHAR(50), -- 'TOTAL', 'PRICE_ONLY', 'DIVIDEND_ONLY'
    
    -- Business fields
    is_cumulative BOOLEAN DEFAULT FALSE,
    performance_calculation_method VARCHAR(100),
    
    -- Audit fields
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    
    -- Constraints
    CONSTRAINT fk_return_terms_performance_payout 
        FOREIGN KEY (performance_payout_id) REFERENCES performance_payout(id),
    CONSTRAINT uk_return_terms_payout_type UNIQUE (performance_payout_id, return_type)
);

-- Indexes
CREATE INDEX idx_return_terms_performance_payout_id ON return_terms(performance_payout_id);
CREATE INDEX idx_return_terms_type ON return_terms(return_type);
```

#### **1.5 Price Return Terms Table**

```sql
-- Price return specific terms
CREATE TABLE price_return_terms (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    return_terms_id UUID NOT NULL,
    
    -- CDM compliance
    cdm_entity_type VARCHAR(100) NOT NULL DEFAULT 'PriceReturnTerms',
    cdm_global_key VARCHAR(255) UNIQUE,
    
    -- Price return configuration
    return_type VARCHAR(50) NOT NULL, -- 'PRICE', 'TOTAL'
    conversion_factor DECIMAL(19,6) DEFAULT 1.0,
    
    -- Performance calculation
    performance_calculation_method VARCHAR(100),
    initial_price_reference VARCHAR(255),
    final_price_reference VARCHAR(255),
    
    -- Business fields
    price_adjustment_method VARCHAR(100), -- 'DIVIDEND_ADJUSTED', 'SPLIT_ADJUSTED'
    
    -- Audit fields
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    
    -- Constraints
    CONSTRAINT fk_price_return_terms_return_terms 
        FOREIGN KEY (return_terms_id) REFERENCES return_terms(id)
);

-- Indexes
CREATE INDEX idx_price_return_terms_return_terms_id ON price_return_terms(return_terms_id);
```

#### **1.6 Dividend Return Terms Table**

```sql
-- Dividend return specific terms
CREATE TABLE dividend_return_terms (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    return_terms_id UUID NOT NULL,
    
    -- CDM compliance
    cdm_entity_type VARCHAR(100) NOT NULL DEFAULT 'DividendReturnTerms',
    cdm_global_key VARCHAR(255) UNIQUE,
    
    -- Dividend configuration
    dividend_payout_ratio DECIMAL(5,4) DEFAULT 1.0, -- Percentage of dividend to pay
    dividend_reinvestment BOOLEAN DEFAULT FALSE,
    dividend_entitlement VARCHAR(50), -- 'EX_DATE', 'RECORD_DATE', 'PAYMENT_DATE'
    
    -- Dividend amount configuration
    dividend_amount_type VARCHAR(50), -- 'PERIOD', 'CUMULATIVE'
    first_period VARCHAR(50), -- 'FIRST', 'SECOND'
    
    -- Extraordinary dividends
    extraordinary_dividends_party VARCHAR(100),
    excess_dividend_amount_type VARCHAR(50),
    
    -- Currency and treatment
    dividend_currency VARCHAR(3),
    non_cash_dividend_treatment VARCHAR(50),
    dividend_composition VARCHAR(50),
    
    -- Business fields
    special_dividends_handling VARCHAR(100),
    material_dividend_threshold DECIMAL(19,6),
    
    -- Audit fields
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    
    -- Constraints
    CONSTRAINT fk_dividend_return_terms_return_terms 
        FOREIGN KEY (return_terms_id) REFERENCES return_terms(id)
);

-- Indexes
CREATE INDEX idx_dividend_return_terms_return_terms_id ON dividend_return_terms(return_terms_id);
```

#### **1.7 Variance/Volatility Return Terms Table**

```sql
-- Variance and volatility return terms
CREATE TABLE variance_volatility_terms (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    return_terms_id UUID NOT NULL,
    
    -- CDM compliance
    cdm_entity_type VARCHAR(100) NOT NULL DEFAULT 'VarianceReturnTerms',
    cdm_global_key VARCHAR(255) UNIQUE,
    
    -- Variance/volatility configuration
    variance_strike_price DECIMAL(19,6),
    volatility_strike_price DECIMAL(19,6),
    
    -- Cap/floor configuration
    variance_cap_price DECIMAL(19,6),
    variance_floor_price DECIMAL(19,6),
    volatility_cap_price DECIMAL(19,6),
    volatility_floor_price DECIMAL(19,6),
    
    -- Vega notional
    vega_notional_amount DECIMAL(19,6),
    vega_notional_currency VARCHAR(3),
    
    -- Calculation parameters
    annualization_factor INTEGER DEFAULT 252,
    expected_trading_days INTEGER,
    initial_level DECIMAL(19,6),
    mean_adjustment BOOLEAN DEFAULT FALSE,
    
    -- Dividend adjustments
    share_price_dividend_adjustment BOOLEAN DEFAULT FALSE,
    dividend_applicability VARCHAR(50),
    
    -- Business fields
    exchange_traded_contract_reference VARCHAR(255),
    
    -- Audit fields
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    
    -- Constraints
    CONSTRAINT fk_variance_volatility_terms_return_terms 
        FOREIGN KEY (return_terms_id) REFERENCES return_terms(id)
);

-- Indexes
CREATE INDEX idx_variance_volatility_terms_return_terms_id ON variance_volatility_terms(return_terms_id);
```

#### **1.8 Valuation Schedule Table**

```sql
-- Valuation dates and schedule
CREATE TABLE valuation_schedules (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    performance_payout_id UUID NOT NULL,
    
    -- CDM compliance
    cdm_entity_type VARCHAR(100) NOT NULL DEFAULT 'ValuationDates',
    cdm_global_key VARCHAR(255) UNIQUE,
    
    -- Schedule configuration
    schedule_type VARCHAR(50) NOT NULL, -- 'PARAMETRIC', 'EXPLICIT'
    valuation_frequency VARCHAR(50), -- 'DAILY', 'WEEKLY', 'MONTHLY', 'QUARTERLY'
    
    -- Date configuration
    first_valuation_date DATE,
    last_valuation_date DATE,
    valuation_time TIME,
    valuation_timezone VARCHAR(50),
    
    -- Business day adjustments
    business_day_convention VARCHAR(50), -- 'FOLLOWING', 'PRECEDING', 'MODIFIED_FOLLOWING'
    business_centers TEXT[], -- Array of business center codes
    
    -- Audit fields
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    
    -- Constraints
    CONSTRAINT fk_valuation_schedules_performance_payout 
        FOREIGN KEY (performance_payout_id) REFERENCES performance_payout(id)
);

-- Indexes
CREATE INDEX idx_valuation_schedules_performance_payout_id ON valuation_schedules(performance_payout_id);
CREATE INDEX idx_valuation_schedules_type ON valuation_schedules(schedule_type);
```

#### **1.9 Payment Schedule Table**

```sql
-- Payment dates and schedule
CREATE TABLE payment_schedules (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    performance_payout_id UUID NOT NULL,
    
    -- CDM compliance
    cdm_entity_type VARCHAR(100) NOT NULL DEFAULT 'PaymentDates',
    cdm_global_key VARCHAR(255) UNIQUE,
    
    -- Schedule configuration
    schedule_type VARCHAR(50) NOT NULL, -- 'PARAMETRIC', 'EXPLICIT'
    payment_frequency VARCHAR(50), -- 'DAILY', 'WEEKLY', 'MONTHLY', 'QUARTERLY'
    
    -- Date configuration
    first_payment_date DATE,
    last_payment_date DATE,
    payment_delay_days INTEGER DEFAULT 0,
    
    -- Business day adjustments
    business_day_convention VARCHAR(50),
    business_centers TEXT[],
    
    -- Payment relative configuration
    pay_relative_to VARCHAR(50), -- 'VALUATION_DATE', 'CALCULATION_PERIOD'
    
    -- Audit fields
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    
    -- Constraints
    CONSTRAINT fk_payment_schedules_performance_payout 
        FOREIGN KEY (performance_payout_id) REFERENCES performance_payout(id)
);

-- Indexes
CREATE INDEX idx_payment_schedules_performance_payout_id ON payment_schedules(performance_payout_id);
CREATE INDEX idx_payment_schedules_type ON payment_schedules(schedule_type);
```

#### **1.10 FX Features Table**

```sql
-- FX features for quanto and composite structures
CREATE TABLE fx_features (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    performance_payout_id UUID NOT NULL,
    
    -- CDM compliance
    cdm_entity_type VARCHAR(100) NOT NULL DEFAULT 'FxFeature',
    cdm_global_key VARCHAR(255) UNIQUE,
    
    -- FX configuration
    reference_currency VARCHAR(3) NOT NULL,
    fx_feature_type VARCHAR(50) NOT NULL, -- 'QUANTO', 'COMPOSITE', 'CROSS_CURRENCY'
    
    -- Quanto configuration
    quanto_fx_rate DECIMAL(19,6),
    quanto_fx_rate_source VARCHAR(255),
    quanto_fixing_time TIME,
    quanto_fixing_timezone VARCHAR(50),
    
    -- Composite configuration
    composite_determination_method VARCHAR(100),
    composite_relative_date_offset INTEGER,
    composite_fx_spot_rate_source VARCHAR(255),
    
    -- Cross-currency configuration
    cross_currency_fx_rate DECIMAL(19,6),
    cross_currency_fx_rate_source VARCHAR(255),
    
    -- Audit fields
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    
    -- Constraints
    CONSTRAINT fk_fx_features_performance_payout 
        FOREIGN KEY (performance_payout_id) REFERENCES performance_payout(id)
);

-- Indexes
CREATE INDEX idx_fx_features_performance_payout_id ON fx_features(performance_payout_id);
CREATE INDEX idx_fx_features_type ON fx_features(fx_feature_type);
```

### 2. **Supporting Tables**

#### **2.1 Contracts Table**

```sql
-- Contract master table
CREATE TABLE contracts (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    contract_reference VARCHAR(255) UNIQUE NOT NULL,
    contract_type VARCHAR(50) NOT NULL, -- 'EQUITY_SWAP', 'TOTAL_RETURN_SWAP'
    
    -- CDM compliance
    cdm_entity_type VARCHAR(100) NOT NULL DEFAULT 'Contract',
    cdm_global_key VARCHAR(255) UNIQUE,
    
    -- Business fields
    contract_status VARCHAR(50) DEFAULT 'ACTIVE',
    effective_date DATE NOT NULL,
    termination_date DATE,
    
    -- Parties
    party1_id UUID,
    party2_id UUID,
    
    -- Audit fields
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    
    -- Constraints
    CONSTRAINT fk_contracts_party1 FOREIGN KEY (party1_id) REFERENCES parties(id),
    CONSTRAINT fk_contracts_party2 FOREIGN KEY (party2_id) REFERENCES parties(id)
);

-- Indexes
CREATE INDEX idx_contracts_reference ON contracts(contract_reference);
CREATE INDEX idx_contracts_type ON contracts(contract_type);
CREATE INDEX idx_contracts_status ON contracts(contract_status);
```

#### **2.2 Contract Legs Table**

```sql
-- Contract legs table
CREATE TABLE contract_legs (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    contract_id UUID NOT NULL,
    leg_number INTEGER NOT NULL,
    leg_type VARCHAR(50) NOT NULL, -- 'EQUITY_LEG', 'FUNDING_LEG'
    
    -- CDM compliance
    cdm_entity_type VARCHAR(100) NOT NULL DEFAULT 'ContractLeg',
    cdm_global_key VARCHAR(255) UNIQUE,
    
    -- Business fields
    leg_direction VARCHAR(10) NOT NULL, -- 'PAY', 'RECEIVE'
    notional_amount DECIMAL(19,6),
    notional_currency VARCHAR(3),
    
    -- Audit fields
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    
    -- Constraints
    CONSTRAINT fk_contract_legs_contract 
        FOREIGN KEY (contract_id) REFERENCES contracts(id),
    CONSTRAINT uk_contract_leg_number UNIQUE (contract_id, leg_number)
);

-- Indexes
CREATE INDEX idx_contract_legs_contract_id ON contract_legs(contract_id);
CREATE INDEX idx_contract_legs_type ON contract_legs(leg_type);
```

#### **2.3 Parties Table**

```sql
-- Parties table
CREATE TABLE parties (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    party_identifier VARCHAR(255) UNIQUE NOT NULL,
    party_name VARCHAR(255) NOT NULL,
    party_type VARCHAR(50), -- 'COUNTERPARTY', 'BROKER', 'CLEARING_HOUSE'
    
    -- CDM compliance
    cdm_entity_type VARCHAR(100) NOT NULL DEFAULT 'Party',
    cdm_global_key VARCHAR(255) UNIQUE,
    
    -- Business fields
    country VARCHAR(100),
    legal_entity_identifier VARCHAR(255),
    
    -- Audit fields
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100)
);

-- Indexes
CREATE INDEX idx_parties_identifier ON parties(party_identifier);
CREATE INDEX idx_parties_type ON parties(party_type);
```

### 3. **Data Access Layer**

#### **3.1 Repository Interface**

```java
@Repository
public interface PerformancePayoutRepository extends JpaRepository<PerformancePayout, UUID> {
    
    // Find by contract
    List<PerformancePayout> findByContractId(UUID contractId);
    
    // Find by leg
    List<PerformancePayout> findByLegId(UUID legId);
    
    // Find active payouts
    List<PerformancePayout> findByIsActiveTrue();
    
    // Find by CDM global key
    Optional<PerformancePayout> findByCdmGlobalKey(String cdmGlobalKey);
    
    // Find by underlier type
    @Query("SELECT pp FROM PerformancePayout pp " +
           "JOIN pp.underliers u " +
           "WHERE u.underlierType = :underlierType")
    List<PerformancePayout> findByUnderlierType(String underlierType);
    
    // Find by return type
    @Query("SELECT pp FROM PerformancePayout pp " +
           "JOIN pp.returnTerms rt " +
           "WHERE rt.returnType = :returnType")
    List<PerformancePayout> findByReturnType(String returnType);
}
```

#### **3.2 Service Layer**

```java
@Service
@Transactional
public class PerformancePayoutService {
    
    @Autowired
    private PerformancePayoutRepository payoutRepository;
    
    @Autowired
    private UnderlierRepository underlierRepository;
    
    @Autowired
    private ReturnTermsRepository returnTermsRepository;
    
    /**
     * Create a new performance payout
     */
    public PerformancePayout createPerformancePayout(PerformancePayoutCreateRequest request) {
        
        // Validate request
        validateCreateRequest(request);
        
        // Create performance payout
        PerformancePayout payout = new PerformancePayout();
        payout.setContractId(request.getContractId());
        payout.setLegId(request.getLegId());
        payout.setCdmGlobalKey(generateCdmGlobalKey());
        
        // Save payout
        payout = payoutRepository.save(payout);
        
        // Create underliers
        createUnderliers(payout.getId(), request.getUnderliers());
        
        // Create return terms
        createReturnTerms(payout.getId(), request.getReturnTerms());
        
        // Create schedules
        createSchedules(payout.getId(), request.getSchedules());
        
        return payout;
    }
    
    /**
     * Get performance payout with full details
     */
    public PerformancePayoutDetail getPerformancePayoutDetail(UUID payoutId) {
        PerformancePayout payout = payoutRepository.findById(payoutId)
            .orElseThrow(() -> new EntityNotFoundException("Performance payout not found"));
        
        return PerformancePayoutDetail.builder()
            .payout(payout)
            .underliers(underlierRepository.findByPerformancePayoutId(payoutId))
            .returnTerms(returnTermsRepository.findByPerformancePayoutId(payoutId))
            .valuationSchedule(valuationScheduleRepository.findByPerformancePayoutId(payoutId))
            .paymentSchedule(paymentScheduleRepository.findByPerformancePayoutId(payoutId))
            .fxFeatures(fxFeatureRepository.findByPerformancePayoutId(payoutId))
            .build();
    }
}
```

### 4. **Database Optimization**

#### **4.1 Partitioning Strategy**

```sql
-- Partition performance_payout by contract_id for large contracts
CREATE TABLE performance_payout_partitioned (
    LIKE performance_payout INCLUDING ALL
) PARTITION BY HASH (contract_id);

-- Create partitions
CREATE TABLE performance_payout_p0 PARTITION OF performance_payout_partitioned
    FOR VALUES WITH (modulus 4, remainder 0);
CREATE TABLE performance_payout_p1 PARTITION OF performance_payout_partitioned
    FOR VALUES WITH (modulus 4, remainder 1);
CREATE TABLE performance_payout_p2 PARTITION OF performance_payout_partitioned
    FOR VALUES WITH (modulus 4, remainder 2);
CREATE TABLE performance_payout_p3 PARTITION OF performance_payout_partitioned
    FOR VALUES WITH (modulus 4, remainder 3);
```

#### **4.2 Materialized Views**

```sql
-- Materialized view for performance payout summary
CREATE MATERIALIZED VIEW performance_payout_summary AS
SELECT 
    pp.contract_id,
    pp.leg_id,
    pp.payout_type,
    u.underlier_type,
    u.underlier_reference,
    rt.return_type,
    COUNT(*) as payout_count
FROM performance_payout pp
JOIN underliers u ON pp.id = u.performance_payout_id
JOIN return_terms rt ON pp.id = rt.performance_payout_id
WHERE pp.is_active = TRUE
GROUP BY pp.contract_id, pp.leg_id, pp.payout_type, u.underlier_type, u.underlier_reference, rt.return_type;

-- Enhanced materialized view for cashflow summary with payment status
CREATE MATERIALIZED VIEW cashflow_payment_summary AS
SELECT 
    c.contract_id,
    c.leg_id,
    c.cashflow_type,
    c.cashflow_subtype,
    c.cashflow_status,
    c.currency,
    COUNT(*) as cashflow_count,
    SUM(CASE WHEN c.cashflow_status = 'ACCRUED' THEN c.amount ELSE 0 END) as total_accrued_amount,
    SUM(CASE WHEN c.cashflow_status = 'REALIZED_UNSETTLED' THEN c.amount ELSE 0 END) as total_realized_unsettled_amount,
    SUM(CASE WHEN c.cashflow_status = 'REALIZED_SETTLED' THEN c.amount ELSE 0 END) as total_realized_settled_amount,
    AVG(c.amount) as average_cashflow_amount,
    MIN(c.payment_date) as earliest_payment_date,
    MAX(c.payment_date) as latest_payment_date
FROM cashflows c
GROUP BY c.contract_id, c.leg_id, c.cashflow_type, c.cashflow_subtype, c.cashflow_status, c.currency;

-- Materialized view for payment status summary
CREATE MATERIALIZED VIEW payment_status_summary AS
SELECT 
    p.payment_type,
    p.payment_method,
    p.payment_status,
    p.payment_currency,
    COUNT(*) as payment_count,
    SUM(p.payment_amount) as total_payment_amount,
    AVG(p.payment_amount) as average_payment_amount,
    MIN(p.payment_execution_date) as earliest_execution_date,
    MAX(p.payment_execution_date) as latest_execution_date
FROM payments p
GROUP BY p.payment_type, p.payment_method, p.payment_status, p.payment_currency;

-- Materialized view for netting summary
CREATE MATERIALIZED VIEW netting_summary AS
SELECT 
    ni.netting_type,
    ni.netting_status,
    ni.netting_currency,
    COUNT(*) as netting_count,
    SUM(ABS(ni.net_amount)) as total_netting_volume,
    AVG(ABS(ni.net_amount)) as average_netting_amount,
    COUNT(DISTINCT ni.party1_id) + COUNT(DISTINCT ni.party2_id) as unique_parties_count
FROM netting_instructions ni
GROUP BY ni.netting_type, ni.netting_status, ni.netting_currency;

-- Refresh all materialized views
REFRESH MATERIALIZED VIEW performance_payout_summary;
REFRESH MATERIALIZED VIEW cashflow_payment_summary;
REFRESH MATERIALIZED VIEW payment_status_summary;
REFRESH MATERIALIZED VIEW netting_summary;
```

#### **4.3 Indexing Strategy**

```sql
-- Composite indexes for common query patterns
CREATE INDEX idx_performance_payout_contract_leg_active 
ON performance_payout(contract_id, leg_id, is_active);

CREATE INDEX idx_underliers_payout_type_reference 
ON underliers(performance_payout_id, underlier_type, underlier_reference);

CREATE INDEX idx_return_terms_payout_type 
ON return_terms(performance_payout_id, return_type);

-- Partial indexes for active records
CREATE INDEX idx_performance_payout_active_contracts 
ON performance_payout(contract_id) WHERE is_active = TRUE;

-- GIN indexes for array fields
CREATE INDEX idx_valuation_schedules_business_centers 
ON valuation_schedules USING GIN (business_centers);

CREATE INDEX idx_payment_schedules_business_centers 
ON payment_schedules USING GIN (business_centers);
```

### 5. **Data Migration and Versioning**

#### **5.1 Schema Versioning**

```sql
-- Schema version tracking
CREATE TABLE schema_versions (
    id SERIAL PRIMARY KEY,
    version VARCHAR(50) NOT NULL,
    applied_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    description TEXT,
    script_name VARCHAR(255)
);

-- Insert current version
INSERT INTO schema_versions (version, description, script_name) 
VALUES ('1.0.0', 'Initial Performance Payout schema', '001_initial_schema.sql');
```

#### **5.2 Data Migration Scripts**

```sql
-- Example migration script
-- Migration: 002_add_correlation_terms.sql

-- Add correlation return terms table
CREATE TABLE correlation_return_terms (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    return_terms_id UUID NOT NULL,
    
    -- CDM compliance
    cdm_entity_type VARCHAR(100) NOT NULL DEFAULT 'CorrelationReturnTerms',
    cdm_global_key VARCHAR(255) UNIQUE,
    
    -- Correlation configuration
    correlation_strike DECIMAL(19,6),
    correlation_cap DECIMAL(19,6),
    correlation_floor DECIMAL(19,6),
    
    -- Calculation parameters
    correlation_period INTEGER, -- Days for correlation calculation
    correlation_method VARCHAR(100), -- 'PEARSON', 'SPEARMAN'
    
    -- Audit fields
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    
    -- Constraints
    CONSTRAINT fk_correlation_return_terms_return_terms 
        FOREIGN KEY (return_terms_id) REFERENCES return_terms(id)
);

-- Add indexes
CREATE INDEX idx_correlation_return_terms_return_terms_id 
ON correlation_return_terms(return_terms_id);

-- Update schema version
INSERT INTO schema_versions (version, description, script_name) 
VALUES ('1.1.0', 'Add correlation return terms', '002_add_correlation_terms.sql');
```

## Implementation Benefits

### 1. **CDM Compliance**
- All tables include CDM entity type and global key fields
- Supports CDM validation and lineage tracking
- Maintains referential integrity with CDM principles

### 2. **Relational Database Best Practices**
- Proper normalization to avoid data redundancy
- Comprehensive indexing strategy for performance
- Foreign key constraints for data integrity
- Audit fields for tracking changes

### 3. **Scalability and Performance**
- Partitioning strategy for large datasets
- Materialized views for common queries
- Optimized indexes for typical access patterns
- Efficient query patterns

### 4. **Business Flexibility**
- Supports complex equity swap structures
- Handles multiple underlier types
- Extensible for future product types
- Comprehensive audit trail

## Next Steps

1. **Create Database Schema**: Implement the PostgreSQL schema
2. **Build Data Access Layer**: Create repositories and services
3. **Add Validation**: Implement CDM compliance validation
4. **Performance Testing**: Test with realistic data volumes
5. **Migration Strategy**: Plan data migration from existing systems

This database design provides a robust foundation for storing Performance Payout data while maintaining CDM compliance and following relational database best practices.
