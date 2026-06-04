-- Dev-only bootstrap for the Docker SQL Server image (see ../../docker-compose.yml).
-- Creates the databases the archiver connects to. Flyway then creates the archive.* control
-- tables inside archive_control on first run. NOT for production.
IF DB_ID('archive_control')        IS NULL CREATE DATABASE archive_control;
IF DB_ID('dw')                     IS NULL CREATE DATABASE dw;
IF DB_ID('archive')                IS NULL CREATE DATABASE archive;
IF DB_ID('archive_investigation')  IS NULL CREATE DATABASE archive_investigation;
GO
