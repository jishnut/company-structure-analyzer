package com.company.analyzer.util;

import com.company.analyzer.model.Employee;

/**
 * Default Implementation of EmployeeFactory.
 */
public class DefaultEmployeeFactory implements EmployeeFactory{

    @Override
    public Employee createEmployee(String id, String firstName, String lastName, int salary, String managerId) {
        return new Employee(id, firstName, lastName, salary, managerId);
    }
    
}
