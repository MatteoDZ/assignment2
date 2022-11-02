package org.example;

public class Car extends Product{
    private int doors;

    private int seats;

    private String engineType;

    private String displacement;

    private String emissionClass;

    private String color;

    private int kms;

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
