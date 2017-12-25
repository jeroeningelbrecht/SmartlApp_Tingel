package com.example.jingleski.midtier.operations;

public class SplitResponse extends OperationResponse{
    
    public SplitResponse() {
        super();    
    }

    /**
     *
     * @param sequenceNumber
     * @param terms: in a SplitResponse, terms[0] is the result and terms[1] is part of the sum or subtraction;
     *               e.g. [15,5] where the user needs to give in 10 as 15 = 5 + 10 in case the sign is '+'
     *               e.g. [15,20] where the user needs to give in 5 as 15 = 20 - 5 in case the sign is '-'
     * @param resultOkIc
     * @param finishIc
     */
    public SplitResponse(int sequenceNumber, int[]terms, boolean resultOkIc, boolean finishIc){
        super(sequenceNumber, terms, resultOkIc, finishIc);
    }
    
}
