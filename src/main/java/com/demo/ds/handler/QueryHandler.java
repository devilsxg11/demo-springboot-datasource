package com.demo.ds.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class QueryHandler {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Map<String, Object>> query(){

        String sql = "select * from test.person order by age,name desc limit 999900, 10;";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    public List<Map<String, Object>> queryByAge(int minAge){

        String sql = "select * from person where age > ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, minAge);
        return maps;
    }

    public List<Map<String, Object>> queryBySex(int sex){
        String sql = "select * from person where sex = ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, sex);
        return maps;
    }
}
