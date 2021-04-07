/*CREATE
DATABASE IF NOT EXISTS `redirect-service`;
USE `redirect-service`;*/

--
-- Table structure for table `url`
--

CREATE TABLE IF NOT EXISTS `url`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `long_url` VARCHAR (255) NOT NULL DEFAULT '',
    `short_url` VARCHAR (255) NOT NULL DEFAULT '',
    `customer_number` INTEGER DEFAULT NULL,
    `expiration_date` VARCHAR (255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;
