import java.time.LocalDate;

public class ExpirableProducts extends Product{
private LocalDate expiryDate;

    public ExpirableProducts(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

}

