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

@WebServlet(name = "FindMovieServlet", urlPatterns = "/findMovie")
public class FindMovieServlet extends HttpServlet {

    private static final String SHOW_MOVIE_PAGE = "movie.jsp";
    private static final String ERROR_PAGE = "error.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String route = ERROR_PAGE;

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            MovieDao dao = new MovieDao();
            MovieDto dto = dao.findById(id);
            request.setAttribute("MOVIE", dto);
            route = SHOW_MOVIE_PAGE;
        } catch (SQLException | ClassNotFoundException e) {
            log("FindMovieServlet_" + e.getClass() + " : " + e.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(route);
            rd.forward(request, response);
        }
    }
}
