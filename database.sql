
drop database DeccanSportClub;
create database DeccanSportClub;
use DeccanSportClub;
-- users --> (userid , username, password, role, address, phone , email) 
-- --> admin, manager, member
-- sports --> sportid , sport name
-- plans --> planid, sportid, planname, fees, duration
-- batch --> batchid, starttime, size, sportid
-- enrollment --> memberid, batchid, planid, status
-- coding


create table Users(
userId int primary key auto_increment,
username varchar (50),
password  varchar (50),
role  varchar (50), 
address  varchar (50),
phone  varchar (50), 
email  varchar (50) unique
);

create table Sports(
sportId int primary key AUTO_INCREMENT,
sportName varchar(100)
);

create table Batch(
batchId int primary key AUTO_INCREMENT,
startDate date,
endDate date,
batchSize int,
sportId int,
foreign key(sportId) references Sports(sportId) ON DELETE SET NULL
);

create table Plans(
planId int primary key auto_increment,
sportId int , 
planName varchar (50),
fees double,
duration int,
foreign key(sportId) references Sports(sportId) 
);

CREATE TABLE Enrollment (
enrollId int primary key AUTO_INCREMENT,
batchId int,
startDate DATE,
endDate DATE,
mStatus VARCHAR(100),
foreign key(batchId) references Batch(batchId) 
);

show tables;

desc ENROLLMENT;

