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

    <a href="/divisions"> <button>Divisions</button> </a>
    <a href="/employees"> <button>Employees</button> </a>
    <a href="/positions"> <button class="selectedButton">Positions</button> </a>
    <br><br>
    <h2> Create position: </h2>
    <form:form method="post" action="/positions" modelAttribute="positionRequest">
        Name: <form:input path="postName" /> <br>
        Division id: <form:input path="postDivisionId" /> <br>
        Responsibilities: <form:input path="postResponsibilities" /> <br>
        <input type="submit" value="Create" />
    </form:form>

    <h2>Delete position:</h2>
    <form:form method="get" action="/positions/delete" modelAttribute="positionRequest">
        id: <form:input path="id" /> <br><br>
        <input type="submit" value="Delete" />
    </form:form>

    <h2> Filter positions: </h2>
    <form:form method="get" action="/positions/filter" modelAttribute="positionRequest">
        Name: <form:input path="getName" /> <br>
        Responsibilities: <form:input path="getResponsibilities" /> <br>
        Division name: <form:input path="getDivisionName" /> <br>
        Division id: <form:input path="getDivisionId" /> <br>
        <input type="submit" value="Filter">
    </form:form>
<%-- --%>

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
                <td>
                    ${position.getId()}
                </td>
                <td>
                    <a href="/positions/${position.getId()}">
                        ${position.getName()}
                    </a>
                </td>
                <td>
                    ${position.getResponsibilities()}
                </td>
                <td>
                    ${position.getDivision().getName()}
                </td>
                <td>
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
