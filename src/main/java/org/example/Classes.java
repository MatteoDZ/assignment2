package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

public class Classes {

    static class User {
        // Integer che fungerà da primary key
        int ID;
        // Nome dell'utente
        String name;
        // Cognome dell'utente
        String surname;
        // Email dell'utente || Unique
        String email;
        // Password
        String password;
        // Numero di telefono dell'utente || Unique
        String phone_number;
        // Stato dell'utente
        Boolean active;
        // Data di registrazione (Ha senso??)
        Date date_of_registration;

        public User(int ID, String name, String surname, String email, String password, String phone_number, Boolean active, Date date_of_registration) {
            this.ID = ID;
            this.name = name;
            this.surname = surname;
            this.email = email;
            this.password = password;
            this.phone_number = phone_number;
            this.active = active;
            this.date_of_registration = date_of_registration;
        }

        // Metodi Getter
        public int getID() {
            return ID;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public Boolean getActive() {
            return active;
        }

        public Date getDate_of_registration() {
            return date_of_registration;
        }

        public String getPhone_number() {
            return phone_number;
        }

        // Metodi Setter
        public void setName(String name) {
            this.name = name;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }
    }

    static class Product
    {
        int productId;
        //Id for identification of the product || Unique

        String category;
        //The category in which the item has to be placed

        String name;
        //Displayed Name of the product

        String description;
        //Description of the product

        String brandName;
        //Brand name

        String imageUrl;
        //Displayed Image's Url

        float price;
        //Price displayed

        int stock;
        //If the product is in stock or not

        public Product(int productId, String category, String name, String description, String brandName, String imageUrl, float price, int stock)
        {
            this.productId = productId;
            this.category = category;
            this.name = name;
            this.description = description;
            this.brandName = brandName;
            this.imageUrl = imageUrl;
            this.price = price;
            this.stock = stock;

        }

        //Metodi Getter
        public int getProductId()
        {
            return productId;
        }

        public String getCategory()
        {
            return category;
        }

        public String getName()
        {
            return name;
        }

        public String getDescription()
        {
            return description;
        }

        public String getBrandName()
        {
            return brandName;
        }

        public String getImageUrl()
        {
            return imageUrl;
        }

        public float getPrice()
        {
            return price;
        }

        public int getStock()
        {
            return stock;
        }
    }

    static class Cart {
        // Il carrello viene considerato una Hashtable con il nome del prodotto e un numero indicante la quantità
        // É possibile esportare un Hashtable come JSON?
        // HashTable<String, Integer>
    }

    static class Order {
        // Un ordine è un'istantanea del carrello che viene creata quando viene effettuato l'acquisto dei prodotti nel carrello
        // Cart cart;
    }

    static class Customer extends User {

        // Oggetto di classe Cart per identificare il carrello del cliente
        Cart cart;
        // ArrayList di Order per tenere traccia degli ordini effettuati dal cliente
        ArrayList<Order> orders;

        public Customer(int ID, String name, String surname, String email, String password, String phone_number, Boolean active, Date date_of_registration, Cart cart, ArrayList<Order> orders) {
            super(ID, name, surname, email, password, phone_number, active, date_of_registration);
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

    static class Manager extends User {

        // Nome della compagnia
        String company;
        // Hashtable contente coppie di valori <NomeProdotto, Prodotto> TODO: Ha più senso usare Hashtable o Hashmap?
        Hashtable<String, Product> products;

        public Manager(int ID, String name, String surname, String email, String password, String phone_number, Boolean active, Date date_of_registration, String company, Hashtable<String, Product> products) {
            super(ID, name, surname, email, password, phone_number, active, date_of_registration);
            this.company = company;
            this.products = products;
        }

        // Metodi Getter e Setter
        public String getCompany() {
            return company;
        }

        public Hashtable<String, Product> getProducts() {
            return products;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        // Metodi gestione prodotti
        public void addProduct(String s, Product p) {
            this.products.put(s,p);
        }

        public void removeProduct(String s) {
            this.products.remove(s);
        }

        public void clearAllProducts() {
            this.products.clear();
        }
    }

    static class Book extends Product
    {
        String summary;

        String language;

        int numberPages;
        public Book(int productId, String category, String name, String description, String brandName, String imageUrl, float price, int stock, String summary, String language, int numberPages)
        {
            super( productId, category, name, description, brandName, imageUrl, price, stock);
            this.summary = summary;
            this.description = description;
            this.numberPages = numberPages;
        }

        public String getSummary()
        {
            return summary;
        }

        public String getDescription()
        {
            return description;
        }

        public int getNumberPages()
        {
            return numberPages;
        }
    }

}
