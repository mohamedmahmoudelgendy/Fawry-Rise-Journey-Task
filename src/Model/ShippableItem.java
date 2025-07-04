package Model;

public class ShippableItem {
    private String name;
    private double weight;
    private int quantity;

    public ShippableItem(String name, double weight, int quantity) {
        this.name = name;
        this.weight = weight;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getWeight() { return weight; }
    public int getQuantity() { return quantity; }
}