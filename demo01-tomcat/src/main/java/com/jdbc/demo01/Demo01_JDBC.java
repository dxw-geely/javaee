package com.jdbc.demo01;

import java.sql.*;

public class Demo01_JDBC {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://172.23.130.34:3306/ve", "root", "root1234");
            String sql = "select * from lkp_geo_region_name where province = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "北京");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String adcode = resultSet.getString("adcode");
                String name = resultSet.getString("name");
                String province = resultSet.getString("province");
                String cityname = resultSet.getString("cityname");
                System.out.println(adcode + "----" + name + "----" + province + "----" + cityname);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
