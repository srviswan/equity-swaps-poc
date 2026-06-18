# AGENTS.md

## Cursor Cloud specific instructions

This is a multi-service (microservices) monorepo for a synthetic **equity swaps** platform. The toolchain (JDK 21, Maven 3.8.7, Python 3.12) is already present on the VM; the startup update script pre-resolves Maven dependencies for `swap-rules-engine` into the persisted local `~/.m2` cache.

### Primary actively-developed service: `swap-rules-engine`
Equity-swap enrichment rules engine (Java 21, Spring Boot 3.3.5, Maven multi-module reactor). It is the focus of recent development and is fully self-contained in dev mode (embedded **H2** + Flyway, no external infra). Standard commands are in `swap-rules-engine/README.md` and `swap-rules-engine/Makefile`.

Non-obvious caveats:
- **Lint/`verify` currently fails on committed code.** `mvn spotless:check` (and therefore `make verify` / `mvn verify`, which run the spotless gate) reports formatting violations in already-committed source. To run tests, skip the gate with `-Dspotless.check.skip=true`; to reformat, run `mvn spotless:apply`. This is a pre-existing repo state, not an environment problem.
- **Running the admin app requires the reactor jars in `~/.m2` first.** `mvn -pl swap-rules-admin spring-boot:run` alone fails with `Could not resolve ... swap-rules-core`. Either install once then run:
  - `cd swap-rules-engine && mvn -B -ntp install -DskipTests -Dspotless.check.skip=true -pl '!swap-rules-jmh,!swap-rules-loadtest'`
  - `mvn -pl swap-rules-admin spring-boot:run`  (serves on **port 8080**, context `/`)
  - or use `mvn -pl swap-rules-admin -am spring-boot:run`.
- The admin app seeds sample rules and auto-publishes a snapshot on startup, so the UI/API is usable immediately.
- Some `swap-archiver` tests are **Testcontainers/Docker**-based and **skip gracefully when Docker is absent** (Docker is not installed on the VM). The MSSQL integration tests (`-Pit`) likewise need a SQL Server container.

Hello-world (verified working): open `http://localhost:8080/enrich.html`, paste a raw trade JSON, click "Run Enrichment" — or via API: `POST /api/v1/snapshots/publish` then `POST /api/v1/enrich` with `swap-rules-admin/src/test/resources/golden/usd-equity-swap-trade.json`.

### Other services (not part of the default dev demo)
- `cashflow-generation-service` — Java 21, Spring Boot 3.3 reactive. Requires **PostgreSQL + Redis + Kafka** (see its `docker-compose.yml`); Docker is not installed here.
- `trade-capture-service` — Java **11**, Spring Boot 2.7.18; targets Java 11 and is not expected to build cleanly under the installed JDK 21.
- `synthetics-common`, `synthetics-instruction-service`, `synthetics-handler-service`, `synthetics-position-service` — declare a parent POM `com.finos.synthetics:equity-swaps-poc` that **does not exist in the repo**, so they will not build via Maven until that parent is provided.
- `data-archival-system-v2`, `data-retention-service`, `allocation-svc`, `xlsscripts` — Python; the first two need SQL Server. Install per-dir via `pip install -r requirements.txt`.
