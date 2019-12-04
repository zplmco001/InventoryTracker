<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .sidenav {
        height: 100%;
        width: 160px;
        position: fixed;
        z-index: 1;
        top: 51px;
        left: 0;
        background-color: rgb(210,230,240);
        overflow-x: hidden;
        padding-top: 20px;
    }
    .mainMenu {
        padding: 6px 8px 6px 16px;
        text-decoration: none;
        font-size: 25px;
        color: rgb(41,102,169);
        display: block;
    }

    .subMenu{

        padding: 6px 8px 6px 16px;
        text-decoration: none;
        font-size: 15px;
        color: rgb(41,102,169);
        display: block;

    }

    .sidenav a:hover {
        color: #f1f1f1;
    }
    .main {
        margin-left: 160px; /* Same as the width of the sidenav */
        font-size: 28px; /* Increased text to enable scrolling */
        padding: 0px 10px;
    }
    @media screen and (max-height: 450px) {
        .sidenav {padding-top: 15px;}
        .sidenav a {font-size: 18px;}
    }
</style>
</head>
<body>
<div id="mySidenav" class="sidenav">
    <a <c:if test="${param.pageName == 'home'}">href="#" </c:if> class="mainMenu" href="#">Home</a>
    <a <c:if test="${param.pageName == 'users'}">href="#" </c:if> class="mainMenu" href="#">Users</a>
    <a <c:if test="${param.pageName == 'addUser'}">href="#" </c:if> class="subMenu" href="addUser">Add User</a>
    <a <c:if test="${param.pageName == 'displayUsers'}">href="#" </c:if> class="subMenu" href="#">Display Users</a>
    <a <c:if test="${param.pageName == 'inventory'}">href="#" </c:if> class="mainMenu" href="#">Inventory</a>
    <a <c:if test="${param.pageName == 'addProduct'}"> href="#" </c:if> class="subMenu" href="addProduct">Add Product</a>
    <a <c:if test="${param.pageName == 'editProduct'}">href="#" </c:if> class="subMenu" href="#">Edit Product</a>
    <a <c:if test="${param.pageName == 'sendMail'}">href="#" </c:if> class="mainMenu" href="#">Send Mail</a>
</div>
</body>
