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
    sexo VARCHAR(10)
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
    FOREIGN KEY (fkTreino) REFERENCES TREINO(pkTreino) ON DELETE CASCADE,
    FOREIGN KEY (fkExercicio) REFERENCES EXERCICIO(pkExercicio)
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


INSERT INTO exercicio (nome, descricao, tipo, grupo_muscular, equipamento, nivel_dificuldade)
VALUES 
('Puxada na Barra Fixa', 'Trabalha as costas e bíceps', 'Força', 'Dorsal', 'Barra fixa', 'Intermediário'),
('Flexão de Braço', 'Trabalha peito, ombro e tríceps', 'Força', 'Peitoral', 'Peso corporal', 'Iniciante'),
('Leg Press', 'Trabalha quadríceps, glúteos e panturrilhas', 'Força', 'Quadríceps', 'Leg Press', 'Intermediário'),
('Desenvolvimento com Halteres', 'Trabalha ombros e tríceps', 'Força', 'Ombros', 'Halteres', 'Intermediário'),
('Remada Curvada', 'Trabalha costas e bíceps', 'Força', 'Dorsal', 'Barra ou halteres', 'Avançado'),
('Deadlift', 'Trabalha costas, pernas e glúteos', 'Força', 'Glúteos', 'Barra', 'Avançado'),
('Barra Fixa com Pegada Invertida', 'Trabalha costas e bíceps', 'Força', 'Dorsal', 'Barra fixa', 'Intermediário'),
('Cadeira Extensora', 'Trabalha quadríceps', 'Força', 'Quadríceps', 'Cadeira extensora', 'Iniciante'),
('Tríceps Pulley', 'Trabalha tríceps', 'Força', 'Tríceps', 'Pulley', 'Intermediário'),
('Abdominal na Máquina', 'Trabalha a musculatura abdominal', 'Força', 'Abdominais', 'Máquina de abdominal', 'Iniciante');

-- Inserir planos
INSERT INTO PLANO (nome, descricao, preco_mensal, duracao_minima) 
VALUES 
('Plano Básico', 'Plano com recursos essenciais para iniciantes.', 49.90, 12),
('Plano Premium', 'Plano completo com benefícios exclusivos para usuários avançados.', 149.90, 24);

-- Inserir benefícios
INSERT INTO BENEFICIO (nome, descricao, tipo) 
VALUES 
('Acesso a Suporte 24h', 'Suporte técnico disponível 24 horas por dia, 7 dias por semana.', 'Suporte'),
('Armazenamento Extra', 'Espaço adicional para armazenamento de dados.', 'Armazenamento'),
('Desconto em Produtos', 'Desconto exclusivo em produtos selecionados.', 'Desconto'),
('Acesso a Cursos Online', 'Cursos de capacitação gratuitos e exclusivos.', 'Educação'),
('VPN Premium', 'Acesso a VPN de alta segurança para navegação anônima.', 'Segurança'),
('Backup Automático', 'Backup diário e automático de seus dados.', 'Segurança');

-- Associando benefícios ao Plano Básico (ID: 1)
INSERT INTO PLANO_BENEFICIO (fkPlano, fkBeneficio, detalhes, quantidade)
VALUES 
(1, 1, 'Suporte técnico disponível 24 horas por dia.', 1), 
(1, 2, 'Armazenamento extra de 10GB.', 10),              
(1, 6, 'Backup diário dos seus dados.', 1);             

INSERT INTO PLANO_BENEFICIO (fkPlano, fkBeneficio, detalhes, quantidade)
VALUES 
(2, 3, 'Desconto de 15% em produtos selecionados.', 1), 
(2, 4, 'Acesso completo a cursos e workshops exclusivos.', 1),
(2, 5, 'VPN Premium com segurança máxima.', 1); 