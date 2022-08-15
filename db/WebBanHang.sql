-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: webbanhang
-- ------------------------------------------------------
-- Server version	8.0.29
DROP SCHEMA IF EXISTS `webbanhang`;
CREATE SCHEMA `webbanhang` ;
use `webbanhang` ;

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
-- Table structure for table `cutomers`
--

DROP TABLE IF EXISTS `cutomers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cutomers` (
                            `Id` int NOT NULL AUTO_INCREMENT,
                            `Name` varchar(45) DEFAULT NULL,
                            `Birthday` date DEFAULT NULL,
                            `Procvince` varchar(45) DEFAULT NULL,
                            `Address` varchar(255) DEFAULT NULL,
                            `Tel` varchar(45) DEFAULT NULL,
                            `district` varchar(45) DEFAULT NULL,
                            `gender` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cutomers`
--

LOCK TABLES `cutomers` WRITE;
/*!40000 ALTER TABLE `cutomers` DISABLE KEYS */;
INSERT INTO `cutomers` VALUES (1,'Lan','2000-12-09','Cao Bằng','85/3/1 Phạm Văn Đồng phường 3, quận Bình thạnh',NULL,'Huyện Hòa An','Male');
/*!40000 ALTER TABLE `cutomers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupproduct`
--

DROP TABLE IF EXISTS `groupproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `groupproduct` (
                                `Id` int NOT NULL AUTO_INCREMENT,
                                `Name` varchar(45) DEFAULT NULL,
                                `Content` varchar(45) DEFAULT NULL,
                                `Images` varchar(45) DEFAULT NULL,
                                `Status` tinyint DEFAULT NULL,
                                PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupproduct`
--

LOCK TABLES `groupproduct` WRITE;
/*!40000 ALTER TABLE `groupproduct` DISABLE KEYS */;
INSERT INTO `groupproduct` VALUES (1,'Kem đánh răng','Kem đánh răng Coldgate','colgate.jpg',1),(2,'Bánh bông lan','Bánh bông lan Solife','solite.jpg',1),(3,'Bánh socola','Bánh socola Chocobie','chocopie.jpg',1),(4,'Sữa chua vinamilk','Sữa chua vinamilk hương dâu','suachua.jpg',1);
/*!40000 ALTER TABLE `groupproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `img`
--

DROP TABLE IF EXISTS `img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `img` (
                       `ID` int NOT NULL AUTO_INCREMENT,
                       `Imageid` int DEFAULT NULL,
                       `Image` varchar(45) DEFAULT NULL,
                       PRIMARY KEY (`ID`),
                       KEY `Imageid_idx` (`Imageid`),
                       CONSTRAINT `Imageid` FOREIGN KEY (`Imageid`) REFERENCES `product` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `img`
--

LOCK TABLES `img` WRITE;
/*!40000 ALTER TABLE `img` DISABLE KEYS */;
INSERT INTO `img` VALUES (1,1,'ponnie.jpg'),(2,1,'ponnie1.jpg'),(3,1,'ponnie2.jpg'),(4,1,'ponnie3.jpg'),(5,2,'phomai.jpg'),(6,2,'phomai1.jpg'),(7,2,'phomai2.jpg'),(8,2,'phomai3.jpg'),(9,3,'halan.jpg'),(10,3,'halan1.jpg'),(11,3,'halan2.jpg'),(12,3,'halan3.jpg'),(13,4,'solite.jpg'),(14,4,'solite1.jpg'),(15,4,'solite2.jpg'),(16,4,'solite3.jpg'),(23,6,'chocopie2.jpg'),(24,6,'chocopie3.jpg'),(25,7,'suachua.jpg'),(26,7,'suachua1.jpg'),(27,7,'suachua2.jpg'),(28,7,'suachua3.jpg'),(29,8,'comfort.jpg'),(30,8,'comfort1.jpg'),(31,8,'comfort2.jpg'),(32,8,'comfort3.jpg'),(33,9,'nuoc-lau-san.jpg'),(34,9,'nuoc-lau-san1.jpg'),(35,9,'nuoc-lau-san2.jpg'),(36,9,'nuoc-lau-san3.jpg'),(37,10,'cocacola.jpg'),(38,10,'cocacola1.jpg'),(39,10,'cocacola2.jpg'),(40,10,'cocacola3.jpg'),(41,11,'pepsi.jpg'),(42,11,'pepsi1.jpg'),(43,11,'pepsi2.jpg'),(44,11,'pepsi3.jpg'),(45,12,'3mien.jpg'),(46,12,'3mien1.jpg'),(47,12,'3mien2.jpg'),(48,12,'3mien3.jpg'),(49,13,'haohao.jpg'),(50,13,'haohao1.jpg'),(51,13,'haohao2.jpg'),(52,13,'haohao3.jpg'),(53,14,'milo.jpg'),(54,14,'milo1.jpg'),(55,14,'milo2.jpg'),(56,14,'milo3.jpg'),(57,15,'ovaltine.jpg'),(58,15,'ovaltine1.jpg'),(59,15,'ovaltine2.jpg'),(60,15,'ovaltine3.jpg'),(61,16,'lays.jpg'),(62,16,'lays1.jpg'),(63,16,'lays2.jpg'),(64,16,'lays3.jpg'),(65,17,'swing.jpg'),(66,17,'swing1.jpg'),(67,17,'swing2.jpg'),(68,17,'swing3.jpg'),(69,18,'dainisa.jpg'),(70,18,'dainisa1.jpg'),(71,18,'dainisa2.jpg'),(72,18,'dainisa3.jpg'),(73,19,'banhbia.jpg'),(74,19,'banhbia1.jpg'),(75,19,'banhbia2.jpg'),(76,19,'banhbia3.jpg'),(77,20,'romano.jpg'),(78,20,'romano1.jpg'),(79,20,'romano2.jpg'),(80,20,'romano3.jpg'),(81,21,'xmen.jpg'),(82,21,'xmen1.jpg'),(83,21,'xmen2.jpg'),(84,21,'xmen3.jpg'),(85,22,'sua-rua-mat.jpg'),(86,22,'sua-rua-mat1.jpg'),(87,22,'sua-rua-mat2.jpg'),(88,22,'sua-rua-mat3.jpg'),(89,23,'bot-ngot.jpg'),(90,23,'bot-ngot1.jpg'),(91,23,'bot-ngot2.jpg'),(92,23,'bot-ngot3.jpg'),(93,24,'knorr.jpg'),(94,24,'knorr1.jpg'),(95,24,'knorr2.jpg'),(96,24,'knorr3.jpg');
/*!40000 ALTER TABLE `img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `money_month`
--

DROP TABLE IF EXISTS `money_month`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `money_month` (
                               `month` int NOT NULL,
                               `money` double NOT NULL,
                               PRIMARY KEY (`month`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `money_month`
--

LOCK TABLES `money_month` WRITE;
/*!40000 ALTER TABLE `money_month` DISABLE KEYS */;
/*!40000 ALTER TABLE `money_month` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetail` (
                               `Id` int NOT NULL AUTO_INCREMENT,
                               `Order_Id` int DEFAULT NULL,
                               `Product_Id` int DEFAULT NULL,
                               `Quantity` int DEFAULT NULL,
                               PRIMARY KEY (`Id`),
                               KEY `Order_Id_idx` (`Order_Id`),
                               KEY `Product_Id_idx` (`Product_Id`),
                               CONSTRAINT `Order_Id` FOREIGN KEY (`Order_Id`) REFERENCES `orders` (`Id`),
                               CONSTRAINT `Product_Id` FOREIGN KEY (`Product_Id`) REFERENCES `product` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
INSERT INTO `orderdetail` VALUES (1,1,3,2),(2,1,10,3),(3,2,2,4);
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
                          `Id` int NOT NULL AUTO_INCREMENT,
                          `Customer_id` int DEFAULT NULL,
                          `Totalmoney` float DEFAULT NULL,
                          `Date` datetime DEFAULT NULL,
                          `Status` tinyint DEFAULT NULL,
                          PRIMARY KEY (`Id`),
                          KEY `Customer_id_idx` (`Customer_id`),
                          CONSTRAINT `Customer_id` FOREIGN KEY (`Customer_id`) REFERENCES `cutomers` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,189200,'2022-07-27 15:28:45',1),(2,1,120800,'2022-08-01 09:25:57',1);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
                           `Id` int NOT NULL AUTO_INCREMENT,
                           `Name` varchar(45) DEFAULT NULL,
                           `Detail` varchar(255) DEFAULT NULL,
                           `Price` varchar(45) DEFAULT NULL,
                           `Sale` varchar(45) DEFAULT NULL,
                           `Date` date DEFAULT NULL,
                           `Amount` int DEFAULT NULL,
                           `Status` int DEFAULT NULL,
                           `GroupID` int DEFAULT NULL,
                           PRIMARY KEY (`Id`),
                           KEY `GroupID_idx` (`GroupID`),
                           CONSTRAINT `GroupID` FOREIGN KEY (`GroupID`) REFERENCES `groupproduct` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Xúc xích ponnie','Xúc xích ponnie được làm từ thịt','6000','0.1','2022-04-29',1,1,1),(2,'Phô mai con bò cười','Thơm ngon, mềm mịn, 8 miếng vị truyền thống','28000','0.1','2022-04-29',1,1,1),(3,'Sữa tươi Cô gái Hà La','Sữa tươi cô gái Hà Lan, tươi như gái Hà La','7000','0.1','2022-05-29',1,1,2),(4,'Bánh bông lan solite','Bánh bông lan kem bơ sữa','20000','0.1','2022-05-29',1,1,1),(6,'Phô mai con bò cười','Thơm ngon, mềm mịn, 8 miếng vị truyền thống','28000','0.1','2022-04-29',1,1,1),(7,'Sữa tươi Cô gái Hà La','Sữa tươi cô gái Hà Lan, tươi như gái Hà La','7000','0.1','2022-05-29',1,1,2),(8,'Bánh bông lan solite','Bánh bông lan kem bơ sữa','20000','0.1','2022-05-29',1,1,1),(9,'Kem đánh răng Colgate','Cho hơi thở mát lạnh, giảm 90% sự phát triển của vi khuẩ','79000','0.1','2022-05-29',1,1,3),(10,'Bánh Chocopie','Hạnh phúc là trao tặng, tình như Chocopie','58000','0.1','2022-05-29',1,1,1),(11,'Sữa chua Vinamilk','Vinamilk \"Vươn cao Việt Nam\"','25000','0.1','2022-04-29',1,1,2),(12,'Nước giặt Comfort','Thơm mát suốt ngày dài năng động','129000','0.1','2022-04-29',1,1,3),(13,'Nước lau sàn Sunlight','Nhà sạch – không hại da tay – sạch đến bất ngờ','55000','0.1','2022-04-29',1,1,3),(14,'Nước ngọt có ga Coca Cola','CocaCola! Uống cùng cảm xúc','8000','0.1','2022-04-29',1,1,2),(15,'Nước ngọt có ga Pepsi','Pepsi – hương vị tuyệt vời cho cuộc sống của bạ','7000','0.1','2022-04-29',1,1,2),(16,'Mì 3 miền gold','Nổi bật hương vị bò hầm rau thơm','4000','0.1','2022-04-29',1,1,1),(17,'Mì Hảo Hảo','Biểu tượng của chất lượng','4500','0.1','2022-04-29',1,1,1),(18,'Thức uống lúa mạch Milo','Nhà vô địch làm từ Milo','6500','0.1','2022-04-29',1,1,2),(19,'Thức uống lúa mạch Ovaltine','Chẳng cần vô địch, chỉ cần con thích','6500','0.1','2022-04-29',1,1,2),(20,'Lays! Snack khoai tây','Hương vị đến từ khoai tây','9000','0.1','2022-04-29',1,1,1),(21,'Wing! Snack khoai tây','Snack khoai tây vị bít tết kiểu New York','8500','0.1','2022-04-29',1,1,1),(22,'Bánh quy Dainisa','Bánh quy bơ Dainisa','125000','0.1','2022-04-29',1,1,1),(23,'Đặc sản Bánh Bía','Bánh Bía Sốc Trăng','70000','0.1','2022-04-29',1,1,1),(24,'Dầu gội Romano','Dầu gội cao cấp cho Nam','150000','0.1','2022-04-29',1,1,3);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
                         `Id` int NOT NULL AUTO_INCREMENT,
                         `Username` varchar(45) NOT NULL,
                         `Password` varchar(255) DEFAULT NULL,
                         `Email` varchar(45) DEFAULT NULL,
                         `Enabled` varchar(45) DEFAULT NULL,
                         `Img` varchar(45) DEFAULT NULL,
                         `Cutomers_id` int DEFAULT NULL,
                         `Role` varchar(45) NOT NULL,
                         `Token` varchar(45) DEFAULT NULL,
                         PRIMARY KEY (`Id`),
                         UNIQUE KEY `Username_UNIQUE` (`Username`),
                         UNIQUE KEY `Email_UNIQUE` (`Email`),
                         KEY `Cutomers_id_idx` (`Cutomers_id`),
                         CONSTRAINT `Cutomers_id` FOREIGN KEY (`Cutomers_id`) REFERENCES `cutomers` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'phuchau','1901','phuchau164@gmIL.COM','1',NULL,1,'ROLE_ADMIN',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-11 20:21:09
