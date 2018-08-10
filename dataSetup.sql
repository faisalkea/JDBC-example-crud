use springtest;
show tables;

create table user(id int UNSIGNED primary key not null auto_increment, name varchar(100), email varchar(100));
INSERT INTO `springtest`.`user` (`id`, `name`, `email`) VALUES ('1', 'Faisal', 'fafj@kea.dk');
INSERT INTO `springtest`.`user` (`id`, `name`, `email`) VALUES ('2', 'Christian', 'chrk@kea.dk');
INSERT INTO `springtest`.`user` (`id`, `name`, `email`) VALUES ('3', 'Claus', 'clbo@kea.dk');

select * from user;

create table student(id int UNSIGNED primary key not null auto_increment, firstname varchar(100), lastname varchar(100), email varchar(100));
INSERT INTO `springtest`.`student` (`id`, `firstname`, `lastname`, `email`) VALUES ('1', 'Faisal', 'Jarkass', 'fafj@kea.dk');
INSERT INTO `springtest`.`student` (`id`, `firstname`, `lastname`, `email`) VALUES ('2', 'Alex', 'Constantin', 'coag@kea.dk');
INSERT INTO `springtest`.`student` (`id`, `firstname`, `lastname`, `email`) VALUES ('3', 'Jesper', 'Nordentoft', 'jesn@kea.dk');
INSERT INTO `springtest`.`student` (`id`, `firstname`, `lastname`, `email`) VALUES ('4', 'test', 'testesen', 'test@kea.dk');

select * from student;