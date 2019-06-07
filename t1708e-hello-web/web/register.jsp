<%--
  Created by IntelliJ IDEA.
  User: HP ENVY
  Date: 5/11/2019
  Time: 6:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center">
    <h2>Register Form</h2>
</div>
<form action="/user/register" method="post">
    <div style="text-align: center">
        <div>
            <label>Username</label>
            <input type="text" name="username" placeholder="username"/>
        </div>
        <div>
            <label>Password</label>
            <input type="password" name="password" placeholder="password"/>
        </div>
        <div>
            <label>Full Name</label>
            <input type="text" name="fullName"/>
        </div>
        <div>
            <label>Email</label>
            <input type="text" name="email"/>
        </div>
        <div>
            <label>Phone Number</label>
            <input type="text" name="phone"/>
        </div>

        <button type="submit">REGISTER</button>
    </div>
</form>
</body>
</html>
