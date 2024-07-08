//Assignment 1:
//Take a class Fruit which contains the name & count of the fruit.
//Now let's pass the fruits.txt file from the command line.
//Our program has to calculate the count the number of occurrences of each line in a file
//and update the fruit name & count accordingly.
package Fruitspackage;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Fruit {
    private String name;
    private int count;

    public Fruit(String name) {
        this.name = name;
        this.count = 0;
    }


    public String getName() {
        return name;
    }


    public int getCount() {
        return count;
    }

    public void countof() {
        this.count++;
    }


    public static void main(String[] args) throws IOException {

        String filepath="C://Users//BhanuPrasad//OneDrive - infoservices.com//Desktop//JavaAssignment2//StreamsApi//Fruitspackage//fruit.txt";
        Map<String,Long> fruitcount = Files.lines(Paths.get(filepath)).
                map(String::trim).filter(line->!line.isEmpty()).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
           fruitcount.forEach((name,count)->{
               Fruit fruit=new Fruit(name);
               for(int i=0;i<count;i++) {
                   fruit.countof();
               }
               System.out.println(fruit.name +" "+fruit.count);
           });
    }
}
