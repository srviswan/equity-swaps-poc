-- Trade Capture Service — F3 blotter & rule-explain persistence (FR-204/207).
-- Hot tables: partitioned on trade_date via the V001 ps_trade_month scheme.

CREATE TABLE dbo.swap_blotter (
  blotter_id       BIGINT IDENTITY  NOT NULL,
  correlation_id   VARCHAR(64)      NOT NULL,    -- D4: blockId/allocationId/version
  block_id         VARCHAR(64)      NOT NULL,
  allocation_id    VARCHAR(64)      NOT NULL DEFAULT '',
  version          INT              NOT NULL,
  allocation_type  VARCHAR(8)       NOT NULL,    -- BLOCK | SWAP
  book             VARCHAR(32)      NOT NULL,
  account_id       VARCHAR(64)      NOT NULL,
  security_id      VARCHAR(64)      NOT NULL,
  trade_date       DATE             NOT NULL,
  snapshot_version VARCHAR(128)     NOT NULL,    -- rule snapshot used (audit / replay)
  blotter_json     NVARCHAR(MAX)    NOT NULL,    -- full SwapBlotter payload (provisional E9)
  status           VARCHAR(24)      NOT NULL DEFAULT 'ASSEMBLED',
                   -- ASSEMBLED | VALIDATED | ROUTED | DISPATCHED (F4+ advance this)
  created_at       DATETIME2(3)     NOT NULL DEFAULT SYSUTCDATETIME(),
  CONSTRAINT pk_blotter PRIMARY KEY CLUSTERED (trade_date, blotter_id)
    ON ps_trade_month(trade_date),
  CONSTRAINT uq_blotter UNIQUE (correlation_id, trade_date)
    ON ps_trade_month(trade_date)
);
GO
CREATE INDEX ix_blotter_block ON dbo.swap_blotter (block_id, allocation_id, version)
  ON ps_trade_month(trade_date);
GO

CREATE TABLE dbo.rule_explain (
  explain_id       BIGINT IDENTITY  NOT NULL,
  correlation_id   VARCHAR(64)      NOT NULL,
  trade_date       DATE             NOT NULL,
  seq              INT              NOT NULL,    -- engine decision order
  rule_id          VARCHAR(64)      NOT NULL,    -- 'UNRESOLVED' when no rule matched a target
  rule_version     INT              NOT NULL,
  category         VARCHAR(16)      NOT NULL DEFAULT '',
  target           VARCHAR(32)      NOT NULL,
  narrative        NVARCHAR(2000)   NOT NULL,    -- FR-207 plain-language explain
  created_at       DATETIME2(3)     NOT NULL DEFAULT SYSUTCDATETIME(),
  CONSTRAINT pk_explain PRIMARY KEY CLUSTERED (trade_date, explain_id)
    ON ps_trade_month(trade_date),
  CONSTRAINT uq_explain UNIQUE (correlation_id, seq, trade_date)
    ON ps_trade_month(trade_date)
);
GO
