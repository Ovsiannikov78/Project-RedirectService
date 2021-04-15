
--
-- Table structure for table `redirect_statistic`
--
DROP TABLE IF EXISTS `redirect_statistic`;

CREATE TABLE IF NOT EXISTS `redirect_statistic`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `long_url` VARCHAR (255) NOT NULL DEFAULT '',
    `short_url` VARCHAR(255) NOT NULL DEFAULT '',
    `current_date` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY(`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;
