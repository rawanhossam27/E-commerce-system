import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items;

    public Cart() {
        items = new HashMap<>();
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void add(Product product, int quantity) {
    int availableStock = product.getQuantity();

    if (availableStock == 0) {
        System.out.println(product.getName() + " is out of stock and was not added to the cart.");
        return;
    }

    int finalQty = Math.min(quantity, availableStock);

    if (finalQty < quantity) {
        System.out.println(product.getName() + " only has " + finalQty + " in stock. Added " + finalQty + " to the cart.");
    }

    if (items.containsKey(product)) {
        int currentQty = items.get(product);
        items.put(product, currentQty + finalQty);
    } else {
        items.put(product, finalQty);
    }
}

    public Map<String, Integer> getProductNamesAndAmounts() {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            result.put(product.getName(), quantity);
        }
        return result;
    }

    public String getProductName(Product product) {
        if (items.containsKey(product)) {
            return product.getName();
        }
        return null;
    }

    public Integer getProductAmount(Product product) {
        return items.getOrDefault(product, 0);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            total += product.getPrice() * quantity;
        }
        return total;
    }
    public void remove(Product product) {
    if (!items.containsKey(product)) {
        throw new IllegalArgumentException("Product not in cart");
    }
    items.remove(product);
}

}
