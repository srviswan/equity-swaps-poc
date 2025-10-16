-- 09_generate_test_data.sql
-- Generate test data for archival testing

-- SourceDB1 - Generate contracts and positions
USE SourceDB1;
GO

-- Insert test contracts (some matured, some active)
INSERT INTO dbo.Contract (contractId, contractNumber, maturity_date, status, jurisdiction)
VALUES 
    (NEWID(), 'CONTRACT-001', '2022-01-15', 'MATURED', 'US'),
    (NEWID(), 'CONTRACT-002', '2022-06-30', 'MATURED', 'US'),
    (NEWID(), 'CONTRACT-003', '2023-12-31', 'MATURED', 'US'),
    (NEWID(), 'CONTRACT-004', '2025-06-30', 'ACTIVE', 'US'),
    (NEWID(), 'CONTRACT-005', '2025-12-31', 'ACTIVE', 'US');

-- Insert test positions
DECLARE @contract1 UNIQUEIDENTIFIER = (SELECT TOP 1 contractId FROM dbo.Contract WHERE contractNumber = 'CONTRACT-001');
DECLARE @contract2 UNIQUEIDENTIFIER = (SELECT TOP 1 contractId FROM dbo.Contract WHERE contractNumber = 'CONTRACT-002');
DECLARE @contract3 UNIQUEIDENTIFIER = (SELECT TOP 1 contractId FROM dbo.Contract WHERE contractNumber = 'CONTRACT-003');
DECLARE @contract4 UNIQUEIDENTIFIER = (SELECT TOP 1 contractId FROM dbo.Contract WHERE contractNumber = 'CONTRACT-004');

INSERT INTO dbo.Position (basketId, positionId, businessDate, contractId, quantity, price)
VALUES 
    (NEWID(), 1, '2022-01-15', @contract1, 1000.00, 50.25),
    (NEWID(), 2, '2022-01-16', @contract1, 1500.00, 50.30),
    (NEWID(), 3, '2022-06-30', @contract2, 2000.00, 45.75),
    (NEWID(), 4, '2022-07-01', @contract2, 2500.00, 45.80),
    (NEWID(), 5, '2023-12-31', @contract3, 3000.00, 55.00),
    (NEWID(), 6, '2024-01-01', @contract3, 3500.00, 55.10),
    (NEWID(), 7, '2024-06-30', @contract4, 4000.00, 60.00),
    (NEWID(), 8, '2024-07-01', @contract4, 4500.00, 60.05);

-- SourceDB2 - Generate contracts and trades
USE SourceDB2;
GO

INSERT INTO dbo.Contract (contractId, contractNumber, maturity_date, status, jurisdiction)
VALUES 
    (NEWID(), 'TRADE-CONTRACT-001', '2022-03-15', 'MATURED', 'US'),
    (NEWID(), 'TRADE-CONTRACT-002', '2022-09-30', 'MATURED', 'US'),
    (NEWID(), 'TRADE-CONTRACT-003', '2025-03-15', 'ACTIVE', 'US');

DECLARE @trade_contract1 UNIQUEIDENTIFIER = (SELECT TOP 1 contractId FROM dbo.Contract WHERE contractNumber = 'TRADE-CONTRACT-001');
DECLARE @trade_contract2 UNIQUEIDENTIFIER = (SELECT TOP 1 contractId FROM dbo.Contract WHERE contractNumber = 'TRADE-CONTRACT-002');
DECLARE @trade_contract3 UNIQUEIDENTIFIER = (SELECT TOP 1 contractId FROM dbo.Contract WHERE contractNumber = 'TRADE-CONTRACT-003');

INSERT INTO dbo.Trade (tradeId, contractId, tradeDate, quantity, price)
VALUES 
    (NEWID(), @trade_contract1, '2022-03-15', 500.00, 25.50),
    (NEWID(), @trade_contract1, '2022-03-16', 750.00, 25.55),
    (NEWID(), @trade_contract2, '2022-09-30', 1000.00, 30.00),
    (NEWID(), @trade_contract2, '2022-10-01', 1250.00, 30.05),
    (NEWID(), @trade_contract3, '2024-03-15', 1500.00, 35.00),
    (NEWID(), @trade_contract3, '2024-03-16', 1750.00, 35.05);

-- SourceDB3 - Generate price history
USE SourceDB3;
GO

INSERT INTO dbo.PriceHistory (priceId, asOfDate, symbol, price)
VALUES 
    (NEWID(), '2020-01-01', 'AAPL', 75.00),
    (NEWID(), '2020-06-01', 'AAPL', 80.00),
    (NEWID(), '2021-01-01', 'AAPL', 85.00),
    (NEWID(), '2021-06-01', 'AAPL', 90.00),
    (NEWID(), '2022-01-01', 'AAPL', 95.00),
    (NEWID(), '2022-06-01', 'AAPL', 100.00),
    (NEWID(), '2023-01-01', 'AAPL', 105.00),
    (NEWID(), '2023-06-01', 'AAPL', 110.00),
    (NEWID(), '2024-01-01', 'AAPL', 115.00),
    (NEWID(), '2024-06-01', 'AAPL', 120.00);

PRINT 'Test data generated successfully';
