<%@ page import="com.t1708e.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: HP ENVY
  Date: 5/11/2019
  Time: 6:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) request.getAttribute("user");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center">
    <h1>Login Success</h1>
</div>
<div style="text-align: center">
    <h3>Login success with account: <%= user.getUsername()%></h3>
</div>
</body>
</html>
