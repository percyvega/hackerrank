package com.percyvega.exercises.algox.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransposeMatrixTest {

    // O(h * w) time | O(h * w) space - where h is the height of the matrix and w is the width
    public static int[][] transposeMatrix(int[][] matrix) {
        int[][] transposed = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        return transposed;
    }

    @Test
    void testTransposeMatrix() {
        int[][] matrix = new int[][]{
                {1, 2}
        };
        int[][] transposed = new int[][]{
                {1},
                {2}
        };
        assertThat(transposeMatrix(matrix)).isEqualTo(transposed);

        matrix = new int[][]{
                {1, 2},
                {3, 4},
                {5, 6}
        };
        transposed = new int[][]{
                {1, 3, 5},
                {2, 4, 6}
        };

        assertThat(transposeMatrix(matrix)).isEqualTo(transposed);

        matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        transposed = new int[][]{
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        assertThat(transposeMatrix(matrix)).isEqualTo(transposed);
    }
}
