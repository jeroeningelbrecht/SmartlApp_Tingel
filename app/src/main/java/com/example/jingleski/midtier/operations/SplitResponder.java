package com.example.jingleski.midtier.operations;

public class SplitResponder{
    
    /**
     * handle a splitrequest/response but with only giving the operationidentifier
     * @param operationIdentifier: identifies the operation: e.g. "+" for addition and "-" for subtraction
     */
    public static OperationResponse handleResponse(String operationIdentifier) {
        
        
        return new SplitResponse(0,new int[]{0,0},false,false);
    }
    
}
