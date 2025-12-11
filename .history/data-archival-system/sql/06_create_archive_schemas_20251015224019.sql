-- 06_create_archive_schemas.sql
-- Create archive schemas for each source database

USE archive_db;
GO

-- Create schemas for each source database
CREATE SCHEMA SourceDB1;
GO
CREATE SCHEMA SourceDB2;
GO
CREATE SCHEMA SourceDB3;
GO

-- Create archive tables with metadata columns
CREATE TABLE SourceDB1.Position (
    basketId UNIQUEIDENTIFIER NOT NULL,
    positionId BIGINT NOT NULL,
    businessDate DATE NOT NULL,
    contractId UNIQUEIDENTIFIER NOT NULL,
    quantity DECIMAL(18,4),
    price DECIMAL(18,4),
    archival_flag BIT NOT NULL,
    archived_date DATETIME DEFAULT GETDATE(),
    archive_batch_id UNIQUEIDENTIFIER,
    retention_expiry_date DATE,
    CONSTRAINT PK_Position_Archive PRIMARY KEY CLUSTERED (basketId, positionId, businessDate, archival_flag)
);

CREATE TABLE SourceDB2.Trade (
    tradeId UNIQUEIDENTIFIER NOT NULL,
    contractId UNIQUEIDENTIFIER NOT NULL,
    tradeDate DATE NOT NULL,
    quantity DECIMAL(18,4),
    price DECIMAL(18,4),
    archival_flag BIT NOT NULL,
    archived_date DATETIME DEFAULT GETDATE(),
    archive_batch_id UNIQUEIDENTIFIER,
    retention_expiry_date DATE,
    CONSTRAINT PK_Trade_Archive PRIMARY KEY CLUSTERED (tradeId, archival_flag)
);

CREATE TABLE SourceDB3.PriceHistory (
    priceId UNIQUEIDENTIFIER NOT NULL,
    asOfDate DATE NOT NULL,
    symbol VARCHAR(20) NOT NULL,
    price DECIMAL(18,4),
    archival_flag BIT NOT NULL,
    archived_date DATETIME DEFAULT GETDATE(),
    archive_batch_id UNIQUEIDENTIFIER,
    retention_expiry_date DATE,
    CONSTRAINT PK_PriceHistory_Archive PRIMARY KEY CLUSTERED (priceId, archival_flag)
);

PRINT 'Archive schemas and tables created successfully';
