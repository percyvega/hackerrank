package com.percyvega.exercises.dailyinterviewpro;

import com.percyvega.model.binarytree.BinaryTreeUtils;
import com.percyvega.model.binarytree.BinaryTree;
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
        assertThat(BinaryTreeUtils.toString(invert(BinaryTreeUtils.of("a")))).isEqualTo("a");
        assertThat(BinaryTreeUtils.toString(invert(BinaryTreeUtils.of("a", "b")))).isEqualTo("a, null, b");
        assertThat(BinaryTreeUtils.toString(invert(BinaryTreeUtils.of("a", null, "c")))).isEqualTo("a, c, null");
        assertThat(BinaryTreeUtils.toString(invert(BinaryTreeUtils.of("a", "b", "c")))).isEqualTo("a, c, b");
        assertThat(BinaryTreeUtils.toString(invert(BinaryTreeUtils.of("a", "b", "c", "d", "e", "f")))).isEqualTo("a, c, b, null, f, e, d");
    }

    private <E> BinaryTree<E> invert(BinaryTree<E> node) {
        if (node != null) {
            BinaryTree<E> temp = node.right;
            node.right = node.left;
            node.left = temp;

            invert(node.left);
            invert(node.right);
        }
        return node;
    }

}
