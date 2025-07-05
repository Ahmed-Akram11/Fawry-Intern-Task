package Task.Services;

import Task.Interfacess.IsExpired;
import Task.Interfacess.IsShipped;
import Task.Models.*;

import java.util.ArrayList;

public class ValidationService {

    public static void validateCart(Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }

        for (Item item : cart.getItems()) {
            Product product = item.getProduct();
            int quantity = product.getQuantity();
            if (product instanceof IsExpired && ((IsExpired) product).isExpired()) {
                throw new IllegalArgumentException(product.getName() + " is expired");
            }

            if (product.getQuantity() <= 0) { // out stock
                throw new IllegalArgumentException(product.getName() + " is out of stock");
            }

        }
    }


    public static void validateCustomerBalance(Customer customer, double total) {
        if (customer.getBalance() < total) {
            throw new IllegalArgumentException("balance insufficient");
        }
    }
}
