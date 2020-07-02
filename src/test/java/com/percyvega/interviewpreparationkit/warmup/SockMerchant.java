package com.percyvega.interviewpreparationkit.warmup;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class SockMerchant {

    @Test
    void test1() {
        int[] inputSingles = new int[]{10, 20, 40, 20, 10, 40, 10, 30, 50, 90, 10, 20, 90};
        int expectedPairs = 5;

        assertThat(sockMerchant(inputSingles)).isEqualTo(expectedPairs);
    }

    static int sockMerchant(int[] ar) {
        List<Integer> alreadyPaired = new ArrayList<>();
        int countPaired = 0;

        for (int i = 0; i < ar.length - 1; i++) {
            if (!alreadyPaired.contains(i)) {
                for (int j = i + 1; j < ar.length; j++) {
                    if (!alreadyPaired.contains(j)) {
                        if (ar[i] == ar[j]) {
                            alreadyPaired.add(i);
                            alreadyPaired.add(j);

                            countPaired++;
                            break;
                        }
                    }
                }
            }
        }

        return countPaired;
    }

}
