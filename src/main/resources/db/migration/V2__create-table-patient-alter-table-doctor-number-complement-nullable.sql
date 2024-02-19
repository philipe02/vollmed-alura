CREATE TABLE PATIENT(
    ID BIGINT NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(100) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL UNIQUE,
    PHONE VARCHAR(100) NOT NULL,
    CPF VARCHAR(100) NOT NULL UNIQUE,
    STREET VARCHAR(100) NOT NULL,
    NUMBER VARCHAR(100),
    COMPLEMENT VARCHAR(100),
    NEIGHBORHOOD VARCHAR(100) NOT NULL,
    CITY VARCHAR(100) NOT NULL,
    STATE VARCHAR(100) NOT NULL,
    ZIPCODE VARCHAR(100) NOT NULL,
    PRIMARY KEY (ID)
);

ALTER TABLE DOCTOR
MODIFY COLUMN NUMBER VARCHAR(100) NULL,
MODIFY COLUMN COMPLEMENT VARCHAR(100) NULL;
