package com.percyvega.model;

import org.junit.jupiter.api.Test;

public class BTreePrinterTest {

    @Test
    void printNode1() {
        Node<Integer> rootNode = Node.of(8);
        BTreePrinter.printNode(rootNode);
    }

    @Test
    void printNode2() {
        Node<Integer> rootNode = Node.of(8, 4);
        BTreePrinter.printNode(rootNode);
    }

    @Test
    void printNode3() {
        Node<Integer> rootNode = Node.of(8, 4, 12, 2, 6, 10, 14);
        BTreePrinter.printNode(rootNode);
    }

}
