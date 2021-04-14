package com.example.calculator.utility.math;

public class OperatorMathUtils {

    public static Double tryParseDouble(String string){
        Double number = 0.0;
        try{
            number = Double.parseDouble(string);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        return (number);
    }

    public static String add(String string1, String string2){
        Double number1 = OperatorMathUtils.tryParseDouble(string1);
        Double number2 = OperatorMathUtils.tryParseDouble(string2);

        Double result = number1 + number2;
        return(Double.toString(result));
    }

    public static String subtract(String string1, String string2){
        Double number1 = OperatorMathUtils.tryParseDouble(string1);
        Double number2 = OperatorMathUtils.tryParseDouble(string2);

        Double result = number1 - number2;
        return(Double.toString(result));
    }

    public static String multiply(String string1, String string2){
        Double number1 = OperatorMathUtils.tryParseDouble(string1);
        Double number2 = OperatorMathUtils.tryParseDouble(string2);

        Double result = number1 * number2;
        return(Double.toString(result));
    }

    public static String divide(String string1, String string2){
        Double number1 = OperatorMathUtils.tryParseDouble(string1);
        Double number2 = OperatorMathUtils.tryParseDouble(string2);
        if(number2!=0.0) {
            Double result = number1 / number2;
            return(Double.toString(result));
        }else{
            return("DIVIDED_BY_ZERO");
        }

    }

    public static String[] parseFormulaToStringArray(String formula){
        String[] result = formula.trim().split("\\s+");
        return result;
    }

    private static Integer getMultiplicationOrDivisionPosition(String[] formulaArray){
        // This method will tell us if there are more multiplication/divisions and if so, at which position. If not, it returns -1
        for (Integer i=0;i<formulaArray.length;i++) {
            if(formulaArray[i].equals("*") || formulaArray[i].equals("/")){
                return i;
            }
        }
        return -1;
    }

    private static String[] calculateMultiplicationOrDivision(String[] formulaArray, Integer operatorPosition) throws Exception {
        // this method will execute a single multiplication or division in the array
        int arrayLength = formulaArray.length;
        String[] arrayAfterCalculations= new String[formulaArray.length-2];

        // Same array until the number before the operator.
        for (int i = 0; i < operatorPosition - 1; i++) {
            arrayAfterCalculations[i] = formulaArray[i];
        }
        if(formulaArray[operatorPosition].equals("*")) {
            arrayAfterCalculations[operatorPosition - 1] = multiply(formulaArray[operatorPosition-1],formulaArray[operatorPosition+1]);
        }else if(formulaArray[operatorPosition].equals("/")) {
            String divisionResult = divide(formulaArray[operatorPosition-1],formulaArray[operatorPosition+1]);
            if(!divisionResult.equals("DIVIDED_BY_ZERO")){
                arrayAfterCalculations[operatorPosition - 1] =divisionResult;
            }else{
                return (new String[]{"DIVIDED_BY_ZERO"});
            }
        }else{
            throw new Exception("Unknown operation exception");
        }

        for (int i = operatorPosition+2; i < formulaArray.length; i++) {
            arrayAfterCalculations[i-2]= formulaArray[i];
        }
        return arrayAfterCalculations;
    }

    private static String[] calculateAllMultiplicationsAndDivisions(String[] formulaArray){
        // This method will do all calculations for multiplications and divisions

        //FIRST CHECK TO SEE IF THERE IS A SINGLE OPERATION TO BE DONE
        Integer operatorPosition = getMultiplicationOrDivisionPosition(formulaArray);
        while(operatorPosition!=-1){
            try {
                formulaArray = calculateMultiplicationOrDivision(formulaArray, operatorPosition);
            }catch(Exception e){
                System.err.println(e);
            }
            operatorPosition= getMultiplicationOrDivisionPosition(formulaArray);
        }
        return formulaArray;

    }


    public static String calculateResult(String formula){
        String[] formulaArray = parseFormulaToStringArray(formula);

        for (String string:formulaArray) {
            System.out.println(string);
        }
        System.out.println("Now i will do the multiplications");

        formulaArray = calculateAllMultiplicationsAndDivisions(formulaArray);

        System.out.println("printing the new array");
        for (String string:formulaArray) {
            System.out.println(string);
        }
        return "0";
    }
}
