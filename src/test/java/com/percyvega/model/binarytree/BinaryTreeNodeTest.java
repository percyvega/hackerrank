package com.percyvega.model.binarytree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {

    @Test
    void of() {
        BinaryTreeNode<Integer> rootNode = BinaryTreeNode.of(8);

        assertThat(rootNode.value).isEqualTo(8);
        assertThat(rootNode.left).isNull();
        assertThat(rootNode.right).isNull();
    }

    @Test
    void of2() {
        BinaryTreeNode<Integer> rootNode = BinaryTreeNode.of(8, BinaryTreeNode.of(3));

        assertThat(rootNode.value).isEqualTo(8);
        assertThat(rootNode.left.value).isEqualTo(3);
        assertThat(rootNode.right).isNull();
    }

    @Test
    void of3() {
        BinaryTreeNode<Integer> rootNode = BinaryTreeNode.of(8, BinaryTreeNode.of(3), BinaryTreeNode.of(13));

        assertThat(rootNode.value).isEqualTo(8);
        assertThat(rootNode.left.value).isEqualTo(3);
        assertThat(rootNode.right.value).isEqualTo(13);
    }

}