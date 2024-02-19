CREATE TABLE DOCTOR(
    ID BIGINT NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(100) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL UNIQUE,
    CRM VARCHAR(100) NOT NULL UNIQUE,
    SPECIALITY VARCHAR(100) NOT NULL,
    PHONE VARCHAR(100) NOT NULL,
    STREET VARCHAR(100) NOT NULL,
    NUMBER VARCHAR(100) NOT NULL,
    COMPLEMENT VARCHAR(100) NOT NULL,
    NEIGHBORHOOD VARCHAR(100) NOT NULL,
    CITY VARCHAR(100) NOT NULL,
    STATE VARCHAR(100) NOT NULL,
    ZIPCODE VARCHAR(100) NOT NULL,

    PRIMARY KEY (ID)
);