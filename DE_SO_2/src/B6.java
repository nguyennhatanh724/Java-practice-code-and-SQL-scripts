import java.util.ArrayList;
import java.util.Scanner;

public class B6 {
    private static final Scanner input = new Scanner(System.in);
    private static final ArrayList<Book> books = new ArrayList<>();

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
                    return; // kết thúc chương trình
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }
    private static void addBook() {
        String title = readNonEmtyString("Enter title: ");
        String author = readNonEmtyString("Enter author: ");
        int year = readInt("Enter year: ");
        Book newBook = new Book(title, author, year);
        books.add(newBook);
        System.out.println("Book added successfully");
    }

    private static void findBookByAuthor() {
        String searchAuthor = readNonEmtyString("Enter author: ");
        boolean found = false;
        for( Book book1 : books) {
            if(book1.getAuthor().equals(searchAuthor)) {
                System.out.println(book1);
                found = true;
            }
        }
        if(found) {
            System.out.println("Book found successfully");
        }else{
            System.out.println("Book not found");
        }
    }

    private static String readNonEmtyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = input.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Value cannot be empty.");
        }
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
}
