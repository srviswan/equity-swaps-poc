-- 06_master_archival_procedure.sql
-- Master orchestration procedure with resume capability

USE control_db;
GO

-- ===========================================
-- PROCEDURE: Execute complete archival with resume capability
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Execute_Complete_Archival_With_Resume
    @batch_id UNIQUEIDENTIFIER,
    @execution_id UNIQUEIDENTIFIER = NULL
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @source_database VARCHAR(100);
    DECLARE @table_name VARCHAR(100);
    DECLARE @archive_schema VARCHAR(100);
    DECLARE @archive_table VARCHAR(100);
    DECLARE @staging_table_name VARCHAR(200);
    DECLARE @current_phase VARCHAR(50);
    DECLARE @resume_point VARCHAR(200);
    DECLARE @error_msg NVARCHAR(MAX);
    DECLARE @archive_table_versioned VARCHAR(200);
    DECLARE @schema_version INT;
    
    -- Create or retrieve execution state
    IF @execution_id IS NULL
    BEGIN
        SET @execution_id = NEWID();
        
        -- Get first table to process (for single-table execution)
        SELECT TOP 1 
            @source_database = source_database,
            @table_name = table_name,
            @archive_schema = archive_db_schema,
            @archive_table = archive_db_table
        FROM control.archival_table_list
        WHERE archival_enabled = 1 AND active = 1;
        
        IF @source_database IS NULL
        BEGIN
            PRINT 'No tables configured for archival';
            RETURN;
        END
        
        INSERT INTO control.archival_execution_state (
            execution_id, batch_id, workflow_type, source_database, table_name,
            current_phase, execution_status
        ) VALUES (
            @execution_id, @batch_id, 'ARCHIVAL', @source_database, @table_name,
            'PREPARE', 'RUNNING'
        );
    END
    ELSE
    BEGIN
        -- Get execution state
        SELECT 
            @source_database = source_database,
            @table_name = table_name,
            @current_phase = current_phase,
            @resume_point = resume_point
        FROM control.archival_execution_state
        WHERE execution_id = @execution_id;
        
        -- Get archive configuration
        SELECT 
            @archive_schema = archive_db_schema,
            @archive_table = archive_db_table
        FROM control.archival_table_list
        WHERE source_database = @source_database AND table_name = @table_name;
    END
    
    BEGIN TRY
        -- PHASE 2: Prepare records (skip if already done)
        IF @current_phase = 'PREPARE'
        BEGIN
            EXEC control.sp_Log_Execution_Step @execution_id, 'Preparing records for archival', 1;
            
            -- Execute preparation (idempotent)
            EXEC control.sp_Prepare_Archival_Records_Idempotent 
                @source_database, @table_name, @batch_id, 
                @staging_table_name OUTPUT, @archive_table_versioned OUTPUT, @schema_version OUTPUT;
            
            -- Move to next phase
            UPDATE control.archival_execution_state
            SET current_phase = 'MOVE', current_step = NULL, resume_point = 'MOVE_PHASE'
            WHERE execution_id = @execution_id;
            
            SET @current_phase = 'MOVE';
        END
        
        -- PHASE 3: Move to archive (skip if already done)
        IF @current_phase IN ('PREPARE', 'MOVE')
        BEGIN
            EXEC control.sp_Log_Execution_Step @execution_id, 'Moving data to archive_db', 2;
            
            -- Get staging table name if not set
            IF @staging_table_name IS NULL
            BEGIN
                SELECT TOP 1 @staging_table_name = staging_table_name
                FROM control.partition_switch_tracking
                WHERE batch_id = @batch_id AND source_database = @source_database AND table_name = @table_name
                ORDER BY started_at DESC;
            END
            
            IF @staging_table_name IS NOT NULL
            BEGIN
                -- Execute movement (idempotent) using versioned archive table
                DECLARE @records_moved BIGINT;
                EXEC control.sp_Move_To_Archive_Master 
                    @source_database, @staging_table_name, @archive_schema, @archive_table_versioned, 
                    @batch_id, @records_moved OUTPUT;
                
                -- Drop staging table after successful move
                EXEC control.sp_Drop_Staging_Table_Safe @source_database, @staging_table_name, @batch_id;
            END
            
            -- Mark complete
            EXEC control.sp_Update_Execution_Status @execution_id, 'SUCCESS', NULL, 1;
        END
        
        -- Update heartbeat
        UPDATE control.archival_execution_state
        SET last_heartbeat = GETDATE()
        WHERE execution_id = @execution_id;
        
        PRINT 'Archival completed successfully for ' + @source_database + '.' + @table_name;
        
    END TRY
    BEGIN CATCH
        SET @error_msg = ERROR_MESSAGE();
        
        -- Log error
        EXEC control.sp_Update_Execution_Status @execution_id, 'FAILED', @error_msg, 0;
        
        -- Update error count and resume capability
        UPDATE control.archival_execution_state
        SET error_count = error_count + 1,
            can_resume = CASE WHEN error_count < 3 THEN 1 ELSE 0 END
        WHERE execution_id = @execution_id;
        
        PRINT 'ERROR: Archival failed - ' + @error_msg;
        THROW;
    END CATCH
END;
GO

-- ===========================================
-- PROCEDURE: Execute complete lifecycle (archive + dispose)
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Execute_Complete_Lifecycle
    @batch_id UNIQUEIDENTIFIER
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @execution_id UNIQUEIDENTIFIER = NEWID();
    
    -- Create lifecycle execution state
    INSERT INTO control.archival_execution_state (
        execution_id, batch_id, workflow_type,
        current_phase, execution_status
    ) VALUES (
        @execution_id, @batch_id, 'LIFECYCLE',
        'ARCHIVE', 'RUNNING'
    );
    
    BEGIN TRY
        -- PHASE 1: Archive records
        EXEC control.sp_Log_Execution_Step @execution_id, 'Running archival workflow', 1;
        
        -- Process all configured tables
        DECLARE @tables TABLE (
            source_database VARCHAR(100),
            table_name VARCHAR(100)
        );
        
        INSERT INTO @tables
        SELECT source_database, table_name
        FROM control.archival_table_list
        WHERE archival_enabled = 1 AND active = 1;
        
        DECLARE @source_database VARCHAR(100);
        DECLARE @table_name VARCHAR(100);
        
        DECLARE archive_cursor CURSOR FOR
        SELECT source_database, table_name FROM @tables;
        
        OPEN archive_cursor;
        FETCH NEXT FROM archive_cursor INTO @source_database, @table_name;
        
        WHILE @@FETCH_STATUS = 0
        BEGIN
            PRINT 'Archiving ' + @source_database + '.' + @table_name;
            
            -- Execute archival for this table
            DECLARE @table_execution_id UNIQUEIDENTIFIER = NEWID();
            EXEC control.sp_Execute_Complete_Archival_With_Resume @batch_id, @table_execution_id;
            
            FETCH NEXT FROM archive_cursor INTO @source_database, @table_name;
        END
        
        CLOSE archive_cursor;
        DEALLOCATE archive_cursor;
        
        -- PHASE 2: Dispose old records
        EXEC control.sp_Log_Execution_Step @execution_id, 'Running disposal workflow', 2;
        
        EXEC control.sp_Execute_Disposal_Workflow @batch_id;
        
        -- Mark lifecycle complete
        EXEC control.sp_Update_Execution_Status @execution_id, 'SUCCESS', NULL, 1;
        
        PRINT 'Complete lifecycle executed successfully';
        
    END TRY
    BEGIN CATCH
        DECLARE @error_msg NVARCHAR(MAX) = ERROR_MESSAGE();
        
        -- Log error
        EXEC control.sp_Update_Execution_Status @execution_id, 'FAILED', @error_msg, 0;
        
        PRINT 'ERROR: Lifecycle execution failed - ' + @error_msg;
        THROW;
    END CATCH
END;
GO

-- ===========================================
-- PROCEDURE: Show archive status
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Show_Archive_Status
AS
BEGIN
    SET NOCOUNT ON;
    
    -- Show archive database contents
    DECLARE @sql NVARCHAR(MAX) = '
    USE archive_db;
    
    SELECT 
        s.name as schema_name,
        t.name as table_name,
        SUM(p.rows) as record_count
    FROM sys.tables t
    JOIN sys.schemas s ON t.schema_id = s.schema_id
    JOIN sys.partitions p ON t.object_id = p.object_id
    WHERE p.index_id IN (0,1)
    GROUP BY s.name, t.name
    ORDER BY s.name, t.name;
    ';
    
    EXEC sp_executesql @sql;
END;
GO

PRINT 'Master archival procedures created successfully';
