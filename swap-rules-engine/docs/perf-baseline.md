# Performance baseline

Target SLO: **P99 &lt; 50ms** synchronous enrichment @ **200 TPS** sustained.

## JMH (local reference)

Run: `make bench` or `mvn -pl swap-rules-jmh package && java -jar swap-rules-jmh/target/benchmarks.jar`

| Scenario | Rules | Expected P99 (laptop) |
|----------|-------|------------------------|
| `EnrichmentBench.enrich` | 1,000 economic | &lt; 30ms |
| Unit `EnrichmentEngineImplTest` | 2 rules | &lt; 5ms |

## Gatling (nightly CI)

Configure against `swap-rules-admin` `POST /api/v1/enrich`:

- Sustain **200 req/s** for 10 minutes
- Burst **500 req/s** for 2 minutes
- Assert P99 &lt; 50ms

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
