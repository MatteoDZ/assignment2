package org.example;

public class Book extends Product{
    private String summary;

    private final String language;

    private final int numberPages;

    public Book(int productId, String category, String name, String description, String brandName, String imageUrl, float price, int stock, String shortDescription, String summary, String language, int numberPages) {
        super(productId, category, name, description, brandName, imageUrl, price, stock, shortDescription);
        this.summary = summary;
        this.language = language;
        this.numberPages = numberPages;
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public String getSummary()
    {
        return summary;
    }

    public int getNumberPages()
    {
        return numberPages;
    }
}
