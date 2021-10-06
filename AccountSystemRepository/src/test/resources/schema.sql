CREATE SEQUENCE NWU_GENERIC_SEQ
    START WITH 1
    INCREMENT BY 1;


CREATE TABLE ACCOUNT_TYPE
(
  ACCOUNT_TYPE_ID       BIGINT          NOT NULL,
  MNEMONIC              VARCHAR(100)    NOT NULL    UNIQUE,
  ACCOUNT_TYPE_NAME     VARCHAR(255)    NOT NULL,
  CREATION_DATE         DATE            NOT NULL,
    PRIMARY KEY (ACCOUNT_TYPE_ID)
);


CREATE TABLE ACCOUNT_INFO (
    INFO_ID             BIGINT  NOT NULL,
    ACCOUNT_TYPE_ID     BIGINT  NOT NULL,
    MEMBER_ID           BIGINT  NOT NULL,
    BALANCE             BIGINT  NOT NULL,
        PRIMARY KEY (INFO_ID)
);


CREATE TABLE ACCOUNT_TRANSAX
(
  TRANSAX_ID            BIGINT  NOT NULL,
  ACCOUNT_TYPE_ID       BIGINT  NOT NULL,
  MEMBER_ID             BIGINT  NOT NULL,
  AMOUNT                BIGINT  NOT NULL,
  TRANSAX_DATE          DATE    NOT NULL,
    PRIMARY KEY (TRANSAX_ID),
--    CONSTRAINT FK_ACCOUNT_TYPE_ID FOREIGN KEY (ACCOUNT_TYPE_ID) REFERENCES ACCOUNT_TYPE (ACCOUNT_TYPE_ID)
--    CONSTRAINT FK_ACCOUNT_INFO_ID FOREIGN KEY (INFO_ID) REFERENCES ACCOUNT_INFO (INFO_ID)
);