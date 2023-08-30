create database duck;
use duck;
create table users (
  `id_users` INT NOT NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `access_level` VARCHAR(45) NULL,
  PRIMARY KEY (`id_users`));
select * from users
