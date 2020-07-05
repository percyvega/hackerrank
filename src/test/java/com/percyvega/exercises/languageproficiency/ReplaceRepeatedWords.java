package com.percyvega.exercises.languageproficiency;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class ReplaceRepeatedWords {

    @Test
    void test1() {
        String input = "is is this the best best best site in inthe world ever ever";
        String expected = "is this the best site in inthe world ever";

        assertThat(replaceRepeatedWords(input)).isEqualTo(expected);
    }

    String replaceRepeatedWords(String input) {
        String regex = "(\\b[a-z]+\\b)(\\b\\s+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Matcher m = p.matcher(input);

        while (m.find()) {
            input = input.replaceAll(m.group(), m.group(1));
        }

        return input;
    }
}

