package com.percyvega.model.binarytree;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class BinaryGraphUtilsTest {

    @Test
    void not_balanced() {
        BinaryTree<Integer> rootNode = BinaryTree.of(4);

        rootNode.left = BinaryTree.of(2, BinaryTree.of(1), BinaryTree.of(3));
        rootNode.right = BinaryTree.of(7, null, BinaryTree.of(8, null, BinaryTree.of(9)));

        assertThat(BinaryTreeUtils.isBalanced(rootNode)).isFalse();
    }

    @Test
    void isBalancedTest() {
        BinaryTree<Integer> rootNode = BinaryTree.of(4, 2, 8, 1, 3, 7, 9);

        assertThat(BinaryTreeUtils.isBalanced(rootNode)).isTrue();
    }

    @Test
    void toStringTest() {
        BinaryTree<Integer> rootNode1 = BinaryTree.of(4);
        assertThat(BinaryTreeUtils.toString(rootNode1)).isEqualTo("4");

        BinaryTree<Integer> rootNode2 = BinaryTree.of(4, 2);
        assertThat(BinaryTreeUtils.toString(rootNode2)).isEqualTo("4, 2, null");

        BinaryTree<Integer> rootNode3 = BinaryTree.of(4, null, 8);
        assertThat(BinaryTreeUtils.toString(rootNode3)).isEqualTo("4, null, 8");

        BinaryTree<Integer> rootNode4 = BinaryTree.of(4, 2, 8);
        assertThat(BinaryTreeUtils.toString(rootNode4)).isEqualTo("4, 2, 8");

        BinaryTree<Integer> rootNode5 = BinaryTree.of(4, 2, 8, 1);
        assertThat(BinaryTreeUtils.toString(rootNode5)).isEqualTo("4, 2, 8, 1, null, null, null");
    }

}
