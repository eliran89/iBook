-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: localhost    Database: ibookdb
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `authorID` int(11) NOT NULL,
  `authorName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`authorID`),
  UNIQUE KEY `authorName_UNIQUE` (`authorName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (10,'David Grossman'),(5,'Eliran'),(11,'George Lucas'),(8,'Grim Brothers'),(3,'Guy'),(1,'J. D. Salinger'),(2,'J.K.Rowling'),(9,'miriam ruth'),(4,'Nimrod'),(7,'R.R.Martin'),(12,'Yochi Brandes'),(6,'Zachi');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bauthor`
--

DROP TABLE IF EXISTS `bauthor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bauthor` (
  `authorID` int(11) NOT NULL,
  `bookID` int(11) NOT NULL,
  PRIMARY KEY (`authorID`,`bookID`),
  KEY `bookid_idx` (`bookID`),
  KEY `fk_author_bauthor_idx` (`authorID`),
  CONSTRAINT `fk_author_bauthor` FOREIGN KEY (`authorID`) REFERENCES `author` (`authorID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_author_book` FOREIGN KEY (`bookID`) REFERENCES `book` (`bookID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bauthor`
--

LOCK TABLES `bauthor` WRITE;
/*!40000 ALTER TABLE `bauthor` DISABLE KEYS */;
INSERT INTO `bauthor` VALUES (1,37),(3,38),(4,38),(5,38),(6,38),(2,39),(7,40),(8,41),(8,42),(8,43),(10,44),(11,45),(12,46);
/*!40000 ALTER TABLE `bauthor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bkey`
--

DROP TABLE IF EXISTS `bkey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bkey` (
  `bookID` int(11) NOT NULL,
  `Word` varchar(10) NOT NULL,
  PRIMARY KEY (`bookID`,`Word`),
  KEY `word_idx` (`Word`),
  KEY `fk_bkey_book_idx` (`bookID`),
  CONSTRAINT `fk_bkey_book` FOREIGN KEY (`bookID`) REFERENCES `book` (`bookID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_bkey_key` FOREIGN KEY (`Word`) REFERENCES `keyword` (`word`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bkey`
--

LOCK TABLES `bkey` WRITE;
/*!40000 ALTER TABLE `bkey` DISABLE KEYS */;
INSERT INTO `bkey` VALUES (37,'kill'),(37,'Very Suck'),(38,'hard'),(38,'long'),(38,'test'),(39,'fantasy'),(39,'greate'),(40,'Medieval'),(41,'kids'),(41,'legend'),(42,'kids'),(42,'legend'),(43,'kids'),(43,'legends'),(44,'Fiction'),(44,'run'),(45,'Fiction'),(45,'Star Wars'),(46,'Israeli');
/*!40000 ALTER TABLE `bkey` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `bookID` int(11) NOT NULL,
  `Title` varchar(45) DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  `brief` varchar(500) DEFAULT NULL,
  `appendix` varchar(500) DEFAULT NULL,
  `numOfOrders` int(11) DEFAULT NULL,
  `cost` float DEFAULT NULL,
  `suspended` int(11) DEFAULT '0',
  PRIMARY KEY (`bookID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (37,'The Catcher in the Rye','english','no','no',0,35,0),(38,'Project Test','english','This is a test','No',0,35,1),(39,'Harry Potter','English','a book','a book',0,40,0),(40,'Game Of Thrones','English','a book about the game of thrones','no',0,40,0),(41,'Snow White','English','no','no',0,20,0),(42,'Pinocchio','English','no','no',0,20,0),(43,'Cinderella','English','no','no',0,20,0),(44,'Someone to Run with ','Hebrew','no','no',0,17,0),(45,'Star Wars','English','no','no',0,40,0),(46,'Seven Mothers','Hebrew','no','no',0,20,0);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bscope`
--

DROP TABLE IF EXISTS `bscope`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bscope` (
  `bookID` int(11) NOT NULL,
  `scopeName` varchar(45) NOT NULL,
  `rank` int(11) DEFAULT NULL,
  `subject` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`scopeName`,`bookID`),
  KEY `fk_scope_book_idx` (`bookID`),
  CONSTRAINT `fk_bscope_scope` FOREIGN KEY (`scopeName`) REFERENCES `scope` (`scopeName`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_scope_book` FOREIGN KEY (`bookID`) REFERENCES `book` (`bookID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bscope`
--

LOCK TABLES `bscope` WRITE;
/*!40000 ALTER TABLE `bscope` DISABLE KEYS */;
INSERT INTO `bscope` VALUES (37,'Adults',0,'Boring'),(38,'Adults',0,'test'),(37,'Drama',0,'Boring'),(46,'Drama',0,'Israeli'),(40,'fantacy',0,'Medieval'),(37,'Fantasy',0,'Boring'),(39,'Fantasy',0,'Kids'),(44,'Fiction',0,'Literature'),(45,'Fiction',0,'Fiction'),(39,'Kids',0,'Magic'),(41,'kids',0,'fantacy'),(42,'kids',0,'fantacy'),(43,'kids',0,'fantacy'),(38,'test',0,'test');
/*!40000 ALTER TABLE `bscope` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bsubject`
--

DROP TABLE IF EXISTS `bsubject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bsubject` (
  `bookID` int(11) NOT NULL,
  `subName` varchar(45) NOT NULL,
  PRIMARY KEY (`bookID`,`subName`),
  KEY `bookid_idx` (`bookID`),
  KEY `fk_bsubject_subject_idx` (`subName`),
  CONSTRAINT `fk_bsubject_book` FOREIGN KEY (`bookID`) REFERENCES `book` (`bookID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_bsubject_subject` FOREIGN KEY (`subName`) REFERENCES `subject` (`subjectName`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bsubject`
--

LOCK TABLES `bsubject` WRITE;
/*!40000 ALTER TABLE `bsubject` DISABLE KEYS */;
/*!40000 ALTER TABLE `bsubject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interestedreader`
--

DROP TABLE IF EXISTS `interestedreader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interestedreader` (
  `userID` int(11) NOT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  KEY `username_idx` (`username`),
  CONSTRAINT `` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interestedreader`
--

LOCK TABLES `interestedreader` WRITE;
/*!40000 ALTER TABLE `interestedreader` DISABLE KEYS */;
INSERT INTO `interestedreader` VALUES (22222,'Nimrod','Mendel','nimrod'),(68686,'moshe','galamin','mosheg'),(78978,'meni','mushonov','mushon');
/*!40000 ALTER TABLE `interestedreader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keyword`
--

DROP TABLE IF EXISTS `keyword`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `keyword` (
  `word` varchar(10) NOT NULL,
  PRIMARY KEY (`word`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keyword`
--

LOCK TABLES `keyword` WRITE;
/*!40000 ALTER TABLE `keyword` DISABLE KEYS */;
INSERT INTO `keyword` VALUES ('fantasy'),('Fiction'),('greate'),('hard'),('Israeli'),('kids'),('kill'),('legend'),('legends'),('long'),('Medieval'),('run'),('Star Wars'),('test'),('Very Suck');
/*!40000 ALTER TABLE `keyword` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodicreader`
--

DROP TABLE IF EXISTS `periodicreader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `periodicreader` (
  `userID` int(11) NOT NULL,
  `pType` varchar(45) DEFAULT NULL,
  `dateOfEnd` date DEFAULT NULL,
  PRIMARY KEY (`userID`),
  KEY `userID_idx` (`userID`),
  CONSTRAINT `userID` FOREIGN KEY (`userID`) REFERENCES `reader` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodicreader`
--

LOCK TABLES `periodicreader` WRITE;
/*!40000 ALTER TABLE `periodicreader` DISABLE KEYS */;
INSERT INTO `periodicreader` VALUES (11111,'yearly','2020-11-15'),(11225,'monthly','2017-08-25'),(44445,'monthly','2017-06-26'),(55145,'yearly','2020-01-25');
/*!40000 ALTER TABLE `periodicreader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privilege` (
  `privilege` int(11) NOT NULL,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`privilege`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
INSERT INTO `privilege` VALUES (1,'Interested Reader'),(2,'Reader'),(3,'Editor'),(4,'Library Worker'),(5,'Librarian'),(6,'Manager');
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reader`
--

DROP TABLE IF EXISTS `reader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reader` (
  `userID` int(11) NOT NULL,
  `creditCard` varchar(45) NOT NULL,
  `debt` int(11) DEFAULT '0',
  `rType` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`userID`),
  KEY `username_idx` (`username`),
  CONSTRAINT `username` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reader`
--

LOCK TABLES `reader` WRITE;
/*!40000 ALTER TABLE `reader` DISABLE KEYS */;
INSERT INTO `reader` VALUES (11111,'11111111',350,'periodic','zachi','meyer','zachi'),(11225,'12321234',0,'periodic','luach','trempim','lutrmp'),(11235,'12221545',0,'onebyone','Winnie','Pooh','winpo'),(44445,'44512457',0,'periodic','Shimon','Shimon','theking'),(55145,'55455454',0,'periodic','Yona','Yahav','yohav'),(64645,'64645645',350,'onebyone','malki','grosman','malki'),(78456,'12354123',0,'onebyone','James','Bond','jbond'),(78978,'11122233',0,'onebyone','meni','mushonov','mushon'),(85285,'54658452',0,'onebyone','Pika','Chu','Pikachu'),(87468,'11245123',0,'onebyone','Trump','Donald','Mcdonald');
/*!40000 ALTER TABLE `reader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `readerorder`
--

DROP TABLE IF EXISTS `readerorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `readerorder` (
  `userID` int(11) NOT NULL,
  `bookID` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`userID`,`bookID`),
  KEY `fk_rorder_book_idx` (`bookID`),
  CONSTRAINT `fk_reader_rorder` FOREIGN KEY (`userID`) REFERENCES `reader` (`userID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_rorder_book` FOREIGN KEY (`bookID`) REFERENCES `book` (`bookID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `readerorder`
--

LOCK TABLES `readerorder` WRITE;
/*!40000 ALTER TABLE `readerorder` DISABLE KEYS */;
INSERT INTO `readerorder` VALUES (11111,37,'2017-01-19 00:00:00'),(64645,39,'2017-01-01 18:00:00');
/*!40000 ALTER TABLE `readerorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reviews` (
  `reviewid` int(11) NOT NULL,
  `BookID` int(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `visible` int(11) DEFAULT '0',
  `text` varchar(400) NOT NULL,
  PRIMARY KEY (`reviewid`),
  UNIQUE KEY `UN_BookID_username` (`BookID`,`username`),
  KEY `fk_review_book_idx` (`BookID`),
  KEY `fk_review_user_idx` (`username`),
  CONSTRAINT `fk_review_book` FOREIGN KEY (`BookID`) REFERENCES `book` (`bookID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES (1,37,'Suck','zachi',0,'This book is suck'),(2,37,'Bad ','malki',0,'I dont like this book at all because he killed John Lennon and the author is a murderer '),(3,39,'Great ','zachi',1,'I dont like this book at all he killed John Lennon and the author is a murderer'),(4,39,'O.K.','malki',1,'This Book is O.K and not more then that');
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scope`
--

DROP TABLE IF EXISTS `scope`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scope` (
  `scopeName` varchar(45) NOT NULL,
  `comments` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`scopeName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scope`
--

LOCK TABLES `scope` WRITE;
/*!40000 ALTER TABLE `scope` DISABLE KEYS */;
INSERT INTO `scope` VALUES ('Adults',NULL),('Drama',NULL),('fantacy',NULL),('Fantasy',NULL),('Fiction',NULL),('Kids',NULL),('test',NULL);
/*!40000 ALTER TABLE `scope` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `searches`
--

DROP TABLE IF EXISTS `searches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `searches` (
  `bookID` int(11) NOT NULL DEFAULT '0',
  `date` datetime DEFAULT NULL,
  KEY `fk_search_book_idx` (`bookID`),
  CONSTRAINT `fk_search_book` FOREIGN KEY (`bookID`) REFERENCES `book` (`bookID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `searches`
--

LOCK TABLES `searches` WRITE;
/*!40000 ALTER TABLE `searches` DISABLE KEYS */;
INSERT INTO `searches` VALUES (37,'2016-12-25 17:00:00'),(37,'2017-01-20 14:49:28'),(39,'2017-01-20 14:51:35'),(39,'2017-01-20 14:52:02'),(37,'2017-01-20 14:52:09'),(39,'2017-01-20 14:52:22'),(37,'2017-01-20 14:52:26'),(39,'2017-01-20 14:52:41'),(38,'2017-01-20 14:52:46'),(37,'2017-01-20 14:52:50'),(37,'2017-01-20 14:52:56'),(38,'2017-01-20 14:52:59'),(37,'2017-01-22 18:16:11'),(37,'2017-01-22 18:16:40'),(37,'2017-01-22 18:16:57'),(40,'2017-01-22 18:17:20');
/*!40000 ALTER TABLE `searches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `subjectName` varchar(45) NOT NULL,
  PRIMARY KEY (`subjectName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` varchar(10) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `privilege` int(11) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `logged` int(11) DEFAULT '0',
  PRIMARY KEY (`username`),
  KEY `fk_user_privilege_idx` (`privilege`),
  CONSTRAINT `fk_user_privilege` FOREIGN KEY (`privilege`) REFERENCES `privilege` (`privilege`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Avi','12345',3,'1',0),('eliran','98765',4,'1',0),('guy','12345',6,'1',0),('jbond','45123',2,'1',0),('lutrmp','12345',2,'1',0),('malki','12345',2,'0',0),('Mcdonald','12345',2,'1',0),('mosheg','12345',2,'1',0),('mushon','12345',2,'1',0),('nimrod','12345',1,'1',0),('Pikachu','12345',2,'1',0),('theking','12345',2,'1',0),('winpo','12345',2,'1',0),('yohav','98765',2,'1',0),('zachi','98765',2,'1',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-26 20:46:08
