package com.springdemo.springdemoorderservice.model;

public class Order {
    private int id;
    private String no;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", no='" + no + '\'' +
                '}';
    }

    public static Order createOrder(int id){
        Order order = new Order();
        order.setId(id);
        order.setNo("NO-"+String.valueOf(id));
        return order;
    }
}
