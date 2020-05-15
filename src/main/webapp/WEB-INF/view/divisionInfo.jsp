<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
-->
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

    ID: <span id="ID">${division.getId()}</span> <br>
    Name: <span id="Name">${division.getName()}</span> <br>
    Head division:
    <a href="/divisions/${division.getHeadDiv().getId()}" id="Head division">
        <span>${division.getHeadDiv().getName()}</span>
    </a> <br>
    Chief:
    <a href="/employees/${division.getChief().getId()}"  id="Chief">
        ${division.getChief().getFullName()}
    </a> <br>

    <h1>Edit division: </h1>
    <form:form method="post" action="/divisions/${division.getId()}/update" modelAttribute="divisionInfoRequest">
        name: <form:input path="newName" id="newName"/>
        <input type="submit" value="Change" id="ChangeName"/>
    </form:form>
    <form:form method="post" action="/divisions/${division.getId()}/update" modelAttribute="divisionInfoRequest">
        head division id: <form:input path="newHeadDivisionId" id="newHeadDivisionId"/>
        <input type="submit" value="Change" id="ChangeHead"/>
    </form:form>
    <form:form method="post" action="/divisions/${division.getId()}/update" modelAttribute="divisionInfoRequest">
        chief id: <form:input path="newChiefId" id="newChiefId"/>
        <input type="submit" value="Change" id="ChangeChief"/>
    </form:form>

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
