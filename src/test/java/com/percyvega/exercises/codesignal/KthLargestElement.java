package com.percyvega.exercises.codesignal;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Find the kth largest element in an unsorted array. This will be the kth largest element in sorted order, not the kth distinct element.
 */
public class KthLargestElement {

    @Test
    void kthLargestElementTest() {
        assertThat(kthLargestElement(new int[]{7, 6, 5, 4, 3, 2, 1}, 2)).isEqualTo(6);
        assertThat(kthLargestElement(new int[]{99, 99}, 1)).isEqualTo(99);
        assertThat(kthLargestElement(new int[]{1}, 1)).isEqualTo(1);
        assertThat(kthLargestElement(new int[]{2, 1}, 1)).isEqualTo(2);
        assertThat(kthLargestElement(new int[]{-1, 2, 0}, 2)).isEqualTo(0);
        assertThat(kthLargestElement(new int[]{-1, 2, 0}, 3)).isEqualTo(-1);
        assertThat(kthLargestElement(new int[]{3, 1, 2, 4}, 2)).isEqualTo(3);
        assertThat(kthLargestElement(new int[]{3, 2, 1, 5, 6, 4}, 2)).isEqualTo(5);
        assertThat(kthLargestElement(new int[]{5, 2, 4, 1, 3, 6, 0}, 2)).isEqualTo(5);
        assertThat(kthLargestElement(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3}, 8)).isEqualTo(3);
        assertThat(kthLargestElement(new int[]{3, 3, 3, 3, 4, 3, 3, 3, 3}, 1)).isEqualTo(4);
        assertThat(kthLargestElement(new int[]{3, 3, 3, 3, 4, 3, 3, 3, 3}, 5)).isEqualTo(3);
        assertThat(kthLargestElement(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)).isEqualTo(4);
        assertThat(kthLargestElement(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6}, 1)).isEqualTo(11);
        assertThat(kthLargestElement(new int[]{2, 1}, 2)).isEqualTo(1);
        assertThat(kthLargestElement(new int[]{-1, -1}, 2)).isEqualTo(-1);
    }

    int kthLargestElement(int[] nums, int k) {
        List<Integer> integerList = IntStream.of(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        return integerList.get(k - 1);
    }

}
