package com.percyvega.nonhackerrank.bst;

public class BinarySearchTree {

    Node root;

    public BinarySearchTree(Node root) {
        if(root == null) {
            throw new RuntimeException("BinarySearchTree root can't be null.");
        }

        this.root = root;
    }

    boolean isBalanced() {
        return Node.isBalanced(root);
    }

    public int height() {
        return Node.height(root);
    }

    public void add(Node newNode) {
        // implement addition

        // self-check tha it is still balanced
    }
}
