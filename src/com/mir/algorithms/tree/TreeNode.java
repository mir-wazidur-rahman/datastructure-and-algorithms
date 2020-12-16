package com.mir.algorithms.tree;

import sun.reflect.generics.tree.Tree;

public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data){
        this.data = data;
    }

    public void insert(int value){
        if (value == data) {
            System.out.println("Duplicate values not allowed");
            return;
        }

        if(value < data){
            if (leftChild == null) //left child is empty and can be inserted
                leftChild = new TreeNode(value);

            else leftChild.insert(value);// calling insert on the left child
        }else{
            if (rightChild == null) //right child is empty and can be inserted
                rightChild = new TreeNode(value);

            else rightChild.insert(value);// calling insert on the right child
        }

    }

    public TreeNode get(int value){

        if (value == data){
            System.out.println("Data = " + data);
            return this;
        }

        if (value < data){
            if (null != leftChild) return leftChild.get(value);
        }else{
            if (null != rightChild) return rightChild.get(value);
        }

        System.out.println(value + " not found");
        return null;
    }

    public void traverseInOrder(){

        if (leftChild != null){
            leftChild.traverseInOrder();
        }
        System.out.print(data + ",");

        if (rightChild != null){
            rightChild.traverseInOrder();
        }
    }

    public void traversePreOrder(){

        System.out.print(data + ",");
        if (leftChild != null){
            leftChild.traverseInOrder();
        }


        if (rightChild != null){
            rightChild.traverseInOrder();
        }
    }

    public void traversePostOrder(){


        if (leftChild != null){
            leftChild.traverseInOrder();
        }


        if (rightChild != null){
            rightChild.traverseInOrder();
        }
        System.out.print(data + ",");
    }

    public int min() {

        if (null == leftChild)
            return data;

        else
           return leftChild.min();
    }

    public int max() {

        if (null == rightChild)
            return data;

        else
            return rightChild.max();
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Data=" + data;
    }
}
