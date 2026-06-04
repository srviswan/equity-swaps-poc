-- ============================================================================
-- Archival engine control schema.
-- Configuration and run-state live as DATA here so the deployable jar stays
-- stateless and "what to archive" can change with zero redeploy.
-- ============================================================================

-- ---------------------------------------------------------------------------
-- Job: one named archival configuration.
-- ---------------------------------------------------------------------------
CREATE TABLE archive_job (
    job_name              VARCHAR(64)   NOT NULL,
    topology              VARCHAR(20)   NOT NULL,  -- SAME_DB | CROSS_DB | CROSS_SERVER
    retention_months      INT           NOT NULL DEFAULT 13,   -- dormancy before eligible
    archive_retention_yrs INT           NOT NULL DEFAULT 7,     -- purge from archive after N yrs
    default_batch_size    INT           NOT NULL DEFAULT 50000,
    min_batch_size        INT           NOT NULL DEFAULT 5000,
    max_batch_size        INT           NOT NULL DEFAULT 200000,
    log_used_pct_pause    INT           NOT NULL DEFAULT 70,    -- pause when log used % above this
    ag_redo_queue_pause   BIGINT        NOT NULL DEFAULT 5000000, -- pause when secondary behind (KB)
    may_issue_log_backup  BIT           NOT NULL DEFAULT 0,
    max_parallel_workers  INT           NOT NULL DEFAULT 1,      -- 1 = single stream; >1 = basket-sharded
    -- Break-glass: flip run_signal to PAUSE/STOP from any SQL client to halt the engine cleanly at
    -- the next safe (committed) boundary. RUN = normal.
    run_signal            VARCHAR(10)   NOT NULL DEFAULT 'RUN',  -- RUN | PAUSE | STOP
    signal_reason         NVARCHAR(400) NULL,
    signal_by             VARCHAR(128)  NULL,
    signal_at             DATETIME2     NULL,
    enabled               BIT           NOT NULL DEFAULT 1,
    created_at            DATETIME2     NOT NULL DEFAULT SYSUTCDATETIME(),
    CONSTRAINT pk_archive_job PRIMARY KEY (job_name)
);

-- ---------------------------------------------------------------------------
-- Tables in scope for a job. dependency_level drives FK ordering:
--   delete order   = highest level (children) -> lowest (parents)
--   restore order  = lowest level  (parents)  -> highest (children)
-- ---------------------------------------------------------------------------
CREATE TABLE archive_table (
    job_name              VARCHAR(64)   NOT NULL,
    source_schema         VARCHAR(128)  NOT NULL,
    source_table          VARCHAR(128)  NOT NULL,
    target_schema         VARCHAR(128)  NOT NULL,
    target_table          VARCHAR(128)  NOT NULL,
    dependency_level      INT           NOT NULL,  -- 0 = parent, larger = child
    -- Generic, per-table selection. join_columns are the source columns matched against the
    -- per-chunk key set (e.g. 'basket_key', 'swap_key', or composite 'basket_key,business_date_key').
    join_columns          VARCHAR(256)  NOT NULL,
    -- DIRECT  = table carries the basket key; join straight to the eligible-basket worklist.
    -- BRIDGE  = resolve eligible baskets -> this table's keys via a mapping table, then join.
    key_resolution        VARCHAR(10)   NOT NULL DEFAULT 'DIRECT',
    bridge_table          VARCHAR(256)  NULL,      -- BRIDGE: e.g. dbo.DimSwap (must be indexed on basket col)
    bridge_basket_column  VARCHAR(128)  NULL,      -- BRIDGE: basket key column on the bridge
    bridge_join_columns   VARCHAR(256)  NULL,      -- BRIDGE: key columns on the bridge (match join_columns)
    business_date_column  VARCHAR(128)  NULL,      -- real date column on the fact row (partition derivation)
    copy_strategy         VARCHAR(20)   NOT NULL,  -- SAME_DB | CROSS_DB | CROSS_SERVER
    disable_target_indexes BIT          NOT NULL DEFAULT 0,
    checksum_verify       BIT           NOT NULL DEFAULT 1,
    schema_mode           VARCHAR(10)   NOT NULL DEFAULT 'AUTO',   -- AUTO | STRICT
    storage_format        VARCHAR(20)   NOT NULL DEFAULT 'ROWSTORE_PAGE', -- ROWSTORE_PAGE | CCI
    -- Partitioning: a SINGLE derived column. ARCHIVED_PERIOD aligns with "purge N years from
    -- archived date"; BUSINESS_DATE aligns with data-age queries (then retention purge no longer
    -- maps 1:1 to a partition SWITCH). The unique clustered index MUST contain this column.
    partition_strategy    VARCHAR(20)   NOT NULL DEFAULT 'ARCHIVED_PERIOD', -- ARCHIVED_PERIOD | BUSINESS_DATE | NONE
    partition_granularity VARCHAR(10)   NOT NULL DEFAULT 'MONTH',  -- MONTH | QUARTER | YEAR
    restorable            BIT           NOT NULL DEFAULT 1,
    column_map_json       NVARCHAR(MAX) NULL,       -- optional include/exclude/rename
    enabled               BIT           NOT NULL DEFAULT 1,
    CONSTRAINT pk_archive_table PRIMARY KEY (job_name, source_schema, source_table),
    CONSTRAINT fk_archive_table_job FOREIGN KEY (job_name) REFERENCES archive_job (job_name)
);
CREATE INDEX ix_archive_table_order ON archive_table (job_name, dependency_level);

-- ---------------------------------------------------------------------------
-- Run windows: when the engine is allowed to work, by day of week.
-- ---------------------------------------------------------------------------
CREATE TABLE archive_window (
    job_name        VARCHAR(64)   NOT NULL,
    day_of_week     TINYINT       NOT NULL,  -- 1=Sun .. 7=Sat (matches DATEPART(weekday))
    start_time      TIME(0)       NOT NULL,
    end_time        TIME(0)       NOT NULL,
    max_duration_mins INT         NULL,
    batch_size_cap  INT           NULL,
    CONSTRAINT pk_archive_window PRIMARY KEY (job_name, day_of_week),
    CONSTRAINT fk_archive_window_job FOREIGN KEY (job_name) REFERENCES archive_job (job_name)
);

-- ---------------------------------------------------------------------------
-- Basket lifecycle state. One row per basket. Eligibility is computed from
-- this (policy lives in archive_job), never as a per-row flag on fact tables.
-- ---------------------------------------------------------------------------
CREATE TABLE basket_archive_state (
    basket_key       BIGINT        NOT NULL,
    termination_date DATE          NULL,
    status           VARCHAR(16)   NOT NULL,  -- ACTIVE | TERMINATED | NEEDS_REVIEW | ELIGIBLE | ARCHIVED
    archived         BIT           NOT NULL DEFAULT 0,
    archive_batch_id BIGINT        NULL,
    archived_at_utc  DATETIME2     NULL,
    last_refreshed_at DATETIME2    NOT NULL DEFAULT SYSUTCDATETIME(),
    CONSTRAINT pk_basket_archive_state PRIMARY KEY (basket_key)
);
CREATE INDEX ix_basket_state_eligibility ON basket_archive_state (status, archived, termination_date);

-- ---------------------------------------------------------------------------
-- Run header: one row per engine invocation.
-- ---------------------------------------------------------------------------
CREATE TABLE archive_run (
    run_id           BIGINT        IDENTITY(1,1) NOT NULL,
    job_name         VARCHAR(64)   NOT NULL,
    as_of_date       DATE          NOT NULL,
    mode             VARCHAR(16)   NOT NULL,  -- ARCHIVE | RESTORE | DRY_RUN
    status           VARCHAR(16)   NOT NULL,  -- RUNNING | PAUSED | DONE | FAILED
    started_at_utc   DATETIME2     NOT NULL DEFAULT SYSUTCDATETIME(),
    ended_at_utc     DATETIME2     NULL,
    baskets_selected INT           NULL,
    rows_copied      BIGINT        NULL,
    rows_deleted     BIGINT        NULL,
    error_text       NVARCHAR(MAX) NULL,
    CONSTRAINT pk_archive_run PRIMARY KEY (run_id),
    CONSTRAINT fk_archive_run_job FOREIGN KEY (job_name) REFERENCES archive_job (job_name)
);

-- ---------------------------------------------------------------------------
-- Worklist: eligible baskets for a run. chunk_no is assigned at RUNTIME when a
-- basket enters a chunk, so the adaptive controller can resize chunks mid-run.
-- A crash leaves IN_PROGRESS rows that the next run reclaims first (restart).
-- ---------------------------------------------------------------------------
CREATE TABLE archive_worklist (
    run_id           BIGINT        NOT NULL,
    basket_key       BIGINT        NOT NULL,
    chunk_no         INT           NULL,                -- assigned when the basket enters a chunk
    worker_id        INT           NOT NULL DEFAULT 0,  -- shard owner when max_parallel_workers > 1
    status           VARCHAR(12)   NOT NULL DEFAULT 'PENDING', -- PENDING|IN_PROGRESS|DONE|FAILED
    CONSTRAINT pk_archive_worklist PRIMARY KEY (run_id, basket_key),
    CONSTRAINT fk_worklist_run FOREIGN KEY (run_id) REFERENCES archive_run (run_id)
);
CREATE INDEX ix_worklist_next  ON archive_worklist (run_id, status, basket_key);
CREATE INDEX ix_worklist_chunk ON archive_worklist (run_id, chunk_no);

-- ---------------------------------------------------------------------------
-- Per-chunk-per-table audit + checkpoint. State machine for cross-server safety.
-- ---------------------------------------------------------------------------
CREATE TABLE archive_chunk_log (
    run_id           BIGINT        NOT NULL,
    chunk_no         INT           NOT NULL,
    source_table     VARCHAR(256)  NOT NULL,
    state            VARCHAR(12)   NOT NULL,  -- PENDING|COPIED|VERIFIED|DELETED|DONE|FAILED
    rows_copied      BIGINT        NULL,
    rows_deleted     BIGINT        NULL,
    source_checksum  BIGINT        NULL,
    target_checksum  BIGINT        NULL,
    log_used_pct     INT           NULL,
    ag_redo_queue_kb BIGINT        NULL,
    duration_ms      BIGINT        NULL,
    retry_count      INT           NOT NULL DEFAULT 0,
    error_text       NVARCHAR(MAX) NULL,
    updated_at_utc   DATETIME2     NOT NULL DEFAULT SYSUTCDATETIME(),
    CONSTRAINT pk_archive_chunk_log PRIMARY KEY (run_id, chunk_no, source_table),
    CONSTRAINT fk_chunk_log_run FOREIGN KEY (run_id) REFERENCES archive_run (run_id)
);

-- ---------------------------------------------------------------------------
-- Audit of automatic (additive) target schema changes.
-- ---------------------------------------------------------------------------
CREATE TABLE archive_schema_audit (
    audit_id        BIGINT        IDENTITY(1,1) NOT NULL,
    target_table    VARCHAR(256)  NOT NULL,
    ddl_applied     NVARCHAR(MAX) NOT NULL,
    applied_at_utc  DATETIME2     NOT NULL DEFAULT SYSUTCDATETIME(),
    CONSTRAINT pk_archive_schema_audit PRIMARY KEY (audit_id)
);

-- ---------------------------------------------------------------------------
-- Audit of restore operations (into the investigation DB).
-- ---------------------------------------------------------------------------
CREATE TABLE archive_restore_log (
    restore_id      BIGINT        IDENTITY(1,1) NOT NULL,
    basket_key      BIGINT        NULL,
    archive_batch_id BIGINT       NULL,
    target_db       VARCHAR(256)  NOT NULL,
    rows_restored   BIGINT        NULL,
    requested_by    VARCHAR(128)  NULL,
    status          VARCHAR(16)   NOT NULL,
    started_at_utc  DATETIME2     NOT NULL DEFAULT SYSUTCDATETIME(),
    ended_at_utc    DATETIME2     NULL,
    CONSTRAINT pk_archive_restore_log PRIMARY KEY (restore_id)
);
