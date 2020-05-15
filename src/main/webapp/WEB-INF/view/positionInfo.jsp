<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
-->
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

    <a href="/divisions" id="btnDivisions"> <button>Divisions</button> </a>
    <a href="/employees" id="btnEmployees"> <button>Employees</button> </a>
    <a href="/positions" id="btnPositions"> <button>Positions</button> </a>
    <br>

    ID: <span id="ID">${position.getId()}</span> <br>
    Name: <span id="Name">${position.getName()}</span> <br>
    Division: <span id="Division">${position.getDivision().getName()}</span> <br>
    Responsibilities: <span id="Responsibilities">${position.getResponsibilities()}</span> <br>

    <h1>Edit position: </h1>
    <form:form method="post" action="/positions/${position.getId()}/update" modelAttribute="positionInfoRequest">
        Name: <form:input path="newName" id="newName"/>
        <input type="submit" value="Change" id="ChangeName"/>
    </form:form>
    <form:form method="post" action="/positions/${position.getId()}/update" modelAttribute="positionInfoRequest">
        Responsibilities: <form:input path="newResponsibilities" id="newResponsibilities"/>
        <input type="submit" value="Change" id="ChangeResponsibilities"/>
    </form:form>
    <form:form method="post" action="/positions/${position.getId()}/update" modelAttribute="positionInfoRequest">
        Division id: <form:input path="newDivisionId" id="newDivisionId"/>
        <input type="submit" value="Change" id="ChangeDivision"/>
    </form:form>

    <h1>Add employee: </h1>
    <form:form method="post" action="/positions/${position.getId()}/update" modelAttribute="positionInfoRequest">
        New employee id: <form:input path="newEmployeeId" id="newEmployeeId"/> <br>
        New employee salary: <form:input path="newEmployeeSalary" id="newEmployeeSalary"/> <br><br>
        <input type="submit" value="Add employee" id="addEmployee" /> <br>
    </form:form>

    <h1>Remove employee</h1>
    <form:form method="post" action="/positions/${position.getId()}/update" modelAttribute="positionInfoRequest">
        Position id: <form:input path="deleteEmployeeId" id="deleteEmployeeId"/> <br><br>
        <input type="submit" value="Remove" id="removeEmployee" /> <br>
    </form:form>



    <h1>List of Employees:</h1>
    <table>
        <tr class="tableHeader">
            <td>id</td>
            <td>Name</td>
            <td>Salary</td>
        </tr>
        <c:forEach items="${position.getEmpPos()}" var="emp_pos">
            <tr>
                <td>
                    <span id="idColumn">${emp_pos.getEmp().getId()}</span>
                </td>
                <td>
                    <a href="/employees/${emp_pos.getEmp().getId()}"
                       id=nameColumn>
                        ${emp_pos.getEmp().getFullName()}
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
