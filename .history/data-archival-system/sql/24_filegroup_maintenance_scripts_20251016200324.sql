-- 24_filegroup_maintenance_scripts.sql
-- Filegroup-specific maintenance scripts

USE control_db;
GO

-- Daily maintenance stored procedure for PRIMARY filegroup
CREATE PROCEDURE control.sp_Daily_Maintenance_PRIMARY
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @StartTime DATETIME = GETDATE();
    DECLARE @EndTime DATETIME;
    
    PRINT 'Starting daily maintenance for PRIMARY filegroup...';
    
    -- Phase 1: Index maintenance
    EXEC control.sp_Index_Maintenance_PRIMARY;
    
    -- Phase 2: Statistics update
    EXEC control.sp_Statistics_Update_PRIMARY;
    
    -- Phase 3: Consistency check
    EXEC control.sp_Consistency_Check_PRIMARY;
    
    -- Phase 4: Backup
    EXEC control.sp_Backup_PRIMARY;
    
    SET @EndTime = GETDATE();
    PRINT 'Daily maintenance completed in ' + 
          CAST(DATEDIFF(minute, @StartTime, @EndTime) AS VARCHAR) + ' minutes';
END;
GO

-- Index maintenance for PRIMARY filegroup only
CREATE PROCEDURE control.sp_Index_Maintenance_PRIMARY
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @TableName NVARCHAR(128);
    DECLARE @IndexName NVARCHAR(128);
    DECLARE @Fragmentation FLOAT;
    
    -- Create temporary table for indexes to rebuild
    CREATE TABLE #IndexesToRebuild (
        TableName NVARCHAR(128),
        IndexName NVARCHAR(128),
        Fragmentation FLOAT
    );
    
    -- Find fragmented indexes on PRIMARY filegroup only
    INSERT INTO #IndexesToRebuild (TableName, IndexName, Fragmentation)
    SELECT 
        t.name AS TableName,
        i.name AS IndexName,
        ps.avg_fragmentation_in_percent
    FROM sys.dm_db_index_physical_stats(DB_ID(), NULL, NULL, NULL, 'LIMITED') ps
    JOIN sys.tables t ON ps.object_id = t.object_id
    JOIN sys.indexes i ON ps.object_id = i.object_id AND ps.index_id = i.index_id
    JOIN sys.data_spaces ds ON i.data_space_id = ds.data_space_id
    WHERE ds.name = 'PRIMARY'  -- Only PRIMARY filegroup
      AND ps.avg_fragmentation_in_percent > 10
      AND i.type_desc != 'HEAP'
    ORDER BY ps.avg_fragmentation_in_percent DESC;
    
    -- Rebuild indexes with ONLINE=ON to minimize blocking
    DECLARE index_cursor CURSOR FOR
    SELECT TableName, IndexName FROM #IndexesToRebuild;
    
    OPEN index_cursor;
    FETCH NEXT FROM index_cursor INTO @TableName, @IndexName;
    
    WHILE @@FETCH_STATUS = 0
    BEGIN
        PRINT 'Rebuilding index: ' + @IndexName + ' on table: ' + @TableName;
        
        BEGIN TRY
            EXEC('ALTER INDEX ' + @IndexName + ' ON ' + @TableName + 
                 ' REBUILD WITH (ONLINE = ON, MAXDOP = 4)');
            PRINT 'Successfully rebuilt: ' + @IndexName;
        END TRY
        BEGIN CATCH
            PRINT 'ERROR rebuilding ' + @IndexName + ': ' + ERROR_MESSAGE();
        END CATCH
        
        FETCH NEXT FROM index_cursor INTO @TableName, @IndexName;
    END
    
    CLOSE index_cursor;
    DEALLOCATE index_cursor;
    
    DROP TABLE #IndexesToRebuild;
    
    PRINT 'Index maintenance for PRIMARY filegroup completed';
END;
GO

-- Statistics update for PRIMARY filegroup tables only
CREATE PROCEDURE control.sp_Statistics_Update_PRIMARY
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @TableName NVARCHAR(128);
    DECLARE @SQL NVARCHAR(MAX);
    
    PRINT 'Updating statistics for PRIMARY filegroup tables...';
    
    -- Get tables in PRIMARY filegroup
    DECLARE table_cursor CURSOR FOR
    SELECT t.name
    FROM sys.tables t
    JOIN sys.data_spaces ds ON t.data_space_id = ds.data_space_id
    WHERE ds.name = 'PRIMARY';
    
    OPEN table_cursor;
    FETCH NEXT FROM table_cursor INTO @TableName;
    
    WHILE @@FETCH_STATUS = 0
    BEGIN
        PRINT 'Updating statistics for: ' + @TableName;
        
        BEGIN TRY
            SET @SQL = 'UPDATE STATISTICS ' + @TableName + ' WITH FULLSCAN';
            EXEC sp_executesql @SQL;
            PRINT 'Successfully updated statistics for: ' + @TableName;
        END TRY
        BEGIN CATCH
            PRINT 'ERROR updating statistics for ' + @TableName + ': ' + ERROR_MESSAGE();
        END CATCH
        
        FETCH NEXT FROM table_cursor INTO @TableName;
    END
    
    CLOSE table_cursor;
    DEALLOCATE table_cursor;
    
    PRINT 'Statistics update for PRIMARY filegroup completed';
END;
GO

-- Consistency check for PRIMARY filegroup only
CREATE PROCEDURE control.sp_Consistency_Check_PRIMARY
AS
BEGIN
    SET NOCOUNT ON;
    
    PRINT 'Running consistency check for PRIMARY filegroup...';
    
    BEGIN TRY
        DBCC CHECKDB (SourceDB1, FILEGROUP = 'PRIMARY') 
        WITH NO_INFOMSGS, ALL_ERRORMSGS;
        PRINT 'Consistency check for PRIMARY filegroup completed successfully';
    END TRY
    BEGIN CATCH
        PRINT 'ERROR in consistency check: ' + ERROR_MESSAGE();
        RAISERROR('Consistency check failed', 16, 1);
    END CATCH
END;
GO

-- Backup PRIMARY filegroup
CREATE PROCEDURE control.sp_Backup_PRIMARY
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @BackupPath NVARCHAR(500);
    DECLARE @BackupName NVARCHAR(200);
    
    SET @BackupName = 'SourceDB1_Primary_Full_' + 
                     REPLACE(CONVERT(VARCHAR, GETDATE(), 112), '-', '') + '_' +
                     REPLACE(CONVERT(VARCHAR, GETDATE(), 108), ':', '');
    SET @BackupPath = 'D:\Backups\' + @BackupName + '.bak';
    
    PRINT 'Starting backup of PRIMARY filegroup to: ' + @BackupPath;
    
    BEGIN TRY
        BACKUP DATABASE SourceDB1
        FILEGROUP = 'PRIMARY'
        TO DISK = @BackupPath
        WITH COMPRESSION, CHECKSUM, STATS = 10;
        
        PRINT 'PRIMARY filegroup backup completed successfully';
    END TRY
    BEGIN CATCH
        PRINT 'ERROR in PRIMARY filegroup backup: ' + ERROR_MESSAGE();
        RAISERROR('Backup failed', 16, 1);
    END CATCH
END;
GO

-- Weekly maintenance stored procedure for ARCHIVE_FG filegroup
CREATE PROCEDURE control.sp_Weekly_Maintenance_ARCHIVE_FG
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @StartTime DATETIME = GETDATE();
    
    PRINT 'Starting weekly maintenance for ARCHIVE_FG filegroup...';
    
    -- Archive filegroup maintenance
    EXEC control.sp_Archive_Maintenance;
    
    -- Archive cleanup
    EXEC control.sp_Archive_Cleanup;
    
    SET @StartTime = GETDATE();
    PRINT 'Weekly maintenance completed in ' + 
          CAST(DATEDIFF(minute, @StartTime, GETDATE()) AS VARCHAR) + ' minutes';
END;
GO

-- Archive filegroup maintenance
CREATE PROCEDURE control.sp_Archive_Maintenance
AS
BEGIN
    SET NOCOUNT ON;
    
    PRINT 'Starting archive filegroup maintenance...';
    
    -- Rebuild indexes on ARCHIVE_FG (once per month)
    BEGIN TRY
        -- Example for Position table - would be dynamic in real implementation
        IF EXISTS (SELECT * FROM sys.tables WHERE name = 'Position' AND schema_id = SCHEMA_ID('archive'))
        BEGIN
            PRINT 'Rebuilding indexes on archive.Position...';
            ALTER INDEX ALL ON archive.Position REBUILD
            WITH (ONLINE = ON, MAXDOP = 8, SORT_IN_TEMPDB = ON);
        END
        
        -- Update statistics for archived tables
        PRINT 'Updating statistics for archived tables...';
        UPDATE STATISTICS archive.Position WITH FULLSCAN;
        
        -- Consistency check for ARCHIVE_FG
        PRINT 'Running consistency check for ARCHIVE_FG...';
        DBCC CHECKDB (SourceDB1, FILEGROUP = 'ARCHIVE_FG')
        WITH NO_INFOMSGS;
        
        -- Differential backup of ARCHIVE_FG
        PRINT 'Creating differential backup of ARCHIVE_FG...';
        BACKUP DATABASE SourceDB1
        FILEGROUP = 'ARCHIVE_FG'
        TO DISK = 'E:\Backups\SourceDB1_Archive_Diff.bak'
        WITH DIFFERENTIAL, COMPRESSION, STATS = 10;
        
        PRINT 'Archive filegroup maintenance completed successfully';
    END TRY
    BEGIN CATCH
        PRINT 'ERROR in archive maintenance: ' + ERROR_MESSAGE();
        RAISERROR('Archive maintenance failed', 16, 1);
    END CATCH
END;
GO

-- Archive cleanup procedure
CREATE PROCEDURE control.sp_Archive_Cleanup
AS
BEGIN
    SET NOCOUNT ON;
    
    PRINT 'Starting archive cleanup...';
    
    BEGIN TRY
        -- Move old archives to archive_db (example - would be dynamic)
        PRINT 'Moving old archives to archive_db...';
        EXEC control_db.control.sp_Cleanup_Old_Archives 3, 1000000;
        
        -- Shrink ARCHIVE_FG if needed (after moving data)
        PRINT 'Shrinking ARCHIVE_FG files...';
        DBCC SHRINKFILE (SourceDB1_Archive1, 10);  -- Leave 10% free space
        DBCC SHRINKFILE (SourceDB1_Archive2, 10);
        
        PRINT 'Archive cleanup completed successfully';
    END TRY
    BEGIN CATCH
        PRINT 'ERROR in archive cleanup: ' + ERROR_MESSAGE();
        RAISERROR('Archive cleanup failed', 16, 1);
    END CATCH
END;
GO

-- Monthly full maintenance procedure
CREATE PROCEDURE control.sp_Monthly_Full_Maintenance
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @StartTime DATETIME = GETDATE();
    
    PRINT 'Starting monthly full maintenance...';
    
    BEGIN TRY
        -- Full consistency check (all filegroups)
        PRINT 'Running full consistency check...';
        DBCC CHECKDB (SourceDB1) WITH NO_INFOMSGS;
        
        -- Rebuild all indexes (all filegroups)
        PRINT 'Rebuilding all indexes...';
        EXEC sp_MSforeachtable 'ALTER INDEX ALL ON ? REBUILD WITH (ONLINE = ON)';
        
        -- Update all statistics
        PRINT 'Updating all statistics...';
        EXEC sp_updatestats;
        
        -- Full backup (all filegroups)
        PRINT 'Creating full database backup...';
        BACKUP DATABASE SourceDB1
        TO DISK = 'D:\Backups\SourceDB1_Full.bak'
        WITH COMPRESSION, CHECKSUM, STATS = 10;
        
        PRINT 'Monthly full maintenance completed in ' + 
              CAST(DATEDIFF(minute, @StartTime, GETDATE()) AS VARCHAR) + ' minutes';
    END TRY
    BEGIN CATCH
        PRINT 'ERROR in monthly maintenance: ' + ERROR_MESSAGE();
        RAISERROR('Monthly maintenance failed', 16, 1);
    END CATCH
END;
GO

-- Monitoring query for filegroup sizes
CREATE PROCEDURE control.sp_Monitor_Filegroup_Sizes
AS
BEGIN
    SET NOCOUNT ON;
    
    PRINT 'Filegroup Size Monitoring Report';
    PRINT '===============================';
    
    SELECT 
        fg.name AS FileGroupName,
        SUM(f.size * 8 / 1024 / 1024) AS SizeGB,
        SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024 / 1024) AS UsedGB,
        SUM(f.size * 8 / 1024 / 1024) - SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024 / 1024) AS FreeGB,
        CAST((SUM(FILEPROPERTY(f.name, 'SpaceUsed') * 8 / 1024 / 1024) * 100.0) / 
             (SUM(f.size * 8 / 1024 / 1024)) AS DECIMAL(5,2)) AS PercentUsed
    FROM sys.filegroups fg
    JOIN sys.database_files f ON fg.data_space_id = f.data_space_id
    GROUP BY fg.name
    ORDER BY fg.name;
END;
GO

-- Monitoring query for index fragmentation by filegroup
CREATE PROCEDURE control.sp_Monitor_Index_Fragmentation
AS
BEGIN
    SET NOCOUNT ON;
    
    PRINT 'Index Fragmentation Report by Filegroup';
    PRINT '======================================';
    
    SELECT 
        ds.name AS FileGroupName,
        t.name AS TableName,
        i.name AS IndexName,
        ps.avg_fragmentation_in_percent,
        ps.page_count,
        CASE 
            WHEN ps.avg_fragmentation_in_percent > 30 THEN 'CRITICAL - Rebuild Required'
            WHEN ps.avg_fragmentation_in_percent > 10 THEN 'WARNING - Consider Rebuild'
            ELSE 'OK'
        END AS Status
    FROM sys.dm_db_index_physical_stats(DB_ID(), NULL, NULL, NULL, 'SAMPLED') ps
    JOIN sys.tables t ON ps.object_id = t.object_id
    JOIN sys.indexes i ON ps.object_id = i.object_id AND ps.index_id = i.index_id
    JOIN sys.data_spaces ds ON i.data_space_id = ds.data_space_id
    WHERE ps.avg_fragmentation_in_percent > 5
    ORDER BY ps.avg_fragmentation_in_percent DESC;
END;
GO

PRINT 'Filegroup maintenance scripts created successfully';
