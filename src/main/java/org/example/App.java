package org.example;
import redis.clients.jedis.*;
import org.example.Classes.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Test creazione di un nuovo cliente e un nuovo manager
        Customer c = new Customer(1234, "Babbo", "Natale", "bn@gmail.com", "HoHoHo",
                "1234", Boolean.TRUE, new Date(), new Cart(), new ArrayList<Order>());

        Manager m = new Manager(9967, "Giorgio", "Mastrota", "CavalierCustode@AcciaioInox.it", "Batteriadipentole",
                "800700600", Boolean.TRUE, new Date(), "Fondofuso", new Hashtable<String, Product>() {
        });

        // Test generale metodi
        System.out.println(c.getName());
        c.setName("Madre");
        System.out.println(c.getName());

        System.out.println(m.email);
        System.out.println(m.products);

        /*m.addProduct("Maglione", new Product());
        m.addProduct("Scrivania", new Product());
        m.addProduct("Ferrari", new Product());*/

        System.out.println(m.products);

        m.removeProduct("Scrivania");
        // La modifica di un prodotto viene effettuata modificando il prodotto e lasciano la stessa stringa
        /*m.addProduct("Maglione", new Product());*/

        System.out.println(m.getProducts());

        m.clearAllProducts();

        System.out.println(m.products);


        String culo = "Culo";
        String redisHost = "localhost";
        Integer redisPort = 6379;

        JedisPool pool = new JedisPool(redisHost, redisPort);

        try (Jedis jedis = pool.getResource()) {
            jedis.set("Hello", "World");
        }
        pool.close();
    }
}
