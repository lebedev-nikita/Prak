<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <h2> Create division: </h2>
    <form:form method="post" action="/divisions" modelAttribute="postDivision">
        Division name: <form:input path="name"/> <br>
        Head division id: <form:input path="headDivId"/> <br>
        Chief id: <form:input path="chiefId"/> <br><br>
        <input type="submit" value="Submit"/>
    </form:form>

    <h2> Filter divisions: </h2>
    <form action="/divisions" method="get">
        Division name: <input type="text" name="getDivName" value="${param.getDivName}"> <br>
        Head division name: <input type="text" name="getHeadDivName" value="${param.getHeadDivName}"> <br>
        Chief name: <input type="text" name="getChiefName" value="${param.getChiefName}"> <br>
        Chief surname: <input type="text" name="getChiefSurame" value="${param.getChiefSurame}"> <br>
        Chief patronymic: <input type="text" name="getChiefPatronymic" value="${param.getChiefPatronymic}"> <br><br>
        <input type="submit" name="" value="Submit">
    </form>

    <h2>List of divisions: </h2>
    <table>
        <tr class="tableHeader">
            <th>Division name</th>
            <th>Head division name</th>
            <th>Chief name</th>
        </tr>
        <c:forEach items="${dtm.listLike(param.getDivName, param.getHeadDivName, param.getChiefName, param.chiefSurname, param.getChiefPatronymic)}" var="division">
            <tr>
                <td>
                    <a href="/divisions/${division.getId()}">
                        ${division.getName()}
                    </a>
                </td>
                <td>
                    <a href="/divisions/${division.getHeadDiv().getId()}">
                        ${division.getHeadDiv().getName()}
                    </a>
                </td>
                <td>
                    <!-- Получаем имя руководителя -->
                    <a href="/employees/${division.getChief().getId()}">
                        ${division.getChief().getFullName()}
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>

</html>
