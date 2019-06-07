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
        <h2>Login Form</h2>
    </div>

    <form action="/user/login" method="post">
        <div style="text-align: center">
            <div>
                <label>Username</label>
                <input type="text" name="username" placeholder="username"/>
            </div>
            <div>
                <label>Password</label>
                <input type="password" name="password" placeholder="password"/>
            </div>
        </div>

        <div style="text-align: center; margin-top: 20px">
            <button type="submit"  style="margin-right: 20px"> Login</button>
            <button type="reset" > Reset</button>
        </div>

    </form>


</body>
</html>
