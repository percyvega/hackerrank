package com.percyvega.exercises.dailyinterviewpro;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class CreateASimpleCalculator {

    @Test
    void testCalculate() {
        assertThat(calculate("2 - 1 - 3 + 5")).isEqualTo(3);
        assertThat(calculate("- 7 + ( 1 - 2 + 9 )")).isEqualTo(1);
        assertThat(calculate("( 4 - 1 ) - 3 + 2")).isEqualTo(2);
        assertThat(calculate("- ( 3 + ( 2 - 1 ) )")).isEqualTo(-4);
        assertThat(calculate("- (7 + ( 1 - 3 ) ) + ( 2 )")).isEqualTo(-3);
    }

    private int calculate(String expression) {
        String withoutParenthesis = calculateInParenthesis(expression);
        return calculateNoParenthesis(withoutParenthesis);
    }

    @Test
    void testCalculateInParenthesis() {
        assertThat(calculateInParenthesis("2 - 1 - 3 + 5")).isEqualTo("2 - 1 - 3 + 5");
        assertThat(calculateInParenthesis("- 7 + ( 1 - 2 + 9 )")).isEqualTo("- 7 + 8");
        assertThat(calculateInParenthesis("( 4 - 1 ) - 3 + 2")).isEqualTo("3 - 3 + 2");
        assertThat(calculateInParenthesis("- ( 3 + ( 2 - 1 ) ) + 1")).isEqualTo("- 4 + 1");
        assertThat(calculateInParenthesis("- (7 + ( 1 - 3 ) ) + ( 2 )")).isEqualTo("- 5 + 2");
    }

    private String calculateInParenthesis(String expression) {
        while(true) {
            int iOpen = expression.lastIndexOf("(");
            if(iOpen == -1) {
                break;
            } else {
                int iClose = expression.indexOf(")", iOpen);
                String a = expression.substring(0, iOpen);
                String b = expression.substring(iOpen + 1, iClose - 1).trim();
                String c = expression.substring(iClose + 1);

                expression = a + calculateNoParenthesis(b) + c;
            }
        }

        return expression;
    }

    @Test
    void testCalculateNoParenthesis() {
        assertThat(calculateNoParenthesis("5")).isEqualTo(5);
        assertThat(calculateNoParenthesis("- 5")).isEqualTo(-5);
        assertThat(calculateNoParenthesis("+ 5")).isEqualTo(5);
        assertThat(calculateNoParenthesis("2 + 9")).isEqualTo(11);
        assertThat(calculateNoParenthesis("- 1 - 2")).isEqualTo(-3);
        assertThat(calculateNoParenthesis("- 7 + 1 + 2")).isEqualTo(-4);
        assertThat(calculateNoParenthesis("2 - 1 - 3 + 5")).isEqualTo(3);
        assertThat(calculateNoParenthesis("- 3 + 2 - 1")).isEqualTo(-2);
    }

    private int calculateNoParenthesis(String expression) {
        int total = 0;
        String[] tokens = expression.split("\\s");
        for (int i = 0; i < tokens.length; i++) {
            String iToken = tokens[i];
            if (iToken.equals("-")) {
                String jToken = tokens[++i];
                total -= Integer.parseInt(jToken);
            } else if (iToken.equals("+")) {
                String jToken = tokens[++i];
                total += Integer.parseInt(jToken);
            } else {
                total = Integer.parseInt(iToken);
            }
        }

        return total;
    }

}
