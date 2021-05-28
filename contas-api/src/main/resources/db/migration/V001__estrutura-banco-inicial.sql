create table conta_banco (
codigo smallint auto_increment,
valor float not null,
constraint pk_conta_banco primary key(codigo));

create table backup(
codigo smallint auto_increment,
caminho_backup varchar(200) not null,
constraint pk_backup primary key(codigo));

create table restore(
codigo smallint auto_increment,
caminho_restore varchar(200) not null,
constraint pk_restore primary key(codigo));

create table tipo_renda (
codigo smallint auto_increment,
descricao varchar(50)not null,
constraint pk_tipo_renda primary key(codigo));

create table tipo_pagamento (
codigo smallint auto_increment,
descricao varchar(50)not null,
constraint pk_tipo_pagamento primary key(codigo));

create table pagador (
codigo smallint auto_increment,
nome varchar(40)not null,
constraint pk_tipo_pagamento primary key(codigo));

create table usuario (
codigo smallint auto_increment,
nome_completo varchar(80)not null,
cpf numeric(15,0) not null,
login varchar(15) not null,
senha varchar(150) not null,
constraint pk_usuario primary key(codigo));

create table renda (
codigo int auto_increment,
usuario smallint not null,
tipo_renda smallint not null,
data_renda date not null,
valor float not null,
constraint pk_renda primary key(codigo),
constraint fk_renda_usuario foreign key (usuario) references usuario(codigo),
constraint fk_renda_tipo_renda foreign key (tipo_renda) references tipo_renda(codigo));

create table conta_pagar (
codigo int auto_increment,
pagador smallint not null,
tipo_pagamento smallint not null,
usuario smallint not null,
descricao varchar(50) not null,
qtde_parcelas smallint not null,
constraint pk_conta_pagar primary key(codigo),
constraint fk_conta_pagar_pagador foreign key (pagador ) references pagador(codigo),
constraint fk_conta_pagar_tipo_pagamento foreign key(tipo_pagamento) references tipo_pagamento(codigo),
constraint fk_conta_pagar_usuario foreign key(usuario) references usuario(codigo));

create table lancamento_conta_pagar (
codigo int auto_increment,
conta_pagar int not null,
valor float not null,
vinculo_parcela int not null,
constraint pk_lancamento_conta_pagar primary key (codigo),
constraint fk_lancamento_conta_pagar foreign key(conta_pagar) references conta_pagar(codigo));
