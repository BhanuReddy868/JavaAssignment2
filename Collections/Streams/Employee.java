package Streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class Employee {
     int id;
    private final String name;
    private final int age;
    private final String gender;
    private final String position;
    private  final int year;
    private final double salary;

    public Employee(int id, String name, int age, String gender, String position, int year, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.position = position;
        this.year = year;
        this.salary = salary;

    }


    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    public String getGender() {
        return gender;
    }

    public String getPosition() {
        return position;
    }

    public int getYear() {
        return year;
    }
    public double getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(111, "Vishnu Priya", 32, "Female", "HR", 2011, 25000.0));
        list.add(new Employee(122, "Vinay Raj", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        list.add(new Employee(133, "Avinash Reddy", 29, "Male", "Infrastructure", 2012, 18000.0));
        list.add(new Employee(144, "Bhanu Prasad", 28, "Male", "Product Development", 2014, 32500.0));
        list.add(new Employee(155, "Aish Roy", 27, "Female", "HR", 2013, 22700.0));
        list.add(new Employee(166, "Raj Vignesh", 43, "Male", "Security And Transport", 2016, 10500.0));
        list.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        list.add(new Employee(188, "Chandra Mouli", 31, "Male", "Product Development", 2015, 34500.0));
        list.add(new Employee(199, "Shilpa Shetty", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        list.add(new Employee(200, "Kumar Raja", 38, "Male", "Security And Transport", 2015, 11000.5));
        list.add(new Employee(211, "Ameen Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        list.add(new Employee(222, "Sunil Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        list.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        list.add(new Employee(244, "Shankar Dada", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        list.add(new Employee(255, "Alia Butt", 23, "Male", "Infrastructure", 2018, 12700.0));
        list.add(new Employee(266, "Santhi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        list.add(new Employee(277, "Sunil Shetty", 31, "Male", "Product Development", 2012, 35700.0));

        //1 : How many male and female employees are there in the organization?
        long countmale = list.stream().filter(count -> count.getGender().equalsIgnoreCase("male")).count();
        System.out.println("The number of male employees in organization is " + countmale);

        List<String> genderlist = list.stream().filter(gender -> gender.getGender().equalsIgnoreCase("MAle")).
                map(gender -> gender.getName() + " - " + gender.getGender()).toList();
        genderlist.forEach(System.out::println);

        System.out.println();
        long countfemale = list.stream().filter(count -> count.getGender().equalsIgnoreCase("female")).count();
        System.out.println("The number of male employees in organization is " + countfemale);
        List<String> genderlist1 = list.stream().filter(gender -> gender.getGender().equalsIgnoreCase("female")).
                map(gender -> gender.getName() + " - " + gender.getGender()).toList();
        genderlist1.forEach(System.out::println);
        //2 : Print the name of all departments in the organization?
        System.out.println();
        System.out.println("The Departments in Organization are :");
        Map<String,List<Employee>> maplist=list.stream().collect(Collectors.groupingBy(Employee::getPosition));
        maplist.forEach((position,_) ->
            System.out.println(position)
        );
        System.out.println();
        //3 : What is the average age of male and female employees?
        double averageofmale = list.stream().filter(gender -> gender.getGender().equalsIgnoreCase("male"))
                .mapToDouble(Employee::getAge).average().orElse(0.0);
        System.out.println("The average age of male employees is " + averageofmale);
        System.out.println();
        double averageoffemale = list.stream().filter(gender -> gender.getGender().equalsIgnoreCase("female"))
                .mapToDouble(Employee::getAge).average().orElse(0.0);
        System.out.println("The average age of female employees is " + averageoffemale);
        System.out.println();
        //4 : Get the details of highest paid employee in the organization?

        Optional<Employee> higestpaid = list.stream().max(Comparator.comparingDouble(Employee::getSalary));
        higestpaid.ifPresent(emp -> {
            System.out.println("The highest paid employee details are");
            System.out.println("name : " + emp.getName());
            System.out.println("age : " + emp.getAge());
            System.out.println("Department : " + emp.getPosition());
            System.out.println("salary : " + emp.getSalary());
        });
        System.out.println();
        //5 : Get the names of all employees who have joined after 2015?

        Predicate<Employee> name= year->year.getYear() > 2015;
        System.out.println("The Employees who has joined after 2015 : ");
        list.stream().filter(name).map(Employee::getName).forEach(System.out::println);

//        System.out.println("The employees who joined after 2015 :");
//        list.stream().filter(name -> name.getYear() > 2015).map(Employee::getName)
//                .forEach(System.out::println);
        //6:Count the number of employees in each department?
        System.out.println();
        Map<String, Long> maplist1 = list.stream().collect(Collectors.groupingBy(Employee::getPosition, Collectors.counting()));
        for (Map.Entry<String, Long> entry : maplist1.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println();
        //7 : What is the average salary of each department?
          Map<String, Double> averagesalary = list.stream().collect(Collectors
                .groupingBy(Employee::getPosition, Collectors.averagingDouble(Employee::getSalary)));
        averagesalary.forEach((position, avgsal) ->
                    System.out.println("Department  : " + position + " Average salary is " + avgsal)
        );
        System.out.println();
        //8 : Get the details of youngest male employee in the product Development.
        Optional<Employee> young = list.stream().filter(position -> position.getPosition().equalsIgnoreCase("Product Development")).min(Comparator.comparing(Employee::getAge));
        young.ifPresent(age ->
            System.out.println("The youngest employee in department Product and Development : " + age.getName()  + " Age is  " + age.getAge() )
        );
        //9 : Who has the most working experience in the organization?
        Optional<Employee> experience=list.stream().min(Comparator.comparing(Employee::getYear));
        experience.ifPresent(exp->
                    System.out.println("The employee who has more work experience in organization is : " +
                            " " +exp.getName() + " from Department : " +exp.getPosition())
                );
        System.out.println();
    //10 : How many male and female employees are there in the sales and Marketing
        System.out.println("Male Employees who are in Sales And Marketing");
        Stream<Employee> maleemp=list.stream().
                filter(emp->emp.getPosition().equalsIgnoreCase("Sales And Marketing")).
                filter(emp->emp.getGender().equalsIgnoreCase("Male"));

        maleemp.forEach(emp1 ->
            System.out.println(emp1.getName())
        );
        System.out.println("Female employees who are in Sales And Marketing are :");
        Stream<Employee> femaleemp=list.stream().
                filter(emp->emp.getPosition().equalsIgnoreCase("Sales And Marketing")).
                filter(emp->emp.getGender().equalsIgnoreCase("female"));

        femaleemp.forEach(emp1 ->
            System.out.println(emp1.getName())
        );

        System.out.println();
        //11 : What is the average salary of male and female employees?
        Map<String,Double> avgsalary=list.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
        avgsalary.forEach((gender,sal)->
            System.out.println("The Average salary of  " + gender + " is "  +sal)
                );
        System.out.println();
        //12 : List down the names of all employees in each department?
        System.out.println();
        Map<String, List<Employee>> nameofdep = list.stream().collect(Collectors.groupingBy(Employee::getPosition));
        nameofdep.forEach((position, emplist) -> {
            System.out.println();
            System.out.println("Department :" + position);
            emplist.forEach(emp -> System.out.println(emp.getName()));
        });
        System.out.println();
        //13 : What is the average salary and total salary of the whole organization
        double streamofsal=list.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println("The sum of Total salaries is : " + streamofsal);
        double streamofavgsal=list.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("The Average of Total salaries is : " + streamofavgsal);

    //14 : Separate the employees who are younger or equal to 25 years from
        System.out.println();
       list.stream().filter(emp -> emp.getAge()<=25).
       forEach(emp->System.out.println("The employees who are younger or equal to 25 years are : "+emp.getName()+ ","  + " Age is " + emp.getAge())
       );

       //15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
        System.out.println();
        Optional<Employee> maxage = list.stream().max(Comparator.comparing(Employee::getAge));
        maxage.ifPresent(age ->
            System.out.println("The oldest employee is : "+age.getName() + " and Age is : " + age.getAge() + "  from Department : " +age.getPosition())
        );
    }
}

