package Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        if (product.getQuantity() < quantity) {
            System.out.println("Error: Not enough stock for " + product.getName());
            return;
        }

        Product cartItem = new Product(
                product.getName(),
                product.getPrice(),
                quantity,
                product.getWeight(),
                product.getExpirationDate()
        );
        items.add(cartItem);
    }

    public List<Product> getItems() { return items; }

    public void clear() { items.clear(); }

    public double calculateSubtotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}