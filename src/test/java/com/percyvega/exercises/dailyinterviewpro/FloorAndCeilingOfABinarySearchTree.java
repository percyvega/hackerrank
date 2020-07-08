package com.percyvega.exercises.dailyinterviewpro;

import com.percyvega.model.binarytree.BinaryTreeNode;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class FloorAndCeilingOfABinarySearchTree {

    @Test
    void test_isBetween() {
        assertThat(isBetween(0, 0, 0)).isTrue();
        assertThat(isBetween(0, 1, 1)).isTrue();
        assertThat(isBetween(0, 1, 0)).isTrue();
        assertThat(isBetween(0, 2, 0)).isTrue();
        assertThat(isBetween(0, 2, 1)).isTrue();
        assertThat(isBetween(0, 2, 2)).isTrue();

        assertThat(isBetween(0, 0, 0)).isTrue();
        assertThat(isBetween(1, 0, 1)).isTrue();
        assertThat(isBetween(1, 0, 0)).isTrue();
        assertThat(isBetween(2, 0, 0)).isTrue();
        assertThat(isBetween(2, 0, 1)).isTrue();
        assertThat(isBetween(2, 0, 2)).isTrue();

        assertThat(isBetween(0, 0, -1)).isFalse();
        assertThat(isBetween(1, 0, 2)).isFalse();
        assertThat(isBetween(1, 0, -1)).isFalse();
        assertThat(isBetween(2, 0, 3)).isFalse();
        assertThat(isBetween(2, 0, 3)).isFalse();
        assertThat(isBetween(2, 0, 3)).isFalse();
    }

    @Test
    void testThis1() {
        assertThat(findCeilingAndFloor(BinaryTreeNode.of(8), 8)).containsExactly(null, 8);
    }

    @Test
    void testThis2() {
        assertThat(findCeilingAndFloor(BinaryTreeNode.of(8, 4), 10)).containsExactly(8, null);
    }

    @Test
    void testThis3() {
        assertThat(findCeilingAndFloor(BinaryTreeNode.of(8, 4), 8)).containsExactly(null, 8);
    }

    @Test
    void testThis4() {
        assertThat(findCeilingAndFloor(BinaryTreeNode.of(8, 4), 6)).containsExactly(8, 4);
    }

    @Test
    void testThis5() {
        assertThat(findCeilingAndFloor(BinaryTreeNode.of(8, 4), 4)).containsExactly(8, 4);
    }

    @Test
    void testThis6() {
        assertThat(findCeilingAndFloor(BinaryTreeNode.of(8, 4), 2)).containsExactly(4, null);
    }

    @Test
    void testThis7() {
        assertThat(findCeilingAndFloor(BinaryTreeNode.of(8, 4, 12, 2, 6, 10, 14), 5)).containsExactly(4, 6);
    }

    @Test
    void testThis8() {
        BinaryTreeNode<Integer> rootNode = BinaryTreeNode.of(
                8,
                2, 12,
                1, 4, 10, 14,
                null, null, 3, 7, null, null, null, null,
                null, null, null, null, null, null, 6);
        assertThat(findCeilingAndFloor(rootNode, 5)).containsExactly(6, null);
    }

    private List<Integer> findCeilingAndFloor(BinaryTreeNode<Integer> rootNode, int target) {
        BinaryTreeNode<Integer> previousNode = null;
        BinaryTreeNode<Integer> currentNode = rootNode;

        while (true) {
            Integer currentValue = currentNode.value;
            if (target == currentValue) {
                break;
            } else if (target < currentValue) {
                if (currentNode.left == null) {
                    if (previousNode == null || !isBetween(currentNode.value, previousNode.value, target)) {
                        previousNode = currentNode;
                        currentNode = null;
                    }
                    break;
                } else {
                    previousNode = currentNode;
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    if (previousNode == null || !isBetween(currentNode.value, previousNode.value, target)) {
                        previousNode = currentNode;
                        currentNode = null;
                    }
                    break;
                } else {
                    previousNode = currentNode;
                    currentNode = currentNode.right;
                }
            }
        }

        return getCeilingAndFloorList(previousNode, currentNode);
    }

    private List<Integer> getCeilingAndFloorList(BinaryTreeNode<Integer> previousNode, BinaryTreeNode<Integer> currentNode) {
        if (previousNode == null) {
            return Arrays.asList(null, currentNode.value);
        } else if (currentNode == null) {
            return Arrays.asList(previousNode.value, null);
        }

        return Arrays.asList(previousNode.value, currentNode.value);
    }

    private boolean isBetween(Integer x, Integer y, Integer target) {
        if ((x <= target && target <= y) ||
                (y <= target && target <= x)) {
            return true;
        } else {
            return false;
        }
    }

}
