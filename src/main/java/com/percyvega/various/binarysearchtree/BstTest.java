package com.percyvega.various.binarysearchtree;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class BstTest {

    @Test
    void not_balanced() {
        BinarySearchTree tree = new BinarySearchTree(new Node(4));

        tree.root.left = new Node(2);
        tree.root.right = new Node(7);

        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.right = new Node(8);

        tree.root.right.right.right = new Node(9);

        assertThat(tree.isBalanced()).isFalse();
    }

    @Test
    void balanced() {
        BinarySearchTree tree = new BinarySearchTree(new Node(4));

        tree.root.left = new Node(2);
        tree.root.right = new Node(8);

        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(9);

        assertThat(tree.isBalanced()).isTrue();
    }

}
