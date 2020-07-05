package com.percyvega.model;

import java.util.ArrayList;
import java.util.List;


/**
 * This is a Binary Tree node which represents
 */
public class Node<T> {
    public T value;
    public Node left;
    public Node right;

    public static <T> Node of(T value) {
        return Node.of(value, null, null);
    }

    public static <T> Node of(T... values) {
        List<Node> nodesList = new ArrayList<>(values.length);

        Node rootNode = Node.of(values[0]);
        nodesList.add(rootNode);

        for (int i = 1; i < values.length; i++) {
            Node iNode = Node.of(values[i]);
            nodesList.add(iNode);

            Node parentNode = nodesList.get((int) Math.ceil(i / 2d) - 1);
            if (i % 2 == 1) {
                parentNode.left = iNode;
            } else {
                parentNode.right = iNode;
            }
        }

        return rootNode;
    }

    public static <T> Node of(T value, Node left, Node right) {
        Node node = new Node();
        node.value = value;
        node.left = left;
        node.right = right;

        return node;
    }

}
