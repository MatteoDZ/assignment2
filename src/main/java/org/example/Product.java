package org.example;

public class Product {
    private int productId;
    //Id for identification of the product || Unique

    private String category;
    //The category in which the item has to be placed

    private String name;
    //Displayed Name of the product

    private String shortDescription;

    private String description;
    //Description of the product

    private String brandName;
    //Brand name

    private String imageUrl;
    //Displayed Image's Url

    private float price;
    //Price displayed

    private int stock;
    //If the product is in stock or not

    public Product(int productId, String category, String name, String description, String brandName, String imageUrl, float price, int stock, String shortDescription)
    {
        this.productId = productId;
        this.category = category;
        this.name = name;
        this.description = description;
        this.brandName = brandName;
        this.imageUrl = imageUrl;
        this.price = price;
        this.stock = stock;
        this.shortDescription = shortDescription;
    }

    //Metodi Getter
    public int getProductId()
    {
        return productId;
    }

    public String getCategory()
    {
        return category;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public String getBrandName()
    {
        return brandName;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public float getPrice()
    {
        return price;
    }

    public int getStock()
    {
        return stock;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
