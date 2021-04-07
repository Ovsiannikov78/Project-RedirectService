/*CREATE DATABASE  IF NOT EXISTS `redirect-service`;
USE `redirect-service`;*/

-- -----------------------------------------------------
-- Table `redirect-service`.`url`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `url`;

CREATE TABLE IF NOT EXISTS `url` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `long_url` VARCHAR (255) NOT NULL DEFAULT '',
    `short_url` VARCHAR (255) NOT NULL DEFAULT '',
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;
