<%@ page import="com.t1708e.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: HP ENVY
  Date: 5/11/2019
  Time: 6:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String reason =  (String) request.getAttribute("reason");
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
    <h3>LOGIN FAILED</h3>
    <h5>REASON : <%=reason%></h5>
</div>
</body>
</html>
