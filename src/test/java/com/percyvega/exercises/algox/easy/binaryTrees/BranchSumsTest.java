package com.percyvega.exercises.algox.easy.binaryTrees;

import com.percyvega.model.binarytree.BinaryTree;
import com.percyvega.model.binarytree.BinaryTreeUtils;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class BranchSumsTest {

    // O(n) time | O(n) space - where n is the number of nodes
    // Time is O(n): because we touch every single node.
    // Space is O(n): because a tree will usually have half of its nodes as leaf nodes, so n/2, which is n.
    public static List<Integer> branchSums(BinaryTree<Integer> root) {
        List<Integer> branchSums = new ArrayList<>();

        traverseTree(root, branchSums, 0);

        return branchSums;
    }

    private static void traverseTree(BinaryTree<Integer> root, List<Integer> branchSums, int sumAncestors) {
        if(root != null) {
            if (root.left == null && root.right == null) {
                branchSums.add(sumAncestors + root.value);
            } else {
                traverseTree(root.left, branchSums, sumAncestors + root.value);
                traverseTree(root.right, branchSums, sumAncestors + root.value);
            }
        }
    }

    @Test
    void testBranchSums() {
        List<Integer> branchSums = branchSums(BinaryTreeUtils.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        for(int i : branchSums) {
            log.info(i);
        }
    }

}
