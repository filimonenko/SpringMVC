<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddOrEditEmployee.jsp</title>
</head>
<body>
<h3>AddOrEditEmployee</h3>

<form:form method="POST" action="saveEmployee" modelAttribute="employee" enctype="multipart/form-data">
    <form:input type="hidden" path="departmentId" value="${employee.departmentId}"/> 
    <form:input type="hidden" path="id" value="${employee.id}"/> 

    <table>
        <tr>
            <th><form:label path="image">Profile image:</form:label></th>
            <td><img  src="getPhoto/${employee.id}" alt="No image uploaded" width="50" Height="50"></td>
            <td><form:input type="file" path="image" accept="image/*" />
        </tr>
        <tr>
            <th><form:label path="name">name :</form:label></th>
            <td><form:input type="text" path="name" value="${employee.name}"/>
        </tr>
        <tr>
            <th><form:label path="birthDate">date of birth :</form:label></th>
            <td><form:input type="text" path="birthDate" value="${employee.birthDate}"/>
        </tr>
        <tr>
            <th><form:label path="email">employeeMailBox :</form:label></th>
            <td><form:input type="text" path="email" value="${employee.email}"/>
        </tr>
        <tr>
            <th><label for="resume">Profile resume doc:</label></th>
            <td><input type="file" name="file" id="resume"/>
        </tr>         
        <tr>
            <td><a href="showEmployee?departmentId=${employee.departmentId}"> List of employees</a></td>
            <td><input type="submit" value="save"/></td>
        </tr>
    </table>
          
</form:form>
</body>
</html>