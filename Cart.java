import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private Map<Product, amount> items;

    public Cart() {
        items = new HashMap<>();
    }

    public Map<Product, amount> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void add(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Not enough stock");
        }

        if (items.containsKey(product)) {
            int currentQty = items.get(product);
            items.put(product, currentQty + quantity);
        } else {
            items.put(product, quantity);
                }
    }

    public Map<String, Integer> getProductNamesAndAmounts() {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<Product, amount> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            result.put(product.getName(), quantity);
        }
        return result;
    }

    public List<String> getProductNames() {
        List<String> names = new ArrayList<>();
        for (Product product : items.keySet()) {
            names.add(product.getName());
        }
        return names;
    }

    public List<Integer> getProductAmounts() {
        List<Integer> amounts = new ArrayList<>();
        for (Integer quantity : items.values()) {
            amounts.add(quantity);
        }
        return amounts;
    }

    public String getProductName(Product product) {
        if (items.containsKey(product)) {
            return product.getName();
        }
        return null; // or throw an exception if preferred
    }

    public Integer getProductAmount(Product product) {
        return items.getOrDefault(product, 0);
    }
}
