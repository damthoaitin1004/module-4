<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 7/18/2023
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Chuyển đổi đô la Mỹ ra VN đồng</h1>
<form action="/home" method="post">
    <input name="number" placeholder="Nhập số lượng cần chuyển đổi" type="number" required>
    <button type="submit">Kết quả</button>
</form>
<div><c:out value="${result}"></c:out></div>
</body>
</html>
