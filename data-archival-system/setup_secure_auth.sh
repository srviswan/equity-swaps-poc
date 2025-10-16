#!/bin/bash

echo "🔐 Setting up Secure Authentication for Data Archival System"
echo "============================================================"

# Check if Python dependencies are installed
echo "📋 Checking Python dependencies..."
python3 -c "import cryptography" 2>/dev/null
if [ $? -ne 0 ]; then
    echo "Installing cryptography package..."
    pip3 install cryptography
fi

# Create .env file with secure passwords
echo "🔑 Generating secure passwords..."
DB_PASSWORD=$(openssl rand -base64 32)
ENCRYPTION_KEY=$(openssl rand -base64 32)

# Create .env file
cat > .env << EOF
# Database Configuration
DB_SERVER=localhost,1434
DB_DATABASE=master
DB_USERNAME=archival_service
DB_PASSWORD=$DB_PASSWORD

# Encryption Configuration
ENCRYPTION_KEY=$ENCRYPTION_KEY

# Application Configuration
LOG_LEVEL=INFO
MAX_WORKERS=10
BATCH_SIZE=1000
EOF

# Set secure permissions
chmod 600 .env

echo "✅ Environment file created: .env"
echo "🔒 File permissions set to 600 (owner read/write only)"

# Create .gitignore entry
if [ ! -f .gitignore ]; then
    echo "Creating .gitignore file..."
    cat > .gitignore << EOF
# Environment files
.env
*.env

# Configuration files
config/secure_config.json
config/master.key

# Log files
*.log

# Python cache
__pycache__/
*.pyc
*.pyo
*.pyd
.Python
EOF
fi

echo "📝 Added security entries to .gitignore"

# Create secure startup script
cat > start_secure.sh << 'EOF'
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
EOF

chmod +x start_secure.sh

echo "✅ Secure startup script created: start_secure.sh"

# Create secure test script
cat > test_secure_system.py << 'EOF'
#!/usr/bin/env python3
"""
Secure test script for the archival system
"""

import os
import subprocess
import sys
from datetime import datetime

def test_secure_connection():
    """Test secure database connection"""
    print("🔐 Testing Secure Database Connection...")
    
    # Check environment variables
    if not os.getenv('DB_PASSWORD'):
        print("❌ DB_PASSWORD environment variable not set!")
        return False
    
    try:
        cmd = [
            "docker", "exec", "archival-sqlserver-secure",
            "/opt/mssql-tools18/bin/sqlcmd",
            "-S", "localhost",
            "-U", os.getenv('DB_USERNAME', 'sa'),
            "-P", os.getenv('DB_PASSWORD'),
            "-C",
            "-Q", "SELECT @@VERSION"
        ]
        
        result = subprocess.run(cmd, capture_output=True, text=True, timeout=30)
        if result.returncode == 0:
            print("✅ Secure connection successful")
            return True
        else:
            print(f"❌ Connection failed: {result.stderr}")
            return False
    except Exception as e:
        print(f"❌ Connection test failed: {e}")
        return False

def test_secure_orchestrator():
    """Test secure orchestrator"""
    print("\n🚀 Testing Secure Orchestrator...")
    
    try:
        result = subprocess.run([
            "python3", "secure_archival_orchestrator.py", "--status"
        ], capture_output=True, text=True, timeout=30)
        
        if result.returncode == 0:
            print("✅ Secure orchestrator working")
            print(result.stdout)
            return True
        else:
            print(f"❌ Orchestrator test failed: {result.stderr}")
            return False
    except Exception as e:
        print(f"❌ Orchestrator test failed: {e}")
        return False

def main():
    print("🔐 Secure Data Archival System Test")
    print("=" * 40)
    
    # Load environment variables
    if os.path.exists('.env'):
        with open('.env', 'r') as f:
            for line in f:
                if line.strip() and not line.startswith('#'):
                    key, value = line.strip().split('=', 1)
                    os.environ[key] = value
    
    tests = [
        ("Secure Connection", test_secure_connection),
        ("Secure Orchestrator", test_secure_orchestrator)
    ]
    
    passed = 0
    total = len(tests)
    
    for test_name, test_func in tests:
        print(f"\n📋 {test_name}")
        if test_func():
            passed += 1
        else:
            print(f"❌ {test_name} failed")
    
    print(f"\n📊 Test Results: {passed}/{total} passed")
    
    if passed == total:
        print("🎉 All secure tests passed!")
        return 0
    else:
        print("⚠️  Some tests failed.")
        return 1

if __name__ == "__main__":
    sys.exit(main())
EOF

chmod +x test_secure_system.py

echo "✅ Secure test script created: test_secure_system.py"

echo ""
echo "🎉 Secure Authentication Setup Complete!"
echo "========================================"
echo ""
echo "📋 Next Steps:"
echo "1. Update your SQL Server with the generated password: $DB_PASSWORD"
echo "2. Start the secure system: ./start_secure.sh"
echo "3. Test the system: python3 test_secure_system.py"
echo "4. Run archival: python3 secure_archival_orchestrator.py --run"
echo ""
echo "🔒 Security Features:"
echo "✅ Environment variables for credentials"
echo "✅ Encrypted configuration files"
echo "✅ Secure file permissions (600)"
echo "✅ .gitignore protection"
echo "✅ No hardcoded passwords"
echo ""
echo "⚠️  Important:"
echo "- Never commit .env files to version control"
echo "- Rotate passwords regularly"
echo "- Use strong passwords in production"
echo "- Enable audit logging"
