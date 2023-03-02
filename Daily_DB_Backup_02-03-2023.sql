-- MariaDB dump 10.19  Distrib 10.4.27-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: etablissementpublic
-- ------------------------------------------------------
-- Server version	10.4.27-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `detail_salaire`
--

DROP TABLE IF EXISTS `detail_salaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detail_salaire` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `prime_generale` double DEFAULT NULL,
  `prime_responsabilite` double DEFAULT NULL,
  `salaire_base` double DEFAULT NULL,
  `employe` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlen9sfqrejjcc7ny610rrmhh8` (`employe`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_salaire`
--

LOCK TABLES `detail_salaire` WRITE;
/*!40000 ALTER TABLE `detail_salaire` DISABLE KEYS */;
INSERT INTO `detail_salaire` VALUES (1,'ABC123','2023-02-26',1000.5,250.25,5000,NULL),(2,'DEF789','2023-03-15',1200.75,300.25,5500,NULL),(3,'GHI123','2023-04-01',800.5,200.25,4000,NULL);
/*!40000 ALTER TABLE `detail_salaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_salaire_seq`
--

DROP TABLE IF EXISTS `detail_salaire_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detail_salaire_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_salaire_seq`
--

LOCK TABLES `detail_salaire_seq` WRITE;
/*!40000 ALTER TABLE `detail_salaire_seq` DISABLE KEYS */;
INSERT INTO `detail_salaire_seq` VALUES (1);
/*!40000 ALTER TABLE `detail_salaire_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `echelle`
--

DROP TABLE IF EXISTS `echelle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `echelle` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `grade` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK83eqyo2gk14py9yki3b66nfcm` (`grade`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `echelle`
--

LOCK TABLES `echelle` WRITE;
/*!40000 ALTER TABLE `echelle` DISABLE KEYS */;
INSERT INTO `echelle` VALUES (1,'ABC','Sample Text',NULL),(2,'hope','King cookies',NULL);
/*!40000 ALTER TABLE `echelle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `echelle_seq`
--

DROP TABLE IF EXISTS `echelle_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `echelle_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `echelle_seq`
--

LOCK TABLES `echelle_seq` WRITE;
/*!40000 ALTER TABLE `echelle_seq` DISABLE KEYS */;
INSERT INTO `echelle_seq` VALUES (1);
/*!40000 ALTER TABLE `echelle_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `echellon`
--

DROP TABLE IF EXISTS `echellon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `echellon` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `delai` bigint(20) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `echelle` bigint(20) DEFAULT NULL,
  `echellon_precedant` bigint(20) DEFAULT NULL,
  `echellon_suivant` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnacsf0s1ywdcyo2i3gbvbahop` (`echelle`),
  KEY `FKqct2fex9gbby0dxfirsv5y79u` (`echellon_precedant`),
  KEY `FKn4dh28imhhdbtq90oilghmwd` (`echellon_suivant`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `echellon`
--

LOCK TABLES `echellon` WRITE;
/*!40000 ALTER TABLE `echellon` DISABLE KEYS */;
INSERT INTO `echellon` VALUES (1,'ABC',30,'echellon1',1000,NULL,NULL,2),(2,'EFG',20,'echellon2',1000,NULL,1,3),(3,'xyz',10,'echellon3',500,NULL,2,4),(4,'hjk',10,'echellon4',250,NULL,3,5);
/*!40000 ALTER TABLE `echellon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `echellon_seq`
--

DROP TABLE IF EXISTS `echellon_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `echellon_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `echellon_seq`
--

LOCK TABLES `echellon_seq` WRITE;
/*!40000 ALTER TABLE `echellon_seq` DISABLE KEYS */;
INSERT INTO `echellon_seq` VALUES (1);
/*!40000 ALTER TABLE `echellon_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employe`
--

DROP TABLE IF EXISTS `employe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employe` (
  `id` bigint(20) NOT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `nombre_mois` bigint(20) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `salaire_de_base` double DEFAULT NULL,
  `echellon` bigint(20) DEFAULT NULL,
  `entite_administratif` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6tbb526jwkctwrdt1ky8wu3oj` (`echellon`),
  KEY `FKn8jh8ytit5p02bfxe1gtxer08` (`entite_administratif`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employe`
--

LOCK TABLES `employe` WRITE;
/*!40000 ALTER TABLE `employe` DISABLE KEYS */;
INSERT INTO `employe` VALUES (1,'C1','Doe',12,'John',3000,NULL,NULL),(2,'C2','Smith',10,'Jane',2500,2,4),(3,'C3','Garcia',6,'Carlos',2000,3,3),(4,'C4','Kim',8,'Jin',2750,4,1),(5,'C5','Singh',12,'Amar',3500,5,2);
/*!40000 ALTER TABLE `employe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employe_seq`
--

DROP TABLE IF EXISTS `employe_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employe_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employe_seq`
--

LOCK TABLES `employe_seq` WRITE;
/*!40000 ALTER TABLE `employe_seq` DISABLE KEYS */;
INSERT INTO `employe_seq` VALUES (1);
/*!40000 ALTER TABLE `employe_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entite_administratif`
--

DROP TABLE IF EXISTS `entite_administratif`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entite_administratif` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `chef_entite` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj8uiuyhtt477hhdxekuhxyhuy` (`chef_entite`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entite_administratif`
--

LOCK TABLES `entite_administratif` WRITE;
/*!40000 ALTER TABLE `entite_administratif` DISABLE KEYS */;
INSERT INTO `entite_administratif` VALUES (1,'ENT001','Entité 1',1),(2,NULL,'Entité 2',2),(3,'ENT003','Entité 3',3);
/*!40000 ALTER TABLE `entite_administratif` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entite_administratif_seq`
--

DROP TABLE IF EXISTS `entite_administratif_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entite_administratif_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entite_administratif_seq`
--

LOCK TABLES `entite_administratif_seq` WRITE;
/*!40000 ALTER TABLE `entite_administratif_seq` DISABLE KEYS */;
INSERT INTO `entite_administratif_seq` VALUES (1);
/*!40000 ALTER TABLE `entite_administratif_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grade` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (1,'ABC','BookEli'),(2,'OCP','tiktak');
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade_seq`
--

DROP TABLE IF EXISTS `grade_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grade_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade_seq`
--

LOCK TABLES `grade_seq` WRITE;
/*!40000 ALTER TABLE `grade_seq` DISABLE KEYS */;
INSERT INTO `grade_seq` VALUES (1);
/*!40000 ALTER TABLE `grade_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mandat`
--

DROP TABLE IF EXISTS `mandat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mandat` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `date_debut` datetime DEFAULT NULL,
  `date_fin` datetime DEFAULT NULL,
  `prime` double DEFAULT NULL,
  `employe` bigint(20) DEFAULT NULL,
  `responsabilite` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK54ldkkv39gwd3b12r8kp9t9rc` (`employe`),
  KEY `FKf746xabyw5q5nuvwuuai30k4j` (`responsabilite`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mandat`
--

LOCK TABLES `mandat` WRITE;
/*!40000 ALTER TABLE `mandat` DISABLE KEYS */;
INSERT INTO `mandat` VALUES (1,'ABC123','2022-01-01 00:00:00','2022-12-31 23:59:59',1000,NULL,2);
/*!40000 ALTER TABLE `mandat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mandat_seq`
--

DROP TABLE IF EXISTS `mandat_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mandat_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mandat_seq`
--

LOCK TABLES `mandat_seq` WRITE;
/*!40000 ALTER TABLE `mandat_seq` DISABLE KEYS */;
INSERT INTO `mandat_seq` VALUES (1);
/*!40000 ALTER TABLE `mandat_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsabilite`
--

DROP TABLE IF EXISTS `responsabilite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `responsabilite` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `prime` double DEFAULT NULL,
  `echellon_min` bigint(20) DEFAULT NULL,
  `employe` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK76m5mf76k3v0c10rdo7j08exk` (`echellon_min`),
  KEY `FKpwy0ui0trbeyqxgj8vm6f5a9h` (`employe`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsabilite`
--

LOCK TABLES `responsabilite` WRITE;
/*!40000 ALTER TABLE `responsabilite` DISABLE KEYS */;
INSERT INTO `responsabilite` VALUES (1,'E1','Doyen',5000,NULL,NULL),(2,'E2','Auditeur',2400,NULL,NULL),(3,'E3','Expert-comptable',1500,NULL,NULL),(4,'E4','Chef de département',1500,NULL,NULL),(5,'E5','Chef de service',1000,NULL,NULL),(6,'E6','Responsable RH',2000,NULL,NULL),(7,'E7','Responsable commercial',2500,NULL,NULL),(8,'E8','Chef de projet',3000,NULL,NULL),(9,'E9','Ingénieur',3500,NULL,NULL),(10,'E10','Consultant',4000,NULL,NULL),(11,'E11','Responsable Info',3300,3,NULL),(12,'E12','Responsable Math',4000,4,NULL),(13,'E13','Responsable Bio',1500,3,NULL);
/*!40000 ALTER TABLE `responsabilite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsabilite_seq`
--

DROP TABLE IF EXISTS `responsabilite_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `responsabilite_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsabilite_seq`
--

LOCK TABLES `responsabilite_seq` WRITE;
/*!40000 ALTER TABLE `responsabilite_seq` DISABLE KEYS */;
INSERT INTO `responsabilite_seq` VALUES (1);
/*!40000 ALTER TABLE `responsabilite_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-02  9:05:00
