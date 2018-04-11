USE forum;

CREATE TABLE IF NOT EXISTS USERS  (
    ID INT auto_increment,
    USER_NAME  VARCHAR(150) NOT NULL,
    EMAIL  VARCHAR(150) NOT NULL,
    PASSWORD VARCHAR(50) NOT NULL,
    FIRST_NAME VARCHAR(100) NOT NULL,
    LAST_NAME VARCHAR(50) NOT NULL,
    DOB VARCHAR(50) NOT NULL,
    SEX VARCHAR(50) NOT NULL,
    CITY VARCHAR(50) NOT NULL,
    REGISTER_DATE VARCHAR(50) NOT NULL,
    ID_TYPE VARCHAR(50),
    CONSTRAINT  PK_USERS  PRIMARY KEY ( ID )
);