package org.example;
import redis.clients.jedis.*;
import org.example.Classes.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
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

        System.out.println(c.getName());
        c.setName("Madre");
        System.out.println(c.getName());

        System.out.println(m.email);


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
