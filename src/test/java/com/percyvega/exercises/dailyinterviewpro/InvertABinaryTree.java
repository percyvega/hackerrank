package com.percyvega.exercises.dailyinterviewpro;

import com.percyvega.model.binarytree.BinaryTree;
import com.percyvega.model.binarytree.BinaryTreeNode;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class inverts a BinaryTree by swapping left and right nodes of a parent.
 * So a tree A, B, C becomes A, C, B
 */
@Log4j2
class InvertABinaryTree {

    @Test
    void testThis() {
        assertThat(BinaryTree.toString(invert(BinaryTree.of("a")))).isEqualTo("a");
        assertThat(BinaryTree.toString(invert(BinaryTree.of("a", "b")))).isEqualTo("a, null, b");
        assertThat(BinaryTree.toString(invert(BinaryTree.of("a", null, "c")))).isEqualTo("a, c, null");
        assertThat(BinaryTree.toString(invert(BinaryTree.of("a", "b", "c")))).isEqualTo("a, c, b");
        assertThat(BinaryTree.toString(invert(BinaryTree.of("a", "b", "c", "d", "e", "f")))).isEqualTo("a, c, b, null, f, e, d");
    }

    private <E> BinaryTreeNode<E> invert(BinaryTreeNode<E> node) {
        if (node != null) {
            BinaryTreeNode<E> temp = node.right;
            node.right = node.left;
            node.left = temp;

            invert(node.left);
            invert(node.right);
        }
        return node;
    }

}
