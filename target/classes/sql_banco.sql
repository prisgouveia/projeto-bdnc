create table denuncia(
	id serial primary key,
	ocorrencia varchar, 
	data date, 
	situacao varchar, 
	info varchar, 
	ponto geometry
	
);

create table usuario(
	id serial primary key,
	nome varchar,
	email varchar,
	senha varchar
	
)