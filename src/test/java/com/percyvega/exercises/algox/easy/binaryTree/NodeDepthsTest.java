package com.percyvega.exercises.algox.easy.binaryTree;

import com.percyvega.model.binarytree.BinaryTree;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NodeDepthsTest {

    // O(n) time | O(h) space - where n is the number of nodes and h is the height of the tree
    // Space is O(h) because the maximum number of elements we'll store in the memory call stack will be the height
    public static int nodeDepths(BinaryTree<Integer> root) {
        return getTreeNodeDepths(root, 0);
    }

    static int getTreeNodeDepths(BinaryTree<Integer> root, int rootDepth) {
        int nodeDepths = 0;

        if (root != null) {
            nodeDepths += rootDepth;
            nodeDepths += getTreeNodeDepths(root.left, rootDepth + 1);
            nodeDepths += getTreeNodeDepths(root.right, rootDepth + 1);
        }

        return nodeDepths;
    }

    @Test
    void testNodeDepths() {
        BinaryTree<Integer> tree = BinaryTree.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertThat(nodeDepths(tree)).isEqualTo(16);
    }

}
