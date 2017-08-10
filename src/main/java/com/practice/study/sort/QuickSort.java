package com.practice.study.sort;

import com.practice.base.Base;
import com.practice.base.DataGenerator;

import java.util.Collections;

/**
 * Created by junwuguo on 2017/8/4 0004.
 *
 * 快速排序
 * 速度快、效率高，就跟它的名字一样优秀
 *
 * 逻辑：
 * 每次都选一个基准，将数组分为2个部分，一个比基准大，一个比基准小。
 * 然后再对产生的2个部分分别重复该步骤。
 * 有点二分法的意思，每次都能确定一个基准，虽然每次不知道基准在整个数组排好序后的准确位置，
 * 但是能知道每次的基准是比已有的各个基准是大还是小，等整个数组都走完后，排序自然就出来了。
 *
 * 时间复杂度：O(n*log(n))
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
