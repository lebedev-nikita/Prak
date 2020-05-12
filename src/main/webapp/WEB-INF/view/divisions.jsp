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

    <a href="/divisions" id="btnDivisions"> <button class="selectedButton">Divisions</button> </a>
    <a href="/employees" id="btnEmployees"> <button>Employees</button> </a>
    <a href="/positions" id="btnPositions"> <button>Positions</button> </a>
    <br><br>

    <h2> Create division: </h2>
    <form:form method="post" action="/divisions" modelAttribute="divisionRequest">
        Division name: <form:input path="postName"      id="postName" /> <br>
        Head division id: <form:input path="headDivId"  id="headDivId" /> <br>
        Chief id: <form:input path="chiefId"            id="chiefId" /> <br><br>
        <input type="submit" value="Create"         id="Create" />
    </form:form>

    <h2>Delete division:</h2>
    <form:form method="get" action="/divisions/delete" modelAttribute="divisionRequest">
        id: <form:input path="id" id="deleteId"/> <br><br>
        <input type="submit" value="Delete" id="Delete"/>
    </form:form>

    <h2> Filter divisions: </h2>
    <form:form method="get" action="/divisions/filter" modelAttribute="divisionRequest">
        Division name: <form:input path="getName"           id="getName" /> <br>
        Head division name: <form:input path="headDivName"  id="headDivName" /> <br>
        Chief name: <form:input path="chiefName"            id="chiefName" /> <br>
        Chief surname: <form:input path="chiefSurname"      id="chiefSurname" /> <br>
        Chief patronymic: <input path="chiefPatronymic"     id="chiefPatronymic" /> <br><br>
        <input type="submit" value="Filter"             id="Filter">
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
                <td id="idColumn">
                    ${division.getId()}
                </td>
                <td id="divNameColumn">
                    <a href="/divisions/${division.getId()}">
                        ${division.getName()}
                    </a>
                </td>
                <td>
                    <a href="/divisions/${division.getHeadDiv().getId()}"
                       id="headDivNameColumn">
                        ${division.getHeadDiv().getName()}
                    </a>
                </td>
                <td id="chiefFullNameColumn">
                    <a href="/employees/${division.getChief().getId()}">
                        ${division.getChief().getFullName()}
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>

</html>
