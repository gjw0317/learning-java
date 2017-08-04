package com.practice.study.sort;

import com.practice.base.Base;
import com.practice.base.DataGenerator;

import java.util.Collections;

/**
 * Created by junwuguo on 2017/8/4 0004.
 */
public class QuickSort {
    private static int count = 0;

    private static int partition(Integer[] array, int left, int right) {
        int tmpIndex = left;
        int tmpValue = array[left];
        while (left < right) {
            while (left < right && array[right] >= tmpValue) {
                right--;
                count++;
            }
            while (left < right && array[left] <= tmpValue) {
                left++;
                count++;
            }
            Base.swap(array, left, right);
            count++;
        }
        Base.swap(array, tmpIndex, left);
        return left;
    }

    public static void quickSort(Integer[] array, int left, int right) {
        if (array == null || left >= array.length || right >= array.length || left >= right) {
            return;
        }
        int x = partition(array, left, right);
        quickSort(array, left, x - 1);
        quickSort(array, x + 1, right);
    }

    public static void main(String[] args) {
        Integer[] array = DataGenerator.generateArray();
        assert array != null;
        quickSort(array, 0, array.length - 1);
        Base.display(array);
        System.out.println("size:" + array.length + ", times:" + count);
    }
}
