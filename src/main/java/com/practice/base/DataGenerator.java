package com.practice.base;

import com.practice.Objects.TreeNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by junwuguo on 2017/8/4 0004.
 */
public class DataGenerator {
    public static String fileForSort = "src/main/resources/for_sort.txt";

    public static Integer[] generateArray() {
        File file = new File(fileForSort);
        BufferedReader reader = null;
        List<Integer> list = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tmp = null;
            while ((tmp = reader.readLine()) != null) {
                String[] line = tmp.split(" ");
                for (String num: line) {
                    list.add(Integer.valueOf(num));
                }
            }
            Integer[] result = new Integer[list.size()];
            list.toArray(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static TreeNode generateTree() {
        Integer[] array = generateArray();
        if (array == null || array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for(int i = 1; i < array.length && !queue.isEmpty(); i++) {
            TreeNode tmp = queue.peek();
            if (tmp == null) {
                break;
            }
            TreeNode newNode = new TreeNode(array[i]);
            queue.add(newNode);
            if (tmp.leftChild == null) {
                tmp.leftChild = newNode;
            } else if (tmp.rightChild == null) {
                tmp.rightChild = newNode;
                queue.poll();
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] x = generateArray();
        Base.display(x);
        TreeNode root = generateTree();
        Base.display(x);
    }
}
