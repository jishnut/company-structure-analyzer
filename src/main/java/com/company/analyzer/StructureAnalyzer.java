package com.company.analyzer;

import java.io.IOException;
import java.util.List;

import com.company.analyzer.model.ManagerDifferentialSalary;
import com.company.analyzer.model.ReportingLine;
import com.company.analyzer.processor.AnalysisProcessor;
import com.company.analyzer.repository.EmployeeRepository;
import com.company.analyzer.util.Constants;
import com.company.analyzer.util.CsvReader;
import com.company.analyzer.util.DefaultEmployeeFactory;
import com.company.analyzer.util.EmployeeFactory;
import com.company.analyzer.util.Output;

/**
 * Reads an input CSV file with employee details, analyzes the company structure, and reports the analysis results.
 */
public class StructureAnalyzer 
{
    private static CsvReader csvReader = CsvReader.getSingletonInstance();
    private static EmployeeFactory employeeFactory = new DefaultEmployeeFactory();
    private static EmployeeRepository employeeRepository = EmployeeRepository.getSingletonInstance();

    public static void main( String[] args ) throws IOException
    {
        String inputFileName = args.length > 0? args[0] : null;
        if(inputFileName == null || inputFileName.isBlank())
            inputFileName = Constants.getInputFileName();
        
        List<String> csvLines = csvReader.readCsv(inputFileName, args.length==0);
        Output.logLinesFromInput(csvLines);

        for(int i=1; i<csvLines.size(); i++){
            String line = csvLines.get(i);
            String[] lineContents = line.split(Constants.getCsvSeparator());
            employeeRepository.addEmployee(employeeFactory.createEmployee(lineContents[0], lineContents[1], lineContents[2], Integer.parseInt(lineContents[3]), lineContents.length==5?lineContents[4]:Constants.getEmptyString()));            
        }

        List<ManagerDifferentialSalary> result1 = AnalysisProcessor.findManagersEarningLess();
        List<ManagerDifferentialSalary> result2 = AnalysisProcessor.findManagersEarningMore();
        List<ReportingLine> result3 = AnalysisProcessor.employeesWithLongReportingLine();

        Output.logStructureAnalysisResults(result1, result2, result3);
    }
}
