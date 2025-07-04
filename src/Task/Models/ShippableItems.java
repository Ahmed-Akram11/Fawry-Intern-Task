package Task.Models;

import Task.Interfacess.Shippable;

public class ShippableItems implements Shippable {
    private String name;
    private double weight;

    public ShippableItems(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double weight() {
        return getWeight();
    }

    @Override
    public String name() {
        return getName();
    }
}
