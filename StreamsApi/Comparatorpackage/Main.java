package Comparatorpackage;

public class Main {
    public static void main(String[] args) {
         EmployeeSet employeeSet=new EmployeeSet();
        employeeSet.addEmployee(new Employee(111, "Vishnu Priya", 32, 25000.0));
        employeeSet.addEmployee(new Employee(122, "Vinay Raj", 25,13500.0));
        employeeSet.addEmployee(new Employee(133, "Avinash Reddy", 29, 18000.0));
        employeeSet.addEmployee(new Employee(144, "Bhanu Prasad", 28,32500.0));
        employeeSet.addEmployee(new Employee(166, "Raj Vignesh", 43, 10500.0));
        employeeSet.addEmployee(new Employee(177, "Manu Sharma", 35,27000.0));
       employeeSet.printEmployees();
    }
}
