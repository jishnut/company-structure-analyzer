package com.company.analyzer.util;
/**
 * Console-based implementation of Logger.
 */
public class ConsoleLogger implements Logger {

    @Override
    public void log(String content) {
        System.out.println(content);
    }
    
}
