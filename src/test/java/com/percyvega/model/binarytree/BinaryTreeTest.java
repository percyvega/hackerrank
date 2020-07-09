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
    void isBalancedTest() {
        BinaryTreeNode<Integer> rootNode = BinaryTree.of(4, 2, 8, 1, 3, 7, 9);

        assertThat(BinaryTree.isBalanced(rootNode)).isTrue();
    }

    @Test
    void toStringTest() {
        BinaryTreeNode<Integer> rootNode1 = BinaryTree.of(4);
        assertThat(BinaryTree.toString(rootNode1)).isEqualTo("4");

        BinaryTreeNode<Integer> rootNode2 = BinaryTree.of(4, 2);
        assertThat(BinaryTree.toString(rootNode2)).isEqualTo("4, 2, null");

        BinaryTreeNode<Integer> rootNode3 = BinaryTree.of(4, null, 8);
        assertThat(BinaryTree.toString(rootNode3)).isEqualTo("4, null, 8");

        BinaryTreeNode<Integer> rootNode4 = BinaryTree.of(4, 2, 8);
        assertThat(BinaryTree.toString(rootNode4)).isEqualTo("4, 2, 8");

        BinaryTreeNode<Integer> rootNode5 = BinaryTree.of(4, 2, 8, 1);
        assertThat(BinaryTree.toString(rootNode5)).isEqualTo("4, 2, 8, 1, null, null, null");
    }

}
