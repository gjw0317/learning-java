package com.practice.Objects;

/**
 * Created by junwuguo on 2017/8/16 0016.
 */
public class TreeNode {

    public String name;
    public int value;
    public TreeNode leftChild;
    public TreeNode rightChild;

    public TreeNode(String name) {
        this.name = name;
    }

    public TreeNode(int value){
        this.name = "node" + String.valueOf(value);
        this.value = value;
    }

    public TreeNode(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public TreeNode(String name, int value, TreeNode leftChild, TreeNode rightChild) {
        this.name = name;
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

}
