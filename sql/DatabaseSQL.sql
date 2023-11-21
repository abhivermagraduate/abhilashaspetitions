/*
SQLyog Community v12.09 (64 bit)
MySQL - 10.6.16-MariaDB : Database - adaptass_petition
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`adaptass_petition` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;

USE `adaptass_petition`;

/*Table structure for table `petition` */

DROP TABLE IF EXISTS `petition`;

CREATE TABLE `petition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `petition_text` blob DEFAULT NULL,
  `create_date_time` timestamp NULL DEFAULT NULL,
  `petition_scope` varchar(255) DEFAULT NULL,
  `geographic_area` varchar(255) DEFAULT NULL,
  `petition_title` varchar(255) DEFAULT NULL,
  `image_id` varchar(255) DEFAULT NULL,
  `signature_goal_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `petition_signature` */

DROP TABLE IF EXISTS `petition_signature`;

CREATE TABLE `petition_signature` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `create_date_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `petition_id` int(11) DEFAULT NULL,
  `petition_win_notification` tinyint(1) DEFAULT NULL,
  `petition_progress_notification` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `petition_sign_fk` (`petition_id`),
  CONSTRAINT `petition_sign_fk` FOREIGN KEY (`petition_id`) REFERENCES `petition` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
