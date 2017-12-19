package com.khuetla.starter.movie;

import java.io.Serializable;

/**
 * @author : Anh Khue
 */

public class MovieDto implements Serializable {

    private int id;
    private String name;

    public MovieDto() {
    }

    public MovieDto(int id, String name) {
        this.id = id;
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
