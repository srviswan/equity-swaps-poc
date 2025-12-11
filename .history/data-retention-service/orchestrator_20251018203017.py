#!/usr/bin/env python3
"""
Data Retention Service Orchestrator
Production-ready orchestrator with resilience, validation, and recovery capabilities
"""

import argparse
import logging
import sys
import uuid
from datetime import datetime
from typing import Optional, Dict, Any

import pyodbc


class PrerequisiteError(Exception):
    """Raised when required setup is not complete"""
    pass


class ArchivalOrchestrator:
    """Production-ready archival orchestrator with resilience and monitoring"""
    
    def __init__(self, connection_string: str = None):
        self.connection_string = connection_string or (
            "DRIVER={ODBC Driver 18 for SQL Server};"
            "SERVER=localhost,1436;"
            "DATABASE=control_db;"
            "UID=sa;"
            "PWD=Archival@2025!;"
            "TrustServerCertificate=yes;"
        )
        self.batch_id = str(uuid.uuid4())
        self.sql = SQLExecutor(self.connection_string)
        
        # Setup logging
        self.setup_logging()
        
    def setup_logging(self):
        """Setup comprehensive logging"""
        log_filename = f"archival_{datetime.now().strftime('%Y%m%d')}.log"
        
        logging.basicConfig(
            level=logging.INFO,
            format='%(asctime)s - %(name)s - %(levelname)s - %(message)s',
            handlers=[
                logging.FileHandler(log_filename),
                logging.StreamHandler(sys.stdout)
            ]
        )
        
        self.logger = logging.getLogger('ArchivalOrchestrator')
        
    def validate_prerequisites(self) -> bool:
        """Validate system is ready (idempotent)"""
        self.logger.info("Validating system prerequisites...")
        
        try:
            result = self.sql.execute("EXEC control.sp_Validate_System_Prerequisites")
            
            if "INVALID" in result:
                self.logger.error("System prerequisites validation failed")
                self.logger.error(result)
                raise PrerequisiteError("Setup required. Run './init_control_db.sh' first.")
            
            self.logger.info("✓ All prerequisites validated successfully")
            return True
            
        except Exception as e:
            self.logger.error(f"Prerequisites validation error: {e}")
            raise PrerequisiteError(f"Setup required. Run './init_control_db.sh' first. Error: {e}")
    
    def check_running_executions(self) -> bool:
        """Check for running or failed executions"""
        self.logger.info("Checking for running or failed executions...")
        
        try:
            result = self.sql.execute("EXEC control.sp_Monitor_Executions")
            
            if result and len(result.strip()) > 0:
                self.logger.warning("Found running or failed executions:")
                self.logger.warning(result)
                
                # Auto-resume failed executions
                self.logger.info("Attempting to resume failed executions...")
                self.sql.execute("EXEC control.sp_Resume_Failed_Executions")
                return True
            
            self.logger.info("✓ No running or failed executions found")
            return False
            
        except Exception as e:
            self.logger.warning(f"Could not check running executions: {e}")
            return False
    
    def show_system_status(self):
        """Show comprehensive system status"""
        self.logger.info("=" * 80)
        self.logger.info("SYSTEM STATUS")
        self.logger.info("=" * 80)
        
        try:
            # Show configured tables
            tables = self.sql.execute("""
                SELECT source_database, table_name, archival_enabled, disposal_enabled, 
                       retention_years_in_archive, last_archived
                FROM control.archival_table_list 
                WHERE active = 1
                ORDER BY source_database, table_name
            """)
            
            table_lines = tables.split('\n') if tables else []
            self.logger.info(f"Configured Tables: {len(table_lines)}")
            if tables:
                for line in tables.split('\n'):
                    if line.strip():
                        self.logger.info(f"  - {line.strip()}")
            
            # Show recent executions
            executions = self.sql.execute("""
                SELECT TOP 10 execution_status, workflow_type, source_database, table_name,
                       DATEDIFF(MINUTE, started_at, GETDATE()) as minutes_ago
                FROM control.archival_execution_state
                WHERE started_at >= DATEADD(DAY, -1, GETDATE())
                ORDER BY started_at DESC
            """)
            
            self.logger.info("\\nRecent Executions (Last 24h):")
            if executions:
                for line in executions.split('\n'):
                    if line.strip():
                        self.logger.info(f"  {line.strip()}")
            
            # Show archive status
            archive_status = self.sql.execute("EXEC control.sp_Show_Archive_Status")
            self.logger.info("\\nArchive Database Status:")
            if archive_status:
                for line in archive_status.split('\n'):
                    if line.strip():
                        self.logger.info(f"  {line.strip()}")
            
        except Exception as e:
            self.logger.error(f"Error getting system status: {e}")
    
    def run_monthly_archival_resilient(self) -> bool:
        """Run archival with resilience and recovery"""
        self.logger.info("=" * 80)
        self.logger.info(f"MONTHLY ARCHIVAL WORKFLOW - Batch ID: {self.batch_id}")
        self.logger.info(f"Started: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}")
        self.logger.info("=" * 80)
        
        try:
            # Validate prerequisites
            self.validate_prerequisites()
            
            # Check for running/failed executions
            self.check_running_executions()
            
            # Execute archival (idempotent)
            self.logger.info("Executing archival workflow...")
            result = self.sql.execute_procedure(
                "control.sp_Execute_Complete_Archival_With_Resume",
                {'batch_id': self.batch_id}
            )
            
            if result:
                self.logger.info("✓ Archival workflow completed successfully")
                return True
            else:
                self.logger.error("✗ Archival workflow failed")
                return False
                
        except PrerequisiteError as e:
            self.logger.error(f"Prerequisites error: {e}")
            return False
        except Exception as e:
            self.logger.error(f"Archival failed: {e}")
            self.logger.info("Execution state saved. You can resume by running again.")
            return False
    
    def execute_disposal_workflow(self) -> bool:
        """Execute retention-based disposal from archive_db"""
        self.logger.info("=" * 80)
        self.logger.info(f"DISPOSAL WORKFLOW - Batch ID: {self.batch_id}")
        self.logger.info(f"Removing records past retention period from archive_db")
        self.logger.info("=" * 80)
        
        try:
            # Validate prerequisites
            self.validate_prerequisites()
            
            # Execute disposal workflow
            result = self.sql.execute_procedure(
                "control.sp_Execute_Disposal_Workflow",
                {'batch_id': self.batch_id}
            )
            
            if result:
                self.logger.info("✓ Disposal workflow completed successfully")
                return True
            else:
                self.logger.error("✗ Disposal workflow failed")
                return False
                
        except Exception as e:
            self.logger.error(f"Disposal failed: {e}")
            return False
    
    def run_complete_lifecycle(self) -> bool:
        """Run complete lifecycle: Archive + Disposal"""
        self.logger.info("=" * 80)
        self.logger.info(f"COMPLETE LIFECYCLE - Batch ID: {self.batch_id}")
        self.logger.info(f"Running archival + disposal workflow")
        self.logger.info("=" * 80)
        
        try:
            # Validate prerequisites
            self.validate_prerequisites()
            
            # Execute complete lifecycle
            result = self.sql.execute_procedure(
                "control.sp_Execute_Complete_Lifecycle",
                {'batch_id': self.batch_id}
            )
            
            if result:
                self.logger.info("✓ Complete lifecycle executed successfully")
                return True
            else:
                self.logger.error("✗ Complete lifecycle failed")
                return False
                
        except Exception as e:
            self.logger.error(f"Lifecycle execution failed: {e}")
            return False
    
    def monitor_executions(self):
        """Monitor running executions"""
        self.logger.info("Monitoring executions...")
        
        try:
            result = self.sql.execute("EXEC control.sp_Monitor_Executions")
            if result:
                self.logger.info("Current executions:")
                for line in result.split('\n'):
                    if line.strip():
                        self.logger.info(f"  {line.strip()}")
            else:
                self.logger.info("No running executions found")
                
        except Exception as e:
            self.logger.error(f"Error monitoring executions: {e}")
    
    def resume_failed_executions(self) -> bool:
        """Resume failed executions"""
        self.logger.info("Resuming failed executions...")
        
        try:
            result = self.sql.execute("EXEC control.sp_Resume_Failed_Executions")
            self.logger.info("✓ Resume operation completed")
            return True
            
        except Exception as e:
            self.logger.error(f"Error resuming executions: {e}")
            return False


class SQLExecutor:
    """SQL execution wrapper with error handling"""
    
    def __init__(self, connection_string: str):
        self.connection_string = connection_string
        
    def execute(self, query: str) -> str:
        """Execute SQL query and return result"""
        try:
            with pyodbc.connect(self.connection_string) as conn:
                cursor = conn.cursor()
                cursor.execute(query)
                
                # Handle different result types
                if cursor.description:
                    # SELECT query
                    rows = cursor.fetchall()
                    if rows:
                        return '\\n'.join([' '.join(str(cell) for cell in row) for row in rows])
                    else:
                        return ""
                else:
                    # Non-SELECT query
                    return "SUCCESS"
                    
        except Exception as e:
            raise Exception(f"SQL execution failed: {e}")
    
    def execute_procedure(self, procedure_name: str, parameters: Dict[str, Any]) -> bool:
        """Execute stored procedure with parameters"""
        try:
            with pyodbc.connect(self.connection_string) as conn:
                cursor = conn.cursor()
                
                # Build parameter string
                param_str = ', '.join([f"@{k} = ?" for k in parameters.keys()])
                query = f"EXEC {procedure_name} {param_str}"
                
                # Execute with parameters
                cursor.execute(query, list(parameters.values()))
                
                # Check for errors
                if cursor.description:
                    rows = cursor.fetchall()
                    if rows and any('FAILED' in str(row) for row in rows):
                        return False
                
                return True
                
        except Exception as e:
            raise Exception(f"Procedure execution failed: {e}")


def main():
    """Main entry point"""
    parser = argparse.ArgumentParser(description='Data Retention Service Orchestrator')
    parser.add_argument('--run', action='store_true', help='Run monthly archival workflow')
    parser.add_argument('--dispose', action='store_true', help='Run disposal workflow only')
    parser.add_argument('--lifecycle', action='store_true', help='Run complete lifecycle (archive + disposal)')
    parser.add_argument('--status', action='store_true', help='Show system status')
    parser.add_argument('--monitor', action='store_true', help='Monitor running executions')
    parser.add_argument('--resume', action='store_true', help='Resume failed executions')
    parser.add_argument('--connection-string', help='Custom connection string')
    
    args = parser.parse_args()
    
    if not any([args.run, args.dispose, args.lifecycle, args.status, args.monitor, args.resume]):
        parser.print_help()
        return 1
    
    try:
        orchestrator = ArchivalOrchestrator(args.connection_string)
        
        if args.status:
            orchestrator.show_system_status()
            return 0
        
        if args.monitor:
            orchestrator.monitor_executions()
            return 0
        
        if args.resume:
            success = orchestrator.resume_failed_executions()
            return 0 if success else 1
        
        if args.run:
            success = orchestrator.run_monthly_archival_resilient()
            return 0 if success else 1
        
        if args.dispose:
            success = orchestrator.execute_disposal_workflow()
            return 0 if success else 1
        
        if args.lifecycle:
            success = orchestrator.run_complete_lifecycle()
            return 0 if success else 1
        
    except PrerequisiteError as e:
        print(f"SETUP REQUIRED: {e}")
        print("Run './init_control_db.sh' to initialize the control database")
        return 1
    except Exception as e:
        print(f"ERROR: {e}")
        return 1


if __name__ == '__main__':
    sys.exit(main())
