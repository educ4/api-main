create table alunos(
    cpf varchar(14) not null,
    nome varchar(100) not null,
    sexo varchar(100) not null,
    email varchar(100) not null unique,
    senha varchar(255) not null,

    primary key(cpf)

);