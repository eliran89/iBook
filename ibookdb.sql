CREATE DATABASE  IF NOT EXISTS `ibookdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ibookdb`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
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
  PRIMARY KEY (`authorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,' J. D. Salinger'),(2,'J.K.Rowling');
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
INSERT INTO `bauthor` VALUES (2,34),(1,35);
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
  CONSTRAINT `fk_bkey_key` FOREIGN KEY (`Word`) REFERENCES `keyword` (`word`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bkey`
--

LOCK TABLES `bkey` WRITE;
/*!40000 ALTER TABLE `bkey` DISABLE KEYS */;
INSERT INTO `bkey` VALUES (34,'fantacy'),(34,'greate'),(34,'O.K'),(35,'kill'),(35,'Suck'),(35,'Very Suck');
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
  `brief` varchar(45) DEFAULT NULL,
  `appendix` varchar(45) DEFAULT NULL,
  `numOfSearches` int(11) DEFAULT NULL,
  `numOfOrders` int(11) DEFAULT NULL,
  `absoluteRank` int(11) DEFAULT NULL,
  `cost` float DEFAULT NULL,
  `suspended` bit(1) DEFAULT b'0',
  PRIMARY KEY (`bookID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (34,'Harry Poter','English','a book','a book',0,1,2,40,'\0'),(35,'The Catcher in the Rye','english','no','no',0,1,1,35,'\0');
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
INSERT INTO `bscope` VALUES (35,'adults',NULL,'Boring'),(35,'Drama',NULL,'Boring'),(34,'Fantasy',NULL,'Kids'),(35,'Fantasy',NULL,'Boring'),(34,'Kids',NULL,'Magic');
/*!40000 ALTER TABLE `bscope` ENABLE KEYS */;
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
INSERT INTO `interestedreader` VALUES (22222,'Nimrod','Mendel','nimrod');
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
INSERT INTO `keyword` VALUES ('fantacy'),('greate'),('kill'),('O.k'),('Suck'),('Very Suck');
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
  `dateOfEnd` datetime DEFAULT NULL,
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
INSERT INTO `periodicreader` VALUES (13,'yearly','2017-01-15 14:00:00');
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
  `debt` int(11) NOT NULL,
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
INSERT INTO `reader` VALUES (13,'4545',350,'periodic','zachi','mayer','zachi'),(14,'2332',350,'onbyone','malki','grosman','malki');
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
INSERT INTO `reviews` VALUES (1,35,'Suck','zachi',1,'this book is suck'),(2,35,'bad','malki',1,'i dont like this book at all he killed john lennon and the author is a murderer'),(3,34,'Great','zachi',1,'its a greate book i love fantasy books'),(4,34,'O.K','malki',1,'this book is O.K and not more then that');
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
INSERT INTO `scope` VALUES ('Adults',NULL),('Drama',NULL),('Fantasy',NULL),('Kids',NULL);
/*!40000 ALTER TABLE `scope` ENABLE KEYS */;
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
INSERT INTO `user` VALUES ('Avi','12345',3,'1'),('eliran','98765',4,'1'),('guy','12345',6,'1'),('malki','12345',2,'1'),('nimrod','12345',1,'1'),('zachi','98765',2,'1');
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

-- Dump completed on 2017-01-11 17:41:19
