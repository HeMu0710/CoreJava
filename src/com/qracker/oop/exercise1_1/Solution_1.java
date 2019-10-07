package com.qracker.oop.exercise1_1;

public class Solution_1 {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {3,1,4,1,5,9,2,6};

        showReversedArray(array1);
        showReversedArray(array2);
    }

    /*
     * Reverse an array and print it in the standard output
     * @param a the input array
     */
    public static void showReversedArray(int[] a) {
        int i;
        for(i = 0;i<=a.length/2 - 1;i++){
            int temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
        for (int x: a
             ) {
            System.out.print(x+" ");
        }
        System.out.println();
    }
}
