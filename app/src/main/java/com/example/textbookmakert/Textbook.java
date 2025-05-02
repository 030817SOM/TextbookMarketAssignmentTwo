package com.example.textbookmakert;

import java.io.Serializable;

public class Textbook implements Serializable {
    private String title;
    private String sellerName;
    private int copies;
    private double price;
    private String bankDetails;

    public Textbook(String title, String sellerName, int copies, double price, String bankDetails) {
        this.title = title;
        this.sellerName = sellerName;
        setCopies(copies);
        setPrice(price);
        this.bankDetails = bankDetails;
    }

    public String getTitle() {
        return title;
    }

    public String getSellerName() {
        return sellerName;
    }

    public int getCopies() {
        return copies;
    }

    public double getPrice() {
        return price;
    }

    public String getBankDetails() {
        return bankDetails;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public void setBankDetails(String bankDetails) {
        this.bankDetails = bankDetails;
    }


    public void setCopies(int copies) {
        if (copies < 1) {
            throw new IllegalArgumentException("Copies must be at least 1");
        }
        this.copies = copies;
    }

    public void setPrice(double price) {
        if (price < 0.0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Textbook)) return false;
        Textbook other = (Textbook) obj;
        return this.title.equalsIgnoreCase(other.title) && this.sellerName.equalsIgnoreCase(other.sellerName);
    }

    @Override
    public int hashCode() {
        return (title + sellerName).toLowerCase().hashCode();
    }
}
