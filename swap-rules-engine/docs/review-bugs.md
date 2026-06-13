# Review Bugs (Bugbot)

Findings from branch review vs `main`, with fix status.

| # | Severity | Location | Finding | Status |
|---|----------|----------|---------|--------|
| 1 | High | `ApprovalCallbackHandler.java:60` | `publishResume` hardcoded partition key (`EQ_US_HY` / `CLI-9` / `SEC-AAPL`) instead of trade sequence fields | Fixed |
| 2 | High | `ApprovalCallbackHandler.java:43` | `ROWS` scope returned `PARTIAL` without denying carved-out rows, resuming approved rows, or publishing `APPROVAL_RESUME` | Fixed |
| 3 | High | `ChangesetSimulationService.java:43` | Batch simulation evaluated touched rules individually instead of merged projected set | Fixed |
| 4 | High | `ChangesetPublishService.java:46` | Publish conflict check ran on raw merged rules; drafts skipped by compiler | Fixed |
| 5 | High | `PublishService.java:70` | Snapshot publish used `compile(asOf)` instead of full-range compile (FR-205/D7) | Fixed |
| 6 | Medium | `ChangesetController.java:48` | Simulate endpoint used bare `ObjectMapper` without `JavaTimeModule` | Fixed |
| 7 | Medium | `BulkEditService.java:14` | Null version used non-deterministic `findFirst()` | Fixed |

## Verification

```bash
cd swap-rules-engine
mvn -pl trade-capture-service,swap-rules-admin test
```
