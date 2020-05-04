package com.percyvega.practice.java8.codeexercises;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * A binary tree is perfect when all levels are complete.
 * Write a method that checks if a binary tree is perfect.
 * TreeNode API methods: node.left() and node.right().
 */
public class Level3_PerfectBinaryTreeCheck {

    @Test
    void isPerfectBinaryTree() {
        assertThat(isPerfectBinaryTree(SampleBinaryTrees.binaryTreeHeight0)).isTrue();
        assertThat(isPerfectBinaryTree(SampleBinaryTrees.binaryTreeHeight1)).isTrue();
        assertThat(isPerfectBinaryTree(SampleBinaryTrees.binaryTreeHeight2)).isFalse();
        assertThat(isPerfectBinaryTree(SampleBinaryTrees.binaryTreeHeight3)).isFalse();
        assertThat(isPerfectBinaryTree(SampleBinaryTrees.binaryTreeHeight4)).isFalse();
        assertThat(isPerfectBinaryTree(SampleBinaryTrees.binaryTreeHeight5)).isTrue();
        assertThat(isPerfectBinaryTree(SampleBinaryTrees.binaryTreeHeight6)).isFalse();
    }

    private boolean isPerfectBinaryTree(Node node) {
        if ((node.left() == null && node.right() == null)) {
            return true;
        } else if ((node.left() != null && node.right() != null)) {
            return
                    isPerfectBinaryTree(node.left()) && isPerfectBinaryTree(node.right()) &&
                            getPerfectlyBinaryTreeHeight(0, node.left()) == getPerfectlyBinaryTreeHeight(0, node.right());
        } else {
            return false;
        }
    }

    private int getPerfectlyBinaryTreeHeight(int initialDepth, Node node) {
        if (node == null) {
            return initialDepth;
        } else {
            return getPerfectlyBinaryTreeHeight(initialDepth + 1, node.left());
        }
    }
}

class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this(value, null, null);
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int value() {
        return value;
    }

    public Node left() {
        return left;
    }

    public Node right() {
        return right;
    }
}

class SampleBinaryTrees {

    public static Node binaryTreeHeight0 = new Node(3);

    public static Node binaryTreeHeight1 = new Node(
            3,
            new Node(2),
            new Node(4)
    );

    public static Node binaryTreeHeight2 = new Node(
            3,
            new Node(2),
            null
    );

    public static Node binaryTreeHeight3 = new Node(
            3,
            new Node(2, new Node(4), new Node(8)),
            null
    );

    public static Node binaryTreeHeight4 = new Node(
            3,
            new Node(2, new Node(4), new Node(8)),
            new Node(5)
    );

    public static Node binaryTreeHeight5 = new Node(
            3,
            new Node(2, new Node(4), new Node(8)),
            new Node(2, new Node(4), new Node(8))
    );

    public static Node binaryTreeHeight6 = new Node(
            3,
            new Node(2, new Node(4), new Node(8)),
            new Node(2, new Node(4), null)
    );
}