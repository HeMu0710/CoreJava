package com.qracker.test;

import com.qracker.learn.LengthComparator;

import java.util.Arrays;

public class ComparatorTest {
    public static void main(String[] args) {
        String[] friends = {"Peter","Paul","Jessic"};
        Arrays.sort(friends,new LengthComparator());
        for (String s: friends
             ) {
            System.out.println(s);
        }
    }
}
