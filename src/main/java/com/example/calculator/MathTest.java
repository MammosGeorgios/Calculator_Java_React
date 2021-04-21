package com.example.calculator;

import com.example.calculator.utility.math.OperatorMathUtils;

public class MathTest {
    public static void main(String[] args){
//        String s1 = "10.32";
//        String s2 = "0";
//
//        String result = OperatorMathUtils.divide(s1,s2);
//        System.out.println(result);
        String testString= "15 * 3 - 15 + 5 * 3 * 10 - 150 + 3";
        String result;
        try {
            result = OperatorMathUtils.calculateResult(testString);
            System.out.println("The expression we are trying to calculate is: " + testString +"\nThe result is: " + result);
        }catch(Exception e){
            System.err.println(e.toString());
        }


    }
}
