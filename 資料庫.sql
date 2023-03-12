/****** SSMS 中 SelectTopNRows 命令的指令碼  ******/
delete users

create table users(
	userID int primary key identity(1,1),
	userAccount nvarchar(200) unique not null,
	userPwd nvarchar(200) not null,
	userName nvarchar(200) not null,
	gender nvarchar(200),
	birthday nvarchar(200) 
)

insert into [GamePlat].[dbo].[users]([userAccount]
      ,[userPwd]
      ,[userName]
      ,[gender]
      ,[birthday])
  values
  ('michael@gmail.com','1234','陳昱臻','男','1997-06-23'),
  ('jun@gmail.com','1234','陳女女','女','1920-12-13')



