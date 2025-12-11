-- 08_create_partitioning.sql
-- Create partition functions and schemes for efficient data movement

USE SourceDB1;
GO

-- ========================================
-- Create partition function for Position table
-- Partitions by archival_flag (0 = active, 1 = archival)
-- ========================================
IF NOT EXISTS (SELECT * FROM sys.partition_functions WHERE name = 'PF_Position_ArchivalFlag')
BEGIN
    CREATE PARTITION FUNCTION PF_Position_ArchivalFlag (BIT)
    AS RANGE RIGHT FOR VALUES (1);
    -- Partition 1: archival_flag = 0 (active)
    -- Partition 2: archival_flag = 1 (to be archived)
    
    PRINT 'Created partition function PF_Position_ArchivalFlag';
END
GO

-- ========================================
-- Create partition scheme
-- ========================================
IF NOT EXISTS (SELECT * FROM sys.partition_schemes WHERE name = 'PS_Position_ArchivalFlag')
BEGIN
    CREATE PARTITION SCHEME PS_Position_ArchivalFlag
    AS PARTITION PF_Position_ArchivalFlag
    ALL TO ([PRIMARY]);
    
    PRINT 'Created partition scheme PS_Position_ArchivalFlag';
END
GO

-- ========================================
-- Drop existing Position table and recreate with partitioning
-- ========================================
IF EXISTS (SELECT * FROM sys.tables WHERE name = 'Position' AND schema_id = SCHEMA_ID('dbo'))
BEGIN
    -- Save existing data
    SELECT * INTO dbo.Position_Backup FROM dbo.Position;
    
    DROP TABLE dbo.Position;
    PRINT 'Backed up and dropped existing Position table';
END
GO

-- Create partitioned Position table
CREATE TABLE dbo.Position (
    basketId UNIQUEIDENTIFIER NOT NULL,
    positionId BIGINT NOT NULL,
    businessDate DATE NOT NULL,
    contractId UNIQUEIDENTIFIER NOT NULL,
    securityId VARCHAR(50) NOT NULL,
    quantity DECIMAL(18,4) NOT NULL,
    price DECIMAL(18,4) NOT NULL,
    market_value DECIMAL(18,2) NOT NULL,
    
    -- Archival columns
    archival_flag BIT DEFAULT 0 NOT NULL,
    archival_month VARCHAR(6) NULL,
    
    created_date DATETIME DEFAULT GETDATE(),
    
    CONSTRAINT PK_Position PRIMARY KEY CLUSTERED (basketId, positionId, businessDate, archival_flag),
    CONSTRAINT FK_Position_Contract FOREIGN KEY (contractId) REFERENCES dbo.Contract(contractId)
) ON PS_Position_ArchivalFlag(archival_flag);

CREATE INDEX IDX_Position_businessDate ON dbo.Position(businessDate);
CREATE INDEX IDX_Position_contractId ON dbo.Position(contractId);
CREATE INDEX IDX_Position_archival_month ON dbo.Position(archival_month) WHERE archival_flag = 1;

PRINT 'Created partitioned Position table';
GO

-- Restore data if backup exists
IF EXISTS (SELECT * FROM sys.tables WHERE name = 'Position_Backup' AND schema_id = SCHEMA_ID('dbo'))
BEGIN
    INSERT INTO dbo.Position SELECT * FROM dbo.Position_Backup;
    DROP TABLE dbo.Position_Backup;
    PRINT 'Restored data from backup';
END
GO

-- ========================================
-- Create staging table for partition switch
-- Must have EXACT same structure including constraints
-- ========================================
CREATE PROCEDURE dbo.sp_Create_Staging_Table_For_Partition_Switch
    @staging_table_name VARCHAR(200)
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    
    -- Drop if exists
    SET @sql = '
    IF EXISTS (SELECT * FROM sys.tables WHERE name = ''' + @staging_table_name + ''')
        DROP TABLE dbo.' + QUOTENAME(@staging_table_name) + ';
    ';
    EXEC sp_executesql @sql;
    
    -- Create staging table with EXACT same structure
    SET @sql = '
    CREATE TABLE dbo.' + QUOTENAME(@staging_table_name) + ' (
        basketId UNIQUEIDENTIFIER NOT NULL,
        positionId BIGINT NOT NULL,
        businessDate DATE NOT NULL,
        contractId UNIQUEIDENTIFIER NOT NULL,
        securityId VARCHAR(50) NOT NULL,
        quantity DECIMAL(18,4) NOT NULL,
        price DECIMAL(18,4) NOT NULL,
        market_value DECIMAL(18,2) NOT NULL,
        archival_flag BIT DEFAULT 0 NOT NULL,
        archival_month VARCHAR(6) NULL,
        created_date DATETIME DEFAULT GETDATE(),
        
        CONSTRAINT PK_' + @staging_table_name + ' PRIMARY KEY CLUSTERED (basketId, positionId, businessDate, archival_flag),
        CONSTRAINT CK_' + @staging_table_name + '_archival_flag CHECK (archival_flag = 1)
    ) ON [PRIMARY];
    ';
    
    EXEC sp_executesql @sql;
    PRINT 'Created staging table: ' + @staging_table_name;
END;
GO

PRINT 'Partitioning setup completed for SourceDB1';
GO

-- ========================================
-- Repeat for SourceDB2.Trade
-- ========================================
USE SourceDB2;
GO

IF NOT EXISTS (SELECT * FROM sys.partition_functions WHERE name = 'PF_Trade_ArchivalFlag')
BEGIN
    CREATE PARTITION FUNCTION PF_Trade_ArchivalFlag (BIT)
    AS RANGE RIGHT FOR VALUES (1);
    PRINT 'Created partition function PF_Trade_ArchivalFlag';
END
GO

IF NOT EXISTS (SELECT * FROM sys.partition_schemes WHERE name = 'PS_Trade_ArchivalFlag')
BEGIN
    CREATE PARTITION SCHEME PS_Trade_ArchivalFlag
    AS PARTITION PF_Trade_ArchivalFlag
    ALL TO ([PRIMARY]);
    PRINT 'Created partition scheme PS_Trade_ArchivalFlag';
END
GO

-- Recreate Trade table with partitioning
IF EXISTS (SELECT * FROM sys.tables WHERE name = 'Trade' AND schema_id = SCHEMA_ID('dbo'))
BEGIN
    SELECT * INTO dbo.Trade_Backup FROM dbo.Trade;
    DROP TABLE dbo.Trade;
    PRINT 'Backed up and dropped existing Trade table';
END
GO

CREATE TABLE dbo.Trade (
    tradeId UNIQUEIDENTIFIER NOT NULL,
    contractId UNIQUEIDENTIFIER NOT NULL,
    tradeDate DATE NOT NULL,
    settlementDate DATE NOT NULL,
    trade_type VARCHAR(50) NOT NULL,
    amount DECIMAL(18,4) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    archival_flag BIT DEFAULT 0 NOT NULL,
    archival_month VARCHAR(6) NULL,
    created_date DATETIME DEFAULT GETDATE(),
    
    CONSTRAINT PK_Trade PRIMARY KEY CLUSTERED (tradeId, archival_flag),
    CONSTRAINT FK_Trade_Contract FOREIGN KEY (contractId) REFERENCES dbo.Contract(contractId)
) ON PS_Trade_ArchivalFlag(archival_flag);

CREATE INDEX IDX_Trade_tradeDate ON dbo.Trade(tradeDate);
CREATE INDEX IDX_Trade_contractId ON dbo.Trade(contractId);

PRINT 'Created partitioned Trade table';
GO

IF EXISTS (SELECT * FROM sys.tables WHERE name = 'Trade_Backup' AND schema_id = SCHEMA_ID('dbo'))
BEGIN
    INSERT INTO dbo.Trade SELECT * FROM dbo.Trade_Backup;
    DROP TABLE dbo.Trade_Backup;
    PRINT 'Restored data from backup';
END
GO

-- ========================================
-- Repeat for SourceDB3.PriceHistory
-- ========================================
USE SourceDB3;
GO

IF NOT EXISTS (SELECT * FROM sys.partition_functions WHERE name = 'PF_PriceHistory_ArchivalFlag')
BEGIN
    CREATE PARTITION FUNCTION PF_PriceHistory_ArchivalFlag (BIT)
    AS RANGE RIGHT FOR VALUES (1);
    PRINT 'Created partition function PF_PriceHistory_ArchivalFlag';
END
GO

IF NOT EXISTS (SELECT * FROM sys.partition_schemes WHERE name = 'PS_PriceHistory_ArchivalFlag')
BEGIN
    CREATE PARTITION SCHEME PS_PriceHistory_ArchivalFlag
    AS PARTITION PF_PriceHistory_ArchivalFlag
    ALL TO ([PRIMARY]);
    PRINT 'Created partition scheme PS_PriceHistory_ArchivalFlag';
END
GO

IF EXISTS (SELECT * FROM sys.tables WHERE name = 'PriceHistory' AND schema_id = SCHEMA_ID('dbo'))
BEGIN
    SELECT * INTO dbo.PriceHistory_Backup FROM dbo.PriceHistory;
    DROP TABLE dbo.PriceHistory;
    PRINT 'Backed up and dropped existing PriceHistory table';
END
GO

CREATE TABLE dbo.PriceHistory (
    priceId BIGINT NOT NULL,
    securityId VARCHAR(50) NOT NULL,
    priceDate DATE NOT NULL,
    open_price DECIMAL(18,4),
    close_price DECIMAL(18,4),
    high_price DECIMAL(18,4),
    low_price DECIMAL(18,4),
    volume BIGINT,
    archival_flag BIT DEFAULT 0 NOT NULL,
    archival_month VARCHAR(6) NULL,
    created_date DATETIME DEFAULT GETDATE(),
    
    CONSTRAINT PK_PriceHistory PRIMARY KEY CLUSTERED (priceId, securityId, priceDate, archival_flag),
    CONSTRAINT UQ_PriceHistory UNIQUE (securityId, priceDate, archival_flag)
) ON PS_PriceHistory_ArchivalFlag(archival_flag);

CREATE INDEX IDX_PriceHistory_date ON dbo.PriceHistory(priceDate);
CREATE INDEX IDX_PriceHistory_security ON dbo.PriceHistory(securityId);

PRINT 'Created partitioned PriceHistory table';
GO

IF EXISTS (SELECT * FROM sys.tables WHERE name = 'PriceHistory_Backup' AND schema_id = SCHEMA_ID('dbo'))
BEGIN
    INSERT INTO dbo.PriceHistory SELECT * FROM dbo.PriceHistory_Backup;
    DROP TABLE dbo.PriceHistory_Backup;
    PRINT 'Restored data from backup';
END
GO

PRINT 'All tables partitioned successfully';
