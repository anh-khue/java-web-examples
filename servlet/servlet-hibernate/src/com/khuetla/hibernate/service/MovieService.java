package com.khuetla.hibernate.service;

import com.khuetla.hibernate.entity.Movie;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

import com.khuetla.hibernate.config.HibernateUtils;

/**
 * @author : Anh Khue
 */

public class MovieService {

    public List<Movie> findAll() {

        Session session = HibernateUtils.getSession();

        try {
            return session
                    .createQuery("from Movie", Movie.class)
                    .getResultList();
        } finally {
            session.close();
        }
    }

    public Movie findById(int id) {

        Session session = HibernateUtils.getSession();

        try {
            return session.find(Movie.class, id);
        } finally {
            session.close();
        }
    }

    public Serializable add(String name) {
        Session session = HibernateUtils.getSession();

        try {
            Movie movie = new Movie();
            movie.setName(name);
            return session.save(movie);
        } finally {
            session.close();
        }
    }

}
