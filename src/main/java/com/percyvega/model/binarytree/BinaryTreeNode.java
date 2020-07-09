package com.percyvega.model.binarytree;

/**
 * This is a Binary Tree node which represents
 */
public class BinaryTreeNode<E> {

    public E value;
    public BinaryTreeNode<E> left;
    public BinaryTreeNode<E> right;

    public static <E> BinaryTreeNode<E> of(E value) {
        return BinaryTreeNode.of(value, null, null);
    }

    public static <E> BinaryTreeNode<E> of(E value, BinaryTreeNode<E> left) {
        return BinaryTreeNode.of(value, left, null);
    }

    public static <E> BinaryTreeNode<E> of(E value, BinaryTreeNode<E> left, BinaryTreeNode<E> right) {
        BinaryTreeNode<E> node = new BinaryTreeNode<>();
        node.value = value;
        node.left = left;
        node.right = right;

        return node;
    }

}
