insert into account_type (ACCOUNT_TYPE_ID, MNEMONIC, ACCOUNT_TYPE_NAME, CREATION_DATE) values (1, 'MILES', 'Miles', '2020-01-01');
insert into account_type (ACCOUNT_TYPE_ID, MNEMONIC, ACCOUNT_TYPE_NAME, CREATION_DATE) values (2, 'PLAYS', 'Game Play', '2020-03-01');

insert into account_info (INFO_ID, ACCOUNT_TYPE_ID, MEMBER_ID, BALANCE) values (3, 1, 2, 100);

insert into account_transax (TRANSAX_ID, ACCOUNT_TYPE_ID, MEMBER_ID, AMOUNT, TRANSAX_DATE) values (4, 1, 2, 10, '2020-04-01');
