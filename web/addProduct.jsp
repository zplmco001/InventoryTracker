<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products - Inventory Tracker</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script>
        var index = 3;
        function add() {

            var div = document.getElementById('new_chq');
            console.log();
            div.innerHTML = div.innerHTML+'<div class=col-md-3>' +
                '<input type="text" name="key-'+index+'" class="form-control validate"></div>' +
                '<div class="col-md-9"><input type="text" name="value-'+index+'" class="form-control validate"><br>' +
                '</div>'
            index = index+1;
            console.log(index);
        }
    </script>
</head>
<body>
<jsp:include page="header.jsp" >
    <jsp:param name="pageName" value="addProduct" />
</jsp:include>
<c:out value="${requestScope.get('isAdmin')}"/>
<div class="container">
    <div class="head">
        <jsp:include page="navbar.jsp">
            <jsp:param name="pageName" value="addProduct"/>
        </jsp:include>
    </div>



    <div class="container" style="position: absolute; left: 150px;">

        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Product Name</th>
                <th scope="col">Quantity</th>
                <th scope="col">Attributes</th>
            </tr>
            </thead>
            <tbody>
                    <c:forEach items="${requestScope.items}" var="itemval" varStatus="count">
                        <tr>
                                <td>${itemval.name}</td>
                                <td>${itemval.quantity}</td>


                                <td>
                                    <c:forEach var="type" items="${itemval.pMap}">
                                        <c:if test="${type.key != '_id'}">
                                            <c:out value="${type.key}:${type.value}"/><br>
                                        </c:if>
                                    </c:forEach>
                                </td>



                            <td>
                                <button type="button" data-toggle="modal" data-target="#edit-user${count.index}" style="width: 78px !important" class="btn btn-primary" >Edit</button>
                                <button type="button" data-toggle="modal" data-target="#delete-user${count.index}" style="width: 78px !important" class="btn btn-danger">Delete</button>
                            </td>

                        </tr>
                        <div>
                            <div class="modal fade" id="edit-user${count.index}" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Modal Header</h4>
                                        </div>
                                        <div class="modal-body">
                                            <form action="displayProducts" method="post">


                                                Product Name: <input value="${itemval.name}" type="text" name="productName" size="32" class="form-control validate" contenteditable="true">
                                                Product Quantity: <input value="${itemval.quantity}" type="text" name="productQuantity" size="32" class="form-control validate" contenteditable="true">

                                                <c:forEach var="typec" items="${itemval.pMap}" varStatus="cnt">


                                                    <input value="${count.index}" type="hidden" name="editedMap" size="32" readonly class="form-control validate">
                                                    <c:choose>
                                                        <c:when test="${typec.key == '_id'}">
                                                            <input value="${typec.value}" type="hidden" name="editedId" size="32" readonly class="form-control validate">
                                                        </c:when>

                                                        <c:otherwise>
                                                            ${typec.key}: <input value="${typec.value}" type="text" name="prop${cnt.index}" size="32" class="form-control validate" contenteditable="true">
                                                        </c:otherwise>

                                                    </c:choose>

                                                </c:forEach>


                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                    <input type="submit" value="Save changes" class="btn btn-primary">
                                                </div>
                                            </form>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>

                        <div>
                            <div class="modal fade" id="delete-user${count.index}" role="dialog">
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
                                        <form action="displayProducts" method="post">
                                            <c:forEach var="typec" items="${itemval.pMap}" >
                                                <c:if test="${typec.key == '_id'}">
                                                    <input value="${typec.value}" type="hidden" name="deletedId" size="32" readonly class="form-control validate">
                                                </c:if>
                                            </c:forEach>

                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Dismiss</button>
                                                <input type="submit" value="Delete" class="btn btn-primary">
                                            </div>
                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

            </tbody>
        </table>

        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#addProductModal">Add Product</button>

        <div class="modal fade" id="addProductModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Add Product</h4>
                    </div>
                    <div class="modal-body">
                        <form action="displayProducts" method="post">

                            <div id="new_chq">
                                <div class="col-md-3">
                                    <label class="mr-sm-2">Name: </label>
                                </div>
                                <div class="col-md-9">
                                    <input type="text" name="name" class="form-control validate"><br>
                                </div>
                                <div class="col-md-3">
                                    <label class="mr-sm-2">Quantity: </label>
                                </div>
                                <div class="col-md-9">
                                    <input type="text" name="quantity" class="form-control validate"><br>
                                </div>
                            </div>

                            <button type="button" onclick="add()" style="margin: 10px;">Add Attribute</button>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Save changes</button>
                            </div>
                        </form>

                    </div>
                </div>

            </div>
        </div>

    </div>


</div>
</body>
</html>
