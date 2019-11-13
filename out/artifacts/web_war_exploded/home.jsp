<%--
  Created by IntelliJ IDEA.
  User: fatih
  Date: 13.11.2019
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<p> Printing</p>
<p> Printing all the products again using JSTL </p>
<c:forEach items="${requestScope.prods}" var="item">
    <p><a href="handle_login?id=${item.id}">${item.name} </a></p>
</c:forEach>



</body>
</html>
