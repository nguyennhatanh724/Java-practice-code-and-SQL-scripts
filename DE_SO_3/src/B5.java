import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B5 {
    private static final Scanner input = new Scanner(System.in);
    private static List<Employee> employees =  new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readInt("Choose (1-5): ");
            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> removeEmployee();
                case 3 -> findEmployee();
                case 4 -> showAllEmployees();
                case 5 -> { System.out.println("Bye!"); return; }
                default -> System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
        }
    }

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


    private static void printMenu() {
        System.out.println("==== EMPLOYEE MANAGER ====");
        System.out.println("1. Add employee");
        System.out.println("2. Remove employee");
        System.out.println("3. Find employee");
        System.out.println("4. Show all employees");
        System.out.println("5. Exit");
    }

    private static void findEmployee(){
        if (employees.isEmpty()) {
            System.out.println("No employees.");
            return;
        }
        String kw = readNonEmptyString("Search name contains: ").toLowerCase();
        boolean found = false;
        for (Employee e : employees) {
            if (e.getName().toLowerCase().contains(kw)) {
                if (!found) {
                    System.out.println("--- Found ---");
                    found = true;
                }
                System.out.println(e);
            }
        }
        if (!found) System.out.println("No match.");
    }


    private static void removeEmployee(){
        if (employees.isEmpty()) {
            System.out.println("No employees.");
            return;
        }
        int id = readInt("Enter employee id to remove: ");
        for( int i = 0; i < employees.size(); i++ ){
            if(employees.get(i).getId() == id){
                Employee employee = employees.remove(i);
                System.out.println("Employee " + employee.getName() + " has been removed");
                return;
            }
        }
        System.out.println("Id" + id + "not match.");
    }

    private static void addEmployee(){
        String name = readNonEmptyString("Enter employee name: ");
        double salary = readDoubleMin("Enter employee salary", 0.0);

        Employee employee = new Employee(nextId++, name, salary);
        employees.add(employee);
        System.out.println("Employee added successfully");
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
