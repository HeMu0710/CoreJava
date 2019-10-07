package com.qracker.learn;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name,double salary,int year,int month,int day){
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public double getSalary(){
        return bonus + super.getSalary();
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }

    public String toString() {
        return super.toString() + "[bonus=" + this.bonus + "]";
    }
}
