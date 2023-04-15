<!DOCTYPE html>
<html>
    <head>
        <title>Log In Page</title>
    </head>
    <body>
        <h1>Log In</h1>
        <form action="user?page=login" method="post">
            Username <input type="text" value="kritesh01" name="username"><br/>
            Password <input type="text" value="pass1234" name="password"><br/>
            <input type="submit">
        </form>
    </body>
</html>


<!--

create database mydb;

use mydb;

create table userinfo(
id int primary key auto_increment,
username varchar(255),
password varchar(255)
);

insert into userinfo(username,password) values ("swost01","pass1234");

select*from userinfo;





-->