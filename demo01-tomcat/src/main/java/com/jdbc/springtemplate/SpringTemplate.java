package com.jdbc.springtemplate;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class SpringTemplate {
    public static void main(String[] args) throws Exception {
        //1. 创建数据库连接池对象
        Properties properties = new Properties();
        properties.load(SpringTemplate.class.getClassLoader().getResourceAsStream("druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "select * from hy_area where id = ?";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, 2);
        System.out.println(stringObjectMap);


        String sql2 = "select id, name, level from hy_area where level = ?";
        List<City> query = jdbcTemplate.query(sql2, new BeanPropertyRowMapper<City>(City.class), 1);

        for (City city : query) {
            System.out.println(city);
        }





    }
}
