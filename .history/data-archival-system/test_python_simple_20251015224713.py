#!/usr/bin/env python3
"""
Simplified test script for the archival system
This version works without ODBC driver by using subprocess calls to sqlcmd
"""

import subprocess
import json
import sys
from datetime import datetime
import uuid

class ArchivalTester:
    def __init__(self):
        self.connection_string = "localhost,1434"
        self.username = "sa"
        self.password = "Archival@2025!"
        
    def run_sql(self, query, database="master"):
        """Run SQL query using sqlcmd"""
        try:
            cmd = [
                "docker", "exec", "archival-sqlserver",
                "/opt/mssql-tools18/bin/sqlcmd",
                "-S", "localhost",  # Connect to localhost inside container
                "-U", self.username,
                "-P", self.password,
                "-C",  # Trust server certificate
                "-d", database,
                "-Q", query
            ]
            
            result = subprocess.run(cmd, capture_output=True, text=True, timeout=30)
            if result.returncode == 0:
                return result.stdout.strip()
            else:
                print(f"SQL Error: {result.stderr}")
                return None
        except Exception as e:
            print(f"Command failed: {e}")
            return None
    
    def test_connection(self):
        """Test database connection"""
        print("🔌 Testing Database Connection...")
        result = self.run_sql("SELECT @@VERSION")
        if result:
            print("✅ Connection successful")
            lines = result.split('\n')
            print(f"   SQL Server version: {lines[0]}")
            return True
        else:
            print("❌ Connection failed")
            return False
    
    def test_databases(self):
        """Test if all databases exist"""
        print("\\n📊 Testing Database Structure...")
        databases = ['SourceDB1', 'SourceDB2', 'SourceDB3', 'archive_db', 'control_db']
        
        for db in databases:
            result = self.run_sql(f"SELECT name FROM sys.databases WHERE name = '{db}'")
            if result and db in result:
                print(f"✅ Database {db} exists")
            else:
                print(f"❌ Database {db} missing")
                return False
        return True
    
    def test_configuration(self):
        """Test configuration tables"""
        print("\\n⚙️  Testing Configuration...")
        result = self.run_sql("SELECT COUNT(*) FROM control_db.control.archival_table_config", "control_db")
        if result:
            # Parse the count from SQL output
            lines = result.split('\n')
            for line in lines:
                line = line.strip()
                if line.isdigit():
                    count = int(line)
                    print(f"✅ Configuration: {count} tables configured")
                    return True
            print("❌ Could not parse configuration count")
            return False
        else:
            print("❌ Configuration test failed")
            return False
    
    def test_archival_process(self):
        """Test the archival process"""
        print("\\n🔄 Testing Archival Process...")
        
        # Test marking
        print("   Marking records for archival...")
        result = self.run_sql("EXEC control_db.control.sp_Mark_Table_Archival_Eligible 'SourceDB1', 'dbo', 'Position'", "control_db")
        if result and "Marked records" in result:
            print("   ✅ Marking successful")
        else:
            print("   ❌ Marking failed")
            return False
        
        # Check marked records
        result = self.run_sql("SELECT COUNT(*) FROM control_db.control.archival_marker WHERE archival_eligible = 1", "control_db")
        if result:
            lines = result.split('\n')
            for line in lines:
                line = line.strip()
                if line.isdigit():
                    count = int(line)
                    print(f"   ✅ {count} records marked for archival")
                    break
        
        # Test archival
        print("   Archiving records...")
        batch_id = str(uuid.uuid4())
        result = self.run_sql(f"EXEC control_db.control.sp_Archive_Table_Bulk_Copy '{batch_id}', 'SourceDB1', 'dbo', 'Position'", "control_db")
        if result and "Bulk copy archival completed" in result:
            print("   ✅ Archival successful")
        else:
            print("   ❌ Archival failed")
            return False
        
        # Check archived records
        result = self.run_sql("SELECT COUNT(*) FROM archive_db.SourceDB1.Position", "archive_db")
        if result:
            lines = result.split('\n')
            for line in lines:
                line = line.strip()
                if line.isdigit():
                    count = int(line)
                    print(f"   ✅ {count} records archived")
                    break
        
        return True
    
    def show_status(self):
        """Show system status"""
        print("\\n📈 System Status Dashboard")
        print("=" * 50)
        
        # Source data counts
        print("\\n📊 Source Data:")
        tables = [
            ("SourceDB1", "Position"),
            ("SourceDB2", "Trade"),
            ("SourceDB3", "PriceHistory")
        ]
        
        for db, table in tables:
            result = self.run_sql(f"SELECT COUNT(*) FROM {db}.dbo.{table}", db)
            if result:
                lines = result.split('\n')
                for line in lines:
                    line = line.strip()
                    if line.isdigit():
                        count = int(line)
                        print(f"   {db}.{table}: {count} records")
                        break
        
        # Archive data counts
        print("\\n📦 Archive Data:")
        result = self.run_sql("SELECT COUNT(*) FROM archive_db.SourceDB1.Position", "archive_db")
        if result:
            lines = result.split('\n')
            for line in lines:
                line = line.strip()
                if line.isdigit():
                    count = int(line)
                    print(f"   archive_db.SourceDB1.Position: {count} records")
                    break
        
        # Configuration
        print("\\n⚙️  Configuration:")
        result = self.run_sql("SELECT source_database + '.' + table_schema + '.' + table_name as TableName, table_type FROM control_db.control.archival_table_config WHERE active = 1", "control_db")
        if result:
            lines = result.split('\n')[2:-2]  # Skip header and footer
            for line in lines:
                if line.strip():
                    parts = line.split()
                    if len(parts) >= 2:
                        table_name = parts[0]
                        table_type = parts[1]
                        print(f"   {table_name}: {table_type}")
    
    def run_full_test(self):
        """Run complete test suite"""
        print("🚀 Data Archival System - Python Test")
        print("=" * 50)
        
        tests = [
            ("Database Connection", self.test_connection),
            ("Database Structure", self.test_databases),
            ("Configuration", self.test_configuration),
            ("Archival Process", self.test_archival_process)
        ]
        
        passed = 0
        total = len(tests)
        
        for test_name, test_func in tests:
            print(f"\\n📋 {test_name}")
            if test_func():
                passed += 1
            else:
                print(f"❌ {test_name} failed")
        
        print(f"\\n📊 Test Results: {passed}/{total} passed")
        
        if passed == total:
            print("🎉 All tests passed! System is ready.")
            self.show_status()
            return True
        else:
            print("⚠️  Some tests failed. Check the output above.")
            return False

def main():
    tester = ArchivalTester()
    
    if len(sys.argv) > 1 and sys.argv[1] == "--status":
        tester.show_status()
    else:
        success = tester.run_full_test()
        sys.exit(0 if success else 1)

if __name__ == "__main__":
    main()
