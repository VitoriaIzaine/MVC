/*Este script contém alguns comandos para criar um usuário, um banco, 
armazenar valores no banco e forncecer permissões ao usuário criado.alter.alter.
Para evitar problemas com os comandos, execute um comando de cada vez 
na ordem em que são apresentados.
*/

/*Cria um usuário chamado "user_aplicao" com senha "app1234" */
CREATE USER 'user_aplicacao'@'localhost' IDENTIFIED BY 'app1234';

/*cria um banco chamado "filmes"*/
create database filmes;

/*Atribui todas as permissões ao usuário "user_aplicacao" ao banco "filmes"
Um mesmo usuário pode ter permissões em vários bancos.
*/
GRANT ALL PRIVILEGES ON filmes.* TO 'user_aplicacao'@'localhost';

/* Configura autenticacao do usuario criado */
ALTER USER 'user_aplicacao'@'localhost' IDENTIFIED WITH mysql_native_password BY 'app1234';

/*cria uma tabela filme */
CREATE TABLE filme(
	id_filme int auto_increment not null,
    nome varchar(50),
    genero varchar(50),
    plataforma varchar(50),
    status_film varchar(50),
    avaliacao int,
    
    primary key (id_filme)
);

/*Insere alguns filmes no banco*/
insert into filmes.filme(nome, genero, plataforma, status_film, avaliacao) values ("Harry Potter 1", "Fantasia", "NetFlix", "A assistir", 5);
insert into filmes.filme(nome, genero, plataforma, status_film, avaliacao) values ("Harry Potter 2", "Fantasia", "NetFlix", "A assistir", 1);
insert into filmes.filme(nome, genero, plataforma, status_film, avaliacao) values ("Harry Potter 3", "Fantasia", "NetFlix", "A assistir", 2);
insert into filmes.filme(nome, genero, plataforma, status_film, avaliacao) values ("Harry Potter 4", "Fantasia", "NetFlix", "A assistir", 3);
insert into filmes.filme(nome, genero, plataforma, status_film, avaliacao) values ("Harry Potter 5", "Fantasia", "NetFlix", "A assistir", 4);

