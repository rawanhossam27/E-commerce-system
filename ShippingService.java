public class ShippingService {
    private double shippingFees;

    public ShippingService(double shippingFees) {
        this.shippingFees = shippingFees;
    }

    public double getShippingFees() {
        return shippingFees;
    }
    public void setShippingFees(double shippingFees) {
        this.shippingFees = shippingFees;
    }

    public static void ship(List<Shippable> items) {
       System.out.println("Recieved " + toShip.size() + " items for shipping.");
    }
}
