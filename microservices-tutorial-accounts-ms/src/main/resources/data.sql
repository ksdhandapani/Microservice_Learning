DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS accounts;

CREATE TABLE `customers` (
`customer_id` int AUTO_INCREMENT PRIMARY KEY,
`name` varchar(100) NOT NULL, 
`email` varchar(100) NOT NULL, 
`mobile_number` varchar(20) NOT NULL,
`create_dt` date DEFAULT NULL
);

CREATE TABLE `accounts` (
`customer_id` int NOT NULL,
`account_number` int AUTO_INCREMENT PRIMARY KEY,
`account_type` varchar(100) NOT NULL, 
`branch_address` varchar(200) NOT NULL, 
`create_dt` date DEFAULT NULL
);

INSERT INTO `customers`(`name`,`email`,`mobile_number`,`create_dt`)
VALUES('Dhandapani Sudhakar','dhandapani@email.com','9894064229',CURDATE());

INSERT INTO `accounts`(`customer_id`,`account_number`,`account_type`,`branch_address`,`create_dt`)
VALUES(1,1000001,'Savings','123, Main Street, Kodumudi',CURDATE());