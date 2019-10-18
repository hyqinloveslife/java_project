CREATE TABLE `tianshop`.`book` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `name` VARCHAR(200) NULL COMMENT '书名',
  `referred` VARCHAR(200) NULL COMMENT '简称',
  `price` DOUBLE NULL COMMENT '价格',
  `published` VARCHAR(45) NULL COMMENT '出版社',
  `author` VARCHAR(45) NULL COMMENT '作者',
  `publishDate` VARCHAR(45) NULL,
  `desc` VARCHAR(200) NULL COMMENT '简介',
  `isbn` VARCHAR(45) NULL COMMENT '国际标准书号',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;