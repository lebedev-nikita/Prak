<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->
<html>

<head>
    <meta charset="utf-8">
    <title>${position.getName()}</title>
    <link rel="stylesheet" type="text/css" href="./styles.css">
    <style>
        <%@include file="styles.css"%>
    </style>
</head>

<body>
    <a href="/"> <button>Hello</button> </a>
    <a href="/divisions"> <button>Divisions</button> </a>
    <a href="/employees"> <button>Employees</button> </a>
    <a href="/positions"> <button>Positions</button> </a>
    <br>

    ID: ${position.getId()} <br>
    Name: ${position.getName()} <br>
    Division: ${dtm.getById(position.getDivisionId()).getName()} <br>
    Responsibilities: ${position.getResponsibilities()} <br>

    <h1>List of Employees:</h1>
    <table>
        <tr class="tableHeader">
            <td>Name</td>
            <td>Salary</td>
        </tr>
        <c:forEach items="${eptm.listByPosId(position.getId())}" var="emp_pos">
            <tr>
                <td>
                    <a href="/employees/${emp_pos.getEmpId()}">
                        ${etm.getById(emp_pos.getEmpId()).getFullName()}
                    </a>
                </td>
                <td>
                    ${emp_pos.getSalary()}
                </td>
            </tr>
        </c:forEach>
    </table>
</body>

</html>
