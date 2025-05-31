import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Cart {
    private final List<Product> items = new ArrayList<>();

    public void add(Product p) {
        items.add(p);
    }
    public void removeById(int id) {
        items.removeIf(p -> p.getId()==id);
    }
    public List<Product> getProducts() {
        return List.copyOf(items);
    }
    public double getTotal() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }
}
