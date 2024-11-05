--liquibase formatted sql
--changeset pep_sxx:1
DROP TABLE IF EXISTS bank_account CASCADE;
--changeset pep_sxx:2
DROP SEQUENCE IF EXISTS bank_account_seq CASCADE;

--changeset pep_sxx:3
CREATE SEQUENCE IF NOT EXISTS bank_account_seq
    START WITH 50 INCREMENT BY 50;

--changeset pep_sxx:4
CREATE TABLE bank_account
(
    id             BIGINT DEFAULT nextval('bank_account_seq') PRIMARY KEY,
    money          NUMERIC(38, 2),
    name           VARCHAR(255),
    number_account BIGINT,
    time_adding    TIMESTAMP(6)
);