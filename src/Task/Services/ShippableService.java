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

    public double calculate(double fees) {
        double total = 0;
        int idx = 0;
        for (ShippableItems item : items) {
            total += quantity.get(idx) * item.getWeight() * fees;
            idx++;
        }
        return total;
    }

    public void printShippableItems() {
        double totalWeight = 0;
        int idx = 0;
        System.out.println("** Shipment notice **");
        for (ShippableItems item : items) {
            totalWeight += quantity.get(idx) * item.getWeight();
            System.out.println(quantity.get(idx) + "x " + item.getName() + " " + item.getWeight() + "kg");
            idx++;
        }
        System.out.println("Total package weight  " + totalWeight + "kg");
    }


}
