-- MySQL Script generated by MySQL Workbench
-- Thu Mar 21 11:37:14 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ncme-area
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ncme-area
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ncme-area` ;
USE `ncme-area` ;

-- -----------------------------------------------------
-- Table `ncme-area`.`dict_administrative_areas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ncme-area`.`dict_administrative_areas` (
  `id` INT UNSIGNED NOT NULL,
  `parent_id` INT NOT NULL,
  `area_code` VARCHAR(45) NOT NULL,
  `area_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;