package com.company.analyzer.util;

import com.company.analyzer.model.Employee;

/**
 * Factory for creating Employee instances.
 */
public interface EmployeeFactory {
    
    /**
     * @param id
     * @param firstName
     * @param lastName
     * @param salary
     * @param managerId
     * @return a new Employee instance
     */
    public Employee createEmployee(String id, String firstName, String lastName, int salary, String managerId);
}
