package com.practice.study.tree;

import com.practice.Objects.TreeNode;
import com.practice.base.DataGenerator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by junwuguo on 2017/8/16 0016.
 */
public class Traversal {

    /**
     * 广度优先遍历
     * 示例：每行输出一层，每层从左到右，依次输出各个节点的value
     * 思路：广度优先、队列、计数
     * @param root
     */
    public static void BreadthFirstTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 1;
        int nextLevel = 0;
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp == null) {
                break;
            }
            System.out.print(tmp.value);
            if (tmp.leftChild != null) {
                queue.add(tmp.leftChild);
                nextLevel++;
            }
            if (tmp.rightChild != null) {
                queue.add(tmp.rightChild);
                nextLevel++;
            }
            currentLevel--;
            if (currentLevel == 0) {
                System.out.println();
                currentLevel = nextLevel;
                nextLevel = 0;
            } else {
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = DataGenerator.generateTree();
        BreadthFirstTraversal(root);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        t1.leftChild = t2;
        t1.rightChild = t3;
        t2.leftChild = t4;
        t2.rightChild = t5;
        t4.leftChild = t6;
        t4.rightChild = t7;
        t6.leftChild = t8;
        t8.leftChild = t9;
        BreadthFirstTraversal(t1);
    }
}
