<%--
  Created by IntelliJ IDEA.
  User: HP ENVY
  Date: 12/4/2018
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Employee</title>
</head>
<body>
    <ul>
        <c:forEach items="${listEmp}" var="item">
            <li>${item.id} - ${item.name} - ${item.email}</li>
        </c:forEach>
    </ul>
</body>
</html>
<script>

</script>
