package com.example.jingleski.midtier.operations;

import java.util.Arrays;

public class OperationResponse {
    
    private int sequenceNumber;
    private int[] factors;
    private boolean resultOkIc,finishIc;
    
    public OperationResponse(){
        this(0, new int[]{0,0}, false, false);
    }
    
    public OperationResponse(int sequenceNumber, int[]factors, boolean resultOkIc, boolean finishIc){
        this.sequenceNumber = sequenceNumber;
        this.factors = factors;
        this.resultOkIc = resultOkIc;
        this.finishIc = finishIc;
    }
    
    public int getSequenceNumber(){
        return this.sequenceNumber;    
    }
    
    public int[] getFactors(){
        return this.factors;    
    }
    
    public boolean isResultOkIc(){
        return this.resultOkIc;    
    }
    
    public boolean isFinishIc(){
        return this.finishIc;    
    }
    
    @Override
    public String toString(){
        String representation = "";
        representation += "sequencenumber: " + this.sequenceNumber;
        representation += " - factors: " + Arrays.toString(this.factors);
        representation += " - result ok?: " + this.resultOkIc;
        representation += " - finished?: " + this.finishIc;
        
        
        return representation;
    }
    
}
