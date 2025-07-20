package com.updated.rollTheDice.Utilities;

public class Utils {

    /**
     * Returns a capitalized version of the input string.
     * @param input The string to capitalize.
     * @return Capitalized string, or the original string if it is null or empty.
     */
    public static String capitalize(String input) {
        if (input == null || input.isEmpty()) return input;
        return Character.toUpperCase(input.charAt(0)) + input.substring(1);
    }

    public static void printSeparator(Integer length) {
        System.out.println("=".repeat(length));
    }
}
