<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.db.DAO.DivisionTableManager" %>
<%@ page import="com.db.DAO.EmployeeTableManager" %>
<%@ page import="com.db.DAO.PositionTableManager" %>
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

    <a href="/"> <button>Hello</button> </a>
    <a href="/divisions"> <button class="selectedButton">Divisions</button> </a>
    <a href="/employees"> <button>Employees</button> </a>
    <a href="/positions"> <button>Positions</button> </a>
    <br><br>

    <h2> Filter: </h2>
    <form action="/divisions" method="get">
        Division name: <input type="text" name="divName" value=""> <br>
        Head division name: <input type="text" name="headDivName" value=""> <br>
        Chief name: <input type="text" name="chiefName" value=""> <br>
        Chief surname: <input type="text" name="chiefSurame" value=""> <br>
        Chief patronymic: <input type="text" name="chiefPatronymic" value=""> <br><br>
        <input type="submit" name="" value="Submit">
    </form>

    <h3>Table of all divisions: </h3>
    <table>
        <tr class="tableHeader">
            <td>name</td>
            <td>headDivName</td>
            <td>chiefName</td>
        </tr>
        <c:forEach items="${dtm.listAllDivisions()}" var="division">
            <tr>
                <td>
                    <a href="/divisions/${division.getId()}">
                        ${division.getName()}
                    </a>
                </td>
                <td>
                    <a href="/divisions/${division.getHeadDivId()}">
                        ${dtm.getById(division.getHeadDivId()).getName()}
                    </a>
                </td>
                <td>
                    <a href="/employees/${division.getChiefId()}">
                        ${etm.getById(division.getChiefId()).getFullName()}
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>

</html>
