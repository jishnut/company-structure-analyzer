package com.company.analyzer.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.company.analyzer.model.Employee;

public class DefaultEmployeeFactoryTests {
    private static EmployeeFactory employeeFactory = new DefaultEmployeeFactory();

    @Test
    public void createEmployee(){
        Employee emp = employeeFactory.createEmployee("123", "Vito", "Corleone", 10000, "124");

        assertEquals("123", emp.getId());
        assertEquals("Vito", emp.getFirstName());
        assertEquals("Corleone", emp.getLastName());
        assertEquals(10000, emp.getSalary());
        assertEquals("124", emp.getManagerId());
    }
}
