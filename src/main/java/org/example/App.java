package org.example;
import org.json.JSONObject;
import redis.clients.jedis.*;
import org.example.Classes.*;

import java.util.*;

public class App 
{
    private static ConnectionsManager cManager = new ConnectionsManager();
    /*
    To determine if he's a customer, a manager, a guest or he wants to disconnect
    If He wants to disconnect the connectionState becomes -2 and exits
    If He is a Customer the connectionState will be set to 0
    If He is a Manager the connectionState will be set to 1
    If He is a Guest the connectionState will be set to 2
    */
    private static int connectionState = -1;

    public static void main( String[] args )
    {
        /*
        // Test creazione di un nuovo cliente e un nuovo manager
        Customer c = new Customer("Babbo", "Natale", "bn@gmail.com", "HoHoHo",
                "1234", Boolean.TRUE, new Date(), new Cart(), new ArrayList<Order>(), "Porco", "Cane");

        Manager m = new Manager("Giorgio", "Mastrota", "CavalierCustode@AcciaioInox.it", "Batteriadipentole",
                "800700600", Boolean.TRUE, new Date(), "Fondofuso", new Hashtable<String, Product>() {
        }, "Porca", "Maiala");

        // Test generale metodi
        System.out.println(c.getName());
        c.setName("Madre");
        System.out.println(c.getName());

        System.out.println(m.getEmail());
        System.out.println(m.getProducts() + "\n");

        m.addProduct("Maglione", new Product());
        m.addProduct("Scrivania", new Product());
        m.addProduct("Ferrari", new Product());

        //System.out.println(m.products);

        m.removeProduct("Scrivania");
        // La modifica di un prodotto viene effettuata modificando il prodotto e lasciano la stessa stringa
        m.addProduct("Maglione", new Product());

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
        */
        System.out.println("Benvenuto in Ecommerce!");
        while (connectionState == -1) {
            int mode = cManager.FirstAccessPossibleCommands();
            switch (mode) {
                case 1:
                    cManager.Register();
                    break;
                case 2:
                    if(cManager.LogIn("customer"))
                        connectionState = 0;
                    break;
                case 3:
                    //He tries to log in as a manager
                    if(cManager.LogIn("manager"))
                        connectionState = 1;
                    break;
                case 4:
                    //He is a guest
                    connectionState = 2;
                    break;
                case 5:
                    //He wants to log out
                    connectionState = -2;
                    break;
                default:
                    System.out.println("Error in the system.");
            }
        }

        //After the initial connection and log in or log out
        switch (connectionState)
        {
            case -2:
                System.out.println("Goodbye!");
                return;
            case 0:
                System.out.println("Customer " + cManager.GetCurrentUser());
                break;
            case 1:
                System.out.println("Manager " + cManager.GetCurrentUser());
                break;
            case 2:
                System.out.println("Guest");
                break;
            default:
                System.out.println("Error in the system.");
        }
    }
}
