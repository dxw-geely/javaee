package com.jdbc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnectionUtils {

    private static Connection connection;
    private static PreparedStatement ps;
    private static String driver;
    private static String host;
    private static String user;
    private static String password;
    static {
        Properties properties = new Properties();
        InputStream rs = JDBCConnectionUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(rs);
            driver = properties.getProperty("driver");
            user = properties.getProperty("user");
            host = properties.getProperty("host");
            password = properties.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(host, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            return connection;
        }
    }
}
