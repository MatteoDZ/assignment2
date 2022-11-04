package org.example;
import net.datafaker.Faker;
import org.json.JSONObject;
import redis.clients.jedis.*;
import org.example.Classes.*;

import java.sql.*;
import java.sql.Connection;
import java.sql.Date;
import java.util.*;

import static java.lang.Boolean.FALSE;

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

        populate();

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

    public static void populate(){
        Faker faker = new Faker(new Locale("it"));

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "password")) {

            String delCus = "DELETE FROM customer";
            PreparedStatement delCusSt = connection.prepareStatement(delCus);
            delCusSt.executeUpdate();

            String delMan = "DELETE FROM manager";
            PreparedStatement delManSt = connection.prepareStatement(delMan);
            delManSt.executeUpdate();

            String delPro = "DELETE FROM product";
            PreparedStatement delProSt = connection.prepareStatement(delPro);
            delProSt.executeUpdate();

            String sqlman = "INSERT INTO manager SET Name = 'Manager', Surname = 'Direttore', Email = 'ilcapo@email.it', Password = 'password', Phonenumber = '0123456789', Company = 'Unipi'";
            PreparedStatement pstman = connection.prepareStatement(sqlman);
            pstman.executeUpdate();

            for (int i = 0; i < 1000; i++) {
                String sql = "INSERT INTO customer SET Name = ?, Surname = ?, Email = ?, Password = ?, Phonenumber = ?, Active = 1, RegistrationDate = ?, Address = ?, Country = ?";
                PreparedStatement pst = connection.prepareStatement(sql);

                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();
                String email = firstName.toLowerCase() + lastName.toLowerCase() + faker.number().numberBetween(01, 99) + "@email.it";
                String password = faker.password().toString();
                String phoneNumber = faker.phoneNumber().phoneNumber();
                Date date = new Date(122, 10, 2);
                String address = faker.address().streetAddress(FALSE) + " , " + faker.address().city() + " " + faker.address().zipCode();

                pst.setString(1, firstName);
                pst.setString(2, lastName);
                pst.setString(3, email);
                pst.setString(4, password);
                pst.setString(5, phoneNumber);
                pst.setDate(6, date);
                pst.setString(7, address);
                pst.setString(8, "Italy");

                pst.executeUpdate();
                System.out.println("Ho completato " + i + " operazioni");
            }

            for (int i = 0; i < 100; i++) {
                String sql = "INSERT INTO product SET Name = ?, ShortDescription = ?, Description = ?, Brand = ?, ImageUrl = ?, Price = ?, Stock = ?";
                PreparedStatement pst = connection.prepareStatement(sql);

                String name = faker.vehicle().makeAndModel();
                String shDesc = faker.lordOfTheRings().character();
                String desc = faker.lordOfTheRings().location();
                String[] splited = name.split("\\s+");
                String brand = splited[0];
                String img = "";
                double price = faker.number().randomDouble(3, 10000, 200000);
                Integer stock = faker.number().numberBetween(1, 10);

                pst.setString(1, name);
                pst.setString(2, shDesc);
                pst.setString(3, desc);
                pst.setString(4, brand);
                pst.setString(5, img);
                pst.setFloat(6, (float) price);
                pst.setInt(7, stock);

                pst.executeUpdate();
                System.out.println("Ho completato " + i + " operazioni");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
