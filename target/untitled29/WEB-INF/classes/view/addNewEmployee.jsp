<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 10.03.2022
  Time: 3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="employee" type="org.example"--%>
<form:form action="/saveEmployee"  modelAttribute="employee">
    Name <form:input path="name"/><br/>
    Surname <form:input path="surname"/><br/>
    Salary <form:input path="salary"/><br/>
    Department <form:input path="department"/><br/>
    <input type="submit">
</form:form>
</body>
</html>
