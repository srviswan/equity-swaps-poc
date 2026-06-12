-- Trade Capture Service — F0 schema contract (spec §F0.3).
-- Monthly partitioning on trade_date, sliding window current + 2 hot.

CREATE PARTITION FUNCTION pf_trade_month (date)
  AS RANGE RIGHT FOR VALUES ('2026-06-01','2026-07-01','2026-08-01');
GO
CREATE PARTITION SCHEME ps_trade_month
  AS PARTITION pf_trade_month ALL TO ([PRIMARY]);
GO

CREATE TABLE dbo.ingestion_record (
  ingestion_id        UNIQUEIDENTIFIER NOT NULL DEFAULT NEWSEQUENTIALID(),
  block_id            VARCHAR(64)  NOT NULL,
  allocation_id       VARCHAR(64)  NOT NULL DEFAULT '',   -- '' for BLOCK
  version             INT          NOT NULL,
  gcam_message_id     VARCHAR(128) NOT NULL,
  allocation_type     VARCHAR(8)   NOT NULL,              -- BLOCK | SWAP
  source_system       VARCHAR(16)  NOT NULL,              -- GCAM | MANUAL | TEST_HARNESS
  entry_mode          VARCHAR(16)  NOT NULL DEFAULT 'ALLOCATION', -- ALLOCATION | MANUAL_BLOTTER
  initiated_by        VARCHAR(64)  NOT NULL DEFAULT 'SYSTEM',     -- stage-5.5 STP input
  preview_hash        VARCHAR(64)  NULL,                  -- manual blotter mode (audit)
  approval_id         VARCHAR(64)  NULL,                  -- set when parked/approved
  sequence_key_hash   BIGINT       NOT NULL,
  book                VARCHAR(32)  NOT NULL,
  account_id          VARCHAR(64)  NOT NULL,              -- client acct or wash book
  security_id         VARCHAR(64)  NOT NULL,
  trade_date          DATE         NOT NULL,
  status              VARCHAR(24)  NOT NULL,              -- state machine: spec §F0.3
  supersedes_version  INT          NULL,                  -- D9 audit only
  raw_proto           VARBINARY(MAX) NOT NULL,
  correlation_id      VARCHAR(64)  NOT NULL,
  received_at         DATETIME2(3) NOT NULL DEFAULT SYSUTCDATETIME(),
  acked_at            DATETIME2(3) NULL,
  CONSTRAINT pk_ingestion PRIMARY KEY CLUSTERED (trade_date, ingestion_id)
    ON ps_trade_month(trade_date),
  CONSTRAINT uq_idem UNIQUE (block_id, allocation_id, version, trade_date)
    ON ps_trade_month(trade_date)
);
GO
CREATE INDEX ix_ing_seqkey   ON dbo.ingestion_record (sequence_key_hash, received_at) ON ps_trade_month(trade_date);
CREATE INDEX ix_ing_gcam_msg ON dbo.ingestion_record (gcam_message_id)                ON ps_trade_month(trade_date);
GO

CREATE TABLE dbo.enriched_allocation (
  ingestion_id     UNIQUEIDENTIFIER NOT NULL,
  trade_date       DATE          NOT NULL,
  security_ref     NVARCHAR(MAX) NOT NULL,   -- JSON snapshot of resolved ref data
  client_ref       NVARCHAR(MAX) NULL,
  book_ref         NVARCHAR(MAX) NOT NULL,
  wash_book_ref    NVARCHAR(MAX) NULL,
  enriched_payload NVARCHAR(MAX) NOT NULL,   -- full EnrichedAllocationMessage JSON
  enriched_at      DATETIME2(3)  NOT NULL DEFAULT SYSUTCDATETIME(),
  CONSTRAINT pk_enriched PRIMARY KEY CLUSTERED (trade_date, ingestion_id)
    ON ps_trade_month(trade_date)
);
GO

CREATE TABLE dbo.audit_reject (        -- pre-ACK NACKs (structural / mandatory / ref-data)
  reject_id       BIGINT IDENTITY PRIMARY KEY,
  gcam_message_id VARCHAR(128) NOT NULL,
  block_id        VARCHAR(64)  NULL,
  allocation_id   VARCHAR(64)  NULL,
  version         INT          NULL,
  stage           VARCHAR(24)  NOT NULL,     -- STRUCTURAL | MANDATORY | REFDATA
  reason          NVARCHAR(1000) NOT NULL,
  attempt         INT          NOT NULL,
  raw_proto       VARBINARY(MAX) NOT NULL,
  rejected_at     DATETIME2(3) NOT NULL DEFAULT SYSUTCDATETIME()
);
GO

CREATE TABLE dbo.repair_quarantine (
  quarantine_id   BIGINT IDENTITY PRIMARY KEY,
  ingestion_id    UNIQUEIDENTIFIER NULL,     -- null if quarantined pre-persist
  gcam_message_id VARCHAR(128) NOT NULL,
  category        VARCHAR(32)  NOT NULL,     -- REFDATA_EXHAUSTED | VERSION_GAP | BUSINESS_VALIDATION
  detail          NVARCHAR(MAX) NOT NULL,
  raw_proto       VARBINARY(MAX) NULL,
  status          VARCHAR(16)  NOT NULL DEFAULT 'OPEN', -- OPEN | REPROCESSED | DISCARDED
  created_at      DATETIME2(3) NOT NULL DEFAULT SYSUTCDATETIME(),
  resolved_at     DATETIME2(3) NULL,
  resolved_by     VARCHAR(64)  NULL
);
GO

CREATE TABLE dbo.version_gap_hold (    -- DB-backed buffer: survives restart
  hold_id          BIGINT IDENTITY PRIMARY KEY,
  block_id         VARCHAR(64)  NOT NULL,
  allocation_id    VARCHAR(64)  NOT NULL,
  held_version     INT          NOT NULL,
  expected_version INT          NOT NULL,
  book             VARCHAR(32)  NOT NULL,
  deadline_at      DATETIME2(3) NOT NULL,
  raw_proto        VARBINARY(MAX) NOT NULL,
  CONSTRAINT uq_hold UNIQUE (block_id, allocation_id, held_version)
);
GO

-- F6 (DDL fixed now as part of the F0 contract): per-target dispatch state
CREATE TABLE dbo.dispatch_record (
  dispatch_id      BIGINT IDENTITY PRIMARY KEY,
  ingestion_id     UNIQUEIDENTIFIER NOT NULL,
  destination_id   VARCHAR(32)  NOT NULL,    -- SYSTEM_A | SYSTEM_B | CONTRACT_SVC | ...
  status           VARCHAR(16)  NOT NULL DEFAULT 'PENDING',
                   -- PENDING | CLAIMED | SENT | FAILED  (claim-batch executor)
  attempt_count    INT          NOT NULL DEFAULT 0,
  next_attempt_at  DATETIME2(3) NOT NULL DEFAULT SYSUTCDATETIME(),
  last_error       NVARCHAR(1000) NULL,
  envelope_hash    VARCHAR(64)  NULL,        -- payload integrity / resend dedup
  sent_at          DATETIME2(3) NULL,
  created_at       DATETIME2(3) NOT NULL DEFAULT SYSUTCDATETIME(),
  CONSTRAINT uq_dispatch UNIQUE (ingestion_id, destination_id)
);
GO
CREATE INDEX ix_disp_claim ON dbo.dispatch_record (status, next_attempt_at)
  INCLUDE (destination_id);
GO

-- F6/F7 (fixed now): business ACK is a separate table, never a dispatch status (D14)
CREATE TABLE dbo.business_ack (
  business_ack_id  BIGINT IDENTITY PRIMARY KEY,
  dispatch_id      BIGINT       NOT NULL,    -- FK dispatch_record
  system_id        VARCHAR(32)  NOT NULL,
  status           VARCHAR(16)  NOT NULL,    -- BOOKED | REJECTED
  swap_ref         VARCHAR(64)  NULL,
  lot_refs         NVARCHAR(MAX) NULL,       -- JSON [{lotId, action, qty}]
  reject_reason    NVARCHAR(1000) NULL,
  ack_payload      NVARCHAR(MAX) NOT NULL,   -- raw, for audit
  acked_at         DATETIME2(3) NOT NULL,
  received_at      DATETIME2(3) NOT NULL DEFAULT SYSUTCDATETIME(),
  CONSTRAINT uq_back UNIQUE (dispatch_id)    -- one business ACK per dispatch
);
GO

-- F7 (DDL fixed now as part of the F0 contract): bidirectional cross-ref
CREATE TABLE dbo.cross_ref (
  cross_ref_id     BIGINT IDENTITY PRIMARY KEY,
  ingestion_id     UNIQUEIDENTIFIER NOT NULL,
  from_system      VARCHAR(16) NOT NULL,   -- whose refs are delivered
  to_system        VARCHAR(16) NOT NULL,   -- who receives them
  swap_ref         VARCHAR(64) NULL,
  lot_refs         NVARCHAR(MAX) NULL,     -- JSON; includes unwind lot IDs A→B
  status           VARCHAR(16) NOT NULL DEFAULT 'PENDING',  -- PENDING | DELIVERED | FAILED
  delivered_at     DATETIME2(3) NULL,
  CONSTRAINT uq_xref UNIQUE (ingestion_id, from_system, to_system)
);
GO
