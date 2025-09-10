import java.util.*;

/**
 * Console application for managing employees
 * Provide operations: add, remove, search by id, display.
 * Employee are stored in an in-memory list
 */
public class B5 {
    //Share scanner instance for reading input from user
    private static final Scanner input = new Scanner(System.in);
    //Temporary in-memory storage for employees (no database connection)
    private static final List<Employee> employees = new ArrayList<>();
    // Auto-increment counter to assign unique IDs for new products
    private static int nextId = 1;
    // Temporary in-memory store for employee mapped by their unique ID
    private static final Map<Integer, Employee> byId = new HashMap<>();

    /**
     * Entry point of console program
     * Loop indefinite to display menu and process user choices until option "5. Exit"
     *
     * @param args (not use)
     */
    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readInt("Choose (1-5): ");
            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> removeEmployee();
                case 3 -> findEmployee();
                case 4 -> showAllEmployees();
                case 5 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
        }
    }

    /**
     * Display the employee list.
     * If list is empty, print "No employees." .
     */
    private static void showAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees.");
            return;
        }
        System.out.println("--- Employee list ---");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    /**
     * Display the menu
     */
    private static void printMenu() {
        System.out.println("==== EMPLOYEE MANAGER ====");
        System.out.println("1. Add employee");
        System.out.println("2. Remove employee");
        System.out.println("3. Find employee");
        System.out.println("4. Show all employees");
        System.out.println("5. Exit");
    }

    /**
     * Search the employee by name (substring, case-insensitive)
     * If matches are found, print them; otherwise print "No match." .
     */
    private static void findEmployee() {
        if (employees.isEmpty()) {
            System.out.println("No employees.");
            return;
        }

        int id = readInt("Enter employee id to find: ");
        Employee e = byId.get(id);

        if (e == null) {
            System.out.println("Id " + id + " not match.");
        } else {
            System.out.println(e);
        }

    }

    /**
     * Adds a new employee to the list.
     * After successful addition, prints a confirmation message.
     */
    private static void addEmployee() {
        String name = readNonEmptyString("Enter employee name: ");
        double salary = readDoubleMin("Enter employee salary", 0.0);

        Employee employee = new Employee(nextId++, name, salary);
        employees.add(employee);
        byId.put(employee.getId(), employee);

        System.out.println("Employee added successfully");
    }

    /**
     * Removes an employee by id.
     * If the id exists, prints a confirmation message and removes the employee;
     * otherwise prints "Id ... not match.".
     */
    private static void removeEmployee() {
        if (employees.isEmpty()) {
            System.out.println("No employees.");
            return;
        }
        int id = readInt("Enter employee id to remove: ");

        Employee removed = byId.remove(id);
        if (removed == null) {
            System.out.println("Id " + id + " not match.");
            return;
        }

        employees.removeIf(employee -> employee.getId() == id);
        System.out.println("Id " + id + " not match.");
    }

    /**
     * Reads an integer value from user input.
     * Keeps prompting until a valid integer is entered.
     *
     * @param prompt the message displayed to the user
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
     * @param prompt       the message displayed to the user
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
     * @param prompt the message displayed to the user
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
