package com.project.attempt;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        System.out.println(checkIfAParenthesesStringCanBeValidLoop("))()))", "010100"));
        System.out.println(checkIfAParenthesesStringCanBeValidLoop("()()", "0000"));
        System.out.println(checkIfAParenthesesStringCanBeValidLoop(")", "0"));

    }

    // We will be using recursion in order to test all possible variations of
    // string s and see if any of them can result in a valid parentheses string.
    public static boolean checkIfAParenthesesStringCanBeValidLoop(String s, String locked) {

        // We check at the beginning of the method to see
        // if the string is already a valid parentheses string or not.
        if (isParenthesesValid(s)) { return true; }

        // Since both string s and string locked are the same length,
        // we can iterate through both of them with the same loop.
        for (int i = 0; i < locked.length(); i++) {

            // As per the challenge instructions, if locked[i] == '0', then s[i] can be changed.
            // Otherwise, we ignore it when locked[i] == '1' as the value of s[i] is completely fixed.
            if (locked.charAt(i) == '0') {

                // We create a second string that has the opposite parentheses at s[i]
                // in order to help test out both parentheses possibilities at that index.
                StringBuilder sBuilder = new StringBuilder(s);
                sBuilder.setCharAt(i, oppositeParentheses(s.charAt(i)));

                // Since we will be testing both possible parentheses at s[i] and be performing recursion, we
                // set locked[i] to '1' so that further calls of this method won't repeat any behavior at this index.
                StringBuilder lockedBuilder = new StringBuilder(locked);
                lockedBuilder.setCharAt(i, '1');

                // We perform recursion here with both possible parentheses being used at the current index,
                // with further calls of this method checking for other indexes i where locked[i] == '0' and
                // hence testing both parentheses at those indexes as well. If at -any- point, a valid parentheses
                // string is obtained by changing the parentheses at some index s[i] where locked[i] == '0', then the
                // method will return true which will float back up to the very first call and return true there.
                if (checkIfAParenthesesStringCanBeValidLoop(s, lockedBuilder.toString())
                        || checkIfAParenthesesStringCanBeValidLoop(sBuilder.toString(), lockedBuilder.toString())) {
                    return true;
                }

            }

        }

        return false;

    }

    // A helper method that checks if the string is a valid parentheses string.
    // Taking the specifications of the challenge into account, it is surmised that
    // iterating through any valid parenthesis string should never result in the number of
    // ')'s surpassing the number of '('s at any point. (assuming it's being iterated left-to-right)
    private static boolean isParenthesesValid(String s) {

        int leftParentheses = 0;
        int rightParentheses = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                leftParentheses++;
            } else if (s.charAt(i) == ')') {
                rightParentheses++;
            }

            if (leftParentheses < rightParentheses) { return false; }

        }

        return leftParentheses == rightParentheses;

    }

    // A simple helper method to switch a parentheses character to the opposite one.
    // Returns '0' is an invalid character is put through the method.
    private static char oppositeParentheses(char c) {

        if (c == '(') {
            return ')';
        } else if (c == ')') {
            return '(';
        }

        System.out.println("Something went wrong!");

        return '0';

    }

}
