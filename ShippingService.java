import java.util.*;

public class ShippingService {
    private static double shippingFees;

    public static double getShippingFees() {
        return shippingFees;
    }

    public static void setShippingFees(double shippingFees) {
        ShippingService.shippingFees = shippingFees;
    }

    public static void ship(List<Shippable> items) {
        System.out.println("Received " + items.size() + " items for shipping.");
    }
}
