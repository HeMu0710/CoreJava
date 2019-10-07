package com.qracker.test;

import com.qracker.learn.Employee;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Employee> staff = new TreeMap<>();
        staff.put("144-25-5464",new Employee("Amy Lee"));
        staff.put("567-21-1234",new Employee("Harry Hacker"));
        staff.put("899-20-2546",new Employee("Gray Cooper"));
        staff.put("134-87-3549",new Employee("Francesca Cruz"));

        System.out.println(staff);
        staff.remove("144-25-5464");
        staff.put("567-21-1234",new Employee("Francesca Miller"));
        System.out.println(staff.get("899-20-2546"));
        staff.forEach((k,v)->
                System.out.println("key=" + k + ", value= " + v));
    }
}
