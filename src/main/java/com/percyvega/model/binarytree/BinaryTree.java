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

    public static <T> String toString(BinaryTreeNode<T> node) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= BinaryTree.height(node); i++) {
            appendValues(sb, node, i);
        }

        return sb.toString();
    }

    private static <T> void appendValues(StringBuilder sb, BinaryTreeNode<T> node, int printThisLevel) {
        if (printThisLevel == 1) {
            appendValueOf(sb, node);
        } else {
            BinaryTreeNode<T> nodeLeft = null;
            BinaryTreeNode<T> nodeRight = null;
            if (node != null) {
                nodeLeft = node.left;
                nodeRight = node.right;
            }
            appendValues(sb, nodeLeft, printThisLevel - 1);
            appendValues(sb, nodeRight, printThisLevel - 1);
        }
    }

    private static <T> void appendValueOf(StringBuilder sb, BinaryTreeNode<T> node) {
        if (sb.length() != 0) {
            sb.append(", ");
        }
        if (node != null) {
            sb.append(node.value);
        } else {
            sb.append((T) null);
        }
    }

}
