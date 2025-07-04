public class ShippedProducts extends Product{
    private double weight;

    public ShippedProducts(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    
    }
    @Override
    public boolean isShippable() {
        return true;
    }

    public double getWeightValue() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
