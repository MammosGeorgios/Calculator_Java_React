package com.example.calculator;

import com.example.calculator.utility.math.OperatorMathUtils;

public class MathTest {
    public static void main(String[] args){
//        String s1 = "10.32";
//        String s2 = "0";
//
//        String result = OperatorMathUtils.divide(s1,s2);
//        System.out.println(result);
        String testString= "15 + 3 * 0 + 15 * 3";
        OperatorMathUtils.calculateResult(testString);
    }
}
