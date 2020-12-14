<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 11.11.2020
  Time: 1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Hello, Admin</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/admin/general.css" />">
</head>
<body class="myBody">

<div>
    <br> <a class="myLink" href="<c:url value="/admin/createTopicAndTest"/>">Созадть топик и тест</a><br>
    <br> <a class="myLink" href="<c:url value="/admin/createTest"/>">Наполнить тест</a><br>
    <br> <a class="myLink" href="<c:url value="/admin/createUser"/>">Создать пользователя</a><br>
    <br> <a class="myLink" href="<c:url value="/admin/showStatistic"/>">Статистика</a><br>
    <br> <a class="myLink" href="<c:url value="/logout"/>">Выход</a><br>
</div>

</body>
</html>
