package com.qracker.oop.exercise1_2;

public class Circle extends Shape{
    private double radius;

    Circle(double r){
        this.radius = r;
    }
    @Override
    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }
}
