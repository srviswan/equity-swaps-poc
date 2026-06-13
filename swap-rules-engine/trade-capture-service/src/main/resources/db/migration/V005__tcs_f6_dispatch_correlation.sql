-- F6: correlation_id on dispatch_record for ops queries and executor envelope rebuild
-- without joining ingestion_record on every claim.

ALTER TABLE dbo.dispatch_record ADD correlation_id VARCHAR(64) NULL;
GO
CREATE INDEX ix_disp_corr ON dbo.dispatch_record (correlation_id)
  INCLUDE (destination_id, status);
GO
