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
