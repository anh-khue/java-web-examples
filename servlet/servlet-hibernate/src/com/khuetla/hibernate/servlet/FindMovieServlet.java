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

            MovieService service = new MovieService();
            Movie movie = service.findById(id);
            request.setAttribute("MOVIE", movie);
            route = SHOW_MOVIE_PAGE;
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(route);
            rd.forward(request, response);
        }
    }
}
