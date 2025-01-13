package com.project.attempt;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        System.out.println(checkIfAParenthesesStringCanBeValidLoop("))()))", "010100"));
        System.out.println(checkIfAParenthesesStringCanBeValidLoop("()()", "0000"));
        System.out.println(checkIfAParenthesesStringCanBeValidLoop(")", "0"));

    }

    public static boolean checkIfAParenthesesStringCanBeValidLoop(String s, String locked) {

        if (isParenthesesValid(s)) { return true; }

        for (int i = 0; i < locked.length(); i++) {

            if (locked.charAt(i) == '0') {

                StringBuilder sBuilder = new StringBuilder(s);
                sBuilder.setCharAt(i, oppositeParentheses(s.charAt(i)));

                StringBuilder lockedBuilder = new StringBuilder(locked);
                lockedBuilder.setCharAt(i, '1');

                if (checkIfAParenthesesStringCanBeValidLoop(s, lockedBuilder.toString())
                || checkIfAParenthesesStringCanBeValidLoop(sBuilder.toString(), lockedBuilder.toString())) {
                    return true;
                }

            }

        }

        return false;

    }

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
