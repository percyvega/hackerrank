package com.percyvega.exercises.dailyinterviewpro;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FallingDominoes {

    @Test
    void isValidTest() {
        assertThat(getFinalPosition(".")).isEqualTo(".");
        assertThat(getFinalPosition("L")).isEqualTo("L");
        assertThat(getFinalPosition("R")).isEqualTo("R");

        assertThat(getFinalPosition("L.")).isEqualTo("L.");
        assertThat(getFinalPosition(".R")).isEqualTo(".R");
        assertThat(getFinalPosition(".L")).isEqualTo("LL");
        assertThat(getFinalPosition("R.")).isEqualTo("RR");

        assertThat(getFinalPosition("L...")).isEqualTo("L...");
        assertThat(getFinalPosition("...R")).isEqualTo("...R");
        assertThat(getFinalPosition("R...")).isEqualTo("RRRR");
        assertThat(getFinalPosition("...L")).isEqualTo("LLLL");

        assertThat(getFinalPosition(".R..")).isEqualTo(".RRR");
        assertThat(getFinalPosition(".L..")).isEqualTo("LL..");
        assertThat(getFinalPosition("..R.")).isEqualTo("..RR");
        assertThat(getFinalPosition("..L.")).isEqualTo("LLL.");

        assertThat(getFinalPosition("L..L")).isEqualTo("LLLL");
        assertThat(getFinalPosition("...R..R")).isEqualTo("...RRRR");
        assertThat(getFinalPosition("...R..R..")).isEqualTo("...RRRRRR");
        assertThat(getFinalPosition("R..R")).isEqualTo("RRRR");

        assertThat(getFinalPosition("..R..L..")).isEqualTo("..RRLL..");
        assertThat(getFinalPosition("..R...L..")).isEqualTo("..RR.LL..");
        assertThat(getFinalPosition("..R...LR.")).isEqualTo("..RR.LLRR");
        assertThat(getFinalPosition("..R...LR..L..")).isEqualTo("..RR.LLRRLL..");
        assertThat(getFinalPosition("R...L")).isEqualTo("RR.LL");
        assertThat(getFinalPosition(".L.R.")).isEqualTo("LL.RR");
        assertThat(getFinalPosition("R.L")).isEqualTo("R.L");

        assertThat(getFinalPosition("..R...L..R.")).isEqualTo("..RR.LL..RR");
    }

    String getFinalPosition(String positionStr) {
        char[] position = positionStr.toCharArray();

        int currentIndex = 0;

        firstWhile:
        while (currentIndex < position.length) {
            switch (position[currentIndex]) {
                case '.':
                    break;
                case 'L':
                    position = makeLToTheLeftOf(currentIndex, new String(position)).toCharArray();
                    break;
                case 'R':
                    int i = currentIndex;

                    while (++i < position.length) {
                        if (position[i] == '.') {
                            position[i] = 'R';
                        } else if (position[i] == 'R') {
                            currentIndex = i - 1;
                        } else if (position[i] == 'L') {
                            int dotsChanged = i - currentIndex - 1;
                            if (dotsChanged == 0) {
                                break;
                            } else {
                                boolean isEven = dotsChanged % 2 == 0;
                                if (isEven) {
                                    for (int j = i - dotsChanged / 2; position[j] != 'L'; j++) {
                                        position[j] = 'L';
                                    }
                                    currentIndex = i + 1;
                                    continue firstWhile;
                                } else {
                                    position[i - dotsChanged / 2 - 1] = '.';
                                    for (int j = i - dotsChanged / 2; position[j] != 'L'; j++) {
                                        position[j] = 'L';
                                    }
                                    currentIndex = i + 1;
                                    continue firstWhile;
                                }
                            }
                        }
                    }
                    break;
            }
            ++currentIndex;
        }

        return new String(position);
    }

    @Test
    void makeLToTheLeftOfTest() {
        assertThat(makeLToTheLeftOf(0, "...")).isEqualTo("...");
        assertThat(makeLToTheLeftOf(1, "...")).isEqualTo("L..");
        assertThat(makeLToTheLeftOf(2, "...")).isEqualTo("LL.");
        assertThat(makeLToTheLeftOf(3, "...")).isEqualTo("LLL");
        assertThat(makeLToTheLeftOf(3, ".L.")).isEqualTo(".LL");
        assertThat(makeLToTheLeftOf(3, ".R.")).isEqualTo(".RL");
    }

    private String makeLToTheLeftOf(int currentIndex, String positionStr) {
        char[] position = positionStr.toCharArray();

        for (int i = currentIndex - 1; i >= 0 && position[i] == '.'; i--) {
            position[i] = 'L';
        }

        return new String(position);
    }

}
