# Trade Capture Service — F0/F1 Component Specification

Detailed build spec for **F0** (contracts, schema, topology, config) and
**F1** (ingress pipeline through enriched persist + GCAM ACK/NACK).

Parent document: [trade-capture-architecture.md](trade-capture-architecture.md).
Decision references (D1–D22) resolve against the decision register there.

---

## F0.1 Proto contract

Single envelope for all ingress sources (GCAM, manual, test harness, approval
resumes). The payload kind decides the pipeline entry stage (D17):
`allocation` → stage 1, `manual_blotter` → stage 5.5 (approval gate),
`approval_resume` → stage 6.

```protobuf
syntax = "proto3";
package tcs.allocation.v1;

enum AllocationType { ALLOCATION_TYPE_UNSPECIFIED = 0; BLOCK = 1; SWAP = 2; }
enum SourceSystem   { SOURCE_UNSPECIFIED = 0; GCAM = 1; MANUAL = 2; TEST_HARNESS = 3; }

message TcsIngressMessage {
  string   message_id   = 1;
  SourceSystem source   = 2;
  // Partition key components duplicated at envelope level so the publisher
  // sets the Solace partition key without parsing the payload.
  string book           = 3;
  string account_id     = 4;   // client account (SWAP) or wash book (BLOCK/manual)
  string security_id    = 5;
  string initiated_by   = 6;   // user/system id; input to the stage-5.5 STP check

  oneof payload {
    AllocationMessage   allocation      = 10;
    SwapBlotterPayload  manual_blotter  = 11;
    ApprovalResume      approval_resume = 12;
  }
}

// Published by tc-approval when the Approval Service returns Approved.
// Re-enters the partitioned queue (same key) so the parked trade resumes
// at stage 6 serialized in key order.
message ApprovalResume {
  string ingestion_id   = 1;   // parked trade
  string approval_id    = 2;
  string approved_by    = 3;
  string approved_at_utc = 4;
}

message AllocationMessage {
  // --- identity & ordering ---
  string   block_id        = 1;
  string   allocation_id   = 2;   // empty for pure BLOCK
  int32    version         = 3;   // monotonic per (block_id, allocation_id)
  string   gcam_message_id = 4;   // transport-level dedup
  int64    key_sequence    = 5;   // RESERVED: per-sequence-key counter if GCAM agrees; 0 = absent
  AllocationType type      = 6;
  SourceSystem   source    = 7;

  // --- sequence key components ---
  string book              = 10;
  string client_account    = 11;  // SWAP only
  string security_id       = 12;
  // wash book derived in-pipeline (ClientAccount + B2BLeg + Exchange), never sent by GCAM

  // --- economics (subset; full list from GCAM mapping workbook) ---
  string trade_date        = 20;  // ISO-8601
  string settlement_date   = 21;
  double quantity          = 22;
  string direction         = 23;
  string exchange          = 24;
  string asset_type        = 25;
  bool   b2b_leg           = 26;
  string client_master_no  = 27;
  string location          = 28;
  map<string, string> extended_attributes = 40;  // forward-compat overflow

  // --- envelope ---
  string published_at_utc  = 50;
  int32  schema_version    = 51;
}

message SwapBlotterPayload {
  string blotter_id        = 1;
  string preview_hash      = 2;   // hash of approved preview (audit)
  string approved_by       = 3;
  string approval_id       = 4;
  bytes  blotter_json      = 5;   // full SwapBlotter incl. swapDataProduct
  string trade_date        = 6;
  int32  schema_version    = 7;
}
```

Contract rules:

- Same schema for BLOCK and SWAP (D8); discriminator = `type`.
- `version` is the **only** ordering field the consumer trusts today.
- `key_sequence` is pre-wired: if GCAM grants a per-key counter, full gap
  detection turns on via config (`gapDetection.useKeySequence`) — no proto or
  code change.
- Open with GCAM team: GCAM publishes `TcsIngressMessage{allocation}`
  directly, or TCS wraps bare `AllocationMessage` at the consumer edge.

---

## F0.2 Solace topology

| Object | Name | Config |
|--------|------|--------|
| Inbound topic | `tcs/allocation/in/v1` | GCAM + manual + test harness publish here |
| Partitioned queue | `Q.TCS.ALLOCATION.IN` | subscribes topic; **128 partitions**; partition key header = `hash(book, account_id, security_id)` set by publisher |
| Inbound DLQ | `Q.TCS.ALLOCATION.DLQ` | max-redelivery 3 → DLQ |
| Outbound (F6+) | `tcs/booking/out/{system}/v1` | per dispatch target |
| Business ACK (F6+) | `Q.TCS.BUSINESSACK.{SYSTEM}` | response queues |
| Cross-ref push (F7) | `tcs/crossref/out/{system}/v1` | bidirectional notifications |
| Cache invalidation (F2) | `tcs/refdata/invalidate/v1` | fan-out to all instances |

Consumer settings:

- Client-ACK mode; ACK/NACK explicit per the matrix in F1.2.
- Prefetch window 50 (one slow key must not starve the partition).
- One active consumer per partition (exclusive or partition-sticky shared).
- Manual publisher sets the **identical** partition key formula — manual
  trades compete fairly in per-key order with GCAM traffic.

---

## F0.3 SQL Server DDL (F0/F1 tables)

```sql
-- Partition infra: monthly on trade_date, sliding window current + 2 hot
CREATE PARTITION FUNCTION pf_trade_month (date)
  AS RANGE RIGHT FOR VALUES ('2026-06-01','2026-07-01','2026-08-01');
CREATE PARTITION SCHEME ps_trade_month
  AS PARTITION pf_trade_month ALL TO ([PRIMARY]);

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
  status              VARCHAR(24)  NOT NULL,              -- state machine below
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
CREATE INDEX ix_ing_seqkey   ON dbo.ingestion_record (sequence_key_hash, received_at) ON ps_trade_month(trade_date);
CREATE INDEX ix_ing_gcam_msg ON dbo.ingestion_record (gcam_message_id)                ON ps_trade_month(trade_date);

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

CREATE TABLE dbo.repair_quarantine (
  quarantine_id   BIGINT IDENTITY PRIMARY KEY,
  ingestion_id    UNIQUEIDENTIFIER NULL,     -- null if quarantined pre-persist
  gcam_message_id VARCHAR(128) NOT NULL,
  category        VARCHAR(32)  NOT NULL,     -- REFDATA_EXHAUSTED | VERSION_GAP | BUSINESS_VALIDATION | STALE_APPROVAL
  detail          NVARCHAR(MAX) NOT NULL,
  raw_proto       VARBINARY(MAX) NULL,
  status          VARCHAR(16)  NOT NULL DEFAULT 'OPEN', -- OPEN | REPROCESSED | DISCARDED
  created_at      DATETIME2(3) NOT NULL DEFAULT SYSUTCDATETIME(),
  resolved_at     DATETIME2(3) NULL,
  resolved_by     VARCHAR(64)  NULL
);

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
```

### `ingestion_record.status` state machine

```
ALLOCATION mode:
  RECEIVED → VALIDATED → ENRICHED_ACKED                 (terminal for F1)
  RECEIVED → REJECTED_STRUCTURAL | REJECTED_REFDATA      (audit row; ingestion row optional)
  ENRICHED_ACKED → … (F3+: rules → stage-5.5 gate:
        STP      → BLOTTER_READY → QUEUED → DISPATCHING
                   → SENT | PARTIALLY_SENT | FAILED
        NOT STP  → PENDING_APPROVAL → (Approved, via APPROVAL_RESUME)
                   → BLOTTER_READY → QUEUED → …
                 → APPROVAL_DENIED (terminal, audited)
        )
  any → QUARANTINED

MANUAL_BLOTTER mode (enters at stage-5.5 gate; no GCAM ACK semantics):
  RECEIVED → (gate: STP → BLOTTER_VALIDATED | NOT STP → PENDING_APPROVAL → …)
           → BLOTTER_READY → QUEUED → …
  Solace ACK after the gate-outcome persist (PENDING_APPROVAL or
  BLOTTER_VALIDATED), whichever occurs.

APPROVAL_RESUME kind: not a new ingestion_record — transitions the referenced
parked record PENDING_APPROVAL → BLOTTER_READY; idempotent (duplicate resume
for a record not in PENDING_APPROVAL → ACK + skip).
```

---

## F0.4 Configuration files

```yaml
# reorder-buffer.yml — version-gap policy ONLY (D2/D18)
defaults:
  versionGapTimeoutMs: 45000
  maxHeldPerAllocation: 16
  onTimeout: QUARANTINE
books:
  EQ_US_HY: { versionGapTimeoutMs: 90000 }
  EQ_EU:    { versionGapTimeoutMs: 30000 }
```

```yaml
# ingress.yml
solace:
  queue: Q.TCS.ALLOCATION.IN
  partitions: 128
  prefetch: 50
refdataRetry:
  maxAttempts: 3            # D6/D22
  backoffMs: [1000, 5000, 15000]
gapDetection:
  useKeySequence: false      # flip when GCAM delivers key_sequence
```

```yaml
# cache-policy.yml — consumed in F2; checked in at F0 as a contract (D16)
entities:
  security:
    staticFields:   { mode: CACHE, ttl: 4h,  invalidation: event }
    statusFields:   { mode: READ_THROUGH }
  clientAccount:
    staticFields:   { mode: CACHE, ttl: 1h,  invalidation: event }
    eligibility:    { mode: CACHE, ttl: 30s }
  book:             { mode: CACHE, ttl: 4h,  invalidation: event }
  washBook:         { mode: CACHE, ttl: 1h,  invalidation: event }
```

```yaml
# position-match-key.yml — consumed in F5; checked in at F0 as a contract (D10)
default:
  fields: [book, clientAccount, security, direction]
systems:
  SYSTEM_A:
    explicitEventType: false
    positionLookup: NEVER
    matchKey: default
  SYSTEM_B:
    explicitEventType: true
    positionLookup: BEFORE_ROUTE
    matchKey:
      fields: [book, clientAccount, security, direction, swapStructure]
```

---

## F1.1 Module layout

```
tc-ingress/
├── SolacePartitionConsumer        // client-ACK, partition-bound
│   └── routes on payload kind:
│       ALLOCATION      → IngressPipeline.fromStage1()
│       MANUAL_BLOTTER  → IngressPipeline.fromGate()     (stage 5.5; wired in F8)
│       APPROVAL_RESUME → IngressPipeline.resumeFromStage6() (wired in F8)
├── IdempotencyGate                // uq_idem probe; ALLOCATION dedup on
│                                  // (block_id, allocation_id, version);
│                                  // MANUAL_BLOTTER dedup on blotter_id;
│                                  // APPROVAL_RESUME idempotent on (ingestion_id, approval_id)
├── VersionGapBuffer               // ALLOCATION only; DB-backed (version_gap_hold)
│   ├── onArrival(msg): PROCESS | HOLD | DUPLICATE
│   └── GapTimeoutSweeper          // scheduled 5s; deadline → quarantine + alert
├── AckNackController              // single owner of Solace ACK/NACK decisions
└── IngressMetrics

tc-validation/
├── ProtoStructuralValidator       // parse + schema_version gate
└── MandatoryFieldValidator        // per allocation_type field sets

tc-reference/                      // F1 ships interface + direct (no-cache) impl
├── ReferenceDataProxy (interface) // Caffeine/Redis impls arrive in F2
├── DirectLookupProxy              // read-through everything until F2
└── WashBookResolver               // ClientAccount + b2b_leg + exchange rule
```

---

## F1.2 ACK/NACK decision matrix (authoritative)

| Event | Solace action | DB action |
|-------|---------------|-----------|
| Duplicate idempotency key (status ≥ ENRICHED_ACKED) | **ACK** | none |
| Proto unparseable / schema mismatch | **NACK** (→ DLQ after redelivery 3) | `audit_reject(STRUCTURAL)` |
| Mandatory field missing | **NACK** | `audit_reject(MANDATORY)` |
| Ref-data miss, attempts 1–2 | **NACK** (redeliver, backoff) | `audit_reject(REFDATA, attempt=n)` |
| Ref-data miss, attempt 3 | **ACK** | `repair_quarantine(REFDATA_EXHAUSTED)` — ACK so GCAM stops retrying; trade is now TCS-owned |
| Version gap detected | **ACK** | `version_gap_hold` row — message durably held in SQL |
| Gap timeout | — | hold row → `repair_quarantine(VERSION_GAP)` |
| Enriched persist success | **ACK** | `ingestion_record=ENRICHED_ACKED` + `enriched_allocation`, one txn; ACK only after commit |
| SQL failure on persist | **NACK** | none (retry-safe via idempotency) |
| Manual blotter gate outcome persisted (`PENDING_APPROVAL` or `BLOTTER_VALIDATED`) | **ACK** | gate txn (full path F8) |
| Approval resume applied (or duplicate/stale resume) | **ACK** | `PENDING_APPROVAL → BLOTTER_READY` txn; stale → no-op (full path F8) |

Deliberate asymmetry: ref-data attempts 1–2 use NACK redelivery (cheap,
GCAM-side); the 3rd attempt **ACKs and quarantines** — otherwise the message
ping-pongs to DLQ and ops loses the enriched context. Version-gap holds are
ACKed because `version_gap_hold` makes TCS durably responsible.

---

## F1.3 Version-gap buffer semantics

```
onArrival(block, alloc, v):
  lastProcessed = max processed version for (block, alloc)   // from ingestion_record
  if v <= lastProcessed:        DUPLICATE/stale → ACK, audit
  if v == lastProcessed + 1:    PROCESS; then drain holds v+1, v+2, … in order
  if v >  lastProcessed + 1:    persist hold row, ACK, start/extend book deadline
```

- Sweeper: every 5s, holds past `deadline_at` → `repair_quarantine(VERSION_GAP)`,
  metric `tc.version_gap.quarantined{book}`, ops alert.
- Restart-safe: holds live in SQL; in-memory index rebuilt on partition
  assignment.
- Scope is **versions of one allocation only** — cross-allocation order on a
  key is Solace partition FIFO (D2); there is no contiguous counter to
  gap-check across allocations unless GCAM supplies `key_sequence`.

---

## F1.4 Pipeline transaction boundaries

| Step | Transaction |
|------|-------------|
| Idempotency probe | none (read) |
| Hold insert (gap) | T1: insert `version_gap_hold` → Solace ACK after commit |
| Audit reject | T1: insert `audit_reject` → Solace NACK after commit |
| Enriched persist | T1: upsert `ingestion_record(ENRICHED_ACKED)` + insert `enriched_allocation` → Solace ACK **after commit** |
| Quarantine (3rd ref-data miss) | T1: insert `repair_quarantine` (+ optional ingestion row `QUARANTINED`) → Solace ACK after commit |

The Solace ACK is always **after** the SQL commit it depends on; a crash
between commit and ACK is resolved by the idempotency gate on redelivery.

---

## F1.5 Metrics

| Metric | Notes |
|--------|-------|
| `tc.ingress.rate{type,source,book}` | BLOCK/SWAP × GCAM/MANUAL/TEST |
| `tc.partition.lag{partition}` | primary HPA gate |
| `tc.gcam.ack.latency` | received_at → acked_at, P50/P99 |
| `tc.validation.fail{stage,reason}` | STRUCTURAL / MANDATORY |
| `tc.refdata.miss{entity,attempt}` | watch attempt=3 → quarantine inflow |
| `tc.version_gap.held{book}` | gauge |
| `tc.version_gap.quarantined{book}` | counter + alert |
| `tc.quarantine.open{category}` | gauge, ops dashboard |
| `tc.idempotency.duplicate{source}` | GCAM retry health |

---

## F1.6 Exit criteria

1. **Soak**: 2M synthetic messages/day, zero ordering violations per key
   (assert monotonic versions in `ingestion_record` per
   `(block_id, allocation_id)`).
2. **Spike**: 15K messages / 10 min concentrated on 10 hot keys — partition
   lag recovers < 2 min, GCAM ACK P99 < 500 ms.
3. **Crash**: kill/restart consumer mid-spike — no loss, no duplicate
   `ENRICHED_ACKED`, version-gap holds recovered from SQL.
4. **Ref-data outage drill**: 3 retries → quarantine → repair-UI reprocess
   succeeds end-to-end.

---

## Carried prerequisites (external, before F1 code freeze)

1. GCAM ordering contract (or `key_sequence` field) — blocking.
2. GCAM envelope decision (`TcsIngressMessage` direct vs consumer-edge wrap).
3. System A business-ACK latency distribution — shapes T+8/T+10 milestones,
   not F1 itself.
