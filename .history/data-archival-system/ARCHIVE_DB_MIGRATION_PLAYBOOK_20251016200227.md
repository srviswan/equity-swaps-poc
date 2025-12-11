# Archive Database Migration Playbook

## Pre-Migration Checklist

- [ ] New server provisioned and accessible
- [ ] SQL Server 2019 installed on target server
- [ ] Network connectivity verified between source and target
- [ ] Sufficient storage on target server (verify current archive_db size + 50%)
- [ ] SQL Server service account has permissions
- [ ] Backup of archive_db completed and verified
- [ ] Maintenance window scheduled (recommend 8-12 hours)

## Migration Steps

### Step 1: Pre-Migration Testing

```sql
-- Test migration in test mode (no actual changes)
EXEC control_db.control.sp_Migrate_Archive_Database
    @target_server = 'ArchiveServerB',
    @target_linked_server = 'ArchiveServerB_Link',
    @test_mode = 1;
```

### Step 2: Backup Current Archive Database

```sql
-- Full backup of archive_db
BACKUP DATABASE archive_db
TO DISK = 'D:\Backups\archive_db_pre_migration.bak'
WITH COMPRESSION, CHECKSUM, STATS = 10;

-- Verify backup
RESTORE VERIFYONLY FROM DISK = 'D:\Backups\archive_db_pre_migration.bak';
```

### Step 3: Execute Migration

```sql
-- Execute actual migration
EXEC control_db.control.sp_Migrate_Archive_Database
    @target_server = 'ArchiveServerB',
    @target_linked_server = 'ArchiveServerB_Link',
    @test_mode = 0;
```

### Step 4: Restore on Target Server

On target server (ArchiveServerB):

```sql
-- Restore archive_db
RESTORE DATABASE archive_db
FROM DISK = 'D:\Backups\archive_db_migration.bak'
WITH MOVE 'archive_db' TO 'F:\Data\archive_db.mdf',
     MOVE 'archive_db_log' TO 'G:\Logs\archive_db_log.ldf',
     STATS = 10;
```

### Step 5: Validate Migration

```sql
-- Test connectivity to remote archive_db
EXEC control_db.control.sp_Test_Archive_Connectivity;

-- Verify view queries work
SELECT COUNT(*) FROM archive_db.SourceDB1.Position;
```

### Step 6: Post-Migration Cleanup

```sql
-- After 30 days of successful operation, drop local archive_db
-- DROP DATABASE archive_db;  -- CAUTION!
```

## Rollback Procedure

If migration fails:

```sql
-- Update topology back to local
UPDATE control_db.control.database_topology
SET server_name = @@SERVERNAME,
    linked_server_name = NULL,
    is_local = 1
WHERE database_type = 'ARCHIVE';

-- Recreate views pointing to local archive_db
EXEC control_db.control.sp_Recreate_All_Archive_Views @test_mode = 0;
```

## Performance Considerations

- Linked server queries will be slower (network latency)
- Consider using synonym caching
- Monitor distributed query performance
- Adjust timeout settings if needed

## Migration Timeline

### Phase 1: Preparation (1-2 days)
- Provision target server
- Install SQL Server 2019
- Configure network connectivity
- Test connectivity and permissions

### Phase 2: Testing (1 day)
- Run migration in test mode
- Validate connectivity
- Test archive queries
- Document any issues

### Phase 3: Migration (8-12 hours)
- Backup archive_db (2-4 hours)
- Transfer backup to target (1-2 hours)
- Restore on target server (2-4 hours)
- Update topology and views (1 hour)
- Validate migration (1 hour)

### Phase 4: Validation (1-2 days)
- Monitor performance
- Test all archive queries
- Validate data integrity
- Document any issues

### Phase 5: Cleanup (30 days later)
- Drop local archive_db
- Update documentation
- Archive migration logs

## Troubleshooting Guide

### Common Issues

1. **Linked Server Creation Failure**
   - Verify SQL Server service account permissions
   - Check network connectivity
   - Validate target server configuration

2. **Backup Transfer Failure**
   - Check disk space on target server
   - Verify network bandwidth
   - Consider compression options

3. **Restore Failure**
   - Verify backup file integrity
   - Check target server permissions
   - Validate file paths and naming

4. **View Creation Failure**
   - Check linked server connectivity
   - Verify schema permissions
   - Review view definition syntax

### Performance Issues

1. **Slow Query Performance**
   - Monitor network latency
   - Check linked server configuration
   - Consider query optimization

2. **Timeout Errors**
   - Increase query timeout settings
   - Optimize query execution plans
   - Consider batch processing

## Validation Scripts

### Connectivity Test

```sql
-- Test basic connectivity
SELECT @@SERVERNAME AS LocalServer, 
       @@VERSION AS SQLVersion,
       GETDATE() AS TestTime;

-- Test linked server connectivity
SELECT * FROM [ArchiveServerB_Link].archive_db.sys.tables;
```

### Data Integrity Test

```sql
-- Compare row counts
SELECT 'SourceDB1.Position' AS TableName, COUNT(*) AS RowCount
FROM SourceDB1.dbo.Position
UNION ALL
SELECT 'ArchiveDB.SourceDB1.Position', COUNT(*)
FROM [ArchiveServerB_Link].archive_db.SourceDB1.Position;
```

### Performance Test

```sql
-- Test query performance
SET STATISTICS IO ON;
SET STATISTICS TIME ON;

SELECT COUNT(*) 
FROM [ArchiveServerB_Link].archive_db.SourceDB1.Position
WHERE businessDate >= '2020-01-01';

SET STATISTICS IO OFF;
SET STATISTICS TIME OFF;
```

## Monitoring and Alerts

### Key Metrics to Monitor

1. **Query Performance**
   - Average query duration
   - Network latency
   - Timeout frequency

2. **Data Integrity**
   - Row count comparisons
   - Data validation results
   - Error rates

3. **System Health**
   - Linked server status
   - Disk space utilization
   - Network connectivity

### Alert Configuration

```sql
-- Create alerts for migration monitoring
EXEC msdb.dbo.sp_add_alert 
    @name = 'Archive Migration - Linked Server Down',
    @message_id = 0,
    @severity = 16,
    @enabled = 1,
    @delay_between_responses = 300;

EXEC msdb.dbo.sp_add_alert 
    @name = 'Archive Migration - Query Timeout',
    @message_id = 0,
    @severity = 14,
    @enabled = 1,
    @delay_between_responses = 300;
```

## Documentation Updates

### Post-Migration Documentation

1. **Update Architecture Diagrams**
   - Reflect new server topology
   - Update connection strings
   - Document new network paths

2. **Update Operational Procedures**
   - Modify backup procedures
   - Update monitoring scripts
   - Revise maintenance schedules

3. **Update Disaster Recovery Plans**
   - Include new server in DR procedures
   - Update recovery time objectives
   - Test DR procedures

## Success Criteria

### Technical Validation

- [ ] All archive queries execute successfully
- [ ] Data integrity verified (100% match)
- [ ] Performance within acceptable limits
- [ ] No connectivity issues
- [ ] All views and procedures working

### Business Validation

- [ ] Archive reports generate correctly
- [ ] Historical data accessible
- [ ] No impact on active operations
- [ ] Compliance requirements met
- [ ] User acceptance testing passed

## Post-Migration Checklist

- [ ] Monitor system performance for 48 hours
- [ ] Validate all archive queries
- [ ] Update documentation
- [ ] Train operations team
- [ ] Schedule regular health checks
- [ ] Plan for future migrations

## Lessons Learned Template

### Migration Date: ___________
### Migration Duration: ___________
### Issues Encountered: ___________
### Resolution Actions: ___________
### Performance Impact: ___________
### Recommendations: ___________
