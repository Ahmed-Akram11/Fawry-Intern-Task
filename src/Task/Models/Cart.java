package Task.Models;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> items = new ArrayList<>();

    public void addToCart(Item item) {
        if (item.getQuantity() > item.getProduct().quantity) {
           throw new IllegalArgumentException("Cannot add , no sufficent product available");
        }
        items.add(item);
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public ArrayList<Item> getItems(){
        return items;
    }
}
