package com.percyvega.model.binarytree;

import java.util.ArrayList;
import java.util.List;

public abstract class BinaryTreeUtils {

    public static <E> BinaryTree<E> of(E... values) {
        List<BinaryTree<E>> nodesList = new ArrayList<>(values.length);

        BinaryTree<E> rootNode = BinaryTree.of(values[0]);
        nodesList.add(rootNode);

        for (int i = 1; i < values.length; i++) {
            BinaryTree<E> iNode = BinaryTree.of(values[i]);
            nodesList.add(iNode);

            BinaryTree<E> parentNode = nodesList.get((int) Math.ceil(i / 2d) - 1);
            if (i % 2 == 1) {
                parentNode.left = iNode;
            } else {
                parentNode.right = iNode;
            }
        }

        return rootNode;
    }

    public static <E> boolean isBalanced(BinaryTree<E> node) {
        if (node.left == null && node.right == null) {
            return true;
        }

        if (Math.abs(height(node.left) - height(node.right)) > 1) {
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);
    }

    public static <E> int height(BinaryTree<E> node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static <E> String toString(BinaryTree<E> node) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= BinaryTreeUtils.height(node); i++) {
            appendValues(sb, node, i);
        }

        return sb.toString();
    }

    private static <E> void appendValues(StringBuilder sb, BinaryTree<E> node, int printThisLevel) {
        if (printThisLevel == 1) {
            appendValueOf(sb, node);
        } else {
            BinaryTree<E> nodeLeft = null;
            BinaryTree<E> nodeRight = null;
            if (node != null) {
                nodeLeft = node.left;
                nodeRight = node.right;
            }
            appendValues(sb, nodeLeft, printThisLevel - 1);
            appendValues(sb, nodeRight, printThisLevel - 1);
        }
    }

    private static <E> void appendValueOf(StringBuilder sb, BinaryTree<E> node) {
        if (!sb.isEmpty()) {
            sb.append(", ");
        }
        if (node != null) {
            sb.append(node.value);
        } else {
            sb.append((E) null);
        }
    }

}
