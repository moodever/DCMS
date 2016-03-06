CREATE DATABASE  IF NOT EXISTS `dcms_core` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dcms_core`;
-- MySQL dump 10.13  Distrib 5.6.17, for osx10.6 (i386)
--
-- Host: 128.135.11.198    Database: dcms_core
-- ------------------------------------------------------
-- Server version	5.5.47-0ubuntu0.14.04.1-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dcms_child`
--

DROP TABLE IF EXISTS `dcms_child`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dcms_child` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `affliation` int(2) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `slibling_id` int(10) DEFAULT NULL,
  `active_enrollment` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dcms_child_active_enrollment` (`active_enrollment`),
  CONSTRAINT `FK_dcms_child_active_enrollment` FOREIGN KEY (`active_enrollment`) REFERENCES `dcms_enrollment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dcms_child`
--

LOCK TABLES `dcms_child` WRITE;
/*!40000 ALTER TABLE `dcms_child` DISABLE KEYS */;
INSERT INTO `dcms_child` VALUES (1,2,'2014-06-17','Claire','Jiang','Ling','NA','3152881001',0,7),(2,0,'2014-01-07','Yang','Hong','','NA','3152881002',0,8),(3,1,'2013-03-11','Helen','Zhu','Yu','NA','3152881003',0,NULL),(4,0,'2014-03-10','Nick','Su','Jo','NA','3152881004',0,NULL),(5,2,'2013-03-19','Jack','Ma','','NA','3152881005',0,NULL),(6,1,'2012-06-17','Harper','Jiang','','NA','3152881006',0,10),(7,1,'2015-03-02','Ben','Linch','','NA','3152881007',0,6),(9,1,'2012-01-01','Mike','Wong','H',NULL,NULL,0,NULL),(10,2,'2011-02-01','July','Lin','',NULL,NULL,0,NULL),(11,1,'2011-09-01','Benjamin','Dong','','Good Kids',NULL,0,NULL),(12,2,'2010-10-08','Pink','Man','S','Kids is bad',NULL,0,NULL),(13,1,'2012-11-20','William','White','M','Kids is smart','315112233',0,NULL);
/*!40000 ALTER TABLE `dcms_child` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dcms_child_contact`
--

DROP TABLE IF EXISTS `dcms_child_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dcms_child_contact` (
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `phone1` varchar(255) DEFAULT NULL,
  `phone2` varchar(255) DEFAULT NULL,
  `role` varchar(30) NOT NULL DEFAULT '',
  `status` varchar(30) DEFAULT NULL,
  `child_id` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`child_id`,`role`),
  CONSTRAINT `FK_dcms_child_contact_child_id` FOREIGN KEY (`child_id`) REFERENCES `dcms_child` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dcms_child_contact`
--

LOCK TABLES `dcms_child_contact` WRITE;
/*!40000 ALTER TABLE `dcms_child_contact` DISABLE KEYS */;
INSERT INTO `dcms_child_contact` VALUES ('101 Swan St. Potsdam, NY','pure.young@gmail.com','Cathy','Yang',NULL,NULL,'3152627732','3152627732','Mother',NULL,1),('109 Leroy ST,Potsdam','Chris@gmail.com','Chris','Wong',NULL,NULL,'3152627732','315-999-8897','Dad',NULL,9),('108 Leroy ST, Potsdam','Tina@gmail.com','Tina','Wong',NULL,NULL,NULL,'315-888-7788','Mom',NULL,9),('209 Leroy ST,Potsdam','bob@gmail.com','Bob','Lin',NULL,NULL,NULL,'3152333457','Dad',NULL,10),('208 Leroy ST,Potsdam','mary@gmail.com','Mary','Lin',NULL,NULL,NULL,'3152333457','Mom',NULL,10),('102 main St','bike@gmail.com','Bike','Dong',NULL,NULL,'3152627732','','Dad','2',11),('101 main ST','sisy@gmail.com','Sisy','Dong','MI','Contact Notes','3152627732','','Mom','1',11),('stone ST','d@gm.com','Brown','Man',NULL,NULL,'333556666','','Dad','0',12),('water ST','p@q.com','Purple','Woman',NULL,NULL,'333445555','','Mom','1',12),('main St','jace1@gmail.com','Jack','White',NULL,NULL,'315-11-2345','315-99-8089','Dad','2',13),('main ST','Apple@gmail.com','Apple','White',NULL,NULL,'315778888','315-22-5538','Mom','1',13);
/*!40000 ALTER TABLE `dcms_child_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dcms_classroom`
--

DROP TABLE IF EXISTS `dcms_classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dcms_classroom` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `capacity` int(5) DEFAULT NULL,
  `grade` int(2) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `student_num` int(5) DEFAULT NULL,
  `age_to` int(5) DEFAULT NULL,
  `age_from` int(5) DEFAULT NULL,
  `term` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dcms_classroom`
--

LOCK TABLES `dcms_classroom` WRITE;
/*!40000 ALTER TABLE `dcms_classroom` DISABLE KEYS */;
INSERT INTO `dcms_classroom` VALUES (1,8,1,'Toddler1',5,53,104,'fall15'),(2,10,1,'Toddler2',5,105,156,'fall15'),(4,14,3,'Preschool3',5,157,208,'fall15'),(5,16,3,'Preschool4',5,209,260,'fall15'),(6,16,4,'Kindergarden',5,261,365,'fall15'),(8,20,5,'School Age',5,366,999,'fall15'),(9,10,2,'Progressive Room',5,120,180,'fall15'),(10,8,0,'Infant',8,6,52,'fall15'),(11,8,1,'Toddler1',7,53,104,'spring15'),(12,10,1,'Toddler2',7,105,156,'spring15'),(14,14,3,'Preschool3',7,157,208,'spring15'),(15,16,3,'Preschool4',5,209,260,'spring15'),(16,16,4,'Kindergarden',5,261,365,'spring15'),(18,20,5,'School Age',5,366,999,'spring15'),(19,10,2,'Progressive Room',6,120,180,'spring15'),(20,8,0,'Infant',12,6,52,'spring15'),(21,8,0,'Infant',10,6,52,'spring16'),(22,14,3,'Preschool3',5,157,208,'spring16'),(23,16,3,'Preschool4',5,209,260,'spring16'),(24,20,5,'School Age',5,366,999,'spring16'),(25,8,1,'Toddler1',5,53,104,'spring16'),(26,10,1,'Toddler2',5,105,156,'spring16'),(27,10,2,'Progressive Room',5,120,180,'spring16'),(28,16,4,'Kindergarden',5,261,365,'spring16'),(69,14,3,'Preschool3',5,157,208,'spring18'),(70,20,5,'School Age',5,366,999,'spring18'),(71,8,0,'Infant',10,6,52,'spring18'),(72,16,4,'Kindergarden',5,261,365,'spring18'),(73,8,1,'Toddler1',5,53,104,'spring18'),(74,10,1,'Toddler2',5,105,156,'spring18'),(75,16,3,'Preschool4',5,209,260,'spring18'),(76,10,2,'Progressive Room',5,120,180,'spring18'),(77,14,3,'Preschool3',5,157,208,'fall18'),(78,10,2,'Progressive Room',5,120,180,'fall18'),(79,16,3,'Preschool4',5,209,260,'fall18'),(80,20,5,'School Age',5,366,999,'fall18'),(81,10,1,'Toddler2',5,105,156,'fall18'),(82,8,1,'Toddler1',5,53,104,'fall18'),(83,16,4,'Kindergarden',5,261,365,'fall18'),(84,8,0,'Infant',10,6,52,'fall18'),(85,20,5,'School Age',5,366,999,'spring17'),(86,8,1,'Toddler1',5,53,104,'spring17'),(87,16,3,'Preschool4',5,209,260,'spring17'),(88,16,4,'Kindergarden',5,261,365,'spring17'),(89,14,3,'Preschool3',5,157,208,'spring17'),(90,10,2,'Progressive Room',5,120,180,'spring17'),(91,8,0,'Infant',10,6,52,'spring17'),(92,10,1,'Toddler2',5,105,156,'spring17'),(93,16,4,'Kindergarden',5,261,365,'fall17'),(94,8,0,'Infant',10,6,52,'fall17'),(95,8,1,'Toddler1',5,53,104,'fall17'),(96,16,3,'Preschool4',5,209,260,'fall17'),(97,10,2,'Progressive Room',5,120,180,'fall17'),(98,14,3,'Preschool3',5,157,208,'fall17'),(99,20,5,'School Age',5,366,999,'fall17'),(100,10,1,'Toddler2',5,105,156,'fall17'),(101,8,1,'Toddler1',5,53,104,'spring11'),(102,16,3,'Preschool4',5,209,260,'spring11'),(103,20,5,'School Age',5,366,999,'spring11'),(104,10,2,'Progressive Room',5,120,180,'spring11'),(105,14,3,'Preschool3',5,157,208,'spring11'),(106,16,4,'Kindergarden',5,261,365,'spring11'),(107,8,0,'Infant',10,6,52,'spring11'),(108,10,1,'Toddler2',5,105,156,'spring11'),(109,16,4,'Kindergarden',5,261,365,'fall11'),(110,8,0,'Infant',10,6,52,'fall11'),(111,8,1,'Toddler1',5,53,104,'fall11'),(112,16,3,'Preschool4',5,209,260,'fall11'),(113,20,5,'School Age',5,366,999,'fall11'),(114,10,2,'Progressive Room',5,120,180,'fall11'),(115,14,3,'Preschool3',5,157,208,'fall11'),(116,10,1,'Toddler2',5,105,156,'fall11'),(117,8,1,'Toddler1',5,53,104,'spring12'),(118,20,5,'School Age',5,366,999,'spring12'),(119,8,0,'Infant',12,6,52,'spring12'),(120,10,2,'Progressive Room',5,120,180,'spring12'),(121,10,1,'Toddler2',5,105,156,'spring12'),(122,16,4,'Kindergarden',5,261,365,'spring12'),(123,14,3,'Preschool3',5,157,208,'spring12'),(124,16,3,'Preschool4',5,209,260,'spring12'),(125,8,1,'Toddler1',7,53,104,'spring20'),(126,16,4,'Kindergarden',5,261,365,'spring20'),(127,14,3,'Preschool3',7,157,208,'spring20'),(128,20,5,'School Age',5,366,999,'spring20'),(129,10,1,'Toddler2',7,105,156,'spring20'),(130,16,3,'Preschool4',5,209,260,'spring20'),(131,8,0,'Infant',12,6,52,'spring20'),(132,10,2,'Progressive Room',5,120,180,'spring20');
/*!40000 ALTER TABLE `dcms_classroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dcms_classroom_teacher`
--

DROP TABLE IF EXISTS `dcms_classroom_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dcms_classroom_teacher` (
  `teacher_id` int(10) NOT NULL,
  `classroom_id` int(10) NOT NULL,
  PRIMARY KEY (`teacher_id`,`classroom_id`),
  KEY `FK_dcms_classroom_teacher_classroom_id` (`classroom_id`),
  CONSTRAINT `FK_dcms_classroom_teacher_classroom_id` FOREIGN KEY (`classroom_id`) REFERENCES `dcms_classroom` (`id`),
  CONSTRAINT `FK_dcms_classroom_teacher_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `dcms_teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dcms_classroom_teacher`
--

LOCK TABLES `dcms_classroom_teacher` WRITE;
/*!40000 ALTER TABLE `dcms_classroom_teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `dcms_classroom_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dcms_enrollment`
--

DROP TABLE IF EXISTS `dcms_enrollment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dcms_enrollment` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `accept_date` date DEFAULT NULL,
  `attending_mode` varchar(50) DEFAULT NULL,
  `contract_from_date` date DEFAULT NULL,
  `contract_to_date` date DEFAULT NULL,
  `contract_from` date DEFAULT NULL,
  `STATUS` varchar(20) DEFAULT NULL,
  `TERM` varchar(50) DEFAULT NULL,
  `fri_time` varchar(255) DEFAULT NULL,
  `mon_time` varchar(255) DEFAULT NULL,
  `thu_time` varchar(255) DEFAULT NULL,
  `tue_time` varchar(255) DEFAULT NULL,
  `wed_time` varchar(255) DEFAULT NULL,
  `child_id` int(10) DEFAULT NULL,
  `classroom_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dcms_enrollment_classroom_id` (`classroom_id`),
  KEY `FK_dcms_enrollment_child_id` (`child_id`),
  CONSTRAINT `FK_dcms_enrollment_child_id` FOREIGN KEY (`child_id`) REFERENCES `dcms_child` (`id`),
  CONSTRAINT `FK_dcms_enrollment_classroom_id` FOREIGN KEY (`classroom_id`) REFERENCES `dcms_classroom` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dcms_enrollment`
--

LOCK TABLES `dcms_enrollment` WRITE;
/*!40000 ALTER TABLE `dcms_enrollment` DISABLE KEYS */;
INSERT INTO `dcms_enrollment` VALUES (2,'2015-03-18','WEEKDAY','2015-03-31',NULL,NULL,'INVALID',NULL,'9-10','9-10','9-10','9-10','9-10',2,10),(3,'2015-03-21','MON_WED_FRI','2015-03-20',NULL,NULL,'INVALID',NULL,'1-3','1-3','','','1-3',3,10),(6,'2015-03-22','WEEKDAY','2015-03-21',NULL,NULL,'EFFECTIVE',NULL,'9:00 - 15:00','9:00 - 15:00','9:00 - 15:00','9:00 - 15:00','9:00 - 15:00',7,20),(7,'2015-01-01','WEEKDAY','2015-01-10',NULL,NULL,'EFFECTIVE',NULL,'7:30-13:30','7:30-13:30','9:00-15:00','9:00-15:00','7:30-13:30',1,20),(8,'2015-01-01','MON_WED_FRI','2015-03-30',NULL,NULL,'EFFECTIVE',NULL,'10:00-16:00','10:00-16:00','','','10:00-16:00',2,11),(9,'2015-03-01','TUE_THU','2015-01-03',NULL,NULL,'INVALID',NULL,'','','11:00-17:00','11:00-17:00','',3,12),(10,'2015-03-03','MON_WED_FRI','2015-03-01',NULL,NULL,'EFFECTIVE',NULL,'9:00-15:00','9:00-15:00','','','9:00-15:00',6,14);
/*!40000 ALTER TABLE `dcms_enrollment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dcms_event_log`
--

DROP TABLE IF EXISTS `dcms_event_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dcms_event_log` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `event` varchar(255) DEFAULT NULL,
  `event_date` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `child_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dcms_event_log_child_id` (`child_id`),
  CONSTRAINT `FK_dcms_event_log_child_id` FOREIGN KEY (`child_id`) REFERENCES `dcms_child` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dcms_event_log`
--

LOCK TABLES `dcms_event_log` WRITE;
/*!40000 ALTER TABLE `dcms_event_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `dcms_event_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dcms_teacher`
--

DROP TABLE IF EXISTS `dcms_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dcms_teacher` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `fri_time` varchar(255) DEFAULT NULL,
  `mon_time` varchar(255) DEFAULT NULL,
  `thu_time` varchar(255) DEFAULT NULL,
  `tue_time` varchar(255) DEFAULT NULL,
  `wed_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dcms_teacher`
--

LOCK TABLES `dcms_teacher` WRITE;
/*!40000 ALTER TABLE `dcms_teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `dcms_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dcms_waitinglist`
--

DROP TABLE IF EXISTS `dcms_waitinglist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dcms_waitinglist` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `application_date` date DEFAULT NULL,
  `attending_mode` varchar(50) DEFAULT NULL,
  `customized_sequence` int(10) DEFAULT NULL,
  `desire_date` date DEFAULT NULL,
  `expect_grade` varchar(50) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `offered_date` date DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `child` int(10) DEFAULT NULL,
  `display_status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dcms_waitinglist_child` (`child`),
  CONSTRAINT `FK_dcms_waitinglist_child` FOREIGN KEY (`child`) REFERENCES `dcms_child` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dcms_waitinglist`
--

LOCK TABLES `dcms_waitinglist` WRITE;
/*!40000 ALTER TABLE `dcms_waitinglist` DISABLE KEYS */;
INSERT INTO `dcms_waitinglist` VALUES (1,'2015-03-07','WEEKDAY',0,'2015-03-07','Infant','None','2015-01-01','ENROLLED',1,'ENROLLED'),(2,'2015-03-08','MON_WED_FRI',0,'2015-03-09','Infant','None','2015-01-01','ENROLLED',2,'ENROLLED'),(3,'2015-03-07','TUE_THU',0,'2015-03-07','Infant','None','2015-03-01','REMOVED',3,'REMOVED'),(4,'2015-03-07','WEEKDAY',0,'2015-03-07','Infant','None',NULL,'NEW',4,'NEW'),(5,'2015-03-07','MON_WED_FRI',0,'2015-03-07','Infant','None','2015-03-01','NEW',5,'RETURNED_TO_LIST'),(6,'2015-03-20','MON_WED_FRI',0,'2015-03-20','Infant','None','2015-03-03','ENROLLED',6,'ENROLLED'),(7,'2015-03-01','WEEKDAY',0,'2015-04-20','Infant','None','2015-03-22','ENROLLED',7,'ENROLLED'),(8,'2015-03-31','WEEKDAY',0,'2015-03-31','Preschool3',NULL,NULL,'NEW',9,'NEW'),(9,'2015-03-31','WEEKDAY',0,'2015-03-31','Infant',NULL,NULL,'NEW',10,'NEW'),(10,'2015-03-31','WEEKDAY',0,'2015-03-31','School Age',NULL,NULL,'NEW',11,'NEW'),(11,'2015-03-31','WEEKDAY',0,'2015-03-31','Infant','Application is pending',NULL,'NEW',12,'NEW'),(12,'2015-03-31','WEEKDAY',0,'2015-03-31','Infant','Application is the first',NULL,'NEW',13,'NEW');
/*!40000 ALTER TABLE `dcms_waitinglist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-06 11:13:24
