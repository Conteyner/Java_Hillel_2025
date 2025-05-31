import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ProductRepository repo = new ProductRepository();
        repo.initData();
        Cart cart = new Cart();
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("""
                    1. List products
                    2. Add product to cart
                    3. Remove product from cart
                    4. Show cart
                    5. Clear cart
                    0. Exit
                    """);
                System.out.print("Your choice: ");
                String choice = sc.nextLine().trim();

                switch (choice) {
                    case "1" -> repo.findAll().forEach(System.out::println);
                    case "2" -> {
                        System.out.print("Product ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        repo.findById(id).ifPresentOrElse(
                                cart::add,
                                () -> System.out.println("Product not found"));
                    }
                    case "3" -> {
                        System.out.print("Product ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        cart.removeById(id);
                    }
                    case "4" -> System.out.println(cart);
                    case "5" -> {
                        cart = new Cart();
                        System.out.println("Cart cleared.");
                    }
                    case "0" -> System.exit(0);
                    default  -> System.out.println("Invalid menu option.");
                }
            }
        }
    }
}
