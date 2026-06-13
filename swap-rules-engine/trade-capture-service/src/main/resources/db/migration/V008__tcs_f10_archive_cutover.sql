-- F10 (FR-602): archive run tracking + switched partition registry.
CREATE TABLE dbo.archive_run (
  run_id            BIGINT IDENTITY PRIMARY KEY,
  partition_month   DATE         NOT NULL,
  status            VARCHAR(16)  NOT NULL,   -- RUNNING | COMPLETE | FAILED
  rows_archived     BIGINT       NULL,
  started_at        DATETIME2(3) NOT NULL DEFAULT SYSUTCDATETIME(),
  completed_at      DATETIME2(3) NULL,
  preflight_json    NVARCHAR(MAX) NULL
);
GO

CREATE TABLE dbo.archived_partition (
  partition_month   DATE         NOT NULL PRIMARY KEY,
  archive_run_id    BIGINT       NOT NULL,
  switched_at       DATETIME2(3) NOT NULL DEFAULT SYSUTCDATETIME(),
  CONSTRAINT fk_archived_partition_run FOREIGN KEY (archive_run_id) REFERENCES dbo.archive_run(run_id)
);
GO
