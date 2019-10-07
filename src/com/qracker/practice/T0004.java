package com.qracker.practice;

import java.util.Scanner;

public class T0004 {
    public static void main(String[] args){
        System.out.println("请输入需要判断的回文数，范围：1~99999");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        while(s.length()>5){
            System.out.println("ERROR,请输入1~99999的整数");
            s = in.nextLine();
        }
        in.close();
        boolean result = true;
        for(int i = 0;i<=s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1))
                result = false;
        }
        System.out.println("是否是回文数："+result);
    }
}