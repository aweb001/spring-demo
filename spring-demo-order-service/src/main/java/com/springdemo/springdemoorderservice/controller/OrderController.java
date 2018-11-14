package com.springdemo.springdemoorderservice.controller;

import com.springdemo.springdemoorderservice.model.Order;
import com.springdemo.springdemoorderservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable int id) {
        return Order.createOrder(id);
    }

    @RequestMapping(value = "/order/user/{id}", method = RequestMethod.GET)
    public User getOrderUser(@PathVariable int id) {
        return restTemplate.getForObject(
                String.format("{0}/user/{1}", env.getProperty("extend.user-service.url"),
                String.valueOf(id)),
                User.class);
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getInfo() {
        return env.getProperty("server.port");
    }

    @RequestMapping(value = "/info/user", method = RequestMethod.GET)
    public String getUserInfo() {
        return restTemplate.getForObject(env.getProperty("extend.user-service.url") + "/info/", String.class);
    }
}
