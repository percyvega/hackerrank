package com.percyvega.nonhackerrank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
 */
class BinaryGap {

    @Test
    void testBinaryGap() {
        assertThat(binaryGap(1)).isEqualTo(0);
        assertThat(binaryGap(2)).isEqualTo(0);
        assertThat(binaryGap(3)).isEqualTo(0);
        assertThat(binaryGap(4)).isEqualTo(0);
        assertThat(binaryGap(5)).isEqualTo(1);
        assertThat(binaryGap(8)).isEqualTo(0);
        assertThat(binaryGap(9)).isEqualTo(2);
        assertThat(binaryGap(16)).isEqualTo(0);
        assertThat(binaryGap(17)).isEqualTo(3);
        assertThat(binaryGap(529)).isEqualTo(4);
        assertThat(binaryGap(Integer.MAX_VALUE)).isEqualTo(0);
    }

    private int binaryGap(int N) {
        String binaryString = getBinaryString(N);
        return getBinaryGap(binaryString);
    }

    @Test
    void testGetBinaryGap() {
        assertThat(getBinaryGap("1")).isEqualTo(0);
        assertThat(getBinaryGap("10")).isEqualTo(0);
        assertThat(getBinaryGap("11")).isEqualTo(0);
        assertThat(getBinaryGap("100")).isEqualTo(0);
        assertThat(getBinaryGap("101")).isEqualTo(1);
        assertThat(getBinaryGap("1000")).isEqualTo(0);
        assertThat(getBinaryGap("1001")).isEqualTo(2);
        assertThat(getBinaryGap("10000")).isEqualTo(0);
        assertThat(getBinaryGap("10001")).isEqualTo(3);
        assertThat(getBinaryGap("1111111111111111111111111111111")).isEqualTo(0);
    }

    private int getBinaryGap(String binaryString) {
        int binaryGap = 0;
        int posLastOne = 0;

        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                int currentBinaryGap = i - posLastOne - 1;

                if (currentBinaryGap > binaryGap) {
                    binaryGap = currentBinaryGap;
                }

                posLastOne = i;
            }
        }

        return binaryGap;
    }

    @Test
    void testGetBinaryString() {
        assertThat(getBinaryString(1)).isEqualTo("1");
        assertThat(getBinaryString(2)).isEqualTo("10");
        assertThat(getBinaryString(3)).isEqualTo("11");
        assertThat(getBinaryString(4)).isEqualTo("100");
        assertThat(getBinaryString(5)).isEqualTo("101");
        assertThat(getBinaryString(8)).isEqualTo("1000");
        assertThat(getBinaryString(9)).isEqualTo("1001");
        assertThat(getBinaryString(16)).isEqualTo("10000");
        assertThat(getBinaryString(17)).isEqualTo("10001");
        assertThat(getBinaryString(Integer.MAX_VALUE)).isEqualTo("1111111111111111111111111111111");
    }

    private String getBinaryString(int n) {
        StringBuilder binaryString = new StringBuilder();

        int binaryDigitsCount = getBinaryDigitsCount(n);

        for (int i = binaryDigitsCount; i > 0; i--) {
            int pow = (int) Math.pow(2, i - 1);

            if (n >= pow) {
                n -= pow;
                binaryString.append("1");
            } else {
                binaryString.append("0");
            }
        }

        return binaryString.toString();
    }

    @Test
    void testGetBinaryDigitsCount() {
        assertThat(getBinaryDigitsCount(1)).isEqualTo(1);
        assertThat(getBinaryDigitsCount(2)).isEqualTo(2);
        assertThat(getBinaryDigitsCount(3)).isEqualTo(2);
        assertThat(getBinaryDigitsCount(4)).isEqualTo(3);
        assertThat(getBinaryDigitsCount(5)).isEqualTo(3);
        assertThat(getBinaryDigitsCount(8)).isEqualTo(4);
        assertThat(getBinaryDigitsCount(9)).isEqualTo(4);
        assertThat(getBinaryDigitsCount(16)).isEqualTo(5);
        assertThat(getBinaryDigitsCount(17)).isEqualTo(5);
        assertThat(getBinaryDigitsCount(Integer.MAX_VALUE)).isEqualTo(31);
    }

    private int getBinaryDigitsCount(int n) {
        int binaryDigitsCount = 1;
        int i = 1;
        while (true) {
            if (i >= n) {
                return binaryDigitsCount;
            }

            ++binaryDigitsCount;
            i = (2 * (i + 1)) - 1;
        }
    }

}
