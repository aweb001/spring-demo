package com.springdemo.springdemoorderservice.model;

public class User {
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }

    public static User  createUser(int id){
        User user = new User();
        user.id = id;
        user.name = "name-"+String.valueOf(id);

        return  user;
    }
}
