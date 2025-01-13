package com.project;

import com.project.attempt.LeetCodeAttempt;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeAttemptTest {

    @Test
    public void checkIfAParenthesesStringCanBeValidLoopTest() {

        assertTrue(LeetCodeAttempt.checkIfAParenthesesStringCanBeValidLoop("))()))", "010100"));
        assertTrue(LeetCodeAttempt.checkIfAParenthesesStringCanBeValidLoop("()()", "0000"));
        assertFalse(LeetCodeAttempt.checkIfAParenthesesStringCanBeValidLoop(")", "0"));

    }

}
