package Task.Models;

import Task.Interfacess.IsShipped;

public class TV extends Product implements IsShipped {
    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public TV(String name, int price, int quantity, double weight) {
        this(name, price, quantity);
        this.weight = weight;
    }

    public TV(String name, int price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean isShipped() {
        return true;
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
