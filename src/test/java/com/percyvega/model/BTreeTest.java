package com.percyvega.model;

import com.percyvega.model.BTree;
import com.percyvega.model.Node;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class BTreeTest {

    @Test
    void not_balanced() {
        Node rootNode = Node.of(4);

        rootNode.left = Node.of(2);
        rootNode.right = Node.of(7);

        rootNode.left.left = Node.of(1);
        rootNode.left.right = Node.of(3);
        rootNode.right.right = Node.of(8);

        rootNode.right.right.right = Node.of(9);

        assertThat(BTree.isBalanced(rootNode)).isFalse();
    }

    @Test
    void balanced() {
        Node rootNode = Node.of(4);

        rootNode.left = Node.of(2);
        rootNode.right = Node.of(8);

        rootNode.left.left = Node.of(1);
        rootNode.left.right = Node.of(3);
        rootNode.right.left = Node.of(7);
        rootNode.right.right = Node.of(9);

        assertThat(BTree.isBalanced(rootNode)).isTrue();
    }

}
