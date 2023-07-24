<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 7/18/2023
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>
<body>
<header>
    <div class="row bg-dark ">
        <div class="col-md-3">
            <img src="https://dictionary.cambridge.org/vi/external/images/logo-lrg.png?version=5.0.330"
                 style="width: 100%;height: 100%;margin-left: 10px">
        </div>
        <div class="col-md-9" align="center" style="margin-top: 30px">
            <form style="display: inline" action="/home" method="post">
                <input type="search" name="search" style="width: 60%;border-radius: 10px" placeholder="Enter meaningful word">
                <button type="submit" class="btn btn-outline-light" style=" border-radius: 10px">Search</button>
            </form>
            <div style="display: inline">
                <div></div>
            </div>
        </div>
    </div>
</header>
<div style="width: 60%;margin-left: 20%">
    <h1>
        ${name}
    </h1>
    <hr>
       <h3>${msg}</h3>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</html>
<input type="checkbox" id="1">
<label for="1"></label>