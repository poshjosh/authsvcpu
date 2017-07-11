/**
If you change any table, column names etc here then you have
to re-work the persistence layer
*/
/**
drop database if exists `loosebox_authsvc`;
create database `loosebox_authsvc` CHARACTER SET = utf8 COLLATE = utf8_general_ci;
*/

drop database if exists `loosebox_authsvc`;
create database if not exists `loosebox_authsvc` CHARACTER SET = utf8 COLLATE = utf8_general_ci;

drop table if exists `loosebox_authsvc`.userstatus;
create table `loosebox_authsvc`.userstatus
(
    userstatusid SMALLINT(2) NOT NULL PRIMARY KEY,
    userstatus VARCHAR(15) not null
)ENGINE=INNODB;

insert into `loosebox_authsvc`.userstatus VALUES(1, 'Unactivated');
insert into `loosebox_authsvc`.userstatus VALUES(2, 'Activated');
insert into `loosebox_authsvc`.userstatus VALUES(3, 'Deactivated');
insert into `loosebox_authsvc`.userstatus VALUES(4, 'Unregistered');

drop table if exists `loosebox_authsvc`.app;
create table `loosebox_authsvc`.app
(
    appid INTEGER(8) AUTO_INCREMENT not null PRIMARY KEY,
    emailaddress VARCHAR (100) not null UNIQUE,
    password VARCHAR (500) not null,
    username VARCHAR (100) not null, 
    userstatus SMALLINT(2) not null DEFAULT '1',
    datecreated DATETIME not null,
    timemodified TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (userstatus) 
        REFERENCES userstatus(userstatusid)
        ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=INNODB;

/** email address is not unique here because the same user could use 2 different apps */
drop table if exists `loosebox_authsvc`.appuser;
create table `loosebox_authsvc`.appuser
(
    appuserid INTEGER(8) AUTO_INCREMENT not null PRIMARY KEY,
    appid INTEGER(8) not null,
    emailaddress VARCHAR (100) not null,
    password VARCHAR (500) not null,
    username VARCHAR (100) not null, 
    userstatus SMALLINT(2) not null DEFAULT '1',
    datecreated DATETIME not null,
    timemodified TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (appid) 
        REFERENCES app(appid)
        ON DELETE CASCADE ON UPDATE CASCADE,

    FOREIGN KEY (userstatus) 
        REFERENCES userstatus(userstatusid)
        ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=INNODB;

drop table if exists `loosebox_authsvc`.usertoken;
create table `loosebox_authsvc`.usertoken
(
    tokenid INTEGER(8) AUTO_INCREMENT not null PRIMARY KEY,
    appuserid INTEGER(8) not null UNIQUE,
    seriesid VARCHAR (255) not null, 
    token VARCHAR (255) not null,
    datecreated DATETIME not null,
    timemodified TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (appuserid) 
        REFERENCES appuser(appuserid)
        ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=INNODB;

drop table if exists `loosebox_authsvc`.apptoken;
create table `loosebox_authsvc`.apptoken
(
    tokenid INTEGER(8) AUTO_INCREMENT not null PRIMARY KEY,
    appid INTEGER(8) not null UNIQUE,
    seriesid VARCHAR (255) not null, 
    token VARCHAR (255) not null,
    datecreated DATETIME not null,
    timemodified TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (appid) 
        REFERENCES app(appid)
        ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=INNODB;



