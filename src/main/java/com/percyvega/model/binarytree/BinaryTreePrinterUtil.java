package com.percyvega.model.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * From https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
 */
public abstract class BinaryTreePrinterUtil {

    public static <E extends Comparable<E>> void printNode(BinaryTree<E> root) {
        int maxLevel = BinaryTreePrinterUtil.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <E extends Comparable<E>> void printNodeInternal(List<BinaryTree<E>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BinaryTreePrinterUtil.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BinaryTreePrinterUtil.printWhitespaces(firstSpaces);

        List<BinaryTree<E>> newNodes = new ArrayList<>();
        for (BinaryTree<E> node : nodes) {
            if (node != null && node.value != null) {
                System.out.print(node.value);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BinaryTreePrinterUtil.printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BinaryTreePrinterUtil.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BinaryTreePrinterUtil.printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null && nodes.get(j).left.value != null)
                    System.out.print("/");
                else
                    BinaryTreePrinterUtil.printWhitespaces(1);

                BinaryTreePrinterUtil.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null && nodes.get(j).right.value != null)
                    System.out.print("\\");
                else
                    BinaryTreePrinterUtil.printWhitespaces(1);

                BinaryTreePrinterUtil.printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println();
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <E extends Comparable<E>> int maxLevel(BinaryTree<E> node) {
        if (node == null)
            return 0;

        return Math.max(BinaryTreePrinterUtil.maxLevel(node.left), BinaryTreePrinterUtil.maxLevel(node.right)) + 1;
    }

    private static <E> boolean isAllElementsNull(List<E> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}