package com.percyvega.exercises.dailyinterviewpro;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class WordSearch {

    @Test
    void test1() {
        char[][] matrix = new char[][]{
                {'A', 'N', 'O', 'B'},
                {'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'B'},
                {'M', 'A', 'S', 'S'}};

        String target = "FOAM";

        assertThat(isWordInMatrix(matrix, target)).isTrue();
    }

    @Test
    void test2() {
        char[][] matrix = new char[][]{
                {'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'}};

        String target = "FOAM";

        assertThat(isWordInMatrix(matrix, target)).isFalse();
    }

    @Test
    void test3() {
        char[][] matrix = new char[][]{
                {'A', 'N', 'O', 'B'},
                {'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'T'},
                {'M', 'A', 'S', 'S'}};

        String target = "NOT";

        assertThat(isWordInMatrix(matrix, target)).isTrue();
    }

    private boolean isWordInMatrix(char[][] matrix, String targetString) {
        char[] target = targetString.toCharArray();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (isVerticalWordFoundAt(matrix, i, j, target) || isHorizontalWordFoundAt(matrix, i, j, target)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isVerticalWordFoundAt(char[][] matrix, int i, int j, char[] target) {
        int iTarget = 0;
        for (int i2 = i; i2 < matrix.length && iTarget < target.length; i2++) {
            if (matrix[i2][j] != target[iTarget++]) {
                return false;
            }
        }
        return iTarget == target.length;
    }

    private boolean isHorizontalWordFoundAt(char[][] matrix, int i, int j, char[] target) {
        int iTarget = 0;
        for (int j2 = j; j2 < matrix[i].length && iTarget < target.length; j2++) {
            if (matrix[i][j2] != target[iTarget++]) {
                return false;
            }
        }
        return iTarget == target.length;
    }

}
