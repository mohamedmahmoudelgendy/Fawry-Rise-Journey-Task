import Model.Customer;
import Model.Product;
import Service.CheckoutService;
import Service.ShippingServiceImpl;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new Product("Cheese", 100, 5, 0.4, LocalDate.now().plusDays(10));
        Product tv = new Product("TV", 500, 3, 15.0, null);
        Product scratchCard = new Product("Scratch Card", 50, 100, null, null);

        Customer customer = new Customer("John Doe", 2000);

        customer.getCart().addItem(cheese, 2);
        customer.getCart().addItem(tv, 1);
        customer.getCart().addItem(scratchCard, 3);

        CheckoutService checkout = new CheckoutService(new ShippingServiceImpl());
        checkout.checkout(customer);
    }
}