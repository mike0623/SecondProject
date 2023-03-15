/****** SSMS 中 SelectTopNRows 命令的指令碼  ******/
truncate table users

delete users

drop table users

create table users(
	userID int primary key identity(1,1),
	userAccount nvarchar(200) unique not null,
	userPwd nvarchar(200) not null,
	userName nvarchar(200) not null,
	gender nvarchar(200),
	birthday nvarchar(200),
	createDate date default getdate(),
	userPhoto nvarchar(max)
)

insert into [GamePlat].[dbo].[users]([userAccount]
      ,[userPwd]
      ,[userName]
      ,[gender]
      ,[birthday])
  values
  ('michael@gmail.com','1234','陳昱臻','男','1997-06-23'),
  ('jun@gmail.com','1234','陳女女','女','1920-12-13')


  insert into [GamePlat].[dbo].[users]([userAccount]
      ,[userPwd]
      ,[userName]
      ,[gender]
      ,[birthday],userPhoto)
  values
--  ('michael@gmail.com','1234','陳昱臻','男','1997-06-23',(select userPhoto from users where userID = 171)),
--  ('jun@gmail.com','1234','陳女女','女','1920-12-13',(select userPhoto from users where userID = 171)),
    ('1','1234','陳昱臻','男','1997-06-23',(select userPhoto from users where userID = 212)),
  ('2','1234','陳女女','女','1920-12-13',(select userPhoto from users where userID = 212)),
    ('3','1234','陳昱臻','男','1997-06-23',(select userPhoto from users where userID = 212)),
  ('4','1234','陳女女','女','1920-12-13',(select userPhoto from users where userID = 212)),
    ('5','1234','陳昱臻','男','1997-06-23',(select userPhoto from users where userID = 212)),
  ('6','1234','陳女女','女','1920-12-13',(select userPhoto from users where userID = 212)),
    ('7','1234','陳昱臻','男','1997-06-23',(select userPhoto from users where userID = 212)),
  ('8','1234','陳女女','女','1920-12-13',(select userPhoto from users where userID = 212)),
    ('9','1234','陳昱臻','男','1997-06-23',(select userPhoto from users where userID = 212)),
  ('10','1234','陳女女','女','1920-12-13',(select userPhoto from users where userID = 212)),
  ('11','1234','陳昱臻','男','1997-06-23',(select userPhoto from users where userID = 212)),
  ('12','1234','陳女女','女','1920-12-13',(select userPhoto from users where userID = 212)),
      ('13','1234','陳昱臻','男','1997-06-23',(select userPhoto from users where userID = 212)),
  ('14','1234','陳女女','女','1920-12-13',(select userPhoto from users where userID = 212)),
    ('15','1234','陳昱臻','男','1997-06-23',(select userPhoto from users where userID = 212)),
  ('16','1234','陳女女','女','1920-12-13',(select userPhoto from users where userID = 212)),
    ('17','1234','陳昱臻','男','1997-06-23',(select userPhoto from users where userID = 212)),
  ('18','1234','陳女女','女','1920-12-13',(select userPhoto from users where userID = 212)),
    ('19','1234','陳昱臻','男','1997-06-23',(select userPhoto from users where userID = 212)),
  ('20','1234','陳女女','女','1920-12-13',(select userPhoto from users where userID = 212)),
    ('21','1234','陳昱臻','男','1997-06-23',(select userPhoto from users where userID = 212)),
  ('22','1234','陳女女','女','1920-12-13',(select userPhoto from users where userID = 212)),
  ('23','1234','陳昱臻','男','1997-06-23',(select userPhoto from users where userID = 212)),
  ('24','1234','陳女女','女','1920-12-13',(select userPhoto from users where userID = 212))



  select * from users order by userID offset 0 rows fetch next 10 rows only
  select count(*) from users
  ------------------------------

  drop table boardgame

  create table boardgame(
	gameID int primary key identity(1,1),
	gameName nvarchar(200) unique not null,
	creater nvarchar(200),
	createdDate date default getdate(),
	degreeOfDifficulty nvarchar(200), --easy,medium,hard
	spendTime nvarchar(200) --quick,medium,long
  )

  insert into boardgame(gameName,creater,createdDate,degreeOfDifficulty,spendTime)
  values('1A2B','Michael',GETDATE(),'easy','quick')

  -----------------------
  drop table score

   create table score(
	scoreID int primary key identity(1,1),
	score int not null,
	createdDate date default getdate(),
	f_userID int not null,
	f_gameID int not null
	foreign key (f_userID) references users(userID) on delete cascade on update cascade,
	foreign key (f_gameID) references boardgame(gameID) on delete cascade on update cascade
  )

  insert into score(score,f_userID,f_gameID)
  values(100,1,1)

  ---------------------------
  create table usersDeleted(
	deletedUserID int primary key identity(1,1),
	userAccount nvarchar(200) not null,
	userPwd nvarchar(200) not null,
	userName nvarchar(200) not null,
	gender nvarchar(200),
	birthday nvarchar(200),
	deleteDate date default getdate(),
	userPhoto nvarchar(max),
	deleter nvarchar(200) default 'user'
)

drop table usersDeleted






  



