# Trade Capture Service — Product Requirements Document (PRD)

**Version**: 1.0 · **Status**: Approved for build · **Owner**: Equity Swap Lifecycle Architecture

> **READ THIS FIRST (execution handoff).** This PRD is the entry point for
> implementing the Trade Capture Service. It enumerates WHAT to build as
> numbered, testable requirements. The companion documents define HOW:
>
> 1. [trade-capture-architecture.md](trade-capture-architecture.md) — target
>    architecture, decision register D1–D25, pipeline semantics, diagrams,
>    REST API inventory (§10), provisional integration contracts (§15).
> 2. [f0-f1-component-spec.md](f0-f1-component-spec.md) — build-level spec for
>    phases F0/F1: proto, DDL, Solace topology, ACK/NACK matrix, configs.
> 3. UI mocks: [assets/trade-entry-ui-mock.png](assets/trade-entry-ui-mock.png),
>    [assets/rules-management-ui-mock.png](assets/rules-management-ui-mock.png).
>
> Rules of engagement for the implementing agent:
> - The decision register (D1–D25) is **binding**. Do not re-litigate decisions;
>   if a requirement appears to conflict with a decision, raise it — do not
>   silently pick one.
> - Reuse this repository's existing libraries: `swap-rules-core` /
>   `swap-rules-runtime` (enrichment engine), `swap-rules-admin` (rule
>   authoring), `swap-rules-shadow` (diff harness), `swap-archiver` (archive
>   patterns). Do NOT introduce Drools, SpEL-first rule engines, or a second
>   rules implementation.
> - Build in phase order F0 → F12 (§10). Each phase has exit criteria; do not
>   start a phase until the previous phase's exit criteria are demonstrably met.
> - Tech stack is fixed: Java 21+, Spring Boot, MS SQL Server, Solace
>   (partitioned queues), protobuf ingress, Micrometer metrics.
> - External prerequisites E1–E10 are tracked in §11 and block specific
>   phases; stub them behind interfaces and proceed where noted. Integration
>   contracts marked *provisional* in architecture §15 are the working
>   assumption until the owning team confirms.

---

## 1. Product context

### 1.1 Problem

The firm processes 1.5–2M equity swap trades/day arriving as allocation
messages from GCAM (an allocation management system). A legacy system
captures, enriches, and books these trades into a single downstream system.
It must be replaced with a new Trade Capture Service (TCS) that:

- preserves **strict per-key ordering** (position correctness depends on it),
- enriches and defaults trades via **configurable rules** owned by two
  distinct user groups (traders = economic, Ops/MO = non-economic),
- routes to **multiple downstream systems** with differing capabilities,
- maintains **cross-references** between downstream systems (System B cannot
  perform HICO/LIFO lot selection and must be told exactly which lots to
  close),
- supports **manual trade entry** with an approval workflow,
- meets a **15-minute regulatory reporting SLA** end-to-end,
- proves **parity with the legacy system** before cutover.

### 1.2 Position in the platform

TCS is upstream of Position Management / Lifecycle Management. Its canonical
output, the **SwapBlotter** (a contract-like artifact carrying
`swapDataProduct`), feeds the Contract Service, Position Service, and external
booking systems (System A, System B, extensible).

### 1.3 Personas

| Persona | Needs |
|---------|-------|
| **Trader** | Owns economic defaulting rules; approves non-STP manual trades; needs rule explainability in plain language |
| **Ops / Middle Office** | Owns non-economic rules; works the repair queue; resolves partial dispatch failures; runs bulk operations |
| **Trading Assistant** | Books manual trades (single + bulk upload); not STP — requires trader approval |
| **Support / SRE** | Real-time pipeline visibility, SLA dashboards, replay/resend tooling, self-healing behavior |
| **Downstream system owner (A/B)** | Stable envelope contract, business-ACK protocol, cross-ref push + poll API |
| **Auditor / Regulator** | Full trace: who/what/when per trade, rule provenance, approval history, 15-min SLA evidence |

### 1.4 Glossary

| Term | Meaning |
|------|---------|
| Block Allocation | Trade not yet allocated to a client account; sequenced under a WashBook; acts as a temporary swap allocation downstream |
| Swap Allocation | Trade allocated to a client account; one block → many swap allocations (1:M) |
| SwapBlotter | Canonical enriched artifact, 1:1 with an allocation; becomes contract-like after defaulting |
| Sequence key | `(Book, AccountId, SecurityId)`; AccountId = ClientAccount (Swap) or WashBook (Block) |
| Idempotency key | `(BlockId, AllocationId, Version)` + GCAM message id |
| STP | Straight-through-processing initiator: passes the approval gate without pausing |
| Business ACK | Downstream confirmation carrying swapRef/lotRefs (distinct from Solace L1 ACK) |
| Cross-ref | Exchange of swap/lot references between downstream systems via TCS |

---

## 2. Functional requirements — ingestion & ordering

| ID | Requirement | Acceptance criteria | Ref |
|----|-------------|---------------------|-----|
| FR-100 | Consume `TcsIngressMessage` protobuf from a Solace **partitioned queue** (128 partitions; partition key = hash of sequence key) | Messages for the same sequence key are processed strictly in arrival order; consumers scale to ≤ partition count | D2, D3; spec §F0.2 |
| FR-101 | Support three payload kinds in one envelope: `allocation`, `manual_blotter`, `approval_resume`, each entering the pipeline at its defined stage (1 / 5.5 / 6) | Routing verified by integration test per kind | D17; spec §F0.1 |
| FR-102 | Enforce idempotency on `(blockId, allocationId, version)`; duplicates ACK'd and skipped without side effects | Redelivered message after commit produces no second `ENRICHED_ACKED` row | D4 |
| FR-103 | Handle versioned amendments: version N+1 processed as a new run; no recall of in-flight version N; `supersedes_version` recorded | Amend test: both versions traceable, downstream not recalled | D9 |
| FR-104 | **Version-gap buffer**: hold version N+2 when N+1 unseen, DB-backed (`version_gap_hold`), book-specific timeout, quarantine on expiry | Crash/restart retains holds; timeout moves to repair queue with alert | D2, D18; spec §F1.3 |
| FR-105 | Apply the ACK/NACK matrix exactly as specified (NACK structural; ref-data NACK ×2 then ACK+quarantine on 3rd; ACK only after SQL commit) | Each matrix row covered by a test | D5, D6, D22; spec §F1.2 |
| FR-106 | ACK to GCAM occurs when `ingestion_record` + `enriched_allocation` commit in one transaction — never blocked by downstream | Verified ordering: commit before Solace ACK in all paths | D5 |
| FR-107 | Block allocations use the same schema and routing rules as swap allocations, with WashBook substituting ClientAccount in the sequence key | Block + subsequent swap allocations for the same block process correctly | D8 |

## 3. Functional requirements — enrichment & rules

| ID | Requirement | Acceptance criteria | Ref |
|----|-------------|---------------------|-----|
| FR-200 | Reference-data enrichment: lookupSecurity, lookupClientAccount, lookupBook, lookupWashBook behind a `ReferenceDataProxy` interface | Missing entity → hard reject path per FR-105 | arch §9 |
| FR-201 | WashBook derived from ClientAccount + B2BLeg + Exchange (+ allocation attributes), never supplied by GCAM | Unit-tested resolver | arch §9 |
| FR-202 | **Per-entity cache policy** from `cache-policy.yml`: static fields cached (TTL + event invalidation); correctness-critical fields (security status) read-through | Inactive security is never accepted from a stale cache | D16 |
| FR-203 | Cache implementation swappable Caffeine → Redis without application-code change (interface boundary) | Demonstrated by config-level switch in tests | D16 |
| FR-204 | Economic defaulting: **all matching rules in priority order**; non-economic: **first match wins**, mode configurable per rule metadata | Strategy behavior covered by engine tests (exists in `swap-rules-runtime`) | D7 |
| FR-205 | Rules are **effective-dated**; back-dated trades evaluate against rules as of **trade date** (single snapshot with `[effectiveFrom, effectiveTo)` ranges; `RuleCompiler` change) | Back-dated trade hits the historical rule version | D7; arch §6 |
| FR-206 | Rule authoring prevents conflicting field assignments for the same criteria slice (blocking conflict detection on save/publish) | Conflicting changeset cannot publish | D7; arch §6.1 |
| FR-207 | Every applied rule produces a **plain-language explanation** persisted per trade (`rule_explain`), narrating criteria matched and values set, with snapshot version | Auditor can retrieve "why" for any trade field | arch §6 |
| FR-208 | Rule Static service: every criteria dimension and action value backed by a dynamic datasource (DB/service) feeding UI dropdowns | No free-text criteria in standard rules | arch §6.1 |
| FR-209 | Overridable defaults: when business validation fails, ops may edit blotter fields in the repair UI and re-run **business validation only** | Repair → edit → revalidate → continue path tested | arch §5 |

## 4. Functional requirements — validation, approval, routing

| ID | Requirement | Acceptance criteria | Ref |
|----|-------------|---------------------|-----|
| FR-300 | Business validation (structural integrity + mandatory contract fields) runs after defaulting, before routing; failures → repair queue (internal, post-ACK) | Failure lands in repair UI with reason | arch §5 |
| FR-301 | **Approval gate at stage 5.5**, after eco + non-eco enrichment: workflow rules (first-match) evaluate the enriched SwapBlotter + initiator; STP → pass; non-STP → park | GCAM trades always pass; trading-assistant trades park | D17; arch §8 |
| FR-302 | Parked trades **release the partition** (never block the key); approval resume re-enters via `APPROVAL_RESUME` on the same topic + partition key, resuming at business validation | Concurrent GCAM trades on the same key proceed while parked | D17 |
| FR-303 | Approval outcomes: Approved → resume; Denied → terminal `APPROVAL_DENIED`, audited; no response in **15 min** → escalation alert, remains pending | Timeout alert fires; denied trade never dispatches | D17 |
| FR-304 | Routing on Book + assetType via config (`routing-rules.yml`), extensible dimensions without code change | New routing dimension added by config in test | D10 |
| FR-305 | Per-target position behavior: System A receives everything as NEW (no lookup); System B requires PositionService lookup → derive NEW/TOP_UP/UNWIND **before send**; envelope sent immediately (no dependency on A) | Both target behaviors integration-tested with PositionService stub | D11, D12, D13 |
| FR-306 | Position match key per system from `position-match-key.yml` (default: book, clientAccount, security, direction) | Key template change requires no deploy | D10 |

## 5. Functional requirements — dispatch, ACK, cross-references

| ID | Requirement | Acceptance criteria | Ref |
|----|-------------|---------------------|-----|
| FR-400 | Fan-out dispatch: one `dispatch_record` per (ingestion, target); claim-batch short transactions; concurrent per-destination thread pools; **no network I/O inside DB transactions** | One target down does not delay others; verified under load | arch §7 |
| FR-401 | Retry with exponential backoff per target; DLQ after max attempts; aggregate ingestion status `SENT / PARTIALLY_SENT / FAILED` | `PARTIALLY_SENT` visible in ops UI with per-record retry/skip actions | arch §7 |
| FR-402 | Business ACKs consumed from per-system response queues into `business_ack` (separate table, FK to dispatch record) carrying swapRef + lotRefs; per-target ACK timeout → retry inquiry → escalation | ACK latency histogram per target emitted | D14 |
| FR-403 | **Bidirectional cross-ref**: on A's business ACK push A's swapRef + exact unwind lot IDs to B; on B's ACK push B's refs to A; each direction tracked independently (PENDING/DELIVERED/FAILED) | Unwind lot IDs reach B without B polling; both directions auditable | D15 |
| FR-404 | Cross-ref **poll API** for downstream recovery: query by allocationId / swapRef, both directions | Documented REST endpoint with contract tests | D15 |
| FR-405 | Unwind flow: System B operates custom-lot unwind only; the lot IDs to close always originate from System A's business ACK and are delivered via FR-403/404 | End-to-end unwind test with stubbed A and B | D12, D15 |
| FR-406 | Partial-success handling: surfaced on ops UI; user actions per dispatch record (retry, skip, manual reconcile) | UI workflow test | arch §7 |

## 6. Functional requirements — manual trading & bulk operations

| ID | Requirement | Acceptance criteria | Ref |
|----|-------------|---------------------|-----|
| FR-500 | Manual trade entry UI per mock (§8.4 of architecture): GCAM-shaped form, dry-run blotter preview with rule provenance per field, approval status chip, pipeline progress chips | Preview shows rule explanations identical to processing-time `rule_explain` | arch §8.4; mock |
| FR-501 | **Dual publish mode**: Raw Allocation (full pipeline, rules at processing time) or SwapBlotter (previewed/edited blotter shipped as-is, entering at the approval gate) | Both modes produce booked trades through the same queue | D17 |
| FR-502 | Both modes and approval resumes publish to the **same partitioned topic with the same partition key** — no out-of-band injection | Ordering test: manual + GCAM trades on one key interleave correctly | D17 |
| FR-503 | Blotter-mode governance: approval request carries edited-fields diff vs rule-derived preview; `rule_explain` records frozen-rules provenance | Auditor sees what was overridden and by whom | D21 |
| FR-504 | **Bulk trade upload** (CSV/XLSX, ≤10K rows configurable): synchronous per-row validation report; valid subset submittable; each row → individual Raw-Allocation message with own partition key and idempotency key `MAN-{batchId}-{rowNo}` | 10K-row file processes with row-level isolation; failures tagged `batch_id` in repair queue | D23; arch §8.5 |
| FR-505 | Bulk approval grouping: non-STP uploader's rows park grouped by `batch_id`; Approval Service request carries batch summary; batch approve / deny / per-row carve-out supported | Approver handles one item per batch, not 10K | D23 |
| FR-506 | Batch dashboard: per-row status rollup (validated / parked / approved / booked / failed / quarantined) linked to ingestion records | Statuses reconcile with `ingestion_record` | D23 |
| FR-507 | **Bulk rules operations** per mock (§6.1): multi-select bulk edit (effective dates, enable/disable, priority re-sequencing, clone-to), CSV/YAML import/export as draft changesets | Bulk edits never bypass conflict detection | D24; arch §6.1 |
| FR-508 | Changeset model: bulk changes simulate against sample trades and publish **atomically as one snapshot** (all-or-nothing) | Failed simulation blocks publish; snapshot version increments once | D24 |

## 7. Functional requirements — APIs, persistence, testing

| ID | Requirement | Acceptance criteria | Ref |
|----|-------------|---------------------|-----|
| FR-600 | Lookup API by allocationId / blockId / swapRef / lotRef / client+date / book+date; fall-through hot → archive → **System A API** | Aged-trade lookup returns from System A transparently | D19 |
| FR-601 | Resend / cross-ref sync trigger endpoints (idempotent) | Replays produce no duplicate downstream bookings | arch §10 |
| FR-602 | All hot tables monthly-partitioned on trade_date; archive job (swap-archiver patterns) moves lifecycle-complete + 90-day-old trades to archive storage | Partition-switch archival verified; hot window = current + 2 months | D19 |
| FR-603 | Full audit trail: raw ingress, enriched snapshot, blotter versions, routing decision, envelopes, ACKs, cross-refs, approvals, rule explains — retrievable per trade ("show me everything that happened") | Single API call reconstructs the trade's journey | arch §10 |
| FR-604 | **Legacy parity harness**: take legacy trades, replay through TCS via the real ingress topic, compare new vs legacy SwapBlotter (legacy lives in a different database) using a **user-configurable field manifest** (must-match / tolerance / ignore per field) | Field manifest editable without code; mismatch report per field | arch §12 |
| FR-605 | Shadow mode (full pipeline, no downstream publish) and **dual-publish** feature flag per book/target | Cutover per book demonstrated in staging | D20 |
| FR-606 | Test harness can synthesize proto messages onto the ingress queue from legacy trade extracts and from golden fixtures | Used by parity + soak + spike suites | arch §12 |

## 8. Functional requirements — reconciliation

Design reference: architecture §7.1 (D25). TCS is the system of record for
what was **instructed**; Systems A/B for what was **booked**.

| ID | Requirement | Acceptance criteria | Ref |
|----|-------------|---------------------|-----|
| FR-700 | **R1 — Ingestion completeness recon**: compare GCAM EOD counts/extract vs `ingestion_record`; detect missed allocations and silently-expired version gaps | EOD run flags a withheld test message; on-demand run per book/date | D25 |
| FR-701 | **R2 — Instruction-vs-booking recon**: compare TCS dispatched + business-ACKed view vs System A/B snapshots; detect orphans both directions and key-economics drift (qty, direction, security) | Seeded orphan and qty-drift fixtures detected and classified | D25 |
| FR-702 | **R3 — Cross-system sync recon (A ↔ B)**: verify both systems hold each other's swap/lot refs per TCS `cross_ref`; detect lot mismatches after custom-lot unwinds and status divergence | Post-unwind lot mismatch fixture detected; missing peer-ref detected | D25 |
| FR-703 | Matching by key precedence `allocationId → swapRef → lotRef` with composite fallback for orphan candidates; field comparison driven by the **same configurable manifest mechanism as FR-604** (must-match / tolerance / ignore) | Manifest change requires no deploy; shared implementation with parity harness | D25, FR-604 |
| FR-704 | Break taxonomy and lifecycle: `MISSING_IN_A/B/TCS, REF_MISMATCH, QTY_MISMATCH, STATUS_MISMATCH, LOT_MISMATCH, DUPLICATE`; lifecycle `DETECTED → HEALING/ACKNOWLEDGED → RESOLVED_AUTO/RESOLVED_MANUAL/WRITTEN_OFF`; write-off requires reason + approver | All transitions audited; no break deletable | D25 |
| FR-705 | **Auto-heal** restricted to idempotent TCS-side actions: cross-ref re-push (FR-403), poll-API backfill, envelope resend (FR-601); QTY/STATUS breaks never auto-healed; a break is `RESOLVED_AUTO` only when the next incremental run no longer detects it | Auto-heal test: ref break healed and confirmed on re-run; qty break routed to human | D25 |
| FR-706 | Snapshot discipline: read-only API/extract access to downstream (never direct DB); watermarked as-of comparison excluding the in-flight horizon (default 30 min, configurable) to avoid false breaks | In-flight trade produces no break; watermark recorded per run | D25 |
| FR-707 | Scheduling & operability: EOD full runs (R1–R3) + intraday incremental (R2/R3, hourly, T-day trades) + on-demand per trade/book/date; runs restartable and idempotent per `(type, scope, as-of)`; break UI with aging escalation (24h/48h) | Re-running a completed run is a no-op; aging alert fires on stale break | D25 |
| FR-708 | Recon persistence (`recon_run`, `recon_break`) follows the standard hot-partition + archive policy; recon metrics per architecture §11 emitted | Dashboards show breaks by type/class, auto-heal rate, age histogram | D19, D25 |

## 9. Non-functional requirements

| ID | Requirement | Target |
|----|-------------|--------|
| NFR-1 | Daily volume | 1.5–2M trades/day sustained |
| NFR-2 | Spike | 7K–15K trades in 10 min (market close), concentrated per Book+Client, with mixed traffic |
| NFR-3 | Regulatory SLA | 15 min end-to-end (incl. downstream chain); TCS milestones: ACK T+0, blotter T+1m, dispatched T+3m, business ACKs T+8m, cross-refs T+10m |
| NFR-4 | GCAM ACK latency | P99 < 500 ms under spike |
| NFR-5 | Ordering | Zero per-key ordering violations (hard correctness; verified in soak) |
| NFR-6 | Resilience | Consumer crash/restart with zero loss and zero duplicate bookings; version-gap holds survive restart |
| NFR-7 | Self-healing | Auto-retry with backoff, circuit breakers on reference APIs, DLQs, quarantine + repair workflow, backpressure gates |
| NFR-8 | Scalability | Horizontal via partition consumers (HPA on lag/latency); scale ceiling = partition count; per-stage scaling within the monolith |
| NFR-9 | Observability | All metrics in architecture §11 emitted (Micrometer → ESaaS/Observe); correlation id `(blockId, allocationId, version)` on every span, propagated to PositionService, Approval Service, Systems A/B |
| NFR-10 | Maintainability | Modular monolith with ArchUnit-enforced module boundaries (pattern exists in `swap-rules-archtest`) |
| NFR-11 | Tech stack | Java 21+, MS SQL Server, Solace, protobuf — fixed |

## 10. Delivery phases & definition of done

Build strictly in order. A phase is done when its exit criteria pass in CI
and a demo against the listed scenario succeeds.

| Phase | Scope (FR coverage) | Exit criteria |
|-------|---------------------|---------------|
| **F0** | Contracts: proto, DDL, Solace topology, config files (FR-100/101 contracts) | All artifacts in repo per [f0-f1-component-spec.md](f0-f1-component-spec.md); DDL applies cleanly; proto compiles |
| **F1** | Ingress (FR-100–107 minus rules) | Spec §F1.6: 2M/day soak zero ordering violations; 15K/10-min spike, lag recovery < 2 min, ACK P99 < 500 ms; crash test; ref-data outage drill |
| **F2** | Cache (FR-202/203) | Invalidation-bus drill: status change visible to all instances ≤ fallback TTL; inactive-security trade rejected |
| **F3** | Rules wiring (FR-204/205/207, SwapBlotter + swapDataProduct) | Golden fixtures produce expected blotters; back-dated trade uses historical rules; rule_explain persisted |
| **F4** | Business validation + repair (FR-209/300) | Repair → edit → revalidate → continue demo |
| **F5** | Routing + PositionService (FR-304–306) | A/B routing matrix tests green with PS stub |
| **F6** | Dispatch + System A + business ACK (FR-400–402) | Target-down isolation test; PARTIALLY_SENT surfaced |
| **F7** | System B + cross-ref (FR-403–406) | End-to-end unwind with lot delivery to B; bidirectional cross-ref audit |
| **F8** | Approval gate + manual UI + bulk upload (FR-301–303, 500–506) | Park/resume under concurrent same-key load; 10K-row upload demo; batch approval |
| **F9** | Parity harness (FR-604/606) | Legacy comparison run with configurable manifest; mismatch report |
| **F10** | Cutover tooling + archive + fallback API (FR-600–603, 605) | Shadow → dual-publish flag demo; archival partition switch |
| **F11** | Rules admin bulk ops (FR-507/508) | Changeset bulk edit + atomic publish + batch simulation demo |
| **F12** | Reconciliation (FR-700–708) — build order R3 → R2 → R1 (R3 first: custom-lot unwind sync is the highest operational risk) | Seeded break fixtures per type detected, classified, healed/escalated; idempotent re-run; aging alerts |

## 11. External dependencies & open items (blocking specific work)

| # | Item | Owner | Blocks | Interim |
|---|------|-------|--------|---------|
| E1 | GCAM ordering contract (publish order = business order per key) or `key_sequence` field | GCAM team | F1 sign-off | Build with version-gap only; `gapDetection.useKeySequence` ready |
| E2 | GCAM envelope decision: publish `TcsIngressMessage` directly vs TCS wraps at edge | GCAM team | F0 proto finalization | Default: TCS wraps |
| E3 | System A business-ACK latency distribution (P50/P99) | System A team | T+8/T+10 SLA budgets, F7 | Provisional budgets stand |
| E4 | Approval Service batch-approval API capability | Approval team | FR-505 | Per-row approval fallback with batch summary header |
| E5 | PositionService lookup contract (open qty, swapRef, lotRefs, peer refs) | Position team | F5 | Stub interface per FR-305 |
| E6 | System A/B reconciliation snapshot interfaces (API or EOD extract, with as-of watermark) | System A/B teams | F12 | Define `ReconRecord` normalization contract; build engine against fixtures |
| E7 | GCAM EOD counts/extract for ingestion completeness recon | GCAM team | F12 (R1 only) | R2/R3 proceed without it |
| E8 | **Full `AllocationMessage` field transcription** from the GCAM mapping workbook (proto in spec §F0.1 carries a representative subset) | GCAM team + TCS BA | F0 proto completeness; F3 rule criteria coverage | `extended_attributes` map carries unmapped fields; transcribe before F3 exit |
| E9 | **SwapBlotter / `swapDataProduct` field dictionary** (canonical egress schema: contract, legs, schedule, lot, business-event fields) | TCS architecture + Ops | F3 (blotter build), F9 (parity manifest) | Derive draft from legacy blotter table schema + rules action targets; freeze before F3 exit |
| E10 | **System A/B outbound envelope + business-ACK message formats** | System A/B teams | F6/F7 | Provisional contracts in architecture §15 are the working assumption |

## 12. Out of scope (v1)

- Real-time/streaming reconciliation (batch EOD + hourly incremental only —
  FR-700–708 cover the in-scope recon engine, phase F12).
- Auto-deny on approval timeout (escalation only).
- Redis shared cache (interface-ready; Caffeine per-instance in v1).
- Compensating recall of in-flight versions on amend/cancel (D9).
- Lifecycle Engine as a mandatory dispatch path (optional target only).
