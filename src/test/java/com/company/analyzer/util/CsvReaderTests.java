package com.company.analyzer.util;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import org.junit.Test;

public class CsvReaderTests {
    private static CsvReader csvReader = CsvReader.getSingletonInstance();

    @Test
    public void readCsv() throws IOException{
        List<String> lines = csvReader.readCsv("sample_input.csv", true);
        assertEquals(10, lines.size());

        assertEquals("Id,firstName,lastName,salary,managerId", lines.get(0));
        assertEquals("123,Joe,Doe,60000,", lines.get(1));
        assertEquals("124,Martin,Chekov,45000,123", lines.get(2));
        assertEquals("125,Bob,Ronstad,47000,123", lines.get(3));
        assertEquals("300,Alice,Hasacat,50000,124", lines.get(4));
        assertEquals("305,Brett,Hardleaf,34000,300", lines.get(5));
        assertEquals("306,Vito,Corleone,30000,300", lines.get(6));
        assertEquals("307,Michael,Corleone,30000,306", lines.get(7));
        assertEquals("308,John,Corleone,40000,307", lines.get(8));
        assertEquals("309,Freddy,Corleone,30000,308", lines.get(9));
    }
    
}
