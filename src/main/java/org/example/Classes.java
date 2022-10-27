package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

public class Classes {

    static class User {
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

        String address;
        String country;

        public User(String name, String surname, String email, String password, String phone_number, Boolean active, Date date_of_registration,String address, String country) {
            this.name = name;
            this.surname = surname;
            this.email = email;
            this.password = password;
            this.phone_number = phone_number;
            this.active = active;
            this.date_of_registration = date_of_registration;
            this.address = address;
            this.country = country;
        }

        // Metodi Getter
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

        public String getAddress() {
            return address;
        }

        public String getCountry() {
            return country;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setCountry(String country) {
            this.country = country;
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

        String shortDescription;

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

        public Product(int productId, String category, String name, String description, String brandName, String imageUrl, float price, int stock, String shortDescription)
        {
            this.productId = productId;
            this.category = category;
            this.name = name;
            this.description = description;
            this.brandName = brandName;
            this.imageUrl = imageUrl;
            this.price = price;
            this.stock = stock;
            this.shortDescription = shortDescription;
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

        public String getShortDescription() {
            return shortDescription;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setShortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }
    }

    static class Cart {
        // Il carrello viene considerato una Hashtable con il nome del prodotto e un numero indicante la quantità
        // É possibile esportare un Hashtable come JSON?
        // HashTable<String, Integer>
    }

    static class Order {
        // Un ordine è un'istantanea del carrello che viene creata quando viene effettuato l'acquisto dei prodotti nel carrello
        Cart cart;
        // ArrayList<Products>
        Float total;
        String orderStatus;
        Date orderDate;
        Date shippingDate;
        String shippingAddress;
        String shippingCountry;
        String paymentType;

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

    static class Customer extends User {

        // Oggetto di classe Cart per identificare il carrello del cliente
        Cart cart;
        // ArrayList di Order per tenere traccia degli ordini effettuati dal cliente
        ArrayList<Order> orders;

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

    static class Manager extends User {

        // Nome della compagnia
        String company;
        // Hashtable contente coppie di valori <NomeProdotto, Prodotto> TODO: Ha più senso usare Hashtable o Hashmap?
        Hashtable<String, Product> products;
        ArrayList<Integer> products_alt; // Alternativa per gestire meglio i prodotti

        public Manager(String name, String surname, String email, String password, String phone_number, Boolean active, Date date_of_registration, String company, Hashtable<String, Product> products, String address, String country) {
            super(name, surname, email, password, phone_number, active, date_of_registration, address, country);
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

        public Book(int productId, String category, String name, String description, String brandName, String imageUrl, float price, int stock, String shortDescription, String summary, String language, int numberPages) {
            super(productId, category, name, description, brandName, imageUrl, price, stock, shortDescription);
            this.summary = summary;
            this.language = language;
            this.numberPages = numberPages;
        }

        public void setSummary(String summary)
        {
            this.summary = summary;
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

    public class Car extends Product
    {

        int doors;

        int seats;

        String engineType;

        String displacement;

        String emissionClass;

        String color;

        int kms;

        public Car(int productId, String category, String name, String description, String brandName, String imageUrl, float price, int stock, String shortDescription, int doors, int seats, String engineType, String displacement, String emissionClass, String color, int kms) {
            super(productId, category, name, description, brandName, imageUrl, price, stock, shortDescription);
            this.doors = doors;
            this.seats = seats;
            this.engineType = engineType;
            this.displacement = displacement;
            this.emissionClass = emissionClass;
            this.color = color;
            this.kms = kms;
        }

        public int getDoors() {
            return doors;
        }

        public void setDoors(int doors) {
            this.doors = doors;
        }

        public int getSeats() {
            return seats;
        }

        public void setSeats(int seats) {
            this.seats = seats;
        }

        public String getEngineType() {
            return engineType;
        }

        public void setEngineType(String engineType) {
            this.engineType = engineType;
        }

        public String getDisplacement() {
            return displacement;
        }

        public void setDisplacement(String displacement) {
            this.displacement = displacement;
        }

        public String getEmissionClass() {
            return emissionClass;
        }

        public void setEmissionClass(String emissionClass) {
            this.emissionClass = emissionClass;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getKms() {
            return kms;
        }

        public void setKms(int kms) {
            this.kms = kms;
        }
    }

    public class Furniture extends Product
    {
        int length;
        int height;
        int width;
        String color;
        int numberOfDrawers;

        public Furniture(int productId, String category, String name, String description, String brandName, String imageUrl, float price, int stock, String shortDescription, int length, int height, int width, String color, int numberOfDrawers) {
            super(productId, category, name, description, brandName, imageUrl, price, stock, shortDescription);
            this.length = length;
            this.height = height;
            this.width = width;
            this.color = color;
            this.numberOfDrawers = numberOfDrawers;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getNumberOfDrawers() {
            return numberOfDrawers;
        }

        public void setNumberOfDrawers(int numberOfDrawers) {
            this.numberOfDrawers = numberOfDrawers;
        }
    }

    public class Laptop extends Product
    {
        int diskSpace;
        int screenSize;
        String diskType;
        String cpuType;
        String gpuType;
        String oS;

        public Laptop(int productId, String category, String name, String description, String brandName, String imageUrl, float price, int stock, String shortDescription, int diskSpace, int screenSize, String diskType, String cpuType, String gpuType, String oS) {
            super(productId, category, name, description, brandName, imageUrl, price, stock, shortDescription);
            this.diskSpace = diskSpace;
            this.screenSize = screenSize;
            this.diskType = diskType;
            this.cpuType = cpuType;
            this.gpuType = gpuType;
            this.oS = oS;
        }

        public int getDiskSpace() {
            return diskSpace;
        }

        public void setDiskSpace(int diskSpace) {
            this.diskSpace = diskSpace;
        }

        public int getScreenSize() {
            return screenSize;
        }

        public void setScreenSize(int screenSize) {
            this.screenSize = screenSize;
        }

        public String getDiskType() {
            return diskType;
        }

        public void setDiskType(String diskType) {
            this.diskType = diskType;
        }

        public String getCpuType() {
            return cpuType;
        }

        public void setCpuType(String cpuType) {
            this.cpuType = cpuType;
        }

        public String getGpuType() {
            return gpuType;
        }

        public void setGpuType(String gpuType) {
            this.gpuType = gpuType;
        }

        public String getoS() {
            return oS;
        }

        public void setoS(String oS) {
            this.oS = oS;
        }
    }

    public class Beverage extends Product
    {
        String beverageType;
        float volumeInMl;
        float alcoholPercentage;

        public Beverage(int productId, String category, String name, String description, String brandName, String imageUrl, float price, int stock, String shortDescription, String beverageType, float volumeInMl, float alcoholPercentage) {
            super(productId, category, name, description, brandName, imageUrl, price, stock, shortDescription);
            this.beverageType = beverageType;
            this.volumeInMl = volumeInMl;
            this.alcoholPercentage = alcoholPercentage;
        }

        public String getBeverageType() {
            return beverageType;
        }

        public void setBeverageType(String beverageType) {
            this.beverageType = beverageType;
        }

        public float getVolumeInMl() {
            return volumeInMl;
        }

        public void setVolumeInMl(float volumeInMl) {
            this.volumeInMl = volumeInMl;
        }

        public float getAlcoholPercentage() {
            return alcoholPercentage;
        }

        public void setAlcoholPercentage(float alcoholPercentage) {
            this.alcoholPercentage = alcoholPercentage;
        }
    }
}
