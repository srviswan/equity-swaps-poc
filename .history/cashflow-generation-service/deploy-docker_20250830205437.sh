#!/bin/bash

# Docker Deployment Script for Cashflow Generation Service
set -e

echo "🚀 Deploying Cashflow Generation Service with Docker Compose"
echo "=========================================================="

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Check if Docker and Docker Compose are installed
if ! command -v docker &> /dev/null; then
    echo -e "${RED}❌ Docker is not installed!${NC}"
    exit 1
fi

if ! command -v docker-compose &> /dev/null; then
    echo -e "${RED}❌ Docker Compose is not installed!${NC}"
    exit 1
fi

echo -e "${BLUE}📋 Deployment Configuration:${NC}"
echo "  - Service: Cashflow Generation Service"
echo "  - Package: com.lifecycle.cashflow"
echo "  - Dependencies: PostgreSQL, Redis, Kafka"
echo "  - Monitoring: Prometheus, Grafana"
echo ""

# Stop any existing services
echo -e "${YELLOW}🛑 Stopping existing services...${NC}"
docker-compose down --volumes --remove-orphans

# Build the application image
echo -e "${YELLOW}🔨 Building application image...${NC}"
./build-docker.sh

# Start the services
echo -e "${YELLOW}🚀 Starting services...${NC}"
docker-compose up -d

echo -e "${GREEN}✅ Services started successfully!${NC}"
echo ""

# Wait for services to be healthy
echo -e "${YELLOW}⏳ Waiting for services to be healthy...${NC}"
echo -e "${BLUE}This may take 60-90 seconds for all services to start...${NC}"

# Check service status
sleep 10
for i in {1..30}; do
    if docker-compose ps | grep -q "Up (healthy)"; then
        break
    fi
    echo -n "."
    sleep 3
done
echo ""

# Show service status
echo -e "${BLUE}📊 Service Status:${NC}"
docker-compose ps

echo ""
echo -e "${GREEN}🎉 Deployment Complete!${NC}"
echo ""
echo -e "${BLUE}🌐 Service Endpoints:${NC}"
echo "  - Cashflow API:      http://localhost:8080"
echo "  - Health Check:      http://localhost:8080/health"
echo "  - Management:        http://localhost:8081/actuator"
echo "  - Prometheus:        http://localhost:9090"
echo "  - Grafana:           http://localhost:3000 (admin/admin)"
echo ""
echo -e "${BLUE}💾 Database Connections:${NC}"
echo "  - PostgreSQL:        localhost:5432 (postgres/password)"
echo "  - Redis:             localhost:6379"
echo "  - Kafka:             localhost:9092"
echo ""
echo -e "${BLUE}🔧 Useful Commands:${NC}"
echo "  - View logs:         docker-compose logs -f cashflow-service"
echo "  - Test endpoints:    ./test-docker.sh"
echo "  - Stop services:     docker-compose down"
echo "  - Restart service:   docker-compose restart cashflow-service"
