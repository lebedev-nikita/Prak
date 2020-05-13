<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <meta charset="utf-8">
    <title>Positions</title>
    <link rel="stylesheet" type="text/css" href="./styles.css">
    <style>
        <%@include file="styles.css"%>
    </style>
</head>

<body>

    <a href="/divisions" id="btnDivisions"> <button>Divisions</button> </a>
    <a href="/employees" id="btnEmployees"> <button>Employees</button> </a>
    <a href="/positions" id="btnPositions"> <button class="selectedButton">Positions</button> </a>
    <br><br>

    <h2> Create position: </h2>
    <form:form method="post" action="/positions" modelAttribute="positionRequest">
        Name: <form:input path="postName"                         id="postName"/> <br>
        Division id: <form:input path="postDivisionId"            id="postDivisionId" /> <br>
        Responsibilities: <form:input path="postResponsibilities" id="postResponsibilities"/> <br>
        <input type="submit" value="Create"                     id="Create"/>
    </form:form>

    <h2>Delete position:</h2>
    <form:form method="get" action="/positions/delete" modelAttribute="positionRequest">
        id: <form:input path="id"                   id="deleteId" /> <br><br>
        <input type="submit" value="Delete"     id="Delete" />
    </form:form>

    <h2> Filter positions: </h2>
    <form:form method="get" action="/positions/filter" modelAttribute="positionRequest">
        Name: <form:input path="getName"                         id="getName" /> <br>
        Responsibilities: <form:input path="getResponsibilities" id="getResponsibilities" /> <br>
        Division name: <form:input path="getDivisionName"        id="getDivisionName" /> <br>
        Division id: <form:input path="getDivisionId"            id="getDivisionId" /> <br>
        <input type="submit" value="Filter"                 id="Filter">
    </form:form>

    <h2>List of positions: </h2>
    Amount of lines: ${positionList.size()} <br><br>
    <table>
        <tr class="tableHeader">
            <th>id</th>
            <th>Name</th>
            <th>Responsibilities</th>
            <th>Division</th>
            <th>Division id</th>
            <th>Employees</th>
        </tr>
        <c:forEach items="${positionList}" var="position">
            <tr>
                <td id="idColumn">
                    ${position.getId()}
                </td>
                <td id="nameColumn">
                    <a href="/positions/${position.getId()}">
                        ${position.getName()}
                    </a>
                </td>
                <td id="responsibilitiesColumn">
                    ${position.getResponsibilities()}
                </td>
                <td id="divisionNameColumn">
                    ${position.getDivision().getName()}
                </td>
                <td id="divisionIdColumn">
                    ${position.getDivision().getId()}
                </td>
                <td>
                    <c:forEach items="${position.getEmpPos()}" var="ep">
                        <a href="/employees/${ep.getEmp().getId()}">
                            ${ep.getEmp().getFullName()} <br>
                        </a>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>

</html>
