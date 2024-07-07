package collection;

import java.util.*;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String position;
    private int year;
    private double salary;

    public Employee(int id, String name, int age, String gender, String position, int year, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.position = position;
        this.year = year;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static void main(String[] args) {
        List<Employee> l = new ArrayList<>();
        l.add(new Employee(111, "Vishnu Priya", 32, "Female", "HR", 2011, 25000.0));
        l.add(new Employee(122, "Vinay Raj", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        l.add(new Employee(133, "Avinash Reddy", 29, "Male", "Infrastructure", 2012, 18000.0));
        l.add(new Employee(144, "Bhanu Prasad", 28, "Male", "Product Development", 2014, 32500.0));
        l.add(new Employee(155, "Aish Roy", 27, "Female", "HR", 2013, 22700.0));
        l.add(new Employee(166, "Raj Vignesh", 43, "Male", "Security And Transport", 2016, 10500.0));
        l.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        l.add(new Employee(188, "Chandra Mouli", 31, "Male", "Product Development", 2015, 34500.0));
        l.add(new Employee(199, "Shilpa Shetty", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        l.add(new Employee(200, "Kumar Raja", 38, "Male", "Security And Transport", 2015, 11000.5));
        l.add(new Employee(211, "Ameen Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        l.add(new Employee(222, "Sunil Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        l.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        l.add(new Employee(244, "Shankar Dada", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        l.add(new Employee(255, "Alia Butt", 23, "Male", "Infrastructure", 2018, 12700.0));
        l.add(new Employee(266, "Santhi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        l.add(new Employee(277, "Sunil Shetty", 31, "Male", "Product Development", 2012, 35700.0));

        // How many male and female employees are there in the organization?
        int malecount = 0;
        int femalecount = 0;
        for (Employee employee : l) {
            if (employee.getGender().equalsIgnoreCase("Male")) {
                malecount++;
            }
        }
        System.out.println("the number of male empolyees in company are : " + malecount);
        for (Employee employee : l) {
            if (employee.getGender().equalsIgnoreCase("Female")) {
                femalecount++;
            }
        }
        System.out.println("the number of female empolyees in company are : " + femalecount);
        System.out.println();

//2 : Print the name of all departments in the organization?
        HashSet<String> department = new HashSet<>();
        for (Employee employee : l) {
            department.add(employee.getPosition());
        }
        System.out.println();
        for (String dep : department) {
            System.out.println("The departments are : " + dep);
        }
        System.out.println();
//3 : What is the average age of male and female employees?
        float sumofmale = 0;
        float sumoffemale=0;
        float a=0f;
        float b=0f;
        for (Employee employee : l) {
            if (employee.getGender().equalsIgnoreCase("Male")) {
                a = (sumofmale += employee.getAge()) / malecount;
            }
        }
        System.out.println("The count of male  is:" + malecount);
        System.out.println("The sum of male age is :"+sumofmale);
        System.out.println("The average of male age is : " +a);

        System.out.println();
        for (Employee employee : l) {
            if (employee.getGender().equalsIgnoreCase("female")) {
                b = (sumoffemale += employee.getAge()) / femalecount;
            }
        }
        System.out.println("The count of female  is:" + femalecount);
        System.out.println("The sum of female age is :"+sumoffemale);
        System.out.println("The average of female age is : " +b);




        System.out.println();
            //4 : Get the details of highest paid employee in the organization?

            ArrayList<Double> arr = new ArrayList<Double>();
            for (Employee employee : l) {
                arr.add(employee.getSalary());
            }
            double max = arr.get(0);
            int n = arr.size();
            for (int i = 1; i < n; i++) {
                if (arr.get(i) > max) {
                    max = arr.get(i);
                }
            }
            System.out.println("The highest salary of employee in organization is :" + max);

            System.out.println();

            //5 : Get the names of all employees who have joined after 2015?
            for (Employee employee : l) {
                if (employee.getYear() > 2015) {

                    System.out.println("The employees how joined after 2015 :" + employee.getName());
                }
            }

            System.out.println();

            //6 : Count the number of employees in each department?
            int countofProductDevelopment = 0;
            for (Employee employee : l) {
                if (employee.getPosition().equalsIgnoreCase("Product Development")) {
                    countofProductDevelopment++;
                }
            }
            System.out.println("The Employee who Department is product development is:" + countofProductDevelopment);

            int countofSalesAndMarketing = 0;
            for (Employee employee : l) {
                if (employee.getPosition().equalsIgnoreCase("Sales And Marketing")) {
                    countofSalesAndMarketing++;

                }
            }
            System.out.println("The Employee who Department is Sales And Marketing is:" + countofSalesAndMarketing);

            int countofSecurityAndtransport = 0;
            for (Employee employee : l) {
                if (employee.getPosition().equalsIgnoreCase("Security And transport")) {
                    countofSecurityAndtransport++;
                }
            }
            System.out.println("The Employee who Department is Security And transport is:" + countofSecurityAndtransport);

            int countofInfrastructure = 0;
            for (Employee employee : l) {
                if (employee.getPosition().equalsIgnoreCase("Infrastructure")) {
                    countofInfrastructure++;
                }
            }
            System.out.println("The Employee who Department is Infrastructure is:" + countofInfrastructure);

            int countofHR = 0;
            for (Employee employee : l) {
                if (employee.getPosition().equalsIgnoreCase("HR")) {
                    countofHR++;
                }
            }
            System.out.println("The Employee who Department is HR is:" + countofHR);

            int countofAccountAndFinance = 0;
            for (Employee employee : l) {
                if (employee.getPosition().equalsIgnoreCase("Account And Finance")) {
                    countofAccountAndFinance++;
                }
            }
            System.out.println("The Employee who Department is Account And Finance is:" + countofAccountAndFinance);
            System.out.println();


            // 7: What is the average salary of each department?
            int sumofsalaryofPD = 0;
            int countofsalaryPD = 0;
            int PD = 0;
            for (Employee employee : l) {
                if (employee.getPosition().equalsIgnoreCase("Product Development")) {
                    countofsalaryPD++;
                    PD = (sumofsalaryofPD += employee.getSalary()) / countofsalaryPD;
                }
            }
            System.out.println("The sum of salaries of Product Development department is:" + sumofsalaryofPD);
            System.out.println("The average salary of Product Development department is :" + PD);
            System.out.println();

            int sumofsalaryofsm = 0;
            int countofsalarysm = 0;
            int sm = 0;
            for (Employee employee : l) {
                if (employee.getPosition().equalsIgnoreCase("sales and marketing")) {
                    countofsalarysm++;
                    sm = (sumofsalaryofsm += employee.getSalary()) / countofsalarysm;
                }
            }
            System.out.println("The sum of salaries of Sales and Marketing department is:" + sumofsalaryofPD);
            System.out.println("The average salary of Sale and Marketing department is :" + sm);


            System.out.println();
            int sumofsalaryofST = 0;
            int countofsalaryST = 0;
            int ST = 0;
            for (Employee employee : l) {
                if (employee.getPosition().equalsIgnoreCase("Security And Transport")) {
                    countofsalaryST++;
                    ST = (sumofsalaryofST += employee.getSalary()) / countofsalaryST;
                }
            }
            System.out.println("The sum of salaries of Security and transporting is:" + sumofsalaryofST);
            System.out.println("The average salary of Security and transporting is :" + ST);


            System.out.println();
            int sumofsalaryofIN = 0;
            int countofsalaryIN = 0;
            int IN = 0;
            for (Employee employee : l) {
                if (employee.getPosition().equalsIgnoreCase("Infrastructure")) {
                    countofsalaryIN++;
                    IN = (sumofsalaryofIN += employee.getSalary()) / countofsalaryIN;
                }
            }
            System.out.println("The sum of salaries of Infrastructure is:" + sumofsalaryofIN);
            System.out.println("The average salary of Infrastructure is :" + IN);


            System.out.println();
            int sumofsalaryofHR = 0;
            int countofsalaryHR = 0;
            int HR = 0;
            for (Employee employee : l) {
                if (employee.getPosition().equalsIgnoreCase("HR")) {
                    countofsalaryHR++;
                    HR = (sumofsalaryofHR += employee.getSalary()) / countofsalaryHR;
                }
            }
            System.out.println("The sum of salaries of HR is:" + sumofsalaryofHR);
            System.out.println("The average salary of HR is :" + HR);

            System.out.println();
            int sumofsalaryofAF = 0;
            int countofsalaryAF = 0;
            int AF = 0;
            for (Employee employee : l) {
                if (employee.getPosition().equalsIgnoreCase("Account and Finance")) {
                    countofsalaryAF++;
                    AF = (sumofsalaryofAF += employee.getSalary()) / countofsalaryAF;
                }
            }
            System.out.println("The sum of salaries of Account And Finance is:" + sumofsalaryofAF);
            System.out.println("The average salary of Account And Finance is :" + AF);

            System.out.println();
            //  8 : Get the details of youngest male employee in the product
            Employee young = l.get(0);
            for (Employee employee : l) {
                if (employee.getGender().equalsIgnoreCase("MAle") && employee.getPosition().equalsIgnoreCase("Product Development")) {
                    if (employee.age < young.age) {
                        young = employee;
                    }
                }
            }

            System.out.println("The youngest Male  in product and Development is: " + young.name + "is " + young.age);

            System.out.println();

            //9.Who has the most working experience in the organization?
            Employee workyears = l.get(0);
            for (Employee employee : l) {
                if (employee.year < workyears.year) {
                    workyears = employee;
                }
            }
            System.out.println("The employee who has most working experinece in organization is : " + workyears.name + "  since " + workyears.year);
            System.out.println();
            //10 : How many male and female employees are there in the sales
            int countofMale = 0;
            int countOffemale = 0;
            for (Employee employee : l) {
                if (employee.getPosition().equalsIgnoreCase("sales and marketing")) {
                    if (employee.getGender().equalsIgnoreCase("Male")) {
                        countofMale++;
                    } else
                        countOffemale++;
                }
            }
            System.out.println("The number of male who are in sales and marketing is :" + countofMale);
            System.out.println("The number of female who are in sales and marketing is :" + countOffemale);

            System.out.println();
            //11 : What is the average salary of male and female employees?
            int count1 = 0;
            int count2 = 0;
            double sumofmalesalary = 0;
            double sumoffemalesalary = 0;
            double x = 0;
            double y = 0;
            for (Employee employee : l) {
                if (employee.getGender().equalsIgnoreCase("Male")) {
                    count1++;
                    x = (sumofmalesalary += employee.getSalary()) / count1;
                } else {
                    count2++;
                    y = (sumoffemalesalary += employee.getSalary()) / count2;
                }
            }
            System.out.println(count1);
            System.out.println("the average of male salary is : " + x);
            System.out.println(count2);
            System.out.println("the average of female salary is : " + y);

            System.out.println();
            //12 : List down the names of all employees in each department?

            Map<String, List<Employee>> postion = new HashMap<>();
            for (Employee employee : l) {
                postion.computeIfAbsent(employee.getPosition(), k -> new ArrayList<>()).
                        add(employee);
            }
            for (Map.Entry<String, List<Employee>> entry : postion.entrySet()) {
                System.out.println();
                System.out.println("Department :" + entry.getKey());
                for (Employee employee : entry.getValue()) {
                    System.out.println(employee.getName());
                }
            }
            System.out.println();
            //13 : What is the average salary and total salary of the whole
            int totalsalary = 0;
            int avg = 0;
            int countofSalary = 0;
            for (Employee employee : l) {
                countofSalary++;
                totalsalary += employee.getSalary();
                avg = totalsalary / countofSalary;
            }
            System.out.println("The total salary of whole employees is" + totalsalary);
            System.out.println("The average salary of whole employees is :" + avg);

            System.out.println();
            //14 : Separate the employees who are younger or equal to 25 years from
            for (Employee employee : l) {
                if (employee.age <= 25) {
                    System.out.println("The age of employee who is younger and equals to 25 :" + employee.getName() + " age is : " + employee.getAge());
                }
            }
            System.out.println();

            //15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
            for (Employee employee : l) {
                if (employee.age > young.age) {
                    young = employee;
                }
            }
            System.out.println("The oldest employee in organization is  " + young.getName() + "  age is  " + young.getAge() + " and department is  " + young.getPosition());
        }
    }


