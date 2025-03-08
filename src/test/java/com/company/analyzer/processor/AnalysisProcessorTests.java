package com.company.analyzer.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.company.analyzer.model.ManagerDifferentialSalary;
import com.company.analyzer.model.ReportingLine;
import com.company.analyzer.repository.EmployeeRepository;
import com.company.analyzer.util.DefaultEmployeeFactory;
import com.company.analyzer.util.EmployeeFactory;

public class AnalysisProcessorTests {
    private static EmployeeRepository employeeRepository = EmployeeRepository.getSingletonInstance();
    private static EmployeeFactory employeeFactory = new DefaultEmployeeFactory();

    @BeforeClass
    public static void setup(){
        employeeRepository.addEmployee(employeeFactory.createEmployee("123", "Joe", "Doe", 60000, ""));
        employeeRepository.addEmployee(employeeFactory.createEmployee("124", "Martin", "Chekov", 45000, "123"));
        employeeRepository.addEmployee(employeeFactory.createEmployee("125", "Bob", "Ronstad", 47000, "123"));
        employeeRepository.addEmployee(employeeFactory.createEmployee("300", "Alice", "Hasacat", 50000, "124"));
        employeeRepository.addEmployee(employeeFactory.createEmployee("305", "Brett", "Hardleaf", 34000, "300"));
        employeeRepository.addEmployee(employeeFactory.createEmployee("306", "Vito", "Corleone", 30000, "300"));
        employeeRepository.addEmployee(employeeFactory.createEmployee("307", "Michael", "Corleone", 30000, "306"));
        employeeRepository.addEmployee(employeeFactory.createEmployee("308", "John", "Corleone", 40000, "307"));
        employeeRepository.addEmployee(employeeFactory.createEmployee("309", "Freddy", "Corleone", 30000, "308"));
    }

    @Test
    public void findManagersEarningLess(){
        List<ManagerDifferentialSalary> result = AnalysisProcessor.findManagersEarningLess();
        assertEquals(3, result.size());

        Set<String> firstNames = new HashSet<>(result.stream().map(mds -> mds.getFirstName()).toList());
        assertTrue(firstNames.contains("Martin"));
        assertTrue(firstNames.contains("Vito"));
        assertTrue(firstNames.contains("Michael"));
    }

    @Test
    public void findManagersEarningMore(){
        List<ManagerDifferentialSalary> result = AnalysisProcessor.findManagersEarningMore();
        assertEquals(1, result.size());

        Set<String> firstNames = new HashSet<>(result.stream().map(mds -> mds.getFirstName()).toList());
        assertTrue(firstNames.contains("Alice"));
    }

    @Test
    public void employeesWithLongReportingLine(){
        List<ReportingLine> result = AnalysisProcessor.employeesWithLongReportingLine();
        assertEquals(2, result.size());

        Set<String> firstNames = new HashSet<>(result.stream().map(mds -> mds.getFirstName()).toList());
        assertTrue(firstNames.contains("John"));
        assertTrue(firstNames.contains("Freddy"));
    }
}
