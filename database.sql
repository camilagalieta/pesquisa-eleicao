CREATE DATABASE pesquisa_eleicao;
USE pesquisa_eleicao;

CREATE TABLE candidato (
    id INT NOT NULL auto_increment,
    nome VARCHAR(255) NOT NULL,
    partido VARCHAR(255) NOT NULL,
    ficha_limpa BOOLEAN,
    PRIMARY KEY (id)
);

CREATE TABLE pesquisa (
    id INT NOT NULL auto_increment,
    instituto VARCHAR(255) NOT NULL,
    data varchar(255) NOT NULL,
    local VARCHAR(255) NOT NULL,
    idadeMedia INT NOT NULL,
    tipoPesquisa VARCHAR(255) NOT NULL,
    formatoPesquisa VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE candidato_pesquisa (
    id INT NOT NULL auto_increment,
    candidato_id INT NOT NULL,
    pesquisa_id INT NOT NULL,
    voto INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (candidato_id)
        REFERENCES candidato (id),
    FOREIGN KEY (pesquisa_id)
        REFERENCES pesquisa (id)
);
