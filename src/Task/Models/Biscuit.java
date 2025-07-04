package Task.Models;


import Task.Interfacess.IsExpired;
import Task.Interfacess.IsShipped;

import java.time.LocalDate;

public class Biscuit extends Product implements IsExpired, IsShipped {
    private LocalDate date;
    private double weight;

    public Biscuit(String name, int price, int quantity, LocalDate date, double weight) {
        this(name, price, quantity);
        this.date = date;
        this.weight = weight;
    }

    public Biscuit(String name, int price, int quantity) {
        super(name, price, quantity);
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(date);
    }

    @Override
    public LocalDate expiringDate() {
        return date;
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
