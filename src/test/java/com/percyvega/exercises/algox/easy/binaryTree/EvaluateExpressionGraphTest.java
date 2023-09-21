package com.percyvega.exercises.algox.easy.binaryTree;

import com.percyvega.model.binarytree.BinaryTree;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EvaluateExpressionGraphTest {

    // O(n) time | O(h) - where n is the number of nodes, and h is the height of the tree.
    public int evaluateExpressionTree(BinaryTree<Integer> tree) {
        if (tree == null) {
            return 0;
        }

        Integer value = tree.value;
        int leftValue = evaluateExpressionTree(tree.left);
        int rightValue = evaluateExpressionTree(tree.right);

        if (value == -1) {
            return leftValue + rightValue;
        } else if (value == -2) {
            return leftValue - rightValue;
        } else if (value == -3) {
            return leftValue / rightValue;
        } else if (value == -4) {
            return leftValue * rightValue;
        } else {
            return value;
        }
    }

    @Test
    void testEvaluateExpressionTree() {
        BinaryTree<Integer> tree = BinaryTree.of(-1, -2, -3, -4, 2, 8, 3, 2, 3);

        assertThat(evaluateExpressionTree(tree)).isEqualTo(6);
    }
}
