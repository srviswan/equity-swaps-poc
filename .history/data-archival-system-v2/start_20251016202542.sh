#!/bin/bash

echo "========================================="
echo "Starting Data Archival System V2"
echo "========================================="
echo ""

# Start Docker Compose
echo "Starting SQL Server container..."
docker-compose up -d

echo ""
echo "Waiting for SQL Server to be ready..."
sleep 30

# Check if SQL Server is ready
while ! docker exec archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P 'Archival@2025!' -C -Q 'SELECT 1' > /dev/null 2>&1; do
    echo "Waiting for SQL Server..."
    sleep 5
done

echo ""
echo "✓ SQL Server is ready!"
echo ""
echo "========================================="
echo "System Information"
echo "========================================="
echo "SQL Server Port: 1435"
echo "Connection: Server=localhost,1435;User Id=sa;Password=Archival@2025!;Encrypt=false;"
echo ""
echo "To connect with sqlcmd:"
echo "docker exec -it archival-sqlserver-v2 /opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P 'Archival@2025!' -C"
echo ""
echo "To stop the system:"
echo "docker-compose down"
echo ""
echo "========================================="
echo "Next Steps"
echo "========================================="
echo "1. Install Python dependencies: pip3 install -r requirements.txt"
echo "2. Run test: python3 test_system.py"
echo "3. Run orchestrator: python3 orchestrator.py --run"
echo ""
