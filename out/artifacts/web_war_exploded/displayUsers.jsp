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

    <div class="container" style="margin-left: 75px">


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
            <tr>
                <th scope="row">1</th>
                <td>deneme</td>
                <td>deneme</td>
                <td>deneme</td>
                <td>deneme</td>
                <td>deneme</td>
                <td> <button>edit</button> </td>
                <td> <button>delete</button>  </td>

            </tr>
            <tr>
                <th scope="row">1</th>
                <td>deneme</td>
                <td>deneme</td>
                <td>deneme</td>
                <td>deneme</td>
                <td>deneme</td>
                <td> <button>edit</button> </td>
                <td> <button>delete</button>  </td>

            </tr>
            <tr>
                <th scope="row">1</th>
                <td>deneme</td>
                <td>deneme</td>
                <td>deneme</td>
                <td>deneme</td>
                <td>deneme</td>
                <td> <button>edit</button> </td>
                <td> <button>delete</button>  </td>

            </tr>
            <tr>
                <th scope="row">1</th>
                <td>deneme</td>
                <td>deneme</td>
                <td>deneme</td>
                <td>deneme</td>
                <td>deneme</td>
                <td> <button>edit</button> </td>
                <td> <button>delete</button>  </td>

            </tr>
            <tr>
                <th scope="row">1</th>
                <td>deneme</td>
                <td>deneme</td>
                <td>deneme</td>
                <td>deneme</td>
                <td>deneme</td>
                <td> <button>edit</button> </td>
                <td> <button>delete</button>  </td>

            </tr>

            </tbody>


        </table>



    </div>



</div>

</body>
</html>
