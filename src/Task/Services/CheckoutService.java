package Task.Services;

import Task.Interfacess.IsExpired;
import Task.Interfacess.IsShipped;
import Task.Models.*;

import java.util.ArrayList;

public class CheckoutService {
    private static final int feesRatio = 14;

    public static void Checkout(Customer customer) {
        double shipping = 0;
        double subtotal = 0;
        ArrayList<ShippableItems> ShippableItems = new ArrayList<>();
        ArrayList<Integer> ItemsCount = new ArrayList<>();
        double totalWeight = 0;
        Cart cart = customer.getCart();


        if (cart.isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }

        for (Item item : cart.getItems()) {
            Product cur = item.getProduct();

            if (cur instanceof IsExpired && ((IsExpired) cur).isExpired()) {
                throw new IllegalArgumentException(cur.getName() + " is expired");
            }

            if (cur.getQuantity() <= 0) { // out stock
                throw new IllegalArgumentException(cur.getName() + " is out of stock");
            }


            if (cur instanceof IsShipped && ((IsShipped) cur).isShipped()) {
                double weight = ((IsShipped) cur).weight();
                shipping += item.getQuantity() * weight * feesRatio;
                ShippableItems.add(new ShippableItems(cur.getName(), weight));
                totalWeight += item.getQuantity() * weight;
                ItemsCount.add(item.getQuantity());
            }

            subtotal += item.getPrice();
            int curQuantity = cur.getQuantity();
            cur.setQuantity(curQuantity - item.getQuantity());
        }

        double total = shipping + subtotal;

        if (customer.getBalance() < total) {
            throw new IllegalArgumentException("balance insufficient");
        }
        double currentCustomerBalance = customer.getBalance();
        customer.setBalance(currentCustomerBalance - total);


        if (!ShippableItems.isEmpty()) {
            ShippableService ser = new ShippableService(ShippableItems, ItemsCount);
            ser.build();
            System.out.println("Total package weight  " + totalWeight + "kg");
        }
        System.out.println("----------------------");
        System.out.println("** Checkout receipt **");
        for (Item item : customer.getCart().getItems()) {
            System.out.print(item.getQuantity() + " x " + item.getProduct().getName() + " ");
            System.out.println(item.getPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shipping);
        System.out.println("Amount: " + total);
        System.out.println();
    }
}
