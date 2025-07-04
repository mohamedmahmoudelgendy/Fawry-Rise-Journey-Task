package Service;

import Model.ShippableItem;

import java.util.List;

public interface ShippingService {
    void generateShippingNotice(List<ShippableItem> shippableItems);
    double calculateShippingFees(List<ShippableItem> shippableItems);
}