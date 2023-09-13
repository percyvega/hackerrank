package com.percyvega.exercises.algox.easy.binaryTrees;

import com.percyvega.model.binarytree.BinaryTree;
import com.percyvega.model.binarytree.BinaryTreePrinterUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindClosestValueInBstTest {

    // Average: O(log(n)) time | O(1) space - where n is the number of nodes
    // Worst: O(n) time | O(1) space
    public static int findClosestValueInBst(BinaryTree<Integer> tree, int target) {
        int closestValue = tree.value;

        do {
            if (Math.abs(tree.value - target) < Math.abs(closestValue - target)) {
                closestValue = tree.value;
            }

            if (target < tree.value) {
                tree = tree.left;
            } else {
                tree = tree.right;
            }
        } while (tree != null);

        return closestValue;
    }

    @Test
    void testFindClosestValueInBst() {
        BinaryTree<Integer> tree = BinaryTree.of(
                10,
                5, 15,
                2, 9, 13, 22
        );
        tree.right.left.right(14);
        tree.left.left.right(3);
        tree.left.left.left(
                BinaryTree.of(
                        1,
                        BinaryTree.of(-51, -403),
                        BinaryTree.of(1,
                                null,
                                BinaryTree.of(
                                        1,
                                        null,
                                        BinaryTree.of(1, null, 1)
                                )
                        )
                )
        );

        assertThat(findClosestValueInBst(tree, 12)).isEqualTo(13);
        assertThat(findClosestValueInBst(tree, -70)).isEqualTo(-51);
        assertThat(findClosestValueInBst(tree, -1)).isEqualTo(1);
    }

}
