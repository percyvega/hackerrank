package com.percyvega.exercises.algox.easy.binaryTrees;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindClosestValueInBstTest {

    // Average: O(log(n)) time | O(1) space - where n is the number of nodes
    // Worst: O(n) time | O(1) space
    public static int findClosestValueInBst(BST tree, int target) {
        int closestValue = tree.value;

        do {
            if (Math.abs(tree.value - target) < Math.abs(closestValue - target)) {
                closestValue = tree.value;
            }

            if (tree.value > target) {
                tree = tree.left;
            } else {
                tree = tree.right;
            }
        } while (tree != null);

        return closestValue;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST(int value, BST left, BST right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    @Test
    void testFindClosestValueInBst() {
        BST tree = new BST(10,
                new BST(
                        5,
                        new BST(
                                2,
                                new BST(1),
                                null
                        ),
                        new BST(5)
                ),
                new BST(
                        15,
                        new BST(
                                13,
                                null,
                                new BST(14)
                        ),
                        new BST(22)
                )
        );
        int target = 12;
        assertThat(findClosestValueInBst(tree, target)).isEqualTo(13);

        tree = new BST(100,
                new BST(
                        5,
                        new BST(
                                2,
                                new BST(
                                        1,
                                        new BST(
                                                -51,
                                                new BST(-403),
                                                null
                                        ),
                                        new BST(
                                                1,
                                                null,
                                                new BST(
                                                        1,
                                                        null,
                                                        new BST(
                                                                1,
                                                                null,
                                                                new BST(1)
                                                        )
                                                )
                                        )
                                ),
                                new BST(3)
                        ),
                        new BST(
                                15
                        )
                ),
                new BST(
                        15,
                        new BST(
                                13,
                                null,
                                new BST(14)
                        ),
                        new BST(22)
                )
        );
        target = -70;
        assertThat(findClosestValueInBst(tree, target)).isEqualTo(-51);

        target = -1;
        assertThat(findClosestValueInBst(tree, target)).isEqualTo(1);
    }

}
