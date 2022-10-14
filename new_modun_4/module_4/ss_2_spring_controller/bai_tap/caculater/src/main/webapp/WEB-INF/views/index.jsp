<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/14/2022
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>CACULATER</h1>

    <form action="/result" method="post">
        <input type="text" value="${number1}" name="number1">
        <input type="text" value="${number2}" name="number2">
        <p>----------------------------</p>
        <button type="submit" value="cong" name="option">Cộng(+)</button>
        <button type="submit" value="tru" name="option">Trừ(-)</button>
        <button type="submit" value="nhan" name="option">Nhân(*)</button>
        <button type="submit" value="chia" name="option">Chia(/)</button>
        <p>-----------------------------</p>
        <p>Kết quả là: ${result}</p>
    </form>
</body>
</html>
