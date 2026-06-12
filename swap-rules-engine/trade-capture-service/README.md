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

Phases F0–F12 implemented as a library with exit-criteria tests. A **demo Spring Boot
shell** exposes REST APIs and an ops console for local development (in-memory stores,
no Docker).

### Run locally (demo mode)

```bash
cd swap-rules-engine
mvn -pl swap-rules-core,swap-rules-runtime install -DskipTests
mvn -pl trade-capture-service spring-boot:run
```

Open **http://localhost:8081/** for the ops console. Rules authoring UI remains on
**swap-rules-admin** at http://localhost:8080/.

> **Demo mode security:** The default Spring profile is `demo` (in-memory stores, no SSO).
> All REST endpoints—including resend, archive, recon heal, and manual submit—are
> unauthenticated. **Bind to localhost only** (`127.0.0.1`) and never expose port 8081
> beyond your dev machine. Production deployments must use a non-demo profile with real
> persistence, ingress, and auth (see PRD external dependencies E1–E10).

| Service | Port | Purpose |
|---------|------|---------|
| `trade-capture-service` | 8081 | TCS REST + ops UI (demo) |
| `swap-rules-admin` | 8080 | Rule studio + enrichment console |

Design approved; production wiring (SQL Server JDBC, Solace ingress, SSO) deferred per PRD
external dependencies E1–E10.
