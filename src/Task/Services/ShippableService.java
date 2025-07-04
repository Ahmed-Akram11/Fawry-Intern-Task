package Task.Services;

import Task.Models.ShippableItems;

import java.util.ArrayList;

public class ShippableService {
    private ArrayList<ShippableItems> items;
    private ArrayList<Integer> quantity;

    public ShippableService(ArrayList<ShippableItems> items, ArrayList<Integer> quantity) {
        this.items = items;
        this.quantity = quantity;
    }


    public void build() {
        int idx = 0;
        System.out.println("** Shipment notice **");
        for (ShippableItems item : items) {
            System.out.println(quantity.get(idx) + "x " + item.getName() + " " + item.getWeight()+"kg");
            idx++;
        }
    }

}
