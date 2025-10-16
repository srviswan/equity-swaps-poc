-- 05_create_test_tables.sql
-- Create test tables in source databases

-- SourceDB1 - Position table
USE SourceDB1;
GO

CREATE TABLE dbo.Contract (
    contractId UNIQUEIDENTIFIER PRIMARY KEY,
    contractNumber VARCHAR(50) NOT NULL,
    maturity_date DATE NOT NULL,
    status VARCHAR(20) DEFAULT 'ACTIVE',
    jurisdiction VARCHAR(50) DEFAULT 'US',
    created_date DATETIME DEFAULT GETDATE()
);

CREATE TABLE dbo.Position (
    basketId UNIQUEIDENTIFIER NOT NULL,
    positionId BIGINT NOT NULL,
    businessDate DATE NOT NULL,
    contractId UNIQUEIDENTIFIER NOT NULL,
    quantity DECIMAL(18,4),
    price DECIMAL(18,4),
    archival_flag BIT DEFAULT 0 NOT NULL,
    CONSTRAINT PK_Position PRIMARY KEY CLUSTERED (basketId, positionId, businessDate),
    CONSTRAINT FK_Position_Contract FOREIGN KEY (contractId) REFERENCES dbo.Contract(contractId)
);

-- SourceDB2 - Trade table
USE SourceDB2;
GO

CREATE TABLE dbo.Contract (
    contractId UNIQUEIDENTIFIER PRIMARY KEY,
    contractNumber VARCHAR(50) NOT NULL,
    maturity_date DATE NOT NULL,
    status VARCHAR(20) DEFAULT 'ACTIVE',
    jurisdiction VARCHAR(50) DEFAULT 'US',
    created_date DATETIME DEFAULT GETDATE()
);

CREATE TABLE dbo.Trade (
    tradeId UNIQUEIDENTIFIER PRIMARY KEY,
    contractId UNIQUEIDENTIFIER NOT NULL,
    tradeDate DATE NOT NULL,
    quantity DECIMAL(18,4),
    price DECIMAL(18,4),
    archival_flag BIT DEFAULT 0 NOT NULL,
    CONSTRAINT FK_Trade_Contract FOREIGN KEY (contractId) REFERENCES dbo.Contract(contractId)
);

-- SourceDB3 - Reference data
USE SourceDB3;
GO

CREATE TABLE dbo.PriceHistory (
    priceId UNIQUEIDENTIFIER PRIMARY KEY,
    asOfDate DATE NOT NULL,
    symbol VARCHAR(20) NOT NULL,
    price DECIMAL(18,4),
    archival_flag BIT DEFAULT 0 NOT NULL
);

PRINT 'Test tables created successfully';
