package org.example;

import java.util.ArrayList;
import java.util.Date;

public class Customer extends User{
    // Oggetto di classe Cart per identificare il carrello del cliente
    private Cart cart;
    // ArrayList di Order per tenere traccia degli ordini effettuati dal cliente
    private ArrayList<Order> orders;

    public Customer(String name, String surname, String email, String password, String phone_number, Boolean active, Date date_of_registration, Cart cart, ArrayList<Order> orders, String address, String country) {
        super(name, surname, email, password, phone_number, active, date_of_registration, address, country);
        this.cart = cart;
        this.orders = orders;
    }

    // Metodi Getter e Setter
    public Cart getCart() {
        return cart;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}
