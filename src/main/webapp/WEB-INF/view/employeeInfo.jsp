<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->
<html>

<head>
    <meta charset="utf-8">
    <title>${employee.getFullName()}</title>
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

    id: ${employee.getId()} <br>
    surname: ${employee.getSurname()} <br>
    name: ${employee.getName()} <br>
    patronymic: ${employee.getPatronymic()} <br>
    education: ${employee.getEducation()} <br>

    <h1>Positions:</h1>
    <table>
        <tr class="tableHeader">
            <td>Name</td>
            <td>Division</td>
            <td>Salary</td>
        </tr>
        <c:forEach items="${eptm.listByEmpId(employee.getId())}" var="emp_pos">
            <tr>
                <td>
                    <a href="/positions/${emp_pos.getPosId()}">
                        ${ptm.getById(emp_pos.getPosId()).getName()}
                    </a>
                </td>
                <td>
                    <a href="divisions/${ptm.getById(emp_pos.getPosId()).getDivisionId()}">
                        ${dtm.getById(ptm.getById(emp_pos.getPosId()).getDivisionId()).getName()}
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