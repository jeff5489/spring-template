USE `testing`;

DROP TABLE IF EXISTS `people`;

CREATE TABLE `people` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `job` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- INSERT INTO `people` VALUES 
-- 	(1,'David','Adams','Astronaunt'),
-- 	(2,'John','Doe','Ditch Digger'),
-- 	(3,'Ajay','Rao','Professor of Mathematics'),
-- 	(4,'Mary','Public','Dish Washer'),
-- 	(5,'Maxwell','Dixon','Circus Performer');
    
INSERT INTO people (first_name, last_name, job)
VALUES ('David','Adams','Astronaunt'),
	('John','Doe','Ditch Digger'),
	('Ajay','Rao','Professor of Mathematics'),
	('Mary','Public','Dish Washer'),
	('Maxwell','Dixon','Circus Performer');
