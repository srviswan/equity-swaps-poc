# Performance baseline

## SLO targets (not measured)

- **P99 < 50ms** synchronous enrichment @ **200 TPS** sustained (production / Gatling).
- Local JMH reference (laptop): `EnrichmentBench.enrich` with 1,000 economic rules — target **P99 < 30ms**.
- Unit `EnrichmentEngineImplTest` (2 rules): functional correctness; wall-clock assert **< 50ms** per enrich.

## JMH (local reference)

**Measured:** 2026-05-23

**Environment:** macOS Darwin 25.5.0 (arm64); JDK 23.0.2 Amazon Corretto (`OpenJDK 64-Bit Server VM`); no extra JVM flags.

**Command:**

```bash
mvn -pl swap-rules-jmh package -DskipTests
java -jar swap-rules-jmh/target/benchmarks.jar -wi 2 -i 3 -f 1
```

**Benchmark:** `com.pb.swap.rules.jmh.EnrichmentBench.enrich` — `Mode.SampleTime`, 1,000 published economic rules, 1 fork, warmup 2×1s, measurement 3×1s (CLI overrides class defaults).

| Scenario | Rules | Mean (ms/op) | P50 | P95 | P99 | P99.9 |
|----------|-------|--------------|-----|-----|-----|-------|
| `EnrichmentBench.enrich` | 1,000 economic | 0.095 ± 0.001 | 0.089 | 0.113 | **0.227** | 0.555 |

Additional JMH percentiles (ms/op): P0 0.075, P90 0.104, P99.99 0.748, max 0.940. Sample count **N = 31,596**.

Also: `make bench` runs the same jar with default JMH annotations on the benchmark class.

| Scenario | Rules | Notes |
|----------|-------|--------|
| `EnrichmentEngineImplTest` | 2 | JUnit; asserts single enrich **< 50ms** — **passes** on 2026-05-23 (`mvn -pl swap-rules-runtime test -Dtest=EnrichmentEngineImplTest`). |

## Gatling (nightly CI)

Configure against `swap-rules-admin` `POST /api/v1/enrich`:

- Sustain **200 req/s** for 10 minutes
- Burst **500 req/s** for 2 minutes
- Assert P99 < 50ms

## JVM flags (production candidate)

```
-XX:+UseZGC -Xms2g -Xmx2g
```

Compare with G1 using JFR in staging before cutover.

## Grafana SLO panels

- `rules.engine.enrich` histogram (P50/P95/P99)
- `rules.engine.phase` by category
- `rules.no_match.count` by target
- Snapshot age gauge
