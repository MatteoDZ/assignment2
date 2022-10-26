package org.example;
import org.json.JSONObject;
import redis.clients.jedis.*;
import org.example.Classes.*;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Test creazione di un nuovo cliente e un nuovo manager
        Customer c = new Customer("Babbo", "Natale", "bn@gmail.com", "HoHoHo",
                "1234", Boolean.TRUE, new Date(), new Cart(), new ArrayList<Order>());

        Manager m = new Manager("Giorgio", "Mastrota", "CavalierCustode@AcciaioInox.it", "Batteriadipentole",
                "800700600", Boolean.TRUE, new Date(), "Fondofuso", new Hashtable<String, Product>() {
        });

        // Test generale metodi
        System.out.println(c.getName());
        c.setName("Madre");
        System.out.println(c.getName());

        System.out.println(m.email);
        System.out.println(m.products + "\n");

        /*m.addProduct("Maglione", new Product());
        m.addProduct("Scrivania", new Product());
        m.addProduct("Ferrari", new Product());*/

        //System.out.println(m.products);

        m.removeProduct("Scrivania");
        // La modifica di un prodotto viene effettuata modificando il prodotto e lasciano la stessa stringa
        /*m.addProduct("Maglione", new Product());*/

        //System.out.println(m.getProducts());

        m.clearAllProducts();

        //System.out.println(m.products);

        Hashtable<String, String> ht = new Hashtable<>();
        ht.put("Hello", "World");
        ht.put("Dio", "Cane");
        ht.put("Alfa", "Omega");

        System.out.println("Stampo l'hashtable originale");
        System.out.println(ht + "\n");

        JSONObject jsonObject = new JSONObject(ht);
        System.out.println("Stampo il file JSON");
        System.out.println(jsonObject + "\n");

        Map<String, Object> recover = jsonObject.toMap();
        Hashtable<String, Object> st = new Hashtable<>(recover);
        System.out.println("Stampo l'hashtable recuperata");
        System.out.println(recover);
        System.out.println(st + "\n");

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
