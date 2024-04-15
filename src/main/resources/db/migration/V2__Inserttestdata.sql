-- Добавление тестовых данных в таблицу user_account
INSERT INTO user_account (id, balance, username) VALUES
(1, 1000.00, 'johndoe'),
(51, 1500.50, 'janedoe'),
(101, 2000.00, 'mikebrown');

-- Добавление тестовых данных в таблицу account_transaction
-- Обратите внимание, что мы используем реальные ID записей из user_account.
-- Предполагаем, что ID, сгенерированные выше, будут 1, 51 и 101 соответственно.
INSERT INTO account_transaction (id, amount, transaction_time, transaction_type, user_account_id) VALUES
(nextval('transaction_seq'), 100.00, '2024-04-14 10:00:00', 'DEPOSIT', 1),
(nextval('transaction_seq'), 200.00, '2024-04-14 11:00:00', 'WITHDRAW', 1),
(nextval('transaction_seq'), 150.00, '2024-04-14 12:00:00', 'DEPOSIT', 51);
