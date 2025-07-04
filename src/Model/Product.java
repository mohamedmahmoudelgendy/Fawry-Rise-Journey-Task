package Model;

import java.time.LocalDate;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private Double weight;
    private LocalDate expirationDate;

    public Product(String name, double price, int quantity, Double weight, LocalDate expirationDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
        this.expirationDate = expirationDate;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public Double getWeight() { return weight; }
    public LocalDate getExpirationDate() { return expirationDate; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public boolean isExpired() {
        return expirationDate != null && expirationDate.isBefore(LocalDate.now());
    }

    public boolean isShippable() {
        return weight != null && weight > 0;
    }
}