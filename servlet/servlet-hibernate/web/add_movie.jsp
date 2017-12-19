<%--
  Created by IntelliJ IDEA.
  User: Anh Khue
  Date: 19/12/17
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Movie</title>
</head>
<body>
<form action="/addMovie" method="post">
    <label for="id">
        ID
    </label>
    <input type="text" name="id" id="id" value="Auto generated" disabled>
    <label for="name">
        Name
    </label>
    <input type="text" name="name" id="name">
    <input type="submit" value="Add">
</form>
</body>
</html>
