-- 04_create_test_tables.sql
-- Create test tables with archival_flag in source databases

-- ========================================
-- SourceDB1 Tables
-- ========================================
USE SourceDB1;
GO

-- Contract table (reference table)
CREATE TABLE dbo.Contract (
    contractId UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    contract_number VARCHAR(50) NOT NULL UNIQUE,
    counterparty VARCHAR(100) NOT NULL,
    start_date DATE NOT NULL,
    maturity_date DATE NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE', -- 'ACTIVE', 'MATURED', 'TERMINATED'
    created_date DATETIME DEFAULT GETDATE()
);

CREATE INDEX IDX_Contract_status ON dbo.Contract(status);
CREATE INDEX IDX_Contract_maturity ON dbo.Contract(maturity_date);

PRINT 'Created Contract table in SourceDB1';
GO

-- Position table (main transactional table with partitioning)
CREATE TABLE dbo.Position (
    basketId UNIQUEIDENTIFIER NOT NULL,
    positionId BIGINT NOT NULL,
    businessDate DATE NOT NULL,
    contractId UNIQUEIDENTIFIER NOT NULL,
    securityId VARCHAR(50) NOT NULL,
    quantity DECIMAL(18,4) NOT NULL,
    price DECIMAL(18,4) NOT NULL,
    market_value DECIMAL(18,2) NOT NULL,
    
    -- Archival flag
    archival_flag BIT DEFAULT 0 NOT NULL,
    archival_month VARCHAR(6) NULL, -- YYYYMM - for monthly partitioning
    
    created_date DATETIME DEFAULT GETDATE(),
    
    CONSTRAINT PK_Position PRIMARY KEY CLUSTERED (basketId, positionId, businessDate),
    CONSTRAINT FK_Position_Contract FOREIGN KEY (contractId) REFERENCES dbo.Contract(contractId)
);

CREATE INDEX IDX_Position_archival ON dbo.Position(archival_flag, archival_month);
CREATE INDEX IDX_Position_businessDate ON dbo.Position(businessDate);
CREATE INDEX IDX_Position_contractId ON dbo.Position(contractId);

PRINT 'Created Position table in SourceDB1';
GO

-- ========================================
-- SourceDB2 Tables
-- ========================================
USE SourceDB2;
GO

-- Contract table
CREATE TABLE dbo.Contract (
    contractId UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    contract_number VARCHAR(50) NOT NULL UNIQUE,
    counterparty VARCHAR(100) NOT NULL,
    start_date DATE NOT NULL,
    maturity_date DATE NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    created_date DATETIME DEFAULT GETDATE()
);

PRINT 'Created Contract table in SourceDB2';
GO

-- Trade table
CREATE TABLE dbo.Trade (
    tradeId UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    contractId UNIQUEIDENTIFIER NOT NULL,
    tradeDate DATE NOT NULL,
    settlementDate DATE NOT NULL,
    trade_type VARCHAR(50) NOT NULL,
    amount DECIMAL(18,4) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    
    -- Archival flag
    archival_flag BIT DEFAULT 0 NOT NULL,
    archival_month VARCHAR(6) NULL,
    
    created_date DATETIME DEFAULT GETDATE(),
    
    CONSTRAINT FK_Trade_Contract FOREIGN KEY (contractId) REFERENCES dbo.Contract(contractId)
);

CREATE INDEX IDX_Trade_archival ON dbo.Trade(archival_flag, archival_month);
CREATE INDEX IDX_Trade_tradeDate ON dbo.Trade(tradeDate);
CREATE INDEX IDX_Trade_contractId ON dbo.Trade(contractId);

PRINT 'Created Trade table in SourceDB2';
GO

-- ========================================
-- SourceDB3 Tables
-- ========================================
USE SourceDB3;
GO

-- PriceHistory table
CREATE TABLE dbo.PriceHistory (
    priceId BIGINT IDENTITY(1,1) PRIMARY KEY,
    securityId VARCHAR(50) NOT NULL,
    priceDate DATE NOT NULL,
    open_price DECIMAL(18,4),
    close_price DECIMAL(18,4),
    high_price DECIMAL(18,4),
    low_price DECIMAL(18,4),
    volume BIGINT,
    
    -- Archival flag
    archival_flag BIT DEFAULT 0 NOT NULL,
    archival_month VARCHAR(6) NULL,
    
    created_date DATETIME DEFAULT GETDATE(),
    
    CONSTRAINT UQ_PriceHistory UNIQUE (securityId, priceDate)
);

CREATE INDEX IDX_PriceHistory_archival ON dbo.PriceHistory(archival_flag, archival_month);
CREATE INDEX IDX_PriceHistory_date ON dbo.PriceHistory(priceDate);
CREATE INDEX IDX_PriceHistory_security ON dbo.PriceHistory(securityId);

PRINT 'Created PriceHistory table in SourceDB3';
GO

PRINT 'All test tables created successfully with archival_flag';
