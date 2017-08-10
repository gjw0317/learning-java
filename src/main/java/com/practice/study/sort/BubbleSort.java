package com.practice.study.sort;

import com.practice.base.Base;
import com.practice.base.DataGenerator;

/**
 * Created by junwuguo on 2017/8/4 0004.
 *
 * 冒泡算法
 * 最基本的排序算法
 *
 * 逻辑:
 * 遍历整个数组，两两比较，依次找到最小值、第二小值、……，直至整个序列变成升序排列。
 *
 * 时间复杂度：O(n^2)
 */
public class BubbleSort {
    private static int count = 0;

    public static void bubbleSort(Integer[] array) {
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[i] > array[j]) {
                    Base.swap(array, i, j);
                }
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = DataGenerator.generateArray();
        assert array != null;
        bubbleSort(array);
        Base.display(array);
        System.out.println("size:" + array.length + ", times:" + count);
    }
}
