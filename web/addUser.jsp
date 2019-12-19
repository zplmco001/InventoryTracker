<%--
  Created by IntelliJ IDEA.
  User: mehmetcanolgun
  Date: 2.12.2019
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inventory Tracker</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <style>

        #myInput {
            background-position: 10px 10px;
            background-repeat: no-repeat;
            width: 100%;
            font-size: 16px;
            padding: 12px 20px 12px 40px;
            border: 1px solid #ddd;
            margin-bottom: 12px;
        }
    </style>
</head>
<body>

<jsp:include page="header.jsp" >
    <jsp:param name="pageName" value="addUser" />
</jsp:include>
<c:out value="${requestScope.get('isAdmin')}"/>
<div class="container">
    <div class="head">
        <jsp:include page="navbar.jsp">
            <jsp:param name="pageName" value="addUser"/>
        </jsp:include>
    </div>



</div>




</body>
</html>
