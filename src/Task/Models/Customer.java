package Task.Models;

public class Customer {
    private String name;
    private double balance;
    private Cart cart;

    public Customer(String name,int balance, Cart cart) {
        this.name = name;
        this.balance = balance;
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
