<%@page import="java.util.List"%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Create</h1>
        <form action="user?page=create" method="post">
            Name <input type="text" value="Kritesh" name="name"><br/>
            Username <input type="text" value="kritesh" name="username"><br/>
            Password <input type="text" value="pass1234" name="password"><br/>
            <input type="submit">
        </form>
        <%
        List<User> userlist = (List<User>) request.getAttribute("userlist");
        if(userlist!=null){
        %>
        <h1>Read</h1>
        <table>
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Username</td>
                <td>Password</td>
                <td>Delete</td>
            </tr>
            <%
            for(User u : userlist){
            %>
            <tr>
                <td><%=u.getId()%></td>
                <td><%=u.getName()%></td>
                <td><%=u.getUsername()%></td>
                <td><%=u.getPassword()%></td>
                <td>
                    <a href="user?page=delete&id=<%=u.getId()%>">Delete</a>
                </td>
            </tr>
            <%}%>
        </table>
        <%}%>
        <h1>Update</h1>
        <form action="user?page=register" method="post">
            Id <input type="text" value="Kritesh" name="id"><br/>
            Name <input type="text" value="Kritesh" name="name"><br/>
            Username <input type="text" value="kritesh" name="username"><br/>
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
firstname varchar(255),
username varchar(255),
password varchar(255)
);

select*from userinfo;

-->
