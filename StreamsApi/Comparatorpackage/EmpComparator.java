//2.Create a class EmpComparator, that implements the comparator interface. The comparision of two employee objects should follow the rule below:
//Employees must be first sorted based on the ascending order of salaries. This means that the employee object that contains the lowest salary should come BEFORE the employees who have higher salaries
//•If salaries are equal, sort based on the alphabetic order of their names.
//•If salaries and names are equal then sort on the descending order of their age.

package Comparatorpackage;

import java.util.Comparator;
    public class EmpComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee e1, Employee e2) {
            int salarycompare=Double.compare(e1.getSalary(),e2.getSalary());
            if(salarycompare!=0){
                return  salarycompare;
            }
            int namecompare=e1.getName().compareTo(e2.getName());
            if(namecompare!=0){
                return namecompare;
            }
            return Integer.compare(e1.getAge(),e2.getAge());
        }

    }
