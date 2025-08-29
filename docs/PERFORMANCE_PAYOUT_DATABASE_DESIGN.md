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

-- Enhanced materialized view for cashflow summary with all states including deferred
CREATE MATERIALIZED VIEW cashflow_status_summary AS
SELECT 
    c.contract_id,
    c.leg_id,
    c.cashflow_type,
    c.cashflow_subtype,
    c.cashflow_status,
    c.currency,
    COUNT(*) as cashflow_count,
    SUM(CASE WHEN c.cashflow_status = 'ACCRUED' THEN c.amount ELSE 0 END) as total_accrued_amount,
    SUM(CASE WHEN c.cashflow_status = 'REALIZED_DEFERRED' THEN c.amount ELSE 0 END) as total_deferred_amount,
    SUM(CASE WHEN c.cashflow_status = 'REALIZED_UNSETTLED' THEN c.amount ELSE 0 END) as total_realized_unsettled_amount,
    SUM(CASE WHEN c.cashflow_status = 'REALIZED_SETTLED' THEN c.amount ELSE 0 END) as total_realized_settled_amount,
    AVG(c.amount) as average_cashflow_amount,
    MIN(c.payment_date) as earliest_payment_date,
    MAX(c.payment_date) as latest_payment_date
FROM cashflows c
GROUP BY c.contract_id, c.leg_id, c.cashflow_type, c.cashflow_subtype, c.cashflow_status, c.currency;

-- Materialized view for daily accrual summary
CREATE MATERIALIZED VIEW daily_accrual_summary AS
SELECT 
    da.contract_id,
    da.leg_id,
    da.accrual_date,
    da.currency,
    COUNT(*) as accrual_count,
    SUM(da.daily_accrual_amount) as total_daily_accrual,
    SUM(da.cumulative_accrual_amount) as total_cumulative_accrual,
    AVG(da.accrual_factor) as average_accrual_factor,
    SUM(da.notional_amount) as total_notional
FROM daily_accruals da
GROUP BY da.contract_id, da.leg_id, da.accrual_date, da.currency;

-- Materialized view for unrealized P&L summary
CREATE MATERIALIZED VIEW unrealized_pnl_summary AS
SELECT 
    upnl.contract_id,
    upnl.leg_id,
    upnl.valuation_date,
    upnl.unrealized_pnl_currency,
    COUNT(*) as valuation_count,
    SUM(upnl.unrealized_pnl_amount) as total_unrealized_pnl,
    SUM(upnl.price_pnl_amount) as total_price_pnl,
    SUM(upnl.dividend_pnl_amount) as total_dividend_pnl,
    SUM(upnl.interest_pnl_amount) as total_interest_pnl,
    SUM(upnl.fx_pnl_amount) as total_fx_pnl,
    AVG(upnl.confidence_level) as average_confidence_level
FROM unrealized_pnl_timeseries upnl
GROUP BY upnl.contract_id, upnl.leg_id, upnl.valuation_date, upnl.unrealized_pnl_currency;

-- Materialized view for deferred cashflow analysis
CREATE MATERIALIZED VIEW deferred_cashflow_analysis AS
SELECT 
    c.contract_id,
    c.leg_id,
    c.deferral_reason,
    c.currency,
    COUNT(*) as deferred_count,
    SUM(c.amount) as total_deferred_amount,
    AVG(c.deferral_period_days) as average_deferral_period,
    MIN(c.deferral_date) as earliest_deferral_date,
    MAX(c.expected_realization_date) as latest_expected_realization,
    COUNT(CASE WHEN c.expected_realization_date < CURRENT_DATE THEN 1 END) as overdue_deferrals
FROM cashflows c
WHERE c.cashflow_status = 'REALIZED_DEFERRED'
GROUP BY c.contract_id, c.leg_id, c.deferral_reason, c.currency;

-- Refresh all materialized views
REFRESH MATERIALIZED VIEW performance_payout_summary;
REFRESH MATERIALIZED VIEW cashflow_status_summary;
REFRESH MATERIALIZED VIEW daily_accrual_summary;
REFRESH MATERIALIZED VIEW unrealized_pnl_summary;
REFRESH MATERIALIZED VIEW deferred_cashflow_analysis;
```

## **Example Usage Scenarios**

### 1. **Single Stock Equity Swap**
```sql
-- Create performance payout for single stock
INSERT INTO performance_payout (contract_id, leg_id, payout_type) 
VALUES ('contract-uuid', 'leg-uuid', 'PERFORMANCE_PAYOUT');

-- Add single stock underlier
INSERT INTO underliers (performance_payout_id, underlier_type, underlier_reference, underlier_name)
VALUES ('payout-uuid', 'SINGLE_STOCK', 'US0378331005', 'Apple Inc.');

-- Configure price return terms
INSERT INTO return_terms (performance_payout_id, return_type, is_cumulative)
VALUES ('payout-uuid', 'PRICE', TRUE);
```

### 2. **Basket Equity Swap**
```sql
-- Create basket underlier
INSERT INTO underliers (performance_payout_id, underlier_type, underlier_reference, underlier_name)
VALUES ('payout-uuid', 'BASKET', 'TECH_BASKET_001', 'Technology Sector Basket');

-- Add basket constituents
INSERT INTO basket_constituents (basket_underlier_id, constituent_underlier_id, weight_type, weight_value)
VALUES 
    ('basket-uuid', 'apple-uuid', 'PERCENTAGE', 0.40),
    ('basket-uuid', 'microsoft-uuid', 'PERCENTAGE', 0.35),
    ('basket-uuid', 'google-uuid', 'PERCENTAGE', 0.25);
```

### 3. **Complex Return Terms**
```sql
-- Add variance return terms
INSERT INTO variance_volatility_terms (
    return_terms_id, 
    variance_strike_price, 
    variance_cap_price, 
    annualization_factor
) VALUES ('return-terms-uuid', 0.15, 0.25, 252);
```

## **Practical Query Examples**

### 1. **Enhanced Cashflow Status Tracking Queries**

#### **Get All Cashflows by Status Including Deferred**
```sql
SELECT 
    c.cashflow_reference,
    c.cashflow_type,
    c.cashflow_subtype,
    c.cashflow_status,
    c.amount,
    c.currency,
    c.accrual_start_date,
    c.accrual_end_date,
    c.payment_date,
    c.deferral_date,
    c.expected_realization_date,
    c.deferral_reason,
    p1.party_name as payer,
    p2.party_name as receiver
FROM cashflows c
JOIN parties p1 ON c.payer_party_id = p1.id
JOIN parties p2 ON c.receiver_party_id = p2.id
WHERE c.contract_id = 'contract-uuid'
ORDER BY 
    CASE c.cashflow_status 
        WHEN 'ACCRUED' THEN 1
        WHEN 'REALIZED_DEFERRED' THEN 2
        WHEN 'REALIZED_UNSETTLED' THEN 3
        WHEN 'REALIZED_SETTLED' THEN 4
    END,
    c.payment_date;
```

#### **Get Deferred Cashflows Requiring Attention**
```sql
SELECT 
    c.cashflow_reference,
    c.amount,
    c.currency,
    c.deferral_date,
    c.expected_realization_date,
    c.deferral_reason,
    DATEDIFF('day', c.expected_realization_date, CURRENT_DATE) as days_overdue,
    CASE 
        WHEN c.expected_realization_date < CURRENT_DATE THEN 'OVERDUE'
        WHEN c.expected_realization_date = CURRENT_DATE THEN 'DUE_TODAY'
        ELSE 'FUTURE'
    END as deferral_status
FROM cashflows c
WHERE c.cashflow_status = 'REALIZED_DEFERRED'
  AND (c.expected_realization_date <= CURRENT_DATE OR c.expected_realization_date IS NULL)
ORDER BY c.expected_realization_date;
```

### 2. **Daily Accrual Time Series Queries**

#### **Get Daily Accrual Progression for a Contract**
```sql
SELECT 
    da.accrual_date,
    da.business_date,
    da.daily_accrual_amount,
    da.cumulative_accrual_amount,
    da.currency,
    da.accrual_factor,
    da.notional_amount,
    da.rate_or_price,
    da.is_business_day
FROM daily_accruals da
WHERE da.contract_id = 'contract-uuid'
  AND da.accrual_date BETWEEN '2024-01-01' AND '2024-01-31'
ORDER BY da.accrual_date;
```

#### **Calculate Interest Accrual from Daily Granular Data**
```sql
SELECT 
    da.contract_id,
    da.leg_id,
    da.currency,
    COUNT(*) as accrual_days,
    SUM(da.daily_accrual_amount) as total_accrued_amount,
    SUM(da.cumulative_accrual_amount) as final_cumulative_amount,
    AVG(da.accrual_factor) as average_day_count_fraction,
    SUM(da.notional_amount * da.accrual_factor) as notional_weighted_accrual
FROM daily_accruals da
WHERE da.contract_id = 'contract-uuid'
  AND da.accrual_date BETWEEN '2024-01-01' AND '2024-01-31'
GROUP BY da.contract_id, da.leg_id, da.currency;
```

#### **Compare Daily vs. Period Accruals**
```sql
WITH daily_summary AS (
    SELECT 
        contract_id,
        leg_id,
        currency,
        SUM(daily_accrual_amount) as daily_total,
        SUM(cumulative_accrual_amount) as daily_cumulative
    FROM daily_accruals
    WHERE accrual_date BETWEEN '2024-01-01' AND '2024-01-31'
    GROUP BY contract_id, leg_id, currency
),
period_summary AS (
    SELECT 
        contract_id,
        leg_id,
        currency,
        SUM(amount) as period_total
    FROM cashflows
    WHERE cashflow_status = 'ACCRUED'
      AND accrual_start_date >= '2024-01-01'
      AND accrual_end_date <= '2024-01-31'
    GROUP BY contract_id, leg_id, currency
)
SELECT 
    ds.contract_id,
    ds.leg_id,
    ds.currency,
    ds.daily_total,
    ds.daily_cumulative,
    ps.period_total,
    ABS(ds.daily_total - ps.period_total) as difference,
    CASE 
        WHEN ABS(ds.daily_total - ps.period_total) < 0.01 THEN 'MATCH'
        ELSE 'MISMATCH'
    END as reconciliation_status
FROM daily_summary ds
JOIN period_summary ps ON ds.contract_id = ps.contract_id 
    AND ds.leg_id = ps.leg_id 
    AND ds.currency = ps.currency;
```

### 3. **Unrealized P&L Time Series Queries**

#### **Get P&L Time Series for Risk Analysis**
```sql
SELECT 
    upnl.valuation_date,
    upnl.business_date,
    upnl.unrealized_pnl_amount,
    upnl.unrealized_pnl_currency,
    upnl.price_pnl_amount,
    upnl.dividend_pnl_amount,
    upnl.interest_pnl_amount,
    upnl.fx_pnl_amount,
    upnl.other_pnl_amount,
    upnl.valuation_method,
    upnl.confidence_level,
    upnl.is_end_of_day,
    upnl.is_month_end
FROM unrealized_pnl_timeseries upnl
WHERE upnl.contract_id = 'contract-uuid'
  AND upnl.valuation_date >= CURRENT_DATE - INTERVAL '30 days'
ORDER BY upnl.valuation_date;
```

#### **Calculate P&L Volatility and Risk Metrics**
```sql
WITH pnl_changes AS (
    SELECT 
        valuation_date,
        unrealized_pnl_amount,
        LAG(unrealized_pnl_amount) OVER (ORDER BY valuation_date) as prev_pnl,
        unrealized_pnl_amount - LAG(unrealized_pnl_amount) OVER (ORDER BY valuation_date) as pnl_change
    FROM unrealized_pnl_timeseries
    WHERE contract_id = 'contract-uuid'
      AND valuation_date >= CURRENT_DATE - INTERVAL '90 days'
)
SELECT 
    COUNT(*) as observation_count,
    AVG(pnl_change) as average_daily_change,
    STDDEV(pnl_change) as daily_pnl_volatility,
    MIN(pnl_change) as worst_daily_change,
    MAX(pnl_change) as best_daily_change,
    PERCENTILE_CONT(0.05) WITHIN GROUP (ORDER BY pnl_change) as var_95_percentile,
    PERCENTILE_CONT(0.01) WITHIN GROUP (ORDER BY pnl_change) as var_99_percentile
FROM pnl_changes
WHERE pnl_change IS NOT NULL;
```

#### **End-of-Day P&L Summary**
```sql
SELECT 
    upnl.valuation_date,
    upnl.contract_id,
    upnl.leg_id,
    upnl.unrealized_pnl_amount,
    upnl.unrealized_pnl_currency,
    upnl.price_pnl_amount,
    upnl.dividend_pnl_amount,
    upnl.interest_pnl_amount,
    upnl.fx_pnl_amount,
    upnl.other_pnl_amount,
    upnl.valuation_method,
    upnl.confidence_level
FROM unrealized_pnl_timeseries upnl
WHERE upnl.is_end_of_day = TRUE
  AND upnl.valuation_date >= CURRENT_DATE - INTERVAL '7 days'
ORDER BY upnl.valuation_date DESC;
```

### 4. **Deferred Cashflow Management Queries**

#### **Get Deferral Reasons and Volumes**
```sql
SELECT 
    deferral_reason,
    currency,
    COUNT(*) as cashflow_count,
    SUM(amount) as total_deferred_amount,
    AVG(deferral_period_days) as average_deferral_period,
    COUNT(CASE WHEN expected_realization_date < CURRENT_DATE THEN 1 END) as overdue_count,
    SUM(CASE WHEN expected_realization_date < CURRENT_DATE THEN amount ELSE 0 END) as overdue_amount
FROM cashflows
WHERE cashflow_status = 'REALIZED_DEFERRED'
GROUP BY deferral_reason, currency
ORDER BY total_deferred_amount DESC;
```

#### **Monitor Deferral Aging**
```sql
SELECT 
    contract_id,
    leg_id,
    cashflow_type,
    deferral_reason,
    amount,
    currency,
    deferral_date,
    expected_realization_date,
    DATEDIFF('day', deferral_date, CURRENT_DATE) as days_since_deferral,
    DATEDIFF('day', CURRENT_DATE, expected_realization_date) as days_until_expected,
    CASE 
        WHEN expected_realization_date < CURRENT_DATE THEN 'OVERDUE'
        WHEN expected_realization_date = CURRENT_DATE THEN 'DUE_TODAY'
        WHEN DATEDIFF('day', CURRENT_DATE, expected_realization_date) <= 7 THEN 'DUE_SOON'
        ELSE 'FUTURE'
    END as deferral_urgency
FROM cashflows
WHERE cashflow_status = 'REALIZED_DEFERRED'
ORDER BY 
    CASE 
        WHEN expected_realization_date < CURRENT_DATE THEN 1
        WHEN expected_realization_date = CURRENT_DATE THEN 2
        WHEN DATEDIFF('day', CURRENT_DATE, expected_realization_date) <= 7 THEN 3
        ELSE 4
    END,
    expected_realization_date;
```

### 5. **Business Intelligence and Reporting Queries**

#### **Daily Cashflow and P&L Dashboard**
```sql
WITH daily_summary AS (
    SELECT 
        DATE(c.calculation_date) as calculation_date,
        c.cashflow_status,
        COUNT(*) as cashflow_count,
        SUM(c.amount) as total_amount,
        c.currency
    FROM cashflows c
    WHERE c.calculation_date >= CURRENT_DATE - INTERVAL '30 days'
    GROUP BY DATE(c.calculation_date), c.cashflow_status, c.currency
    
    UNION ALL
    
    SELECT 
        upnl.valuation_date as calculation_date,
        'UNREALIZED_PNL' as cashflow_status,
        1 as cashflow_count,
        upnl.unrealized_pnl_amount as total_amount,
        upnl.unrealized_pnl_currency as currency
    FROM unrealized_pnl_timeseries upnl
    WHERE upnl.valuation_date >= CURRENT_DATE - INTERVAL '30 days'
      AND upnl.is_end_of_day = TRUE
)
SELECT 
    calculation_date,
    cashflow_status,
    currency,
    SUM(cashflow_count) as total_count,
    SUM(total_amount) as total_amount,
    AVG(total_amount) as average_amount
FROM daily_summary
GROUP BY calculation_date, cashflow_status, currency
ORDER BY calculation_date DESC, cashflow_status, currency;
```

#### **Contract Performance Analysis with Time Series**
```sql
SELECT 
    c.contract_id,
    c.leg_id,
    c.cashflow_type,
    c.cashflow_subtype,
    COUNT(DISTINCT c.id) as total_cashflows,
    SUM(CASE WHEN c.cashflow_status = 'ACCRUED' THEN c.amount ELSE 0 END) as total_accrued,
    SUM(CASE WHEN c.cashflow_status = 'REALIZED_DEFERRED' THEN c.amount ELSE 0 END) as total_deferred,
    SUM(CASE WHEN c.cashflow_status = 'REALIZED_UNSETTLED' THEN c.amount ELSE 0 END) as total_realized_unsettled,
    SUM(CASE WHEN c.cashflow_status = 'REALIZED_SETTLED' THEN c.amount ELSE 0 END) as total_settled,
    COUNT(DISTINCT da.accrual_date) as accrual_days,
    AVG(da.daily_accrual_amount) as average_daily_accrual,
    COUNT(DISTINCT upnl.valuation_date) as valuation_days,
    AVG(upnl.unrealized_pnl_amount) as average_unrealized_pnl
FROM cashflows c
LEFT JOIN daily_accruals da ON c.id = da.cashflow_id
LEFT JOIN unrealized_pnl_timeseries upnl ON c.contract_id = upnl.contract_id AND c.leg_id = upnl.leg_id
WHERE c.contract_id = 'contract-uuid'
GROUP BY c.contract_id, c.leg_id, c.cashflow_type, c.cashflow_subtype
ORDER BY total_accrued DESC;
```

## **Business Use Cases**

### 1. **Enhanced Cashflow Lifecycle Management**
- **Accruals**: Daily granular tracking with business day adjustments
- **Deferral Management**: Track deferred cashflows with reasons and expected dates
- **Realization**: Convert accruals to realized amounts
- **Settlement**: Process payments and confirm settlements

### 2. **Time Series Analysis**
- **Daily Accruals**: Track interest and dividend accruals day by day
- **P&L Evolution**: Monitor unrealized P&L changes over time
- **Risk Metrics**: Calculate volatility and VaR from time series data
- **Performance Attribution**: Analyze P&L components over time

### 3. **Deferral Management**
- **Business Rules**: Apply deferral rules based on business logic
- **Regulatory Compliance**: Handle regulatory deferral requirements
- **Counterparty Requests**: Process counterparty deferral requests
- **Aging Analysis**: Monitor overdue deferrals and take action

### 4. **Risk and Compliance**
- **Real-time Monitoring**: Track cashflow and P&L changes
- **Stress Testing**: Use time series data for scenario analysis
- **Regulatory Reporting**: Generate reports with time series data
- **Audit Trail**: Complete history of all status changes

### 5. **Reporting and Analytics**
- **Daily Dashboards**: Real-time cashflow and P&L positions
- **Trend Analysis**: Identify patterns in accruals and P&L
- **Performance Metrics**: Track settlement efficiency and deferral rates
- **Counterparty Analysis**: Monitor exposure and netting benefits
