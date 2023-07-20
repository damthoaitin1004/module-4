<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 7/20/2023
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${msg != nul}">
    <h2>
        ${msg}
    </h2>
</c:if>
<table>
        <tr>
            <td>languages</td>
            <td>${mailBox.languages}</td>
        </tr>
        <tr>
            <td>
                Pages size
            </td>
            <td>
                    ${mailBox.pageSize}
            </td>
        </tr>
        <tr>
            <td>Spam filter</td>
            <td>
                    ${mailBox.spamFilter}
            </td>
        </tr>
        <tr>
            <td>
                Sig nature
            </td>
            <td>
                ${mailBox.sigNature}
            </td>
        </tr>
      <a href="/update"><button>Update</button></a>
</table>
</body>
</html>
