package com.qracker.test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    public static void main(String args[]) {
        List<String> staff = new LinkedList<>();
        staff.add("Amy");
        staff.add("Bob");
        staff.add("Carl");

        Iterator it = staff.iterator();
        String first = (String) it.next();
        String Second = (String) it.next();
        it.remove();
    }
}
