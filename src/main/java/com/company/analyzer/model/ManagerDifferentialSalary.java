package com.company.analyzer.model;

/**
 * A model holding the details of a manager and how much more/less the manager earns above/below the expectation.
 */
public class ManagerDifferentialSalary {
    private String managerId;
    private String firstName;
    private String lastName;
    private int salaryDifference;

    public ManagerDifferentialSalary(String managerId, String firstName, String lastName, int salaryDifference) {
        this.managerId = managerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salaryDifference = salaryDifference;
    }

    public String getManagerId(){
        return this.managerId;

    }

    public String getFirstName(){
        return this.firstName;
        
    }

    public String getLastName(){
        return this.lastName;
        
    }

    public int getSalaryDifference(){
        return this.salaryDifference;
        
    }

    @Override
    public String toString(){
        String stringRepresentation = String.format("[managerId = %s, firstName = %s, lastName = %s, salaryDifference = %d]", this.managerId, this.firstName, this.lastName, this.salaryDifference);

        return stringRepresentation;
    }
}
