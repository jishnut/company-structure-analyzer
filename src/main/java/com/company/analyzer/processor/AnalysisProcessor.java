package com.company.analyzer.processor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.company.analyzer.model.Employee;
import com.company.analyzer.model.ManagerDifferentialSalary;
import com.company.analyzer.model.ReportingLine;
import com.company.analyzer.repository.EmployeeRepository;

/**
 * Processor for performing the company structure analysis based on pre-defined criteria.
 */
public class AnalysisProcessor {
    private static EmployeeRepository employeeRepository = EmployeeRepository.getSingletonInstance();

    /**
     * @return the list of managers who do not earn at least 20% more than the average salary of direct subordinates
     */
    public static List<ManagerDifferentialSalary> findManagersEarningLess(){
        List<Employee> employees = employeeRepository.getEmployees();

        Map<String, Double> subordinateAvgSalaries = employees.stream()
            .collect(Collectors.groupingBy(Employee::getManagerId
                                            , Collectors.averagingDouble(Employee::getSalary)));

        List<ManagerDifferentialSalary> res = employees.stream()
            .filter(e -> (subordinateAvgSalaries.containsKey(e.getId()) && e.getSalary() < 1.2 * subordinateAvgSalaries.get(e.getId())))
            .map(e -> new ManagerDifferentialSalary(e.getId(), e.getFirstName(), e.getLastName(), (int) (1.2*subordinateAvgSalaries.get(e.getId()) - e.getSalary())))
            .collect(Collectors.toList());        

        return res;
    }

    /**
     * @return the list of managers who earn more than 50% above the average salary of direct subordinates
     */
    public static List<ManagerDifferentialSalary> findManagersEarningMore(){
        List<Employee> employees = employeeRepository.getEmployees();

        Map<String, Double> subordinateAvgSalaries = employees.stream()
            .collect(Collectors.groupingBy(Employee::getManagerId
                                            , Collectors.averagingDouble(Employee::getSalary)));

        List<ManagerDifferentialSalary> res = employees.stream()
            .filter((e)->(subordinateAvgSalaries.containsKey(e.getId()) && e.getSalary() > 1.5 * subordinateAvgSalaries.get(e.getId())))
            .map(e -> new ManagerDifferentialSalary(e.getId(), e.getFirstName(), e.getLastName(), (int) (e.getSalary() - 1.5*subordinateAvgSalaries.get(e.getId()))))
            .collect(Collectors.toList());

        return res;
    }
    
    /**
     * @return the list of employees having a longer reporting line than expected
     */
    public static List<ReportingLine> employeesWithLongReportingLine(){
        List<Employee> employees = employeeRepository.getEmployees();

        List<ReportingLine> reportingLines = employees.stream().filter(e -> (e.getManagerCountInReportingLine() > 4))
                                                .map(e -> (new ReportingLine(e.getId(), e.getFirstName(), e.getLastName(), e.getManagerCountInReportingLine()-4)))
                                                .toList();
        
        return reportingLines;
    }
}
