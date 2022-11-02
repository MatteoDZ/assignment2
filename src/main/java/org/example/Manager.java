package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

public class Manager extends User{
    // Nome della compagnia
    private String company;
    // Hashtable contente coppie di valori <NomeProdotto, Prodotto> TODO: Ha più senso usare Hashtable o Hashmap?
    private Hashtable<String, Product> products;
    private ArrayList<Integer> products_alt; // Alternativa per gestire meglio i prodotti

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
