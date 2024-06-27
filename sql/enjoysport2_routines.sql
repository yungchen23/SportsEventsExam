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
-- Temporary view structure for view `getclubofmember`
--

DROP TABLE IF EXISTS `getclubofmember`;
/*!50001 DROP VIEW IF EXISTS `getclubofmember`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `getclubofmember` AS SELECT 
 1 AS `ID`,
 1 AS `CLUBID`,
 1 AS `CLUBNAME`,
 1 AS `MAMBERNAME`,
 1 AS `TITLE`,
 1 AS `LEVEL`,
 1 AS `JOINTIME`,
 1 AS `UPDATETIME`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `mamgerbymemberinfo`
--

DROP TABLE IF EXISTS `mamgerbymemberinfo`;
/*!50001 DROP VIEW IF EXISTS `mamgerbymemberinfo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mamgerbymemberinfo` AS SELECT 
 1 AS `ID`,
 1 AS `姓名`,
 1 AS `帳號`,
 1 AS `性別`,
 1 AS `年齡`,
 1 AS `生日`,
 1 AS `電子信箱`,
 1 AS `電話`,
 1 AS `地區`,
 1 AS `所屬社團`,
 1 AS `狀態`,
 1 AS `創建時間`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `mangerbyclubinfo`
--

DROP TABLE IF EXISTS `mangerbyclubinfo`;
/*!50001 DROP VIEW IF EXISTS `mangerbyclubinfo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mangerbyclubinfo` AS SELECT 
 1 AS `ID`,
 1 AS `clubName`,
 1 AS `clubLeader`,
 1 AS `NumberofMembers`,
 1 AS `clubIntroduction`,
 1 AS `createDate`,
 1 AS `updateDate`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `mymsglist`
--

DROP TABLE IF EXISTS `mymsglist`;
/*!50001 DROP VIEW IF EXISTS `mymsglist`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mymsglist` AS SELECT 
 1 AS `ID`,
 1 AS `memberId`,
 1 AS `memberName`,
 1 AS `clubId`,
 1 AS `message`,
 1 AS `publishDate`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `joineventlistbyclubs`
--

DROP TABLE IF EXISTS `joineventlistbyclubs`;
/*!50001 DROP VIEW IF EXISTS `joineventlistbyclubs`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `joineventlistbyclubs` AS SELECT 
 1 AS `活動ID`,
 1 AS `活動名稱`,
 1 AS `社團名稱`,
 1 AS `報名狀態`,
 1 AS `報名時間`,
 1 AS `修改時間`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `mynoticelist`
--

DROP TABLE IF EXISTS `mynoticelist`;
/*!50001 DROP VIEW IF EXISTS `mynoticelist`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mynoticelist` AS SELECT 
 1 AS `index`,
 1 AS `author`,
 1 AS `topic`,
 1 AS `message`,
 1 AS `publishDate`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `mangerbyclubinfofull`
--

DROP TABLE IF EXISTS `mangerbyclubinfofull`;
/*!50001 DROP VIEW IF EXISTS `mangerbyclubinfofull`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mangerbyclubinfofull` AS SELECT 
 1 AS `Mid`,
 1 AS `name`,
 1 AS `account`,
 1 AS `gender`,
 1 AS `age`,
 1 AS `birthday`,
 1 AS `Email`,
 1 AS `phone`,
 1 AS `location`,
 1 AS `joinclub`,
 1 AS `status`,
 1 AS `createDate`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `getclubofmember`
--

/*!50001 DROP VIEW IF EXISTS `getclubofmember`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `getclubofmember` AS select `c`.`id` AS `ID`,`c`.`clubId` AS `CLUBID`,`c`.`clubName` AS `CLUBNAME`,`m`.`memberName` AS `MAMBERNAME`,(case when (`ms`.`isLeader` = true) then '團長' else '一般團員' end) AS `TITLE`,`ms`.`level` AS `LEVEL`,`ms`.`joinDate` AS `JOINTIME`,`ms`.`updateDate` AS `UPDATETIME` from ((`clubs` `c` join `memberstate` `ms` on((`c`.`clubId` = `ms`.`clubId`))) join `member` `m` on((`ms`.`memberId` = `m`.`memberId`))) order by `c`.`clubId`,`ms`.`joinDate` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mamgerbymemberinfo`
--

/*!50001 DROP VIEW IF EXISTS `mamgerbymemberinfo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mamgerbymemberinfo` AS select `m`.`memberId` AS `ID`,`m`.`memberName` AS `姓名`,`m`.`memberAccount` AS `帳號`,`m`.`memberGender` AS `性別`,`m`.`memberAge` AS `年齡`,`m`.`memberBirthday` AS `生日`,`m`.`memberEmail` AS `電子信箱`,`m`.`memberPhone` AS `電話`,`m`.`memberLocation` AS `地區`,group_concat(`c`.`clubName` separator ', ') AS `所屬社團`,(case when (`m`.`status` = true) then '開放' else '封鎖' end) AS `狀態`,`m`.`createDate` AS `創建時間` from ((`member` `m` left join `memberstate` `ms` on((`m`.`memberId` = `ms`.`memberId`))) left join `clubs` `c` on((`ms`.`clubId` = `c`.`clubId`))) group by `m`.`id`,`m`.`memberName`,`m`.`memberAccount`,`m`.`memberGender`,`m`.`memberAge`,`m`.`memberBirthday`,`m`.`memberEmail`,`m`.`memberPhone`,`m`.`memberLocation`,`m`.`status`,`m`.`createDate` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mangerbyclubinfo`
--

/*!50001 DROP VIEW IF EXISTS `mangerbyclubinfo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mangerbyclubinfo` AS select `c`.`clubId` AS `ID`,`c`.`clubName` AS `clubName`,`m`.`memberName` AS `clubLeader`,count(`ms`.`memberId`) AS `NumberofMembers`,`c`.`clubIntroduction` AS `clubIntroduction`,`c`.`createDate` AS `createDate`,`c`.`updateDate` AS `updateDate` from ((`clubs` `c` left join `memberstate` `ms` on((`c`.`clubId` = `ms`.`clubId`))) left join `member` `m` on((`c`.`clubLeaderId` = `m`.`memberId`))) group by `c`.`id`,`c`.`clubName`,`m`.`memberName`,`c`.`createDate`,`c`.`updateDate` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mymsglist`
--

/*!50001 DROP VIEW IF EXISTS `mymsglist`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mymsglist` AS select `mb`.`id` AS `ID`,`mb`.`memberId` AS `memberId`,`m`.`memberName` AS `memberName`,`mb`.`clubId` AS `clubId`,`mb`.`message` AS `message`,`mb`.`publishDate` AS `publishDate` from (`messageboard` `mb` left join `member` `m` on((`mb`.`memberId` = `m`.`memberId`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `joineventlistbyclubs`
--

/*!50001 DROP VIEW IF EXISTS `joineventlistbyclubs`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `joineventlistbyclubs` AS select `e`.`eventId` AS `活動ID`,`e`.`eventTitle` AS `活動名稱`,`c`.`clubName` AS `社團名稱`,(case when (`ec`.`joinStatus` = 'True') then '已報名' else NULL end) AS `報名狀態`,`ec`.`joinDate` AS `報名時間`,`ec`.`updateDate` AS `修改時間` from ((`events` `e` join `eventclub` `ec` on((`e`.`eventId` = `ec`.`eventId`))) join `clubs` `c` on((`ec`.`clubId` = `c`.`clubId`))) where (`ec`.`joinStatus` = 'True') order by `e`.`eventId`,`ec`.`joinDate` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mynoticelist`
--

/*!50001 DROP VIEW IF EXISTS `mynoticelist`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mynoticelist` AS select row_number() OVER (ORDER BY `nm`.`publishDate` )  AS `index`,`c`.`clubName` AS `author`,`nm`.`topic` AS `topic`,`nm`.`message` AS `message`,`nm`.`publishDate` AS `publishDate` from (`noticemember` `nm` join `clubs` `c` on((`nm`.`clubId` = `c`.`clubId`))) order by `nm`.`publishDate` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mangerbyclubinfofull`
--

/*!50001 DROP VIEW IF EXISTS `mangerbyclubinfofull`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mangerbyclubinfofull` AS select `m`.`memberId` AS `Mid`,`m`.`memberName` AS `name`,`m`.`memberAccount` AS `account`,`m`.`memberGender` AS `gender`,`m`.`memberAge` AS `age`,`m`.`memberBirthday` AS `birthday`,`m`.`memberEmail` AS `Email`,`m`.`memberPhone` AS `phone`,`m`.`memberLocation` AS `location`,group_concat(`c`.`clubName` separator ', ') AS `joinclub`,(case when (`m`.`status` = true) then '開放' else '封鎖' end) AS `status`,`m`.`createDate` AS `createDate` from ((`member` `m` left join `memberstate` `ms` on((`m`.`memberId` = `ms`.`memberId`))) left join `clubs` `c` on((`ms`.`clubId` = `c`.`clubId`))) group by `m`.`id`,`m`.`memberName`,`m`.`memberAccount`,`m`.`memberGender`,`m`.`memberAge`,`m`.`memberBirthday`,`m`.`memberEmail`,`m`.`memberPhone`,`m`.`memberLocation`,`m`.`status`,`m`.`createDate` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-26 12:41:21
