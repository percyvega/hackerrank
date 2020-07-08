package com.percyvega.exercises.java8.codeexercises;

import com.percyvega.model.binarytree.BinaryTreeNode;
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

    private boolean isPerfectBinaryTree(BinaryTreeNode node) {
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

    private int getPerfectlyBinaryTreeHeight(int initialDepth, BinaryTreeNode node) {
        if (node == null) {
            return initialDepth;
        } else {
            return getPerfectlyBinaryTreeHeight(initialDepth + 1, node.left);
        }
    }
}

class SampleBinaryTrees {

    public static BinaryTreeNode binaryTreeHeight0 = BinaryTreeNode.of(3);

    public static BinaryTreeNode binaryTreeHeight1 = BinaryTreeNode.of(
            3,
            BinaryTreeNode.of(2),
            BinaryTreeNode.of(4)
    );

    public static BinaryTreeNode binaryTreeHeight2 = BinaryTreeNode.of(
            3,
            BinaryTreeNode.of(2),
            null
    );

    public static BinaryTreeNode binaryTreeHeight3 = BinaryTreeNode.of(
            3,
            BinaryTreeNode.of(2, BinaryTreeNode.of(4), BinaryTreeNode.of(8)),
            null
    );

    public static BinaryTreeNode binaryTreeHeight4 = BinaryTreeNode.of(
            3,
            BinaryTreeNode.of(2, BinaryTreeNode.of(4), BinaryTreeNode.of(8)),
            BinaryTreeNode.of(5)
    );

    public static BinaryTreeNode binaryTreeHeight5 = BinaryTreeNode.of(
            3,
            BinaryTreeNode.of(2, BinaryTreeNode.of(4), BinaryTreeNode.of(8)),
            BinaryTreeNode.of(2, BinaryTreeNode.of(4), BinaryTreeNode.of(8))
    );

    public static BinaryTreeNode binaryTreeHeight6 = BinaryTreeNode.of(
            3,
            BinaryTreeNode.of(2, BinaryTreeNode.of(4), BinaryTreeNode.of(8)),
            BinaryTreeNode.of(2, BinaryTreeNode.of(4), null)
    );
}