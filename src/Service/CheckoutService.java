package Service;

import Model.Cart;
import Model.Customer;
import Model.Product;
import Model.ShippableItem;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    private final ShippingService shippingService;

    public CheckoutService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void checkout(Customer customer) {
        Cart cart = customer.getCart();
        List<Product> items = cart.getItems();

        if (items.isEmpty()) {
            System.out.println("Cart is empty. Nothing to checkout.");
            return;
        }

        for (Product item : items) {
            if (item.isExpired()) {
                System.out.println("Error: " + item.getName() + " is expired");
                return;
            }
            if (item.getQuantity() <= 0) {
                System.out.println("Error: " + item.getName() + " is out of stock");
                return;
            }
        }

        List<ShippableItem> shippableItems = new ArrayList<>();
        for (Product item : items) {
            if (item.isShippable() && !item.isExpired()) {
                shippableItems.add(new ShippableItem(
                        item.getName(),
                        item.getWeight(),
                        item.getQuantity()
                ));
            }
        }

        double subtotal = cart.calculateSubtotal();
        double shippingFees = shippingService.calculateShippingFees(shippableItems);
        double total = subtotal + shippingFees;

        if (customer.getBalance() < total) {
            System.out.println("Error: Insufficient balance");
            return;
        }

        customer.setBalance(customer.getBalance() - total);

        if (!shippableItems.isEmpty()) {
            shippingService.generateShippingNotice(shippableItems);
        }

        printReceipt(items, subtotal, shippingFees, total, customer.getBalance());
        cart.clear();
    }

    private void printReceipt(List<Product> items, double subtotal,
                              double shipping, double total, double balance) {
        System.out.println("** Checkout receipt **");
        for (Product item : items) {
            System.out.printf("%dx %s %.0f%n",
                    item.getQuantity(), item.getName(),
                    item.getPrice() * item.getQuantity());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shipping);
        System.out.println("Total: " + total);
        System.out.println("Remaining balance: " + balance);
    }
}