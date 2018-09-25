package com.example.jingleski.midtier.configuration;

public class Configuration {
    
    /**
     * for example max 10 sequences per addition exercise
     */
    public static final int MAX_SEQUENCES_PER_EXERCISE = 10;

    /**
     * "+"
     */
    public static final String PLUS_SIGN = "+";
    
    /**
     * "-"
     */
    public static final String MINUS_SIGN = "-";

    /**
     *  "*"
     */
    public static final String MULTIPLICATION_SIGN = "*";

    public enum Child {
        MARIE("Marie",10,10,2),LAURA("Laura",100,100,11),RIENE("Riene",100,100,11);

        private String name;
        private int maxNumberAddition;          //what is the max number for additions?  E.g.: 20
        private int maxNumberSubtraction;       //what is the max number for subtractions; e.g. 20
        private int maxNumberMultiplication;    //what is the max number for multiplication

        Child(String name, int maxNumberAddition, int maxNumberSubtraction, int maxNumberMultiplication) {
            this.name=name;
            this.maxNumberAddition = maxNumberAddition;
            this.maxNumberSubtraction = maxNumberSubtraction;
            this.maxNumberMultiplication= maxNumberMultiplication;
        }
        public String getName(){
            return this.name;
        }
        public int getMaxNumberAddition() {
            return maxNumberAddition;
        }
        public int getMaxNumberSubtraction() {
            return maxNumberSubtraction;
        }
        public int getMaxNumberMultiplication() {
            return maxNumberMultiplication;
        }

        public String toString(){
            return this.name;
        }
    }
}
