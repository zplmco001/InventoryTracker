<%--
  Created by IntelliJ IDEA.
  User: seyitaliyaman
  Date: 4.12.2019
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send Mail</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="header.jsp" >
    <jsp:param name="pageName" value="sendMail" />
</jsp:include>
<c:out value="${requestScope.get('isAdmin')}"/>

<div class="container">
    <div class="head">
        <jsp:include page="navbar.jsp">
            <jsp:param name="pageName" value="sendMail"/>
        </jsp:include>
    </div>

    <div class="container" style="margin-left: 75px">
        <form action="sendMail" method="post">
            <div class="form-group row">
                <label for="adminEmail" class="col-sm-2 col-form-label">To</label>
                <div class="col-sm-10">
                    <select id="adminEmail" name="adminMail">
                        <c:forEach items="${requestScope.adminMailList}" var="adminMail">
                            <option>
                                ${adminMail}
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label for="userEmail" class="col-sm-2 col-form-label">From</label>
                <div class="col-sm-10">
                    <input name="userMail" type="text" readonly class="form-control-plaintext" id="userEmail" value="seyitaliyaman@gmail.com">
                </div>
            </div>

            <div class="form-group row">
                <label for="mailSubject" class="col-sm-2 col-form-label">Subject</label>
                <div class="col-sm-10">
                    <input name="mailSubject" type="text" class="form-control-plaintext" id="mailSubject">
                </div>
            </div>


            <div class="form-group">
                <label for="exampleFormControlTextarea1">Mail</label>
                <textarea name="mail" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
            </div>

            <button type="submit" class="btn btn-primary mb-2">Send Mail</button>

        </form>


    </div>



</div>

</body>
</html>
