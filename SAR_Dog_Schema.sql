-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema sar_dogs
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sar_dogs
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sar_dogs` DEFAULT CHARACTER SET utf8mb3 ;
USE `sar_dogs` ;

-- -----------------------------------------------------
-- Table `sar_dogs`.`handlers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sar_dogs`.`handlers` ;

CREATE TABLE IF NOT EXISTS `sar_dogs`.`handlers` (
  `idHandlers` INT NOT NULL AUTO_INCREMENT,
  `LastName` VARCHAR(45) NOT NULL,
  `FirstName` VARCHAR(45) NOT NULL,
  `HomeStreet` VARCHAR(45) NOT NULL,
  `HomeStreet2` VARCHAR(45) NULL DEFAULT NULL,
  `HomeCity` VARCHAR(45) NOT NULL,
  `HomeState` VARCHAR(45) NOT NULL,
  `HomeZip` INT NOT NULL,
  `MailingStreet` VARCHAR(45) NOT NULL,
  `MailingStreet2` VARCHAR(45) NULL DEFAULT NULL,
  `MailingCity` VARCHAR(45) NOT NULL,
  `MailingState` VARCHAR(45) NOT NULL,
  `MailingZip` VARCHAR(45) NOT NULL,
  `MobilePhone` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idHandlers`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;

ALTER TABLE handlers
  add CONSTRAINT person_lname_fname_address UNIQUE (LastName, FirstName, HomeStreet);

-- -----------------------------------------------------
-- Table `sar_dogs`.`canines`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sar_dogs`.`canines` ;

CREATE TABLE IF NOT EXISTS `sar_dogs`.`canines` (
  `idCanines` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Breed` VARCHAR(45) NOT NULL,
  `Sex` ENUM('Male', 'Female') NOT NULL,
  `Birthdate` DATE NOT NULL,
  `Handlers_idHandlers` INT NOT NULL,
  PRIMARY KEY (`idCanines`),
  INDEX `fk_Canines_Handlers_idx` (`Handlers_idHandlers` ASC) VISIBLE,
  CONSTRAINT `fk_Canines_Handlers`
    FOREIGN KEY (`Handlers_idHandlers`)
    REFERENCES `sar_dogs`.`handlers` (`idHandlers`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sar_dogs`.`certifications`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sar_dogs`.`certifications` ;

CREATE TABLE IF NOT EXISTS `sar_dogs`.`certifications` (
  `idCertifications` INT NOT NULL AUTO_INCREMENT,
  `Agency` VARCHAR(45) NOT NULL,
  `Certification` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCertifications`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sar_dogs`.`certifications_has_canines`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sar_dogs`.`certifications_has_canines` ;

CREATE TABLE IF NOT EXISTS `sar_dogs`.`certifications_has_canines` (
  `Certifications_idCertifications` INT NOT NULL,
  `Canines_idCanines` INT NOT NULL,
  PRIMARY KEY (`Certifications_idCertifications`, `Canines_idCanines`),
  INDEX `fk_Certifications_has_Canines_Canines1_idx` (`Canines_idCanines` ASC) VISIBLE,
  INDEX `fk_Certifications_has_Canines_Certifications1_idx` (`Certifications_idCertifications` ASC) VISIBLE,
  CONSTRAINT `fk_Certifications_has_Canines_Canines1`
    FOREIGN KEY (`Canines_idCanines`)
    REFERENCES `sar_dogs`.`canines` (`idCanines`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_Certifications_has_Canines_Certifications1`
    FOREIGN KEY (`Certifications_idCertifications`)
    REFERENCES `sar_dogs`.`certifications` (`idCertifications`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
