<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <h2>Please Login before Shopping</h2>
  <form action="handle_login" method="post">
    User Name: <input type="text" name="username" size="32"><br>
    Password: <input type="password" name="pwd" size="32"><br>
    <input type="submit" value="send">
  </form>
  <%
    String id = session.getId();
  %>
  <p> Your session id: <%= id %> </p>

  </body>
</html>