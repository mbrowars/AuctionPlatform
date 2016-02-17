create database auction;

use `auction`;

create table User (
	USERID INT(8) PRIMARY KEY NOT NULL,
    EMAIL VARCHAR(32) NOT NULL,
    CODE INT(8) NOT NULL,
    IP VARCHAR(15));

create table Auction (
	AUCTIONID INT(8) PRIMARY KEY NOT NULL,
    TITEL VARCHAR(32) NOT NULL,
    GEBOT FLOAT NOT NULL,
    LAUFZEIT BIGINT(20) NOT NULL,
    BESCHREIBUNG VARCHAR(256),
    HOECHSTBIETENDERID INT(8) NOT NULL,
    PICTURE BLOB);