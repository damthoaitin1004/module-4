<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 7/19/2023
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>

</head>
<body>

<form class="row g-3 needs-validation" novalidate action="/save" method="post" style="width: 60%;height: 30%;margin-left: 10%">
    <div class="col-md-12"><h1>Caculator</h1>
    </div>
    <div class="col-md-6">
        <label for="numberOne" class="form-label">First number</label>
        <input type="number" class="form-control" id="numberOne" name="numberOne" required>
    </div>
    <div class="col-md-6">
        <label for="numberTwo" class="form-label">Last number</label>
        <input type="number" class="form-control" id="numberTwo" name="numberTwo" required>

    </div>
    <div class="col-md-3">
        <button value="+" name="caculator">Addition(+)</button>
    </div>
    <div class="col-md-3">
        <button name="caculator" value="-">Subtraction(-)</button>
    </div>
    <div class="col-md-3">
        <button name="caculator" value="*">Mutiplication(X)</button>
    </div>
    <div class="col-md-3">
        <button name="caculator" value="/">Division(/)</button>
    </div>
</form>
<h1>${result}</h1>
<c:if test="${msg !=null}">
    <h1>${msg}</h1>
</c:if>
</body>
</html>
