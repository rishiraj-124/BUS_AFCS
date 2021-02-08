/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.1.73 : Database - afcsbus_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`afcsbus_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `afcsbus_db`;

/*Table structure for table `bus_routes` */

DROP TABLE IF EXISTS `bus_routes`;

CREATE TABLE `bus_routes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bus_frequency` int(11) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_on` date DEFAULT NULL,
  `dest_stop` int(11) DEFAULT NULL,
  `distance_covered` int(11) DEFAULT NULL,
  `no_of_buses` int(11) DEFAULT NULL,
  `no_of_stops` int(11) DEFAULT NULL,
  `route_description` varchar(255) DEFAULT NULL,
  `route_number` varchar(255) DEFAULT NULL,
  `route_status` int(11) DEFAULT NULL,
  `running_time` int(11) DEFAULT NULL,
  `source_stop` int(11) DEFAULT NULL,
  `depot_num` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `bus_routes` */

insert  into `bus_routes`(`id`,`bus_frequency`,`created_by`,`created_on`,`dest_stop`,`distance_covered`,`no_of_buses`,`no_of_stops`,`route_description`,`route_number`,`route_status`,`running_time`,`source_stop`,`depot_num`) values 
(1,10,'446 - UserTransit','2020-12-18',10019,19,13,19,'BadarPur Border To Noida PhaseII Phool Mandi','8',0,30,10001,'D013'),
(2,10,'446 - UserTransit','2021-01-03',10019,19,13,19,'Nehru Place Terminal To Noida PhaseII Phool Mandi','8A',0,30,10020,'D013');

/*Table structure for table `bus_stops` */

DROP TABLE IF EXISTS `bus_stops`;

CREATE TABLE `bus_stops` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_on` date DEFAULT NULL,
  `is_depot` varchar(255) DEFAULT NULL,
  `is_terminal` varchar(255) DEFAULT NULL,
  `stop_city` varchar(255) DEFAULT NULL,
  `stop_code` varchar(255) DEFAULT NULL,
  `stop_id` int(11) DEFAULT NULL,
  `stop_landmark` varchar(255) DEFAULT NULL,
  `stop_name` varchar(255) DEFAULT NULL,
  `stop_pincode` int(11) DEFAULT NULL,
  `stop_state` varchar(255) DEFAULT NULL,
  `stop_status` varchar(255) DEFAULT NULL,
  `route_id` bigint(20) NOT NULL,
  `route_num` varchar(255) DEFAULT NULL,
  `stop_lat` varchar(255) DEFAULT NULL,
  `stop_long` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl4mamgp58y5g5qmjshuukq7ug` (`route_id`)
) ENGINE=MyISAM AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

/*Data for the table `bus_stops` */

insert  into `bus_stops`(`id`,`created_by`,`created_on`,`is_depot`,`is_terminal`,`stop_city`,`stop_code`,`stop_id`,`stop_landmark`,`stop_name`,`stop_pincode`,`stop_state`,`stop_status`,`route_id`,`route_num`,`stop_lat`,`stop_long`) values 
(1,'446 - UserTransit','2020-12-18','NO','NO','BADAR PUR  BORDER','01',10001,'BP Border','Badar Pur Border',110044,'Delhi','0',1,'8','28.492829','77.303506'),
(2,'446 - UserTransit','2020-12-18','NO','NO','BADAR PUR','02',10002,'Badarpur','Badar Pur',110044,'Delhi','0',1,'8','28.503962','77.301826'),
(3,'446 - UserTransit','2020-12-20','NO','NO','Ali Village','03',10003,'Ali Village','Ali Village',110044,'Delhi','0',1,'8','28.515530','77.307490'),
(4,'446 - UserTransit','2020-12-20','NO','NO','SARITA VIHAR CROSSING','04',10004,'SARITA VIHAR CROSSING','SARITA VIHAR CROSSING',110044,'Delhi','0',1,'8','28.539330','77.295372'),
(5,'446 - UserTransit','2020-12-20','NO','NO','KALINDI KUNJ','05',10005,'KALINDI KUNJ','KALINDI KUNJ',110044,'Delhi','0',1,'8','28.557650','77.321861'),
(6,'446 - UserTransit','2020-12-20','NO','NO','YAMUNA BRIDGE EAST CHECK POST','06',10006,'YAMUNA BRIDGE EAST CHECK POST','YAMUNA BRIDGE EAST CHECK POST',110044,'Delhi','0',1,'8','28.548347','77.316970'),
(7,'446 - UserTransit','2020-12-20','NO','NO','MAHAMAYA FLYOVER','07',10007,'MAHAMAYA FLYOVER','MAHAMAYA FLYOVER',110044,'Delhi','0',1,'8','28.556690','77.323080'),
(8,'446 - UserTransit','2020-12-20','NO','NO','AMITY SCHOOL','08',10008,'AMITY SCHOOL','AMITY SCHOOL',110044,'Delhi','0',1,'8','28.556385','77.330593'),
(9,'446 - UserTransit','2020-12-20','NO','NO','NOIDA SEC-37','09',10009,'NOIDA SEC-37','NOIDA SEC-37',110044,'Delhi','0',1,'8','28.567841','77.345470'),
(10,'446 - UserTransit','2020-12-20','NO','NO','NOIDA SEC-43 POLICE CHOKI SADAR PUR','10',10010,'NOIDA SEC-43 POLICE CHOKI SADAR PUR','NOIDA SEC-43 POLICE CHOKI SADAR PUR',110044,'Delhi','0',1,'8','28.557374','77.356519'),
(11,'446 - UserTransit','2020-12-20','NO','NO','AGHA PUR VILLAGE','11',10011,'AGHA PUR VILLAGE','AGHA PUR VILLAGE',110044,'Delhi','0',2,'8A','28.567318','77.358143'),
(12,'446 - UserTransit','2020-12-20','NO','NO','BAROLA VILLAGE','12',10012,'BAROLA VILLAGE','BAROLA VILLAGE',110044,'Delhi','0',2,'8A','28.560830','77.365412'),
(13,'446 - UserTransit','2020-12-20','NO','NO','HINDON VIHAR MORE','13',10013,'HINDON VIHAR MORE','HINDON VIHAR MORE',110044,'Delhi','0',2,'8A','28.559829','77.376491'),
(14,'446 - UserTransit','2020-12-20','NO','NO','SARIN FARM','14',10014,'SARIN FARM','SARIN FARM',110044,'Delhi','0',2,'8A','28.527719','77.473037'),
(15,'446 - UserTransit','2020-12-20','NO','NO','SADAR PUR VILLAGE','15',10015,'SADAR PUR VILLAGE','SADAR PUR VILLAGE',110044,'Delhi','0',2,'8A','28.557024','77.342368'),
(16,'446 - UserTransit','2020-12-20','NO','NO','NOIDA SEC-82 MORE','16',10016,'NOIDA SEC-82 MORE','NOIDA SEC-82 MORE',110044,'Delhi','0',2,'8A','28.529383','77.391295'),
(17,'446 - UserTransit','2020-12-20','NO','NO','HOUSARY COMPLEX PETROL PUMP','17',10017,'HOUSARY COMPLEX PETROL PUMP','HOUSARY COMPLEX PETROL PUMP',110044,'Delhi','0',2,'8A','28.535696','77.407443'),
(18,'446 - UserTransit','2020-12-20','NO','NO','NOIDA PH-II','18',10018,'NOIDA PH-II','NOIDA PH-II',110044,'Delhi','0',2,'8A','28.537364','77.413711'),
(19,'446 - UserTransit','2020-12-20','NO','NO','NOIDA PH-II PHOOL MANDI','19',10019,'NOIDA PH-II PHOOL MANDI','NOIDA PH-II PHOOL MANDI',110044,'Delhi','0',2,'8A','28.528891','77.424171'),
(20,'446 - UserTransit','2021-01-03','NO','NO','NEHRU PLACE TERMINAL','20',10020,'NP Termial','NEHRU PLACE TERMINAL',110044,'Delhi','0',2,'8A','28.548563','77.255552');

/*Table structure for table `depot` */

DROP TABLE IF EXISTS `depot`;

CREATE TABLE `depot` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `depot_id` varchar(255) DEFAULT NULL,
  `depot_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `depot` */

insert  into `depot`(`id`,`depot_id`,`depot_name`) values 
(1,'D013','SN Depot');

/*Table structure for table `discount` */

DROP TABLE IF EXISTS `discount`;

CREATE TABLE `discount` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `discount_id` varchar(255) DEFAULT NULL,
  `discount_in_per` varchar(255) DEFAULT NULL,
  `discount_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `discount` */

insert  into `discount`(`id`,`discount_id`,`discount_in_per`,`discount_type`) values 
(1,'01','10','Child'),
(2,'02','20','Senior Citizen');

/*Table structure for table `driver_conductor_user` */

DROP TABLE IF EXISTS `driver_conductor_user`;

CREATE TABLE `driver_conductor_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bus_assigned` varchar(255) DEFAULT NULL,
  `depot_id` varchar(255) DEFAULT NULL,
  `depot_name` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `employee_id` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `mpin` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `driver_conductor_user` */

insert  into `driver_conductor_user`(`id`,`bus_assigned`,`depot_id`,`depot_name`,`email_id`,`employee_id`,`first_name`,`last_name`,`mobile`,`mpin`,`password`,`role`,`status`) values 
(1,'DL1R0923','D013','SN Depot','subhash@gmail.com','E0501','Subhash','Chand','9090324576','2343','nextgen@123','Driver','Permanent');

/*Table structure for table `fare` */

DROP TABLE IF EXISTS `fare`;

CREATE TABLE `fare` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dest_stp_id` varchar(255) DEFAULT NULL,
  `disc_amnt` int(11) DEFAULT NULL,
  `fare_amnt` int(11) DEFAULT NULL,
  `src_stp_id` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=401 DEFAULT CHARSET=latin1;

/*Data for the table `fare` */

insert  into `fare`(`id`,`dest_stp_id`,`disc_amnt`,`fare_amnt`,`src_stp_id`,`status`) values 
(1,'10001',0,12,'10001','1'),
(2,'10002',0,12,'10001','1'),
(3,'10003',0,16,'10001','1'),
(4,'10004',0,16,'10001','1'),
(5,'10005',0,20,'10001','1'),
(6,'10006',0,20,'10001','1'),
(7,'10007',0,25,'10001','1'),
(8,'10008',0,25,'10001','1'),
(9,'10009',0,30,'10001','1'),
(10,'10010',0,30,'10001','1'),
(11,'10011',0,35,'10001','1'),
(12,'10012',0,35,'10001','1'),
(13,'10013',0,40,'10001','1'),
(14,'10014',0,40,'10001','1'),
(15,'10015',0,45,'10001','1'),
(16,'10016',0,45,'10001','1'),
(17,'10017',0,50,'10001','1'),
(18,'10018',0,50,'10001','1'),
(19,'10019',0,55,'10001','1'),
(20,'10020',0,55,'10001','1'),
(21,'10001',0,13,'10002','1'),
(22,'10002',0,13,'10002','1'),
(23,'10003',0,17,'10002','1'),
(24,'10004',0,17,'10002','1'),
(25,'10005',0,22,'10002','1'),
(26,'10006',0,22,'10002','1'),
(27,'10007',0,28,'10002','1'),
(28,'10008',0,28,'10002','1'),
(29,'10009',0,32,'10002','1'),
(30,'10010',0,32,'10002','1'),
(31,'10011',0,38,'10002','1'),
(32,'10012',0,38,'10002','1'),
(33,'10013',0,43,'10002','1'),
(34,'10014',0,43,'10002','1'),
(35,'10015',0,50,'10002','1'),
(36,'10016',0,50,'10002','1'),
(37,'10017',0,54,'10002','1'),
(38,'10018',0,54,'10002','1'),
(39,'10019',0,58,'10002','1'),
(40,'10020',0,58,'10002','1'),
(41,'10001',0,13,'10003','1'),
(42,'10002',0,13,'10003','1'),
(43,'10003',0,17,'10003','1'),
(44,'10004',0,17,'10003','1'),
(45,'10005',0,22,'10003','1'),
(46,'10006',0,22,'10003','1'),
(47,'10007',0,28,'10003','1'),
(48,'10008',0,28,'10003','1'),
(49,'10009',0,32,'10003','1'),
(50,'10010',0,32,'10003','1'),
(51,'10011',0,38,'10003','1'),
(52,'10012',0,38,'10003','1'),
(53,'10013',0,43,'10003','1'),
(54,'10014',0,43,'10003','1'),
(55,'10015',0,50,'10003','1'),
(56,'10016',0,50,'10003','1'),
(57,'10017',0,54,'10003','1'),
(58,'10018',0,54,'10003','1'),
(59,'10019',0,58,'10003','1'),
(60,'10020',0,58,'10003','1'),
(61,'10001',0,15,'10004','1'),
(62,'10002',0,15,'10004','1'),
(63,'10003',0,18,'10004','1'),
(64,'10004',0,18,'10004','1'),
(65,'10005',0,23,'10004','1'),
(66,'10006',0,23,'10004','1'),
(67,'10007',0,28,'10004','1'),
(68,'10008',0,28,'10004','1'),
(69,'10009',0,33,'10004','1'),
(70,'10010',0,33,'10004','1'),
(71,'10011',0,39,'10004','1'),
(72,'10012',0,39,'10004','1'),
(73,'10013',0,44,'10004','1'),
(74,'10014',0,44,'10004','1'),
(75,'10015',0,48,'10004','1'),
(76,'10016',0,48,'10004','1'),
(77,'10017',0,52,'10004','1'),
(78,'10018',0,52,'10004','1'),
(79,'10019',0,56,'10004','1'),
(80,'10020',0,56,'10004','1'),
(81,'10001',0,13,'10005','1'),
(82,'10002',0,13,'10005','1'),
(83,'10003',0,17,'10005','1'),
(84,'10004',0,17,'10005','1'),
(85,'10005',0,22,'10005','1'),
(86,'10006',0,22,'10005','1'),
(87,'10007',0,28,'10005','1'),
(88,'10008',0,28,'10005','1'),
(89,'10009',0,32,'10005','1'),
(90,'10010',0,32,'10005','1'),
(91,'10011',0,38,'10005','1'),
(92,'10012',0,38,'10005','1'),
(93,'10013',0,43,'10005','1'),
(94,'10014',0,43,'10005','1'),
(95,'10015',0,50,'10005','1'),
(96,'10016',0,50,'10005','1'),
(97,'10017',0,54,'10005','1'),
(98,'10018',0,54,'10005','1'),
(99,'10019',0,58,'10005','1'),
(100,'10020',0,58,'10005','1'),
(101,'10001',0,10,'10006','1'),
(102,'10002',0,10,'10006','1'),
(103,'10003',0,12,'10006','1'),
(104,'10004',0,12,'10006','1'),
(105,'10005',0,15,'10006','1'),
(106,'10006',0,15,'10006','1'),
(107,'10007',0,18,'10006','1'),
(108,'10008',0,18,'10006','1'),
(109,'10009',0,20,'10006','1'),
(110,'10010',0,20,'10006','1'),
(111,'10011',0,22,'10006','1'),
(112,'10012',0,22,'10006','1'),
(113,'10013',0,24,'10006','1'),
(114,'10014',0,24,'10006','1'),
(115,'10015',0,26,'10006','1'),
(116,'10016',0,26,'10006','1'),
(117,'10017',0,28,'10006','1'),
(118,'10018',0,28,'10006','1'),
(119,'10019',0,32,'10006','1'),
(120,'10020',0,32,'10006','1'),
(121,'10001',0,10,'10007','1'),
(122,'10002',0,10,'10007','1'),
(123,'10003',0,12,'10007','1'),
(124,'10004',0,12,'10007','1'),
(125,'10005',0,15,'10007','1'),
(126,'10006',0,15,'10007','1'),
(127,'10007',0,18,'10007','1'),
(128,'10008',0,18,'10007','1'),
(129,'10009',0,20,'10007','1'),
(130,'10010',0,20,'10007','1'),
(131,'10011',0,22,'10007','1'),
(132,'10012',0,22,'10007','1'),
(133,'10013',0,24,'10007','1'),
(134,'10014',0,24,'10007','1'),
(135,'10015',0,26,'10007','1'),
(136,'10016',0,26,'10007','1'),
(137,'10017',0,28,'10007','1'),
(138,'10018',0,28,'10007','1'),
(139,'10019',0,32,'10007','1'),
(140,'10020',0,32,'10007','1'),
(141,'10001',0,8,'10008','1'),
(142,'10002',0,8,'10008','1'),
(143,'10003',0,10,'10008','1'),
(144,'10004',0,10,'10008','1'),
(145,'10005',0,12,'10008','1'),
(146,'10006',0,12,'10008','1'),
(147,'10007',0,15,'10008','1'),
(148,'10008',0,15,'10008','1'),
(149,'10009',0,18,'10008','1'),
(150,'10010',0,18,'10008','1'),
(151,'10011',0,20,'10008','1'),
(152,'10012',0,20,'10008','1'),
(153,'10013',0,22,'10008','1'),
(154,'10014',0,22,'10008','1'),
(155,'10015',0,25,'10008','1'),
(156,'10016',0,25,'10008','1'),
(157,'10017',0,27,'10008','1'),
(158,'10018',0,27,'10008','1'),
(159,'10019',0,30,'10008','1'),
(160,'10020',0,30,'10008','1'),
(161,'10001',0,8,'10009','1'),
(162,'10002',0,8,'10009','1'),
(163,'10003',0,10,'10009','1'),
(164,'10004',0,10,'10009','1'),
(165,'10005',0,12,'10009','1'),
(166,'10006',0,12,'10009','1'),
(167,'10007',0,15,'10009','1'),
(168,'10008',0,15,'10009','1'),
(169,'10009',0,18,'10009','1'),
(170,'10010',0,18,'10009','1'),
(171,'10011',0,20,'10009','1'),
(172,'10012',0,20,'10009','1'),
(173,'10013',0,22,'10009','1'),
(174,'10014',0,22,'10009','1'),
(175,'10015',0,25,'10009','1'),
(176,'10016',0,25,'10009','1'),
(177,'10017',0,27,'10009','1'),
(178,'10018',0,27,'10009','1'),
(179,'10019',0,30,'10009','1'),
(180,'10020',0,30,'10009','1'),
(181,'10001',0,10,'10010','1'),
(182,'10002',0,10,'10010','1'),
(183,'10003',0,15,'10010','1'),
(184,'10004',0,15,'10010','1'),
(185,'10005',0,18,'10010','1'),
(186,'10006',0,18,'10010','1'),
(187,'10007',0,20,'10010','1'),
(188,'10008',0,20,'10010','1'),
(189,'10009',0,22,'10010','1'),
(190,'10010',0,22,'10010','1'),
(191,'10011',0,25,'10010','1'),
(192,'10012',0,25,'10010','1'),
(193,'10013',0,28,'10010','1'),
(194,'10014',0,28,'10010','1'),
(195,'10015',0,30,'10010','1'),
(196,'10016',0,30,'10010','1'),
(197,'10017',0,33,'10010','1'),
(198,'10018',0,33,'10010','1'),
(199,'10019',0,35,'10010','1'),
(200,'10020',0,35,'10010','1'),
(201,'10001',0,10,'10011','1'),
(202,'10002',0,10,'10011','1'),
(203,'10003',0,15,'10011','1'),
(204,'10004',0,15,'10011','1'),
(205,'10005',0,18,'10011','1'),
(206,'10006',0,18,'10011','1'),
(207,'10007',0,20,'10011','1'),
(208,'10008',0,20,'10011','1'),
(209,'10009',0,22,'10011','1'),
(210,'10010',0,22,'10011','1'),
(211,'10011',0,25,'10011','1'),
(212,'10012',0,25,'10011','1'),
(213,'10013',0,28,'10011','1'),
(214,'10014',0,28,'10011','1'),
(215,'10015',0,30,'10011','1'),
(216,'10016',0,30,'10011','1'),
(217,'10017',0,33,'10011','1'),
(218,'10018',0,33,'10011','1'),
(219,'10019',0,35,'10011','1'),
(220,'10020',0,35,'10011','1'),
(221,'10001',0,15,'10012','1'),
(222,'10002',0,15,'10012','1'),
(223,'10003',0,18,'10012','1'),
(224,'10004',0,18,'10012','1'),
(225,'10005',0,21,'10012','1'),
(226,'10006',0,21,'10012','1'),
(227,'10007',0,22,'10012','1'),
(228,'10008',0,22,'10012','1'),
(229,'10009',0,23,'10012','1'),
(230,'10010',0,23,'10012','1'),
(231,'10011',0,25,'10012','1'),
(232,'10012',0,25,'10012','1'),
(233,'10013',0,28,'10012','1'),
(234,'10014',0,28,'10012','1'),
(235,'10015',0,30,'10012','1'),
(236,'10016',0,30,'10012','1'),
(237,'10017',0,33,'10012','1'),
(238,'10018',0,33,'10012','1'),
(239,'10019',0,35,'10012','1'),
(240,'10020',0,35,'10012','1'),
(241,'10001',0,13,'10013','1'),
(242,'10002',0,13,'10013','1'),
(243,'10003',0,15,'10013','1'),
(244,'10004',0,15,'10013','1'),
(245,'10005',0,18,'10013','1'),
(246,'10006',0,18,'10013','1'),
(247,'10007',0,20,'10013','1'),
(248,'10008',0,20,'10013','1'),
(249,'10009',0,22,'10013','1'),
(250,'10010',0,22,'10013','1'),
(251,'10011',0,25,'10013','1'),
(252,'10012',0,25,'10013','1'),
(253,'10013',0,28,'10013','1'),
(254,'10014',0,28,'10013','1'),
(255,'10015',0,30,'10013','1'),
(256,'10016',0,30,'10013','1'),
(257,'10017',0,33,'10013','1'),
(258,'10018',0,33,'10013','1'),
(259,'10019',0,35,'10013','1'),
(260,'10020',0,35,'10013','1'),
(261,'10001',0,10,'10014','1'),
(262,'10002',0,10,'10014','1'),
(263,'10003',0,15,'10014','1'),
(264,'10004',0,15,'10014','1'),
(265,'10005',0,20,'10014','1'),
(266,'10006',0,20,'10014','1'),
(267,'10007',0,25,'10014','1'),
(268,'10008',0,25,'10014','1'),
(269,'10009',0,30,'10014','1'),
(270,'10010',0,30,'10014','1'),
(271,'10011',0,35,'10014','1'),
(272,'10012',0,35,'10014','1'),
(273,'10013',0,40,'10014','1'),
(274,'10014',0,40,'10014','1'),
(275,'10015',0,45,'10014','1'),
(276,'10016',0,45,'10014','1'),
(277,'10017',0,50,'10014','1'),
(278,'10018',0,50,'10014','1'),
(279,'10019',0,55,'10014','1'),
(280,'10020',0,55,'10014','1'),
(281,'10001',0,10,'10015','1'),
(282,'10002',0,10,'10015','1'),
(283,'10003',0,15,'10015','1'),
(284,'10004',0,15,'10015','1'),
(285,'10005',0,20,'10015','1'),
(286,'10006',0,20,'10015','1'),
(287,'10007',0,25,'10015','1'),
(288,'10008',0,25,'10015','1'),
(289,'10009',0,30,'10015','1'),
(290,'10010',0,30,'10015','1'),
(291,'10011',0,35,'10015','1'),
(292,'10012',0,35,'10015','1'),
(293,'10013',0,40,'10015','1'),
(294,'10014',0,40,'10015','1'),
(295,'10015',0,45,'10015','1'),
(296,'10016',0,45,'10015','1'),
(297,'10017',0,50,'10015','1'),
(298,'10018',0,50,'10015','1'),
(299,'10019',0,55,'10015','1'),
(300,'10020',0,55,'10015','1'),
(301,'10001',0,15,'10016','1'),
(302,'10002',0,15,'10016','1'),
(303,'10003',0,20,'10016','1'),
(304,'10004',0,20,'10016','1'),
(305,'10005',0,25,'10016','1'),
(306,'10006',0,25,'10016','1'),
(307,'10007',0,30,'10016','1'),
(308,'10008',0,30,'10016','1'),
(309,'10009',0,35,'10016','1'),
(310,'10010',0,35,'10016','1'),
(311,'10011',0,40,'10016','1'),
(312,'10012',0,40,'10016','1'),
(313,'10013',0,45,'10016','1'),
(314,'10014',0,45,'10016','1'),
(315,'10015',0,50,'10016','1'),
(316,'10016',0,50,'10016','1'),
(317,'10017',0,55,'10016','1'),
(318,'10018',0,55,'10016','1'),
(319,'10019',0,60,'10016','1'),
(320,'10020',0,60,'10016','1'),
(321,'10001',0,15,'10017','1'),
(322,'10002',0,15,'10017','1'),
(323,'10003',0,20,'10017','1'),
(324,'10004',0,20,'10017','1'),
(325,'10005',0,25,'10017','1'),
(326,'10006',0,25,'10017','1'),
(327,'10007',0,30,'10017','1'),
(328,'10008',0,30,'10017','1'),
(329,'10009',0,35,'10017','1'),
(330,'10010',0,35,'10017','1'),
(331,'10011',0,40,'10017','1'),
(332,'10012',0,40,'10017','1'),
(333,'10013',0,45,'10017','1'),
(334,'10014',0,45,'10017','1'),
(335,'10015',0,50,'10017','1'),
(336,'10016',0,50,'10017','1'),
(337,'10017',0,55,'10017','1'),
(338,'10018',0,55,'10017','1'),
(339,'10019',0,60,'10017','1'),
(340,'10020',0,60,'10017','1'),
(341,'10001',0,7,'10018','1'),
(342,'10002',0,7,'10018','1'),
(343,'10003',0,10,'10018','1'),
(344,'10004',0,10,'10018','1'),
(345,'10005',0,13,'10018','1'),
(346,'10006',0,13,'10018','1'),
(347,'10007',0,16,'10018','1'),
(348,'10008',0,16,'10018','1'),
(349,'10009',0,19,'10018','1'),
(350,'10010',0,19,'10018','1'),
(351,'10011',0,22,'10018','1'),
(352,'10012',0,22,'10018','1'),
(353,'10013',0,22,'10018','1'),
(354,'10014',0,25,'10018','1'),
(355,'10015',0,25,'10018','1'),
(356,'10016',0,28,'10018','1'),
(357,'10017',0,28,'10018','1'),
(358,'10018',0,31,'10018','1'),
(359,'10019',0,31,'10018','1'),
(360,'10020',0,34,'10018','1'),
(361,'10001',0,7,'10019','1'),
(362,'10002',0,7,'10019','1'),
(363,'10003',0,10,'10019','1'),
(364,'10004',0,10,'10019','1'),
(365,'10005',0,13,'10019','1'),
(366,'10006',0,13,'10019','1'),
(367,'10007',0,16,'10019','1'),
(368,'10008',0,16,'10019','1'),
(369,'10009',0,19,'10019','1'),
(370,'10010',0,19,'10019','1'),
(371,'10011',0,22,'10019','1'),
(372,'10012',0,22,'10019','1'),
(373,'10013',0,22,'10019','1'),
(374,'10014',0,25,'10019','1'),
(375,'10015',0,25,'10019','1'),
(376,'10016',0,28,'10019','1'),
(377,'10017',0,28,'10019','1'),
(378,'10018',0,31,'10019','1'),
(379,'10019',0,31,'10019','1'),
(380,'10020',0,34,'10019','1'),
(381,'10001',0,5,'10020','1'),
(382,'10002',0,5,'10020','1'),
(383,'10003',0,10,'10020','1'),
(384,'10004',0,10,'10020','1'),
(385,'10005',0,15,'10020','1'),
(386,'10006',0,15,'10020','1'),
(387,'10007',0,20,'10020','1'),
(388,'10008',0,20,'10020','1'),
(389,'10009',0,25,'10020','1'),
(390,'10010',0,25,'10020','1'),
(391,'10011',0,30,'10020','1'),
(392,'10012',0,30,'10020','1'),
(393,'10013',0,35,'10020','1'),
(394,'10014',0,35,'10020','1'),
(395,'10015',0,40,'10020','1'),
(396,'10016',0,40,'10020','1'),
(397,'10017',0,45,'10020','1'),
(398,'10018',0,45,'10020','1'),
(399,'10019',0,50,'10020','1'),
(400,'10020',0,50,'10020','1');

/*Table structure for table `fare_ruleby_distance` */

DROP TABLE IF EXISTS `fare_ruleby_distance`;

CREATE TABLE `fare_ruleby_distance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fare_amnt` varchar(255) DEFAULT NULL,
  `max_distance` varchar(255) DEFAULT NULL,
  `min_distance` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `fare_ruleby_distance` */

insert  into `fare_ruleby_distance`(`id`,`fare_amnt`,`max_distance`,`min_distance`,`status`) values 
(1,'5','5','0','1'),
(2,'10','10','6','1'),
(3,'15','15','11','1'),
(4,'20','20','16','1'),
(5,'25','25','21','1'),
(6,'30','30','26','1'),
(7,'35','35','31','1'),
(8,'40','40','36','1'),
(9,'45','45','41','1'),
(10,'50','50','46','1');

/*Table structure for table `pass_booking_detail` */

DROP TABLE IF EXISTS `pass_booking_detail`;

CREATE TABLE `pass_booking_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amnt_to_pay` decimal(19,2) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `dest_stop_id` varchar(255) DEFAULT NULL,
  `device_id` varchar(255) DEFAULT NULL,
  `device_ip` varchar(255) DEFAULT NULL,
  `disc_amnt` decimal(19,2) DEFAULT NULL,
  `doc_attached` varchar(255) DEFAULT NULL,
  `doc_required` varchar(255) DEFAULT NULL,
  `doc_type` varchar(255) DEFAULT NULL,
  `dt_issue` date DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `pass_details` varchar(255) DEFAULT NULL,
  `pass_id` varchar(255) DEFAULT NULL,
  `pass_request_date_time` datetime DEFAULT NULL,
  `pass_serial_num` varchar(255) DEFAULT NULL,
  `pass_type` varchar(255) DEFAULT NULL,
  `passqr_code` varchar(255) DEFAULT NULL,
  `pmnt_id` int(11) DEFAULT NULL,
  `src_stop_id` varchar(255) DEFAULT NULL,
  `tot_amnt` decimal(19,2) DEFAULT NULL,
  `trsct_id` int(11) DEFAULT NULL,
  `valid_upto` date DEFAULT NULL,
  `entry_count` varchar(255) DEFAULT NULL,
  `exit_count` varchar(255) DEFAULT NULL,
  `max_trip_allowed` int(11) DEFAULT NULL,
  `remaining_trip` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

/*Data for the table `pass_booking_detail` */

insert  into `pass_booking_detail`(`id`,`amnt_to_pay`,`created_by`,`dest_stop_id`,`device_id`,`device_ip`,`disc_amnt`,`doc_attached`,`doc_required`,`doc_type`,`dt_issue`,`duration`,`pass_details`,`pass_id`,`pass_request_date_time`,`pass_serial_num`,`pass_type`,`passqr_code`,`pmnt_id`,`src_stop_id`,`tot_amnt`,`trsct_id`,`valid_upto`,`entry_count`,`exit_count`,`max_trip_allowed`,`remaining_trip`,`status`) values 
(16,500.00,'asd@gmail.com','10005','358240051111110','101.85.196.251',500.00,NULL,'Yes',NULL,'2021-01-27','one Month','30 Trips Pass','22','2021-01-27 01:18:29','52884753','ltdTripPass','4h7tVY0blRtKLtaQAODmkv72l8MJBzWpiYaWWlNDSQd8RUMKGl50O7ABVZS1',52884753,'10001',500.00,22,'2021-02-26','2','2',30,28,'ACTIVE'),
(17,500.00,'asd@gmail.com','10006','358240051111110','101.85.196.251',500.00,NULL,'Yes',NULL,'2021-01-27','one Month','30 Trips Pass','22','2021-01-27 01:36:44','31945995','ltdTripPass','NYFi3iTbH0i4T5xN6zJWatNJAdIeH49JUtsMVOftfpAlPT8hozerlQ3Iz5IX',31945995,'10002',500.00,22,'2021-02-26','1','1',30,29,'ACTIVE'),
(18,700.00,'asd@gmail.com','10005','358240051111110','188.194.171.113',700.00,NULL,'Yes',NULL,'2021-02-02','one Month','60 Trips Pass','22','2021-02-02 12:40:14','74556878','ltdTripPass','s429l28rGmrV9ekvAuCnCJlajnZPS4sAW6IM2eklWZbPhEgeKhMJNVdETDL0',74556878,'10003',700.00,22,'2021-03-04',NULL,NULL,30,30,'ACTIVE'),
(19,700.00,'asd@gmail.com','10007',NULL,'199.105.88.140',700.00,NULL,'Yes',NULL,'2021-02-07','one Month','60 Trips Pass','22','2021-02-07 09:47:16','54989691','ltdTripPass',NULL,NULL,'10001',700.00,NULL,'2021-03-09',NULL,NULL,30,30,NULL),
(20,700.00,'asd@gmail.com','10007',NULL,'199.105.88.140',700.00,NULL,'Yes',NULL,'2021-02-07','one Month','60 Trips Pass','22','2021-02-07 09:47:29','91065582','ltdTripPass','8llHKn6H4dm4dfAe8IlsjaRlgRduLl645zUzQ9eLBZlEYoq8WQMxbW0d1tyV',91065582,'10001',700.00,22,'2021-03-09',NULL,NULL,30,30,'ACTIVE'),
(21,500.00,'samalpramod@gmail.com','10009',NULL,'199.77.75.0',500.00,NULL,'Yes',NULL,'2021-02-07','one Month','30 Trips Pass','22','2021-02-07 14:08:09','52867048','ltdTripPass','DRBtBBSjfTX2Q7yAABFeoYugrBflqOrT8HEo5reGUeNIOrBJuN2y6L3S4k8B',52867048,'10002',500.00,22,'2021-03-09',NULL,NULL,30,30,'ACTIVE'),
(22,500.00,'samalpramod@gmail.com','10002',NULL,'139.103.118.92',500.00,NULL,'Yes',NULL,'2021-02-07','one Month','30 Trips Pass','22','2021-02-07 14:41:55','28403183','ltdTripPass','b5ozj5dLrIQV2UrdMJ8z9XRVh15gaBLXRQEZ7WYBdKtWxJ38tIpa9ZW9EZta',28403183,'10003',500.00,22,'2021-03-09',NULL,NULL,30,30,'ACTIVE'),
(23,500.00,'samalpramod@gmail.com','10008',NULL,'85.3.22.244',500.00,NULL,'Yes',NULL,'2021-02-08','one Month','30 Trips Pass','22','2021-02-08 03:01:06','61696634','ltdTripPass','CWAZV3DJD4vF9Arad77H3VhqWLTbfd6qlukEtzmVvS48tWjoCJXkxK3WHRHj',61696634,'10002',500.00,22,'2021-03-10',NULL,NULL,30,30,'ACTIVE'),
(24,500.00,'asd@gmail.com','10003','358240051111110','188.194.171.113',500.00,NULL,'Yes',NULL,'2021-02-08','one Month','30 Trips Pass','22','2021-02-08 03:04:40','20069820','ltdTripPass','lVD0VpbpCF5hucWIlxjsPVffLbgptZ0XbZGoE3EoilI4JAUY8G7VxYtJZs2e',20069820,'10001',500.00,22,'2021-03-10',NULL,NULL,30,30,'ACTIVE'),
(25,500.00,'sarthak@gmail.com','10004','860568040633153','41.119.180.67',500.00,NULL,'Yes',NULL,'2021-02-08','one Month','30 Trips Pass','22','2021-02-08 03:24:00','61049839','ltdTripPass','4HMtc2xiTc4pMCo0FTcfJ42fR6Fv1Ff6oeYndZLr1djXVVkTrU6nrzGeg05p',61049839,'10001',500.00,22,'2021-03-10',NULL,NULL,30,30,'ACTIVE');

/*Table structure for table `pass_entry_exit_detail` */

DROP TABLE IF EXISTS `pass_entry_exit_detail`;

CREATE TABLE `pass_entry_exit_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `passb_id` varchar(255) DEFAULT NULL,
  `trip_entry_dt_time` datetime DEFAULT NULL,
  `trip_exit_dt_time` datetime DEFAULT NULL,
  `trip_num` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `pass_entry_exit_detail` */

insert  into `pass_entry_exit_detail`(`id`,`passb_id`,`trip_entry_dt_time`,`trip_exit_dt_time`,`trip_num`) values 
(1,'16','2021-02-02 09:19:30','2021-02-02 09:19:42','2');

/*Table structure for table `pass_master` */

DROP TABLE IF EXISTS `pass_master`;

CREATE TABLE `pass_master` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amt_to_pay` int(11) DEFAULT NULL,
  `disc_amt` int(11) DEFAULT NULL,
  `distance_src_dest` int(11) DEFAULT NULL,
  `doc_reqd` varchar(255) DEFAULT NULL,
  `doc_type` varchar(255) DEFAULT NULL,
  `dt_issue` varchar(255) DEFAULT NULL,
  `lines_valid_on` varchar(255) DEFAULT NULL,
  `pass_amt` int(11) DEFAULT NULL,
  `pass_description` varchar(255) DEFAULT NULL,
  `pass_details` varchar(255) DEFAULT NULL,
  `pass_id` int(11) DEFAULT NULL,
  `pass_name` varchar(255) DEFAULT NULL,
  `pass_period` varchar(255) DEFAULT NULL,
  `pass_type` varchar(255) DEFAULT NULL,
  `pax_type` varchar(255) DEFAULT NULL,
  `trip_allowed` varchar(255) DEFAULT NULL,
  `valid_from` varchar(255) DEFAULT NULL,
  `valid_to` varchar(255) DEFAULT NULL,
  `validity` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `pass_master` */

insert  into `pass_master`(`id`,`amt_to_pay`,`disc_amt`,`distance_src_dest`,`doc_reqd`,`doc_type`,`dt_issue`,`lines_valid_on`,`pass_amt`,`pass_description`,`pass_details`,`pass_id`,`pass_name`,`pass_period`,`pass_type`,`pax_type`,`trip_allowed`,`valid_from`,`valid_to`,`validity`) values 
(1,NULL,NULL,25,'Yes',NULL,NULL,NULL,500,NULL,NULL,22,'ltdTripPass','one Month',NULL,'General','30',NULL,NULL,'31-03-2021'),
(2,NULL,NULL,35,'Yes',NULL,NULL,NULL,700,NULL,NULL,20,'TripPass','Tne Month',NULL,'Regular','60',NULL,NULL,'31-03-2021');

/*Table structure for table `passenger` */

DROP TABLE IF EXISTS `passenger`;

CREATE TABLE `passenger` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amt_paid` bigint(20) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `no_of_tkt` int(11) DEFAULT NULL,
  `pss_type` varchar(255) DEFAULT NULL,
  `tkt_amount` bigint(20) DEFAULT NULL,
  `total_amt` bigint(20) DEFAULT NULL,
  `sj_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe3sgnli93ml40jji3ousivxvv` (`sj_id`)
) ENGINE=MyISAM AUTO_INCREMENT=111 DEFAULT CHARSET=latin1;

/*Data for the table `passenger` */

insert  into `passenger`(`id`,`amt_paid`,`discount`,`no_of_tkt`,`pss_type`,`tkt_amount`,`total_amt`,`sj_id`) values 
(1,120,0,49,'Adult',0,0,1),
(2,120,0,49,'Adult',0,0,2),
(3,100,0,49,'Adult',0,0,3),
(4,100,0,49,'Adult',0,0,4),
(5,17,0,1,'Adult',17,17,5),
(6,16,0,1,'Adult',16,16,6),
(7,17,0,1,'Adult',17,17,7),
(8,12,0,1,'Adult',12,12,8),
(9,12,0,1,'Adult',12,12,9),
(10,22,0,1,'Adult',22,22,10),
(11,17,0,1,'Adult',17,17,11),
(12,16,0,1,'Adult',16,16,12),
(13,22,0,1,'Adult',22,22,13),
(14,16,0,1,'Adult',16,16,14),
(15,17,0,1,'Adult',17,17,15),
(16,130,0,49,'Adult',0,0,16),
(17,170,0,1,'Adult',0,0,17),
(18,150,0,1,'Adult',0,0,18),
(19,22,0,1,'Adult',22,22,19),
(20,16,0,1,'Adult',16,16,20),
(21,22,0,1,'Adult',22,22,21),
(22,25,0,1,'Adult',25,25,22),
(23,25,0,1,'Adult',25,25,23),
(24,25,0,1,'Adult',25,25,24),
(25,22,0,1,'Adult',22,22,25),
(26,28,0,1,'Adult',28,28,26),
(27,180,0,1,'Adult',0,0,27),
(28,16,0,1,'Adult',16,16,28),
(29,17,0,1,'Adult',17,17,29),
(30,95,5,3,'Adult',50,100,30),
(31,95,5,2,'Child',50,100,30),
(32,17,0,1,'Adult',17,17,31),
(33,23,0,1,'Adult',23,23,32),
(34,17,0,1,'Adult',17,17,33),
(35,22,0,1,'Adult',22,22,34),
(36,22,0,1,'Adult',22,22,35),
(37,22,0,1,'Adult',22,22,36),
(38,30,0,1,'Adult',30,30,37),
(39,17,0,1,'Adult',17,17,38),
(40,32,0,1,'Adult',32,32,39),
(41,16,0,1,'Adult',16,16,40),
(42,33,0,1,'Adult',33,33,41),
(43,30,0,1,'Adult',30,30,42),
(44,16,0,1,'Adult',16,16,43),
(45,20,0,1,'Adult',20,20,44),
(46,20,0,1,'Adult',20,20,45),
(47,95,5,3,'Adult',50,100,46),
(48,95,5,2,'Child',50,100,46),
(49,25,0,1,'Adult',25,25,47),
(50,16,0,1,'Adult',16,16,48),
(51,12,0,1,'Adult',12,12,49),
(52,12,0,1,'Adult',12,12,50),
(53,16,0,1,'Adult',16,16,51),
(54,25,0,1,'Adult',25,25,52),
(55,25,0,1,'Adult',25,25,53),
(56,25,0,1,'Adult',25,25,54),
(57,25,0,1,'Adult',25,25,55),
(58,20,0,1,'Adult',20,20,56),
(59,30,0,1,'Adult',30,30,57),
(60,17,0,1,'Adult',17,17,58),
(61,20,0,1,'Adult',20,20,59),
(62,16,0,1,'Adult',16,16,60),
(63,50,0,1,'Adult',50,50,61),
(64,20,0,1,'Adult',20,20,62),
(65,30,0,1,'Adult',30,30,63),
(66,28,0,1,'Adult',28,28,64),
(67,33,0,1,'Adult',33,33,65),
(68,32,0,1,'Adult',32,32,66),
(69,32,0,1,'Adult',32,32,67),
(70,35,0,1,'Adult',35,35,68),
(71,17,0,1,'Adult',17,17,69),
(72,12,0,1,'Adult',12,12,70),
(73,12,0,1,'Adult',12,12,71),
(74,12,0,1,'Adult',12,12,72),
(75,12,0,1,'Adult',12,12,73),
(76,25,0,1,'Adult',25,25,74),
(77,25,0,1,'Adult',25,25,75),
(78,25,0,1,'Adult',25,25,76),
(79,25,0,1,'Adult',25,25,77),
(80,25,0,1,'Adult',25,25,78),
(81,55,0,1,'Adult',55,55,79),
(82,20,0,1,'Adult',20,20,80),
(83,25,0,1,'Adult',25,25,81),
(84,25,0,1,'Adult',25,25,82),
(85,25,0,1,'Adult',25,25,83),
(86,30,0,1,'Adult',30,30,84),
(87,25,0,1,'Adult',25,25,85),
(88,16,0,1,'Adult',16,16,86),
(89,38,0,1,'Adult',38,38,87),
(90,38,0,1,'Adult',38,38,88),
(91,16,0,1,'Adult',16,16,89),
(92,12,0,1,'Adult',12,12,90),
(93,16,0,1,'Adult',16,16,91),
(94,170,0,1,'Adult',0,0,92),
(95,33,0,1,'Adult',33,33,93),
(96,32,0,1,'Adult',32,32,94),
(97,64,0,2,'Adult',64,64,95),
(98,100,0,1,'Adult',0,0,96),
(99,120,0,1,'Adult',0,0,97),
(100,16,0,1,'Adult',16,16,98),
(101,55,0,1,'Adult',55,55,99),
(102,38,0,1,'Adult',38,38,100),
(103,32,0,1,'Adult',32,32,101),
(104,12,0,1,'Adult',12,12,102),
(105,120,0,1,'Adult',0,0,103),
(106,20,0,1,'Adult',0,0,104),
(107,20,0,1,'Adult',0,0,105),
(108,12,0,1,'Adult',12,12,106),
(109,100,0,1,'Adult',0,0,107),
(110,16,0,1,'Adult',16,16,108);

/*Table structure for table `single_journey` */

DROP TABLE IF EXISTS `single_journey`;

CREATE TABLE `single_journey` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cust_imei` varchar(255) DEFAULT NULL,
  `cust_ip_address` varchar(255) DEFAULT NULL,
  `dest_stp_id` int(11) DEFAULT NULL,
  `entryv` varchar(255) DEFAULT NULL,
  `entry_station` varchar(255) DEFAULT NULL,
  `exitv` varchar(255) DEFAULT NULL,
  `exit_station` varchar(255) DEFAULT NULL,
  `paid_amt` varchar(255) DEFAULT NULL,
  `pay_mode` varchar(255) DEFAULT NULL,
  `pmt_id` varchar(255) DEFAULT NULL,
  `qr_ticket_hash` varchar(255) DEFAULT NULL,
  `src_stp_id` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `tkt_bookingdt` date DEFAULT NULL,
  `tkt_no` bigint(20) DEFAULT NULL,
  `tkt_type` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `qr_status` varchar(255) DEFAULT NULL,
  `tkt_booking_dt_time` datetime DEFAULT NULL,
  `valid_upto` datetime DEFAULT NULL,
  `tkt_entry_dt_time` datetime DEFAULT NULL,
  `tkt_exit_dt_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=109 DEFAULT CHARSET=latin1;

/*Data for the table `single_journey` */

insert  into `single_journey`(`id`,`cust_imei`,`cust_ip_address`,`dest_stp_id`,`entryv`,`entry_station`,`exitv`,`exit_station`,`paid_amt`,`pay_mode`,`pmt_id`,`qr_ticket_hash`,`src_stp_id`,`status`,`tkt_bookingdt`,`tkt_no`,`tkt_type`,`user_id`,`qr_status`,`tkt_booking_dt_time`,`valid_upto`,`tkt_entry_dt_time`,`tkt_exit_dt_time`) values 
(47,'358240051111110','101.85.196.251',10008,'Yes',NULL,'Yes',NULL,'25.0','Credit Card','P230770618455690102','1WdjcWCBgBenCexcAColxf4emmMyYj6CmFHFISQBJnDrhhe8f4OKpzdxG8tS',10001,'INACTIVE',NULL,230770618455690102,'SJT','asd@gmail.com','Consumed','2021-01-26 03:37:39','2021-01-26 05:37:39',NULL,NULL),
(48,'358240051111110','101.85.196.251',10003,'Yes',NULL,'Yes',NULL,'16.0','Credit Card','P409576065465041834','2GtzJUPnUz7dGS1cxPCVDRlnYCTPVe5SpWzVSEcOY7mcy4pMcGCZTE4KNW7o',10001,'INACTIVE',NULL,409576065465041834,'SJT','asd@gmail.com','Consumed','2021-01-26 05:57:54','2021-01-26 07:57:54',NULL,NULL),
(49,'358240051111110','101.85.196.251',10002,'Yes',NULL,'Yes',NULL,'12.0','Credit Card','P884382575171457682','j6oZgDdMEYn4vd3LoOnJXOgy6vTETKsTnY2axfBDXioMB3pij0d0GduD39TJ',10001,'INACTIVE',NULL,884382575171457682,'SJT','asd@gmail.com','Consumed','2021-01-26 09:32:33','2021-01-26 11:32:33',NULL,'2021-02-01 15:26:15'),
(50,'358240051111110','101.85.196.251',10002,'Yes',NULL,'Yes',NULL,'12.0','Credit Card','P813419988246531121','QopfRZZ7sWxjWEB2PCsCiG3EB3KTHWS20z6UdMEf5YBUp4z5Z1O2GWlhyz59',10001,'INACTIVE',NULL,813419988246531121,'SJT','asd@gmail.com','Consumed','2021-01-26 09:42:22','2021-01-26 11:42:22',NULL,'2021-02-01 15:32:28'),
(51,'358240051111110','101.85.196.251',10004,'Yes',NULL,'Yes',NULL,'16.0','Credit Card','P448650082594883196','rHkQi62IsLYIOYFm192psWytPvNL8JObHd0iAb8LRZyaLuJQQzf50aoqPady',10001,'INACTIVE',NULL,448650082594883196,'SJT','asd@gmail.com','Consumed','2021-01-26 09:44:11','2021-01-26 11:44:11',NULL,'2021-02-01 15:36:16'),
(52,'358240051111110','101.85.196.251',10007,'Yes',NULL,'Yes',NULL,'25.0','Credit Card','P514274982615999440','gnuAktuG3gxxZqIraACVoS1opldt1MtaMpoj989b8WQCGR2QGx0lvrcrP0xH',10001,'INACTIVE',NULL,514274982615999440,'SJT','asd@gmail.com','Consumed','2021-01-26 09:56:57','2021-01-26 11:56:57','2021-02-02 00:58:21','2021-02-02 00:58:36'),
(53,'358240051111110','101.85.196.251',10007,'Yes',NULL,'Yes',NULL,'25.0','Credit Card','P964551667197542152','ij84bfqr4FVorgHaQcJlRNx4qx1mdF5GtQYsvDnUrBBBLakTb13e0THzm96k',10001,'INACTIVE',NULL,964551667197542152,'SJT','asd@gmail.com','Consumed','2021-01-26 10:00:12','2021-01-26 12:00:12',NULL,'2021-02-02 01:36:59'),
(54,'358240051111110','101.85.196.251',10008,'Yes',NULL,'Yes',NULL,'25.0','Credit Card','P829348919426220186','I8TPeqPFMV9ZW0v4M3MZr27F6R7ZAdkq1cU1X8fddl5Rl9lfG0h85OedqKH3',10001,'INACTIVE',NULL,829348919426220186,'SJT','asd@gmail.com','Consumed','2021-01-26 10:03:29','2021-01-26 12:03:29','2021-02-02 01:36:45','2021-02-02 01:43:39'),
(55,'358240051111110','101.85.196.251',10008,'Yes',NULL,'Yes',NULL,'25.0','Credit Card','P945568621027981970','ouQH9zoLCz4eGWo6u17ELZdDuy8JD0s0ssnvUqZyfdR0udM2CRkq412RijpE',10001,'INACTIVE',NULL,945568621027981970,'SJT','asd@gmail.com','Consumed','2021-01-26 10:04:30','2021-01-26 12:04:30','2021-02-01 13:57:48','2021-02-02 02:18:56'),
(56,'358240051111110','101.85.196.251',10006,'Yes',NULL,'Yes',NULL,'20.0','Credit Card','P114813122585762106','hnLOaXCuyQrC2gGoeI6s1KmmD8lp9bJhJllSeuKE70eECpkXIOMT57i81AsD',10001,'INACTIVE',NULL,114813122585762106,'SJT','asd@gmail.com','Consumed','2021-01-26 10:05:10','2021-01-26 12:05:10','2021-02-02 04:55:36','2021-02-02 04:55:56'),
(57,'358240051111110','101.85.196.251',10009,'Yes',NULL,'Yes',NULL,'30.0','Credit Card','P911723498526935389','Vy8l1brUOtdI9vsABK38jJlrqLEOMjzK46yuii3Ce2vj5iY6ZaGnV4C3fykB',10001,'INACTIVE',NULL,911723498526935389,'SJT','asd@gmail.com','Consumed','2021-01-26 10:06:44','2021-01-26 12:06:44','2021-02-02 02:19:32','2021-02-02 02:20:08'),
(58,'358240051111110','101.85.196.251',10004,'Yes',NULL,'Yes',NULL,'17.0','Credit Card','P347164559285758564','Exi2cj5kMFBEGIHFEVhO3dOnfBSYsjnJPrZ2YQA1jQHvmxZ14WEK3nTqD294',10002,'INACTIVE',NULL,347164559285758564,'SJT','asd@gmail.com','Consumed','2021-01-27 01:15:32','2021-01-27 03:15:32','2021-02-02 03:20:14','2021-02-02 03:20:33'),
(59,'358240051111110','101.85.196.251',10006,'Yes',NULL,'Yes',NULL,'20.0','Credit Card','P268213256047938244','YC1W7NBVEJmU4U7EUc7QTQbfi9GdrNpMPd19h9UfpbUd3Qf0apZqCWSSvsk2',10001,'INACTIVE',NULL,268213256047938244,'SJT','asd@gmail.com','Consumed','2021-01-27 01:32:07','2021-01-27 03:32:07',NULL,NULL),
(60,'358240051111110','101.85.196.251',10004,'Yes',NULL,'Yes',NULL,'16.0','Credit Card','P773187545672171845','UoBcWqOx4NNPvfgiPFJSlk5jV5sYjpvly7m7LYiVAK6bnaQzMArPmjNFC67e',10001,'INACTIVE',NULL,773187545672171845,'RJT','asd@gmail.com','Consumed','2021-01-27 01:38:40','2021-01-27 03:38:40','2021-02-02 07:55:12','2021-02-02 07:55:22'),
(61,NULL,'226.251.28.19',10017,NULL,NULL,NULL,NULL,'50.0','Credit Card','P363751446747373217','otcduW8VaH5qJlNnVsKE220vWeQ8mYZQ4mTPmsbmUrbEqIsAdcICfM8VKQET',10001,'ACTIVE',NULL,363751446747373217,'SJT','asd@gmail.com',NULL,'2021-01-27 03:10:19','2021-01-27 05:10:19',NULL,NULL),
(62,NULL,'85.3.22.244',10005,'Yes',NULL,'Yes',NULL,'20.0','Credit Card','P70876536703497234','hg3YLX5tMWr98eOzDoYKEehGnh2vvVtXIS45JJyUTfk5RJmRnjr014aoVF3h',10001,'INACTIVE',NULL,70876536703497234,'SJT','samalpramod@gmail.com','Consumed','2021-01-27 03:51:58','2021-01-27 05:51:58','2021-02-02 08:35:39','2021-02-02 08:35:55'),
(63,'358240051111110','101.85.196.251',10009,'Yes',NULL,'Yes',NULL,'30.0','Credit Card','P385623816234021951','QUGEQ9ZbEeTd5CEqEjrINpGOCU1QyB2n6B6s1PkIPWqMFyr4p1UlFbB5ocqv',10001,'INACTIVE',NULL,385623816234021951,'SJT','asd@gmail.com','Consumed','2021-02-01 13:14:06','2021-02-01 15:14:06','2021-02-02 05:00:12','2021-02-02 05:00:23'),
(64,'358240051111110','101.85.196.251',10008,'Yes',NULL,'Yes',NULL,'28.0','Credit Card','P621563933490928657','K7pTJZ7npaR03iHT2MI59NtTQku6pz3QOiVoYQVP90BYLdq3k78QEAxiaYvF',10004,'INACTIVE',NULL,621563933490928657,'SJT','asd@gmail.com','Consumed','2021-02-01 13:19:58','2021-02-01 15:19:58','2021-02-01 13:36:16','2021-02-01 13:36:25'),
(65,'358240051111110','101.85.196.251',10010,'Yes',NULL,'Yes',NULL,'33.0','Credit Card','P704781056885207025','RGgWJUbO8jrD5TdqMmqp8VQv0eXoJ4QuGbnmr9vbDCE0b8Bi2qdvkYgih8DQ',10004,'INACTIVE',NULL,704781056885207025,'SJT','asd@gmail.com','Consumed','2021-02-01 13:46:19','2021-02-01 15:46:19','2021-02-01 13:55:02','2021-02-02 07:36:08'),
(66,'358240051111110','101.85.196.251',10009,'Yes',NULL,'Yes',NULL,'32.0','Credit Card','P746565187242227677','RszGDcAiUJfXlvL3oAYoPYF4aCl7ofXyBMjTEhD4YR8kDA5MYirdUpgFL4kp',10002,'INACTIVE',NULL,746565187242227677,'SJT','asd@gmail.com','Consumed','2021-02-01 14:00:18','2021-02-01 16:00:18','2021-02-01 14:01:08','2021-02-02 08:22:24'),
(67,'358240051111110','101.85.196.251',10009,'Yes',NULL,'Yes',NULL,'32.0','Credit Card','P413941306253251282','FQprhyap436cke62dCoWkWlc6I9QPOf1PKuKDsCdsDYJtek5nsng1MeX0d5i',10002,'INACTIVE',NULL,413941306253251282,'SJT','asd@gmail.com','Consumed','2021-02-01 14:03:59','2021-02-01 16:03:59','2021-02-01 14:04:28','2021-02-02 07:12:44'),
(68,'358240051111110','101.85.196.251',10011,NULL,NULL,NULL,NULL,'35.0','Credit Card','P683584101839363033','lkrTHYXeZDMtOzEZdnURhEEWxtHPOFjuxbHWLDdEod81UZQqs5kqM7CkhcII',10001,'ACTIVE',NULL,683584101839363033,'SJT','asd@gmail.com',NULL,'2021-02-01 14:24:24','2021-02-01 16:24:24',NULL,NULL),
(69,'358240051111110','101.85.196.251',10004,'Yes',NULL,'Yes',NULL,'17.0','Credit Card','P205560857705368021','pagWZhK5aUS2ZBsrfbpg1fjdSkYy63DKt5JvZf3mPkWB4aIqY993kO0rygGt',10002,'INACTIVE',NULL,205560857705368021,'SJT','asd@gmail.com','Consumed','2021-02-01 14:27:47','2021-02-01 16:27:47','2021-02-01 14:28:13','2021-02-01 14:28:26'),
(70,'358240051111110','101.85.196.251',10002,'Yes',NULL,'Yes',NULL,'12.0','Credit Card','P881013136414355113','QgelO26upYIMmQohsYByG4zGY2KNyN83cVHafQXhXWGNScuBcn1getl0maNr',10001,'INACTIVE',NULL,881013136414355113,'SJT','asd@gmail.com','Consumed','2021-02-01 14:33:04','2021-02-01 16:33:04','2021-02-01 14:33:30','2021-02-02 08:45:10'),
(71,'358240051111110','101.85.196.251',10002,'Yes',NULL,'Yes',NULL,'12.0','Credit Card','P973262396974763614','DkeL2ltdYir5tFsOF5M9EtiHPsxh8TGTcNKISzkmVZuQWPYCZUR0HaBYQVCT',10001,'INACTIVE',NULL,973262396974763614,'SJT','asd@gmail.com','Consumed','2021-02-01 14:35:43','2021-02-01 16:35:43','2021-02-01 14:36:25','2021-02-02 07:59:20'),
(72,'358240051111110','101.85.196.251',10002,'Yes',NULL,'Yes',NULL,'12.0','Credit Card','P510093327145379954','os8HhVEZdsl3WMa9xSvVsdZqc5qtvZ38rYttOi71JNT8fW3aMikdjqB7IDdk',10001,'INACTIVE',NULL,510093327145379954,'SJT','asd@gmail.com','Consumed','2021-02-01 14:38:14','2021-02-01 16:38:14','2021-02-01 14:38:36','2021-02-01 14:38:45'),
(73,'358240051111110','101.85.196.251',10002,'Yes',NULL,'Yes',NULL,'12.0','Credit Card','P471757379250154429','nXLcOxBuuofJroWYqpNAMhoeNzbqKdRF3gC4FhNhdxR0LdlxxXTFy439cPbt',10001,'INACTIVE',NULL,471757379250154429,'SJT','asd@gmail.com','Consumed','2021-02-01 14:41:15','2021-02-01 16:41:15','2021-02-01 14:41:41','2021-02-01 14:41:53'),
(74,'358240051111110','101.85.196.251',10007,'Yes',NULL,'Yes',NULL,'25.0','Credit Card','P954533795764462228','3BcckbqFXsEnRi1yxqGuYDTtQntUF0PXTVlyx9EFFGUGUuQS5Wphm5bi09Ov',10001,'INACTIVE',NULL,954533795764462228,'SJT','asd@gmail.com','Consumed','2021-02-01 14:44:16','2021-02-01 16:44:16','2021-02-01 14:44:59','2021-02-01 14:45:08'),
(75,'358240051111110','101.85.196.251',10007,'Yes',NULL,'Yes',NULL,'25.0','Credit Card','P171802840475915000','LLsFIEL8dRO0VAEJ8TT0jpF0ijcIiB6MFB2GzjXpIGAP3HbqZNv28VNHHuhx',10001,'INACTIVE',NULL,171802840475915000,'SJT','asd@gmail.com','Consumed','2021-02-01 14:53:19','2021-02-01 16:53:19','2021-02-01 14:53:49','2021-02-01 14:59:32'),
(76,'358240051111110','101.85.196.251',10008,'Yes',NULL,'Yes',NULL,'25.0','Credit Card','P563805107705399091','qu590XkXCM7T7VGCtIai0rTHHtrLxDRR7y8YlqRuJayMEqzDutY9Cre7spbg',10001,'INACTIVE',NULL,563805107705399091,'SJT','asd@gmail.com','Consumed','2021-02-01 15:00:30','2021-02-01 17:00:30','2021-02-01 15:02:22','2021-02-01 15:02:33'),
(77,'358240051111110','101.85.196.251',10008,'Yes',NULL,'Yes',NULL,'25.0','Credit Card','P203972344954477767','DQQgulRB4ZmsnASGvU4byJaonHeCy6tB90aXaEIZRno0QvvDh1S5CnlNnthv',10001,'INACTIVE',NULL,203972344954477767,'SJT','asd@gmail.com','Consumed','2021-02-01 15:07:33','2021-02-01 17:07:33','2021-02-01 15:08:48','2021-02-01 15:15:47'),
(78,'358240051111110','101.85.196.251',10007,'Yes',NULL,'Yes',NULL,'25.0','Credit Card','P665371141131430037','Hxz6KREE5970YhjoYRJAdEBpfJtf70WdLQP4UVy8YnZkHtMSc6xO9O0Grmd4',10001,'INACTIVE',NULL,665371141131430037,'SJT','asd@gmail.com','Consumed','2021-02-02 00:55:38','2021-02-02 02:55:38','2021-02-02 01:02:41','2021-02-02 01:03:02'),
(79,NULL,'36.141.134.116',10019,NULL,NULL,NULL,NULL,'55.0','Credit Card','P183134571449315449','zFeCmcfHQyQFoiFxeZPnKZHDbzO47pAgm355Vze3ZKCfAQUb1sOeFL0SDJZ0',10001,'ACTIVE',NULL,183134571449315449,'SJT','asd@gmail.com',NULL,'2021-02-02 02:07:32','2021-02-02 04:07:32',NULL,NULL),
(80,'863795034994658','36.141.134.116',10006,'Yes',NULL,'Yes',NULL,'20.0','Credit Card','P998868419029326752','5BhBM5pUXlsLzOoDgKCgg27nNiBtQSSco1IpQoMQTqUGufiobiDggli8RQn9',10001,'INACTIVE',NULL,998868419029326752,'SJT','asd@gmail.com','Consumed','2021-02-02 02:10:48','2021-02-02 04:10:48','2021-02-02 07:14:55','2021-02-02 07:14:56'),
(81,NULL,'199.105.88.140',10007,'Yes',NULL,'Yes',NULL,'25.0','Credit Card','P87754974706723461','5oEFA6QWRC3dtNEBL2RVsk9MJ7mj0cstHzyNGYS1oAPjrZ3auRIorp6WtPaz',10001,'INACTIVE',NULL,87754974706723461,'SJT','asd@gmail.com','Consumed','2021-02-02 03:50:01','2021-02-02 05:50:01','2021-02-02 03:50:53','2021-02-02 03:51:02'),
(82,NULL,'199.105.88.140',10007,'Yes',NULL,'Yes',NULL,'25.0','Credit Card','P174165284159657046','arXs3vW6hCZoXDNWc1jDQrX7hns4SMbE7JqrWSWrgf2O3k2yuOKrJZqgk4FF',10001,'INACTIVE',NULL,174165284159657046,'SJT','asd@gmail.com','Consumed','2021-02-02 03:59:38','2021-02-02 05:59:38','2021-02-02 04:00:29','2021-02-02 04:00:42'),
(83,NULL,'199.105.88.140',10008,'Yes',NULL,'Yes',NULL,'25.0','Credit Card','P59945870455236674','aL3Che8gUs8bbmJSIPirTyla9M8QYBAs49TJJQWWfbfvjelxoZDLmox8pL9F',10001,'INACTIVE',NULL,59945870455236674,'SJT','asd@gmail.com','Consumed','2021-02-02 04:24:29','2021-02-02 06:24:29','2021-02-02 04:24:58','2021-02-02 04:25:48'),
(84,NULL,'199.105.88.140',10009,'Yes',NULL,'Yes',NULL,'30.0','Credit Card','P872756567821474685','k7fXpDzmSsQUoyYvUxbmhUrTbd0KQ94CR6hKg2Ld0XYMUdkYjT3LAW9elMXZ',10001,'INACTIVE',NULL,872756567821474685,'SJT','asd@gmail.com','Consumed','2021-02-02 04:53:12','2021-02-02 06:53:12','2021-02-02 04:54:00','2021-02-02 04:54:20'),
(85,NULL,'199.105.88.140',10007,'Yes',NULL,'Yes',NULL,'25.0','Credit Card','P336992806867769386','S4uk7EolBI04xlWEIChYekrU54VRFIPJbjPYzuTZeLQtG5bYstsMcS8Q0v5i',10001,'INACTIVE',NULL,336992806867769386,'SJT','asd@gmail.com','Consumed','2021-02-02 04:59:30','2021-02-02 06:59:30','2021-02-02 08:48:21','2021-02-02 08:48:35'),
(86,NULL,'199.105.88.140',10004,'Yes',NULL,'Yes',NULL,'16.0','Credit Card','P833429115570889444','TV5A1NQ5EAJxDtiegLdY132gYxjSKbF3Rmo2MtkRTxkVSvZjBzh6yL924NUq',10001,'INACTIVE',NULL,833429115570889444,'SJT','asd@gmail.com','Consumed','2021-02-02 07:09:16','2021-02-02 09:09:16','2021-02-02 07:10:00','2021-02-02 07:10:11'),
(87,NULL,'199.105.88.140',10011,NULL,NULL,NULL,NULL,'38.0','Credit Card','P306065729188484399','PF0fDe1vva5Apvtj1xATaZGPhZaKh3eSMlSNvB9bW0h5R2eDEFhfUNQp7qTL',10002,'ACTIVE',NULL,306065729188484399,'SJT','asd@gmail.com',NULL,'2021-02-02 07:11:14','2021-02-02 09:11:14',NULL,NULL),
(88,NULL,'199.105.88.140',10011,NULL,NULL,NULL,NULL,'38.0','Credit Card','P22186182040448334','9gGI4PU6X2sughGbjmFps7oBEKeyT39D4EGeTARVnGa3H4l3XFPHOPvgUyyG',10002,'ACTIVE',NULL,22186182040448334,'SJT','asd@gmail.com',NULL,'2021-02-02 07:12:30','2021-02-02 09:12:30',NULL,NULL),
(89,'358240051111110','188.194.171.113',10003,NULL,NULL,NULL,NULL,'16.0','Credit Card','P264257923220908117','cSsN2A3HK2DRUuLpOb38JK22UDrEVGjzsEAV5sWVVcYYntklnjRJtvd3xv2h',10001,'ACTIVE',NULL,264257923220908117,'SJT','asd@gmail.com',NULL,'2021-02-02 09:28:37','2021-02-02 11:28:37',NULL,NULL),
(90,'358240051111110','188.194.171.113',10002,NULL,NULL,NULL,NULL,'12.0','Credit Card','P215806323336994057','kTcHFkn8vsGU2z7t0eXQXIbgLiVUvj9GX3NPcaSb4FT7HMYjmiPzoGbLPPHG',10001,'ACTIVE',NULL,215806323336994057,'SJT','asd@gmail.com',NULL,'2021-02-02 09:34:28','2021-02-02 11:34:28',NULL,NULL),
(91,'358240051111110','188.194.171.113',10004,NULL,NULL,NULL,NULL,'16.0','Credit Card','P810076692508971181','XNQNzDISWovraFAq1Nfj3Jq9lvr6tmJPCXUObsTkCtc6UM39sqiRmXo6Q1nG',10001,'ACTIVE',NULL,810076692508971181,'SJT','asd@gmail.com',NULL,'2021-02-02 10:43:41','2021-02-02 12:43:41',NULL,NULL),
(92,'358240051111110','188.194.171.113',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'ACTIVE',NULL,361670993692661173,'Value','asd@gmail.com',NULL,'2021-02-02 12:39:59',NULL,NULL,NULL),
(93,NULL,'150.218.131.240',10009,NULL,NULL,NULL,NULL,'33.0','Credit Card','P482321329491690698','XLgELFd2df5GMuYCbNFyFLajUaP1LtGbB9Aqrbll1GNzjcODF3WEjn40J2qR',10004,'ACTIVE',NULL,482321329491690698,'SJT','samalpramod@gmail.com',NULL,'2021-02-06 13:19:14','2021-02-06 15:19:14',NULL,NULL),
(94,NULL,'219.176.76.113',10009,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,10002,'ACTIVE',NULL,730864721204301806,'SJT','samalpramod@gmail.com',NULL,'2021-02-07 09:32:03',NULL,NULL,NULL),
(95,NULL,'219.176.76.113',10009,NULL,NULL,NULL,NULL,'64.0','Credit Card','P718057603045502770','dNTEt4AISidahVi9PnTfFZYlSzEjPWrZeNsobAn634il5RG3fbOUH4MP97RR',10002,'ACTIVE',NULL,718057603045502770,'SJT','samalpramod@gmail.com',NULL,'2021-02-07 09:33:47','2021-02-07 11:33:47',NULL,NULL),
(96,NULL,'99.241.197.119',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'ACTIVE',NULL,366880932461727143,'Value','samalpramod@gmail.com',NULL,'2021-02-07 09:43:43',NULL,NULL,NULL),
(97,NULL,'199.105.88.140',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'ACTIVE',NULL,304917564641332064,'Value','asd@gmail.com',NULL,'2021-02-07 09:46:43',NULL,NULL,NULL),
(98,NULL,'101.85.196.251',10004,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,10001,'ACTIVE',NULL,521063390383778820,'SJT','asd@gmail.com',NULL,'2021-02-07 12:43:51',NULL,NULL,NULL),
(99,'358240051111110','101.85.196.251',10020,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,10001,'ACTIVE',NULL,963012708052113203,'SJT','asd@gmail.com',NULL,'2021-02-07 13:46:39',NULL,NULL,NULL),
(100,'358240051111110','101.85.196.251',10012,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,10002,'ACTIVE',NULL,638954832532973467,'SJT','asd@gmail.com',NULL,'2021-02-07 13:47:10',NULL,NULL,NULL),
(101,NULL,'199.77.75.0',10020,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,10007,'ACTIVE',NULL,105073250551210282,'SJT','samalpramod@gmail.com',NULL,'2021-02-07 13:59:59',NULL,NULL,NULL),
(102,'358240051111110','188.194.171.113',10002,NULL,NULL,NULL,NULL,'12.0','Credit Card','P32414626394494091','OWOlEct3LLAQici0tRCladWCHAcsVWnMvG5xya8K80hGLvVTHQIu1ONI30Jn',10001,'ACTIVE',NULL,32414626394494091,'SJT','asd@gmail.com',NULL,'2021-02-08 02:05:19','2021-02-08 04:05:19',NULL,NULL),
(103,'358240051111110','188.194.171.113',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'ACTIVE',NULL,757025894837713698,'Value','asd@gmail.com',NULL,'2021-02-08 02:05:33',NULL,NULL,NULL),
(104,'358240051111110','188.194.171.113',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'ACTIVE',NULL,306625529603374386,'Value','asd@gmail.com',NULL,'2021-02-08 02:29:53',NULL,NULL,NULL),
(105,'358240051111110','188.194.171.113',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'ACTIVE',NULL,477654538456743286,'Value','asd@gmail.com',NULL,'2021-02-08 02:31:11',NULL,NULL,NULL),
(106,'358240051111110','188.194.171.113',10002,NULL,NULL,NULL,NULL,'12.0','Credit Card','P26360361623024257','KPqfXa1hy3HqqRF2OhGGoIc4V989XIihnBFTgcRiuhFWlrzJcxpJHXLdtho6',10001,'ACTIVE',NULL,26360361623024257,'SJT','asd@gmail.com',NULL,'2021-02-08 02:35:11','2021-02-08 04:35:11',NULL,NULL),
(107,'860568040633153','41.119.180.67',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'ACTIVE',NULL,355129009710858281,'Value','sarthak@gmail.com',NULL,'2021-02-08 03:20:30',NULL,NULL,NULL),
(108,NULL,'103.166.129.23',10003,NULL,NULL,NULL,NULL,'16.0','Credit Card','P711191007071491090','31H5YLWYlNnL5OgZc6sGm8CKcER2XnVAGL1XKWTZnSKf2JMg9ORhDrHTL42e',10001,'ACTIVE',NULL,711191007071491090,'SJT','asd@gmail.com',NULL,'2021-02-08 03:28:35','2021-02-08 05:28:35',NULL,NULL);

/*Table structure for table `ticket_transaction_data` */

DROP TABLE IF EXISTS `ticket_transaction_data`;

CREATE TABLE `ticket_transaction_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cust_card_id` varchar(255) DEFAULT NULL,
  `dest_stop` varchar(255) DEFAULT NULL,
  `pay_mode` varchar(255) DEFAULT NULL,
  `src_stop` varchar(255) DEFAULT NULL,
  `tkt_amnt` varchar(255) DEFAULT NULL,
  `tot_amnt` varchar(255) DEFAULT NULL,
  `txn_amnt` varchar(255) DEFAULT NULL,
  `txn_id` varchar(255) DEFAULT NULL,
  `txn_start_date_time` varchar(255) DEFAULT NULL,
  `txn_uploa_user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkpyvxlaoj7vs70fodgjnrgg0g` (`txn_uploa_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `ticket_transaction_data` */

/*Table structure for table `transaction_upload_user` */

DROP TABLE IF EXISTS `transaction_upload_user`;

CREATE TABLE `transaction_upload_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bus_no` varchar(255) DEFAULT NULL,
  `bus_service_type` varchar(255) DEFAULT NULL,
  `reader_id` varchar(255) DEFAULT NULL,
  `route` varchar(255) DEFAULT NULL,
  `trip` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `transaction_upload_user` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address1` varchar(255) DEFAULT NULL,
  `address2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `imei` varchar(255) DEFAULT NULL,
  `ipaddress` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `mobile_otp` varchar(255) DEFAULT NULL,
  `mobile_verification_status` varchar(255) DEFAULT NULL,
  `pincode` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r9kvst217faqa7vgeyy51oos0` (`email_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`address1`,`address2`,`city`,`country`,`email_id`,`first_name`,`full_name`,`imei`,`ipaddress`,`last_name`,`mobile`,`mobile_otp`,`mobile_verification_status`,`pincode`,`salt`,`state`,`token`,`user_password`,`user_role`) values 
(1,'xyz','xyz2','Noida','India','nnnnnnn@nextgentele.in','Rudra','Rudra Ram','sdfdsf4sf46546','120.12.12.36','Ram','9678954632','049866','Verified','201301',NULL,'U.P',NULL,'mail@2030','Customer'),
(2,'asd','asd','asd',NULL,'asd@gmail.com','asd','asd asd','358240051111110','101.85.196.251','asd','7042022103','090994','Verified','110058',NULL,'asd','K94xbRpKraNoXQ6Noh1SZOEaRDIOV-YO','123456','Customer'),
(3,NULL,NULL,'',NULL,'asd1@gmail.com','asd','asd asd','358240051111110','101.85.196.251','asd','7894561230','452343','Verified',NULL,NULL,'',NULL,'123456','Customer'),
(4,NULL,NULL,'',NULL,'qwe@gmail.com','qwe','qwe qwe','358240051111110','101.85.196.251','qwe','1234567890','121566','Verified',NULL,NULL,'',NULL,'123456','Customer'),
(5,NULL,NULL,'',NULL,'asd@asd.com','asd','asd asd','358240051111110','101.85.196.251','asd','3698520147','434931','Verified',NULL,NULL,'',NULL,'123456','Customer'),
(6,'xyz','xyz2','Noida','India','xxx@nextgentele.in','Rudra','Rudra Ram','sdfdsf4sf46546','120.12.12.36','Ram','9905607890','367020','Verified','201301',NULL,'U.P',NULL,'mail@2030','Customer'),
(7,NULL,NULL,'',NULL,'fff@ff.com','fff','fff fff','358240051111110','101.85.196.251','fff','7896541230','860389',NULL,NULL,NULL,'',NULL,'123456','Customer'),
(8,NULL,NULL,'',NULL,'qqq@qqq.com','qqq','qqq qqq','358240051111110','101.85.196.251','qqq','1234569870','877148',NULL,NULL,NULL,'',NULL,'123456','Customer'),
(9,NULL,NULL,'',NULL,'subhash@gmail.com','subhash','subhash a','358240051111110','101.85.196.251','a','9876543210','291366','Verified',NULL,NULL,'','NZJb45WQHbxrGtI7cmAxbEB305uzFEWv','123456','Customer'),
(10,NULL,NULL,'',NULL,'qwerty@qwerty.com','qwerty','qwerty qwert','358240051111110','101.85.196.251','qwert','1203654789','726746','Verified',NULL,NULL,'',NULL,'123456','Customer'),
(11,NULL,NULL,'',NULL,'hello@gmail.com','hello','hello hello','358240051111110','101.85.196.251','hello','6541239870','718506','Verified',NULL,NULL,'',NULL,'123456','Customer'),
(12,NULL,NULL,'',NULL,'qwerty@qwery.com','qwer','qwer qwer','358240051111110','101.85.196.251','qwer','7894561231','707094','Verified',NULL,NULL,'',NULL,'123456','Customer'),
(13,NULL,NULL,'',NULL,'samalpramod@gmail.com','Pramod','Pramod Samal',NULL,'85.3.22.244','Samal','9868644189','006094','Verified',NULL,NULL,'','Dyz0l2b6w_HetjHIeD0O0m0GJLU-xaUh','dontopen','Customer'),
(14,NULL,NULL,'',NULL,'qwerty@qwerth.com','qwert','qwert qwert','358240051111110','101.85.196.251','qwert','3216547896','857077','Verified',NULL,NULL,'',NULL,'123456','Customer'),
(15,NULL,NULL,'',NULL,'fdgsfh@gsdf.com','asdfg','asdfg asdfg','358240051111110','188.194.171.113','asdfg','7896541232','555371','Verified',NULL,NULL,'',NULL,'123456','Customer'),
(16,NULL,NULL,'Noida',NULL,'sarthak@gmail.com','Sarthak','Sarthak Singh','860568040633153','41.119.180.67','Singh','7878787879','871967','Verified',NULL,NULL,'Uttar Pradesh',NULL,'itsbusafcs','Customer');

/*Table structure for table `value_ticket_entry_exit_detail` */

DROP TABLE IF EXISTS `value_ticket_entry_exit_detail`;

CREATE TABLE `value_ticket_entry_exit_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `entry_stop_id` varchar(255) DEFAULT NULL,
  `exit_stop_id` varchar(255) DEFAULT NULL,
  `trip_entry_dt_time` datetime DEFAULT NULL,
  `trip_exit_dt_time` datetime DEFAULT NULL,
  `trip_num` varchar(255) DEFAULT NULL,
  `value_tkt_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `value_ticket_entry_exit_detail` */

/*Table structure for table `valueqrticket` */

DROP TABLE IF EXISTS `valueqrticket`;

CREATE TABLE `valueqrticket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` bigint(20) DEFAULT NULL,
  `full_ticket_no` varchar(255) DEFAULT NULL,
  `imei` varchar(255) DEFAULT NULL,
  `ip_address` varchar(255) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `issue_time` varchar(255) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  `qr_ticket_hash` varchar(255) DEFAULT NULL,
  `ticket_id` varchar(255) DEFAULT NULL,
  `ticket_status` varchar(255) DEFAULT NULL,
  `ticket_validity` varchar(255) DEFAULT NULL,
  `entry_count` varchar(255) DEFAULT NULL,
  `exit_count` varchar(255) DEFAULT NULL,
  `issue_date_time` datetime DEFAULT NULL,
  `remaining_value` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `valueqrticket` */

insert  into `valueqrticket`(`id`,`amount`,`full_ticket_no`,`imei`,`ip_address`,`issue_date`,`issue_time`,`payment_mode`,`payment_status`,`qr_ticket_hash`,`ticket_id`,`ticket_status`,`ticket_validity`,`entry_count`,`exit_count`,`issue_date_time`,`remaining_value`) values 
(1,120,'58579116133443300971','358240051111110',NULL,'2020-12-24','','NetBanking','Success','Wqk5xCIUMOHvMxtxKfDE00UbHFXfgnSRM8W7SWPArRgHEjgXLff1SqpCsMLn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2,120,'11951612898565670549','358240051111110',NULL,'2020-12-29','','NetBanking','Success','oY2N52QxJntSstsPy9vW9u4DDg2LcoCFjjQ7qAgOBxqgXpY39RzbWnphiI0e',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(3,100,'15627855729590206314','358240051111110',NULL,'2020-12-29','','NetBanking','Success','xS0afM60tgtaUN7qN1l3YgKtjnJFkagpiIHlNTsbpfVEvl68M96uPYV2yCl5',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(4,100,'96178891638938762021',NULL,NULL,'2020-12-29','','NetBanking','Success','EbgBm1eH7l2YUxceVzvB0fEc5SGlLlZxHzrLLM9tiT5u1CRU2zm0LXQ0Kubt',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(5,130,'58606601974629902696','358240051111110',NULL,'2021-01-08','','NetBanking','Success','QaujCyAM7B0R2PQQHuXy3qiKNXjb7Qx970RPRTT6IzuRasXm2I61Cfao5EVS',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(6,170,'15711422843694449024','358240051111110',NULL,'2021-01-08','','NetBanking','Success','EJYKzUnMxzia6qZURq0zU01SbBMXgL5k6zt3mbeEU3g3nQhpgrPMzGgQvdMA',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(7,150,'29219532158713639254','358240051111110',NULL,'2021-01-08','','NetBanking','Success','7Lp8rjCt145xGukc3BLZoj5HFKYvYbdSftlPA9vc0zpBddvIMrSrE9uZ9cUV',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(8,180,'42591882406902575584','358240051111110',NULL,'2021-01-08','','NetBanking','Success','VDu7W35Avhk2t3NAWi4g5po5nvIxQPLZCGdKCrucbejKKj5ff7fbb2ONYkZy',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(9,170,'90244862116112065562','358240051111110',NULL,'2021-02-02','','NetBanking','Success','VUvs9caAeQ9TprMMscZgg5cbf9fGEaLOVfViJxXtT3ZMBylMX0CZP8lfrmpe',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(10,500,'81325699026801548834','1464654654SEDFR',NULL,NULL,NULL,'NetBanking','Success','ekzll4jN6M2kKtznL8ZjCzJIvdtTLX2T6jBy5hur2gzTzEUkj9LduanElNt2',NULL,'ACTIVE',NULL,NULL,NULL,'2021-02-07 09:04:04',500),
(11,100,'73503898482863784298',NULL,NULL,NULL,NULL,'NetBanking','Success','WFF4iWV9BFpb7M3him4iQKojmijNAOeJ4mg2mYSmZfUgJnNGbmhAAxs8dXxj',NULL,'ACTIVE',NULL,NULL,NULL,'2021-02-07 09:43:43',100),
(12,120,'76511347231251880431',NULL,NULL,NULL,NULL,'NetBanking','Success','hMvuT3eSrtIWHRvHZlMeDqrE17DQizQ4jWZouich9dS615noGQXpSnRRTVgt',NULL,'ACTIVE',NULL,NULL,NULL,'2021-02-07 09:46:43',120),
(13,120,'99253176609383229298','358240051111110',NULL,NULL,NULL,'NetBanking','Success','4dvcogWxKdeKDDhhItkTxyI517F3OCdJCWHbtmho2MjzU0yuL6LSsnXAFEfH',NULL,'ACTIVE',NULL,NULL,NULL,'2021-02-08 02:05:34',120),
(14,20,'26699668053923683896','358240051111110',NULL,NULL,NULL,'NetBanking','Success','qlatAv7TltejtMGuclJ5vHLU00QAteJMhWQ5IOtAogvdjP4GOQQxHCZfJoHU',NULL,'ACTIVE',NULL,NULL,NULL,'2021-02-08 02:29:53',20),
(15,20,'58586689202374374323','358240051111110',NULL,NULL,NULL,'NetBanking','Success','OGkNvAXFqUXhJ7HhojOKChrKleETqNzzHI9e4cMPWOFMMVZtz5FecFjtHach',NULL,'ACTIVE',NULL,NULL,NULL,'2021-02-08 02:31:11',20),
(16,100,'58282082966531645374','860568040633153',NULL,NULL,NULL,'NetBanking','Success','bEiy3XrrRMttisJU7xJaibPWbjHvMPt6G9TjuQfpcP8KanJp3HUm4jibV1EQ',NULL,'ACTIVE',NULL,NULL,NULL,'2021-02-08 03:20:30',100);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
