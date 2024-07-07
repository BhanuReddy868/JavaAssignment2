//Assignment2:
//Write a java program to add employees to a TreeSet based on a user defined comparator.
//1.An Employee class is given to you. It defines the fields: Id, name, salary and age. It has getters/setters for each and constructors.

package Comparatorpackage;

public class Employee {
    private int Id;
    private String name;
    private int age;
    private double salary;

    public Employee(int id, String name, int age, double salary) {
        Id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
