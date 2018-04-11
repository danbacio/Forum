USE forum;

CREATE TABLE IF NOT EXISTS POSTS  (
    ID INT auto_increment,
    USER_ID INT NOT NULL,
    TITLE VARCHAR(200) NOT NULL,
    POST VARCHAR(2000) NOT NULL,
    CONSTRAINT  PK_USERS  PRIMARY KEY (ID),
    FOREIGN KEY (USER_ID) REFERENCES USERS(ID)
);