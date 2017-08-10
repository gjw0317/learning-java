package com.practice.base;

/**
 * Created by junwuguo on 2017/8/4 0004.
 */
public class Base {

    public static <T> void display(T[] array) {
        if (array == null) {
            return;
        }
        for (T t: array) {
            System.out.print(t + "\t");
        }
        System.out.println();
    }

    public static <T> void swap(T[] array, int firstIndex, int secondIndex) {
        if (array == null || firstIndex >= array.length || secondIndex >= array.length || firstIndex == secondIndex) {
            return;
        }
        T tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
    }
}
