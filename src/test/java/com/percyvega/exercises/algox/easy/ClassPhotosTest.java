package com.percyvega.exercises.algox.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassPhotosTest {

    // O(n log(n)) time - because fo the sorting algorithm.
    // O(1) space
    // where n is the number of elements in either array.
    public boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        redShirtHeights.sort(Comparator.naturalOrder());
        blueShirtHeights.sort(Comparator.naturalOrder());

        int compareTo = redShirtHeights.get(0).compareTo(blueShirtHeights.get(0));
        if (compareTo == 0) {
            return false;
        }
        for (int i = 1; i < redShirtHeights.size(); i++) {
            int iCompareTo = redShirtHeights.get(i).compareTo(blueShirtHeights.get(i));
            if (compareTo != iCompareTo) {
                return false;
            }
        }

        return true;
    }

    @Test
    void testClassPhotos() {
        assertThat(classPhotos(new ArrayList<>(List.of(1)), new ArrayList<>(List.of(1)))).isFalse();
        assertThat(classPhotos(new ArrayList<>(List.of(1)), new ArrayList<>(List.of(2)))).isTrue();
        assertThat(classPhotos(new ArrayList<>(List.of(2)), new ArrayList<>(List.of(1)))).isTrue();
        assertThat(classPhotos(new ArrayList<>(List.of(5, 8)), new ArrayList<>(List.of(5, 8)))).isFalse();
        assertThat(classPhotos(new ArrayList<>(List.of(5, 8)), new ArrayList<>(List.of(2, 7)))).isTrue();
        assertThat(classPhotos(new ArrayList<>(List.of(5, 8, 1, 3, 4)), new ArrayList<>(List.of(6, 9, 2, 4, 5)))).isTrue();
    }

}
