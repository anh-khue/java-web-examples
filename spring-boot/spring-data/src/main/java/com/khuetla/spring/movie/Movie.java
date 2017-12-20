package com.khuetla.spring.movie;

import javax.persistence.*;

/**
 * @author : Anh Khue
 */

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Movie() {
        // for JPA only
        // Why, JPA? Why????
    }

    public Movie(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
