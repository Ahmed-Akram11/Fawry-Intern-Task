package Task;


import Task.Models.*;
import Task.Services.CheckoutService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new Cheese("Cheese", 100, 10, LocalDate.now().plusDays(5), 0.4);
        Product tv = new TV("TV", 300, 5, 2.0);
        Product scratchCard = new ScratchCard("Scratch Card", 10, 15);
        Cart cart = new Cart();
        System.out.println("Case 1: main Case");
        System.out.println("--------------------------------------");
        try {
            cart.addToCart(new Item(cheese, 2));
            cart.addToCart(new Item(tv, 4));
            cart.addToCart(new Item(scratchCard, 10));
            Customer customer = new Customer("Ahmed", 1700, cart);
            System.out.println("customer balance: " + customer.getBalance());
            CheckoutService.Checkout(customer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Case 2: Insufficient balance");
        System.out.println("--------------------------------------");

        try {
            Customer customer1 = new Customer("Ahmed", 1000, cart);
            CheckoutService.Checkout(customer1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Case 3: cannot add no more product quantity");
        System.out.println("--------------------------------------");

        try {
            cart.addToCart(new Item(tv, 4));
            Customer customer2= new Customer("Ahmed",1500, cart);
            CheckoutService.Checkout(customer2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Case 4: cart is Empty");
        System.out.println("--------------------------------------");


        try {
            Customer customer2= new Customer("Ahmed",1500, new Cart());
            CheckoutService.Checkout(customer2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println("Case 5: out of stock");
        System.out.println("--------------------------------------");

        try {
            Product cheese2 = new Cheese("Cheese", 100, 10, LocalDate.now().minusDays(5), 0.4);
            cart.addToCart(new Item(cheese2,1));
            Customer customer2= new Customer("Ahmed",1500, cart);
            CheckoutService.Checkout(customer2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Case 6: Expired product");
        System.out.println("--------------------------------------");

        try {
            Product cheese2 = new Cheese("Cheese", 100, 10, LocalDate.now().minusDays(5), 0.4);
            Cart cart1= new Cart();
            cart1.addToCart(new Item(cheese2,1));
            Customer customer2= new Customer("Ahmed",1500, cart1);
            CheckoutService.Checkout(customer2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}