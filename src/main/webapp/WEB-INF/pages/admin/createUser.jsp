<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 15.11.2020
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CreateUser</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/admin/createUser.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/admin/general.css" />">
</head>
<body class="myBody">
<div>
    <form:form method="post" action="/admin/createUser" modelAttribute="user">
        <table class="createUser">
            <tr>
                <td><form:checkboxes path="roleSet" items="${allRoles}" multiple="true" itemValue="roleId" itemLabel="role" cssClass="myRow role"/></td>
            </tr>
            <tr>
                <td><form:input path="lastName" placeholder="Фамилия" required="true" cssClass="myRow"/></td>
            </tr>
            <tr>
                <td><form:input path="firstName" placeholder="Имя" required="true" cssClass="myRow"/></td>
            </tr>
            <tr>
                <td><form:input path="login" placeholder="Логин" required="true" cssClass="myRow"/></td>
            </tr>
            <tr>
                <td><form:password path="password" placeholder="Пароль" required="true" cssClass="myRow"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Сохранить пользователя" class="myCreateUserButton"/></td>
            </tr>
        </table>
    </form:form>
</div>

<form action="/admin/goHomeAdmin">
    <input type="submit" value="Назад" class="myCreateUserButton toHomePage">
</form>
</body>
</html>
