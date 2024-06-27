CREATE DATABASE  IF NOT EXISTS `enjoysport2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `enjoysport2`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: enjoysport2
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `clubs`
--

DROP TABLE IF EXISTS `clubs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clubs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `clubId` varchar(45) DEFAULT NULL,
  `clubName` varchar(45) DEFAULT NULL,
  `clubLeaderId` varchar(45) DEFAULT NULL,
  `clubIntroduction` text,
  `clubBillboard` text,
  `clubUrl` varchar(45) DEFAULT NULL,
  `createDate` varchar(45) DEFAULT NULL,
  `updateDate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clubs`
--

LOCK TABLES `clubs` WRITE;
/*!40000 ALTER TABLE `clubs` DISABLE KEYS */;
INSERT INTO `clubs` VALUES (1,'c00001','天龍國第一幫','m00001',NULL,'11天真活潑善良可愛又美麗11aaa','https://blueshoes.tw','2024-06-17 21:37:53','2024-06-25 01:42:20'),(2,'c00002','高雄天龍國','m00002',NULL,NULL,'https://blueshoes.tw/','2024-06-17 21:38:59','2024-06-18 08:36:30'),(3,'c00003','宇宙邦邦忙','m00003','社團介紹~~~~~~~~~~!!',NULL,'https://blueshoes.tw/','2024-06-17 21:41:17','2024-06-18 00:10:09'),(5,'c00005','宇宙邦','m00005',NULL,NULL,NULL,'2024-06-17 23:40:09','2024-06-18 01:20:00'),(7,'c00007','無敵艦隊','m00006','戰力滿點加入',NULL,NULL,'2024-06-18 00:51:04','2024-06-18 08:35:07'),(8,'c00008','宇宙邦4',NULL,NULL,NULL,NULL,'2024-06-21 20:32:37',NULL),(9,'c00009','天龍國','m00018','天龍國第一幫，絕無分店!!!',NULL,NULL,'2024-06-23 16:12:44',NULL),(10,'c00010','天龍國111','m00019','滿城盡是天龍人!!!',NULL,NULL,'2024-06-23 18:34:00',NULL),(11,'c00011','天龍國888','m00020','',NULL,NULL,'2024-06-23 19:44:55',NULL),(21,'c00012','zzzzz','m00021','z',NULL,NULL,'2024-06-23 22:39:22',NULL),(23,'c00022','SS','m00023','六星卡',NULL,NULL,'2024-06-23 22:47:40',NULL),(24,'c00024','改壞了','m00024','改壞了改壞了改壞了改壞了改壞了',NULL,NULL,'2024-06-24 22:46:22',NULL);
/*!40000 ALTER TABLE `clubs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-26 12:41:20
