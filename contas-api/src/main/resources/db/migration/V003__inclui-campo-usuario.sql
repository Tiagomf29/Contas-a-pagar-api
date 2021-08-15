alter table bank_account add code_user smallint not null;
alter table bank_account add constraint fk_bank_account_n1 foreign key(code_user) references user(code);