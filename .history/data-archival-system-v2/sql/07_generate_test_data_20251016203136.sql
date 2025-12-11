-- 07_generate_test_data.sql
-- Generate sample test data

-- ========================================
-- SourceDB1: Contract and Position data
-- ========================================
USE SourceDB1;
GO

-- Insert sample contracts
INSERT INTO dbo.Contract (contractId, contract_number, counterparty, start_date, maturity_date, status)
VALUES
    (NEWID(), 'CTR-2024-001', 'Counterparty A', '2024-01-01', '2024-12-31', 'MATURED'),
    (NEWID(), 'CTR-2024-002', 'Counterparty B', '2024-03-01', '2025-03-01', 'ACTIVE'),
    (NEWID(), 'CTR-2024-003', 'Counterparty C', '2024-06-01', '2025-06-01', 'ACTIVE');

DECLARE @contract1 UNIQUEIDENTIFIER = (SELECT contractId FROM dbo.Contract WHERE contract_number = 'CTR-2024-001');
DECLARE @contract2 UNIQUEIDENTIFIER = (SELECT contractId FROM dbo.Contract WHERE contract_number = 'CTR-2024-002');

-- Insert old positions (eligible for archival - older than 3 months)
INSERT INTO dbo.Position (basketId, positionId, businessDate, contractId, securityId, quantity, price, market_value)
VALUES
    (NEWID(), 1, '2024-06-01', @contract1, 'AAPL', 100.00, 150.00, 15000.00),
    (NEWID(), 2, '2024-06-02', @contract1, 'GOOGL', 50.00, 2500.00, 125000.00),
    (NEWID(), 3, '2024-07-01', @contract1, 'MSFT', 200.00, 300.00, 60000.00),
    (NEWID(), 4, '2024-08-01', @contract1, 'TSLA', 75.00, 250.00, 18750.00);

-- Insert recent positions (NOT eligible for archival - within 3 months)
INSERT INTO dbo.Position (basketId, positionId, businessDate, contractId, securityId, quantity, price, market_value)
VALUES
    (NEWID(), 5, DATEADD(DAY, -30, GETDATE()), @contract2, 'AAPL', 150.00, 160.00, 24000.00),
    (NEWID(), 6, DATEADD(DAY, -15, GETDATE()), @contract2, 'GOOGL', 60.00, 2600.00, 156000.00),
    (NEWID(), 7, GETDATE(), @contract2, 'MSFT', 250.00, 310.00, 77500.00);

PRINT 'Generated ' + CAST(@@ROWCOUNT AS VARCHAR) + ' positions in SourceDB1';
GO

-- ========================================
-- SourceDB2: Trade data
-- ========================================
USE SourceDB2;
GO

-- Insert sample contracts
INSERT INTO dbo.Contract (contractId, contract_number, counterparty, start_date, maturity_date, status)
VALUES
    (NEWID(), 'CTR-2024-101', 'Counterparty X', '2024-01-01', '2024-12-31', 'MATURED'),
    (NEWID(), 'CTR-2024-102', 'Counterparty Y', '2024-03-01', '2025-03-01', 'ACTIVE');

DECLARE @trade_contract1 UNIQUEIDENTIFIER = (SELECT contractId FROM dbo.Contract WHERE contract_number = 'CTR-2024-101');
DECLARE @trade_contract2 UNIQUEIDENTIFIER = (SELECT contractId FROM dbo.Contract WHERE contract_number = 'CTR-2024-102');

-- Insert old trades (eligible for archival)
INSERT INTO dbo.Trade (tradeId, contractId, tradeDate, settlementDate, trade_type, amount, currency)
VALUES
    (NEWID(), @trade_contract1, '2024-06-01', '2024-06-03', 'BUY', 100000.00, 'USD'),
    (NEWID(), @trade_contract1, '2024-06-15', '2024-06-17', 'SELL', 50000.00, 'USD'),
    (NEWID(), @trade_contract1, '2024-07-01', '2024-07-03', 'BUY', 75000.00, 'USD');

-- Insert recent trades (NOT eligible)
INSERT INTO dbo.Trade (tradeId, contractId, tradeDate, settlementDate, trade_type, amount, currency)
VALUES
    (NEWID(), @trade_contract2, DATEADD(DAY, -20, GETDATE()), DATEADD(DAY, -18, GETDATE()), 'BUY', 120000.00, 'USD'),
    (NEWID(), @trade_contract2, DATEADD(DAY, -10, GETDATE()), DATEADD(DAY, -8, GETDATE()), 'SELL', 60000.00, 'USD');

PRINT 'Generated ' + CAST(@@ROWCOUNT AS VARCHAR) + ' trades in SourceDB2';
GO

-- ========================================
-- SourceDB3: Price History data
-- ========================================
USE SourceDB3;
GO

-- Insert old price history (eligible for archival)
DECLARE @i INT = 120; -- 120 days ago
WHILE @i > 90 -- Generate for 30 days (120-90 days ago)
BEGIN
    INSERT INTO dbo.PriceHistory (securityId, priceDate, open_price, close_price, high_price, low_price, volume)
    VALUES
        ('AAPL', DATEADD(DAY, -@i, GETDATE()), 145.00, 150.00, 152.00, 144.00, 1000000),
        ('GOOGL', DATEADD(DAY, -@i, GETDATE()), 2450.00, 2500.00, 2510.00, 2440.00, 500000),
        ('MSFT', DATEADD(DAY, -@i, GETDATE()), 295.00, 300.00, 302.00, 294.00, 800000);
    
    SET @i = @i - 1;
END

-- Insert recent price history (NOT eligible)
SET @i = 30;
WHILE @i > 0
BEGIN
    INSERT INTO dbo.PriceHistory (securityId, priceDate, open_price, close_price, high_price, low_price, volume)
    VALUES
        ('AAPL', DATEADD(DAY, -@i, GETDATE()), 155.00, 160.00, 162.00, 154.00, 1200000),
        ('GOOGL', DATEADD(DAY, -@i, GETDATE()), 2550.00, 2600.00, 2610.00, 2540.00, 550000),
        ('MSFT', DATEADD(DAY, -@i, GETDATE()), 305.00, 310.00, 312.00, 304.00, 900000);
    
    SET @i = @i - 1;
END

PRINT 'Generated price history in SourceDB3';
GO

PRINT 'All test data generated successfully';
