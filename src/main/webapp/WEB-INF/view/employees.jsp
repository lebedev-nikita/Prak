<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <meta charset="utf-8">
    <title>Employees</title>
    <link rel="stylesheet" type="text/css" href="./styles.css">
    <style>
        <%@include file="styles.css"%>
    </style>
</head>

<body>

    <a href="/divisions"> <button>Divisions</button> </a>
    <a href="/employees"> <button class="selectedButton">Employees</button> </a>
    <a href="/positions"> <button>Positions</button> </a>
    <br><br>

    <h2> Create employee: </h2>
    <form:form method="post" action="/employees" modelAttribute="employeeRequest">
        Surname: <form:input path="postSurname" /> <br>
        Name: <form:input path="postName" /> <br>
        Patronymic: <form:input path="postPatronymic" /> <br>
        Education: <form:input path="postEducation" /> <br>
        <input type="submit" value="Create" />
    </form:form>

    <h2>Delete employee:</h2>
    <form:form method="get" action="/employees/delete" modelAttribute="employeeRequest">
        id: <form:input path="id" /> <br><br>
        <input type="submit" value="Delete" />
    </form:form>

    <h2> Filter employees: </h2>
    <form:form method="get" action="/employees/filter" modelAttribute="employeeRequest">
        Surname: <form:input path="getSurname" /> <br>
        Name: <form:input path="getName" /> <br>
        Patronymic: <form:input path="getPatronymic" /> <br>
        Education: <form:input path="getEducation" /> <br>
        <input type="submit" value="Filter">
    </form:form>

    <h2>List of employees: </h2>
    Amount of lines: ${employeeList.size()} <br><br>
    <table>
        <tr class="tableHeader">
            <th>id</th>
            <th>Full name</th>
            <th>Education</th>
            <th>Positions</th>
        </tr>
        <c:forEach items="${employeeList}" var="employee">
            <tr>
                <td>
                    ${employee.getId()}
                </td>
                <td>
                    <a href="/employees/${employee.getId()}">
                        ${employee.getFullName()}
                    </a>
                </td>
                <td>
                    ${employee.getEducation()}
                </td>
                <td>
                    <c:forEach items="${employee.getEmpPos()}" var="ep">
                        <a href="/positions/${ep.getPos().getId()}">
                            ${ep.getPos().getName()} <br>
                        </a>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>

</html>
