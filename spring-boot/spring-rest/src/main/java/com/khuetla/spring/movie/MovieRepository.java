package com.khuetla.spring.movie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author : Anh Khue
 */

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findAll();

    Movie findById(int id);

}
