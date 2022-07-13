package com.practise;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    /*
    Utility to find highest in BST
     */
    public static  int highestInBST(TreeNode root){
        while(root.right!=null){
            root = root.right;
        }
        return root.value;
    }
    /*
    https://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
    Utility to find highest in BST
     */
    public static  TreeNode addGreaterValueBST(TreeNode root){
        if(root == null){
            return null;
        }
        return null;
    }
    /*
    Utility method
     */
    public static void printSpace(int spaceInt){
        StringBuffer space = new StringBuffer(" ");
        for(int i =0;i<spaceInt;i++){
            space.append(" ");
        }
        System.out.print(space);
    }

    /*
    2 queue logic can reduce complexity
     */
    public static void printAsPerTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queueTwo = new LinkedList<TreeNode>();
        TreeNode node = new TreeNode();
        queue.add(root);
        int level = 1;
        while(queue.peek()!=null){
            node = queue.poll();
            System.out.print(node.value);
            if(node.left!= null){
                queueTwo.add(node.left);
            }
            printSpace(level);
            if(node.right!= null){
                queueTwo.add(node.right);
            }
            if(queue.peek()==null){
                System.out.println();
                queue = queueTwo;
                queueTwo= new LinkedList<TreeNode>();
            }
            else{
                printSpace(level);
            }
        }
    }
    /*
    In order traversal
     */
    public static void printInOrder(TreeNode root){
        if(root !=null){
            printInOrder(root.left);
           System.out.print(root.value+" ");
            printInOrder(root.right);
        }
    }
    /*
    Pre order traversal
     */
    public static void printPreOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.value +" ");
            printInOrder(root.left);
            printInOrder(root.right);
        }
    }
    /*
    Post order traversal
     */
    public static void printPostOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            printInOrder(root.right);
            System.out.print(root.value+" ");
        }
    }
    /*
    Construct binary tree from the array given
     */
    public static TreeNode constructBinaryTree(int[] arr){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode();
        if(arr.length>=1){
            root.value =arr[0];
            queue.add(root);
        }
        TreeNode interRoot;
        TreeNode queueNode = null;
        for(int i=1;i<arr.length;i++){
            interRoot = new TreeNode();
            if(queueNode==null){
                queueNode = queue.poll();
            }
            interRoot = new TreeNode();
            interRoot.value = arr[i];
            if(queueNode.left == null){
                queueNode.left = interRoot;
                queue.add(interRoot);
            }
            else if(queueNode.right == null){
                queueNode.right = interRoot;
                queue.add(interRoot);
            }
            if(queueNode.right != null & queueNode.left != null) {
                queueNode = queue.peek() != null ? queue.poll() : null;
            }
        }
    return root;
    }
    /*
    To check whether the binary tree is BST or not
     */
    public static  boolean isBinaryTreeBST(TreeNode root){
        if(root.left!=null){
            if(root.value>root.left.value){
                isBinaryTreeBST(root.left);
            }else{
                return false;
            }
        }
        if(root.right!=null){
            if(root.value<root.right.value){
                isBinaryTreeBST(root.right);
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] arg){
        int[] values ={10,2,14,1,9,13,16};
        TreeNode root =constructBinaryTree(values);
        System.out.println("In order");
        printInOrder(root);
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Pre order");
        printPreOrder(root);
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Post order");
        printPostOrder(root);
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Is input makes binary treeisBinary:"+isBinaryTreeBST(root));
        System.out.println("--------------------------------------------------------------------------------------------");
        printAsPerTree(root);
        System.out.println("--------------------------------------------------------------------------------------------");
    }
}
