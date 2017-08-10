package com.practice.study.sort;

import com.practice.base.Base;
import com.practice.base.DataGenerator;

/**
 * Created by junwuguo on 2017/8/10 0010.
 *
 * 堆排序
 * 可以解决Top K问题
 * 可以构建优先队列
 *
 * 逻辑：
 * 以大根堆为例
 * 1、构建大根堆，则根节点最大
 * 2、交换根节点与最右节点，将根节点到第二右节点之间的堆构建成大根堆，则最右节点为最大值，根节点为第二大值
 * 3、交换根节点与第二右节点，将根节点到第三右节点之间的堆构建成大根堆，则第二右节点为第二大值，根节点为第三大值
 * 4、重复上述步骤，直至根节点与根节点的左儿子也交换完了，则整个数组已经排好序了，根节点最小，最右节点最大。
 *
 * 时间复杂度：最坏O(n*log(n))
 *
 * 相关知识点：
 * 1、堆：
 * 完全二叉树
 * 所有节点都不大于（不小于）其父节点，称之为大根堆（小根堆）
 */
public class HeapSort {
    private static int count = 0;

    public static void HeapSort(Integer[] array) {
        BuildMaxHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            Base.swap(array, i, 0);
            BuildEachNode(array, i, 0);
            count++;
        }
    }

    public static void BuildMaxHeap(Integer[] array){
        if (array == null) {
            return;
        }
        for (int i = array.length / 2; i >= 0; i--) {
            BuildEachNode(array, array.length, i);
            count++;
        }
    }

    public static void BuildEachNode(Integer[] array, int heapSize, int index) {
        if (array == null || index >= array.length / 2) {
            return;
        }
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int maxValueIndex = index;
        if (leftChildIndex < heapSize && array[leftChildIndex] > array[maxValueIndex]) {
            maxValueIndex = leftChildIndex;
        }
        if (rightChildIndex < heapSize && array[rightChildIndex] > array[maxValueIndex]) {
            maxValueIndex = rightChildIndex;
        }
        if (index != maxValueIndex) {
            Base.swap(array, index, maxValueIndex);
            BuildEachNode(array, heapSize, maxValueIndex);
        }
        count++;
    }

    public static void main(String[] args) {
        Integer[] array = DataGenerator.generateArray();
        assert array != null;
        Base.display(array);
        BuildMaxHeap(array);
        Base.display(array);
        HeapSort(array);
        Base.display(array);
        System.out.println("size:" + array.length + ", times:" + count);
    }
}
