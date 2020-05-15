<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
-->
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

    <a href="/divisions" id="btnDivisions"> <button>Divisions</button> </a>
    <a href="/employees" id="btnEmployees"> <button>Employees</button> </a>
    <a href="/positions" id="btnPositions"> <button>Positions</button> </a>
    <br>

    ID: <span id="ID">${employee.getId()}</span> <br>
    surname: <span id="Surname">${employee.getSurname()}</span> <br>
    name: <span id="Name">${employee.getName()}</span> <br>
    patronymic: <span id="Patronymic">${employee.getPatronymic()}</span> <br>
    education: <span id="Education">${employee.getEducation()}</span> <br>

    <h1>Edit employee: </h1>
    <form:form method="post" action="/employees/${employee.getId()}/update" modelAttribute="employeeInfoRequest">
        Surname: <form:input path="newSurname" id="newSurname"/>
        <input type="submit" value="Change" id="ChangeSurname"/>
    </form:form>
    <form:form method="post" action="/employees/${employee.getId()}/update" modelAttribute="employeeInfoRequest">
        Name: <form:input path="newName" id="newName"/>
        <input type="submit" value="Change" id="ChangeName"/>
    </form:form>
    <form:form method="post" action="/employees/${employee.getId()}/update" modelAttribute="employeeInfoRequest">
        Patronymic: <form:input path="newPatronymic" id="newPatronymic"/>
        <input type="submit" value="Change" id="ChangePatronymic"/>
    </form:form>
    <form:form method="post" action="/employees/${employee.getId()}/update" modelAttribute="employeeInfoRequest">
        Education: <form:input path="newEducation" id="newEducation"/>
        <input type="submit" value="Change" id="ChangeEducation"/>
    </form:form>

    <h1>Add position: </h1>
    <form:form method="post" action="/employees/${employee.getId()}/update" modelAttribute="employeeInfoRequest">
        New position id: <form:input path="newPositionId" id="newPositionId"/> <br>
        New position salary: <form:input path="newPositionSalary" id="newPositionSalary"/> <br><br>
        <input type="submit" value="Add position" id="addPosition" /> <br>
    </form:form>

    <h1>Remove position</h1>
    <form:form method="post" action="/employees/${employee.getId()}/update" modelAttribute="employeeInfoRequest">
        Position id: <form:input path="deletePositionId" id="deletePositionId"/> <br><br>
        <input type="submit" value="Remove position" id="removePosition" /> <br>
    </form:form>

    <h1>Positions:</h1>
    <table>
        <tr class="tableHeader">
            <td>id</td>
            <td>Name</td>
            <td>Division</td>
            <td>Salary</td>
        </tr>
        <c:forEach items="${employee.getEmpPos()}" var="emp_pos">
            <tr>
                <td>
                    <span id="idColumn">${emp_pos.getPos().getId()}</span>
                </td>
                <td>
                    <a href="/positions/${emp_pos.getPos().getId()}"
                       id="positionNameColumn">
                        ${emp_pos.getPos().getName()}
                    </a>
                </td>
                <td>
                    <a href="/divisions/${emp_pos.getPos().getDivision().getId()}"
                       id="divisionNameColumn">
                        ${emp_pos.getPos().getDivision().getName()}
                    </a>
                </td>
                <td>
                    <span id="salaryColumn">${emp_pos.getSalary()}</span>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>

</html>
