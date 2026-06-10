# Trade Capture Service

Upstream trade capture for the Equity Swap Lifecycle Management platform:
ingests GCAM allocation messages from Solace, enriches and defaults via the
`swap-rules-engine` libraries, and publishes `SwapBlotter` messages to
downstream booking/position systems with cross-reference tracking.

## Documentation (read in this order)

| # | Document | Purpose |
|---|----------|---------|
| 1 | [docs/trade-capture-prd.md](docs/trade-capture-prd.md) | **Start here.** Product requirements: numbered FR/NFR with acceptance criteria, delivery phases F0–F12 with exit criteria, external dependencies E1–E10, execution rules for implementing agents |
| 2 | [docs/trade-capture-architecture.md](docs/trade-capture-architecture.md) | Target architecture: binding decision register D1–D25, pipeline semantics, ordering model, approval gate, dispatch/cross-ref/reconciliation design, REST API inventory, provisional integration contracts, observability |
| 3 | [docs/f0-f1-component-spec.md](docs/f0-f1-component-spec.md) | Build-level spec for phases F0/F1: proto contract, SQL Server DDL, Solace topology, ACK/NACK matrix, version-gap semantics, config files |

UI mocks: [docs/assets/trade-entry-ui-mock.png](docs/assets/trade-entry-ui-mock.png) ·
[docs/assets/rules-management-ui-mock.png](docs/assets/rules-management-ui-mock.png)

## Status

Design approved; implementation not started. Build strictly in phase order
F0 → F12 per the PRD. Reuses sibling modules in this repository:
`swap-rules-core` / `swap-rules-runtime` (enrichment engine),
`swap-rules-admin` (rule authoring), `swap-rules-shadow` (parity diff),
`swap-archiver` (archival patterns).
