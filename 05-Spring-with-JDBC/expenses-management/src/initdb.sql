CREATE DATABASE expenses_management;
USE expenses_management;
CREATE TABLE `employees` (
                             `id` INT(11) NOT NULL AUTO_INCREMENT,
                             `firstname` VARCHAR(100) NOT NULL COLLATE 'latin1_swedish_ci',
                             `lastname` VARCHAR(100) NOT NULL COLLATE 'latin1_swedish_ci',
                             `dateJoined` DATE NOT NULL,
                             `department` VARCHAR(20) NOT NULL COLLATE 'latin1_swedish_ci',
                             `costCenter` SMALLINT(6) NOT NULL,
                             PRIMARY KEY (`id`) USING BTREE
);
