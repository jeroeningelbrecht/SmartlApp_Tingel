package com.example.jingleski.midtier.operations;

public class Subtraction implements Operation{
    
    public boolean process(int[] numbers, int solution){
        
        int diff = numbers[0];
        for(int i=1; i<numbers.length; i++){
            diff -= numbers[i];
        }
        
        return diff == solution;
    }
    
}
