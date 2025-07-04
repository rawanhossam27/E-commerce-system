public class Product {
    private String name;
    private double price;
    private int quantity;
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean isExpired(){
        return false; //to be overritten in ExpirableProducts
        }
    public boolean isShippable() {
        return false; // to be overridden in ShippableProducts
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public boolean outOfStock() {
        return quantity <= 0;
    }
}  