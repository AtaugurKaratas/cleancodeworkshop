package com.workshop.longmethod;

import java.util.Arrays;
import static com.workshop.longmethod.Constants.*;

/**
 * Dirty: flags, deep nesting, mixed responsibilities, inconsistent returns
 */
public class PasswordValidator {

    public String validatePassword(String password) {
        if (password == null) return NULL_MESSAGE;

        if (password.length() < 8) return TOO_SHORT;

        if (BLACKLIST.contains(password)) return BLACKLISTED;

        if (missingUpperCase(password)) return NO_UPPER;

        if (missingDigit(password)) return NO_DIGIT;

        if (missingSpecial(password)) return NO_SPECIAL;

        if (hasRepeat(password)) return REPEATING_CHARS;

        if (missingEmoji(password)) return NO_EMOJI;

        return SUCCESS_MESSAGE;
    }

    private boolean missingUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) return false;
        }
        return true;
    }

    private boolean missingDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) return false;
        }
        return true;
    }

    private boolean missingSpecial(String password) {
        for (char c : SPECIAL_CHARACTERS.toCharArray()) {
            if (password.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }

    private boolean hasRepeat(String password) {
        int index = 1;
        char last = 0;
        for (char c : password.toCharArray()) {
            if (c == last) {
                index++;
            } else {
                index = 1;
                last = c;
            }
            if (index == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean missingEmoji(String password) {
        return Arrays.stream(EMOJIS.toArray(new String[0])).noneMatch(password::contains);
    }
}
