package com.example.kotlindemo.utils;

public class LengthToCompare {

public static int c=0;
    public static void main(String[] args) {

        while (!compareString("abbcd","cdabb")){
            System.out.println("正在交换");
        }
        System.out.println("结束了 交换了"+c+"次");
    }
    /**
     *
     */
    public static boolean compareString(String a, String b) {
        c++;
        String newA = a.substring(1, a.length()) + a.substring(0, 1);
        System.out.println(newA);
        if (newA.equals(b)) {
            return true;
        }else if (c==a.length()&&!newA.equals(b)){
            return false;
        }
        return compareString(newA,b) ;
    }
}
