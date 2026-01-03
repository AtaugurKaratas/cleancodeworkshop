package com.workshop.longmethod;

import java.util.HashSet;
import java.util.Set;

public class Constants {

    private Constants() {}

    protected static final Set<String> BLACKLIST = new HashSet<>(Set.of("password", "12345678", "qwerty", "letmein", "welcome"));
    protected static final Set<String> EMOJIS = new HashSet<>(Set.of("👽", "😉"));

    public static final String SUCCESS_MESSAGE = "OK";
    public static final String NULL_MESSAGE = "NULL";
    public static final String TOO_SHORT = "TOO_SHORT";
    public static final String BLACKLISTED = "BLACKLISTED";
    public static final String NO_UPPER = "NO_UPPER";
    public static final String NO_DIGIT = "NO_DIGIT";
    public static final String NO_SPECIAL = "NO_SPECIAL";
    public static final String REPEATING_CHARS = "REPEATING_CHARS";
    public static final String NO_EMOJI = "NO_EMOJI";

    public static final String SPECIAL_CHARACTERS = "!@#$%^&*";
}
