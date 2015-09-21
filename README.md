Skeleton dropwizard app for checking in and out textbooks.


Configure db settings in configuration.yml

Currently using a v basic, one table db - something like:

DROP TABLE IF EXISTS `Books`;

CREATE TABLE `Books` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(150) DEFAULT '',
  `author` varchar(150) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Books` WRITE;
/*!40000 ALTER TABLE `Books` DISABLE KEYS */;

INSERT INTO `Books` (`id`, `title`, `author`)
VALUES
	(1,'Eloquent Javascript','Marijn Haverbeke'),
	(2,'Head First Java','A Smith');

/*!40000 ALTER TABLE `Books` ENABLE KEYS */;
UNLOCK TABLES;


#Run:
- ./gradlew
- ./gradlew run

