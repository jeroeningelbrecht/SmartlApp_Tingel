package com.example.jingleski.midtier.operations;

import android.util.Log;

import java.util.Random;
import java.util.logging.Logger;

import com.example.jingleski.midtier.configuration.Configuration;

public class OperationResponder {
    
    /**
    * @param operationIdentifier e.g.: "+" or "-"
    * @return return an int[] containing the factors x,y of the addition or the subtraction
    */
    private static int[] getOperationNumbers(String operationIdentifier, Configuration.Child child){



        int[] operationNumbers = new int[2];
        int operationNumber_1 = 0;
        int operationNumber_2 = 0;
        
        switch(operationIdentifier) {
            case(Configuration.PLUS_SIGN):
                operationNumber_1 = new Random().nextInt(child.getMaxNumberAddition()+1);
                operationNumber_2 = new Random().nextInt(child.getMaxNumberAddition() - operationNumber_1 +1);
                break;
                
            case(Configuration.MINUS_SIGN):
                operationNumber_1 = new Random().nextInt(child.getMaxNumberAddition()+1);
                //minimum 0; maximum value of operationNumber_1;
                operationNumber_2 = new Random().nextInt(child.getMaxNumberAddition()+1);
                
                //attention, don't go lower than 0!
                if( (operationNumber_1 - operationNumber_2) < 0){
                    //swith numbers: (5-15 becomes 15-5)
                    int help = operationNumber_1;
                    operationNumber_1 = operationNumber_2;
                    operationNumber_2 = help;
                }
                break;

            case(Configuration.MULTIPLICATION_SIGN):
                operationNumber_1 = new Random().nextInt(child.getMaxNumberMultiplication()+1);
                operationNumber_2 = new Random().nextInt(child.getMaxNumberMultiplication()+1);

            default: operationNumber_2 = 0;
        }
        
        operationNumbers[0] = operationNumber_1;
        operationNumbers[1] = operationNumber_2;
        return operationNumbers;

    }
    
    /**
     * @param operationIdentifier: identifies the operation: e.g. "+" for addition and "-" for subtraction
     */
    public static OperationResponse handleResponse(String operationIdentifier, Configuration.Child child) {
        int updatedSequenceNumber = 0;

        int[] factors = getOperationNumbers(operationIdentifier,child);
        
        return new OperationResponse(updatedSequenceNumber, factors, false, false);
    }
    
    /**
     * @param operationIdentifier: identifies the operation: e.g. "+" for addition and "-" for subtraction
     * @param sequenceNumber: the sequenceNumber of the exercise
     * @param x: first entered factor by the user
     * @param y: second entered factor by the user
     * @param solution: solution entered by the user that needs to be checked
     * 
     * @return OperationResponse
     */
    public static OperationResponse handleResponse(String operationIdentifier, int sequenceNumber, int x, int y, int solution, Configuration.Child child){
        
        /* result operation ok? */
        Operation operation;
        
        switch(operationIdentifier) {
            case(Configuration.PLUS_SIGN):
                operation = new Addition();
                break;
                
            case(Configuration.MINUS_SIGN):
                operation = new Subtraction();
                break;

            case(Configuration.MULTIPLICATION_SIGN):
                operation = new Multiplication();
                break;
                
            default: operation = new Addition();
        }
        
        boolean resultOkIc = operation.process(new int[]{x,y}, solution);
        
        /* new sequenceNumber */
        int updatedSequenceNumber = ++sequenceNumber;
        
        /* last sequence?  Finished? */
        boolean finishIc = updatedSequenceNumber >= Configuration.MAX_SEQUENCES_PER_EXERCISE;
        
        /* new factors */
        int[] factors = getOperationNumbers(operationIdentifier,child);
        
        /* return new OperationResponse*/
        return new OperationResponse(updatedSequenceNumber, factors, resultOkIc, finishIc);
    }
    
}
