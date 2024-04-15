CREATE SEQUENCE transaction_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE user_account_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE user_account (
    id BIGINT NOT NULL,
    balance NUMERIC(38,2),
    username VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE account_transaction (
    id BIGINT NOT NULL,
    amount NUMERIC(38,2) NOT NULL,
    transaction_time TIMESTAMP(6) NOT NULL,
    transaction_type VARCHAR(255) NOT NULL,
    user_account_id BIGINT NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE account_transaction
ADD CONSTRAINT FK_account_transaction_user_account
FOREIGN KEY (user_account_id) REFERENCES user_account;
