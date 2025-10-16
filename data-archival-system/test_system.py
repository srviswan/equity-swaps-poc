#!/usr/bin/env python3
"""
Test script for the archival system
"""

import pyodbc
import sys
from datetime import datetime

def test_connection():
    """Test database connection"""
    try:
        conn_str = "DRIVER={ODBC Driver 17 for SQL Server};SERVER=localhost,1434;DATABASE=master;UID=sa;PWD=Archival@2025!;Encrypt=false;"
        conn = pyodbc.connect(conn_str)
        cursor = conn.cursor()
        cursor.execute("SELECT @@VERSION")
        version = cursor.fetchone()[0]
        print(f"✅ Connected to SQL Server: {version[:50]}...")
        conn.close()
        return True
    except Exception as e:
        print(f"❌ Connection failed: {e}")
        return False

def test_databases():
    """Test if all databases exist"""
    try:
        conn_str = "DRIVER={ODBC Driver 17 for SQL Server};SERVER=localhost,1434;DATABASE=master;UID=sa;PWD=Archival@2025!;Encrypt=false;"
        conn = pyodbc.connect(conn_str)
        cursor = conn.cursor()
        
        databases = ['SourceDB1', 'SourceDB2', 'SourceDB3', 'archive_db', 'control_db']
        
        for db in databases:
            cursor.execute(f"SELECT name FROM sys.databases WHERE name = '{db}'")
            if cursor.fetchone():
                print(f"✅ Database {db} exists")
            else:
                print(f"❌ Database {db} missing")
                return False
        
        conn.close()
        return True
    except Exception as e:
        print(f"❌ Database check failed: {e}")
        return False

def test_tables():
    """Test if test tables exist and have data"""
    try:
        conn_str = "DRIVER={ODBC Driver 17 for SQL Server};SERVER=localhost,1434;DATABASE=master;UID=sa;PWD=Archival@2025!;Encrypt=false;"
        conn = pyodbc.connect(conn_str)
        cursor = conn.cursor()
        
        # Test SourceDB1.Position
        cursor.execute("SELECT COUNT(*) FROM SourceDB1.dbo.Position")
        count = cursor.fetchone()[0]
        print(f"✅ SourceDB1.Position: {count} records")
        
        # Test SourceDB2.Trade
        cursor.execute("SELECT COUNT(*) FROM SourceDB2.dbo.Trade")
        count = cursor.fetchone()[0]
        print(f"✅ SourceDB2.Trade: {count} records")
        
        # Test SourceDB3.PriceHistory
        cursor.execute("SELECT COUNT(*) FROM SourceDB3.dbo.PriceHistory")
        count = cursor.fetchone()[0]
        print(f"✅ SourceDB3.PriceHistory: {count} records")
        
        # Test configuration
        cursor.execute("SELECT COUNT(*) FROM control_db.control.archival_table_config")
        count = cursor.fetchone()[0]
        print(f"✅ Configuration: {count} tables configured")
        
        conn.close()
        return True
    except Exception as e:
        print(f"❌ Table check failed: {e}")
        return False

def test_archival():
    """Test archival process"""
    try:
        conn_str = "DRIVER={ODBC Driver 17 for SQL Server};SERVER=localhost,1434;DATABASE=master;UID=sa;PWD=Archival@2025!;Encrypt=false;"
        conn = pyodbc.connect(conn_str)
        cursor = conn.cursor()
        
        print("\n🧪 Testing archival process...")
        
        # Test marking
        cursor.execute("EXEC control_db.control.sp_Mark_Table_Archival_Eligible 'SourceDB1', 'dbo', 'Position'")
        print("✅ Marking procedure executed")
        
        # Check markers
        cursor.execute("SELECT COUNT(*) FROM control_db.control.archival_marker WHERE archival_eligible = 1")
        count = cursor.fetchone()[0]
        print(f"✅ {count} records marked for archival")
        
        # Test archival
        batch_id = "00000000-0000-0000-0000-000000000001"
        cursor.execute("EXEC control_db.control.sp_Archive_Table_Bulk_Copy ?, 'SourceDB1', 'dbo', 'Position'", batch_id)
        print("✅ Archival procedure executed")
        
        # Check archive
        cursor.execute("SELECT COUNT(*) FROM archive_db.SourceDB1.Position")
        count = cursor.fetchone()[0]
        print(f"✅ {count} records in archive")
        
        conn.close()
        return True
    except Exception as e:
        print(f"❌ Archival test failed: {e}")
        return False

def main():
    print("🚀 Testing Data Archival System")
    print("=" * 40)
    
    tests = [
        ("Database Connection", test_connection),
        ("Database Existence", test_databases),
        ("Table Data", test_tables),
        ("Archival Process", test_archival)
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
        print("🎉 All tests passed! System is ready.")
        return 0
    else:
        print("⚠️  Some tests failed. Check the output above.")
        return 1

if __name__ == "__main__":
    sys.exit(main())
