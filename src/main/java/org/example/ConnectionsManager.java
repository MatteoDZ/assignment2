package org.example;

import java.sql.*;
import java.util.Scanner;

public class ConnectionsManager {

    private Scanner input = new Scanner(System.in);
    public ConnectionsManager()
    {

    }
    public void Register()
    {
        String name = "";
        String surname = "";
        String email = "";
        String password = "";
        String phone = "";
        String address = "";
        String country = "";

        System.out.println("Insert name:");
        name = input.nextLine();
        System.out.println("Insert surname:");
        surname = input.nextLine();
        System.out.println("Insert email:");
        email = input.nextLine();
        System.out.println("Insert password:");
        password = input.nextLine();
        System.out.println("Insert phone:");
        phone = input.nextLine();
        System.out.println("Insert address:");
        address = input.nextLine();
        System.out.println("Insert country:");
        country = input.nextLine();


        try(
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "password");
        ){
            String sql = "INSERT INTO customer(Name, Surname, Email, Password, Phonenumber, Active, RegistrationDate, Address, Country) VALUES (?, ?, ?, ?, ?, ?, CURRENT_DATE, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setString(5, phone);
            statement.setInt(6, 1);
            statement.setString(7, address);
            statement.setString(8, country);
            statement.execute();
        } catch ( SQLException sqle){
            System.out.println(sqle);
        }
    }

    public void LogIn()
    {
        String email = "";
        String password = "";

        System.out.println("Insert the email:");
        email = input.nextLine();
        System.out.println("Insert the password:");
        password = input.nextLine();
        String sqlQuery = "SELECT * FROM Customer WHERE Email = '"  + email + "'";

        try(
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "password");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlQuery);
        ){
            //Even if it's only 1 row it's needed to position the cursor in the correct spot -> otherwise we get a SqlException!
            while (resultSet.next()) {
                String foundPassword = resultSet.getString("Password");
                if (password.equals(foundPassword) && !resultSet.wasNull()) {
                    System.out.println("Welcome " + resultSet.getString("Name") + " " + resultSet.getString("surname") + " !");
                } else {
                    System.out.println("The email and the password are wrong, try again.");
                }
            }
        } catch ( SQLException sqle){
            System.out.println(sqle);
        }
    }

    public void View()
    {
        try(
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "password");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from product");
        ){
            while(resultSet.next()){
                String productId = resultSet.getString("ProductId");
                String name = resultSet.getString("Name");
                String shortDescription = resultSet.getString("ShortDescription");
                String description = resultSet.getString("Description");
                String brand = resultSet.getString("Brand");
                float price = resultSet.getFloat("Price");
                int stock = resultSet.getInt("Stock");
                System.out.println("Product n." + productId + ":" + "\n" +
                        "Name: " + name + "\n" +
                        "ShortDescription: " + shortDescription + "\n" +
                        "Description: " + description + "\n" +
                        "Brand: " + brand + "\n" +
                        "Price: " + price + "\n" +
                        "Stock: " + stock);
            }
        } catch ( SQLException sqle){
            System.out.println(sqle);
        }
    }

    //Manager sample function
    public void ViewCustomersInfo()
    {
        try(
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "password");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from customer");
        ){
            while(resultSet.next()){
                String customerId = resultSet.getString("CustomerId");
                String name = resultSet.getString("Name");
                String surname = resultSet.getString("Surname");
                String email = resultSet.getString("Email");
                String password = resultSet.getString("Password");
                String phone = resultSet.getString("PhoneNumber");
                int active = resultSet.getInt("Active");
                String date = String.valueOf(resultSet.getDate("RegistrationDate"));
                String address = resultSet.getString("Address");
                String country = resultSet.getString("Country");
                System.out.println("Customer n." + customerId + ":" + "\n" +
                        "Name: " + name + "\n" +
                        "Surname: " + surname + "\n" +
                        "Email: " + email + "\n" +
                        "Password: " + password + "\n" +
                        "Phone Number: " + phone + "\n" +
                        "Status: " + active + "\n" +
                        "Registration date: " + date + "\n" +
                        "Address: " + address + "\n" +
                        "Country: " + country);
            }
        } catch ( SQLException sqle){
            System.out.println(sqle);
        }
    }
}
