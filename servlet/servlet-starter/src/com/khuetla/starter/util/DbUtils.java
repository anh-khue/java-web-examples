package com.khuetla.starter.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author : Anh Khue
 */

public class DbUtils implements Serializable {

    public static Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/your_database_name";

        Connection connection = DriverManager.getConnection(url, "your_username", "your_password");

        return connection;
    }

}
