public class Checkout {
    private Cart cart;
    private Customer customer;
    private ShippedProducts shippedProducts;
    private Product product;
    private ExpirableProducts expirableProducts;
    private ShippableProducts shippableProducts;

    private double totalWeight = 0;
    private double totalPrice = 0;
    public void CheckoutOrder() {
        if (Cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }
        if (Customer.getBalance() <= 0 || Customer.getBalance() < Cart.getTotalPrice()) {
            throw new IllegalStateException("Insufficient balance");
        }
        for (Product product : cart.items) {
            if (product.isExpired()) {
                throw new IllegalStateException("Cannot purchase expired product : " + product.getName());
            }
            if (product.outOfStock()) {
                throw new IllegalStateException(product.getName() + " is out of stock");
            }
        }
        System.out.println("** Shipment notice **");
        for (Product product : cart.getItems().keySet()) {
             int quantity = cart.getProductAmount(product);

            if (product.isShippable()) {
                double itemWeight = ((Shippable) product).getWeight(); // cast to access weight
                System.out.println(quantity + "x " + cart.getProductName(product) + "\t" + (int)(quantity * itemWeight * 1000) + "g");

                totalWeight += quantity * itemWeight;
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
    }