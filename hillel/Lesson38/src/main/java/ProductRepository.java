import java.util.*;

public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public void initData(){
        this.products.add(new Product(1, "T1", 41500));
        this.products.add(new Product(2, "T2", 15000));
        this.products.add(new Product(3, "T3", 8900));
    }

    public List<Product> findAll() {
        return List.copyOf(products);
    }
    public Optional<Product> findById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst();
    }
    public void save(Product product) {
        products.add(product);
    }

    public boolean deleteById(int id) {
        return products.removeIf(product -> product.getId() == id);
    }

    public Boolean update(Product product) {
        return findById(product.getId()).map(old -> {
            products.remove(old);
            products.add(product);
            return true;
        }).orElse(false);

    }
}
