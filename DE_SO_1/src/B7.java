import java.util.ArrayList;
import java.util.Scanner;

public class B7 {
    private static final Scanner input = new Scanner(System.in);
    private static final ArrayList<Product> products = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readInt("Choose (1-5): ");
            switch (choice) {
                case 1 -> addProduct();
                case 2 -> displayProducts();
                case 3 -> removeProduct();
                case 4 -> findProduct();
                case 5 -> { System.out.println("Bye!"); return; }
                default -> System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
        }
    }

    private static void findProduct() {
        String keyword = readNonEmptyString("Search for products by name: ");
        String kw = keyword.toLowerCase();

        boolean found = false;
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(kw)) {
                if(!found) {
                    System.out.println("----Found----");
                    found = true;
                }
                System.out.println(product);
            }
        }
    }

    private static void removeProduct() {
        int id = readInt("Enter product id to remove: ");
        for(int i = 0; i<products.size(); i++){
            if(id==products.get(i).getId()){
                Product remove = products.remove(i);
                System.out.println("Removed: " + remove);
            }
        }
    }

    private static void displayProducts() {
        if(products.isEmpty()){
            System.out.println("No products found.");
            return;
        }
        System.out.println("----Products list----");
        for(Product product : products){
            System.out.println(product);
        }
    }

    private static void addProduct() {
        String name = readNonEmptyString("Please enter your name: ");
        double price = readDoubleMin("Please enter your price (>= 0): ", 0.0);

        Product p = new Product(nextId++, name, price);
        products.add(p);
        System.out.println("Your product has been added."+ p.toString());
    }

    private static void printMenu() {
        System.out.println("==== PRODUCTS MANAGER ====");
        System.out.println("1. Add product");
        System.out.println("2. Display products");
        System.out.println("3. Remove product");
        System.out.println("4. Find product by name");
        System.out.println("5. Exit");
    }
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer, try again.");
            }
        }
    }

    private static double readDoubleMin( String prompt, double minInclusive) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            try {
                double v = Double.parseDouble(line);
                if (v < minInclusive) {
                    System.out.println("Value must be >= " + minInclusive);
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
    }

    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = input.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Value cannot be empty.");
        }
    }

}
