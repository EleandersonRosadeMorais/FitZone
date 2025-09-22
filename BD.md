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
    sexo VARCHAR(10),
    ativo BOOLEAN DEFAULT TRUE
);

CREATE TABLE INSTRUTOR (
    pkInstrutor INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    especialidade VARCHAR(100),
    cref VARCHAR(20) UNIQUE,
    telefone VARCHAR(20),
    email VARCHAR(100),
    senha VARCHAR(500)
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



CREATE TABLE TREINO (
    pkTreino INT AUTO_INCREMENT PRIMARY KEY,
    fkUsuario INT NOT NULL,
    fkInstrutor INT NOT NULL,
    nome VARCHAR(100),
    descricao TEXT,
    objetivo VARCHAR(255),
    duracao_minutos INT,
    concluido BOOLEAN,
    FOREIGN KEY (fkUsuario) REFERENCES USUARIO(pkUsuario),
    FOREIGN KEY (fkInstrutor) REFERENCES INSTRUTOR(pkInstrutor)
);
CREATE TABLE EXERCICIO_TREINO (
    pkExercicioTreino INT AUTO_INCREMENT PRIMARY KEY,
    fkTreino INT NOT NULL,
    fkExercicio INT NOT NULL,
    carga INT,
    repeticoes INT,
    series INT,
    ordem INT,
    FOREIGN KEY (fkTreino) REFERENCES TREINO(pkTreino),
    FOREIGN KEY (fkExercicio) REFERENCES EXERCICIO(pkExercicio),
    ON DELETE CASCADE
);
CREATE TABLE AVALIACAO_FISICA (
    pkAvaliacaoFisica INT AUTO_INCREMENT PRIMARY KEY,
    fkUsuario INT NOT NULL,
    data_avaliacao DATE NOT NULL,
    peso DECIMAL(5,2),
    altura DECIMAL(4,2),
    circunferencia_abdominal DECIMAL(5,2),
    massa_muscular DECIMAL(5,2),      
    gordura_corporal DECIMAL(5,2),     
    imc DECIMAL(5,2),                  
    tmb DECIMAL(6,2),                 
    observacoes TEXT,
    FOREIGN KEY (fkUsuario) REFERENCES USUARIO(pkUsuario)
);

CREATE TABLE DIETA (
    pkDieta INT AUTO_INCREMENT PRIMARY KEY,
    fkUsuario INT NOT NULL,
    refeicao VARCHAR(100),
    peso DECIMAL(5,2),
    calorias DECIMAL(5,2),
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
    duracao_minima INT
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

-- 3. Inserir exercícios base
INSERT INTO exercicio (nome, descricao, tipo, grupo_muscular, equipamento, nivel_dificuldade)
VALUES 
('Supino Reto', 'Trabalha peitoral maior', 'Força', 'Peitoral', 'Banco + barra', 'Intermediário'),
('Agachamento Livre', 'Trabalha pernas e glúteos', 'Força', 'Quadríceps', 'Barra', 'Avançado');

INSERT INTO BENEFICIO (nome, descricao, tipo) VALUES
('Acesso à academia', 'Uso livre de todas as áreas da academia', 'serviço'),
('Aulas coletivas', 'Participação em todas as aulas coletivas', 'serviço'),
('Personal trainer', 'Sessão semanal com personal trainer', 'serviço'),
('Sauna', 'Uso da sauna 2x por semana', 'serviço'),
('Piscina', 'Acesso à piscina', 'serviço'),
('Massagem', '1 sessão mensal de massagem', 'serviço');

INSERT INTO PLANO (nome, descricao, preco_mensal, duracao_minima) VALUES
('Plano Básico', 'Plano com acesso à academia e aulas coletivas', 99.90, 1),
('Plano Premium', 'Plano completo com todos os benefícios inclusos', 199.90, 1);

-- Plano Básico terá: Acesso à academia, Aulas coletivas, Piscina
INSERT INTO PLANO_BENEFICIO (fkPlano, fkBeneficio, detalhes, quantidade) VALUES
(1, 1, 'Uso ilimitado da academia', NULL),
(1, 2, 'Participação em todas as aulas coletivas', NULL),
(1, 5, 'Acesso à piscina', NULL);

-- Plano Premium terá: Personal trainer, Sauna, Massagem
INSERT INTO PLANO_BENEFICIO (fkPlano, fkBeneficio, detalhes, quantidade) VALUES
(2, 3, '1 sessão semanal com personal', 4),
(2, 4, 'Uso da sauna 2x por semana', 8),
(2, 6, '1 sessão mensal de massagem', 1);
