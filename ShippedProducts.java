public class ShippedProducts extends Product implements Shippable {
    private double weight;

    public ShippedProducts(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getWeight() {
        return weight;
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
