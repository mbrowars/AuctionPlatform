use `auction`;
create table User (
	ID INT(8) PRIMARY KEY,
    EMAIL VARCHAR(32) NOT NULL,
    CODE VARCHAR(8) NOT NULL,
    IP VARCHAR(11) NOT NULL);

create table Auction (
	ID INT(8) PRIMARY KEY,
    TITEL VARCHAR(32) NOT NULL,
    GEBOT FLOAT(16) NOT NULL,
    ENDDATUM DATE NOT NULL,
    BESCHREIBUNG VARCHAR(256),
    HOECHSTBIETENDERID INT(8) REFERENCES User(ID));
 
use auction;
 
alter table User 
drop column ID,
add column USERID INT(8) PRIMARY KEY;

alter table user
drop column IP,
add column IP VARCHAR(15);

alter table Auction
drop column ID,
add column AUCTIONID INT(8) PRIMARY KEY;

alter table Auction
drop column HOECHSTBIETENDERID,
add column HOECHSTBIETENDERID INT(8),
add foreign key (HOECHSTBIETENDERID) REFERENCES User(USERID);
    
use auction;
    
alter table Auction
add column PICTURE BLOB;

use auction;
    
alter table User
drop code,
add CODE int(8) not null;

alter table auction
drop foreign key auction_ibfk_1,
drop hoechstbietenderid;

alter table auction
add hoechstbietenderid int(8) not null;

alter table auction
drop enddatum,
add LAUFZEIT BIGINT(20) NOT NULL AFTER GEBOT;
