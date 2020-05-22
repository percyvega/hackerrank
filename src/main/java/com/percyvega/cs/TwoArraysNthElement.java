package com.percyvega.cs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoArraysNthElement {

    @Test
    void test1() {
        int[] array1 = new int[]{1, 3, 4};
        int[] array2 = new int[]{2, 6, 8};

        assertThat(twoArraysNthElement(array1, array2, 0)).isEqualTo(1);
        assertThat(twoArraysNthElement(array1, array2, 1)).isEqualTo(2);
        assertThat(twoArraysNthElement(array1, array2, 2)).isEqualTo(3);
        assertThat(twoArraysNthElement(array1, array2, 3)).isEqualTo(4);
        assertThat(twoArraysNthElement(array1, array2, 4)).isEqualTo(6);
        assertThat(twoArraysNthElement(array1, array2, 5)).isEqualTo(8);
    }

    int twoArraysNthElement(int[] array1, int[] array2, int n) {
        int nthElement = -1;

        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < array1.length + array2.length; i++) {
            if (i == n) {
                if (index1 < array1.length && index2 < array2.length) {
                    nthElement = Math.min(array1[index1], array2[index2]);
                } else if (index1 < array1.length) {
                    nthElement = array1[index1];
                } else {
                    nthElement = array2[index2];
                }
                break;
            }

            if (index1 < array1.length && index2 < array2.length) {
                if (array1[index1] < array2[index2]) {
                    index1++;
                } else {
                    index2++;
                }
            } else if (index1 < array1.length) {
                index1++;
            } else {
                index2++;
            }
        }

        return nthElement;
    }

}
