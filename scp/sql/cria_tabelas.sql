-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema spc
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema spc
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `spc` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `spc` ;

-- -----------------------------------------------------
-- Table `spc`.`Empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spc`.`Empresa` ;

CREATE TABLE IF NOT EXISTS `spc`.`Empresa` (
  `cnpj` VARCHAR(15) NOT NULL COMMENT '',
  `razaoSocial` VARCHAR(45) NULL COMMENT '',
  `endereco` VARCHAR(45) NULL COMMENT '',
  `telefone` VARCHAR(45) NULL COMMENT '',
  `horarioEntrada` INT NULL COMMENT '',
  `horarioSaida` INT NULL COMMENT '',
  PRIMARY KEY (`cnpj`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spc`.`Conjunto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spc`.`Conjunto` ;

CREATE TABLE IF NOT EXISTS `spc`.`Conjunto` (
  `Empresa_cnpj` VARCHAR(15) NOT NULL COMMENT '',
  `numeroConjunto` INT NOT NULL COMMENT '',
  PRIMARY KEY (`numeroConjunto`)  COMMENT '',
  INDEX `fk_Conjunto_Empresa1_idx` (`Empresa_cnpj` ASC)  COMMENT '',
  CONSTRAINT `fk_Conjunto_Empresa1`
    FOREIGN KEY (`Empresa_cnpj`)
    REFERENCES `spc`.`Empresa` (`cnpj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spc`.`ControleDeTemperatura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spc`.`ControleDeTemperatura` ;

CREATE TABLE IF NOT EXISTS `spc`.`ControleDeTemperatura` (
  `Empresa_cnpj` VARCHAR(15) NOT NULL COMMENT '',
  `temperaturaMaxima` INT NULL COMMENT '',
  `horarioInicio` INT NULL COMMENT '',
  `horarioTermino` INT NULL COMMENT '',
  INDEX `fk_ControleDeTemperatura_Empresa_idx` (`Empresa_cnpj` ASC)  COMMENT '',
  CONSTRAINT `fk_ControleDeTemperatura_Empresa`
    FOREIGN KEY (`Empresa_cnpj`)
    REFERENCES `spc`.`Empresa` (`cnpj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
