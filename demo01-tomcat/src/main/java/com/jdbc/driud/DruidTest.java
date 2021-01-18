package com.jdbc.driud;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;

public class DruidTest {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();

        InputStream resourceAsStream = DruidTest.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();

        String sql = "select id, name, code, level from hy_area where level = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 1);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int level = resultSet.getInt("level");
            String code = resultSet.getString(3);
            System.out.println(id + "====" + name + "=====" + level + "=====" + code);
        }
        preparedStatement.close();
        connection.close();
    }
}
