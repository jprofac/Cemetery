CREATE DATABASE  IF NOT EXISTS `proiectcolectiv`;
USE `proiectcolectiv`;

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `proiectcolectiv`.`user` (`id`, `firstname`, `lastname`, `username`, `password`, `type`) VALUES ('1', 'Admin', '1', 'admin', 'admin', '0');

DROP TABLE IF EXISTS `Cemetery`;
CREATE TABLE `Cemetery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `valid` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Parcel`;
CREATE TABLE `Parcel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `cemeteryId` int(11) NOT NULL,
  `valid` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`cemeteryId`) REFERENCES Cemetery(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Owner`;
CREATE TABLE `Owner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `domicile` varchar(45) DEFAULT NULL,
  `valid` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Observation`;
CREATE TABLE `Observation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tomb` boolean DEFAULT false,
  `modificationNr` int(11) DEFAULT NULL,
  `photography` varchar(45) DEFAULT NULL,
  `valid` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Grave`;
CREATE TABLE `Grave` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parcelId` int(11) NOT NULL,
  `surface` int(11) NOT NULL,
  `observationId` int(11) NOT NULL,
  `isMonument` tinyint(1) DEFAULT 0,
  `valid` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`parcelId`) REFERENCES Parcel(id),
  FOREIGN KEY (`observationId`) REFERENCES Observation(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Deceased`;
CREATE TABLE `Deceased` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `religion` varchar(45) DEFAULT NULL,
  `graveId` int(11) NOT NULL,
  `burialDate` datetime DEFAULT NULL,
  `valid` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`graveId`) REFERENCES Grave(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Complainer`;
CREATE TABLE `Complainer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `reason` varchar(45) DEFAULT NULL,
  `valid` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Contract`;
CREATE TABLE `Contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ownerId` int(11) NOT NULL,
  `graveId` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `period` int(11) DEFAULT NULL,  
  `receipt` int(11) DEFAULT NULL,
  `valid` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`ownerId`) REFERENCES Owner(id),
  FOREIGN KEY (`graveId`) REFERENCES Grave(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Request`;
CREATE TABLE `Request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(45) DEFAULT NULL,
  `infocet` int(11) DEFAULT NULL,
  `completed` boolean DEFAULT false,
  `valid` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `CemeteryHistory`;
CREATE TABLE `CemeteryHistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `ParcelHistory`;
CREATE TABLE `ParcelHistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `cemeteryId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`cemeteryId`) REFERENCES Cemetery(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `OwnerHistory`;
CREATE TABLE `OwnerHistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `domicile` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `ObservationHistory`;
CREATE TABLE `ObservationHistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tomb` boolean DEFAULT false,
  `modificationNr` int(11) DEFAULT NULL,
  `photography` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `GraveHistory`;
CREATE TABLE `GraveHistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parcelId` int(11) NOT NULL,
  `surface` int(11) NOT NULL,
  `observationId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`parcelId`) REFERENCES Parcel(id),
  FOREIGN KEY (`observationId`) REFERENCES Observation(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `DeceasedHistory`;
CREATE TABLE `DeceasedHistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `religion` varchar(45) DEFAULT NULL,
  `graveId` int(11) NOT NULL,
  `burialDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`graveId`) REFERENCES Grave(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `ComplainerHistory`;
CREATE TABLE `ComplainerHistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `reason` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `ContractHistory`;
CREATE TABLE `ContracHistoryt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ownerId` int(11) NOT NULL,
  `graveId` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `period` int(11) DEFAULT NULL,  
  `receipt` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`ownerId`) REFERENCES Owner(id),
  FOREIGN KEY (`graveId`) REFERENCES Grave(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `RequestHistory`;
CREATE TABLE `RequestHistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(45) DEFAULT NULL,
  `infocet` int(11) DEFAULT NULL,
  `completed` boolean DEFAULT false,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `UserHistory`;
CREATE TABLE `UserHistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into cemetery(name, address) values ("Cimitirul Militar","Drumul Pepiniera");
insert into cemetery(name, address) values  ("Cimitirul Eroilor","Calea Turzii");
insert into cemetery(name, address) values ("Cimitirul Central", "Strada Avram Iancu");
insert into cemetery(name, address) values ("Cimitirul Evreiesc", "Strada Aviator Badescu");

insert into parcel(code,cemeteryId) values("MIL01",1);
insert into parcel(code,cemeteryId) values("MIL02",1);
insert into parcel(code,cemeteryId) values("MIL03",1);
insert into parcel(code,cemeteryId) values("MIL04",1);
insert into parcel(code,cemeteryId) values("MIL05",1);
insert into parcel(code,cemeteryId) values("ERO01",2);
insert into parcel(code,cemeteryId) values("ERO02",2);
insert into parcel(code,cemeteryId) values("ERO03",2);
insert into parcel(code,cemeteryId) values("ERO04",2);
insert into parcel(code,cemeteryId) values("ERO05",2);
insert into parcel(code,cemeteryId) values("CEN01",3);
insert into parcel(code,cemeteryId) values("CEN02",3);
insert into parcel(code,cemeteryId) values("CEN03",3);
insert into parcel(code,cemeteryId) values("CEN04",3);
insert into parcel(code,cemeteryId) values("CEN05",3);
insert into parcel(code,cemeteryId) values("EVR01",4);
insert into parcel(code,cemeteryId) values("EVR02",4);

insert  into observation (tomb, modificationNr,photography) values (true,1,"bgb");
insert  into observation (tomb, modificationNr,photography) values (true,2,"vfvd");
insert  into observation (tomb, modificationNr,photography) values (true,3,"vdfv");
insert  into observation (tomb, modificationNr,photography) values (true,4,"xoox");
insert  into observation (tomb, modificationNr,photography) values (true,5,"gfbb");

insert into grave (parcelId,surface,observationId,isMonument) values (1,5,1,false);
insert into grave (parcelId,surface,observationId,isMonument) values (2,5,2,false);
insert into grave (parcelId,surface,observationId,isMonument) values (3,5,3,true);
insert into grave (parcelId,surface,observationId,isMonument) values (4,5,4,false);
insert into grave (parcelId,surface,observationId,isMonument) values (5,5,5,false);

insert into deceased(firstName,lastName,religion,graveId,burialDate) values ("Marian","Alexandru","Baprist",1,"2012-03-25");
insert into deceased(firstName,lastName,religion,graveId,burialDate) values ("Bogdan","Muresan","Ortodox",2,"2011-03-25");
insert into deceased(firstName,lastName,religion,graveId,burialDate) values ("Aurel","Popescu","Reformat",3,"2010-03-25");
insert into deceased(firstName,lastName,religion,graveId,burialDate) values ("Ioana","Pop","Ortodox",4,"2013-03-25");
insert into deceased(firstName,lastName,religion,graveId,burialDate) values ("Alexandra","Ionescu","Ortodox",5,"2015-01-02");


