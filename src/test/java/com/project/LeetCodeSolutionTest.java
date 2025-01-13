package com.project;

import com.project.solution.LeetCodeSolution;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeSolutionTest {

    @Test
    public void canBeValidTest() {

        assertTrue(LeetCodeSolution.canBeValid("))()))", "010100"));
        assertTrue(LeetCodeSolution.canBeValid("()()", "0000"));
        assertFalse(LeetCodeSolution.canBeValid(")", "0"));

    }

}
