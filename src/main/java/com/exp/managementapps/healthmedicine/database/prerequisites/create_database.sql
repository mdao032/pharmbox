DROP DATABASE IF EXISTS pharmboxdb;
CREATE DATABASE pharmboxdb
    WITH
    OWNER = postgres
    ENCODING = "UTF-8"
    LC_COLLATE = "French_France.1252"
    LC_CTYPE = "French_France.1252"
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
