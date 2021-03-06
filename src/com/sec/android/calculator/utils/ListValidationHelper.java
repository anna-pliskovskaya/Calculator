package com.sec.android.calculator.utils;

import com.sec.android.calculator.CalculateResults;

import java.util.List;

public class ListValidationHelper {

    public static boolean isListValid(List<String> list) {
        return isBracketsCountValid(list) && isInputListCorrect(list);
    }

    private static boolean isInputListCorrect(List<String> list) {
        int count = 0;
        for (String token : CalculateResults.shuntingYardAlgorithm(list)) {
            if (!CalculateResults.isOperator(token)) {
                count++;
            } else {
                count--;
            }
            if (token.contains("sin") || token.contains("cos")) {
                count++;
            }
        }
        return count == 1;
    }

    private static boolean isBracketsCountValid(List<String> list) {
        return countBrackets(list) == 0;
    }

    private static int countBrackets(List<String> list) {
        int count = 0;

        for (String temp : list) {
            if (temp.contains("(")) {
                count++;
            } else if (temp.contains(")")) {
                count--;
            }
        }
        return count;
    }
}
