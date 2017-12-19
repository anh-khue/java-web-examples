package com.khuetla.starter.servlet;

import com.khuetla.starter.movie.MovieDao;
import com.khuetla.starter.movie.MovieDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "GetAllMoviesServlet", urlPatterns = "/allMovies")
public class GetAllMoviesServlet extends HttpServlet {

    private static final String SHOW_ALL_MOVIES_PAGE = "all_movies.jsp";
    private static final String ERROR_PAGE = "error.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String route = ERROR_PAGE;

        try {
            MovieDao dao = new MovieDao();
            List<MovieDto> dtoList = dao.findAll();
            request.setAttribute("MOVIES_LIST", dtoList);
            route = SHOW_ALL_MOVIES_PAGE;
        } catch (SQLException | ClassNotFoundException e) {
            log("GetAllMoviesServlet_" + e.getClass() + " : " + e.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(route);
            rd.forward(request, response);
        }
    }
}
