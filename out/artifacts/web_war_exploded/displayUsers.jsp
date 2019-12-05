<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: seyitaliyaman
  Date: 4.12.2019
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display Users</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="header.jsp" >
    <jsp:param name="pageName" value="displayUsers" />
</jsp:include>
<c:out value="${requestScope.get('isAdmin')}"/>

<div class="container">
    <div class="head">
        <jsp:include page="navbar.jsp">
            <jsp:param name="pageName" value="displayUsers"/>
        </jsp:include>
    </div>

    <div class="container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">User ID</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Phone Number</th>
                <th scope="col">E-Mail</th>
                <th scope="col">Product Count</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.userList}" var="item" >
                <tr>
                <th scope="row">${item.getId}</th>
                <td>${item.firstname}</td>
                <td>${item.lastname}</td>
                <td>${item.phoneNumber}</td>
                <td>${item.email}</td>
                <td>${item.id}</td>
                <td> <button type="button" data-toggle="modal" data-target="#edit-user" style="width: 78px !important" class="btn btn-primary ">Edit</button>
                    <button type="button" data-toggle="modal" data-target="#delete-user" style="width: 78px !important" class="btn btn-danger">Delete</button>  </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div style="margin: 100px;">
            <div class="modal fade" id="edit-user" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Modal Header</h4>
                        </div>
                        <div class="modal-body">
                            <form action="displayUsers" method="post">
                                First Name: <input type="text" name="name" size="32" class="form-control validate"><br>
                                Last Name: <input type="text" name="quantity" size="32" class="form-control validate"><br>
                                Phone Number: <input type="text" name="quantity" size="32" class="form-control validate"><br>
                                E-Mail: <input type="text" name="quantity" size="32" class="form-control validate"><br>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div style="margin: 100px;">
            <div class="modal fade" id="delete-user" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Delete User</h4>
                        </div>
                        <div class="modal-body">
                            <h3>Are you sure?</h3>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Dismiss</button>
                            <button type="button" class="btn btn-primary">Delete</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </div>
</div>
</body>
</html>
