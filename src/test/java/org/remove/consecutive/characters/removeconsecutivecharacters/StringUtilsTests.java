package org.remove.consecutive.characters.removeconsecutivecharacters;

import org.junit.jupiter.api.Test;
import org.remove.consecutive.characters.removeconsecutivecharacters.utils.StringUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StringUtilsTests {

    @Test
    void removeConsecutiveTest() {
        String input = "aabbbacd";
        String expected = "cd";
        assertEquals(expected, StringUtils.removeConsecutive(input));

        input = "aabcccbbad";
        expected = "d";
        assertEquals(expected, StringUtils.removeConsecutive(input));
    }

    @Test
    void replaceConsecutive() {
        String input = "aabbbcdddeffggggh";
        String expected = "cceeh";
        assertEquals(expected, StringUtils.replaceConsecutive(input));

        input = "abcccbad";
        expected = "d";
        assertEquals(expected, StringUtils.replaceConsecutive(input));
    }

}
