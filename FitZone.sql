CREATE DATABASE  IF NOT EXISTS `fitzone` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `fitzone`;
-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fitzone
-- ------------------------------------------------------
-- Server version	8.0.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assinatura`
--

DROP TABLE IF EXISTS `assinatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assinatura` (
  `pkAssinatura` int NOT NULL AUTO_INCREMENT,
  `fkUsuario` int NOT NULL,
  `fkPlano` int NOT NULL,
  `data_inicio` date NOT NULL,
  `data_fim` date DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `data_renovacao` date DEFAULT NULL,
  PRIMARY KEY (`pkAssinatura`),
  KEY `fkUsuario` (`fkUsuario`),
  KEY `fkPlano` (`fkPlano`),
  CONSTRAINT `assinatura_ibfk_1` FOREIGN KEY (`fkUsuario`) REFERENCES `usuario` (`pkUsuario`),
  CONSTRAINT `assinatura_ibfk_2` FOREIGN KEY (`fkPlano`) REFERENCES `plano` (`pkPlano`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assinatura`
--

LOCK TABLES `assinatura` WRITE;
/*!40000 ALTER TABLE `assinatura` DISABLE KEYS */;
/*!40000 ALTER TABLE `assinatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avaliacao_fisica`
--

DROP TABLE IF EXISTS `avaliacao_fisica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avaliacao_fisica` (
  `pkAvaliacaoFisica` int NOT NULL AUTO_INCREMENT,
  `fkUsuario` int NOT NULL,
  `data_avaliacao` date NOT NULL,
  `peso` decimal(5,2) DEFAULT NULL,
  `altura` decimal(4,2) DEFAULT NULL,
  `circunferencia_abdominal` decimal(5,2) DEFAULT NULL,
  `massa_muscular` decimal(5,2) DEFAULT NULL,
  `gordura_corporal` decimal(5,2) DEFAULT NULL,
  `imc` decimal(5,2) DEFAULT NULL,
  `tmb` decimal(6,2) DEFAULT NULL,
  `observacoes` text,
  PRIMARY KEY (`pkAvaliacaoFisica`),
  KEY `fkUsuario` (`fkUsuario`),
  CONSTRAINT `avaliacao_fisica_ibfk_1` FOREIGN KEY (`fkUsuario`) REFERENCES `usuario` (`pkUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao_fisica`
--

LOCK TABLES `avaliacao_fisica` WRITE;
/*!40000 ALTER TABLE `avaliacao_fisica` DISABLE KEYS */;
/*!40000 ALTER TABLE `avaliacao_fisica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `beneficio`
--

DROP TABLE IF EXISTS `beneficio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `beneficio` (
  `pkBeneficio` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` text,
  `tipo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pkBeneficio`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beneficio`
--

LOCK TABLES `beneficio` WRITE;
/*!40000 ALTER TABLE `beneficio` DISABLE KEYS */;
INSERT INTO `beneficio` VALUES (1,'Acesso a Suporte 24h','Suporte t√©cnico dispon√≠vel 24 horas por dia, 7 dias por semana.','Suporte'),(2,'Armazenamento Extra','Espa√ßo adicional para armazenamento de dados.','Armazenamento'),(3,'Desconto em Produtos','Desconto exclusivo em produtos selecionados.','Desconto'),(4,'Acesso a Cursos Online','Cursos de capacita√ß√£o gratuitos e exclusivos.','Educa√ß√£o'),(5,'VPN Premium','Acesso a VPN de alta seguran√ßa para navega√ß√£o an√¥nima.','Seguran√ßa'),(6,'Backup Autom√°tico','Backup di√°rio e autom√°tico de seus dados.','Seguran√ßa');
/*!40000 ALTER TABLE `beneficio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dieta`
--

DROP TABLE IF EXISTS `dieta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dieta` (
  `pkDieta` int NOT NULL AUTO_INCREMENT,
  `fkUsuario` int NOT NULL,
  `refeicao` varchar(100) DEFAULT NULL,
  `peso` decimal(5,2) DEFAULT NULL,
  `calorias` decimal(5,2) DEFAULT NULL,
  `proteinas` decimal(5,2) DEFAULT NULL,
  `carboidratos` decimal(5,2) DEFAULT NULL,
  `gorduras` decimal(5,2) DEFAULT NULL,
  `observacoes` text,
  PRIMARY KEY (`pkDieta`),
  KEY `fkUsuario` (`fkUsuario`),
  CONSTRAINT `dieta_ibfk_1` FOREIGN KEY (`fkUsuario`) REFERENCES `usuario` (`pkUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dieta`
--

LOCK TABLES `dieta` WRITE;
/*!40000 ALTER TABLE `dieta` DISABLE KEYS */;
/*!40000 ALTER TABLE `dieta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercicio`
--

DROP TABLE IF EXISTS `exercicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercicio` (
  `pkExercicio` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` text,
  `tipo` varchar(50) DEFAULT NULL,
  `grupo_muscular` varchar(50) DEFAULT NULL,
  `equipamento` varchar(50) DEFAULT NULL,
  `nivel_dificuldade` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pkExercicio`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercicio`
--

LOCK TABLES `exercicio` WRITE;
/*!40000 ALTER TABLE `exercicio` DISABLE KEYS */;
INSERT INTO `exercicio` VALUES (1,'Puxada na Barra Fixa','Trabalha as costas e b√≠ceps','For√ßa','Dorsal','Barra fixa','Intermedi√°rio'),(2,'Flex√£o de Bra√ßo','Trabalha peito, ombro e tr√≠ceps','For√ßa','Peitoral','Peso corporal','Iniciante'),(3,'Leg Press','Trabalha quadr√≠ceps, gl√∫teos e panturrilhas','For√ßa','Quadr√≠ceps','Leg Press','Intermedi√°rio'),(4,'Desenvolvimento com Halteres','Trabalha ombros e tr√≠ceps','For√ßa','Ombros','Halteres','Intermedi√°rio'),(5,'Remada Curvada','Trabalha costas e b√≠ceps','For√ßa','Dorsal','Barra ou halteres','Avan√ßado'),(6,'Deadlift','Trabalha costas, pernas e gl√∫teos','For√ßa','Gl√∫teos','Barra','Avan√ßado'),(7,'Barra Fixa com Pegada Invertida','Trabalha costas e b√≠ceps','For√ßa','Dorsal','Barra fixa','Intermedi√°rio'),(8,'Cadeira Extensora','Trabalha quadr√≠ceps','For√ßa','Quadr√≠ceps','Cadeira extensora','Iniciante'),(9,'Tr√≠ceps Pulley','Trabalha tr√≠ceps','For√ßa','Tr√≠ceps','Pulley','Intermedi√°rio'),(10,'Abdominal na M√°quina','Trabalha a musculatura abdominal','For√ßa','Abdominais','M√°quina de abdominal','Iniciante');
/*!40000 ALTER TABLE `exercicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercicio_treino`
--

DROP TABLE IF EXISTS `exercicio_treino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercicio_treino` (
  `pkExercicioTreino` int NOT NULL AUTO_INCREMENT,
  `fkTreino` int NOT NULL,
  `fkExercicio` int NOT NULL,
  `carga` int DEFAULT NULL,
  `repeticoes` int DEFAULT NULL,
  `series` int DEFAULT NULL,
  `ordem` int DEFAULT NULL,
  PRIMARY KEY (`pkExercicioTreino`),
  KEY `fkTreino` (`fkTreino`),
  KEY `fkExercicio` (`fkExercicio`),
  CONSTRAINT `exercicio_treino_ibfk_1` FOREIGN KEY (`fkTreino`) REFERENCES `treino` (`pkTreino`) ON DELETE CASCADE,
  CONSTRAINT `exercicio_treino_ibfk_2` FOREIGN KEY (`fkExercicio`) REFERENCES `exercicio` (`pkExercicio`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercicio_treino`
--

LOCK TABLES `exercicio_treino` WRITE;
/*!40000 ALTER TABLE `exercicio_treino` DISABLE KEYS */;
INSERT INTO `exercicio_treino` VALUES (4,1,4,12312,12312,21312,21312),(5,1,8,3123123,23123,12312,1231);
/*!40000 ALTER TABLE `exercicio_treino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instrutor`
--

DROP TABLE IF EXISTS `instrutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instrutor` (
  `pkInstrutor` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `especialidade` varchar(100) DEFAULT NULL,
  `cref` varchar(20) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `senha` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`pkInstrutor`),
  UNIQUE KEY `cref` (`cref`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instrutor`
--

LOCK TABLES `instrutor` WRITE;
/*!40000 ALTER TABLE `instrutor` DISABLE KEYS */;
INSERT INTO `instrutor` VALUES (1,'jeferson','tirar tudo','123123-B/RN','51111111111','jef@gmail.com','88ea39439e74fa27c09a4fc0bc8ebe6d00978392');
/*!40000 ALTER TABLE `instrutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plano`
--

DROP TABLE IF EXISTS `plano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plano` (
  `pkPlano` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` text,
  `preco_mensal` decimal(10,2) NOT NULL,
  `duracao_minima` int DEFAULT NULL,
  PRIMARY KEY (`pkPlano`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plano`
--

LOCK TABLES `plano` WRITE;
/*!40000 ALTER TABLE `plano` DISABLE KEYS */;
INSERT INTO `plano` VALUES (1,'Plano B√°sico','Plano com recursos essenciais para iniciantes.',49.90,12),(2,'Plano Premium','Plano completo com benef√≠cios exclusivos para usu√°rios avan√ßados.',149.90,24);
/*!40000 ALTER TABLE `plano` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plano_beneficio`
--

DROP TABLE IF EXISTS `plano_beneficio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plano_beneficio` (
  `pkPlanoBeneficio` int NOT NULL AUTO_INCREMENT,
  `fkPlano` int NOT NULL,
  `fkBeneficio` int NOT NULL,
  `detalhes` text,
  `quantidade` int DEFAULT NULL,
  PRIMARY KEY (`pkPlanoBeneficio`),
  KEY `fkPlano` (`fkPlano`),
  KEY `fkBeneficio` (`fkBeneficio`),
  CONSTRAINT `plano_beneficio_ibfk_1` FOREIGN KEY (`fkPlano`) REFERENCES `plano` (`pkPlano`),
  CONSTRAINT `plano_beneficio_ibfk_2` FOREIGN KEY (`fkBeneficio`) REFERENCES `beneficio` (`pkBeneficio`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plano_beneficio`
--

LOCK TABLES `plano_beneficio` WRITE;
/*!40000 ALTER TABLE `plano_beneficio` DISABLE KEYS */;
INSERT INTO `plano_beneficio` VALUES (1,1,1,'Suporte t√©cnico dispon√≠vel 24 horas por dia.',1),(2,1,2,'Armazenamento extra de 10GB.',10),(3,1,6,'Backup di√°rio dos seus dados.',1),(4,2,3,'Desconto de 15% em produtos selecionados.',1),(5,2,4,'Acesso completo a cursos e workshops exclusivos.',1),(6,2,5,'VPN Premium com seguran√ßa m√°xima.',1);
/*!40000 ALTER TABLE `plano_beneficio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treino`
--

DROP TABLE IF EXISTS `treino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treino` (
  `pkTreino` int NOT NULL AUTO_INCREMENT,
  `fkUsuario` int NOT NULL,
  `fkInstrutor` int NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `descricao` text,
  `objetivo` varchar(255) DEFAULT NULL,
  `duracao_minutos` int DEFAULT NULL,
  PRIMARY KEY (`pkTreino`),
  KEY `fkUsuario` (`fkUsuario`),
  KEY `fkInstrutor` (`fkInstrutor`),
  CONSTRAINT `treino_ibfk_1` FOREIGN KEY (`fkUsuario`) REFERENCES `usuario` (`pkUsuario`),
  CONSTRAINT `treino_ibfk_2` FOREIGN KEY (`fkInstrutor`) REFERENCES `instrutor` (`pkInstrutor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treino`
--

LOCK TABLES `treino` WRITE;
/*!40000 ALTER TABLE `treino` DISABLE KEYS */;
INSERT INTO `treino` VALUES (1,1,1,'DeadLift Com puxada Alta Supinada','Suas costas irao doer','musculo e grande',500);
/*!40000 ALTER TABLE `treino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `pkUsuario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `objetivo` varchar(255) DEFAULT NULL,
  `data_cadastro` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `imagem` longblob,
  `cpf` varchar(14) DEFAULT NULL,
  `sexo` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`pkUsuario`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Eleanderson','eleanderson@gmail.com','88ea39439e74fa27c09a4fc0bc8ebe6d00978392','5199999999','2001-05-23','Emagrecer','2025-09-25 01:56:34',_binary 'âPNG\r\n\Z\n\0\0\0\rIHDR\0\0\0`\0\0\0Å\0\0\0?Äø\0\0OIDATx\⁄\ÌôgRKÖŸÄ6†ˇZùv†\Â\»AÄ ºw\¬{\ÔΩwB∏|ÛeDEı\È7j≈õò97\"°ªOeU\Ê˝Æ…Ü¢/{||\Ã;l÷ä¯Ò\Ó›ª\Ê\Õ9jkk\Ì•?\r\‡\Ì€∑°®®Hé™™*{\…\0˛\«|¯!ºˇ^éÒÒq{\ÈO∞Ä\ÿ¿\0l`\060Ä¨\Ì\Ì\Ì\ŸSˇ$Äµµ5{\ \0˛è\0\‡ûûû\–\€\€G}}˝\”kèó\r¸˘\€\0˙˚˚\√\È\ÈihooœπQ[[[8;;ùùù9\Z\◊á\Ó\Ó\Óç\Î§\∆gªªªœ†ß\«ˆˆ∂\‘X\Á\∆∆Üú388Ii?~¸+++R	\À\À\ÀRãããRõòòÛÛÛRõöö\n]]]Ö`c<{xx˜˜˜Ò57bÅ[[[Ò˝\’\’\’3çá=i\ÃM¥\—\—\—pqq\ﬂ3\'≠·∞õõõ¯ûk\“\ZõHûqyy˘Ùü:¥Ù∆Äüûó÷òóXVK÷§4ˆp{{+µü?\Ê}Azww\'µÇúúú\ƒ\ËU\0∏n_ rwvv$Ä\…\……ß\Î≤\0–í\Î≤\0˙˙˙¢S\‘\∆XK>G∂∂∂>î¥\÷\“\“\"5@£±_•ëï\Á\Á\Á9\ZP\»¯\‰Ù¯b\0¸¶4§GMMM\\\Èò\’¯˜%\0\Ê\ÊÊ§ñ§wV´´´ã\0\÷\◊\◊s4˙fVkhhà\Õ~ûhRkllÃ´}ˇ˛=ñR•555\≈¨¥\Ê\Ê\Ê9üV0Ä\Î\Î\Î0;;õ3p\ÓØ_ø§∂∞∞£XidSæ{.--≈®V\ZµölP\⁄\Í\Íjå@•Qˇ)J#∏\»j•mnn\∆R¶4ÇÄ¨U\ZôNïP\Z^îïïïahh\Ë\Ÿ¯¯Òct\nñ\’>˛¶ßßc$dµØ_ø\∆\ƒB≤Zqqq\Ã\0JMV+))â000ê£ïññ\∆\»~\Œ(++ãë¨¥ÚÚrπFFEEEåX•\·2Di\’\’\’1≥îFˆø™\‡pH™¿k´z\0Û9\‰\Î\\´z\0ôDV®@#Um\'UØï|ü\…\÷k÷ò\ÓUâ\∆3ááác\‰g5\Z,kQ\ZMõ5\'>zu¶<§mˆD\ *\0ú<“ç6\r\0-\›\ÿ\”\0∏\'\'Ä“ë~^zch˘ö\"\ŒW\Z˜•YRï#ì“ô\’X+>RÆß\Ï$\'Ø¿q4ùÏôñÜyxxS8´Qñà$\Z\\V#u©ØâC”Éî\«A\Í;\œ!\‘˜\0JŸ¢\Œ\ﬁD<ô¢4û333ì˜KA§>\«/dã\“\»>&J£ÄÖ+gxº|d˛s¥ˇ`3\0∞Ä\ÿ¿\0l`\060\0∞Ä\ÿ¿\0l`\060\0õÄ\Õ\0¿f\0`3\0∞Ä\ÿ¿\0l`\060\0õÄ\Õ\0¿f\0`3\0∞Ä\ÿ¿\0l`\060\0õÄ\Õ\0¿f\0`3\0∞Ä\ÿ¿\0l`\060\0õÄ\Õ\0¿f\0`\0vÅÄ\Õ\0¿f\0`3\0∞Ä\ÿ˛a\0;;;°ßß\'Ùˆˆz¸á\∆\–\–\–\Ô\Ë\Ô\Ô°ªª;\ÁFÄπ∫∫íÄ˙˙˙\¬˘˘π\‘\¬\È\Èi\ﬁ\≈Kmxx8Jmtt4\Ï\Ô\ÔKm||<\Ï\Ó\ÓJmrr2looKmzz:lnnJmvv6¨ØØKm~~>¨ÆÆJmqq1tuu`cc#NL\ÏÒÒ1˛\ÊF\À\À\Àakk+æxxx¶MMMÖ£££\'-14ÿ¨°\rÜõõ9èM\‹\ﬂ\ﬂK-Ω±\‰\Z•˝›ºß•˜ó÷í\œùW0\0¢ìhR\0b\…R\0∏éHS\0\∆\∆\∆\¬¡¡Å@∂êI\n@kkk∏ººî\„Ÿâ3≥ZMM\Õ\”=~W√ÅµµµannNj¨Ö¨\Œj¨°ææ˛\…G/@\ \›\›\›=\Ì\Ì\Ì—±kkkR\√	î•\‡\‰\‰Dj\0¿±Y≠££#\0é\“\ÿXˆÛ\◊jùùùk|˛wZ¡\0pN\…\Íıııµ‘®\◊˘Êçååƒ®V\Z\Ÿ@$)mbb\"BSZímJõôôâ¶4kooOj\‘r2ZiT2Zi%ΩCiÙÜÇê>9\r\Â”ßO1˙IÕ¨ˆ\ÂÀó∏Å¶¶¶≠∏∏86ø∂∂∂≠§§$J¢==JKK\„&‘Å†¨¨,Ô©£ºº\\\Œa|˚ˆ-F•“™™™bF*çRE\ŸQZ]]]hnnñZCC\√\Îz\0Øóññd@£®∞≤≤#Qı\0\Í*∞T`Q£z\0ßûØj+\”Û\“ıö˚´öLΩ&#(õYçg≤ütˇK4JŸ©\Ê\›\ﬁ\ﬁ\∆SX∫«Ω\n\0•#\›L\”\0(\Õ\04R]†±ß\Ôôpvvˆ¨—¶\‡åÙ=\”\√j\”8\‡<S9ôΩ$\Î\ :í˝p\Ï\Œj¨ï@QMòM¿R:_Ä\Õ\–…≥\ÈDY\¬™\ÃTVVFp™\ÃTWW\«´2C9#ãgßk ã\‘wã\∆\∆\∆X\÷T⁄≥>¢Pi---1î\∆\⁄\ÈeJc\ÌÙ@•±vNoJc\Ì µÚ\’Oèó\rzÑˇ\‰?\∆\Ÿ¿\0l_d!˛1Rù\0\0\0\0IENDÆB`Ç','36218694097','homem');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-24 23:30:04
