package com.example.jingleski.midtier.operations;

public class Addition implements Operation{
    
    /**
     * Is the sum of the numbers in numbers[] equal to the given solution
     */
    public boolean process(int[] numbers, int solution){
        int sum = 0;
        for(int i:numbers){
            sum+=i;    
        }
        
        return sum==solution;
    }
    
}
