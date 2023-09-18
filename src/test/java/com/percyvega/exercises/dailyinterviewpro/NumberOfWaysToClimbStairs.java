package com.percyvega.exercises.dailyinterviewpro;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class NumberOfWaysToClimbStairs {

    private final Map<Integer, Long> stairsWays = new HashMap<>();

    @Test
    void testThis() {
        assertThat(getWaysToClimbCount(0)).isEqualTo(0);
        assertThat(getWaysToClimbCount(1)).isEqualTo(1);
        assertThat(getWaysToClimbCount(2)).isEqualTo(2);
        assertThat(getWaysToClimbCount(3)).isEqualTo(3);
        assertThat(getWaysToClimbCount(4)).isEqualTo(5);
        assertThat(getWaysToClimbCount(5)).isEqualTo(8);

        assertThat(getWaysToClimbCount(15)).isEqualTo(987);
        assertThat(getWaysToClimbCount(25)).isEqualTo(121_393);
        assertThat(getWaysToClimbCount(35)).isEqualTo(14_930_352);
        assertThat(getWaysToClimbCount(45)).isEqualTo(1_836_311_903);

        assertThat(getWaysToClimbCount(46)).isEqualTo(2_971_215_073L);
        assertThat(getWaysToClimbCount(47)).isEqualTo(4_807_526_976L);
    }

    private long getWaysToClimbCount(int countStairs) {
        Long cachedResult = getFromCache(countStairs);
        if (cachedResult == null) {
            cachedResult = calculateWaysToClimb(countStairs);
            storeInCache(countStairs, cachedResult);
        }

        return cachedResult;
    }

    private Long getFromCache(int countStairs) {
        return stairsWays.get(countStairs);
    }

    private void storeInCache(int countStairs, Long cachedResult) {
        stairsWays.put(countStairs, cachedResult);
    }

    private Long calculateWaysToClimb(int countStairs) {
        if (countStairs <= 3) {
            return (long) countStairs;
        } else {
            return getWaysToClimbCount(countStairs - 1) + getWaysToClimbCount(countStairs - 2);
        }
    }

}
