package com.company.analyzer.model;

/**
 * A model representing the reporting line analysis result for an Employee.
 */
public class ReportingLine {
    private String employeeId;
    private String firstName;
    private String lastName;
    private int managerCountAboveExpected;

    public ReportingLine(String employeeId, String firstName, String lastName, int managerCountAboveExpected) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.managerCountAboveExpected = managerCountAboveExpected;
    }

    public String getEmployeeId(){
        return this.employeeId;

    }

    public String getFirstName(){
        return this.firstName;
        
    }

    public String getLastName(){
        return this.lastName;
        
    }

    public int getManagerCountAboveExpected(){
        return this.managerCountAboveExpected;
        
    }

    @Override
    public String toString(){
        String stringRepresentation = String.format("[employeeId = %s, firstName = %s, lastName = %s, managerCountAboveExpected = %d]", this.employeeId, this.firstName, this.lastName, this.managerCountAboveExpected);

        return stringRepresentation;
    }
}
