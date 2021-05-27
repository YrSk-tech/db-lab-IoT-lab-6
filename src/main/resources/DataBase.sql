CREATE SCHEMA IF NOT EXISTS `syvak_lab` DEFAULT CHARACTER SET utf8;
USE `syvak_lab` ;

DROP TABLE IF EXISTS `syvak_lab`.`award`;
DROP TABLE IF EXISTS `syvak_lab`.`review_agency`;
DROP TABLE IF EXISTS `syvak_lab`.`review_animator`;
DROP TABLE IF EXISTS `syvak_lab`.`holiday`;
DROP TABLE IF EXISTS `syvak_lab`.`agency_has_custom`;
DROP TABLE IF EXISTS `syvak_lab`.`discounts`;
DROP TABLE IF EXISTS `syvak_lab`.`agency`;
DROP TABLE IF EXISTS `syvak_lab`.`custom_has_animator`;
DROP TABLE IF EXISTS `syvak_lab`.`custom`;
DROP TABLE IF EXISTS `syvak_lab`.`animator`;

CREATE TABLE IF NOT EXISTS `syvak_lab`.`animator` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `syvak_lab`.`custom` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` VARCHAR(45) NOT NULL,
  `duration_in_hours` INT NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `cost_in_uah` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `syvak_lab`.`custom_has_animator` (
  `custom_id` INT NOT NULL,
  `animator_id` INT NOT NULL,
  PRIMARY KEY (`custom_id`, `animator_id`),
  INDEX `fk_custom_has_animator_animator1_idx` (`animator_id` ASC) ,
  INDEX `fk_custom_has_animator_custom1_idx` (`custom_id` ASC) )
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `syvak_lab`.`agency` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `phone_number` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `syvak_lab`.`agency_has_custom` (
  `agency_id` INT NOT NULL,
  `custom_id` INT NOT NULL,
  PRIMARY KEY (`agency_id`, `custom_id`),
  INDEX `fk_agency_has_custom_custom1_idx` (`custom_id` ASC) ,
  INDEX `fk_agency_has_custom_agency1_idx` (`agency_id` ASC) )
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `syvak_lab`.`holiday` (
  `id` INT NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `number_of_animators` INT NOT NULL,
  `number_of_participants` INT NOT NULL,
  `custom_id` INT NOT NULL,
  PRIMARY KEY (`id`, `custom_id`),
  INDEX `fk_holiday_custom1_idx` (`custom_id` ASC) )
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `syvak_lab`.`review_animator` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `author` VARCHAR(45) NOT NULL,
  `text` VARCHAR(45) NOT NULL,
  `animator_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_review_animator_animator1_idx` (`animator_id` ASC) )
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `syvak_lab`.`review_agency` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `author` VARCHAR(45) NOT NULL,
  `text` VARCHAR(45) NOT NULL,
  `agency_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_review_agency_agency1_idx` (`agency_id` ASC) )
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `syvak_lab`.`award` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `year` INT NOT NULL,
  `nomination` VARCHAR(45) NOT NULL,
  `agency_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_award_agency1_idx` (`agency_id` ASC) )
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `syvak_lab`.`discounts` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `cost` FLOAT NOT NULL,
  `agency_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_discounts_agency1_idx` (`agency_id` ASC) )
ENGINE = InnoDB;
ALTER TABLE syvak_lab.custom_has_animator
	    ADD CONSTRAINT `fk_custom_has_animator_custom1`
    FOREIGN KEY (`custom_id`)
    REFERENCES `syvak_lab`.`custom` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
        ADD CONSTRAINT `fk_custom_has_animator_animator1`
    FOREIGN KEY (`animator_id`)
    REFERENCES `syvak_lab`.`animator` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE syvak_lab.agency_has_custom
	ADD CONSTRAINT `fk_agency_has_custom_agency1`
    FOREIGN KEY (`agency_id`)
    REFERENCES `syvak_lab`.`agency` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
	ADD CONSTRAINT `fk_agency_has_custom_custom1`
    FOREIGN KEY (`custom_id`)
    REFERENCES `syvak_lab`.`custom` (`id`)
	ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE syvak_lab.holiday
	ADD CONSTRAINT `fk_holiday_custom1`
    FOREIGN KEY (`custom_id`)
    REFERENCES `syvak_lab`.`custom` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE syvak_lab.review_animator
	ADD CONSTRAINT `fk_review_animator_animator1`
    FOREIGN KEY (`animator_id`)
    REFERENCES `syvak_lab`.`animator` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE syvak_lab.review_agency
	ADD CONSTRAINT `fk_review_agency_agency1`
    FOREIGN KEY (`agency_id`)
    REFERENCES `syvak_lab`.`agency` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE syvak_lab.award
	ADD CONSTRAINT `fk_award_agency1`
    FOREIGN KEY (`agency_id`)
    REFERENCES `syvak_lab`.`agency` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE syvak_lab.discounts
	ADD CONSTRAINT `fk_discounts_agency1`
    FOREIGN KEY (`agency_id`)
    REFERENCES `syvak_lab`.`agency` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

INSERT INTO `syvak_lab`.`animator`(`id`, `name`, `surname`, `last_name`, `age`)
	VALUES('1',	'Petro',	'Petrenko',	'Ivanovuch',	'23'),
	('2', 'Ivan',	'Rosh',	'Bogdanovuch',	'21' ),
    ('3', 'Bogdan',	'Gid',	'Dmutrovuch',	'19'),
    ('4', 'Yuriy',	'Rasid',	'Rustamovuch',	'18'),
    ('5', 'Roman',	'Pora',	'Ivanovuch', 	'20'),
    ('6', 'Vasyl',	'Baran',	'Petrenko',	'23'),
    ('7', 'Bolodia',	'Rushiy',	'Dmutrovuch',	'22'),
    ('8', 'Marko',	'Siba',	'Vitaliyovuch',	'21'),
    ('9', 'Maksym',	'Dorosh',	'Maksumovuch',	'24'),
    ('10', 'Vitaliy',	'Roshi',	'Romanovuch',	'23');

INSERT INTO custom(id, date, duration_in_hours, address, cost_in_uah)
	VALUES('1',	'2020-09-20 00:00:00',	'4',	'Shevchenka 10',	'3500'),
	('2','2020-05-10 00:00:00',	'3',	'Zelena 5',	'3000'),
    ('3','2020-12-03 00:00:00',	'2',	'Zelena 30',	'2500'),
    ('4','2020-10-14 00:00:00', '3',	'Levandivka 3',	'3000'),
    ('5','2020-06-18 00:00:00',	'1',	'Lisna 10',	'2000' ),
    ('6','2020-09-03 00:00:00',	'1',	'Litnia 15',	'2000'),
    ('7','2020-04-02 00:00:00',	'4',	'Orna 25',	'3500'),
    ('8','2020-07-20 00:00:00',	'3',	'Pisha 32',	'3000'),
    ('9','2020-03-03 00:00:00',	'2',	'Plastova 41',	'2500'),
    ('10','2020-03-15 00:00:00',	'3',	'Promuslova 18',	'3000');

INSERT INTO custom_has_animator(custom_id,animator_id)
	VALUES('1', '1'),
    ('2', '2'),
    ('3', '3'),
    ('4', '4'),
    ('5', '5'),
    ('6', '6'),
    ('7', '7'),
    ('8', '8'),
    ('9', '9'),
    ('10', '10');

INSERT INTO agency(id, name, phone_number)
	VALUES('1',	'Party',	'0935457231'),
    ('2',	'Party2',	'0965734324'),
    ('3',	'Party3',	'0956733546'),
    ('4',	'Party4',	'0635647754'),
    ('5',	'Party5',	'0987653843'),
    ('6',	'party6',	'0932456094'),
    ('7',	'Party7',	'0974532345'),
    ('8',	'Party8',	'0964563054'),
    ('9',	'Party9',	'0325465431'),
    ('10',	'Party10',	'0964322325');


INSERT INTO agency_has_custom(agency_id, custom_id)
	VALUES('9', '1'),
    ('6', '2'),
    ('7', '3'),
    ('8', '4'),
    ('10', '5'),
    ('1', '6'),
    ('2', '7'),
    ('3', '8'),
    ('4', '9'),
    ('5', '10');

INSERT INTO holiday(id, type, number_of_animators, number_of_participants, custom_id)
	VALUES('1',	'Weeding',	'2',	'50', '3'),
    ('2',	'Birthday',	'3',	'70', '4'),
    ('3',	'Weeding',	'1',	'30', '6'),
    ('4',	'Birthday',	'1',	'42',  '7'),
    ('5',	'Weeding',	'3',	'54', '8'),
    ('6',	'Weeding',	'2',	'37', '9'),
    ('7',	'Weeding',	'2',	'48', '10'),
    ('8',	'Birthday',	'1',	'29', '1'),
    ('9',	'Birthday',	'4',	'73','2'),
    ('10',  'Birthday',	'4',	'74', '5');

INSERT INTO review_animator(id, author, text, animator_id)
    VALUES('1', 'Mark',	'Good animator for birthday','1'),
    ('2','Dima',	'Good animator for weeding',	'2'),
    ('3','Roman',	'Good animator for birthday',	'3'),
    ('4','Petro',	'Good animator for weeding',	'4'),
    ('5','Vital',	'Good animator for birthday',	'5'),
    ('6','Andriy',	'Good animator for weeding',	'6'),
    ('7','Vitaliy',	'Good animator for birthday',	'7'),
    ('8','Dmytro',	'Good animator for weeding',	'8'),
    ('9','Poma',	'Good animator for weeding',	'9'),
    ('10','Markian',	'Good animator for birthday',	'10');

INSERT INTO review_agency(id, author, text, agency_id)
	VALUES('1','Lise',	'good agency',	'1'),
    ('2','Barry',	'well done',	'2'),
    ('3','Paul',	'goood',	'3'),
    ('4','Pattew',	'cool',		'4'),
    ('5','Ivan',	'well',		'5'),
    ('6','Borus',	'normal',	'6'),
    ('7','Dmytro',	'good',		'7'),
    ('8','Lesia',	'well',		'8'),
    ('9','Taras',	'cool',		'9'),
    ('10','Fedir',	'not bad',		'10');

INSERT INTO award(id, name, year, nomination, agency_id)
	VALUES('1',	'Checking Company',	'2020',	'The best entartaiment 2020',	'1'),
    ('2',	'Checking Company 2',	'2018',	'The best  entartaiment 2018',	'1'),
    ('3',	'Checking Company 3',	'2016',	'The best  entartaiment 2016',	'3'),
    ('4',	'Checking Company 4',	'2016',	'The best  entartaiment 2016,2',	'2'),
    ('5',	'Checking Company 5',	'2020',	'The best  entartaiment 5',	'4'),
    ('6',	'Checking Company 6',	'2018',	'The best  entartaiment 6',	'2'),
    ('7',	'Checking Company 8',	'2019',	'The best  entartaiment 7',	'6'),
    ('8',	'Checking Company 9',	'2020',	'The best  entartaiment 8',	'8'),
    ('9',	'Checking Company 8',	'2016',	'The best  entartaiment 9',	'7'),
    ('10',	'Checking Company 10',	'2017',	'The best  entartaiment 2017',	'10');

INSERT INTO discounts(id, name, cost, agency_id)
	VALUES('1', 'For Hollidays', 	'2999',	'1'),
    ('2',		'For Birthday',		'1999',	'2'),
    ('3',		'For Birthday',		'1499',	'4'),
    ('4',		'For Wedding',		'2999',	'5'),
    ('5',		'For Hollidays', 	'2999',	'3'),
    ('6',		'For Birthday',		'1999',	'8'),
    ('7',		'For Wedding',		'2499',	'7'),
    ('8',		'For Hollidays', 	'1999',	'6'),
    ('9',		'For Wedding',		'2499',	'9'),
    ('10',	'For Birthday',		'2999',	'10');