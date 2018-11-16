package com.knowledge.accumulation.common;

public class Test {

    public static void main(String[] args) {
        String  a = "aa";
        String b = "aa";
        String a1 = a+b;
        String a2 = "aaaa";
        String a3 = new String("aaaa");
        System.out.println(a1==a2);
        System.out.println(a2==a3);
        String c = new String("aa");
        String d = new String("aa");
        System.out.println(a == b);
        System.out.println(a == c);
    }
}
