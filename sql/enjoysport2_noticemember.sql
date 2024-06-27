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
-- Table structure for table `noticemember`
--

DROP TABLE IF EXISTS `noticemember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `noticemember` (
  `id` int NOT NULL AUTO_INCREMENT,
  `noticeId` varchar(45) DEFAULT NULL,
  `memberId` varchar(45) DEFAULT NULL,
  `clubId` varchar(45) DEFAULT NULL,
  `topic` text,
  `message` text,
  `publishDate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noticemember`
--

LOCK TABLES `noticemember` WRITE;
/*!40000 ALTER TABLE `noticemember` DISABLE KEYS */;
INSERT INTO `noticemember` VALUES (1,'nt00001','m00011','c00002','社團通知6','22這是社團通知測試~~~~~','2024-06-21 01:42:37'),(2,'nt00002','m00011','c00002','社團通知556','22這是社團通知測試~~~~~','2024-06-21 01:43:40'),(3,'nt00003','m00011','c00001','社團通知556','22這是社團通知測試~~~~~','2024-06-21 01:43:50'),(4,'nt00004','m00012','c00001','社團通知556','22這是社團通知測試~~~~~','2024-06-21 01:44:01'),(5,'nt00005','m00012','c00001','社團通知556','22這是社團通知測試~~~~~','2024-06-21 01:44:10'),(6,'nt00006','m00012','c00003','社團通知556','22這是社團通知測試~~~~~','2024-06-21 01:44:20'),(7,'nt00007','m00012','c00002','【學生運動參與情形調查】大專校院線上問卷填答系統維護公告','配合 SurveyCake 系統進行系統維護與升級作業，以下期間將會無法填答問卷，敬請協助配合。!!','2024-06-24 00:17:08'),(9,'nt00009','m00001','c00001','臺北市棒球隊113年度第2次球員遴選','推展基礎棒球運動，從下往上扎根，建立金字塔型培訓制度，以擴增國內甲組成棒隊數、提振臺北市棒球競技運動實力及培育優秀棒球人才進軍中華職棒及國家代表隊為目標，並為本市爭取佳績。','2024-06-24 00:26:14'),(10,'nt00010','m00001','c00001','我要看書~~~~~~~~~~~~~~~','我要看書~~~~~~~~~~~~~~~我要看書~~~~~~~~~~~~~~~\n我要看書~~~~~~~~~~~~~~~','2024-06-25 01:45:57');
/*!40000 ALTER TABLE `noticemember` ENABLE KEYS */;
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
