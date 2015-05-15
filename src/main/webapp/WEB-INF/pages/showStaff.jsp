<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page import="java.io.*" %>--%>
<%--<%@ page import="java.sql.*" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Staff</title>
</head>
<body>
<a href="showEmployee?departmentId=${departmentId}"><h3>List of employees</h3></a>

<a href="renderEmployee?departmentId=${departmentId}&employeeId=0"> add employee</a>
<table style="margin: 5" cellspacing="0" border="1" cellpadding="3" width="500">

    <tr>
        <th>avatar</th>
        <th>employeeName</th>
        <th>employeeDob</th>
        <th>employeeMailBox</th>
        <th>resume</th>
        <th colspan="2">action</th>
    </tr>

    <c:forEach items="${listOfEmployee}" var="employee">

        <tr>
            <td><img src="getPhoto/${employee.id}" alt="No image uploaded" width="50" Height="50"></td>
            <td><c:out value="${employee.name}"/></td>
            <td><c:out value="${employee.birthDate}"/></td>
            <td><c:out value="${employee.email}"/></td>
            <c:choose>
                <c:when test="${employee.resume==true}">
                    <td><a href="getResume/${employee.id}">Download</a></td>
                </c:when>
                <c:otherwise>
                    <td>no file</td>
                </c:otherwise>
            </c:choose>
            <td><a href="deleteEmployee?departmentId=${employee.departmentId}&employeeId=${employee.id}">Delete</a></td>
            <td><a href="renderEmployee?departmentId=${employee.departmentId}&employeeId=${employee.id}">Edit</a></td>
        </tr>

    </c:forEach>
</table>
<a href="showDepartments">List of Departments</a>

</body>
</html>