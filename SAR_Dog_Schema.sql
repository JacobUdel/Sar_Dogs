-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema SAR_DOGS
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SAR_DOGS
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SAR_DOGS` DEFAULT CHARACTER SET utf8 ;
USE `SAR_DOGS` ;

-- -----------------------------------------------------
-- Table `SAR_DOGS`.`Handlers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SAR_DOGS`.`Handlers` ;

CREATE TABLE IF NOT EXISTS `SAR_DOGS`.`Handlers` (
  `idHandlers` INT NOT NULL AUTO_INCREMENT,
  `LastName` VARCHAR(45) NOT NULL,
  `FirstName` VARCHAR(45) NOT NULL,
  `HomeStreet` VARCHAR(45) NOT NULL,
  `HomeStreet2` VARCHAR(45) NULL,
  `HomeCity` VARCHAR(45) NOT NULL,
  `HomeState` VARCHAR(45) NOT NULL,
  `HomeZip` INT(5) NOT NULL,
  `MailingStreet` VARCHAR(45) NOT NULL,
  `MailingStreet2` VARCHAR(45) NULL,
  `MailingCity` VARCHAR(45) NOT NULL,
  `MailingState` VARCHAR(45) NOT NULL,
  `MailingZip` VARCHAR(45) NOT NULL,
  `MobilePhone` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idHandlers`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SAR_DOGS`.`Canines`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SAR_DOGS`.`Canines` ;

CREATE TABLE IF NOT EXISTS `SAR_DOGS`.`Canines` (
  `idCanines` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Breed` VARCHAR(45) NOT NULL,
  `Sex` TINYINT NOT NULL,
  `Birthdate` DATE NOT NULL,
  `Handlers_idHandlers` INT NOT NULL,
  PRIMARY KEY (`idCanines`),
  INDEX `fk_Canines_Handlers_idx` (`Handlers_idHandlers` ASC) VISIBLE,
  CONSTRAINT `fk_Canines_Handlers`
    FOREIGN KEY (`Handlers_idHandlers`)
    REFERENCES `SAR_DOGS`.`Handlers` (`idHandlers`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SAR_DOGS`.`Certifications`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SAR_DOGS`.`Certifications` ;

CREATE TABLE IF NOT EXISTS `SAR_DOGS`.`Certifications` (
  `idCertifications` INT NOT NULL AUTO_INCREMENT,
  `Agency` VARCHAR(45) NOT NULL,
  `Certification` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCertifications`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SAR_DOGS`.`Certifications_has_Canines`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SAR_DOGS`.`Certifications_has_Canines` ;

CREATE TABLE IF NOT EXISTS `SAR_DOGS`.`Certifications_has_Canines` (
  `Certifications_idCertifications` INT NOT NULL,
  `Canines_idCanines` INT NOT NULL,
  PRIMARY KEY (`Certifications_idCertifications`, `Canines_idCanines`),
  INDEX `fk_Certifications_has_Canines_Canines1_idx` (`Canines_idCanines` ASC) VISIBLE,
  INDEX `fk_Certifications_has_Canines_Certifications1_idx` (`Certifications_idCertifications` ASC) VISIBLE,
  CONSTRAINT `fk_Certifications_has_Canines_Certifications1`
    FOREIGN KEY (`Certifications_idCertifications`)
    REFERENCES `SAR_DOGS`.`Certifications` (`idCertifications`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Certifications_has_Canines_Canines1`
    FOREIGN KEY (`Canines_idCanines`)
    REFERENCES `SAR_DOGS`.`Canines` (`idCanines`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
