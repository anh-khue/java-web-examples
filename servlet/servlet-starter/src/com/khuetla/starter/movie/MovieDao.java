package com.khuetla.starter.movie;

import com.khuetla.starter.util.DbUtils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Anh Khue
 */

public class MovieDao implements Serializable {

    public List<MovieDto> findAll() throws ClassNotFoundException, SQLException {
        List<MovieDto> result = new ArrayList<>();

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DbUtils.makeConnection();

            String sql = "SELECT id, name FROM movies";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                MovieDto dto = new MovieDto(id, name);

                result.add(dto);
            }
        } finally {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
        return result;
    }

    public MovieDto findById(int id) throws ClassNotFoundException, SQLException {
        MovieDto result = null;

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DbUtils.makeConnection();

            String sql = "SELECT id, name FROM movies WHERE id = ?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                result = new MovieDto(id, name);
            }
        } finally {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
        return result;
    }

    public void add(String name) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DbUtils.makeConnection();

            String sql = "INSERT INTO movies(name) VALUES (?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, name);

            int row = stm.executeUpdate();
        } finally {
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
    }

}
