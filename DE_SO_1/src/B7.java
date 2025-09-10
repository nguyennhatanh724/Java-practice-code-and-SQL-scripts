import java.util.*;

/**
 * Console application for managing products
 * Provide basic operations: add, display, remove, search by name
 * Products are stored temporarily in an in-memory list
 */
public class B7 {
    // Shared Scanner instance for reading user input from console
    private static final Scanner input = new Scanner(System.in);
    // Temporary in-memory storage for products (no database connection)
    private static final List<Product> products = new ArrayList<>();
    // Auto-increment counter to assign unique IDs for new products
    private static int nextId = 1;
    // Temporary in-memory store for products mapped by their unique ID
    private static final Map<Integer, Product> productMap = new HashMap<>();

    /**
     * Entry point of the console application.
     * Loops indefinitely to display the menu and process user choices
     * until option "5. Exit" is selected.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readInt("Choose (1-5): ");
            switch (choice) {
                case 1 -> addProduct();
                case 2 -> displayProducts();
                case 3 -> removeProduct();
                case 4 -> findProduct();
                case 5 -> {
                    System.out.println("Bye!");
                    // End the program
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
        }
    }

    /**
     * Searches for products by name (substring, case-insensitive).
     * If matches are found, prints them; otherwise prints "not found".
     */
    private static void findProduct() {
        String keyword = readNonEmptyString("Search for products by name: ");
        String kw = keyword.toLowerCase(Locale.ROOT);

        boolean found = false;
        for (Product product : products) {
            // Compare in lowercase to allow case-insensitive search
            if (product.getName().contains(kw)) {
                if (!found) {
                    System.out.println("----Found----");
                    found = true;
                }
                System.out.println(product);
            }
        }

        if (!found) {
            System.out.println(keyword + " not found");
        }
    }

    /**
     * Removes a product by its id.
     * If found, prints a removal confirmation; otherwise prints "not found".
     */
    private static void removeProduct() {
        int id = readInt("Enter product id to remove: ");

        if (products.isEmpty()) {
            System.out.println("No products to remove.");
            return;
        }

        Product remove = productMap.remove(id);

        if (remove != null) {
            products.remove(remove);
            System.out.println("Removed: " + remove);
        } else {
            System.out.println(id + " not found");
        }

    }

    /**
     * Displays the list of products.
     * If the list is empty, prints "No products found".
     */
    private static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products found.");
            return;
        }

        System.out.println("----Products list----");

        for (Product product : products) {
            System.out.println(product);
        }
    }

    /**
     * Adds a new product to the list.
     * After successful addition, prints a confirmation message.
     */
    private static void addProduct() {
        String name = readNonEmptyString("Please enter product name: ");
        double price = readDoubleMin("Please enter product price (>= 0): ", 0.0);

        Product p = new Product(nextId++, name.toLowerCase(Locale.ROOT), price);
        products.add(p);
        productMap.put(p.getId(), p);
        System.out.println("Product has been added: " + p);
    }

    /**
     * Prints the program menu.
     */
    private static void printMenu() {
        System.out.println("==== PRODUCTS MANAGER ====");
        System.out.println("1. Add product");
        System.out.println("2. Display products");
        System.out.println("3. Remove product");
        System.out.println("4. Find product by name");
        System.out.println("5. Exit");
    }

    /**
     * Reads an integer value from user input.
     * Keeps prompting until a valid integer is entered.
     *
     * @param prompt the message shown to the user
     * @return a valid integer entered by the user
     */
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

    /**
     * Reads a double value from user input with a minimum allowed value.
     * Keeps prompting until the input is valid and >= minInclusive.
     *
     * @param prompt       the message shown to the user
     * @param minInclusive the minimum allowed value
     * @return a valid double entered by the user
     */
    private static double readDoubleMin(String prompt, double minInclusive) {
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

    /**
     * Reads a non-empty string from user input.
     * Keeps prompting until a non-empty string is entered.
     *
     * @param prompt the message shown to the user
     * @return a valid non-empty string entered by the user
     */
    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = input.nextLine().trim();

            if (!s.isEmpty()) return s;
            System.out.println("Value cannot be empty.");
        }
    }
}
