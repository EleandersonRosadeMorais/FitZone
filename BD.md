CREATE DATABASE FitZone;
USE FitZone;

CREATE TABLE USUARIO (
    pkUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    telefone VARCHAR(20),
    data_nascimento DATE,
    objetivo VARCHAR(255),
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    imagem LONGBLOB,
    cpf VARCHAR(14) UNIQUE,
    ativo BOOLEAN DEFAULT TRUE
);

CREATE TABLE INSTRUTOR (
    pkInstrutor INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    especialidade VARCHAR(100),
    cref VARCHAR(20) UNIQUE,
    telefone VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE EXERCICIO (
    pkExercicio INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    tipo VARCHAR(50),
    grupo_muscular VARCHAR(50),
    equipamento VARCHAR(50),
    nivel_dificuldade VARCHAR(50)
);

CREATE TABLE EXERCICIO_TREINO (
    pkExercicioTreino INT AUTO_INCREMENT PRIMARY KEY,
    fkExercicio INT NOT NULL,
    carga INT,
    repeticoes INT,
    series INT,
    ordem INT,
    FOREIGN KEY (fkExercicio) REFERENCES EXERCICIO(pkExercicio)
);

CREATE TABLE TREINO (
    pkTreino INT AUTO_INCREMENT PRIMARY KEY,
    fkUsuario INT NOT NULL,
    fkInstrutor INT NOT NULL,
    nome VARCHAR(100),
    descricao TEXT,
    objetivo VARCHAR(255),
    duracao_minutos INT,
    concluido boolean,
    fkExercicioTreino INT,
    FOREIGN KEY (fkUsuario) REFERENCES USUARIO(pkUsuario),
    FOREIGN KEY (fkInstrutor) REFERENCES INSTRUTOR(pkInstrutor),
    FOREIGN KEY (fkExercicioTreino) REFERENCES EXERCICIO_TREINO(pkExercicioTreino)
);

CREATE TABLE AVALIACAO_FISICA (
    pkAvaliacaoFisica INT AUTO_INCREMENT PRIMARY KEY,
    fkUsuario INT NOT NULL,
    data_avaliacao DATE NOT NULL,
    peso DECIMAL(5,2),
    altura DECIMAL(4,2),
    circunferencia_abdominal DECIMAL(5,2),
    observacoes TEXT,
    FOREIGN KEY (fkUsuario) REFERENCES USUARIO(pkUsuario)
);

CREATE TABLE DIETA (
    pkDieta INT AUTO_INCREMENT PRIMARY KEY,
    fkUsuario INT NOT NULL,
    refeicao VARCHAR(100),
    peso DECIMAL(5,2),
    calorias INT,
    proteinas DECIMAL(5,2),
    carboidratos DECIMAL(5,2),
    gorduras DECIMAL(5,2),
    observacoes TEXT,
    FOREIGN KEY (fkUsuario) REFERENCES USUARIO(pkUsuario)
);

CREATE TABLE PLANO (
    pkPlano INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco_mensal DECIMAL(10,2) NOT NULL,
    duracao_minima INT,
    ativo BOOLEAN DEFAULT TRUE
);

CREATE TABLE ASSINATURA (
    pkAssinatura INT AUTO_INCREMENT PRIMARY KEY,
    fkUsuario INT NOT NULL,
    fkPlano INT NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE,
    status VARCHAR(50),
    data_renovacao DATE,
    FOREIGN KEY (fkUsuario) REFERENCES USUARIO(pkUsuario),
    FOREIGN KEY (fkPlano) REFERENCES PLANO(pkPlano)
);

CREATE TABLE BENEFICIO (
    pkBeneficio INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    tipo VARCHAR(50)
);

CREATE TABLE PLANO_BENEFICIO (
    pkPlanoBeneficio INT AUTO_INCREMENT PRIMARY KEY,
    fkPlano INT NOT NULL,
    fkBeneficio INT NOT NULL,
    detalhes TEXT,
    quantidade INT,
    FOREIGN KEY (fkPlano) REFERENCES PLANO(pkPlano),
    FOREIGN KEY (fkBeneficio) REFERENCES BENEFICIO(pkBeneficio)
);

use fitzone;

insert into instrutor(nome, especialidade, cref, telefone, email) values ("Rogerio", "tirar peso", "1231232131", "5199999999999", "rogerio@gmail.com");
insert into exercicio(nome, descricao, tipo, grupo_muscular, equipamento, nivel_dificuldade) values ("Rosca direta", "usado para aumentar o biceps", "seila", "biceps", "halter", 5);
insert into exercicio_treino(fkExercicio, carga, repeticoes, series, ordem) values (1, 40, 12, 4, 1);
insert into treino(fkUsuario, fkInstrutor,nome, descricao, objetivo, duracao_minutos, fkExercicioTreino) 
values (1, 1, "Braços", "queimar os biceps", "aumentar", 50, 1);

insert into exercicio(nome, descricao, tipo, grupo_muscular, equipamento, nivel_dificuldade) values ("Supino reto", "usado para aumentar a força no peito", "seila", "peitoral", "barra", 4);
insert into exercicio_treino(fkExercicio, carga, repeticoes, series, ordem) values (2, 60, 10, 4, 1);
insert into treino(fkUsuario, fkInstrutor, nome, descricao, objetivo, duracao_minutos, fkExercicioTreino) 
values (1, 1, "Peito", "fortalecer o peitoral", "hipertrofia", 60, 2);