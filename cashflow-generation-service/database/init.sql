-- Cashflow Generation Service Database Schema
-- Create database tables for the cashflow service

-- Enable UUID extension
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Cashflows table
CREATE TABLE IF NOT EXISTS cashflows (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    contract_id UUID NOT NULL,
    leg_id UUID NOT NULL,
    security_id VARCHAR(50) NOT NULL,
    calculation_type VARCHAR(50) NOT NULL,
    cashflow_type VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    amount DECIMAL(19,6) NOT NULL,
    currency CHAR(3) NOT NULL,
    calculation_date DATE NOT NULL,
    value_date DATE,
    settlement_date DATE,
    deferral_date DATE,
    deferral_reason TEXT,
    deferral_period_days INTEGER,
    notes TEXT,
    expected_realization_date DATE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100) NOT NULL,
    updated_by VARCHAR(100) NOT NULL
);

-- Daily accruals table
CREATE TABLE IF NOT EXISTS daily_accruals (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    contract_id UUID NOT NULL,
    security_id VARCHAR(50) NOT NULL,
    accrual_date DATE NOT NULL,
    accrual_type VARCHAR(50) NOT NULL,
    accrual_amount DECIMAL(19,6) NOT NULL,
    currency CHAR(3) NOT NULL,
    calculation_basis VARCHAR(50),
    interest_rate DECIMAL(10,6),
    notional_amount DECIMAL(19,6),
    day_count_fraction DECIMAL(15,10),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100) NOT NULL,
    updated_by VARCHAR(100) NOT NULL
);

-- Unrealized P&L table
CREATE TABLE IF NOT EXISTS unrealized_pnl (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    contract_id UUID NOT NULL,
    security_id VARCHAR(50) NOT NULL,
    valuation_date DATE NOT NULL,
    unrealized_amount DECIMAL(19,6) NOT NULL,
    currency CHAR(3) NOT NULL,
    market_value DECIMAL(19,6),
    book_value DECIMAL(19,6),
    fx_rate DECIMAL(15,10),
    price_per_share DECIMAL(15,6),
    shares_outstanding DECIMAL(19,6),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100) NOT NULL,
    updated_by VARCHAR(100) NOT NULL
);

-- Create indexes for performance
CREATE INDEX IF NOT EXISTS idx_cashflows_contract_id ON cashflows(contract_id);
CREATE INDEX IF NOT EXISTS idx_cashflows_security_id ON cashflows(security_id);
CREATE INDEX IF NOT EXISTS idx_cashflows_type ON cashflows(cashflow_type);
CREATE INDEX IF NOT EXISTS idx_cashflows_status ON cashflows(status);
CREATE INDEX IF NOT EXISTS idx_cashflows_settlement_date ON cashflows(settlement_date);
CREATE INDEX IF NOT EXISTS idx_cashflows_calculation_date ON cashflows(calculation_date);

CREATE INDEX IF NOT EXISTS idx_daily_accruals_contract_id ON daily_accruals(contract_id);
CREATE INDEX IF NOT EXISTS idx_daily_accruals_security_id ON daily_accruals(security_id);
CREATE INDEX IF NOT EXISTS idx_daily_accruals_date ON daily_accruals(accrual_date);
CREATE INDEX IF NOT EXISTS idx_daily_accruals_type ON daily_accruals(accrual_type);

CREATE INDEX IF NOT EXISTS idx_unrealized_pnl_contract_id ON unrealized_pnl(contract_id);
CREATE INDEX IF NOT EXISTS idx_unrealized_pnl_security_id ON unrealized_pnl(security_id);
CREATE INDEX IF NOT EXISTS idx_unrealized_pnl_date ON unrealized_pnl(valuation_date);

-- Insert sample data for testing
INSERT INTO cashflows (
    contract_id, leg_id, security_id, calculation_type, cashflow_type, 
    status, amount, currency, calculation_date, settlement_date, 
    created_by, updated_by
) VALUES 
    ('123e4567-e89b-12d3-a456-426614174000', 
     '123e4567-e89b-12d3-a456-426614174001',
     'AAPL', 'INTEREST', 'INTEREST', 'ACCRUED', 
     1000.50, 'USD', '2024-01-15', '2024-01-17',
     'system', 'system'),
    ('123e4567-e89b-12d3-a456-426614174000',
     '123e4567-e89b-12d3-a456-426614174001', 
     'AAPL', 'PERFORMANCE', 'PERFORMANCE', 'ACCRUED',
     2500.75, 'USD', '2024-01-15', '2024-01-17',
     'system', 'system');

INSERT INTO daily_accruals (
    contract_id, security_id, accrual_date, accrual_type, 
    accrual_amount, currency, interest_rate, notional_amount,
    created_by, updated_by
) VALUES 
    ('123e4567-e89b-12d3-a456-426614174000', 'AAPL', 
     '2024-01-15', 'INTEREST', 45.50, 'USD', 
     0.05, 100000.00, 'system', 'system'),
    ('123e4567-e89b-12d3-a456-426614174000', 'AAPL',
     '2024-01-16', 'INTEREST', 46.25, 'USD',
     0.05, 100000.00, 'system', 'system');

INSERT INTO unrealized_pnl (
    contract_id, security_id, valuation_date, unrealized_amount,
    currency, market_value, book_value, fx_rate, price_per_share,
    shares_outstanding, created_by, updated_by
) VALUES 
    ('123e4567-e89b-12d3-a456-426614174000', 'AAPL',
     '2024-01-15', 1250.00, 'USD', 151250.00, 150000.00,
     1.0, 175.50, 1000, 'system', 'system');

-- Create update timestamp trigger function
CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ language 'plpgsql';

-- Create triggers for automatic timestamp updates
CREATE TRIGGER update_cashflows_updated_at 
    BEFORE UPDATE ON cashflows 
    FOR EACH ROW EXECUTE PROCEDURE update_updated_at_column();

CREATE TRIGGER update_daily_accruals_updated_at 
    BEFORE UPDATE ON daily_accruals 
    FOR EACH ROW EXECUTE PROCEDURE update_updated_at_column();

CREATE TRIGGER update_unrealized_pnl_updated_at 
    BEFORE UPDATE ON unrealized_pnl 
    FOR EACH ROW EXECUTE PROCEDURE update_updated_at_column();
