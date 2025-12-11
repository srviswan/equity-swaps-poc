-- 22_archive_db_migration_procedures.sql
-- Archive database migration procedures for portability

USE control_db;
GO

-- Procedure to migrate archive_db to different server
CREATE PROCEDURE control.sp_Migrate_Archive_Database
    @target_server VARCHAR(200),
    @target_linked_server VARCHAR(200),
    @test_mode BIT = 1
AS
BEGIN
    SET NOCOUNT ON;
    
    PRINT 'Starting archive database migration...';
    PRINT 'Target Server: ' + @target_server;
    PRINT 'Linked Server Name: ' + @target_linked_server;
    PRINT 'Test Mode: ' + CAST(@test_mode AS VARCHAR);
    
    BEGIN TRY
        -- Step 1: Create linked server
        IF NOT EXISTS (SELECT * FROM sys.servers WHERE name = @target_linked_server)
        BEGIN
            PRINT '  Step 1: Creating linked server...';
            EXEC sp_addlinkedserver 
                @server = @target_linked_server,
                @srvproduct = '',
                @provider = 'SQLNCLI',
                @datasrc = @target_server;
            
            EXEC sp_addlinkedsrvlogin 
                @rmtsrvname = @target_linked_server,
                @useself = 'TRUE';
        END
        
        -- Step 2: Test connectivity
        PRINT '  Step 2: Testing connectivity...';
        DECLARE @test_result INT;
        EXEC @test_result = sp_testlinkedserver @target_linked_server;
        
        IF @test_result != 0
        BEGIN
            RAISERROR('Cannot connect to target server', 16, 1);
            RETURN;
        END
        
        -- Step 3: Backup archive_db
        IF @test_mode = 0
        BEGIN
            PRINT '  Step 3: Backing up archive_db...';
            BACKUP DATABASE archive_db
            TO DISK = 'D:\Backups\archive_db_migration.bak'
            WITH COMPRESSION, CHECKSUM;
            
            -- Step 4: Restore to target server (manual step documented)
            PRINT '  Step 4: Restore backup to target server (manual step)';
            PRINT '    Run on target server: RESTORE DATABASE archive_db FROM DISK = ...';
        END
        
        -- Step 5: Update topology
        IF @test_mode = 0
        BEGIN
            PRINT '  Step 5: Updating database topology...';
            UPDATE control.database_topology
            SET server_name = @target_server,
                linked_server_name = @target_linked_server,
                is_local = 0,
                updated_date = GETDATE()
            WHERE database_type = 'ARCHIVE' AND active = 1;
        END
        
        -- Step 6: Update all archive views
        PRINT '  Step 6: Recreating archive views...';
        EXEC control.sp_Recreate_All_Archive_Views @test_mode;
        
        -- Step 7: Test archive connectivity
        PRINT '  Step 7: Testing archive connectivity...';
        EXEC control.sp_Test_Archive_Connectivity;
        
        PRINT 'Migration ' + CASE WHEN @test_mode = 1 THEN 'test' ELSE 'execution' END + ' completed successfully';
        
    END TRY
    BEGIN CATCH
        PRINT 'ERROR: ' + ERROR_MESSAGE();
        RAISERROR('Migration failed', 16, 1);
    END CATCH
END;
GO

-- Procedure to test archive database connectivity
CREATE PROCEDURE control.sp_Test_Archive_Connectivity
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @archive_ref NVARCHAR(500);
    DECLARE @result_count BIGINT;
    DECLARE @source_db VARCHAR(100);
    
    DECLARE db_cursor CURSOR FOR
        SELECT DISTINCT source_database
        FROM control.archived_tables
        WHERE moved_to_archive_db = 1;
    
    OPEN db_cursor;
    FETCH NEXT FROM db_cursor INTO @source_db;
    
    WHILE @@FETCH_STATUS = 0
    BEGIN
        BEGIN TRY
            SET @archive_ref = control.fn_Get_Database_Reference('ARCHIVE', 'archive_db');
            
            DECLARE @test_sql NVARCHAR(MAX) = 
                'SELECT @count = COUNT(*) FROM ' + @archive_ref + '.' + 
                QUOTENAME(@source_db) + '.Position_Old;';
            
            EXEC sp_executesql @test_sql, N'@count BIGINT OUTPUT', @count = @result_count OUTPUT;
            
            PRINT 'Archive connectivity for ' + @source_db + ': SUCCESS (' + 
                  CAST(@result_count AS VARCHAR) + ' rows)';
        END TRY
        BEGIN CATCH
            PRINT 'Archive connectivity for ' + @source_db + ': FAILED - ' + ERROR_MESSAGE();
        END CATCH
        
        FETCH NEXT FROM db_cursor INTO @source_db;
    END
    
    CLOSE db_cursor;
    DEALLOCATE db_cursor;
END;
GO

-- Procedure to recreate all archive views
CREATE PROCEDURE control.sp_Recreate_All_Archive_Views
    @test_mode BIT = 0
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @source_db VARCHAR(100);
    DECLARE @base_table VARCHAR(100);
    
    DECLARE view_cursor CURSOR FOR
        SELECT DISTINCT source_database, base_table_name
        FROM control.archived_tables
        ORDER BY source_database, base_table_name;
    
    OPEN view_cursor;
    FETCH NEXT FROM view_cursor INTO @source_db, @base_table;
    
    WHILE @@FETCH_STATUS = 0
    BEGIN
        IF @test_mode = 0
            EXEC control.sp_Update_Archive_Views @source_db, @base_table;
        ELSE
            PRINT 'Would recreate view: archive_db.' + @source_db + '.' + @base_table;
        
        FETCH NEXT FROM view_cursor INTO @source_db, @base_table;
    END
    
    CLOSE view_cursor;
    DEALLOCATE view_cursor;
END;
GO

PRINT 'Archive database migration procedures created';
