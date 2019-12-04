<%--
  Created by IntelliJ IDEA.
  User: mehmetcanolgun
  Date: 2.12.2019
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inventory Tracker</title>
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
            <jsp:param name="addUser" value="addUser"/>
        </jsp:include>
    </div>

    <div class="container" >
        <form class="form-inline" >
            <label for="email" class="mr-sm-2">Email address:</label>
            <input type="email" class="form-control mb-2 mr-sm-2" id="email">
            <label for="pwd" class="mr-sm-2">Password:</label>
            <input type="password" class="form-control mb-2 mr-sm-2" id="pwd">
            <div class="form-check mb-2 mr-sm-2">
                <label class="form-check-label">
                    <input class="form-check-input" type="checkbox"> Remember me
                </label>
            </div>
            <button type="submit" class="btn btn-primary mb-2">Submit</button>
        </form>

    </div>



</div>




</body>
</html>
