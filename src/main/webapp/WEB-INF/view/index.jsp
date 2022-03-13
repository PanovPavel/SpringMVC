<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h2>Hello World!</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="empls" items="${AttributeEmployees}">
<%--        <c:url var="deleteButton" value="/deleteEmployee">--%>
<%--            <c:param name="empId" value="${empls.id}"></c:param>--%>
<%--        </c:url>--%>
    <tr>
        <td>${empls.name}</td>
        <td>${empls.surname}</td>
        <td>${empls.department}</td>
        <td>${empls.salary}</td>
        <td>
            <c:url var="emp" value="/deleteEmployee">
                <c:param name="empId" value="${empls.id}"></c:param>
            </c:url>
            <c:url var="empUpdate" value="/updateEmployee">
                <c:param name="empId" value="${empls.id}"></c:param>
            </c:url>
            <input type="button" value="delete" onclick="window.location.href = '${emp}'">
            <input type="button" value="update" onclick="window.location.href = '${empUpdate}'">
        </td>
    </tr>
    </c:forEach>
</table>
<input type="button" value="newWork" onclick="window.location.href = '/addNewEmployee'">
</body>
</html>
