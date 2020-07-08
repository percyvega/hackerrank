package com.percyvega.model.binarytree;

import org.junit.jupiter.api.Test;

public class BinaryTreePrinterTest {

    @Test
    void printNode1() {
        BinaryTreeNode<Integer> rootNode = BinaryTreeNode.of(8);
        BinaryTreePrinter.printNode(rootNode);
    }

    @Test
    void printNode2() {
        BinaryTreeNode<Integer> rootNode = BinaryTreeNode.of(8, 4);
        BinaryTreePrinter.printNode(rootNode);
    }

    @Test
    void printNode3() {
        BinaryTreeNode<Integer> rootNode = BinaryTreeNode.of(8, 4, 12, 2, 6, 10, 14);
        BinaryTreePrinter.printNode(rootNode);
    }

    @Test
    void printNode4() {
        BinaryTreeNode<Integer> rootNode = BinaryTreeNode.of(8,
                2, 12,
                1, 4, 10, 14,
                null, null, 3, 7, null, null, null, null,
                null, null, null, null, null, null, 6);
        BinaryTreePrinter.printNode(rootNode);
    }

}
