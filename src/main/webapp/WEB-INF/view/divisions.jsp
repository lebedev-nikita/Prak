<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->
<html>

<head>
    <meta charset="utf-8">
    <title>Divisions</title>
    <link rel="stylesheet" type="text/css" href="./styles.css">
    <style><%@include file="styles.css"%></style>
</head>
<body>

<a href="/">          <button>Hello</button> </a>
<a href="/divisions"> <button class="selectedButton">Divisions</button>    </a>
<a href="/employees"> <button>Employees</button> </a>
<a href="/positions"> <button>Positions</button> </a>
<br>

<c:if test="${divisionList.size() != 0}">
  <h3>List of all divisions: </h3>
  <c:forEach items="${divisionList}" var="division">
    name: ${division.getName()} <br>
    id: ${division.getId()} <br>
    headDivId: ${division.getHeadDivId()} <br>
    chiefId: ${division.getChiefId()} <br>
    <br>
  </c:forEach>
</c:if>

</body>
</html>
