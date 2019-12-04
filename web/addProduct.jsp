<%--
  Created by IntelliJ IDEA.
  User: fatih
  Date: 27.11.2019
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddProduct</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp" >
    <jsp:param name="pageName" value="locations" />
</jsp:include>
<c:out value="${requestScope.get('isAdmin')}"/>
<div class="container">
    <div class="head">
        <jsp:include page="navbar.jsp">
            <jsp:param name="addProduct" value="product"/>
        </jsp:include>
    </div>

    <div class="container" style="margin-top: 30px; padding: 20px;">
        <form action="addProduct" method="post">
            Name: <input type="text" name="name" size="32"><br>
            Quantity: <input type="text" name="quantity" size="32"><br>
            <input type="submit" value="send">
        </form>

    </div>



</div>




</body>
</html>
