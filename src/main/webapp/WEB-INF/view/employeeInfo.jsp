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

    <a href="/divisions"> <button>Divisions</button> </a>
    <a href="/employees"> <button>Employees</button> </a>
    <a href="/positions"> <button>Positions</button> </a>
    <br>

    ID: <p id="ID">${employee.getId()}</p> <br>
    surname: ${employee.getSurname()} <br>
    name: ${employee.getName()} <br>
    patronymic: ${employee.getPatronymic()} <br>
    education: ${employee.getEducation()} <br>

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

    <h1>New position: </h1>
    <form:form method="post" action="/employees/${employee.getId()}/update" modelAttribute="employeeInfoRequest">
        New position id: <form:input path="newPositionId" id="newPositionId"/> <br>
        New position salary: <form:input path="newPositionSalary" id="newPositionSalary"/> <br><br>
        <input type="submit" value="Add position" id="addPosition" /> <br>
    </form:form>

    <h1>Delete position</h1>
    <form:form method="post" action="/employees/${employee.getId()}/update" modelAttribute="employeeInfoRequest">
        Position id: <form:input path="deletePositionId" id="deletePositionId"/> <br><br>
        <input type="submit" value="Delete" id="deletePosition" /> <br>
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
                    ${emp_pos.getPos().getId()}
                </td>
                <td>
                    <a href="/positions/${emp_pos.getPos().getId()}">
                        ${emp_pos.getPos().getName()}
                    </a>
                </td>
                <td>
                    <a href="/divisions/${emp_pos.getPos().getDivision().getId()}">
                        ${emp_pos.getPos().getDivision().getName()}
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
