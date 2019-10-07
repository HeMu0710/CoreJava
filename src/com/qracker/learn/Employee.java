package com.qracker.learn;
import java.time.LocalDate;

public class Employee implements Comparable<Employee>
{
    private static int nextId = 0;
    private int id = setId();
    private final String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name,double salary,int year,int month,int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year,month,day);
    }

    public Employee(){
        this.name = " ";
        this.salary = 0;
        this.hireDay = LocalDate.now();
    }

    public Employee(String n) {
        this.name = n;
        this.salary = 0;
        this.hireDay = LocalDate.now();
    }

    public String toString(){
       return "ID:"+this.id+" name:"+this.getName()+" salary:"+this.getSalary()+" hireday:"+this.getHireDay();
    }

    public String getName(){
        return this.name;
    }

    public double getSalary(){
        return this.salary;
    }

    public LocalDate getHireDay(){
        return this.hireDay;
    }

    public void setSalary(double newsalary){
        this.salary = newsalary;
    }

    private int setId(){
        nextId++;
        return nextId;
    }

    public static int getNextId(){
        return nextId + 1;
    }

    public static int pow(int a,int b){
        int result = a;
        for(int i = 1;i<b;i++){
            result = result*a;
        }
        return result;
    }

    public static void doubleSalary(Employee e){
        e.setSalary(e.getSalary()*2);
    }

    @Override
    public boolean equals(Object otherObject) {
        if(this == otherObject) return true;
        if(otherObject == null) return false;
        if(!(otherObject instanceof Employee)) return false;
        Employee other = (Employee) otherObject;
        return id == other.id
                && name == other.name
                && salary == other.salary
                && hireDay == other.hireDay;
    }

    public int compareTo(Employee other) {
        return Double.compare(salary, other.salary);
}
}
