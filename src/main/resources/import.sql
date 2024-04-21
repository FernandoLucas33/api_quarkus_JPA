CREATE SCHEMA IF NOT EXISTS loja AUTHORIZATION sa;

CREATE TABLE IF NOT EXISTS loja.PESSOAS(

idPessoa BIGINT NOT NULL,
nome VARCHAR(100) NOT NULL,
sobrenome VARCHAR(200),
PRIMARY KEY (idPessoa)
);

INSERT INTO loja.PESSOAS (idPessoa, nome, sobrenome) VALUES (1, 'Fernando', 'Araujo');
INSERT INTO loja.PESSOAS (idPessoa, nome, sobrenome) VALUES (2, 'Fátima', 'Araujo');
INSERT INTO loja.PESSOAS (idPessoa, nome, sobrenome) VALUES (3, 'João', 'Araujo');
INSERT INTO loja.PESSOAS (idPessoa, nome, sobrenome) VALUES (4, 'Benjamin', 'Araujo');