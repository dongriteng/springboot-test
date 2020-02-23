package com.example.springboot_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/user")
    public List<Map<String, Object>> userList(){

        String sql = "select * from employee";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;

    }

    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into employee values (2, '李', '女', '1830215')";
        jdbcTemplate.update(sql);
        return "add_ok";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update employee set gender = ?, last_name = ? where id = " + id;
        Object[] objects = new Object[2];
        objects[0] = "无";
        objects[1] = "张";
        jdbcTemplate.update(sql, objects);
        return "update_ok";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from employee where id = " + id;

        jdbcTemplate.update(sql);
        return "delete_ok";
    }
}
