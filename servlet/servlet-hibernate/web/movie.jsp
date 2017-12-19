<%@ page import="com.khuetla.hibernate.entity.Movie" %>
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
    <title>Movie Detail</title>
</head>
<body>
<%
    Movie movie = (Movie) request.getAttribute("MOVIE");
%>
<form action="#" method="post">
    <label for="id">
        ID
    </label>
    <input type="text" name="id" id="id"
           value="<%=movie.getId()%>">
    <label for="name">
        Name
    </label>
    <input type="text" name="name" id="name"
           value="<%=movie.getName()%>">
</form>
</body>
</html>
