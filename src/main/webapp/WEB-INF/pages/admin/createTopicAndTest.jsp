<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 07.12.2020
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create topic page</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/admin/createTopicAndTest.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/admin/general.css" />">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body class="myBody">
<form method="post" action="/admin/createTopicAndTest">
    <table class="createTopicAndTest">
        <tr>
            <td>
                <input name="topicName" type="text" list="topicList" placeholder="Выберите топик"
                       id="topicName" class="myRow" required>
                <datalist id="topicList">
                    <c:forEach items="${topicList}" var="topic">
                    <option value="${topic.name}">
                        </c:forEach>
                </datalist>
            </td>
        </tr>
        <tr>
            <td>
                <input name="topicDescription" type="text" placeholder="Описание топика"
                       id="topicDescription" class="myRow" required>
            </td>
        </tr>
        <tr>
            <td>
                <input name="newTestName" type="text" placeholder="Задайте имя теста" id="newTestName" class="myRow" >
            </td>
        </tr>
        <tr>
            <td>
                <input name="newTestDescription" type="text" placeholder="Задайте описание теста"
                       id="newTestDescription" class="myRow">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Сохранить топик и тест" class="myCreateTopicAndTestButton"/>
            </td>
        </tr>
    </table>
</form>
<form action="/admin/goHomeAdmin">
    <input type="submit" value="Назад" class="myCreateTopicAndTestButton toHomePage">
</form>

<script>
    $().ready(function () {
        $("#topicName").change(function (event) {
            $.ajax({
                url: "/admin/selectedTopic",
                type: "GET",
                dateType: "json",
                data: {topic: $(event.target).val()}
            })
                .done(function (data) {
                    setDescription(data)
                })
                .fail(function (xhr, status, error) {
                    alert(xhr.responseText + " " + status + " " + error)
                })
        })
    });

    var setDescription = function (data) {
        $('#topicDescription').val(data);
    }
</script>

</body>
</html>
