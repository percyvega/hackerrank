package com.percyvega.model.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * From https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
 */
public abstract class BinaryTreePrinter {

    public static <E extends Comparable<E>> void printNode(BinaryTreeNode<E> root) {
        int maxLevel = BinaryTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <E extends Comparable<E>> void printNodeInternal(List<BinaryTreeNode<E>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BinaryTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BinaryTreePrinter.printWhitespaces(firstSpaces);

        List<BinaryTreeNode<E>> newNodes = new ArrayList<>();
        for (BinaryTreeNode<E> node : nodes) {
            if (node != null && node.value != null) {
                System.out.print(node.value);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BinaryTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BinaryTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BinaryTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null && nodes.get(j).left.value != null)
                    System.out.print("/");
                else
                    BinaryTreePrinter.printWhitespaces(1);

                BinaryTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null && nodes.get(j).right.value != null)
                    System.out.print("\\");
                else
                    BinaryTreePrinter.printWhitespaces(1);

                BinaryTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println();
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <E extends Comparable<E>> int maxLevel(BinaryTreeNode<E> node) {
        if (node == null)
            return 0;

        return Math.max(BinaryTreePrinter.maxLevel(node.left), BinaryTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <E> boolean isAllElementsNull(List<E> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}