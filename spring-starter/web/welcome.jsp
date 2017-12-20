<%--
  Author: Anh Khue
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<h1>
    ${message}
</h1>

<p>Please tell us your name...</p>
<form action="/hello" method="post">
    <label for="name">Your name: </label>
    <input type="text" name="name" id="name">
    <input type="submit" value="Submit">
</form>
</body>
</html>
