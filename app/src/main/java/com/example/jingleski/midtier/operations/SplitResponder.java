package com.example.jingleski.midtier.operations;

import java.util.Random;

import com.example.jingleski.midtier.configuration.Configuration;

public class SplitResponder{
    
    /**
    * @param operationIdentifier e.g.: "+" or "-"
    * @return return an int[] containing the factors x,y of the addition or the subtraction
    */
    private static int[] getOperationNumbers(String operationIdentifier){
        
        int[] operationNumbers = new int[2];
        int operationNumber_1 = new Random().nextInt(Configuration.MAX_NUMBER_ADDITION+1);
        int operationNumber_2;
        
        switch(operationIdentifier) {
            case(Configuration.PLUS_SIGN):
                //maximum number is number 1 so that number to guess cannot be lower than 0
                operationNumber_2 = new Random().nextInt(operationNumber_1 +1);
                break;
                
            case(Configuration.MINUS_SIGN):
                //here, number 2 is also max number 1 which can only be true if number 2 is on the left side of the subtraction
                //e.g.: number 2 - x = number 1 and NOT x - number2 = number1
                //      20 - 0 = 20         and NOT  x - 20 = 20...
                operationNumber_2 = new Random().nextInt(operationNumber_1+1);
                
                break;
                
            default: operationNumber_2 = 0;
        }
        
        operationNumbers[0] = operationNumber_1;
        operationNumbers[1] = operationNumber_2;
        return operationNumbers;

    }
    
    /**
     * handle a splitrequest/response but with only giving the operationidentifier
     * @param operationIdentifier: identifies the operation: e.g. "+" for addition and "-" for subtraction
     */
    public static OperationResponse handleResponse(String operationIdentifier) {
        
        
        return new SplitResponse(0,new int[]{0,0},false,false);
    }
    
}
