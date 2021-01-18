package com.jdbc.demo01;

import com.jdbc.utils.JDBCConnectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.Arrays;
import java.util.Properties;

public class Demo02_JDBC {
    public static void main(String[] args) throws IOException {
        Connection connection = JDBCConnectionUtils.getConnection();
//        byte[] b = new byte[8];
//        int read = rs.read(b);
//        System.out.println(Arrays.toString(b));
    }
}
