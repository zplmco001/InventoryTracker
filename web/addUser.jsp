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

    <div style="margin: 100px;">

        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#addProductModal">Open Modal</button>

        <div class="modal fade" id="addProductModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Modal Header</h4>
                    </div>
                    <div class="modal-body">
                        <form action="addUser" method="post" class="form-inline" >
                            <label class=mr-sm-2">Name</label>
                            <input type="text" class="form-control validate" name="firstName"><br>

                            <label class=mr-sm-2">LastName</label>
                            <input type="text" class="form-control validate" name="lastName"><br>

                            <label class=mr-sm-2">Username</label>
                            <input type="text" class="form-control validate" name="username"><br>

                            <label class=mr-sm-2">Phone Number</label>
                            <input type="text" class="form-control validate" name="phone"><br>

                            <label class="mr-sm-2">Email address:</label>
                            <input type="email" class="form-control validate" name="email"><br>

                            <label class="mr-sm-2">Password:</label>
                            <input type="password" class="form-control validate" name="password"><br>

                            <label class="mr-sm-2">IsAdmin</label>
                            <select name="item">
                                <option value="false">false</option>
                                <option value="true">true</option>

                            </select>

                            <!--<div class="form-check mb-2 mr-sm-2">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="checkbox"> Remember me
                                </label>
                            </div> -->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary mb-2">Submit</button>

                            </div>

                        </form>

                    </div>

                </div>

            </div>
        </div>

    </div>

    <div class="container" style="margin-left: 75px">


    </div>



</div>




</body>
</html>
