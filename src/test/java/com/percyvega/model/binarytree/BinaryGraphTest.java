package com.percyvega.model.binarytree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryGraphTest {

    @Test
    void of() {
        BinaryTree<Integer> rootNode = BinaryTree.of(8);

        assertThat(rootNode.value).isEqualTo(8);
        assertThat(rootNode.left).isNull();
        assertThat(rootNode.right).isNull();
    }

    @Test
    void of2() {
        BinaryTree<Integer> rootNode = BinaryTree.of(8, BinaryTree.of(3));

        assertThat(rootNode.value).isEqualTo(8);
        assertThat(rootNode.left.value).isEqualTo(3);
        assertThat(rootNode.right).isNull();
    }

    @Test
    void of3() {
        BinaryTree<Integer> rootNode = BinaryTree.of(8, BinaryTree.of(3), BinaryTree.of(13));

        assertThat(rootNode.value).isEqualTo(8);
        assertThat(rootNode.left.value).isEqualTo(3);
        assertThat(rootNode.right.value).isEqualTo(13);
    }

}