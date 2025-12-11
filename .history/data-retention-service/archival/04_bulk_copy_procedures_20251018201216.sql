-- 04_bulk_copy_procedures.sql
-- Bulk copy procedures for data movement

USE control_db;
GO

-- ===========================================
-- PROCEDURE: Bulk copy with table hints
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Bulk_Copy_With_Hints
    @source_database VARCHAR(100),
    @source_table VARCHAR(100),
    @target_database VARCHAR(100),
    @target_schema VARCHAR(100),
    @target_table VARCHAR(100),
    @batch_size INT = 50000,
    @records_copied BIGINT OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @total_copied BIGINT = 0;
    DECLARE @batch_copied INT;
    
    -- Bulk copy with table hints for performance
    WHILE 1 = 1
    BEGIN
        SET @sql = '
        USE ' + QUOTENAME(@target_database) + ';
        
        INSERT TOP(' + CAST(@batch_size AS VARCHAR) + ') INTO ' + QUOTENAME(@target_schema) + '.' + QUOTENAME(@target_table) + ' WITH (TABLOCK, BULK)
        SELECT TOP(' + CAST(@batch_size AS VARCHAR) + ') *, GETDATE() AS archived_date
        FROM ' + QUOTENAME(@source_database) + '.dbo.' + QUOTENAME(@source_table) + ' s
        WHERE NOT EXISTS (
            SELECT 1 FROM ' + QUOTENAME(@target_schema) + '.' + QUOTENAME(@target_table) + ' t
            WHERE t.id = s.id
        );
        ';
        
        EXEC sp_executesql @sql;
        SET @batch_copied = @@ROWCOUNT;
        SET @total_copied = @total_copied + @batch_copied;
        
        -- Break if no more records
        IF @batch_copied = 0 BREAK;
        
        -- Update progress every 10 batches
        IF @total_copied % (@batch_size * 10) = 0
        BEGIN
            PRINT 'Bulk copy progress: ' + CAST(@total_copied AS VARCHAR) + ' records copied';
        END
        
        -- Small delay to avoid overwhelming system
        WAITFOR DELAY '00:00:00.050';
    END
    
    SET @records_copied = @total_copied;
    
    PRINT 'Bulk copy completed: ' + CAST(@records_copied AS VARCHAR) + ' records copied';
END;
GO

-- ===========================================
-- PROCEDURE: Fast bulk copy for large datasets
-- ===========================================
CREATE OR ALTER PROCEDURE control.sp_Fast_Bulk_Copy
    @source_database VARCHAR(100),
    @source_table VARCHAR(100),
    @target_database VARCHAR(100),
    @target_schema VARCHAR(100),
    @target_table VARCHAR(100),
    @records_copied BIGINT OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @sql NVARCHAR(MAX);
    DECLARE @start_time DATETIME = GETDATE();
    
    -- Single large bulk insert with minimal logging
    SET @sql = '
    USE ' + QUOTENAME(@target_database) + ';
    
    INSERT INTO ' + QUOTENAME(@target_schema) + '.' + QUOTENAME(@target_table) + ' WITH (TABLOCK, BULK)
    SELECT *, GETDATE() AS archived_date
    FROM ' + QUOTENAME(@source_database) + '.dbo.' + QUOTENAME(@source_table) + ';
    ';
    
    EXEC sp_executesql @sql;
    SET @records_copied = @@ROWCOUNT;
    
    -- Log performance metrics
    DECLARE @duration_ms INT = DATEDIFF(MILLISECOND, @start_time, GETDATE());
    DECLARE @throughput DECIMAL(18,2) = CASE WHEN @duration_ms > 0 THEN (@records_copied * 8.0 / 1024.0) / (@duration_ms / 1000.0) ELSE 0 END;
    
    -- Log metrics
    INSERT INTO control.archival_metrics (
        metric_type, metric_name, metric_value, metric_unit,
        source_database, operation
    ) VALUES (
        'THROUGHPUT', 'Fast Bulk Copy Duration', @duration_ms, 'ms',
        @source_database, 'BULK_COPY'
    );
    
    INSERT INTO control.archival_metrics (
        metric_type, metric_name, metric_value, metric_unit,
        source_database, operation
    ) VALUES (
        'THROUGHPUT', 'Fast Bulk Copy Throughput', @throughput, 'MB/sec',
        @source_database, 'BULK_COPY'
    );
    
    PRINT 'Fast bulk copy completed: ' + CAST(@records_copied AS VARCHAR) + ' records in ' + CAST(@duration_ms AS VARCHAR) + 'ms';
END;
GO

PRINT 'Bulk copy procedures created successfully';
