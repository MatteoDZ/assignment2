package org.example;

public class Beverage extends Product{
    private String beverageType;
    private float volumeInMl;
    private float alcoholPercentage;

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
