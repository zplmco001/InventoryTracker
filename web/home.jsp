<%--
  Created by IntelliJ IDEA.
  User: fatih
  Date: 13.11.2019
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Inventory Tracker</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
</head>
<body>

<jsp:include page="header.jsp" >
    <jsp:param name="home" value="locations" />
</jsp:include>
<c:out value="${requestScope.get('isAdmin')}"/>
<div>
    <div class="container" >
        <jsp:include page="navbar.jsp" >
            <jsp:param name="pageName" value="locations" />
        </jsp:include>
    </div>
    <div style="margin-left: 175px">
        <c:out value="${requestScope.get('error')}"/>
    </div>
    <div class="container" style="margin-left: 125px;">

        <div class="row" style="margin-left: 125px;">


        </div>
        <div class="card" style="width:400px;">

            <div class="card-body">
                <h4 class="card-title">John Doe</h4>
                <p class="card-text">Some example text some example text. John Doe is an architect and engineer</p>
                <a href="#" class="btn btn-primary">See Profile</a>
            </div>
        </div>



    </div>
</div>



</body>
</html>