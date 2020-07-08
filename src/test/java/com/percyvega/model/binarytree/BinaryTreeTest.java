package com.percyvega.model.binarytree;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class BinaryTreeTest {

    @Test
    void not_balanced() {
        BinaryTreeNode<Integer> rootNode = BinaryTreeNode.of(4);

        rootNode.left = BinaryTreeNode.of(2, BinaryTreeNode.of(1), BinaryTreeNode.of(3));
        rootNode.right = BinaryTreeNode.of(7, null, BinaryTreeNode.of(8, null, BinaryTreeNode.of(9)));

        assertThat(BinaryTree.isBalanced(rootNode)).isFalse();
    }

    @Test
    void balanced() {
        BinaryTreeNode<Integer> rootNode = BinaryTreeNode.of(4);

        rootNode.left = BinaryTreeNode.of(2);
        rootNode.right = BinaryTreeNode.of(8);

        rootNode.left.left = BinaryTreeNode.of(1);
        rootNode.left.right = BinaryTreeNode.of(3);
        rootNode.right.left = BinaryTreeNode.of(7);
        rootNode.right.right = BinaryTreeNode.of(9);

        assertThat(BinaryTree.isBalanced(rootNode)).isTrue();
    }

}
