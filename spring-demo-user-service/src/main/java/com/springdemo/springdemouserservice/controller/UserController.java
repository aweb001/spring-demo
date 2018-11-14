package com.springdemo.springdemouserservice.controller;

import com.springdemo.springdemouserservice.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable int id){
        return User.createUser(id);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String getInfo(){
        return "server.port:"+port;
    }
}
