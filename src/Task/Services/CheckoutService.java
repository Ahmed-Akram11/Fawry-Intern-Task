package Task.Services;

import Task.Models.Cart;
import Task.Models.Customer;
import Task.Models.Item;
import Task.Models.ShippableItems;

import java.util.ArrayList;

public class CheckoutService {
    public static void Checkout(Customer customer) {
        Cart cart = customer.getCart();

        ValidationService.validateCart(cart);
        PriceCalculation process = new PriceCalculation(new ArrayList<>(), new ArrayList<>());

        TotalRecipe recipe = process.Calculate(cart);

        ArrayList<ShippableItems> shippableItems = process.getShippableItems();
        ArrayList<Integer> ItemsCount = process.getItemsCount();

        ValidationService.validateCustomerBalance(customer, recipe.getTotal());
        customer.reduceBalance(recipe.getTotal());


        if (!shippableItems.isEmpty()) {
            ShippableService ser = new ShippableService(shippableItems, ItemsCount);
            ser.printShippableItems();
        }

        PrintRecipies(customer);
        recipe.printTotalRecipe();

    }

    public static void PrintRecipies(Customer customer) {
        System.out.println("----------------------");
        System.out.println("** Checkout receipt **");

        for (Item item : customer.getCart().getItems()) {
            System.out.print(item.getQuantity() + " x " + item.getProduct().getName() + " ");
            System.out.println(item.getPrice());
        }
        System.out.println("customer balance After Checkout: " + customer.getBalance());
    }


}
