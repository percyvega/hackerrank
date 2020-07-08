package com.percyvega.model.binarytree;

import java.util.ArrayList;
import java.util.List;


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

    public static <T> BinaryTreeNode<T> of(T... values) {
        List<BinaryTreeNode<T>> nodesList = new ArrayList<>(values.length);

        BinaryTreeNode<T> rootNode = BinaryTreeNode.of(values[0]);
        nodesList.add(rootNode);

        for (int i = 1; i < values.length; i++) {
            BinaryTreeNode<T> iNode = BinaryTreeNode.of(values[i]);
            nodesList.add(iNode);

            BinaryTreeNode<T> parentNode = nodesList.get((int) Math.ceil(i / 2d) - 1);
            if (i % 2 == 1) {
                parentNode.left = iNode;
            } else {
                parentNode.right = iNode;
            }
        }

        return rootNode;
    }

    public static <T> BinaryTreeNode<T> of(T value, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        BinaryTreeNode<T> node = new BinaryTreeNode<>();
        node.value = value;
        node.left = left;
        node.right = right;

        return node;
    }

}
