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
        <input type="submit" name="" value="Submit">
    </form>

    <% DivisionTableManager dtm = new DivisionTableManager(); %>
    <c:if test="${divisionList.size() != 0}">
        <h3>Table of all divisions: </h3>
        <table>
            <tr class="tableHeader">
                <td>name</td>
                <td>id</td>
                <td>headDivName</td>
                <td>headDivId</td>
                <td>chiefId</td>
            </tr>
            <% String testStr = "testString"; %>
            <c:forEach items="${divisionList}" var="division">
                <tr>
                    <td> ${division.getName()} </td>
                    <td> ${division.getId()} </td>
                    <td> <c:out value="${dtm.getById(1).getName()}" escapeXml="false" /> </td>
                    <td> ${division.getHeadDivId()} </td>
                    <td> ${division.getChiefId()} </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</body>

</html>
