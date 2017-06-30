package com.practice.study.heap;

/**
 * Created by junwuguo on 2017/4/6 0006.
 */
public class BigRootHeap {
    public static int switchCount = 0;
    public static int traverseCount = 0;

    public static void switchInt(int[] heap, int a, int b) {
        switchCount++;
        System.out.println("switch:\t" + heap[a] + "\t" + heap[b]);
        int tmp = heap[b];
        heap[b] = heap[a];
        heap[a] = tmp;
    }

    public static void init1() {
        int[] heap = {20, 12, 35, 15, 10, 80, 30, 17, 2, 1};
        int size = heap.length;
        for (int i = size / 2; i >= 1; i--) {
            traverseCount++;
            if ((2 * i + 1) <= size && heap[i - 1] < heap[2 * i]) {
                switchInt(heap, i - 1, 2 * i);
            }
            if (heap[i - 1] < heap[2 * i - 1]) {
                switchInt(heap, i - 1, 2 * i - 1);
            }
        }
        for (int i : heap) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("switch count:\t" + switchCount);
        System.out.println("traverse count:\t" + traverseCount);
    }

    public static void init2() {
        int[] heap = {20, 12, 35, 15, 10, 80, 30, 17, 2, 1};
        int size = heap.length;
        for (int i = size / 2; i >= 1; i--) {
            traverseCount++;
            int temp = heap[i];
            int c = 2 * i;
            while (c <= size) {
                System.out.println("i=" + i + " c=" + c);
                if (c < size && heap[c - 1] < heap[c]) {
                    c++;
                }
                if (temp >= heap[c - 1]) {
                    break;
                } else {
                    switchCount++;
                    System.out.println("assign:\t" + heap[c / 2] + "\t=\t" + heap[c - 1]);
                    heap[c / 2] = heap[c - 1];
                    c *= 2;
                }
            }
            heap[c / 2] = temp;
        }
        for (int i : heap) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("switch count:\t" + switchCount);
        System.out.println("traverse count:\t" + traverseCount);
    }

    public static void main(String[] args) {
        init1();
        init2();
    }
}
