package com.percyvega.model.binarytree;

import org.junit.jupiter.api.Test;

public class BinaryTreePrinterUtilTest {

    @Test
    void printNode1() {
        BinaryTree<Integer> rootNode = BinaryTree.of(8);
        BinaryTreePrinterUtil.printNode(rootNode);
    }

    @Test
    void printNode2() {
        BinaryTree<Integer> rootNode = BinaryTreeUtils.of(8, 4);
        BinaryTreePrinterUtil.printNode(rootNode);
    }

    @Test
    void printNode3() {
        BinaryTree<Integer> rootNode = BinaryTreeUtils.of(8, 4, 12, 2, 6, 10, 14);
        BinaryTreePrinterUtil.printNode(rootNode);
    }

    @Test
    void printNode4() {
        BinaryTree<Integer> rootNode = BinaryTreeUtils.of(8,
                2, 12,
                1, 4, 10, 14,
                null, null, 3, 7, null, null, null, null,
                null, null, null, null, null, null, 6);
        BinaryTreePrinterUtil.printNode(rootNode);
    }

}
