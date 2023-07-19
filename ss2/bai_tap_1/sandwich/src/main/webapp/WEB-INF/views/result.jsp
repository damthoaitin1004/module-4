<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 7/19/2023
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${msg == null}">
    <table>
        <thead>
        <th>Number</th>
        <th>Select</th>
        </thead>
        <c:forEach var="sandwich" items="${listSandwich}" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${sandwich}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${msg != null}">
    <h1>${msg}</h1>
</c:if>
</body>
</html>
