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
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `events` (
  `id` int NOT NULL AUTO_INCREMENT,
  `eventId` varchar(45) DEFAULT NULL,
  `eventTitle` varchar(45) DEFAULT NULL,
  `eventDescription` text,
  `eventStartDate` varchar(45) DEFAULT NULL,
  `eventEndDate` varchar(45) DEFAULT NULL,
  `eventIsPublish` tinyint(1) DEFAULT NULL,
  `createDate` varchar(45) DEFAULT NULL,
  `updateDate` varchar(45) DEFAULT NULL,
  `eventImg` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (1,'ec0001','月光光心慌慌線上路跑','賽事通通取消沒賽事參加嗎?  害怕人群聚集感染影響健康嗎？  我們知道各位的跑者魂並沒有熄滅! 特別規劃了月光路跑賽事回顧線上跑，讓之前沒有參與到的，或是訓練周全無處發揮的您，參加線上跑也能獨自體驗參加賽事的港覺 無論何時何地只要上傳軌跡圖即可獲得精美完賽禮','2023-06-01','2023-12-31',0,'2024-06-20 00:00:00',NULL,'/controller/img/banner_000.png'),(2,'e00002','2024石門水庫櫻花路跑 線上跑','每年春季，石門水庫的櫻花盛放，形成了絢麗的櫻花花海，吸引著人群前來欣賞這壯麗的景色~\\n\\n而這個活動將帶你進入這個花季中，讓你在花瓣雨中奔跑，每一步都伴隨著花瓣飄散的浪漫，奔跑的同時也能融入大自然的美麗中。','2024-08-01','2024-08-31',1,'2024-06-24 01:40:17',NULL,'/controller/img/banner_003.png'),(3,'e00003','SNOOPY PICNIC『愛要及時．史命必達』愛心認購活動','2024年4月3日，台灣花蓮發生芮氏規模7.2級大地震，造成當地許多大樓倒塌，許多房舍結構亮紅燈，截至5月8日已經有18人，近千人無家可歸，大小餘震不斷，災情一直延續。全台灣不管是私人還是企業都自發做出捐贈或是支援的活動，就連與我國友好的日本也加入其中，身在台灣的我們更一定要參與！《PEANUTS》一直是個有溫度的品牌，從作者筆下的角色日常就可以看出這點。近年來，品牌一直致力在推廣「Take Care」的主題，希望透過粉絲的力量不僅關懷身邊的親朋好友，有餘力還能再關懷那些需要幫助的人們，這次他想邀請台灣民眾與我們一起做公益，我們這次公益的主要對象是花蓮地震受災的人們，我們邀請全台灣民眾，一起透過認購野餐組捐款的方式做公益，我們將此活動的10%營收捐贈給財團法人基督教芥菜種會，由他們將把捐款用於此次花蓮賑災中。台安藥局更是加碼提供參與公益活動民眾，500元台安藥局優惠券。','2024-08-01','2024-08-31',1,'2024-06-24 01:41:39',NULL,'/controller/img/banner_002.png'),(4,'e00004','2024阿里山雲端馬拉松','錯過了因地震而退賽的跑友們，請注意！2024阿里山雲端馬拉松線上跑已上線，就算你現在不在賽場上，也能在你喜歡的地方參與這場熱血的賽事！不僅能挑戰自己，還能收到豐富的完賽禮和精美獎牌！','2024-02-01','2024-03-31',0,'2024-06-24 01:43:37','2024-06-24 23:29:51','/controller/img/banner_004.png'),(5,'e00005','2024蘭陽百K自行車挑戰賽','探索自行車之美！蘭陽百K自行車賽，結合人文風情與絕美地形，讓您一次滿足！','2024-07-01','2024-09-08',1,'2024-06-24 23:29:51',NULL,'/controller/img/banner_001.png'),(6,'e00006','2023武界奧萬大自行車挑戰賽 20公里線上騎','你是不是很惋惜武界奧萬大挑戰賽錯過了，沒關係，抓住這次機會，是該動起來了，不管你在家騎，或夜深人靜時出門騎，緊繃的生活壓力下給自己一點喘息的空間活動咖邀你一起線上騎，保持運動習慣，健康身體增加免疫力，期待再戰下一場優質賽事~~','2024-07-01','2024-12-31',1,'2024-06-24 01:40:17',NULL,'/controller/img/banner_005.png'),(7,'e00007','2024嘉義瘋單車系列活動~浪漫花旗木單車遊','賞花悠閒，與家人同樂：沿著特製的單車路線，輕鬆騎行於嘉義縣市的花旗木花區，品味春天的清新氛圍。每一朵花旗木花朵都是家庭歡笑的背景，讓您與親人共同創造美好時刻。文化探索，增添親子樂趣：除了花旗木的繽紛，我們將帶您走入質樸的農村秘徑，讓您與家人一同體驗當地的文化魅力。活動中融入豐富的文化元素，為您和家人提供更多共學的樂趣。綠色出行，環保愉悅：我們倡導環保出行，以單車遊覽嘉義的鄉村小徑，共同守護這片美麗的自然環境。這是一場讓家人一同參與的綠意之旅，享受環保且愉悅的騎行樂趣。家庭時光，春天的美好回憶：2024浪漫花旗木單車家庭遊是一次家庭共度的美好時光。透過單車、花朵和美麗風景，讓您和家人在春天留下難忘的回憶，一同分享愉快的家庭時光。','2024-01-01','2024-04-13',0,'2024-03-24 01:40:17',NULL,'/controller/img/banner_006.png');
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
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
