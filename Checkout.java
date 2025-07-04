import java.util.*;

public class Checkout {
    private Cart cart;
    private Customer customer;
    private double totalWeight = 0;
    private double totalPrice = 0;
    private int shippingCount = 0;

    public Checkout(Cart cart, Customer customer) {
        this.cart = cart;
        this.customer = customer;
    }

    public void checkoutOrder() {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }
        if (customer.getBalance() <= 0 || customer.getBalance() < cart.getTotalPrice()) {
            throw new IllegalStateException("Insufficient balance");
        }

        Iterator<Product> iterator = cart.getItems().keySet().iterator(); // using iterator for safe removal of expired products
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.isExpired()) {
                System.out.println("Cannot purchase expired product : " + product.getName() + " - removing from cart.");
                iterator.remove(); // safe removal
            } 
        }

        System.out.println("** Shipment notice **");
        for (Product product : cart.getItems().keySet()) {
             int quantity = cart.getProductAmount(product);

            if (product.isShippable()) {
                double itemWeight = ((Shippable) product).getWeight();
                System.out.println(quantity + "x " + cart.getProductName(product) + "\t" + (int)(quantity * itemWeight * 1000) + "g");

                totalWeight += quantity * itemWeight;
                shippingCount++;
            } else {
                System.out.println(quantity + "x " + cart.getProductName(product));
            }   
        }
        if (totalWeight < 1000) {
            System.out.println("Total package weight: " + totalWeight + "g");
        } else {
            System.out.println("Total package weight: " + (totalWeight / 1000) + "kg");
        }
        System.out.println();
        System.out.println("** Checkout receipt **");
        for (Product product : cart.getItems().keySet()) {
            int quantity = cart.getProductAmount(product);
            double unitPrice = product.getPrice();
            System.out.println(quantity + "x " + cart.getProductName(product) + "\t" + quantity * unitPrice);
            totalPrice += quantity * unitPrice;
        }
        System.out.println("Subtotal" + "\t"+ totalPrice);
        if (shippingCount > 0) {
            System.out.println("Shipping" + "\t" + ShippingService.getShippingFees());
        }
        System.out.println("Amount" + "\t" + (totalPrice + ShippingService.getShippingFees()));
        System.out.println("New Balance " + "\t" + (customer.getBalance() - (totalPrice + ShippingService.getShippingFees())));
    
        List<Shippable> toShip = new ArrayList<>();
        for (Product product : cart.getItems().keySet()) {
            if (product instanceof Shippable) {
                toShip.add((Shippable) product);
            }
        }

        if (!toShip.isEmpty()) {
            ShippingService.ship(toShip);
        }


    }


}