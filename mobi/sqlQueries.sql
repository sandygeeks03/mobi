CREATE DATABASE bookdb;

USE bookdb;

CREATE TABLE person(
	userid INT identity(1,1) PRIMARY KEY ,
	username VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	salt VARCHAR(255) NOT NULL
);

CREATE TABLE room(
	roomid INT identity(1,1) PRIMARY KEY ,
	roomname VARCHAR(255) NOT NULL,
	rooms VARCHAR(255) NOT NULL,
	status bit
);

CREATE TABLE booking(
	bookingid INT identity(1,1) PRIMARY KEY ,
	userid INT NOT NULL FOREIGN Key REFERENCES  person(userid),
	roomid INT NOT NULL FOREIGN Key REFERENCES  room(roomid),
	rooms INT NOT NULL
);



  insert into [person] ([username],[password],[salt]) values ('Admin','HhaNvzTsVYwS/x/zbYXlLOE3ETMXQgllqrDaJY9PD/U=','EqdmPh53c9x33EygXpTpcoJvc4VXLK');

  insert into room (roomname,rooms,status) values ('Classic',10,1);


  insert into [booking] ([userid],[roomid],[rooms]) values (1,1,4);
  insert into [booking] ([userid],[roomid],[rooms]) values (1,1,2);
