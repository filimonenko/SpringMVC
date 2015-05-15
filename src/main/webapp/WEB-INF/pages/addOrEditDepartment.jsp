<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddOrEditDepartment.jsp</title>
</head>
<body>
<h3>Add Or Edit Department</h3>

<form:form action="saveDepartment" modelAttribute="department" method="POST">
    <table>
        <tr>
            <th>
                <form:label path="departmentName">department name :</form:label>
            </th>
            <td>
                <form:input path="departmentName" value="${department.departmentName}"/>
                <form:input type="hidden" path="departmentId" value="${department.departmentId}"/>
            </td>
            <td>
                <input type="submit" value="Save"/>
            </td>
        </tr>
            
    </table>
</form:form>
<a href="showDepartments">back</a>
</body>
</html>

