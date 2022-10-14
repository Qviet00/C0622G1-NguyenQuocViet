<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/16/2022
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<center>
<h1>Bảng báo gia vị cho Sandwich</h1>
<p>---------------------------------------------</p>
<form action="/result">
    <c:forEach var="condiment" items="${condimentList}">
        <input type="checkbox" value="${condiment.name}" name="condiment">${condiment.name}
    </c:forEach>
        <button type="submit">Save</button>
</form>
<p>---------------------------------------------</p>
<c:forEach var="condiment" items="${condiment}">
    <p>Gia vị đi kèm: ${condiment}</p>
</c:forEach>
</center>
</body>
</html>
