package com.practice.study.enumClass;

/**
 * Created by junwuguo on 2017/2/16 0016.
 */
public class EnumTest {
    public static void main(String[] args) {
        System.out.println(EnumClass.ONE);
        System.out.println(EnumClass.TWO.getValue());
        System.out.println(EnumClass.valueOf("ONE"));
        System.out.println(EnumClass.valueOf("TWO").getValue());
        try {
            System.out.println(EnumClass.valueOf("THREE"));
        } catch (IllegalArgumentException e) {
            System.out.println("none");
        }


        for (EnumClass tmp : EnumClass.values()) {
            System.out.println(tmp.name());
        }
    }
}
