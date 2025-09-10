import java.util.*;

/**
 * Console application for managing books.
 * Provide basic operations: add, search by author.
 * Books are stored in an in-memory list (ArrayList).
 */
public class B6 {
    //Share Scanner instance for reading user input from console
    private static final Scanner input = new Scanner(System.in);
    // Temporaty in-memory storage for products (no database connection)
    private static final ArrayList<Book> books = new ArrayList<>();
    // Index for fast lookup by author (exact match after normalization)
    private static final Map<String, List<Book>> byAuthor = new HashMap<>();


    /**
     * Entry point of the console application.
     * Loop indefinitely to display the menu and process user choices until option "3. Exit" is selected.
     *
     * @param args
     */
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add book");
            System.out.println("2. Find books by author");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            String choice = input.nextLine().trim();
            switch (choice) {
                case "1" -> addBook();
                case "2" -> findBookByAuthor();
                case "3" -> {
                    System.out.println("Goodbye!");
                    //Finish the program
                    return;
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }

    /**
     * Normalize for case-insensitive exact matching
     */
    private static String norm(String input) {
        return input == null ? "" : input.trim().toLowerCase(Locale.ROOT);
    }

    /**
     * Adds a new book to the list.
     * After successfully addition, print a confirmation message
     */
    private static void addBook() {
        String title = readNonEmptyString("Enter title: ");
        String author = readNonEmptyString("Enter author: ");
        int year = readInt("Enter year: ");

        Book newBook = new Book(title, author, year);
        books.add(newBook);

        byAuthor.computeIfAbsent(norm(author), k -> new ArrayList<>()).add(newBook);

        System.out.println("Book added successfully");
    }

    /**
     * Search the book in the list by author name
     * If matches are found, shown the book with a confirmation message; otherwise print "Book not found"
     */
    private static void findBookByAuthor() {
        String searchAuthor = readNonEmptyString("Enter author: ");

        List<Book> booksByAuthor = byAuthor.getOrDefault(searchAuthor, List.of());

        if (!booksByAuthor.isEmpty()) {
            System.out.println("Book found successfully");
        } else {
            System.out.println("Book not found");
        }
    }

    /**
     * Read a non-empty string from user input.
     * Keep prompting until the user provides a valid value
     *
     * @param prompt the prompt message displayed to the user
     * @return the non-empty string entered by the user
     */
    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = input.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Value cannot be empty.");
        }
    }

    /**
     * Read a not-null integer from user input.
     * Keep prompting until the user provides a valid value
     *
     * @param prompt the prompt message displayed to the user
     * @return the not-null integer entered by the user
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
}
