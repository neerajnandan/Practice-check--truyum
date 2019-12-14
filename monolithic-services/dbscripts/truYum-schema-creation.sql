create schema truyum;
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema truyum
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema truyum
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `truyum` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema truyum
-- -----------------------------------------------------
USE `truyum` ;

-- -----------------------------------------------------
-- Table `truyum`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `truyum`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(60) NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `truyum`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `truyum`.`role` (
  `ro_id` INT NOT NULL AUTO_INCREMENT,
  `ro_name` VARCHAR(45) NULL,
  PRIMARY KEY (`ro_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `truyum`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `truyum`.`user_role` (
  `ur_id` INT NOT NULL AUTO_INCREMENT,
  `ur_us_id` INT NOT NULL,
  `ur_ro_id` INT NOT NULL,
  PRIMARY KEY (`ur_id`),
  INDEX `fk_user_role_user1_idx` (`ur_us_id` ASC),
  INDEX `fk_user_role_role1_idx` (`ur_ro_id` ASC),
  CONSTRAINT `fk_user_role_user1`
    FOREIGN KEY (`ur_us_id`)
    REFERENCES `truyum`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_role1`
    FOREIGN KEY (`ur_ro_id`)
    REFERENCES `truyum`.`role` (`ro_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `truyum`.`menu_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `truyum`.`menu_item` (
  `me_id` INT NOT NULL AUTO_INCREMENT,
  `me_name` VARCHAR(100) NULL,
  `me_price` DECIMAL(8,2) NULL,
  `me_active` VARCHAR(3) NULL,
  `me_date_of_launch` DATE NULL,
  `me_category` VARCHAR(45) NULL,
  `me_free_delivery` VARCHAR(3) NULL,
  `me_image_url` VARCHAR(400) NULL,
  PRIMARY KEY (`me_id`))
ENGINE = InnoDB;



DROP TABLE menu_item;
DROP TABLE cart;
DROP table user;
 drop table user_role;
drop table role;
-- -----------------------------------------------------
-- Table `truyum`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `truyum`.`cart` (
  `ct_id` INT NOT NULL AUTO_INCREMENT,
  `ct_us_id` INT NOT NULL,
  `ct_pr_id` INT NOT NULL,
  PRIMARY KEY (`ct_id`),
  INDEX `fk_cart_user_idx` (`ct_us_id` ASC),
  INDEX `fk_cart_menu_item1_idx` (`ct_pr_id` ASC),
  CONSTRAINT `fk_cart_user`
    FOREIGN KEY (`ct_us_id`)
    REFERENCES `truyum`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cart_menu_item1`
    FOREIGN KEY (`ct_pr_id`)
    REFERENCES `truyum`.`menu_item` (`me_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
