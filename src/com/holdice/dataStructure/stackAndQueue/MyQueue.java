package com.holdice.dataStructure.stackAndQueue;

public class MyQueue {

    private int[] space;
    private int pointer = 0;
    private int popTargetIndex = 0;
    private boolean isOver;

    public MyQueue (int size) {
        this.space = new int[size];
    }

    public void push (int number) {
        this.space[pointer] = number;
        pointer ++;
        if (pointer == this.space.length){
            pointer = 0;
            isOver = true;
        }

    }

    public int pop (int defaultValue) {
        if (pointer == popTargetIndex) {
            return defaultValue;
        }
        int popNumber = this.space[popTargetIndex];
        this.space[popTargetIndex] = 0;
        popTargetIndex ++;
        return popNumber;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(10);
        queue.push(3);
        queue.push(2);
    }
}
