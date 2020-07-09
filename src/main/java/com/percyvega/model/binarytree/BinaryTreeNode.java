package com.percyvega.model.binarytree;

/**
 * This is a Binary Tree node which represents
 */
public class BinaryTreeNode<T> {

    public T value;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public static <T> BinaryTreeNode<T> of(T value) {
        return BinaryTreeNode.of(value, null, null);
    }

    public static <T> BinaryTreeNode<T> of(T value, BinaryTreeNode<T> left) {
        return BinaryTreeNode.of(value, left, null);
    }

    public static <T> BinaryTreeNode<T> of(T value, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        BinaryTreeNode<T> node = new BinaryTreeNode<>();
        node.value = value;
        node.left = left;
        node.right = right;

        return node;
    }

}
