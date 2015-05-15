<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Departments</title>
</head>
<body><a href="showDepartments"><h3>List of Departments</h3></a>

<a href="renderDepartment?id=0"> add Department</a>

<table style="margin: 5" cellspacing="0" border="1" cellpadding="3" width="500">
    <tr>
        <th>department name</th>
        <th colspan="2">action</th>
    </tr>
    <c:forEach items="${listDepartments}" var="dep">
        <tr>
            <td><a href="showEmployee?departmentId=${dep.departmentId}"> ${dep.departmentName}</a>

            <td><a href="deleteDepartment?id=${dep.departmentId}"> Delete</a>
            <td><a href="renderDepartment?id=${dep.departmentId}"> Edit</a>

        </tr>
    </c:forEach>
</table>

<br/>
<a href="http://clck.yandex.ru/redir/dtype=stred/pid=7/cid=1228/*http://pogoda.yandex.ru/kharkiv"><img
        src="http://info.weather.yandex.net/kharkiv/2.ru.png" border="0" alt=""/><img width="1" height="1"
                                                                                      src="http://clck.yandex.ru/click/dtype=stred/pid=7/cid=1227/*http://img.yandex.ru/i/pix.gif"
                                                                                      alt="" border="0"/></a>
</body>
</html>