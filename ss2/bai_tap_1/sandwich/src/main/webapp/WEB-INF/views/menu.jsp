<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 7/19/2023
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiment</h1>
<form method="post" action="/result">
    <label for="Lettuce"><input name="sandwich" id="Lettuce" value="Lettuce" type="checkbox">Lettuce</label>
    <label for="Tomato"><input name="sandwich" id="Tomato" value="Tomato" type="checkbox">Tomato</label>
    <label for="Mustard"><input name="sandwich" id="Mustard" value="Mustard" type="checkbox">Mustard</label>
    <label for="Sprouts"><input name="sandwich" id="Sprouts" value="Sprouts" type="checkbox">Sprouts</label>
    <button type="submit">Save</button>
</form>
</body>
</html>
