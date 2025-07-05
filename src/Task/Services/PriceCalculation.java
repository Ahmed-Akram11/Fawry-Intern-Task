package Task.Services;

import Task.Interfacess.IsShipped;
import Task.Models.Cart;
import Task.Models.Item;
import Task.Models.Product;
import Task.Models.ShippableItems;

import java.util.ArrayList;

public class PriceCalculation {
    private ArrayList<ShippableItems> ShippableItems = new ArrayList<>();
    private ArrayList<Integer> ItemsCount = new ArrayList<>();
    private static final int feesRatio = 14;

    public PriceCalculation(ArrayList<Task.Models.ShippableItems> shippableItems, ArrayList<Integer> itemsCount) {
        ShippableItems = shippableItems;
        ItemsCount = itemsCount;
    }

    public TotalRecipe Calculate(Cart cart) {
        double subtotal = 0;
        for (Item item : cart.getItems()) {
            Product product = item.getProduct();
            subtotal += item.getPrice();
            int curQuantity = product.getQuantity();
            product.setQuantity(curQuantity - item.getQuantity());

            if (product instanceof IsShipped && ((IsShipped) product).isShipped()) {
                double weight = ((IsShipped) product).weight();
                ShippableItems.add(new ShippableItems(product.getName(), weight));
                ItemsCount.add(item.getQuantity());
            }
        }

        ShippableService shippable = new ShippableService(ShippableItems, ItemsCount);
        double shipping = shippable.calculate(feesRatio);
        double total = subtotal + shipping;
        TotalRecipe recipe = new TotalRecipe(subtotal, total, shipping);

        return recipe;
    }

    public  ArrayList<Integer> getItemsCount() {
        return ItemsCount;
    }

    public  ArrayList<Task.Models.ShippableItems> getShippableItems() {
        return ShippableItems;
    }
}
