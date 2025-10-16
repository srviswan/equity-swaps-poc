#!/bin/bash

echo "🔐 Starting Secure Data Archival System"
echo "========================================"

# Check if .env file exists
if [ ! -f .env ]; then
    echo "❌ Error: .env file not found!"
    echo "Please run: ./setup_secure_auth.sh"
    exit 1
fi

# Load environment variables
export $(cat .env | grep -v '^#' | xargs)

# Start Docker with secure configuration
echo "🚀 Starting SQL Server with secure configuration..."
docker-compose -f secure-docker-compose.yml up -d

echo "⏳ Waiting for SQL Server to be ready..."
sleep 30

# Check if SQL Server is ready
while ! docker exec archival-sqlserver-secure /opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P "$DB_PASSWORD" -C -Q 'SELECT 1' > /dev/null 2>&1; do
    echo "Waiting for SQL Server..."
    sleep 5
done

echo "✅ SQL Server is ready!"
echo "🔐 Using secure authentication with environment variables"
echo ""
echo "📋 Available commands:"
echo "  python3 secure_archival_orchestrator.py --status"
echo "  python3 secure_archival_orchestrator.py --run"
echo ""
echo "🛑 To stop the system:"
echo "  docker-compose -f secure-docker-compose.yml down"
