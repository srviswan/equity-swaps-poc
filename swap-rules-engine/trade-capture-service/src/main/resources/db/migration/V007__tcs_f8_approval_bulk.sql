-- F8: approval gate, bulk upload tracking (FR-301/303, FR-504–506)
CREATE TABLE dbo.approval_request (
  approval_request_id BIGINT IDENTITY PRIMARY KEY,
  approval_id         VARCHAR(64)  NOT NULL,
  ingestion_id        UNIQUEIDENTIFIER NOT NULL,
  batch_id            VARCHAR(64)  NULL,
  kind                VARCHAR(16)  NOT NULL,   -- TRADE | BATCH
  status              VARCHAR(16)  NOT NULL DEFAULT 'PENDING', -- PENDING | APPROVED | DENIED
  initiated_by        VARCHAR(64)  NOT NULL,
  publish_mode        VARCHAR(24)  NOT NULL,   -- RAW_ALLOCATION | SWAP_BLOTTER
  blotter_json        NVARCHAR(MAX) NOT NULL,
  edited_fields_diff  NVARCHAR(MAX) NULL,
  respond_by          DATETIME2(3) NOT NULL,
  decided_by          VARCHAR(64)  NULL,
  decided_at          DATETIME2(3) NULL,
  created_at          DATETIME2(3) NOT NULL DEFAULT SYSUTCDATETIME(),
  CONSTRAINT uq_approval_id UNIQUE (approval_id)
);
GO
CREATE INDEX ix_approval_pending ON dbo.approval_request (status, respond_by)
  INCLUDE (batch_id, ingestion_id);
GO

CREATE TABLE dbo.bulk_batch (
  batch_id       VARCHAR(64)  NOT NULL PRIMARY KEY,
  uploaded_by    VARCHAR(64)  NOT NULL,
  uploaded_at    DATETIME2(3) NOT NULL DEFAULT SYSUTCDATETIME(),
  total_rows     INT          NOT NULL,
  valid_rows     INT          NOT NULL DEFAULT 0,
  invalid_rows   INT          NOT NULL DEFAULT 0,
  submitted_rows INT          NOT NULL DEFAULT 0
);
GO

CREATE TABLE dbo.bulk_batch_row (
  batch_row_id   BIGINT IDENTITY PRIMARY KEY,
  batch_id       VARCHAR(64)  NOT NULL,
  row_no         INT          NOT NULL,
  block_id       VARCHAR(64)  NOT NULL,
  status         VARCHAR(24)  NOT NULL DEFAULT 'VALIDATED',
  -- VALIDATED | SUBMITTED | PARKED | APPROVED | BOOKED | FAILED | QUARANTINED | INVALID
  ingestion_id   UNIQUEIDENTIFIER NULL,
  error_detail   NVARCHAR(1000) NULL,
  CONSTRAINT uq_batch_row UNIQUE (batch_id, row_no)
);
GO
CREATE INDEX ix_batch_row ON dbo.bulk_batch_row (batch_id, status);
GO

ALTER TABLE dbo.ingestion_record ADD batch_id VARCHAR(64) NULL;
GO
