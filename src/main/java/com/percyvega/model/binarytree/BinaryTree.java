package com.percyvega.model.binarytree;

public abstract class BinaryTree {

    public static <T> boolean isBalanced(BinaryTreeNode<T> node) {
        if (node.left == null && node.right == null) {
            return true;
        }

        if (Math.abs(height(node.left) - height(node.right)) > 1) {
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);
    }

    public static <T> int height(BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

}
