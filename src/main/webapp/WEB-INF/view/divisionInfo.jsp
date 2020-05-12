<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->
<html>

<head>
    <meta charset="utf-8">
    <title>${division.getName()}</title>
    <link rel="stylesheet" type="text/css" href="./styles.css">
    <style>
        <%@include file="styles.css"%>
    </style>
</head>

<body>

    <a href="/divisions" id="btnDivisions"> <button>Divisions</button> </a>
    <a href="/employees" id="btnEmployees"> <button>Employees</button> </a>
    <a href="/positions" id="btnPositions"> <button>Positions</button> </a>
    <br>

    ID: <p id="ID">${division.getId()}</p> <br>
    Name: <p id="Name">${division.getName()}</p> <br>
    Head division:
    <a href="/divisions/${division.getHeadDiv().getId()}" id="Head division">
        <p>${division.getHeadDiv().getName()}</p>
    </a> <br>
    Chief:
    <a href="/employees/${division.getChief().getId()}"  id="Chief">
        ${division.getChief().getFullName()}
    </a> <br>

    <h1>List of Positions: </h1><br>
    <table>
        <tr class="tableHeader">
            <td>Name</td>
            <td>Responsibilities</td>
            <td>Employees</td>
        </tr>
        <c:forEach items="${division.getPositions()}" var="position">
            <tr>
                <td>
                    <a href="/positions/${position.getId()}">
                        ${position.getName()}
                    </a>
                </td>
                <td>
                    ${position.getResponsibilities()}
                </td>
                <td>
                    <c:forEach items="${position.getEmpPos()}" var="emp_pos">
                        <a href="/employees/${emp_pos.getEmp().getId()}">
                            ${emp_pos.getEmp().getFullName()}
                        </a> <br>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>

</html>
