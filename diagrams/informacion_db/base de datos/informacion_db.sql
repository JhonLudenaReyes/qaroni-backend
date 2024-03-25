-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: informacion_db
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `asignaciones`
--

DROP TABLE IF EXISTS `asignaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asignaciones` (
  `id_asignacion` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `id_empleado` int NOT NULL,
  `id_proyecto` int NOT NULL,
  `id_supervisor` int NOT NULL,
  `horas_destinadas` int DEFAULT NULL,
  PRIMARY KEY (`id_asignacion`,`id_empleado`,`id_proyecto`,`id_supervisor`),
  KEY `fk_asignaciones_empleados_idx` (`id_empleado`),
  KEY `fk_asignaciones_proyectos_idx` (`id_proyecto`),
  KEY `fk_asignaciones_supervisores_idx` (`id_supervisor`),
  CONSTRAINT `fk_asignaciones_empleados` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`),
  CONSTRAINT `fk_asignaciones_proyectos` FOREIGN KEY (`id_proyecto`) REFERENCES `proyectos` (`id_proyecto`),
  CONSTRAINT `fk_asignaciones_supervisores` FOREIGN KEY (`id_supervisor`) REFERENCES `supervisores` (`id_supervisor`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignaciones`
--

LOCK TABLES `asignaciones` WRITE;
/*!40000 ALTER TABLE `asignaciones` DISABLE KEYS */;
INSERT INTO `asignaciones` VALUES (3,'MONITOREO DE PLANTA',1,1,1,160),(4,'INFRAESTRUCTURA ELECTRICA',2,1,1,145),(5,'PLANEACION ESTRATEGICA',3,1,2,100),(6,'LOGISTICA E INFRAESTRUCTURA',4,2,3,160),(7,'REVISION DE ENERGIA',2,1,1,80),(8,'PLANES DE CONTINGENCIAS',3,1,1,45);
/*!40000 ALTER TABLE `asignaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `id_empleado` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(10) DEFAULT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `salario` double DEFAULT NULL,
  `ciudad` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'2400089658','JUAN LUIS','VERA MATIAS','1992-05-12',1400,'CARTAGENA'),(2,'0965894526','ANDRES JHON','SANTOS MORA','1990-08-20',1200,'BUENOS AIRES'),(3,'2400056897','ANA FERNANDA','LAGOS SOTO','1996-01-05',1000,'CARTAGENA'),(4,'0946895678','PEDRO JOSE','RAMIREZ CASTRO','2000-06-10',1400,'GUAYAQUIL'),(5,'2400065982','JORGE ALFREDO','SANTOS VALAREZO',NULL,1100,'CARTAGENA');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyectos`
--

DROP TABLE IF EXISTS `proyectos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyectos` (
  `id_proyecto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) DEFAULT NULL,
  `empresa` varchar(20) DEFAULT NULL,
  `ciudad` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_proyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyectos`
--

LOCK TABLES `proyectos` WRITE;
/*!40000 ALTER TABLE `proyectos` DISABLE KEYS */;
INSERT INTO `proyectos` VALUES (1,'HIDROELECTRICA DEL SUR','ELECTRIX','CARTAGENA'),(2,'PUENTE COLGANTE','CONSTRUCTORCORP','GUAYAQUIL');
/*!40000 ALTER TABLE `proyectos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supervisores`
--

DROP TABLE IF EXISTS `supervisores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supervisores` (
  `id_supervisor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `salario` double DEFAULT NULL,
  `ciudad` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_supervisor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supervisores`
--

LOCK TABLES `supervisores` WRITE;
/*!40000 ALTER TABLE `supervisores` DISABLE KEYS */;
INSERT INTO `supervisores` VALUES (1,'JOSE ARTURO','REYES RAMIREZ',1000,'CARTAGENA'),(2,'MARIO ANDRES','LOPES SUAREZ',1300,'CARTAGENA'),(3,'SANDRA ESTEFANIA','MORA SANDOVAL',1200,'GUAYAQUIL');
/*!40000 ALTER TABLE `supervisores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-25 14:33:37
