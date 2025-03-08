package com.company.analyzer.util;

/**
 * Holds all the global constants.
 */
public class Constants {
    private static final String csvSeparator = ",";
    private static final String emptyString = "";
    private static final String inputFileName = "sample_input.csv";

    private Constants(){ }

    public static String getCsvSeparator(){
        return csvSeparator;
    }

    public static String getEmptyString(){
        return emptyString;
    }

    public static String getInputFileName(){
        return inputFileName;
    }
}
