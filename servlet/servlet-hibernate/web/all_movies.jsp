<%@ page import="java.util.List" %>
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
    <title>All Movies</title>
</head>
<body>
<%
    List<Movie> movies = (List<Movie>) request.getAttribute("MOVIES_LIST");

    if (movies.size() < 1) {
%>
<h2>No record found!</h2>
<%
} else {
%>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Detail</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Movie movie : movies) {
    %>
    <tr>
        <td>
            <%= movie.getId() %>
        </td>
        <td>
            <%= movie.getName() %>
        </td>
        <td>
            <form action="/findMovie" method="get">
                <input type="hidden" name="id" value="<%=movie.getId()%>">
                <input type="submit" value="Detail">
            </form>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<%
    }
%>
<form action="add_movie.jsp" method="get">
    <input type="submit" value="Add new Movie">
</form>
</body>
</html>
