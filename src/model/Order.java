package model;

import java.util.Date;

public class Order {
    private int id;
    private int userId;
    private int restaurantId;
    private Date orderDate;
    private double total;

    public Order() {}
    public Order(int id, int userId, int restaurantId, Date orderDate, double total){
        this.id=id; this.userId=userId; this.restaurantId=restaurantId;
        this.orderDate=orderDate; this.total=total;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id=id;}
    public int getUserId() {return userId;}
    public void setUserId(int userId) {this.userId=userId;}
    public int getRestaurantId() {return restaurantId;}
    public void setRestaurantId(int restaurantId) {this.restaurantId=restaurantId;}
    public Date getOrderDate() {return orderDate;}
    public void setOrderDate(Date orderDate) {this.orderDate=orderDate;}
    public double getTotal() {return total;}
    public void setTotal(double total) {this.total=total;}
}