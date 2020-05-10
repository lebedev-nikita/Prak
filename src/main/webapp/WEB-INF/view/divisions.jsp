<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <meta charset="utf-8">
    <title>Divisions</title>
    <link rel="stylesheet" type="text/css" href="./styles.css">
    <style>
        <%@include file="styles.css"%>
    </style>
</head>

<body>

    <a href="/divisions"> <button class="selectedButton">Divisions</button> </a>
    <a href="/employees"> <button>Employees</button> </a>
    <a href="/positions"> <button>Positions</button> </a>
    <br><br>

    <h2> Create division: </h2>
    <form:form method="post" action="/divisions" modelAttribute="divisionRequest">
        Division name: <form:input path="postName" /> <br>
        Head division id: <form:input path="headDivId" /> <br>
        Chief id: <form:input path="chiefId" /> <br><br>
        <input type="submit" value="Create" />
    </form:form>

    <h2>Delete division:</h2>
    <form:form method="get" action="/divisions/delete" modelAttribute="divisionRequest">
        id: <form:input path="id" /> <br><br>
        <input type="submit" value="Delete" />
    </form:form>

    <h2> Filter divisions: </h2>
    <form:form method="get" action="/divisions/filter" modelAttribute="divisionRequest">
        Division name: <form:input path="getName" /> <br>
        Head division name: <form:input path="headDivName" /> <br>
        Chief name: <form:input path="chiefName" /> <br>
        Chief surname: <form:input path="chiefSurname" /> <br>
        Chief patronymic: <input path="chiefPatronymic" /> <br><br>
        <input type="submit" name="" value="Filter">
    </form:form>

    <h2>List of divisions: </h2>
    Amount of lines: ${divisionList.size()} <br><br>
    <table>
        <tr class="tableHeader">
            <th>id</th>
            <th>Division name</th>
            <th>Head division name</th>
            <th>Chief name</th>
        </tr>
        <c:forEach items="${divisionList}" var="division">
            <tr>
                <td>
                    ${division.getId()}
                </td>
                <td>
                    <a href="/divisions/${division.getId()}">
                        ${division.getName()}
                    </a>
                </td>
                <td>
                    <a href="/divisions/${division.getHeadDiv().getId()}">
                        ${division.getHeadDiv().getName()}
                    </a>
                </td>
                <td>
                    <a href="/employees/${division.getChief().getId()}">
                        ${division.getChief().getFullName()}
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>

</html>
