<%@ page import="java.util.List" %>
<%@ page import="com.khuetla.starter.movie.MovieDto" %><%--
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
    List<MovieDto> dtoList = (List<MovieDto>) request.getAttribute("MOVIES_LIST");

    if (dtoList.size() < 1) {
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
        for (MovieDto dto : dtoList) {
    %>
    <tr>
        <td>
            <%= dto.getId() %>
        </td>
        <td>
            <%= dto.getName() %>
        </td>
        <td>
            <form action="/findMovie" method="get">
                <input type="hidden" name="id" value="<%=dto.getId()%>">
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
