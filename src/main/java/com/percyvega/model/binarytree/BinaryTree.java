package com.percyvega.model.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E> {

    public E value;
    public BinaryTree<E> left;
    public BinaryTree<E> right;

    @SafeVarargs
    public static <E> BinaryTree<E> of(E... values) {
        List<BinaryTree<E>> nodesList = new ArrayList<>(values.length);

        BinaryTree<E> rootNode = BinaryTree.of(values[0]);
        nodesList.add(rootNode);

        for (int i = 1; i < values.length; i++) {
            BinaryTree<E> iNode = BinaryTree.of(values[i]);
            nodesList.add(iNode);

            BinaryTree<E> parentNode = nodesList.get((int) Math.ceil(i / 2d) - 1);
            if (parentNode != null) {
                if (i % 2 == 1) {
                    parentNode.left = iNode;
                } else {
                    parentNode.right = iNode;
                }
            }
        }

        return rootNode;
    }

    public static <E> BinaryTree<E> of(E value) {
        return value == null ? null : BinaryTree.of(value, null, null);
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

    public void left(E value) {
        this.left = BinaryTree.of(value);
    }

    public void right(E value) {
        this.right = BinaryTree.of(value);
    }

    public void left(BinaryTree<E> binaryTree) {
        this.left = binaryTree;
    }

    public void right(BinaryTree<E> binaryTree) {
        this.right = binaryTree;
    }

}
