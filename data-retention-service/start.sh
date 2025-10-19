#!/bin/bash
# start.sh
# Start SQL Server container for Data Retention Service

set -e

# Configuration
CONTAINER_NAME="archival-sqlserver-v2"
IMAGE_NAME="mcr.microsoft.com/mssql/server:2022-latest"
SA_PASSWORD="Archival@2025!"
PORT="1433"

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Function to print colored output
print_status() {
    local status=$1
    local message=$2
    case $status in
        "SUCCESS")
            echo -e "${GREEN}✓${NC} $message"
            ;;
        "ERROR")
            echo -e "${RED}✗${NC} $message"
            ;;
        "WARNING")
            echo -e "${YELLOW}⚠${NC} $message"
            ;;
        "INFO")
            echo -e "${BLUE}→${NC} $message"
            ;;
    esac
}

# Function to check if Docker is running
check_docker() {
    if ! docker info > /dev/null 2>&1; then
        print_status "ERROR" "Docker is not running or not accessible"
        print_status "ERROR" "Please start Docker and try again"
        exit 1
    fi
    print_status "SUCCESS" "Docker is running"
}

# Function to check if container already exists
check_existing_container() {
    if docker ps -a --format "table {{.Names}}" | grep -q "^${CONTAINER_NAME}$"; then
        if docker ps --format "table {{.Names}}" | grep -q "^${CONTAINER_NAME}$"; then
            print_status "INFO" "Container $CONTAINER_NAME is already running"
            return 0
        else
            print_status "INFO" "Container $CONTAINER_NAME exists but is stopped"
            return 1
        fi
    else
        print_status "INFO" "Container $CONTAINER_NAME does not exist"
        return 2
    fi
}

# Function to start existing container
start_existing_container() {
    print_status "INFO" "Starting existing container $CONTAINER_NAME..."
    if docker start $CONTAINER_NAME > /dev/null 2>&1; then
        print_status "SUCCESS" "Container $CONTAINER_NAME started"
        return 0
    else
        print_status "ERROR" "Failed to start container $CONTAINER_NAME"
        return 1
    fi
}

# Function to create new container
create_new_container() {
    print_status "INFO" "Creating new SQL Server container..."
    
    # Create docker-compose.yml if it doesn't exist
    if [ ! -f "docker-compose.yml" ]; then
        print_status "INFO" "Creating docker-compose.yml..."
        cat > docker-compose.yml << EOF
version: '3.8'

services:
  sqlserver:
    image: $IMAGE_NAME
    container_name: $CONTAINER_NAME
    environment:
      - ACCEPT_EULA=Y
      - SA_PASSWORD=$SA_PASSWORD
      - MSSQL_PID=Developer
    ports:
      - "$PORT:1433"
    volumes:
      - sqlserver_data:/var/opt/mssql
      - ./setup:/docker-entrypoint-initdb.d/setup:ro
      - ./archival:/docker-entrypoint-initdb.d/archival:ro
    healthcheck:
      test: ["CMD-SHELL", "/opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P '$SA_PASSWORD' -C -Q 'SELECT 1'"]
      interval: 30s
      timeout: 10s
      retries: 5
      start_period: 30s
    restart: unless-stopped

volumes:
  sqlserver_data:
EOF
        print_status "SUCCESS" "Created docker-compose.yml"
    fi
    
    # Start container using docker-compose
    print_status "INFO" "Starting SQL Server container with docker-compose..."
    if docker-compose up -d; then
        print_status "SUCCESS" "Container started with docker-compose"
        return 0
    else
        print_status "ERROR" "Failed to start container with docker-compose"
        return 1
    fi
}

# Function to wait for SQL Server to be ready
wait_for_sql_server() {
    print_status "INFO" "Waiting for SQL Server to be ready..."
    
    local max_attempts=60
    local attempt=1
    
    while [ $attempt -le $max_attempts ]; do
        if docker exec $CONTAINER_NAME /opt/mssql-tools18/bin/sqlcmd \
            -S localhost -U sa -P "$SA_PASSWORD" -C -Q "SELECT 1" > /dev/null 2>&1; then
            print_status "SUCCESS" "SQL Server is ready!"
            return 0
        fi
        
        if [ $((attempt % 10)) -eq 0 ]; then
            print_status "INFO" "Still waiting for SQL Server... (attempt $attempt/$max_attempts)"
        fi
        
        sleep 5
        ((attempt++))
    done
    
    print_status "ERROR" "SQL Server is not responding after $max_attempts attempts"
    print_status "ERROR" "Please check container logs: docker logs $CONTAINER_NAME"
    return 1
}

# Function to show connection information
show_connection_info() {
    echo ""
    echo "========================================"
    echo "Connection Information"
    echo "========================================"
    echo "Server: localhost,$PORT"
    echo "Username: sa"
    echo "Password: $SA_PASSWORD"
    echo "Container: $CONTAINER_NAME"
    echo ""
    echo "Connection string:"
    echo "Server=localhost,$PORT;Database=master;User Id=sa;Password=$SA_PASSWORD;TrustServerCertificate=true;"
    echo ""
    echo "GUI Tools:"
    echo "  - Azure Data Studio: Connect to localhost,$PORT"
    echo "  - DBeaver: SQL Server connection to localhost:$PORT"
    echo "  - SQL Server Management Studio: localhost,$PORT"
    echo ""
}

# Function to show next steps
show_next_steps() {
    echo "========================================"
    echo "Next Steps"
    echo "========================================"
    echo "1. Initialize control database:"
    echo "   ./init_control_db.sh"
    echo ""
    echo "2. Configure archival tables:"
    echo "   # Add entries to control.archival_table_list"
    echo "   # Example: INSERT INTO control.archival_table_list (...) VALUES (...);"
    echo ""
    echo "3. Run archival workflow:"
    echo "   python3 orchestrator.py --run"
    echo ""
    echo "4. Monitor system:"
    echo "   python3 orchestrator.py --status"
    echo ""
    echo "5. Run tests (optional):"
    echo "   ./tests/run_tests.sh"
    echo ""
}

# Main execution
main() {
    echo "========================================"
    echo "Data Retention Service - SQL Server Setup"
    echo "========================================"
    echo "This script starts the SQL Server container for the Data Retention Service."
    echo ""
    
    # Check Docker
    check_docker
    
    # Check existing container
    local container_status
    check_existing_container
    container_status=$?
    
    case $container_status in
        0)
            # Container is already running
            print_status "SUCCESS" "SQL Server container is already running"
            ;;
        1)
            # Container exists but is stopped
            if start_existing_container; then
                print_status "SUCCESS" "Existing container started"
            else
                print_status "ERROR" "Failed to start existing container"
                exit 1
            fi
            ;;
        2)
            # Container doesn't exist
            if create_new_container; then
                print_status "SUCCESS" "New container created and started"
            else
                print_status "ERROR" "Failed to create new container"
                exit 1
            fi
            ;;
    esac
    
    # Wait for SQL Server to be ready
    if wait_for_sql_server; then
        echo ""
        print_status "SUCCESS" "SQL Server is ready for connections!"
        
        # Show connection information
        show_connection_info
        
        # Show next steps
        show_next_steps
        
    else
        print_status "ERROR" "SQL Server failed to start properly"
        print_status "ERROR" "Please check the logs and try again"
        exit 1
    fi
}

# Handle script arguments
case "${1:-}" in
    --help|-h)
        echo "Usage: $0 [--help]"
        echo ""
        echo "Start SQL Server container for the Data Retention Service."
        echo ""
        echo "This script will:"
        echo "  - Check if Docker is running"
        echo "  - Start existing container or create new one"
        echo "  - Wait for SQL Server to be ready"
        echo "  - Show connection information"
        echo ""
        echo "Prerequisites:"
        echo "  - Docker must be installed and running"
        echo "  - Port 1433 must be available"
        echo ""
        echo "Options:"
        echo "  --help, -h    Show this help message"
        echo ""
        echo "After running this script:"
        echo "  - Run './init_control_db.sh' to initialize the control database"
        echo "  - Configure archival tables in control.archival_table_list"
        echo "  - Run 'python3 orchestrator.py --run' to start archival"
        exit 0
        ;;
    *)
        main
        ;;
esac
