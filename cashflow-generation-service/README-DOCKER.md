# Docker Deployment Guide

## Cashflow Generation Service with Updated Package Structure

This guide covers deploying the Cashflow Generation Service using Docker with the new `com.lifecycle.cashflow` package structure.

## 🚀 Quick Start

### Prerequisites
- Docker Desktop installed and running
- Docker Compose v2.0 or higher
- At least 4GB RAM available for containers

### Deployment Steps

1. **Start Docker Desktop**
   ```bash
   # Verify Docker is running
   docker --version
   docker-compose --version
   ```

2. **Build and Deploy**
   ```bash
   # Build the Docker image
   ./build-docker.sh

   # Deploy all services
   ./deploy-docker.sh
   ```

3. **Test the Deployment**
   ```bash
   # Run comprehensive tests
   ./test-docker.sh
   ```

## 📋 What's Included

### Services
- **Cashflow Generation Service** - Main application with new package structure
- **PostgreSQL 16** - Database with initialized schema and sample data
- **Redis 7** - Caching layer
- **Apache Kafka** - Event streaming (with Zookeeper)
- **Prometheus** - Metrics collection
- **Grafana** - Monitoring dashboards

### Key Features
- ✅ **New Package Structure**: `com.lifecycle.cashflow`
- ✅ **Multi-stage Docker Build**: Optimized image size
- ✅ **Health Checks**: All services monitored
- ✅ **Security**: Non-root container execution
- ✅ **Monitoring**: Prometheus metrics + Grafana dashboards
- ✅ **Sample Data**: Pre-loaded test data
- ✅ **Auto-restart**: Services restart on failure

## 🌐 Service Endpoints

### Application
- **Main API**: http://localhost:8080
- **Health Check**: http://localhost:8080/health
- **Detailed Health**: http://localhost:8080/health/detailed
- **Management**: http://localhost:8081/actuator

### Monitoring
- **Prometheus**: http://localhost:9090
- **Grafana**: http://localhost:3000 (admin/admin)

### Infrastructure
- **PostgreSQL**: localhost:5432 (postgres/password)
- **Redis**: localhost:6379
- **Kafka**: localhost:9092

## 🧪 Testing Endpoints

### Health Check
```bash
curl http://localhost:8080/health
```

### Actor System Status
```bash
curl http://localhost:8080/actors/status
```

### Generate Cashflow
```bash
curl -X POST http://localhost:8080/cashflows/generate \
  -H "Content-Type: application/json" \
  -d '{
    "contractIds": ["123e4567-e89b-12d3-a456-426614174000"],
    "calculationDate": "2024-01-15",
    "cashflowTypes": ["INTEREST"],
    "primaryCalculationType": "INTEREST"
  }'
```

### Search Cashflows
```bash
curl "http://localhost:8080/cashflows?page=0&size=10"
```

## 🔧 Management Commands

### Start Services
```bash
docker-compose up -d
```

### Stop Services
```bash
docker-compose down
```

### View Logs
```bash
# All services
docker-compose logs -f

# Specific service
docker-compose logs -f cashflow-service
```

### Restart Service
```bash
docker-compose restart cashflow-service
```

### Scale Service
```bash
docker-compose up -d --scale cashflow-service=2
```

## 📊 Monitoring

### Application Metrics
```bash
curl http://localhost:8081/actuator/metrics
curl http://localhost:8081/actuator/prometheus
```

### Database Health
```bash
docker-compose exec postgres pg_isready -U postgres
```

### Container Stats
```bash
docker stats
```

## 🗄️ Database

### Connect to PostgreSQL
```bash
docker-compose exec postgres psql -U postgres -d cashflow_db
```

### Sample Queries
```sql
-- View cashflows
SELECT * FROM cashflows LIMIT 5;

-- View daily accruals
SELECT * FROM daily_accruals LIMIT 5;

-- Check table counts
SELECT 
  'cashflows' as table_name, COUNT(*) as count FROM cashflows
UNION ALL
SELECT 
  'daily_accruals' as table_name, COUNT(*) as count FROM daily_accruals;
```

## 🏗️ Architecture

### Container Architecture
```
┌─────────────────┐   ┌─────────────────┐   ┌─────────────────┐
│   Grafana       │   │   Prometheus    │   │   Cashflow      │
│   :3000         │   │   :9090         │   │   Service       │
└─────────────────┘   └─────────────────┘   │   :8080/:8081   │
                                            └─────────────────┘
                                                      │
                             ┌────────────────────────┼────────────────────────┐
                             │                        │                        │
                    ┌─────────────────┐   ┌─────────────────┐   ┌─────────────────┐
                    │   PostgreSQL    │   │     Redis       │   │     Kafka       │
                    │   :5432         │   │     :6379       │   │     :9092       │
                    └─────────────────┘   └─────────────────┘   └─────────────────┘
```

### Application Architecture
```
com.lifecycle.cashflow/
├── controller/          # REST API endpoints
├── service/            # Business logic
├── repository/         # Data access
├── model/             # Domain models
├── actor/             # Actor pattern implementation
├── config/            # Configuration
└── exception/         # Custom exceptions
```

## 🔄 Package Migration

The service has been migrated from `com.finos.cashflow` to `com.lifecycle.cashflow`:

### Updated Components
- All Java package declarations
- All import statements
- Configuration files (application.yml)
- Database repository base packages
- Logging configurations
- Maven groupId

### Verification
```bash
# Search for any remaining old package references
grep -r "com.finos.cashflow" src/ || echo "✅ No old package references found"
```

## 🚨 Troubleshooting

### Service Won't Start
```bash
# Check logs
docker-compose logs cashflow-service

# Check health
docker-compose ps

# Restart dependencies
docker-compose restart postgres redis kafka
```

### Database Connection Issues
```bash
# Check PostgreSQL logs
docker-compose logs postgres

# Test connection
docker-compose exec postgres pg_isready -U postgres
```

### Performance Issues
```bash
# Check resource usage
docker stats

# Check application metrics
curl http://localhost:8081/actuator/metrics/jvm.memory.used
```

### Clean Reset
```bash
# Stop and remove all containers, networks, and volumes
docker-compose down --volumes --remove-orphans

# Remove images
docker rmi lifecycle/cashflow-generation-service:latest

# Rebuild and restart
./build-docker.sh
./deploy-docker.sh
```

## 📈 Production Considerations

### Environment Variables
- `POSTGRES_PASSWORD`: Secure database password
- `KAFKA_BOOTSTRAP_SERVERS`: Kafka cluster endpoints
- `REDIS_PASSWORD`: Redis authentication
- `JAVA_OPTS`: JVM tuning parameters

### Resource Limits
```yaml
# Add to docker-compose.yml services
deploy:
  resources:
    limits:
      memory: 1G
      cpus: '0.5'
    reservations:
      memory: 512M
      cpus: '0.25'
```

### Security
- Use secrets management for passwords
- Enable TLS for external connections
- Run with read-only root filesystem
- Use network segmentation

## 🎉 Success Criteria

✅ **All services healthy**
✅ **API endpoints responding**
✅ **Database connectivity working**
✅ **Actor system operational**
✅ **Thread partitioning active**
✅ **Monitoring functional**
✅ **Sample data loaded**
✅ **New package structure verified**
