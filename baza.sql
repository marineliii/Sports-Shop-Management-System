/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 10.4.27-MariaDB : Database - prodavnica
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prodavnica` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `prodavnica`;

/*Table structure for table `artikal` */

DROP TABLE IF EXISTS `artikal`;

CREATE TABLE `artikal` (
  `artikalID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) NOT NULL,
  `cenaArtikla` double unsigned NOT NULL,
  `tip` varchar(100) NOT NULL,
  PRIMARY KEY (`artikalID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `artikal` */

insert  into `artikal`(`artikalID`,`naziv`,`cenaArtikla`,`tip`) values 
(1,'Adidas STABIL NEXT GEN',15199,'Obuca'),
(2,'Nike JHN BASKETBALL 2PK CREW',1599,'Oprema'),
(3,'RUKOMETNA LOPTA ULTIMATE REPLICA V22',5500,'Lopte'),
(8,'adidas Dukserica Z.N. E. Premium',9090,'Odeca'),
(9,'Cunjevi set 5kom.',3100,'Rekviziti'),
(10,'Energetics STRENGTH BANDS 2.0, fitnes traka',719,'Rekviziti'),
(11,'LEPAK ZA RUKOMETNE LOPTE PROFCARE 500ML',4800,'Rekviziti');

/*Table structure for table `kupac` */

DROP TABLE IF EXISTS `kupac`;

CREATE TABLE `kupac` (
  `kupacID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(100) NOT NULL,
  `prezime` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `kontaktTelefon` varchar(100) NOT NULL,
  PRIMARY KEY (`kupacID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `kupac` */

insert  into `kupac`(`kupacID`,`ime`,`prezime`,`email`,`kontaktTelefon`) values 
(1,'Filip','Petrovic','fp@gmail.com','0621145252'),
(2,'Marko','Petrovic','mp@gmail.com','0693536466'),
(3,'Andja','Rakonjac','ar@email.com','0612589632'),
(5,'Milan','Milovanovic','miki@gmail.com','0614171828'),
(6,'Milan','Milovanovic','d@d.com','065811'),
(7,'Milica','Stepancic','ms@sms.ms','062445789'),
(8,'dkásl','psijadpa','kor@gmail.com','0500002130'),
(9,'gf','rrd','hbhh@d.com','2563325'),
(10,'Petar','Nikodijevic','pera123@hotmail.com','0612305469'),
(11,'Isidora','Bogavac','isidoradod@gmail.com','0693324508'),
(12,'Zorana ','Marinkovic','zor3mar@gmail.com','063213815');

/*Table structure for table `porudzbenica` */

DROP TABLE IF EXISTS `porudzbenica`;

CREATE TABLE `porudzbenica` (
  `porudzbenicaID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `datumOd` date NOT NULL,
  `datumDo` date NOT NULL,
  `ukupnaCena` double unsigned NOT NULL,
  `kupacID_fk` int(10) unsigned NOT NULL,
  `radnikID_fk` int(10) unsigned NOT NULL,
  PRIMARY KEY (`porudzbenicaID`),
  KEY `kupac_ID_fk` (`kupacID_fk`),
  KEY `radnik_ID_fk` (`radnikID_fk`),
  CONSTRAINT `kupac_ID_fk` FOREIGN KEY (`kupacID_fk`) REFERENCES `kupac` (`kupacID`) ON UPDATE CASCADE,
  CONSTRAINT `radnik_ID_fk` FOREIGN KEY (`radnikID_fk`) REFERENCES `radnik` (`radnikID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `porudzbenica` */

insert  into `porudzbenica`(`porudzbenicaID`,`datumOd`,`datumDo`,`ukupnaCena`,`kupacID_fk`,`radnikID_fk`) values 
(18,'2024-01-24','2024-01-26',113119.9293,1,4),
(22,'2024-01-27','2024-01-28',5280,1,1),
(23,'2024-01-27','2024-01-28',14844.5,7,1),
(24,'2024-01-28','2024-02-03',9999,11,1),
(25,'2024-01-29','2024-01-31',17050,3,1),
(26,'2024-01-29','2024-02-03',20358.9,11,1);

/*Table structure for table `preporuka` */

DROP TABLE IF EXISTS `preporuka`;

CREATE TABLE `preporuka` (
  `artikalID` int(10) unsigned NOT NULL,
  `radnikID` int(10) unsigned NOT NULL,
  `ocena` int(2) unsigned NOT NULL,
  `komentar` varchar(1000) NOT NULL,
  KEY `artikalID` (`artikalID`),
  KEY `radnikID` (`radnikID`),
  CONSTRAINT `artikalID_SO` FOREIGN KEY (`artikalID`) REFERENCES `artikal` (`artikalID`) ON UPDATE CASCADE,
  CONSTRAINT `radnikID_SO` FOREIGN KEY (`radnikID`) REFERENCES `radnik` (`radnikID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `preporuka` */

insert  into `preporuka`(`artikalID`,`radnikID`,`ocena`,`komentar`) values 
(3,1,9,'Lopta visokog kvaliteta, pogodna za travu, a moze se koristiti i po betonu ili parketu'),
(1,1,8,'Odlicne rukometne patike'),
(2,1,10,'Izuzetno kvalitetne sportske carape'),
(10,1,3,'Postoje i bolje tranke koje rukometasi mogu da koriste za zagrevanje'),
(8,1,10,'Realno kida duks');

/*Table structure for table `radnik` */

DROP TABLE IF EXISTS `radnik`;

CREATE TABLE `radnik` (
  `radnikID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(100) NOT NULL,
  `prezime` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `kontaktTelefon` varchar(100) NOT NULL,
  `korisnickoIme` varchar(100) NOT NULL,
  `lozinka` varchar(100) NOT NULL,
  `ulogovan` tinyint(1) DEFAULT NULL,
  `obrisan` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`radnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `radnik` */

insert  into `radnik`(`radnikID`,`ime`,`prezime`,`email`,`kontaktTelefon`,`korisnickoIme`,`lozinka`,`ulogovan`,`obrisan`) values 
(1,'Veljko','Marinkovic','marin@gmail.com','0600357372','marin','marin',0,0),
(2,'Pera','Peric','pera@gmail.com','062535595','pera','12345',0,0),
(3,'Milenko','Milenkovic','milen@gm.com','03254851','mile','mile1',0,1),
(4,'Dodat','Radnik','test@hotmail.com','050002012','test','test123',0,0);

/*Table structure for table `stavkaporudzbenice` */

DROP TABLE IF EXISTS `stavkaporudzbenice`;

CREATE TABLE `stavkaporudzbenice` (
  `stavkaID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `porudzbenicaID` int(10) unsigned NOT NULL,
  `iznosStavke` double unsigned NOT NULL,
  `cenaArtikla` double unsigned NOT NULL,
  `pdv` double unsigned NOT NULL,
  `kolicina` int(10) unsigned NOT NULL,
  `artikalID_fk` int(10) unsigned NOT NULL,
  PRIMARY KEY (`stavkaID`,`porudzbenicaID`),
  KEY `porudzbenicaID` (`porudzbenicaID`),
  KEY `artikal_id_fk` (`artikalID_fk`),
  CONSTRAINT `artikal_id_fk` FOREIGN KEY (`artikalID_fk`) REFERENCES `artikal` (`artikalID`) ON UPDATE CASCADE,
  CONSTRAINT `porudzbenicaID_SO` FOREIGN KEY (`porudzbenicaID`) REFERENCES `porudzbenica` (`porudzbenicaID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `stavkaporudzbenice` */

insert  into `stavkaporudzbenice`(`stavkaID`,`porudzbenicaID`,`iznosStavke`,`cenaArtikla`,`pdv`,`kolicina`,`artikalID_fk`) values 
(43,18,16159.9899,15999.99,1,1,1),
(44,18,16159.9899,15999.99,1,1,1),
(45,18,16159.9899,15999.99,1,1,1),
(46,18,16159.9899,15999.99,1,1,1),
(47,18,16159.9899,15999.99,1,1,1),
(55,22,5280,4800,10,1,11),
(56,23,1758.9,1599,10,1,2),
(57,23,7035.6,1599,10,4,2),
(58,23,6050.000000000001,5500,10,1,3),
(59,24,9999,9090,10,1,8),
(60,25,17050,3100,10,5,9),
(61,26,1758.9,1599,10,1,2),
(62,26,18600,3100,20,5,9);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
