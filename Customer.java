public class Customer {
    String name;
    double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    public String getName() {
        return name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean canAfford(double amount) {
        if (canAfford(amount)) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient balance");
        }
    }

    public void purchase(Product product) {
        if (product.getPrice() <= balance) {
            balance -= product.getPrice();
            System.out.println("Purchased: " + product.getName());
        } else {
            System.out.println("Insufficient balance to purchase: " + product.getName());
        }
    }
}
