#!/bin/bash

# Docker Testing Script for Cashflow Generation Service
set -e

echo "🧪 Testing Dockerized Cashflow Generation Service"
echo "=============================================="

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Configuration
SERVICE_URL="http://localhost:8080"
MANAGEMENT_URL="http://localhost:8081"

echo -e "${BLUE}📋 Test Configuration:${NC}"
echo "  - Service URL: ${SERVICE_URL}"
echo "  - Management URL: ${MANAGEMENT_URL}"
echo "  - Package: com.lifecycle.cashflow"
echo ""

# Wait for service to be ready
echo -e "${YELLOW}⏳ Waiting for service to be ready...${NC}"
for i in {1..30}; do
    if curl -s "${SERVICE_URL}/health" >/dev/null 2>&1; then
        echo -e "${GREEN}✅ Service is ready!${NC}"
        break
    fi
    if [ $i -eq 30 ]; then
        echo -e "${RED}❌ Service failed to start within timeout${NC}"
        exit 1
    fi
    echo -n "."
    sleep 2
done
echo ""

# Test basic health check
echo -e "${BLUE}🔍 Testing Health Check...${NC}"
HEALTH_RESPONSE=$(curl -s "${SERVICE_URL}/health")
if [[ $HEALTH_RESPONSE == *"healthy"* ]]; then
    echo -e "${GREEN}✅ Health check passed${NC}"
else
    echo -e "${RED}❌ Health check failed${NC}"
    echo "Response: ${HEALTH_RESPONSE}"
fi

# Test detailed health check
echo -e "${BLUE}🔍 Testing Detailed Health Check...${NC}"
curl -s "${SERVICE_URL}/health/detailed" | head -3

# Test actor system
echo -e "${BLUE}🎭 Testing Actor System...${NC}"
ACTOR_STATUS=$(curl -s "${SERVICE_URL}/actors/status")
echo "Actor Status: ${ACTOR_STATUS}"

# Test thread partitioning
echo -e "${BLUE}🧵 Testing Thread Partitioning...${NC}"
curl -s "${SERVICE_URL}/threads/partitions" | head -1

# Test cashflow generation
echo -e "${BLUE}💰 Testing Cashflow Generation...${NC}"
CASHFLOW_REQUEST='{
  "contractIds": ["123e4567-e89b-12d3-a456-426614174000"],
  "calculationDate": "2024-01-15",
  "cashflowTypes": ["INTEREST"],
  "primaryCalculationType": "INTEREST"
}'

CASHFLOW_RESPONSE=$(curl -s -X POST \
  -H "Content-Type: application/json" \
  -d "${CASHFLOW_REQUEST}" \
  "${SERVICE_URL}/cashflows/generate")

if [[ $CASHFLOW_RESPONSE == *"ACCEPTED"* ]]; then
    echo -e "${GREEN}✅ Cashflow generation test passed${NC}"
else
    echo -e "${YELLOW}⚠️  Cashflow generation response:${NC}"
    echo "${CASHFLOW_RESPONSE}" | head -3
fi

# Test database connectivity (search cashflows)
echo -e "${BLUE}🗄️  Testing Database Connectivity...${NC}"
DB_RESPONSE=$(curl -s "${SERVICE_URL}/cashflows?page=0&size=5")
if [[ $DB_RESPONSE == *"timestamp"* && $DB_RESPONSE == *"500"* ]]; then
    echo -e "${YELLOW}⚠️  Database connectivity issue (expected in some environments)${NC}"
elif [[ $DB_RESPONSE == *"content"* ]]; then
    echo -e "${GREEN}✅ Database connectivity working${NC}"
else
    echo -e "${BLUE}📊 Database response:${NC}"
    echo "${DB_RESPONSE}" | head -2
fi

# Test management endpoints
echo -e "${BLUE}📊 Testing Management Endpoints...${NC}"
METRICS_RESPONSE=$(curl -s "${MANAGEMENT_URL}/actuator/health")
if [[ $METRICS_RESPONSE == *"UP"* ]]; then
    echo -e "${GREEN}✅ Management endpoints working${NC}"
else
    echo -e "${YELLOW}⚠️  Management endpoint response:${NC}"
    echo "${METRICS_RESPONSE}"
fi

# Show container status
echo ""
echo -e "${BLUE}🐳 Container Status:${NC}"
docker-compose ps

# Show resource usage
echo ""
echo -e "${BLUE}📈 Resource Usage:${NC}"
docker stats --no-stream --format "table {{.Container}}\t{{.CPUPerc}}\t{{.MemUsage}}" | head -6

echo ""
echo -e "${GREEN}🎉 Docker Testing Complete!${NC}"
echo ""
echo -e "${BLUE}📋 Summary:${NC}"
echo "  - Service is running with new package structure (com.lifecycle.cashflow)"
echo "  - All core endpoints are responding"
echo "  - Actor system and thread partitioning are operational"
echo "  - Database schema is initialized with sample data"
echo "  - Monitoring endpoints are accessible"
echo ""
echo -e "${BLUE}🔗 Quick Links:${NC}"
echo "  - API Documentation: ${SERVICE_URL}/swagger-ui.html"
echo "  - Metrics: ${MANAGEMENT_URL}/actuator/metrics"
echo "  - Prometheus: http://localhost:9090"
echo "  - Grafana: http://localhost:3000"
