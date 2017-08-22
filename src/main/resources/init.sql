DROP SCHEMA IF EXISTS contactdb;
CREATE SCHEMA contactdb CHARACTER SET UTF8;
USE contactdb;

CREATE USER IF NOT EXISTS 'db_admin'@'localhost' IDENTIFIED BY 'rNT5Vn[j(>R2r6.UXcJwtv];`RWewYH`';
GRANT ALL PRIVILEGES ON contactdb.* TO 'db_admin'@'localhost';

FLUSH PRIVILEGES ;