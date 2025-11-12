## Create_Reset Java Call Flow

The diagram below traces the generated Java implementation in `cdm/event/common/functions/c`. It highlights how the Rosetta function evaluates a reset instruction and delegates to helper functions for observation and reset resolution.

```mermaid
sequenceDiagram
    participant Caller
    participant Create_Reset
    participant TradeStateBuilder as TradeState.builder()
    participant ResolvePerfIds as ResolvePerformanceObservationIdentifiers
    participant ResolveIrIds as ResolveInterestRateObservationIdentifiers
    participant ResolveObservation
    participant ResolvePerfReset as ResolvePerformanceReset
    participant ResolveIrReset as ResolveInterestRateReset
    participant ModelValidator as ModelObjectValidator

    Caller->>Create_Reset: evaluate(instruction, tradeState)
    Create_Reset->>Create_Reset: doEvaluate(instruction, tradeState)
    Create_Reset->>TradeStateBuilder: TradeState.builder()
    Create_Reset->>Create_Reset: assignOutput(resetBuilder, instruction, tradeState)
    Create_Reset->>Create_Reset: toBuilder(tradeState)
    Create_Reset->>Create_Reset: payout = instruction.getPayout()

    alt Performance payout
        Create_Reset->>ResolvePerfIds: evaluate(performancePayout, resetDate)
        ResolvePerfIds-->>Create_Reset: ObservationIdentifier
        Create_Reset->>ResolveObservation: evaluate(identifiers, null)
        ResolveObservation-->>Create_Reset: Observation
        Create_Reset->>ResolvePerfReset: evaluate(performancePayout, observation, resetDate)
        ResolvePerfReset-->>Create_Reset: Reset
        Create_Reset->>Create_Reset: resetBuilder.addResetHistory(reset)
    else Interest rate payout
        Create_Reset->>ResolveIrIds: evaluate(interestRatePayout, observationDate)
        ResolveIrIds-->>Create_Reset: ObservationIdentifier
        Create_Reset->>ResolveObservation: evaluate(identifiers, null)
        ResolveObservation-->>Create_Reset: Observation
        Create_Reset->>ResolveIrReset: evaluate(interestRatePayout, observation, resetDate, rateRecordDate)
        ResolveIrReset-->>Create_Reset: Reset
        Create_Reset->>Create_Reset: resetBuilder.addResetHistory(reset)
    else Unsupported payout
        Create_Reset->>Create_Reset: addResetHistory(empty)
    end

    Create_Reset-->>Create_Reset: resetBuilder.prune()
    Create_Reset-->>Caller: resetBuilder
    Caller->>Create_Reset: build()
    Create_Reset->>ModelValidator: validate(reset)
    ModelValidator-->>Create_Reset: ack
    Create_Reset-->>Caller: TradeState reset
```

### Notes
- Branching is driven by the payout type referenced by the `ResetInstruction`.
- Both branches rely on `ResolveObservation` to pull market data after identifiers are computed.
- `ModelObjectValidator` runs after the builder is converted back to an immutable `TradeState`, enforcing schema constraints before the result is returned.

