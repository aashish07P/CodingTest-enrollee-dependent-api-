CREATE TABLE `enrollees` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `activation` tinyint(4) DEFAULT NULL,
  `dob` varchar(45) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE `dependents` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `dob` varchar(45) DEFAULT NULL,
  `enrollee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_enrollee_idx` (`enrollee_id`),
  CONSTRAINT `FK11t7aucghlm28fxnovyefkg6t` FOREIGN KEY (`enrollee_id`) REFERENCES `enrollees` (`id`)
) 
