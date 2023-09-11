package com.percyvega.model.binarytree;

public class BinaryTree<E> {

    public E value;
    public BinaryTree<E> left;
    public BinaryTree<E> right;

    public static <E> BinaryTree<E> of(E value) {
        return BinaryTree.of(value, null, null);
    }

    public static <E> BinaryTree<E> of(E value, BinaryTree<E> left) {
        return BinaryTree.of(value, left, null);
    }

    public static <E> BinaryTree<E> of(E value, BinaryTree<E> left, BinaryTree<E> right) {
        BinaryTree<E> node = new BinaryTree<>();
        node.value = value;
        node.left = left;
        node.right = right;

        return node;
    }

}
