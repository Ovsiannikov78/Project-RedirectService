CREATE TABLE IF NOT EXISTS `url`
(
    `id`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `long_url`
    VARCHAR
(
    255
) NULL DEFAULT NULL,
    `short_url` VARCHAR
(
    255
) NULL DEFAULT NULL,
    PRIMARY KEY
(
    `id`
))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;
