import java.util.Scanner;

//..............Employee class..............
abstract class Employee {
  private String name;
  private String id;
  private int salary;

  public Employee(String name, int id, int salary) {
    this.name = name;
    this.id = Integer.toString(id);
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return Integer.parseInt(id);
  }

  public int getSalary() {
    return salary;
  }

  // Abstract method to be implemented in subclasses
  public abstract int calculateSalary(); // Calculate salary in subclasses

  // Override Object's toString method for better representation
  @Override
  public String toString() {
    return "Name: " + name + ", Id: " + id + ", Salary: " + salary;
  }
}

// ......................FullTimeEmployee..............................
class FullTimeEmployee extends Employee {
  private double monthlySalary;

  public FullTimeEmployee(String name, int id, int salary, double monthlySalary) {
    super(name, id, salary);
    this.monthlySalary = monthlySalary;
  }

  // Implement calculateSalary() for full-time employees
  @Override
  public int calculateSalary() {
    return (int) (monthlySalary * 12); // Assuming annual salary based on monthly
  }
}

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter employee name: ");
    String name = scanner.nextLine();

    System.out.print("Enter employee ID: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // Consume the newline character

    System.out.print("Enter employee salary: ");
    int salary = scanner.nextInt();
    scanner.nextLine(); // Consume the newline character

    System.out.print("Enter monthly salary: ");
    double monthlySalary = scanner.nextDouble();

    FullTimeEmployee emp = new FullTimeEmployee(name, id, salary, monthlySalary);
    System.out.println("Calculated Salary: " + emp.calculateSalary());
    System.out.println(emp.toString()); // Use toString() for output
  }
}