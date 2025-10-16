#!/usr/bin/env python3
"""
Data Archival Orchestrator
Metadata-driven archival system for 100+ tables across multiple databases
"""

import pyodbc
import logging
import argparse
import sys
from concurrent.futures import ThreadPoolExecutor, as_completed
from datetime import datetime
from typing import List, Dict, Tuple, Optional
import uuid
from dataclasses import dataclass
from enum import Enum
import time
from tenacity import retry, stop_after_attempt, wait_exponential
import json

# Configuration
class TableType(Enum):
    FUNCTIONAL = "FUNCTIONAL"
    REFERENCE = "REFERENCE"
    OPERATIONAL = "OPERATIONAL"

@dataclass
class TableConfig:
    source_db: str
    schema: str
    table_name: str
    table_type: TableType
    has_partitioning: bool
    priority: int

@dataclass
class ArchivalResult:
    source_db: str
    schema: str
    table_name: str
    operation: str
    records_affected: int
    duration_seconds: float
    status: str
    error_message: str = None

class RecoveryManager:
    def __init__(self, connection_string: str):
        self.connection_string = connection_string
        
    def get_connection(self):
        return pyodbc.connect(self.connection_string)
    
    def record_phase(self, batch_id: str, source_db: str, schema: str, table: str, phase: str, details: str = None):
        """Record phase transition in recovery state"""
        try:
            with self.get_connection() as conn:
                cursor = conn.cursor()
                cursor.execute("""
                    MERGE control_db.control.recovery_state AS target
                    USING (SELECT ? as batch_id, ? as source_database, ? as table_schema, ? as table_name, ? as phase, ? as details) AS source
                    ON target.batch_id = source.batch_id 
                       AND target.source_database = source.source_database
                       AND target.table_schema = source.table_schema
                       AND target.table_name = source.table_name
                    WHEN MATCHED THEN
                        UPDATE SET phase = source.phase, updated_at = GETDATE(), details = source.details
                    WHEN NOT MATCHED THEN
                        INSERT (batch_id, source_database, table_schema, table_name, phase, details)
                        VALUES (source.batch_id, source.source_database, source.table_schema, source.table_name, source.phase, source.details);
                """, batch_id, source_db, schema, table, phase, details)
                conn.commit()
        except Exception as e:
            print(f"Failed to record phase: {e}")
    
    def load_incomplete(self) -> List[Dict]:
        """Load incomplete archival operations"""
        try:
            with self.get_connection() as conn:
                cursor = conn.cursor()
                cursor.execute("""
                    SELECT batch_id, source_database, table_schema, table_name, phase, details
                    FROM control_db.control.recovery_state
                    WHERE phase NOT IN ('STAGING_TRUNCATED', 'COMPLETED')
                    ORDER BY started_at
                """)
                return [dict(zip([column[0] for column in cursor.description], row)) for row in cursor.fetchall()]
        except Exception as e:
            print(f"Failed to load incomplete operations: {e}")
            return []

class ArchivalOrchestrator:
    def __init__(self, connection_string: str):
        self.connection_string = connection_string
        self.batch_id = str(uuid.uuid4())
        self.logger = self._setup_logging()
        self.recovery_manager = RecoveryManager(connection_string)
        
    def _setup_logging(self):
        logging.basicConfig(
            level=logging.INFO,
            format='%(asctime)s - %(name)s - %(levelname)s - %(message)s',
            handlers=[
                logging.FileHandler(f'archival_{datetime.now().strftime("%Y%m%d")}.log'),
                logging.StreamHandler()
            ]
        )
        return logging.getLogger('ArchivalOrchestrator')
    
    def get_connection(self):
        return pyodbc.connect(self.connection_string)
    
    def load_table_configs(self) -> List[TableConfig]:
        """Load all active tables from configuration"""
        query = """
        SELECT source_database, table_schema, table_name, table_type, has_partitioning, 
               ISNULL(execution_priority, 50) as priority
        FROM control_db.control.archival_table_config
        WHERE active = 1 AND archival_enabled = 1
        ORDER BY execution_priority, table_type
        """
        with self.get_connection() as conn:
            cursor = conn.cursor()
            cursor.execute(query)
            return [
                TableConfig(
                    source_db=row.source_database,
                    schema=row.table_schema,
                    table_name=row.table_name,
                    table_type=TableType(row.table_type),
                    has_partitioning=bool(row.has_partitioning),
                    priority=row.priority
                )
                for row in cursor.fetchall()
            ]
    
    @retry(stop=stop_after_attempt(3), wait=wait_exponential(multiplier=1, min=4, max=10))
    def mark_table_eligible(self, config: TableConfig) -> ArchivalResult:
        """Mark records eligible for archival for a single table"""
        start_time = time.time()
        try:
            self.recovery_manager.record_phase(self.batch_id, config.source_db, config.schema, config.table_name, 'MARKING')
            
            with self.get_connection() as conn:
                cursor = conn.cursor()
                cursor.execute(
                    "EXEC control_db.control.sp_Mark_Table_Archival_Eligible ?, ?, ?",
                    config.source_db, config.schema, config.table_name
                )
                records = cursor.rowcount
                conn.commit()
                
            duration = time.time() - start_time
            self.logger.info(f"✓ Marked {records} records for {config.source_db}.{config.schema}.{config.table_name} ({duration:.2f}s)")
            
            self.recovery_manager.record_phase(self.batch_id, config.source_db, config.schema, config.table_name, 'MARKED')
            
            return ArchivalResult(
                source_db=config.source_db,
                schema=config.schema,
                table_name=config.table_name,
                operation='MARK',
                records_affected=records,
                duration_seconds=duration,
                status='SUCCESS'
            )
        except Exception as e:
            duration = time.time() - start_time
            self.logger.error(f"✗ Failed marking {config.source_db}.{config.schema}.{config.table_name}: {str(e)}")
            self.recovery_manager.record_phase(self.batch_id, config.source_db, config.schema, config.table_name, 'MARK_FAILED', str(e))
            return ArchivalResult(
                source_db=config.source_db,
                schema=config.schema,
                table_name=config.table_name,
                operation='MARK',
                records_affected=0,
                duration_seconds=duration,
                status='FAILED',
                error_message=str(e)
            )
    
    @retry(stop=stop_after_attempt(2), wait=wait_exponential(multiplier=2, min=10, max=30))
    def archive_table(self, config: TableConfig) -> ArchivalResult:
        """Archive a single table (bulk copy for now)"""
        start_time = time.time()
        try:
            self.recovery_manager.record_phase(self.batch_id, config.source_db, config.schema, config.table_name, 'ARCHIVING')
            
            with self.get_connection() as conn:
                cursor = conn.cursor()
                
                # For now, use bulk copy (partition switching would require more complex setup)
                cursor.execute(
                    "EXEC control_db.control.sp_Archive_Table_Bulk_Copy ?, ?, ?, ?",
                    self.batch_id, config.source_db, config.schema, config.table_name
                )
                
                records = cursor.rowcount
                conn.commit()
                
            duration = time.time() - start_time
            method = "bulk copy"
            self.logger.info(f"✓ Archived {records} records from {config.source_db}.{config.schema}.{config.table_name} via {method} ({duration:.2f}s)")
            
            self.recovery_manager.record_phase(self.batch_id, config.source_db, config.schema, config.table_name, 'ARCHIVED')
            
            return ArchivalResult(
                source_db=config.source_db,
                schema=config.schema,
                table_name=config.table_name,
                operation='ARCHIVE',
                records_affected=records,
                duration_seconds=duration,
                status='SUCCESS'
            )
        except Exception as e:
            duration = time.time() - start_time
            self.logger.error(f"✗ Failed archiving {config.source_db}.{config.schema}.{config.table_name}: {str(e)}")
            self.recovery_manager.record_phase(self.batch_id, config.source_db, config.schema, config.table_name, 'ARCHIVE_FAILED', str(e))
            return ArchivalResult(
                source_db=config.source_db,
                schema=config.schema,
                table_name=config.table_name,
                operation='ARCHIVE',
                records_affected=0,
                duration_seconds=duration,
                status='FAILED',
                error_message=str(e)
            )
    
    def log_result(self, result: ArchivalResult):
        """Log result to database"""
        try:
            with self.get_connection() as conn:
                cursor = conn.cursor()
                cursor.execute("""
                    INSERT INTO control_db.control.archival_execution_log 
                    (batch_id, source_database, table_schema, table_name, operation, records_affected, 
                     execution_start, execution_end, status, error_message)
                    VALUES (?, ?, ?, ?, ?, ?, DATEADD(SECOND, -?, GETDATE()), GETDATE(), ?, ?)
                """, 
                    self.batch_id, result.source_db, result.schema, result.table_name, result.operation,
                    result.records_affected, int(result.duration_seconds), 
                    result.status, result.error_message
                )
                conn.commit()
        except Exception as e:
            self.logger.error(f"Failed to log result: {str(e)}")
    
    def execute_phase_parallel(self, configs: List[TableConfig], 
                               operation_func, max_workers: int = 10) -> List[ArchivalResult]:
        """Execute operation in parallel across multiple tables"""
        results = []
        with ThreadPoolExecutor(max_workers=max_workers) as executor:
            future_to_config = {
                executor.submit(operation_func, config): config 
                for config in configs
            }
            
            for future in as_completed(future_to_config):
                result = future.result()
                results.append(result)
                self.log_result(result)
        
        return results
    
    def run_weekly_archival(self):
        """Main orchestration method - runs weekly archival for all tables"""
        self.logger.info("="*80)
        self.logger.info(f"WEEKLY ARCHIVAL BATCH: {self.batch_id}")
        self.logger.info(f"Started: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}")
        self.logger.info("="*80)
        
        overall_start = time.time()
        
        # Load configurations
        self.logger.info("\n📋 Loading table configurations...")
        configs = self.load_table_configs()
        self.logger.info(f"Loaded {len(configs)} tables for archival")
        
        # PHASE 1: MARKING (parallel execution)
        self.logger.info("\n🏷️  PHASE 1: Marking archival-eligible records...")
        marking_start = time.time()
        marking_results = self.execute_phase_parallel(
            configs, 
            self.mark_table_eligible, 
            max_workers=20  # High parallelism for marking
        )
        marking_duration = time.time() - marking_start
        
        marking_success = sum(1 for r in marking_results if r.status == 'SUCCESS')
        marking_records = sum(r.records_affected for r in marking_results if r.status == 'SUCCESS')
        self.logger.info(f"Phase 1 Complete: {marking_success}/{len(configs)} tables, "
                        f"{marking_records:,} records marked ({marking_duration:.2f}s)")
        
        # PHASE 2: ARCHIVAL (parallel execution)
        self.logger.info("\n📦 PHASE 2: Archiving eligible records...")
        archival_start = time.time()
        
        archival_results = self.execute_phase_parallel(
            configs,
            self.archive_table,
            max_workers=10
        )
        
        archival_duration = time.time() - archival_start
        
        archival_success = sum(1 for r in archival_results if r.status == 'SUCCESS')
        archival_records = sum(r.records_affected for r in archival_results if r.status == 'SUCCESS')
        self.logger.info(f"Phase 2 Complete: {archival_success}/{len(configs)} tables, "
                        f"{archival_records:,} records archived ({archival_duration:.2f}s)")
        
        # PHASE 3: DISPOSAL
        self.logger.info("\n🗑️  PHASE 3: Disposing expired records from archive...")
        disposal_start = time.time()
        try:
            with self.get_connection() as conn:
                cursor = conn.cursor()
                cursor.execute("EXEC control_db.control.sp_Dispose_Expired_Records ?", self.batch_id)
                disposed_records = cursor.rowcount
                conn.commit()
            disposal_duration = time.time() - disposal_start
            self.logger.info(f"Phase 3 Complete: {disposed_records:,} records disposed ({disposal_duration:.2f}s)")
        except Exception as e:
            self.logger.error(f"Phase 3 Failed: {str(e)}")
        
        # SUMMARY
        overall_duration = time.time() - overall_start
        self.logger.info("\n" + "="*80)
        self.logger.info("WEEKLY ARCHIVAL BATCH COMPLETE")
        self.logger.info(f"Batch ID: {self.batch_id}")
        self.logger.info(f"Total Duration: {overall_duration/60:.2f} minutes")
        self.logger.info(f"Tables Processed: {len(configs)}")
        self.logger.info(f"Records Marked: {marking_records:,}")
        self.logger.info(f"Records Archived: {archival_records:,}")
        self.logger.info(f"Errors: {sum(1 for r in marking_results + archival_results if r.status == 'FAILED')}")
        self.logger.info("="*80)
    
    def show_status(self):
        """Show current archival status"""
        try:
            with self.get_connection() as conn:
                cursor = conn.cursor()
                
                print("\n📊 ARCHIVAL STATUS DASHBOARD")
                print("="*50)
                
                # Configuration summary
                cursor.execute("""
                    SELECT table_type, COUNT(*) as table_count, 
                           SUM(CASE WHEN archival_enabled = 1 THEN 1 ELSE 0 END) as enabled_count
                    FROM control_db.control.archival_table_config
                    WHERE active = 1
                    GROUP BY table_type
                """)
                
                print("\n📋 Configuration Summary:")
                for row in cursor.fetchall():
                    print(f"  {row.table_type}: {row.enabled_count}/{row.table_count} tables enabled")
                
                # Recent executions
                cursor.execute("""
                    SELECT TOP 5 batch_id, execution_start, 
                           SUM(CASE WHEN operation = 'MARK' THEN records_affected ELSE 0 END) as marked,
                           SUM(CASE WHEN operation = 'ARCHIVE' THEN records_affected ELSE 0 END) as archived,
                           SUM(CASE WHEN status = 'FAILED' THEN 1 ELSE 0 END) as errors
                    FROM control_db.control.archival_execution_log
                    GROUP BY batch_id, execution_start
                    ORDER BY execution_start DESC
                """)
                
                print("\n🕒 Recent Executions:")
                for row in cursor.fetchall():
                    print(f"  {row.execution_start}: {row.marked:,} marked, {row.archived:,} archived, {row.errors} errors")
                
                # Incomplete operations
                incomplete = self.recovery_manager.load_incomplete()
                if incomplete:
                    print(f"\n⚠️  Incomplete Operations: {len(incomplete)}")
                    for item in incomplete:
                        print(f"  {item['source_database']}.{item['table_schema']}.{item['table_name']} - {item['phase']}")
                else:
                    print("\n✅ No incomplete operations")
                    
        except Exception as e:
            print(f"Failed to show status: {e}")

def main():
    parser = argparse.ArgumentParser(description='Data Archival Orchestrator')
    parser.add_argument('--connection-string', 
                       default="DRIVER={ODBC Driver 17 for SQL Server};SERVER=localhost,1434;DATABASE=master;UID=sa;PWD=Archival@2025!;Encrypt=false;",
                       help='Database connection string')
    parser.add_argument('--run', action='store_true', help='Run weekly archival')
    parser.add_argument('--status', action='store_true', help='Show archival status')
    parser.add_argument('--resume', action='store_true', help='Resume incomplete operations')
    
    args = parser.parse_args()
    
    orchestrator = ArchivalOrchestrator(args.connection_string)
    
    if args.status:
        orchestrator.show_status()
    elif args.resume:
        print("Resume functionality not yet implemented")
    elif args.run:
        orchestrator.run_weekly_archival()
    else:
        parser.print_help()

if __name__ == "__main__":
    main()
