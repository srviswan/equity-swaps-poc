# Filegroup Architecture for Data Archival System

## Overview

Multi-tier storage architecture using SQL Server filegroups to optimize cost, performance, and maintenance operations.

## Filegroup Strategy

### Primary Filegroups (Per Source Database)

#### PRIMARY Filegroup
- Purpose: Active transactional data
- Storage Tier: High-performance NVMe SSD
- Data Characteristics: Hot data, frequent reads/writes
- Size Estimate: 10% of total data
- IOPS Requirement: 50,000+ IOPS
- Latency Target: < 1ms
- Example Path: D:\FastSSD\SourceDB1_Data.mdf

Tables/Partitions:
- dbo.Position (archival_flag = 0)
- dbo.Trade (archival_flag = 0)
- All active transactional data

#### ARCHIVE_FG Filegroup
- Purpose: Recent archived data (< 3 months old)
- Storage Tier: Standard SATA SSD or HDD
- Data Characteristics: Warm data, mostly reads
- Size Estimate: 20% of total data
- IOPS Requirement: 5,000-10,000 IOPS
- Latency Target: < 10ms
- Example Path: E:\ArchiveData\SourceDB1_Archive.ndf

Tables/Partitions:
- archive.Position_20250116 (renamed staging tables)
- archive.Position_20250123
- Partition 2 of main tables (archival_flag = 1)

#### SECONDARY_FG Filegroup (Optional - for very large databases)
- Purpose: Older active data (> 6 months, < archival eligible)
- Storage Tier: Standard SSD
- Data Characteristics: Cool data, infrequent access
- Size Estimate: 10% of total data
- IOPS Requirement: 2,000-5,000 IOPS
- Example Path: E:\StandardSSD\SourceDB1_Secondary.ndf

### Archive Database Filegroups

#### PRIMARY Filegroup
- Purpose: Consolidated old archives (> 3 months)
- Storage Tier: Cheap HDD or cold storage
- Data Characteristics: Cold data, rare access
- Size Estimate: 60% of total data
- IOPS Requirement: 100-500 IOPS
- Latency Target: < 50ms
- Example Path: F:\CheapStorage\ArchiveDB_Data.mdf

Tables:
- SourceDB1.Position_Old (consolidated old archives)
- SourceDB2.Trade_Old
- SourceDB3.PriceHistory_Old

## Storage Tier Comparison

| Tier | Technology | Cost/TB | IOPS | Latency | Use Case |
|------|-----------|---------|------|---------|----------|
| Hot | NVMe SSD | $500 | 50K+ | < 1ms | Active data |
| Warm | SATA SSD | $200 | 10K | < 10ms | Recent archives |
| Cool | SATA HDD | $50 | 500 | < 20ms | Old archives (source) |
| Cold | Cheap HDD | $20 | 100 | < 50ms | Old archives (archive_db) |

## Filegroup Configuration Examples

### SourceDB1 Configuration (30TB total, 3TB active, 27TB archived)

```sql
-- PRIMARY filegroup (3TB active data on fast SSD)
ALTER DATABASE SourceDB1 ADD FILE 
(
    NAME = SourceDB1_Data,
    FILENAME = 'D:\FastSSD\SourceDB1_Data.mdf',
    SIZE = 500GB,
    MAXSIZE = UNLIMITED,
    FILEGROWTH = 10GB
) TO FILEGROUP [PRIMARY];

-- ARCHIVE_FG filegroup (6TB recent archives on standard SSD)
ALTER DATABASE SourceDB1 ADD FILEGROUP ARCHIVE_FG;
ALTER DATABASE SourceDB1 ADD FILE 
(
    NAME = SourceDB1_Archive1,
    FILENAME = 'E:\ArchiveData\SourceDB1_Archive1.ndf',
    SIZE = 1TB,
    MAXSIZE = UNLIMITED,
    FILEGROWTH = 100GB
) TO FILEGROUP ARCHIVE_FG;

-- Add more files for better I/O distribution
ALTER DATABASE SourceDB1 ADD FILE 
(
    NAME = SourceDB1_Archive2,
    FILENAME = 'E:\ArchiveData\SourceDB1_Archive2.ndf',
    SIZE = 1TB,
    MAXSIZE = UNLIMITED,
    FILEGROWTH = 100GB
) TO FILEGROUP ARCHIVE_FG;
```

## Benefits Summary

1. Cost Optimization: Active data on expensive storage (10%), archives on cheap storage (90%)
2. Performance: Hot data gets fast storage, archival queries acceptable speed
3. Maintenance: Can maintain each filegroup independently
4. Backup Strategy: Daily PRIMARY backups, weekly ARCHIVE_FG differentials
5. I/O Distribution: Multiple files per filegroup for parallel I/O
6. Future-Proof: Easy to add new filegroups as requirements evolve

## Implementation Guidelines

### File Sizing Strategy

For a 30TB database with 10% active data:

1. **PRIMARY Filegroup**: 3TB on NVMe SSD
   - Start with 500GB, grow by 10GB increments
   - Monitor for 80% utilization

2. **ARCHIVE_FG Filegroup**: 6TB on SATA SSD
   - Start with 1TB per file, grow by 100GB increments
   - Use multiple files for parallel I/O

3. **Archive Database**: 21TB on cheap HDD
   - Single large file or multiple files
   - Lower performance acceptable

### I/O Optimization

1. **Multiple Files per Filegroup**: Distribute I/O across multiple physical disks
2. **Instant File Initialization**: Enable for faster file growth
3. **Pre-size Files**: Avoid autogrowth during peak operations
4. **Separate Physical Disks**: Each filegroup on different storage tier

### Monitoring Points

1. **Filegroup Size**: Monitor growth rates and capacity
2. **I/O Performance**: Track IOPS and latency per filegroup
3. **Index Fragmentation**: Different thresholds per filegroup
4. **Backup Duration**: Optimize backup windows per filegroup

## Capacity Planning Formulas

### Growth Projections

```
PRIMARY_Size = Current_Active_Data * (1 + Monthly_Growth_Rate)^12
ARCHIVE_FG_Size = Current_Recent_Archives * (1 + Monthly_Growth_Rate)^12
Archive_DB_Size = Current_Old_Archives * (1 + Monthly_Growth_Rate)^12
```

### Storage Cost Calculation

```
Total_Cost = (PRIMARY_Size * $500) + (ARCHIVE_FG_Size * $200) + (Archive_DB_Size * $50)
Savings = (Total_Data * $500) - Total_Cost
```

## Future Expansion

### Adding New Filegroups

1. **QUARTERLY_FG**: For quarterly rollups
2. **ANNUAL_FG**: For annual summaries
3. **DISPOSAL_FG**: For data pending disposal

### Migration Strategy

1. **Gradual Migration**: Move data between filegroups based on age
2. **Zero Downtime**: Use partition switching for seamless moves
3. **Validation**: Verify data integrity after each migration

## Security Considerations

1. **Access Control**: Different permissions per filegroup
2. **Encryption**: TDE for all filegroups
3. **Backup Security**: Separate backup strategies per filegroup
4. **Audit Trail**: Track all filegroup operations
