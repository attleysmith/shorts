package com.common.interview.shorts.passwordtester;

import java.util.Objects;

import static java.lang.Character.*;
import static java.util.Arrays.stream;

public class TestTaker {

    public static final int TAIL_LENGTH = 3;
    public static final String ERROR_INDICATOR = "";

    private record Clue(String password, int upperCase, int sumOfDigits, String backwardTail) {
        public String checkString() {
            return upperCase + backwardTail + sumOfDigits;
        }
    }

    public static String password(String[] passwords, String checkString) {
        return stream(passwords)
                .filter(Objects::nonNull)
                .map(TestTaker::getClue)
                .filter(clue -> clue.checkString().equals(checkString))
                .findAny()
                .map(Clue::password)
                .orElse(ERROR_INDICATOR);
    }

    private static Clue getClue(String password) {
        int length = password.length();
        int upperCase = 0;
        int sumOfDigits = 0;
        StringBuilder backwardTail = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char character = password.charAt(i);
            if (isUpperCase(character)) {
                upperCase++;
            }
            if (isDigit(character)) {
                sumOfDigits += getNumericValue(character);
            }
            if (length - TAIL_LENGTH <= i) {
                backwardTail.insert(0, character);
            }
        }

        return new Clue(password, upperCase, sumOfDigits, backwardTail.toString());
    }
}
