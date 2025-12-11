#!/usr/bin/env python3
"""
Data Archival Orchestrator V2 - Base Implementation
Monthly archival workflow: Base Table → Monthly Archival Table → Archive DB
"""

import subprocess
import sys
import uuid
from datetime import datetime, timedelta
from typing import List, Dict, Optional
import argparse
import logging

# Configure logging
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s',
    handlers=[
        logging.FileHandler(f"archival_{datetime.now().strftime('%Y%m%d')}.log"),
        logging.StreamHandler()
    ]
)
logger = logging.getLogger('ArchivalOrchestrator')


class SQLExecutor:
    """Execute SQL commands via docker exec"""
    
    def __init__(self, container_name="archival-sqlserver-v2", username="sa", password="Archival@2025!"):
        self.container_name = container_name
        self.username = username
        self.password = password
        self.sqlcmd_path = "/opt/mssql-tools18/bin/sqlcmd"
    
    def execute(self, query: str, database: str = "master") -> Optional[str]:
        """Execute SQL query and return result"""
        try:
            cmd = [
                "docker", "exec", self.container_name,
                self.sqlcmd_path,
                "-S", "localhost",
                "-U", self.username,
                "-P", self.password,
                "-C",  # Trust server certificate
                "-d", database,
                "-Q", query,
                "-h", "-1",  # No headers
                "-W"  # Remove trailing spaces
            ]
            
            result = subprocess.run(cmd, capture_output=True, text=True, timeout=300)
            if result.returncode == 0:
                return result.stdout.strip()
            else:
                logger.error(f"SQL Error: {result.stderr}")
                return None
        except subprocess.TimeoutExpired:
            logger.error(f"SQL command timed out")
            return None
        except Exception as e:
            logger.error(f"Command failed: {e}")
            return None
    
    def execute_procedure(self, database: str, procedure: str, params: Dict = None) -> bool:
        """Execute stored procedure"""
        param_str = ""
        if params:
            param_list = [f"@{k} = '{v}'" if isinstance(v, str) else f"@{k} = {v}" 
                         for k, v in params.items()]
            param_str = ", ".join(param_list)
        
        query = f"EXEC {procedure} {param_str};"
        result = self.execute(query, database)
        return result is not None


class ArchivalOrchestrator:
    """Main orchestrator for monthly archival workflow"""
    
    def __init__(self):
        self.sql = SQLExecutor()
        self.batch_id = str(uuid.uuid4())
    
    def get_archival_table_list(self) -> List[Dict]:
        """Get list of tables configured for archival"""
        query = """
        SELECT 
            source_database,
            table_schema,
            table_name,
            months_before_archival,
            archive_db_schema,
            archive_db_table
        FROM control.archival_table_list
        WHERE archival_enabled = 1 AND active = 1;
        """
        
        result = self.sql.execute(query, "control_db")
        if not result:
            return []
        
        # Parse result (simplified parsing)
        tables = []
        for line in result.split('\n'):
            parts = line.strip().split()
            if len(parts) >= 6:
                tables.append({
                    'source_database': parts[0],
                    'table_schema': parts[1],
                    'table_name': parts[2],
                    'months_before_archival': parts[3],
                    'archive_db_schema': parts[4],
                    'archive_db_table': parts[5]
                })
        
        return tables
    
    def mark_records_for_archival(self, source_db: str, table_name: str) -> bool:
        """Step 1: Mark records for archival (set archival_flag = 1)"""
        logger.info(f"Step 1: Marking records for archival in {source_db}.{table_name}")
        
        return self.sql.execute_procedure(
            "control_db",
            "control.sp_Mark_Records_For_Archival",
            {
                'source_database': source_db,
                'table_name': table_name,
                'batch_id': self.batch_id
            }
        )
    
    def get_archival_months(self, source_db: str, table_name: str) -> List[str]:
        """Get list of distinct archival months for a table"""
        query = f"""
        SELECT DISTINCT archival_month
        FROM {source_db}.dbo.{table_name}
        WHERE archival_flag = 1 
          AND archival_month IS NOT NULL
        ORDER BY archival_month;
        """
        
        result = self.sql.execute(query, "master")
        if not result:
            return []
        
        months = [line.strip() for line in result.split('\n') if line.strip()]
        return months
    
    def move_to_monthly_archival(self, source_db: str, table_name: str, archival_month: str) -> bool:
        """Step 2: Move data to monthly archival table"""
        logger.info(f"Step 2: Moving {source_db}.{table_name} data for {archival_month} to monthly archival table")
        
        return self.sql.execute_procedure(
            "control_db",
            "control.sp_Move_To_Monthly_Archival_Fixed",
            {
                'source_database': source_db,
                'table_name': table_name,
                'archival_month': archival_month,
                'batch_id': self.batch_id
            }
        )
    
    def get_monthly_tables_to_move(self) -> List[Dict]:
        """Get monthly archival tables ready to move to archive DB"""
        # Move tables older than 1 month to archive DB
        query = """
        SELECT 
            source_database,
            base_table_name,
            archival_month,
            monthly_table_name
        FROM control.monthly_archival_tracking
        WHERE moved_to_archive_db = 0
          AND archival_month < FORMAT(DATEADD(MONTH, -1, GETDATE()), 'yyyyMM')
        ORDER BY archival_month;
        """
        
        result = self.sql.execute(query, "control_db")
        if not result:
            return []
        
        tables = []
        for line in result.split('\n'):
            parts = line.strip().split()
            if len(parts) >= 4:
                tables.append({
                    'source_database': parts[0],
                    'table_name': parts[1],
                    'archival_month': parts[2],
                    'monthly_table_name': parts[3]
                })
        
        return tables
    
    def move_to_archive_db(self, source_db: str, table_name: str, archival_month: str) -> bool:
        """Step 3: Move monthly archival table to archive DB"""
        logger.info(f"Step 3: Moving {source_db}.{table_name} for {archival_month} to archive_db")
        
        return self.sql.execute_procedure(
            "control_db",
            "control.sp_Move_To_Archive_DB",
            {
                'source_database': source_db,
                'table_name': table_name,
                'archival_month': archival_month,
                'batch_id': self.batch_id
            }
        )
    
    def partition_switch_archival(self, source_db: str, table_name: str) -> bool:
        """Partition switch archival: mark, partition switch, and cleanup in one step"""
        logger.info(f"Running partition switch archival for {source_db}.{table_name}")
        
        return self.sql.execute_procedure(
            "control_db",
            "control.sp_Partition_Switch_Archival",
            {
                'source_database': source_db,
                'table_name': table_name,
                'batch_id': self.batch_id
            }
        )
    
    def run_monthly_archival(self):
        """Run complete monthly archival workflow"""
        logger.info("=" * 80)
        logger.info(f"MONTHLY ARCHIVAL WORKFLOW - Batch ID: {self.batch_id}")
        logger.info(f"Started: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}")
        logger.info("=" * 80)
        
        # Get list of tables to archive
        tables = self.get_archival_table_list()
        if not tables:
            logger.warning("No tables configured for archival")
            return
        
        logger.info(f"Found {len(tables)} tables configured for archival")
        
        # Process each table using partition switching for high performance
        for table_config in tables:
            source_db = table_config['source_database']
            table_name = table_config['table_name']
            
            logger.info("-" * 80)
            logger.info(f"Processing {source_db}.{table_name}")
            
            # Use partition switching for high-performance archival
            if not self.partition_switch_archival(source_db, table_name):
                logger.error(f"Failed to archive {source_db}.{table_name}")
                continue
            
            logger.info(f"Successfully processed {source_db}.{table_name} using partition switching")
        
        # Partition switching handles all data movement efficiently
        logger.info("=" * 80)
        logger.info("Archival workflow completed - all data moved using high-performance partition switching")
        
        logger.info("=" * 80)
        logger.info("MONTHLY ARCHIVAL WORKFLOW COMPLETED")
        logger.info(f"Batch ID: {self.batch_id}")
        logger.info(f"Completed: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}")
        logger.info("=" * 80)
    
    def show_status(self):
        """Show current archival status"""
        logger.info("=" * 80)
        logger.info("ARCHIVAL SYSTEM STATUS")
        logger.info("=" * 80)
        
        # Show configured tables
        tables = self.get_archival_table_list()
        logger.info(f"\nConfigured Tables: {len(tables)}")
        for table in tables:
            logger.info(f"  - {table['source_database']}.{table['table_name']}")
        
        # Show monthly archival tables
        query = """
        SELECT 
            source_database,
            base_table_name,
            archival_month,
            moved_to_archive_db,
            record_count
        FROM control.monthly_archival_tracking
        ORDER BY source_database, base_table_name, archival_month DESC;
        """
        
        result = self.sql.execute(query, "control_db")
        if result:
            logger.info("\nMonthly Archival Tables:")
            logger.info(result)
        
        # Show recent execution log
        query = """
        SELECT TOP 10
            operation,
            source_database,
            table_name,
            archival_month,
            records_affected,
            status,
            execution_start
        FROM control.archival_execution_log
        ORDER BY execution_start DESC;
        """
        
        result = self.sql.execute(query, "control_db")
        if result:
            logger.info("\nRecent Executions:")
            logger.info(result)


def main():
    parser = argparse.ArgumentParser(description='Data Archival Orchestrator V2')
    parser.add_argument('--run', action='store_true', help='Run monthly archival workflow')
    parser.add_argument('--status', action='store_true', help='Show archival status')
    args = parser.parse_args()
    
    orchestrator = ArchivalOrchestrator()
    
    if args.run:
        orchestrator.run_monthly_archival()
    elif args.status:
        orchestrator.show_status()
    else:
        parser.print_help()


if __name__ == "__main__":
    main()

