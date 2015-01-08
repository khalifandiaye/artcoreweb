-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.31-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema bdd_cb_artcore
--

CREATE DATABASE IF NOT EXISTS bdd_cb_artcore;
USE bdd_cb_artcore;

--
-- Definition of table `cartebleue`
--

DROP TABLE IF EXISTS `cartebleue`;
CREATE TABLE `cartebleue` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `numero` varchar(16) NOT NULL,
  `expiration` datetime NOT NULL,
  `cryptogramme` varchar(3) NOT NULL,
  `IDEtatCarte` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_cartebleue_ETAT` (`IDEtatCarte`) USING BTREE,
  CONSTRAINT `FK_cartebleue` FOREIGN KEY (`IDEtatCarte`) REFERENCES `etatcarte` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartebleue`
--

/*!40000 ALTER TABLE `cartebleue` DISABLE KEYS */;
INSERT INTO `cartebleue` (`id`,`numero`,`expiration`,`cryptogramme`,`IDEtatCarte`) VALUES 
 (1,'1234567890123456','2015-12-00 00:00:00','123',1),
 (2,'4321432143214321','2015-12-00 00:00:00','321',2),
 (3,'1234123412341234','2015-12-00 00:00:00','123',3);
/*!40000 ALTER TABLE `cartebleue` ENABLE KEYS */;


--
-- Definition of table `etatcarte`
--

DROP TABLE IF EXISTS `etatcarte`;
CREATE TABLE `etatcarte` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `libelleEtatCarte` varchar(45) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `etatcarte`
--

/*!40000 ALTER TABLE `etatcarte` DISABLE KEYS */;
INSERT INTO `etatcarte` (`id`,`libelleEtatCarte`) VALUES 
 (1,'volee'),
 (2,'perdue'),
 (3,'bloquee');
/*!40000 ALTER TABLE `etatcarte` ENABLE KEYS */;

--
-- Create schema bdd_police_artcore
--

CREATE DATABASE IF NOT EXISTS bdd_police_artcore;
USE bdd_police_artcore;

--
-- Definition of table `statut`
--

DROP TABLE IF EXISTS `statut`;
CREATE TABLE `statut` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `libelle` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `statut`
--

/*!40000 ALTER TABLE `statut` DISABLE KEYS */;
INSERT INTO `statut` (`id`,`libelle`) VALUES 
 (1,'vol'),
 (2,'recel'),
 (3,'trafic'),
 (4,'drogue'),
 (5,'viol'),
 (6,'usurpateur');
/*!40000 ALTER TABLE `statut` ENABLE KEYS */;


--
-- Definition of table `suspect`
--

DROP TABLE IF EXISTS `suspect`;
CREATE TABLE `suspect` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `date_naissance` datetime NOT NULL,
  `id_statut` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_suspect` (`id_statut`),
  CONSTRAINT `FK_suspect` FOREIGN KEY (`id_statut`) REFERENCES `statut` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `suspect`
--

/*!40000 ALTER TABLE `suspect` DISABLE KEYS */;
INSERT INTO `suspect` (`id`,`nom`,`prenom`,`date_naissance`,`id_statut`) VALUES 
 (1,'BABA','ALI','1980-01-01 00:00:00',1),
 (2,'POIVRET','SEL','1980-01-01 00:00:00',2),
 (3,'TRAFIC','INFO','1980-01-01 00:00:00',3),
 (4,'LAPICOUZ','RENEE','1980-01-01 00:00:00',4),
 (5,'GEORGES','GUY','1980-01-01 00:00:00',5),
 (6,'MESRINE','JACQUES','1980-01-01 00:00:00',6);
/*!40000 ALTER TABLE `suspect` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
