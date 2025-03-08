package com.company.analyzer.model;

import java.util.stream.Stream;

import com.company.analyzer.repository.EmployeeRepository;

/**
 * A model representing an employee.
 */

public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private int salary;
    private String managerId;

    private static EmployeeRepository employeeRepository = EmployeeRepository.getSingletonInstance();

    public Employee(String id, String firstName, String lastName, int salary, String managerId){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.managerId = managerId;
    }

    public String getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public int getSalary(){
        return this.salary;
    }

    public String getManagerId(){
        return this.managerId;
    }

    public Employee getManager(){
        return employeeRepository.getById(this.managerId);
    }

    /**
     * @return the number of managers in the reporting line of the employee
     */
    public int getManagerCountInReportingLine(){
        int managerCount = (int) Stream.iterate(this, e -> (e.getManager() != null), Employee::getManager)
                                    .count();

        return managerCount;
    }
}
