-- 01_create_databases.sql
-- Create production and archive databases

-- Production database (simulating multiple source databases)
CREATE DATABASE SourceDB1;
CREATE DATABASE SourceDB2;
CREATE DATABASE SourceDB3;

-- Archive database (single target)
CREATE DATABASE archive_db;

-- Control database (for configuration and logging)
CREATE DATABASE control_db;

PRINT 'Databases created successfully';
