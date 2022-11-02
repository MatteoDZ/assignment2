package org.example;

public class Forniture extends Product{
    private int length;
    private int height;
    private int width;
    private String color;
    private int numberOfDrawers;

    public Forniture(int productId, String category, String name, String description, String brandName, String imageUrl, float price, int stock, String shortDescription, int length, int height, int width, String color, int numberOfDrawers) {
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
