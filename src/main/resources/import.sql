CREATE SCHEMA IF NOT EXISTS bblite AUTHORIZATION sa;

CREATE TABLE IF NOT EXISTS bblite.USUARIO(

id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100) NOT NULL,
cpf VARCHAR(15),
email VARCHAR(50),
password VARCHAR(50)
);

--INSERT INTO bblite.USUARIO (id, nome, cpf, email, password) VALUES (2, 'Albert Einstein','54200269023', 'albert@cientista.com.br', '456');
--INSERT INTO bblite.USUARIO (id, nome, cpf, email, password) VALUES (3, 'Doutor Lucas','86316932006','lucas@doutor.com.br', '789');
--INSERT INTO bblite.USUARIO (id, nome, cpf, email, password) VALUES (1, 'Átila  Iamarino ','21099429080','atila@biologo.com.br', '123');
--INSERT INTO bblite.USUARIO (id, nome, cpf, email, password) VALUES (4, 'Pedro Estudante','66907248085','Pedro@unb.com.br', '987');

