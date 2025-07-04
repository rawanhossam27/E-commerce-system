import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create some products
        Product cheese = new ExpirableProducts("Cheese", 100, 5, LocalDate.now().plusDays(3));
        Product biscuits = new ShippedProducts("Biscuits", 150, 4, 0.7); // 700g
        Product tv = new ShippedProducts("TV", 5000, 2, 15.0); // 15kg
        Product scratchCard = new Product("Scratch Card", 50, 10); // not shippable

        // Create a customer
        Customer customer = new Customer("Ali", 6000);

        // Create a cart and add items
        Cart cart = new Cart();
        cart.add(cheese, 2);        // 2 x 100 = 200
        cart.add(biscuits, 1);      // 1 x 150 = 150
        cart.add(tv, 1);            // 1 x 5000 = 5000
        cart.add(scratchCard, 1);   // 1 x 50 = 50

        // Checkout
        try {
            Checkout.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }
    }
}
