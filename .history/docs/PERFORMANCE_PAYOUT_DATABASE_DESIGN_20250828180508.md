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

#### **1.11 Cashflows Table**

```sql
-- Generated cashflows from performance payout calculations
CREATE TABLE cashflows (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    performance_payout_id UUID NOT NULL,
    contract_id UUID NOT NULL,
    leg_id UUID NOT NULL,
    
    -- CDM compliance
    cdm_entity_type VARCHAR(100) NOT NULL DEFAULT 'Cashflow',
    cdm_global_key VARCHAR(255) UNIQUE,
    
    -- Cashflow identification
    cashflow_reference VARCHAR(255) UNIQUE NOT NULL,
    cashflow_type VARCHAR(50) NOT NULL, -- 'EQUITY_RETURN', 'DIVIDEND', 'INTEREST', 'FEES'
    cashflow_subtype VARCHAR(50), -- 'PRICE_RETURN', 'VARIANCE', 'VOLATILITY', etc.
    
    -- Amount and currency
    amount DECIMAL(19,6) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    fx_rate DECIMAL(19,6) DEFAULT 1.0,
    base_currency_amount DECIMAL(19,6),
    
    -- Payer and receiver
    payer_party_id UUID NOT NULL,
    receiver_party_id UUID NOT NULL,
    
    -- Dates
    accrual_start_date DATE NOT NULL,
    accrual_end_date DATE NOT NULL,
    calculation_date DATE NOT NULL,
    payment_date DATE NOT NULL,
    
    -- Status tracking
    cashflow_status VARCHAR(50) DEFAULT 'ACCRUED', -- 'ACCRUED', 'REALIZED_UNSETTLED', 'REALIZED_SETTLED'
    realization_date DATE,
    settlement_date DATE,
    
    -- Calculation metadata
    calculation_method VARCHAR(100),
    calculation_source VARCHAR(255),
    market_data_snapshot JSONB, -- Store market data used for calculation
    
    -- Business metadata
    tags TEXT[], -- Array of business tags
    business_metadata JSONB, -- Additional business fields
    
    -- Audit fields
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    version INTEGER DEFAULT 1,
    
    -- Constraints
    CONSTRAINT fk_cashflows_performance_payout 
        FOREIGN KEY (performance_payout_id) REFERENCES performance_payout(id),
    CONSTRAINT fk_cashflows_contract 
        FOREIGN KEY (contract_id) REFERENCES contracts(id),
    CONSTRAINT fk_cashflows_leg 
        FOREIGN KEY (leg_id) REFERENCES contract_legs(id),
    CONSTRAINT fk_cashflows_payer 
        FOREIGN KEY (payer_party_id) REFERENCES parties(id),
    CONSTRAINT fk_cashflows_receiver 
        FOREIGN KEY (receiver_party_id) REFERENCES parties(id),
    CONSTRAINT uk_cashflow_reference UNIQUE (cashflow_reference)
);

-- Indexes for performance
CREATE INDEX idx_cashflows_performance_payout_id ON cashflows(performance_payout_id);
CREATE INDEX idx_cashflows_contract_id ON cashflows(contract_id);
CREATE INDEX idx_cashflows_leg_id ON cashflows(leg_id);
CREATE INDEX idx_cashflows_status ON cashflows(cashflow_status);
CREATE INDEX idx_cashflows_payment_date ON cashflows(payment_date);
CREATE INDEX idx_cashflows_calculation_date ON cashflows(calculation_date);
CREATE INDEX idx_cashflows_type_subtype ON cashflows(cashflow_type, cashflow_subtype);
CREATE INDEX idx_cashflows_payer_receiver ON cashflows(payer_party_id, receiver_party_id);
CREATE INDEX idx_cashflows_cdm_global_key ON cashflows(cdm_global_key);
```

#### **1.12 Payments Table**

```sql
-- Actual payment transactions
CREATE TABLE payments (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    cashflow_id UUID NOT NULL,
    
    -- CDM compliance
    cdm_entity_type VARCHAR(100) NOT NULL DEFAULT 'Payment',
    cdm_global_key VARCHAR(255) UNIQUE,
    
    -- Payment identification
    payment_reference VARCHAR(255) UNIQUE NOT NULL,
    payment_type VARCHAR(50) NOT NULL, -- 'CASH', 'SECURITIES', 'NETTED'
    
    -- Amount and currency
    payment_amount DECIMAL(19,6) NOT NULL,
    payment_currency VARCHAR(3) NOT NULL,
    fx_rate DECIMAL(19,6) DEFAULT 1.0,
    base_currency_amount DECIMAL(19,6),
    
    -- Payment details
    payment_method VARCHAR(50), -- 'WIRE', 'ACH', 'CHAPS', 'SEPA'
    payment_instruction_id VARCHAR(255),
    payment_status VARCHAR(50) DEFAULT 'PENDING', -- 'PENDING', 'IN_TRANSIT', 'COMPLETED', 'FAILED', 'CANCELLED'
    
    -- Settlement details
    settlement_method VARCHAR(50), -- 'DELIVERY_VERSUS_PAYMENT', 'FREE_OF_PAYMENT'
    settlement_agent VARCHAR(255),
    settlement_account VARCHAR(255),
    
    -- Dates
    payment_instruction_date DATE NOT NULL,
    payment_execution_date DATE,
    payment_settlement_date DATE,
    
    -- Business metadata
    payment_reason VARCHAR(100), -- 'SCHEDULED', 'ADJUSTMENT', 'CORRECTION'
    payment_priority VARCHAR(20) DEFAULT 'NORMAL', -- 'HIGH', 'NORMAL', 'LOW'
    
    -- Audit fields
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    
    -- Constraints
    CONSTRAINT fk_payments_cashflow 
        FOREIGN KEY (cashflow_id) REFERENCES cashflows(id),
    CONSTRAINT uk_payment_reference UNIQUE (payment_reference)
);

-- Indexes
CREATE INDEX idx_payments_cashflow_id ON payments(cashflow_id);
CREATE INDEX idx_payments_status ON payments(payment_status);
CREATE INDEX idx_payments_execution_date ON payments(payment_execution_date);
CREATE INDEX idx_payments_settlement_date ON payments(payment_settlement_date);
CREATE INDEX idx_payments_type ON payments(payment_type);
CREATE INDEX idx_payments_cdm_global_key ON payments(cdm_global_key);
```

#### **1.13 Payment Instructions Table**

```sql
-- Payment instruction details for settlement systems
CREATE TABLE payment_instructions (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    payment_id UUID NOT NULL,
    
    -- CDM compliance
    cdm_entity_type VARCHAR(100) NOT NULL DEFAULT 'PaymentInstruction',
    cdm_global_key VARCHAR(255) UNIQUE,
    
    -- Instruction details
    instruction_type VARCHAR(50) NOT NULL, -- 'PAYMENT', 'COLLECTION', 'NETTING'
    instruction_status VARCHAR(50) DEFAULT 'PENDING', -- 'PENDING', 'CONFIRMED', 'REJECTED', 'CANCELLED'
    
    -- Bank account details
    payer_bank_account VARCHAR(255),
    payer_bank_name VARCHAR(255),
    payer_bank_swift VARCHAR(11),
    payer_bank_iban VARCHAR(34),
    
    receiver_bank_account VARCHAR(255),
    receiver_bank_name VARCHAR(255),
    receiver_bank_swift VARCHAR(11),
    receiver_bank_iban VARCHAR(34),
    
    -- Payment routing
    correspondent_bank VARCHAR(255),
    correspondent_bank_swift VARCHAR(11),
    intermediary_bank VARCHAR(255),
    intermediary_bank_swift VARCHAR(11),
    
    -- Instruction metadata
    priority VARCHAR(20) DEFAULT 'NORMAL',
    urgency VARCHAR(20) DEFAULT 'NORMAL',
    charge_bearer VARCHAR(20) DEFAULT 'DEBTOR', -- 'DEBTOR', 'CREDITOR', 'SHARED'
    
    -- Business fields
    purpose_code VARCHAR(10), -- ISO 20022 purpose codes
    category_purpose VARCHAR(10), -- ISO 20022 category purpose codes
    remittance_information TEXT,
    
    -- Audit fields
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    
    -- Constraints
    CONSTRAINT fk_payment_instructions_payment 
        FOREIGN KEY (payment_id) REFERENCES payments(id)
);

-- Indexes
CREATE INDEX idx_payment_instructions_payment_id ON payment_instructions(payment_id);
CREATE INDEX idx_payment_instructions_status ON payment_instructions(instruction_status);
CREATE INDEX idx_payment_instructions_type ON payment_instructions(instruction_type);
CREATE INDEX idx_payment_instructions_cdm_global_key ON payment_instructions(cdm_global_key);
```

#### **1.14 Payment Status History Table**

```sql
-- Track payment status changes for audit trail
CREATE TABLE payment_status_history (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    payment_id UUID NOT NULL,
    
    -- Status change details
    from_status VARCHAR(50) NOT NULL,
    to_status VARCHAR(50) NOT NULL,
    status_change_reason VARCHAR(255),
    
    -- Change metadata
    changed_by VARCHAR(100) NOT NULL,
    changed_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    
    -- Business context
    business_justification TEXT,
    approval_required BOOLEAN DEFAULT FALSE,
    approval_received BOOLEAN DEFAULT FALSE,
    approval_received_by VARCHAR(100),
    approval_received_at TIMESTAMP WITH TIME ZONE,
    
    -- Constraints
    CONSTRAINT fk_payment_status_history_payment 
        FOREIGN KEY (payment_id) REFERENCES payments(id)
);

-- Indexes
CREATE INDEX idx_payment_status_history_payment_id ON payment_status_history(payment_id);
CREATE INDEX idx_payment_status_history_changed_at ON payment_status_history(changed_at);
CREATE INDEX idx_payment_status_history_from_status ON payment_status_history(from_status);
CREATE INDEX idx_payment_status_history_to_status ON payment_status_history(to_status);
```

#### **1.15 Netting Instructions Table**

```sql
-- Netting instructions for multiple cashflows
CREATE TABLE netting_instructions (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    
    -- CDM compliance
    cdm_entity_type VARCHAR(100) NOT NULL DEFAULT 'NettingInstruction',
    cdm_global_key VARCHAR(255) UNIQUE,
    
    -- Netting details
    netting_reference VARCHAR(255) UNIQUE NOT NULL,
    netting_type VARCHAR(50) NOT NULL, -- 'PAYMENT_NETTING', 'SETTLEMENT_NETTING'
    netting_status VARCHAR(50) DEFAULT 'PENDING', -- 'PENDING', 'CONFIRMED', 'EXECUTED', 'CANCELLED'
    
    -- Parties
    party1_id UUID NOT NULL,
    party2_id UUID NOT NULL,
    
    -- Netting calculation
    netting_date DATE NOT NULL,
    netting_currency VARCHAR(3) NOT NULL,
    net_amount DECIMAL(19,6), -- Can be positive (party1 pays) or negative (party2 pays)
    
    -- Business fields
    netting_agreement_reference VARCHAR(255),
    netting_method VARCHAR(50), -- 'BILATERAL', 'MULTILATERAL'
    
    -- Audit fields
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    
    -- Constraints
    CONSTRAINT fk_netting_instructions_party1 
        FOREIGN KEY (party1_id) REFERENCES parties(id),
    CONSTRAINT fk_netting_instructions_party2 
        FOREIGN KEY (party2_id) REFERENCES parties(id)
);

-- Indexes
CREATE INDEX idx_netting_instructions_party1 ON netting_instructions(party1_id);
CREATE INDEX idx_netting_instructions_party2 ON netting_instructions(party2_id);
CREATE INDEX idx_netting_instructions_date ON netting_instructions(netting_date);
CREATE INDEX idx_netting_instructions_status ON netting_instructions(netting_status);
CREATE INDEX idx_netting_instructions_cdm_global_key ON netting_instructions(cdm_global_key);
```

#### **1.16 Netting Cashflow Mapping Table**

```sql
-- Maps cashflows to netting instructions
CREATE TABLE netting_cashflow_mapping (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    netting_instruction_id UUID NOT NULL,
    cashflow_id UUID NOT NULL,
    
    -- Mapping details
    inclusion_type VARCHAR(20) NOT NULL, -- 'INCLUDE', 'EXCLUDE'
    netting_priority INTEGER DEFAULT 0, -- Priority for netting order
    
    -- Business fields
    netting_eligibility_reason VARCHAR(255),
    
    -- Audit fields
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    
    -- Constraints
    CONSTRAINT fk_netting_cashflow_mapping_netting 
        FOREIGN KEY (netting_instruction_id) REFERENCES netting_instructions(id),
    CONSTRAINT fk_netting_cashflow_mapping_cashflow 
        FOREIGN KEY (cashflow_id) REFERENCES cashflows(id),
    CONSTRAINT uk_netting_cashflow UNIQUE (netting_instruction_id, cashflow_id)
);

-- Indexes
CREATE INDEX idx_netting_cashflow_mapping_netting_id ON netting_cashflow_mapping(netting_instruction_id);
CREATE INDEX idx_netting_cashflow_mapping_cashflow_id ON netting_cashflow_mapping(cashflow_id);
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

-- Refresh materialized view
REFRESH MATERIALIZED VIEW performance_payout_summary;
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
