-- Trade Capture Service — F4 repair workflow (FR-209/300).
-- Extends the V001 repair_quarantine contract with the editable blotter
-- payload and edit audit used by BUSINESS_VALIDATION quarantines.

ALTER TABLE dbo.repair_quarantine ADD
  correlation_id  VARCHAR(64)   NULL,           -- D4 id for blotter quarantines
  payload_json    NVARCHAR(MAX) NULL,           -- editable SwapBlotter payload
  edited_by       VARCHAR(64)   NULL,           -- last ops editor (FR-209 audit)
  edited_at       DATETIME2(3)  NULL;
GO
CREATE INDEX ix_quarantine_work ON dbo.repair_quarantine (status, category)
  INCLUDE (correlation_id);
GO
