CREATE
DATABASE cadastro_usuarios;

CREATE TABLE enderecos
(
    id         SERIAL PRIMARY KEY,
    cep        VARCHAR(8),
    logradouro VARCHAR(100),
    bairro     VARCHAR(50),
    cidade     VARCHAR(50),
    estado     VARCHAR(2)
);

CREATE TABLE usuarios
(
    id              SERIAL PRIMARY KEY,
    nome            VARCHAR(100) NOT NULL,
    username        VARCHAR(50)  NOT NULL UNIQUE,
    senha           VARCHAR      NOT NULL,
    foto            BYTEA,
    cep             VARCHAR(8),
    email           VARCHAR(100) NOT NULL UNIQUE,
    data_nascimento DATE         NOT NULL,
    sexo            VARCHAR(20)  NOT NULL,
    tipo            VARCHAR(20)  NOT NULL,
    cpf_cnpj        VARCHAR(14),
    endereco_id     BIGINT,
    FOREIGN KEY (endereco_id) REFERENCES enderecos (id)
);

