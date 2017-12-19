package com.khuetla.hibernate.entity;

import javax.persistence.*;

/**
 * @author : Anh Khue
 */

@Entity
@Table(name = "movies", schema = "flexi")
public class Movie {

    private int id;
    private String name;

    public Movie() {
    }

    public Movie(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
