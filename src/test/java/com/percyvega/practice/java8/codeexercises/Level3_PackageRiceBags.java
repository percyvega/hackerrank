package com.percyvega.practice.java8.codeexercises;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Provided that you have a given number of small rice bags (1 kilo each) and big rice bags (5 kilo each),
 * write a method that returns the minimum number of small bags necessary to package goal kilos of rice.
 * Return -1 if it is not possible to package the required rice amount with the bags provided.
 */
public class Level3_PackageRiceBags {

    @Test
    void getCount5KiloBags() {
        assertThat(getCount5KiloBags(19)).isEqualTo(3);
        assertThat(getCount5KiloBags(20)).isEqualTo(4);
        assertThat(getCount5KiloBags(21)).isEqualTo(4);
        assertThat(getCount5KiloBags(22)).isEqualTo(4);
        assertThat(getCount5KiloBags(23)).isEqualTo(4);
        assertThat(getCount5KiloBags(24)).isEqualTo(4);
        assertThat(getCount5KiloBags(25)).isEqualTo(5);
    }

    @Test
    void getMinimumNumberOfSmallBagsNecessary() {
        assertThat(getMinimumNumberOfSmallBagsNecessary(8, 3, 3)).isEqualTo(3);
        assertThat(getMinimumNumberOfSmallBagsNecessary(8, 3, 11)).isEqualTo(1);
        assertThat(getMinimumNumberOfSmallBagsNecessary(8, 3, 18)).isEqualTo(3);
        assertThat(getMinimumNumberOfSmallBagsNecessary(8, 3, 22)).isEqualTo(7);

        assertThat(getMinimumNumberOfSmallBagsNecessary(8, 3, 42)).isEqualTo(-1);
        assertThat(getMinimumNumberOfSmallBagsNecessary(1, 3, 2)).isEqualTo(-1);
        assertThat(getMinimumNumberOfSmallBagsNecessary(1, 3, 8)).isEqualTo(-1);
    }

    private int getMinimumNumberOfSmallBagsNecessary(int smallRiseBags, int bigRiceBags, int goalKilos) {
        int count5KiloBagsRequired = getCount5KiloBags(goalKilos);

        int count1KiloBagsRequired;
        if(count5KiloBagsRequired <= bigRiceBags) {
            count1KiloBagsRequired = goalKilos - (count5KiloBagsRequired * 5);
        } else {
            count1KiloBagsRequired = goalKilos - (bigRiceBags * 5);
        }

        if(count1KiloBagsRequired > smallRiseBags) {
            return -1;
        } else {
            return count1KiloBagsRequired;
        }
    }

    private int getCount5KiloBags(int goalKilos) {
        return goalKilos / 5;
    }

}
