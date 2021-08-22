create table bank_account (
code smallint auto_increment,
value float not null,
constraint pk_bank_account primary key(code));

create table backup(
code smallint auto_increment,
patch_backup varchar(200) not null,
constraint pk_backup primary key(code));

create table restore(
code smallint auto_increment,
patch_restore varchar(200) not null,
constraint pk_restore primary key(code));

create table type_income (
code smallint auto_increment,
description varchar(50)not null,
constraint pk_type_income primary key(code));

create table payment_type (
code smallint auto_increment,
description varchar(50)not null,
constraint pk_paymanet_type primary key(code));

create table payer (
code smallint auto_increment,
name varchar(40)not null,
constraint pk_payer primary key(code));

create table user (
code smallint auto_increment,
full_name varchar(80)not null,
cpf varchar(12)not null,
login varchar(15) not null,
password varchar(150) not null,
constraint pk_user primary key(code));

create table income (
code int auto_increment,
user smallint not null,
type_income smallint not null,
date_income date not null,
value float not null,
constraint pk_income primary key(code),
constraint fk_income_user foreign key (user) references user(code),
constraint fk_income_type_income foreign key (type_income) references type_income(code));

create table account_payable (
code int auto_increment,
payer smallint not null,
payment_type smallint not null,
user smallint not null,
description varchar(50) not null,
quantity_plots smallint not null,
constraint pk_account_payable primary key(code),
constraint fk_account_payable_payer foreign key (payer) references payer(code),
constraint fk_account_payable_payment_type foreign key(payment_type) references payment_type(code),
constraint fk_account_payable foreign key(user) references user(code));

create table launch_account_pay (
code int auto_increment,
account_payable int not null,
date date not null,
value float not null,
parcel_installment int not null,
constraint pk_launch_account_pay primary key (code),
constraint fk_lauch_account_pay foreign key(account_payable) references account_payable(code));
