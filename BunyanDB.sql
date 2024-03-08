CREATE SCHEMA Bunyan;
-- Create avatars table
CREATE TABLE avatars
    ( 
    avatarImageID VARCHAR(2) NOT NULL,
	avatarName	VARCHAR(10) NOT NULL,
	CONSTRAINT avatars PRIMARY KEY (avatarImageID)
     );

 -- Insert into avatars table
INSERT INTO avatars
VALUES ('U0','Anonymous'),
       ('F1','Liam'),
	   ('M1','Sophia'),
       ('F2','Noah'),
       ('M2','Lucy'),
       ('F3','Ethan'),
       ('M3','Olivia');
       
CREATE TABLE Player(
PlayerID int(10) not null auto_increment,
fname varchar(50) not null,
lname varchar(50) not null,
PlayerEmail varchar(50) not null unique,
PlayerPass varchar(50) not null,
playerQues varchar(50) not null,
playerAns varchar(50) not null,
avatar varchar(2),
constraint player_ID PRIMARY KEY(PlayerID),
constraint playeravatar_FK foreign key(avatar) references avatars(avatarImageID)
on delete set null
);
       
CREATE TABLE Achievement(
achievementID INT(10) NOT NULL AUTO_INCREMENT,
playerID INT(6),
levelNum INT(1) ,
totalTime Time(3),
numberOfCoins INT(4) ,
CONSTRAINT Achievement_PK PRIMARY KEY (achievementID),
CONSTRAINT Achievement_FK FOREIGN KEY (playerID)
REFERENCES Player (playerID)
ON DELETE CASCADE
ON UPDATE CASCADE
);

INSERT INTO Player
VALUES (1,'Murooj','M','murooj@gmail.com','msms12345','your favorite subject','math','F1'),(2,'Lamis','l','Lamis@gmail.com','lamis12345','your favorite subject','math','M1'),
(3,'Rahaf','r','Rahaf@gmail.com','rahaf12345','your favorite subject','math','F2'),(4,'Manar','r','Manar@gmail.com','manar12345','your favorite subject','math','F3'),
(5,'shahad','r','shahad@gmail.com','sh12345','your favorite subject','math','F2');

