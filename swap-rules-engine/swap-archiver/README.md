# swap-archiver

Restartable, self-healing data-archival engine for SQL Server. See the full design in
[`../docs/data-archival-design.md`](../docs/data-archival-design.md).

A single config-driven fat jar. *What* is archived lives in the `archive.*` control tables (data,
not code), so criteria/table changes need no redeploy.

## Phase status

- **Phase 1 (done):** connectivity, three auth modes (Kerberos / Integrated / SQL via CyberArk or
  env), and pre-flight checks (connectivity, identity, recovery model, log-space visibility, key
  permissions, source↔target schema consistency). `DRY_RUN` runs pre-flight only.
- Phases 2+ (worklist, copy→verify→delete, windows, throttling, restore) per the design doc.

## Local dev with Docker SQL Server

From the repo root (`swap-rules-engine/`):

```bash
# 1. Start the SQL Server container (defined in docker-compose.yml)
docker compose up -d mssql

# 2. Create the dev databases (control / source / target / investigation)
docker exec -i swap-rules-mssql /opt/mssql-tools18/bin/sqlcmd \
  -S localhost -U sa -P 'Swap_rules_1!' -C -No -i - < swap-archiver/dev/bootstrap.sql

# 3. Run pre-flight (DRY_RUN is the default mode)
mvn -pl swap-archiver -am spring-boot:run
```

On first run Flyway creates the `archive.*` control tables in `archive_control`, then the
pre-flight report is printed. With no `archive_table` rows yet, table-level checks warn (expected).

## Auth modes

| Mode | Config | Notes |
|---|---|---|
| SQL (dev) | `auth: sql`, `credential.provider: env` | username/password from config/env |
| SQL (prod) | `auth: sql`, `credential.provider: cyberark-ccp` | CyberArk CCP (REST + mTLS + AppID) |
| Kerberos | `auth: kerberos` | consumes an existing ticket/keytab; set the URL's `authenticationScheme=JavaKerberos` |
| Integrated | `auth: integrated` | Windows `integratedSecurity=true` |

Override any default via env vars (e.g. `SRC_AUTH=kerberos`, `TGT_CRED=cyberark-ccp`,
`ARCHIVER_MODE=ARCHIVE`). See `src/main/resources/application.yml`.
