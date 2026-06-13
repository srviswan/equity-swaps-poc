-- Trade Capture Service — F5 routing decisions (FR-304/305/306).
-- Stage-7 SQL commit (arch §5): one row per (trade, target), partitioned on
-- trade_date via the V001 ps_trade_month scheme.

CREATE TABLE dbo.routing_decision (
  decision_id      BIGINT IDENTITY  NOT NULL,
  correlation_id   VARCHAR(64)      NOT NULL,    -- D4: blockId/allocationId/version
  trade_date       DATE             NOT NULL,
  rule_name        VARCHAR(64)      NOT NULL,    -- matched routing-rules.yml rule
  target_id        VARCHAR(32)      NOT NULL,    -- SYSTEM_A | SYSTEM_B | ...
  queue            VARCHAR(128)     NOT NULL,
  event_type       VARCHAR(16)      NOT NULL,    -- NEW | TOP_UP | UNWIND
  match_key        NVARCHAR(1000)   NULL,        -- JSON; null when no lookup (D11)
  position_as_of   DATETIME2(3)     NULL,        -- PS snapshot watermark (audit)
  created_at       DATETIME2(3)     NOT NULL DEFAULT SYSUTCDATETIME(),
  CONSTRAINT pk_routing PRIMARY KEY CLUSTERED (trade_date, decision_id)
    ON ps_trade_month(trade_date),
  CONSTRAINT uq_routing UNIQUE (correlation_id, target_id, trade_date)
    ON ps_trade_month(trade_date)
);
GO
