package com.company.analyzer.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Reader for the input CSV file.
 */
public class CsvReader {

    private static CsvReader singletonInstance;
    private Logger logger;

    private CsvReader(){
        this.logger = new ConsoleLogger();
    }

    public static CsvReader getSingletonInstance(){
        if(singletonInstance == null){
            singletonInstance = new CsvReader();
        }
        return singletonInstance;
    }
    
    /**
     * @return the list of lines present in the input csv file
     * @throws IOException if there is any error while reading the CSV file from location
     */
    public List<String> readCsv(String inputFileName, boolean isFromClassPath) throws IOException{
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream fileInputStream = isFromClassPath ? classLoader.getResourceAsStream(inputFileName) : new FileInputStream(inputFileName);

        List<String> lines = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream))){
            String line;
            while((line = br.readLine()) != null){
                lines.add(line);
            }
        }
        finally{            
            try {
                if(fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                logger.log(e.getMessage());
            }
        }
        return lines;
    }
}
