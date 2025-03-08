package com.company.analyzer.util;

import java.util.List;

import com.company.analyzer.model.ManagerDifferentialSalary;
import com.company.analyzer.model.ReportingLine;


/**
 * Utility for logging the analysis results.
 */

public class Output {

    private static Logger logger = new ConsoleLogger();

    /**
     * Logs the lines read from the input CSV file.
     * 
     * @param lines lines read from the input CSV file
     */
    public static void logLinesFromInput(List<String> lines){
        logger.log("\n====== Input received from CSV ==============");
        for(String line: lines){
            logger.log(line);
        }        
        logger.log("===============================================\n");
    }

    /**
     * Logs the company structure analysis results.
     * 
     * @param result1 result from the analysis of managers earning less than the expectation
     * @param result2 result from the analysis of managers earning more than the expectation
     * @param result3 result from the reporting line analysis of employees
     */
    public static void logStructureAnalysisResults(List<ManagerDifferentialSalary> result1, List<ManagerDifferentialSalary> result2, List<ReportingLine> result3){
        logger.log("====== Managers earning less =================");
        for(ManagerDifferentialSalary r: result1){
            logger.log(r.toString());
        }
        logger.log("==============================================\n");

        logger.log("====== Managers earning more =================");
        for(ManagerDifferentialSalary r: result2){
            logger.log(r.toString());
        }
        logger.log("==============================================\n");

        logger.log("===== Employees with long reporting lines =====");
        for(ReportingLine r: result3){
            logger.log(r.toString());
        }
        logger.log("===============================================\n");
    }

}
