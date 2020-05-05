<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->
<html>

<head>
    <meta charset="utf-8">
    <title>Hello</title>
    <link rel="stylesheet" type="text/css" href="./styles.css">
    <style><%@include file="styles.css"%></style>
</head>
<body>

<a href="/">          <button>Hello</button> </a>
<a href="/divisions"> <button>Divisions</button> </a>
<a href="/employees"> <button>Employees</button> </a>
<a href="/positions"> <button>Positions</button> </a>
<br>
Division id: ${divisionId} <br>

</body>
</html>
