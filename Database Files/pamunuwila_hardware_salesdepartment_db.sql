CREATE DATABASE  IF NOT EXISTS `pamunuwila_hardware_salesdepartment_db` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pamunuwila_hardware_salesdepartment_db`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: pamunuwila_hardware_salesdepartment_db
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_no` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(100) NOT NULL,
  `customer_nic` varchar(45) DEFAULT NULL,
  `customer_email` varchar(100) DEFAULT NULL,
  `customer_contact_no` varchar(10) NOT NULL,
  `customer_address` varchar(300) DEFAULT NULL,
  `customer_city` varchar(45) NOT NULL,
  `district_no` int NOT NULL DEFAULT '1',
  `province_no` int NOT NULL DEFAULT '1',
  `customer_gender` varchar(10) NOT NULL,
  `customer_status` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`customer_no`),
  UNIQUE KEY `user_id_UNIQUE` (`customer_no`),
  KEY `fk_user_district1_idx` (`district_no`),
  KEY `fk_user_province1_idx` (`province_no`),
  CONSTRAINT `fk_user_district101` FOREIGN KEY (`district_no`) REFERENCES `district` (`district_no`),
  CONSTRAINT `fk_user_province101` FOREIGN KEY (`province_no`) REFERENCES `province` (`province_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Nimal','196618453266','nimal@gmail.com','0714586924','111,Nawala,Colombo 8','Nawala',6,10,'Male',1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_invoice`
--

DROP TABLE IF EXISTS `customer_invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_invoice` (
  `customer_invoice_no` int NOT NULL AUTO_INCREMENT,
  `customer_invoice_date` date NOT NULL,
  `customer_no` int NOT NULL,
  `customer_invoice_item_count` int NOT NULL DEFAULT '0',
  `customer_invoice_discount` double NOT NULL DEFAULT '0',
  `customer_invoice_tax` double NOT NULL DEFAULT '0',
  `customer_invoice_amount` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`customer_invoice_no`),
  UNIQUE KEY `customer_invoice_id_UNIQUE` (`customer_invoice_no`),
  KEY `fk_customer_invoice_customer1_idx` (`customer_no`),
  CONSTRAINT `fk_customer_invoice_customer1` FOREIGN KEY (`customer_no`) REFERENCES `customer` (`customer_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_invoice`
--

LOCK TABLES `customer_invoice` WRITE;
/*!40000 ALTER TABLE `customer_invoice` DISABLE KEYS */;
INSERT INTO `customer_invoice` VALUES (1,'2021-08-30',1,4,70,25,3105),(2,'2021-09-01',1,1,0,0,800);
/*!40000 ALTER TABLE `customer_invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `district` (
  `district_no` int NOT NULL AUTO_INCREMENT,
  `district_name` varchar(45) NOT NULL,
  PRIMARY KEY (`district_no`),
  UNIQUE KEY `district_id_UNIQUE` (`district_no`),
  UNIQUE KEY `district_name_UNIQUE` (`district_name`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` VALUES (2,'Ampara'),(3,'Anuradhapura'),(4,'Badulla'),(5,'Batticaloa'),(6,'Colombo'),(7,'Galle'),(8,'Gampaha'),(9,'Hambantota'),(10,'Jaffna'),(11,'Kalutara'),(12,'Kandy'),(13,'Kegalle'),(14,'Kilinochchi'),(15,'Kurunegala'),(16,'Mannar'),(17,'Matale'),(18,'Matara'),(19,'Monaragala'),(20,'Mullaitivu'),(1,'Not Selected'),(21,'NuwaraEliya'),(22,'Polonnaruwa'),(23,'Puttalam'),(24,'Ratnapura'),(25,'Trincomalee'),(26,'Vavuniya');
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grn`
--

DROP TABLE IF EXISTS `grn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grn` (
  `grn_no` int NOT NULL AUTO_INCREMENT,
  `grn_date` date NOT NULL,
  `supplier_no` int NOT NULL,
  `grn_item_count` int NOT NULL DEFAULT '0',
  `grn_discount` double NOT NULL DEFAULT '0',
  `grn_vat` double NOT NULL DEFAULT '0',
  `grn_amount` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`grn_no`),
  UNIQUE KEY `supplier_invoice_no_UNIQUE` (`grn_no`),
  KEY `fk_supplier_invoice_supplier1_idx` (`supplier_no`),
  CONSTRAINT `fk_supplier_invoice_supplier1` FOREIGN KEY (`supplier_no`) REFERENCES `supplier` (`supplier_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grn`
--

LOCK TABLES `grn` WRITE;
/*!40000 ALTER TABLE `grn` DISABLE KEYS */;
INSERT INTO `grn` VALUES (1,'2021-08-30',1,4,1000,450,45450),(2,'2021-09-01',2,1,500,500,15000);
/*!40000 ALTER TABLE `grn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grn_item`
--

DROP TABLE IF EXISTS `grn_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grn_item` (
  `grn_item_no` int NOT NULL AUTO_INCREMENT,
  `product_no` int NOT NULL,
  `grn_item_quantity` double NOT NULL DEFAULT '0',
  `grn_item_unit_buy_price` double NOT NULL DEFAULT '0',
  `grn_item_discount` double NOT NULL DEFAULT '0',
  `grn_item_vat` double NOT NULL DEFAULT '0',
  `grn_item_amount` double NOT NULL DEFAULT '0',
  `grn_no` int NOT NULL,
  PRIMARY KEY (`grn_item_no`),
  UNIQUE KEY `purchase_no_UNIQUE` (`grn_item_no`),
  KEY `fk_purchase_product1_idx` (`product_no`),
  KEY `fk_grn_item_grn1_idx` (`grn_no`),
  CONSTRAINT `fk_grn_item_grn1` FOREIGN KEY (`grn_no`) REFERENCES `grn` (`grn_no`),
  CONSTRAINT `fk_purchase_product1` FOREIGN KEY (`product_no`) REFERENCES `product` (`product_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grn_item`
--

LOCK TABLES `grn_item` WRITE;
/*!40000 ALTER TABLE `grn_item` DISABLE KEYS */;
INSERT INTO `grn_item` VALUES (1,1,100,50,5,2,4700,1),(2,2,100,60,0,0,6000,1),(3,3,50,300,10,5,14750,1),(4,4,50,400,0,0,20000,1),(5,3,100,150,5,5,15000,2);
/*!40000 ALTER TABLE `grn_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobrole`
--

DROP TABLE IF EXISTS `jobrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobrole` (
  `jobrole_no` int NOT NULL AUTO_INCREMENT,
  `jobrole_name` varchar(45) NOT NULL,
  PRIMARY KEY (`jobrole_no`),
  UNIQUE KEY `jobrole_id_UNIQUE` (`jobrole_no`),
  UNIQUE KEY `jobrole_name_UNIQUE` (`jobrole_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobrole`
--

LOCK TABLES `jobrole` WRITE;
/*!40000 ALTER TABLE `jobrole` DISABLE KEYS */;
INSERT INTO `jobrole` VALUES (1,'Admin');
/*!40000 ALTER TABLE `jobrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_no` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) NOT NULL,
  `product_image_url` varchar(200) DEFAULT NULL,
  `product_description` varchar(500) DEFAULT NULL,
  `unit_no` int NOT NULL DEFAULT '1',
  `product_discount` double NOT NULL DEFAULT '0',
  `product_tax` double NOT NULL DEFAULT '0',
  `product_status` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`product_no`),
  UNIQUE KEY `product_id_UNIQUE` (`product_no`),
  KEY `fk_product_unit1_idx` (`unit_no`),
  CONSTRAINT `fk_product_unit1` FOREIGN KEY (`unit_no`) REFERENCES `unit` (`unit_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'PVC','C:\\Users\\EZIO AUDITORY\\Downloads\\Favorites\\Images\\PVC.jpeg','',1,0,0,1),(2,'Tap','C:\\Users\\EZIO AUDITORY\\Downloads\\Favorites\\Images\\Tap.jpeg','',1,10,5,1),(3,'LED Bulb','C:\\Users\\EZIO AUDITORY\\Downloads\\Favorites\\Images\\LED Bulb.jpeg','',1,0,0,1),(4,'Tape','C:\\Users\\EZIO AUDITORY\\Downloads\\Favorites\\Images\\Tape.jpeg','',1,0,0,1),(5,'Cement','C:\\Users\\EZIO AUDITORY\\Downloads\\Favorites\\Images\\Cement.jpeg','no',1,10,5,1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `province`
--

DROP TABLE IF EXISTS `province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `province` (
  `province_no` int NOT NULL AUTO_INCREMENT,
  `province_name` varchar(45) NOT NULL,
  PRIMARY KEY (`province_no`),
  UNIQUE KEY `province_id_UNIQUE` (`province_no`),
  UNIQUE KEY `province_name_UNIQUE` (`province_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province`
--

LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;
INSERT INTO `province` VALUES (2,'Central'),(3,'Eastern'),(4,'North Central'),(5,'North Western'),(6,'Northern'),(1,'Not Selected'),(7,'Sabaragamuwa'),(8,'Southern'),(9,'Uva'),(10,'Western');
/*!40000 ALTER TABLE `province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales` (
  `sales_no` int NOT NULL AUTO_INCREMENT,
  `product_no` int NOT NULL,
  `sales_quantity` double NOT NULL DEFAULT '0',
  `sales_unit_sell_price` double NOT NULL,
  `sales_discount` double NOT NULL DEFAULT '0',
  `sales_tax` double NOT NULL DEFAULT '0',
  `sales_amount` double NOT NULL DEFAULT '0',
  `customer_invoice_no` int NOT NULL,
  PRIMARY KEY (`sales_no`),
  UNIQUE KEY `sales_id_UNIQUE` (`sales_no`),
  KEY `fk_sales_product1_idx` (`product_no`),
  KEY `fk_sales_customer_invoice1_idx` (`customer_invoice_no`),
  CONSTRAINT `fk_sales_customer_invoice1` FOREIGN KEY (`customer_invoice_no`) REFERENCES `customer_invoice` (`customer_invoice_no`),
  CONSTRAINT `fk_sales_product1` FOREIGN KEY (`product_no`) REFERENCES `product` (`product_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (1,1,10,80,2,0,780,1),(2,2,5,150,10,5,725,1),(3,3,2,500,0,0,1000,1),(4,4,1,600,0,0,600,1),(5,1,10,80,0,0,800,2);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `stock_no` int NOT NULL AUTO_INCREMENT,
  `stock_date` date NOT NULL,
  `product_no` int NOT NULL,
  `stock_quantity` double NOT NULL DEFAULT '0',
  `stock_unit_sell_price` double NOT NULL DEFAULT '0',
  `stock_last_update` date NOT NULL,
  `stock_status` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`stock_no`),
  UNIQUE KEY `stock_no_UNIQUE` (`stock_no`),
  KEY `fk_stock_product1_idx` (`product_no`),
  CONSTRAINT `fk_stock_product1` FOREIGN KEY (`product_no`) REFERENCES `product` (`product_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,'2021-08-30',1,80,80,'2021-09-01',1),(2,'2021-08-30',2,95,150,'2021-08-30',1),(3,'2021-08-30',3,48,500,'2021-08-30',1),(4,'2021-08-30',4,49,600,'2021-08-30',1),(5,'2021-09-01',3,100,300,'2021-09-01',1);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `supplier_no` int NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(100) NOT NULL,
  `supplier_nic` varchar(45) DEFAULT NULL,
  `supplier_email` varchar(100) DEFAULT NULL,
  `supplier_contact_no` varchar(10) NOT NULL,
  `supplier_address` varchar(300) DEFAULT NULL,
  `supplier_city` varchar(45) NOT NULL,
  `district_no` int NOT NULL DEFAULT '1',
  `province_no` int NOT NULL DEFAULT '1',
  `supplier_gender` varchar(10) NOT NULL,
  `supplier_status` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`supplier_no`),
  UNIQUE KEY `user_id_UNIQUE` (`supplier_no`),
  KEY `fk_user_district1_idx` (`district_no`),
  KEY `fk_user_province1_idx` (`province_no`),
  CONSTRAINT `fk_user_district10` FOREIGN KEY (`district_no`) REFERENCES `district` (`district_no`),
  CONSTRAINT `fk_user_province10` FOREIGN KEY (`province_no`) REFERENCES `province` (`province_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'Kamal','199812548796','kamal@gmail.com','0775551829','231,Dalugama,Kiribathgoda','Kiribathgoda',8,10,'Male',1),(2,'Kamal','200019401844','kamal@gmail.com','0713848592','','colombo',6,10,'Male',1);
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit`
--

DROP TABLE IF EXISTS `unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unit` (
  `unit_no` int NOT NULL AUTO_INCREMENT,
  `unit_name` varchar(45) NOT NULL,
  PRIMARY KEY (`unit_no`),
  UNIQUE KEY `unit_id_UNIQUE` (`unit_no`),
  UNIQUE KEY `unit_name_UNIQUE` (`unit_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit`
--

LOCK TABLES `unit` WRITE;
/*!40000 ALTER TABLE `unit` DISABLE KEYS */;
INSERT INTO `unit` VALUES (2,'Kg'),(3,'Liters'),(4,'Meters'),(5,'Millimeters'),(1,'Number');
/*!40000 ALTER TABLE `unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_no` int NOT NULL AUTO_INCREMENT,
  `user_username` varchar(45) NOT NULL,
  `user_password` varchar(45) NOT NULL,
  `jobrole_no` int NOT NULL DEFAULT '1',
  `user_status` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_no`),
  UNIQUE KEY `user_username_UNIQUE` (`user_username`),
  UNIQUE KEY `user_id_UNIQUE` (`user_no`),
  KEY `fk_user_jobrole1_idx` (`jobrole_no`),
  CONSTRAINT `fk_user_jobrole1` FOREIGN KEY (`jobrole_no`) REFERENCES `jobrole` (`jobrole_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'nuwa','1234',1,1);
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

-- Dump completed on 2021-09-01 16:46:21
