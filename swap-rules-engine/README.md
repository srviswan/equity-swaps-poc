# Swap Rules Engine

Greenfield equity swap enrichment rules engine: transforms **raw hedge trades** into **enriched equity swaps** with full decision provenance.

## Modules

| Module | Purpose |
|--------|---------|
| `swap-rules-core` | Domain model, compiler, strategies, trace (no Spring) |
| `swap-rules-runtime` | `EnrichmentEngineImpl` hot path |
| `swap-rules-store` | JPA + Flyway persistence |
| `swap-rules-admin` | REST API, publish, near-miss, simulate |
| `swap-rules-shadow` | Shadow diff + trade capture adapter |
| `swap-rules-jmh` | Micro-benchmarks |
| `swap-rules-archtest` | ArchUnit module boundaries |

## Quick start

```bash
cd swap-rules-engine
mvn verify -DskipITs=true
mvn -pl swap-rules-admin spring-boot:run
```

Publish rules then enrich:

```bash
curl -X POST http://localhost:8080/api/v1/snapshots/publish
curl -X POST http://localhost:8080/api/v1/enrich -H 'Content-Type: application/json' -d @src/test/resources/golden/usd-equity-swap-trade.json
```

## Integration with pb-synth-tradecapture-svc

1. Add dependency on `swap-rules-runtime`.
2. Use `TradeCaptureAdapter` from `swap-rules-shadow` to map request → `RawHedgeTrade`.
3. Call `EnrichmentEngine.enrich()` in-process (no network hop).
4. Run **shadow mode**: legacy rules engine + new engine; publish diffs via `ShadowDiffService` to Kafka topic `swap.enrichment.shadow.diff`.
5. Cut over per book/product when diff rate &lt; 0.1%.

See [docs/integration-trade-capture.md](docs/integration-trade-capture.md).

## Rule categories

- **ECONOMIC**: layered enrichment per attribute path (restrictive first)
- **NON_ECONOMIC / WORKFLOW / ROUTING**: first-match exclusive per target
- **VALIDATION**: collect matches without mutation

## Ops APIs

- `POST /api/v1/rules` — create rule
- `POST /api/v1/templates` — action template
- `POST /api/v1/fragments` — criteria fragment
- `POST /api/v1/snapshots/publish` — compile + activate snapshot
- `POST /api/v1/enrich` — synchronous enrichment
- `POST /api/v1/rules/near-miss` — closest rules (cold path)
- `POST /api/v1/rules/from-candidate` — draft rule from near-miss
- `POST /api/v1/rules/simulate` — replay draft against samples
- `GET /api/v1/traces/{traceId}` — narrative + raw trace
