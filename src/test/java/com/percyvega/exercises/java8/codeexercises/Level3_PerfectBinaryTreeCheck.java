package com.percyvega.exercises.java8.codeexercises;

import com.percyvega.model.Node;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * A binary tree is perfect when all levels are complete.
 * Write a method that checks if a binary tree is perfect.
 * TreeNode API methods: node.left and node.right.
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
        if ((node.left == null && node.right == null)) {
            return true;
        } else if ((node.left != null && node.right != null)) {
            return
                    isPerfectBinaryTree(node.left) && isPerfectBinaryTree(node.right) &&
                            getPerfectlyBinaryTreeHeight(0, node.left) == getPerfectlyBinaryTreeHeight(0, node.right);
        } else {
            return false;
        }
    }

    private int getPerfectlyBinaryTreeHeight(int initialDepth, Node node) {
        if (node == null) {
            return initialDepth;
        } else {
            return getPerfectlyBinaryTreeHeight(initialDepth + 1, node.left);
        }
    }
}

class SampleBinaryTrees {

    public static Node binaryTreeHeight0 = Node.of(3);

    public static Node binaryTreeHeight1 = Node.of(
            3,
            Node.of(2),
            Node.of(4)
    );

    public static Node binaryTreeHeight2 = Node.of(
            3,
            Node.of(2),
            null
    );

    public static Node binaryTreeHeight3 = Node.of(
            3,
            Node.of(2, Node.of(4), Node.of(8)),
            null
    );

    public static Node binaryTreeHeight4 = Node.of(
            3,
            Node.of(2, Node.of(4), Node.of(8)),
            Node.of(5)
    );

    public static Node binaryTreeHeight5 = Node.of(
            3,
            Node.of(2, Node.of(4), Node.of(8)),
            Node.of(2, Node.of(4), Node.of(8))
    );

    public static Node binaryTreeHeight6 = Node.of(
            3,
            Node.of(2, Node.of(4), Node.of(8)),
            Node.of(2, Node.of(4), null)
    );
}