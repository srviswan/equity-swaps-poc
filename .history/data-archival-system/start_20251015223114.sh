#!/bin/bash

echo "Starting SQL Server archival system..."

# Start Docker Compose
docker-compose up -d

echo "Waiting for SQL Server to be ready..."
sleep 30

# Check if SQL Server is ready
while ! docker exec archival-sqlserver /opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P 'Archival@2025!' -C -Q 'SELECT 1' > /dev/null 2>&1; do
    echo "Waiting for SQL Server..."
    sleep 5
done

echo "SQL Server is ready!"
echo "Connection string: Server=localhost,1434;Database=master;User Id=sa;Password=Archival@2025!;Encrypt=false;"
echo ""
echo "To connect with sqlcmd:"
echo "docker exec -it archival-sqlserver /opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P 'Archival@2025!' -C"
echo ""
echo "To stop the system:"
echo "docker-compose down"
