package com.example.springboot_test.controller;

import com.example.springboot_test.mapper.UserMapper;
import com.example.springboot_test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        return userList;
    }

    @GetMapping("/queryUserById/{id}")
    public User queryUserById(@PathVariable("id") int id){
        User user = userMapper.queryUserById(id);
        return user;
    }

    @GetMapping("/addUser1")
    public String addUser(){
        userMapper.addUser(new User(8, "S", "D", "D"));
        return "ok";
    }

    @GetMapping("/updateUser1")
    public String updateUser(){
        userMapper.updateUser(new User(8, "d", "w", "t"));
        return "ok";
    }

    @GetMapping("/deleteUser1")
    public String deleteUser(){
        userMapper.deleteUser(8);
        return "ok";
    }



}
