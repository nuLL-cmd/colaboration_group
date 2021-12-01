create table if not exists tb_funcionario(
	
	nr_matricula int(10) not null primary key auto_increment,
	nm_funcionario varchar(100) not null,
	idade int(3) not null,
	nacionalidade varchar(30) not null	
	
);

create table if not exists tb_endereco(
	
	id_endereco int(10) not null primary key auto_increment,
	logradouro varchar(100) not null,
	bairro varchar(25) not null,
	numero int(6),
	cidade varchar(50) not null,
	estado varchar(25) not null
	
);

alter table tb_funcionario add column id_endereco int(10) not null;
alter table tb_funcionario add constraint fk_id_endereco_tb_endereco foreign key(id_endereco) references tb_endereco(id_endereco);


create table if not exists tb_atividade(
	
	id_atividade int(10) not null primary key auto_increment,
	nm_atividade varchar(50) not null,
	dt_alteracao date not null
	
);


create table if not exists tb_atividade_funcionario(
	
	id_atv_func int(6) not null primary key auto_increment,
	nr_matriculla int(6) not null,
	id_atividade int(10) not null,
	dt_entrada date not null
	
);

alter table tb_atividade_funcionario change nr_matriculla nr_matricula int(6)
alter table tb_atividade_funcionario add constraint fk_nr_matricula_tb_funcionario foreign key(nr_matricula) references tb_funcionario(nr_matricula) on update no action on delete cascade;
alter table tb_atividade_funcionario add constraint fk_id_atividade_tb_atividade foreign key(id_atividade) references tb_atividade(id_atividade) on update no action on delete cascade
alter table tb_endereco add column nr_matricula int(6) not null
alter table tb_endereco add constraint fk_matricula_tb_funcionario foreign key(nr_matricula) references tb_funcionario(nr_matricula) on update no action on delete cascade


insert into tb_funcionario(nm_funcionario, idade, nacionalidade) values ("Marco Aurélio", 30, "Brasileiro")

insert into tb_endereco(logradouro, bairro, numero, cidade, estado, nr_matricula) values("Rua 11", "Setor Oeste", 145, "Trindade", "GO", 1)

insert into tb_atividade (nm_atividade, dt_alteracao) values("Monitor de Banco de Dados", "2021-11-20")

insert into tb_atividade_funcionario (nr_matricula, id_atividade, dt_entrada) values(1,1,"2021-11-20")