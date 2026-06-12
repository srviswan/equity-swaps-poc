-- F7: cross-ref delivery operational columns (retry + poll API helpers)
ALTER TABLE dbo.cross_ref ADD correlation_id VARCHAR(64) NULL;
GO
ALTER TABLE dbo.cross_ref ADD event_type VARCHAR(16) NULL;
GO
ALTER TABLE dbo.cross_ref ADD attempt_count INT NOT NULL CONSTRAINT df_xref_attempt DEFAULT 0;
GO
ALTER TABLE dbo.cross_ref ADD next_attempt_at DATETIME2(3) NOT NULL
  CONSTRAINT df_xref_next DEFAULT SYSUTCDATETIME();
GO
ALTER TABLE dbo.cross_ref ADD last_error NVARCHAR(1000) NULL;
GO
CREATE INDEX ix_xref_pending ON dbo.cross_ref (status, next_attempt_at)
  INCLUDE (to_system, from_system);
GO
