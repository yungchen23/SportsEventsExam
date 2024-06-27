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
-- Table structure for table `messageboard`
--

DROP TABLE IF EXISTS `messageboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `messageboard` (
  `id` int NOT NULL AUTO_INCREMENT,
  `msgId` varchar(45) DEFAULT NULL,
  `memberId` varchar(45) DEFAULT NULL,
  `clubId` varchar(45) DEFAULT NULL,
  `message` text,
  `publishDate` varchar(45) DEFAULT NULL,
  `updateDate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messageboard`
--

LOCK TABLES `messageboard` WRITE;
/*!40000 ALTER TABLE `messageboard` DISABLE KEYS */;
INSERT INTO `messageboard` VALUES (1,'msg00001','m00001','c00001','各位都有運動習慣嗎?','2024-06-19 08:00:00',NULL),(2,'msg00002','m00001','c00001','要瘦可以靠飲食控制','2024-06-19 08:00:00',NULL),(3,'msg00003','m00002','c00001','35年來堅持打籃球的大叔路過 , 近幾年每周打2~3小時的籃球 , 體能雖然變差了 , 但是固定的運動習慣 , 對於身體的健康 , 感覺還是很有幫助 , 多運動就是支持啦 !','2024-06-19 08:21:47',NULL),(4,'msg00004','m00002','c00001','我是直接在腳上各綁四公斤的沙袋... 反正一天都要走1W步起跳QQ','2024-06-19 08:41:46',NULL),(5,'msg00005','m00002','c00001',' 以前還覺得只有長輩才會去晨跑晨泳，現在才理解原來是因為我們這些小孩才不得不改時間 XD。','2024-06-19 08:43:12',NULL),(6,'msg00006','m00001','c00001','大家都是怎麼安排自己的生活呢','2024-06-23 23:37:57',NULL),(7,'msg00007','m00003','c00001','分享一下我自己的\n平常上班的話\n830起床後到711吃著早餐組合（冰拿鐵必須！）\n9:30後出發上班\n20:30回家吃晚餐配動畫瘋一小時後打遊戲or出門運動\n12:00or1:00洗洗睡\n\n休假\n因為我是在外生活\n基本上就是回家看看家人找找朋友\n順便休息準備下次上班的心態跟體力\n大家的又是如何呢？','2024-06-23 23:42:48',NULL),(8,'msg00008','m00001','c00001','早睡早起精神好!!\n作夢~~~~~','2024-06-25 01:42:03',NULL);
/*!40000 ALTER TABLE `messageboard` ENABLE KEYS */;
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
