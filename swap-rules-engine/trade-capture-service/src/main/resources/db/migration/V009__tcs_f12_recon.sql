-- F12 (FR-708): reconciliation run + break persistence.
CREATE TABLE dbo.recon_run (
  run_id              BIGINT IDENTITY PRIMARY KEY,
  recon_type          VARCHAR(8)   NOT NULL,   -- R1 | R2 | R3
  scope_book          VARCHAR(32)  NULL,
  scope_trade_date    DATE         NULL,
  as_of               DATETIME2(3) NOT NULL,
  status              VARCHAR(16)  NOT NULL,   -- RUNNING | COMPLETE | FAILED
  tcs_watermark       DATETIME2(3) NULL,
  downstream_watermark DATETIME2(3) NULL,
  breaks_detected     INT          NOT NULL DEFAULT 0,
  started_at          DATETIME2(3) NOT NULL DEFAULT SYSUTCDATETIME(),
  completed_at        DATETIME2(3) NULL,
  idempotency_key     VARCHAR(128) NOT NULL,
  CONSTRAINT uq_recon_run_idem UNIQUE (idempotency_key)
);
GO

CREATE TABLE dbo.recon_break (
  break_id            BIGINT IDENTITY PRIMARY KEY,
  run_id              BIGINT       NOT NULL,
  break_type          VARCHAR(32)  NOT NULL,
  break_class         VARCHAR(16)  NOT NULL,   -- R1 | R2 | R3
  allocation_id       VARCHAR(64)  NULL,
  swap_ref            VARCHAR(128) NULL,
  lot_ref             VARCHAR(128) NULL,
  tcs_value_json      NVARCHAR(MAX) NULL,
  peer_value_json     NVARCHAR(MAX) NULL,
  status              VARCHAR(24)  NOT NULL DEFAULT 'DETECTED',
  auto_heal_eligible  BIT          NOT NULL DEFAULT 0,
  resolution_note     NVARCHAR(500) NULL,
  resolved_by         VARCHAR(64)  NULL,
  detected_at         DATETIME2(3) NOT NULL DEFAULT SYSUTCDATETIME(),
  resolved_at         DATETIME2(3) NULL,
  CONSTRAINT fk_recon_break_run FOREIGN KEY (run_id) REFERENCES dbo.recon_run(run_id)
);
GO

CREATE INDEX ix_recon_break_run ON dbo.recon_break (run_id, status);
GO
