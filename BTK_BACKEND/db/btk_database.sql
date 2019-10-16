drop database btk;
create database btk;
use btk;

CREATE TABLE user(
id int not null auto_increment,
nome varchar(100),
email varchar(50) not null,
senha  varchar (10) not null,
PRIMARY KEY (id)
);
         
CREATE TABLE author(
id int not null auto_increment,
nome varchar(100) not null,
sexo varchar (10) not null,
idade varchar(3),
nacionalidade varchar (20),
PRIMARY KEY (id)
);

CREATE TABLE gender(
id int not null auto_increment,
nome varchar (30) not null,
descricao varchar(100),
PRIMARY KEY (id)
);

CREATE TABLE book (
id int not null auto_increment,
nome varchar(100) not null,
editora varchar(35),
descricao varchar(200),
quantidade int not null,
id_gender int not null,
id_author int not null,
PRIMARY KEY (id),
FOREIGN KEY (id_gender)
REFERENCES gender(id),
FOREIGN KEY (id_author)
REFERENCES author(id)
);

CREATE TABLE loan(
id int not null auto_increment,
id_user int not null,
id_lessee int not null,
id_book int not null,
dataEmprestimo date not null,
dataDevolucao date not null,
dataDevolucaoReal date,
loanStatus varchar(10) not null,
PRIMARY KEY (id),
FOREIGN KEY (id_user)
REFERENCES user(id),
FOREIGN KEY (id_lessee)
REFERENCES user (id),
FOREIGN KEY (id_book)
REFERENCES book (id)
);
