package com.company.analyzer.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.company.analyzer.model.Employee;

/**
 * A repository of employees.
 */
public class EmployeeRepository {
    private static EmployeeRepository employeeRepository;
    private List<Employee> employees;

    private EmployeeRepository(){ 
        employees = new ArrayList<>();
    }
    
    public static EmployeeRepository getSingletonInstance(){
        if(employeeRepository == null)
            employeeRepository = new EmployeeRepository();
        
        return employeeRepository;
    }

    public List<Employee> getEmployees(){
        return this.employees;
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }

    /**
     * @param employeeId the id of the employee to be fetched
     * @return an Employee instance linked with the provided id
     */
    public Employee getById(String employeeId){
        Optional<Employee> employee = this.employees.stream().filter(e -> (employeeId.equals(e.getId()))).findFirst();

        return employee.isPresent() ? employee.get() : null;
    }
}
