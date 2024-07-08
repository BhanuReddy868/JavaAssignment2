//3 Create an EmployeeSet class.
//In this class add a TreeSet field that holds employee objects. Name this field as "empTreeSet".
// This TreeSet should add objects in the sorting order as defined by the EmpComparator class described above.

package Comparatorpackage;

import java.util.TreeSet;

public class EmployeeSet {
    private TreeSet<Employee> empTreeset;

    public EmployeeSet() {
        empTreeset = new TreeSet<>(new EmpComparator());
    }

    public int addEmployee(Employee emp) {

        try {
            if (emp == null) {
                throw new IllegalArgumentException("Employee cannot be null");
            }
            empTreeset.add(emp);
            return 0; 
        } catch (Exception e) {
            e.printStackTrace();
            return 1; 
        }
    }

    public void printEmployees() {
        for (Employee emp : empTreeset) {
            if (Integer.compare(emp.getAge(), 0) > 0) {
                System.out.println(emp);
            }
        }
    }
}
