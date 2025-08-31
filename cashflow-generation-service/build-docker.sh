#!/bin/bash

# Docker Build Script for Cashflow Generation Service
set -e

echo "🐳 Building Cashflow Generation Service Docker Image"
echo "=================================================="

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Configuration
IMAGE_NAME="lifecycle/cashflow-generation-service"
IMAGE_TAG="${1:-latest}"
FULL_IMAGE_NAME="${IMAGE_NAME}:${IMAGE_TAG}"

echo -e "${BLUE}📋 Configuration:${NC}"
echo "  - Image Name: ${FULL_IMAGE_NAME}"
echo "  - Package: com.lifecycle.cashflow"
echo "  - Java Version: 21"
echo ""

# Build the Docker image
echo -e "${YELLOW}🔨 Building Docker image...${NC}"
docker build -t "${FULL_IMAGE_NAME}" .

if [ $? -eq 0 ]; then
    echo -e "${GREEN}✅ Docker image built successfully!${NC}"
    echo ""
    
    # Show image information
    echo -e "${BLUE}📊 Image Information:${NC}"
    docker images | grep "${IMAGE_NAME}" | head -1
    echo ""
    
    # Show image size
    IMAGE_SIZE=$(docker images --format "table {{.Repository}}\t{{.Tag}}\t{{.Size}}" | grep "${IMAGE_NAME}" | grep "${IMAGE_TAG}" | awk '{print $3}')
    echo -e "${BLUE}📦 Image Size: ${GREEN}${IMAGE_SIZE}${NC}"
    echo ""
    
    echo -e "${GREEN}🚀 Ready for deployment!${NC}"
    echo ""
    echo -e "${BLUE}Next steps:${NC}"
    echo "  1. Start services: ./deploy-docker.sh"
    echo "  2. Test endpoints: ./test-docker.sh"
    echo "  3. View logs: docker-compose logs -f cashflow-service"
    echo "  4. Stop services: docker-compose down"
    
else
    echo -e "${RED}❌ Docker build failed!${NC}"
    exit 1
fi
