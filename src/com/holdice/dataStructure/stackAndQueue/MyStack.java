package com.holdice.dataStructure.stackAndQueue;

public class MyStack {

    private int[] space;

    private int pointer = 0;

    public MyStack(int size) {
        this.space = new int[size];
    }

    public void push (int number) {
        this.space[pointer] = number;
        pointer ++;
    }

    public int pop (int defaultValue) {
        if (pointer == 0)
            return defaultValue;
        int popNumber = this.space[pointer - 1];
        this.space[pointer - 1] = 0;
        pointer --;
        return popNumber;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(10);
        stack.push(10);
        stack.push(9);
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(0));
    }
}
