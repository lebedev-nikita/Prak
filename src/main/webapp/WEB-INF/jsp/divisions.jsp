<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <title>Divisions</title>
</head>
<body>

<h2>Hello divisions!</h2>
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
