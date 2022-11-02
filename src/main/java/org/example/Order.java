package org.example;

import java.util.Date;

public class Order {
    private Cart cart;
    // ArrayList<Products>
    private Float total;
    private String orderStatus;
    private Date orderDate;
    private Date shippingDate;
    private String shippingAddress;
    private String shippingCountry;
    private String paymentType;

    public Order(Cart cart, Float total, String orderStatus, Date orderDate, Date shippingDate, String shippingAddress, String paymentType, String shippingCountry) {
        this.cart = cart;
        this.total = total;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.shippingDate = shippingDate;
        this.shippingAddress = shippingAddress;
        this.shippingCountry = shippingCountry;
        this.paymentType = paymentType;
    }

    public Cart getCart() {
        return cart;
    }

    public Float getTotal() {
        return total;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }
}
