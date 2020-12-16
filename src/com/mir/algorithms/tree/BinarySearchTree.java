package com.mir.algorithms.tree;


public class BinarySearchTree {

    private TreeNode root;

    public void insert(int value){

        if (null == root){ //tree is empty
            root = new TreeNode(value);
        }else{
            root.insert(value);
        }
    }

    public void traverseInOrder(){
        if (root != null) root.traverseInOrder();
        else System.out.println("Tree is empty");
    }

    public void traversePreOrder(){
        if (root != null) root.traversePreOrder();
        else System.out.println("Tree is empty");
    }

    public void traversePostOrder(){
        if (root != null) root.traversePostOrder();
        else System.out.println("Tree is empty");
    }

    public TreeNode get(int value){

        if (null != root) return  root.get(value);

        return null;

    }

    public int min(){
        if (root == null)
            return Integer.MIN_VALUE;

        else
           return root.min();
    }

    public int max(){
        if (root == null)
            return Integer.MAX_VALUE;

        else
            return root.max();
    }

    public void delete(int value){
        root = delete(root,value);
    }

    private TreeNode delete(TreeNode subTreeRoot, int value){

        if  (subTreeRoot == null){// deleting last element on the tree
            return null;
        }

        if (value < subTreeRoot.getData()){
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(),value));
        }
        else if (value > subTreeRoot.getData()){
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), value));
        }
        else{

            //Caeses 1 and 2: node to delete where node has 0 ot 1 child
            if (subTreeRoot.getLeftChild() == null){
                 return subTreeRoot.getRightChild();
            }else if (subTreeRoot.getRightChild() == null){
                return  subTreeRoot.getLeftChild();

            }

            /**
             * case 3: Node to delete has 2 children
             * Replace the value in the subtreeroot node with the smallest value
             * from the right subtree
             */
            subTreeRoot.setData(subTreeRoot.getRightChild().min());

            //delete the node that has the smallest value in the right subtree
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), subTreeRoot.getData()));
        }

        return subTreeRoot;

    }



    public static void main(String[] args) {

        BinarySearchTree intTree = new BinarySearchTree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);
        intTree.insert(17);

        intTree.traverseInOrder();
        System.out.println();
        intTree.traversePreOrder();
        System.out.println();
        intTree.traversePostOrder();
        System.out.println();


//        intTree.get(27);
//        intTree.get(17);
//        intTree.get(888);

        System.out.println();

//        System.out.println("Min value : " + intTree.min());
//        System.out.println("Min value : " + intTree.max());

//        intTree.delete(15);
//        intTree.traverseInOrder();
//        System.out.println();
//        intTree.delete(17);
//        intTree.traverseInOrder();
//        System.out.println();
//        intTree.delete(25);
//        intTree.traverseInOrder();
//        System.out.println();

        intTree.delete(999);

    }



}
