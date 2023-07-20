<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 7/20/2023
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="mailBox" action="/update" method="post">
    <table>

        <tr>
            <td>Languages</td>
            <td><form:select path="languages" items="${languages}"/></td>
        </tr>
        <tr>
            <td>
                Page Size
            </td>
            <td>Show
                <form:select path="pageSize" items="${pageSize}"/>
                emails per page
            </td>
        </tr>
        <tr>
            <td>
                Spam filter
            </td>
            <td>
                <form:checkbox path="spamFilter" value="true"/>
                 Enable spams filter
            </td>
        </tr>
        <tr>
            <td>
                Signature
            </td>
            <td>
                <form:textarea path="sigNature"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><form:button>
                Update
            </form:button>
                <a href="/home">
                    <button>
                    Cancel
                    </button>
                </a>
            </td>
        </tr>
    </table>


</form:form>
</body>
</html>
