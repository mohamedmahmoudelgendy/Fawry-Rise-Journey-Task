package Service;

import Model.ShippableItem;
import java.util.List;

public class ShippingServiceImpl implements ShippingService {
    @Override
    public void generateShippingNotice(List<ShippableItem> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;

        for (ShippableItem item : items) {
            System.out.printf("%dx %s %.0fg%n",
                    item.getQuantity(), item.getName(), item.getWeight() * 1000);
            totalWeight += item.getWeight() * item.getQuantity();
        }

        System.out.printf("Total package weight %.1fkg%n", totalWeight);
    }

    @Override
    public double calculateShippingFees(List<ShippableItem> items) {
        double fees = 0;
        for (ShippableItem item : items) {
            fees += item.getQuantity() * 10 ;
        }
        return fees ;
    }
}