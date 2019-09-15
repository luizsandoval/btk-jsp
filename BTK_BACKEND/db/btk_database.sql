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

CREATE TABLE lessee (
id int not null auto_increment,
nome varchar(100) not null,
telefone varchar(14),
celular varchar(15),
email varchar(80) not null,
dataNasc varchar(10) not null,
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
dataEmprestimo varchar(10) not null,
dataDevolucao varchar(10) not null,
dataDevolucaoReal varchar(10),
loanStatus varchar(10) not null,
PRIMARY KEY (id),
FOREIGN KEY (id_user)
REFERENCES user(id),
FOREIGN KEY (id_lessee)
REFERENCES lessee (id)
);

CREATE TABLE loan_items(
id_book int not null,
quantidade int not null,
id_loan int not null,
FOREIGN KEY (id_book)
REFERENCES book(id),
FOREIGN KEY (id_loan)
REFERENCES loan(id)
);

select * from user;
select * from author;
select * from gender;
select * from lessee;
select * from book;
select * from loan;
select * from loan_items;