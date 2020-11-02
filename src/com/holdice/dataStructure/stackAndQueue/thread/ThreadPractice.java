package com.holdice.dataStructure.stackAndQueue.thread;

public class ThreadPractice {
    public static void main(String[] args) {
        IsNum isNum = new IsNum(true);
        new EchoNum("打印字母",isNum).start();
        new EchoChar("打印数字",isNum).start();
    }
}
