# Trade capture integration (Phase 6)

## Dependency

```xml
<dependency>
  <groupId>com.pb.swap.rules</groupId>
  <artifactId>swap-rules-runtime</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
<dependency>
  <groupId>com.pb.swap.rules</groupId>
  <artifactId>swap-rules-shadow</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

## Shadow mode

```java
EnrichmentResult newResult = newEngine.enrich(adapter.toRawHedgeTrade(...));
Object legacySwap = legacyRulesEngine.applyRules(blotter);
ShadowDiff diff = shadowDiffService.diff(newResult, legacySwap);
if (!diff.match()) {
  kafkaTemplate.send("swap.enrichment.shadow.diff", tradeId, diff);
}
```

## Cutover

1. Enable shadow for one `book` + `productType` slice.
2. Monitor diff rate dashboard (Grafana).
3. Route production enrichment to new engine for slice when diff &lt; 0.1% for 7 days.
4. Remove legacy `RulesEngineImpl` after full cutover.
