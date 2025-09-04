package com.workshop.longmethod;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {
    @ParameterizedTest
    @CsvSource({
        "Abcdef1!, OK",
        "abcdef1!, NO_UPPER",
        "ABCDEFGH!, NO_DIGIT",
        "Abcdefgh1, NO_SPECIAL",
        "'', TOO_SHORT",
        "password, BLACKLISTED",
        "AAAbcdef1!, REPEATING_CHARS"
    })
    void validates(String input, String expected){
        String result = new PasswordValidator().validate(input);
        assertEquals(expected, result);
    }
}
