package com.percyvega.model.binarytree;

import java.util.ArrayList;
import java.util.List;

public abstract class BinaryTree {

    public static <E> BinaryTreeNode<E> of(E... values) {
        List<BinaryTreeNode<E>> nodesList = new ArrayList<>(values.length);

        BinaryTreeNode<E> rootNode = BinaryTreeNode.of(values[0]);
        nodesList.add(rootNode);

        for (int i = 1; i < values.length; i++) {
            BinaryTreeNode<E> iNode = BinaryTreeNode.of(values[i]);
            nodesList.add(iNode);

            BinaryTreeNode<E> parentNode = nodesList.get((int) Math.ceil(i / 2d) - 1);
            if (i % 2 == 1) {
                parentNode.left = iNode;
            } else {
                parentNode.right = iNode;
            }
        }

        return rootNode;
    }

    public static <E> boolean isBalanced(BinaryTreeNode<E> node) {
        if (node.left == null && node.right == null) {
            return true;
        }

        if (Math.abs(height(node.left) - height(node.right)) > 1) {
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);
    }

    public static <E> int height(BinaryTreeNode<E> node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static <E> String toString(BinaryTreeNode<E> node) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= BinaryTree.height(node); i++) {
            appendValues(sb, node, i);
        }

        return sb.toString();
    }

    private static <E> void appendValues(StringBuilder sb, BinaryTreeNode<E> node, int printThisLevel) {
        if (printThisLevel == 1) {
            appendValueOf(sb, node);
        } else {
            BinaryTreeNode<E> nodeLeft = null;
            BinaryTreeNode<E> nodeRight = null;
            if (node != null) {
                nodeLeft = node.left;
                nodeRight = node.right;
            }
            appendValues(sb, nodeLeft, printThisLevel - 1);
            appendValues(sb, nodeRight, printThisLevel - 1);
        }
    }

    private static <E> void appendValueOf(StringBuilder sb, BinaryTreeNode<E> node) {
        if (sb.length() != 0) {
            sb.append(", ");
        }
        if (node != null) {
            sb.append(node.value);
        } else {
            sb.append((E) null);
        }
    }

}
