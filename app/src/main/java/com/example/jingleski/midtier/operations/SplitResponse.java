package com.example.jingleski.midtier.operations;

public class SplitResponse extends OperationResponse{
    
    public SplitResponse() {
        super();    
    }
    
    public SplitResponse(int sequenceNumber, int[]factors, boolean resultOkIc, boolean finishIc){
        super(sequenceNumber, factors, resultOkIc, finishIc);
    }
    
}
