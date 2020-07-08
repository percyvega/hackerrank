package com.percyvega.model.binarytree;

import java.util.ArrayList;
import java.util.List;

public abstract class BinaryTree {

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
