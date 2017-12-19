package com.khuetla.hibernate.servlet;

import com.khuetla.hibernate.entity.Movie;
import com.khuetla.hibernate.service.MovieService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
            MovieService service = new MovieService();
            List<Movie> movies = service.findAll();
            request.setAttribute("MOVIES_LIST", movies);
            route = SHOW_ALL_MOVIES_PAGE;
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(route);
            rd.forward(request, response);
        }
    }
}
