# Company Structure Analyzer
The project is designed to help the company analyze its organizational structure and identify areas for improvement. It focuses on reporting the data necessary to support decision-making within the organization.

## Input modes
1. **No input file provided** - File named *sample_input.csv* will be used from the classpath (present in resources folder).  
2. **Input file path as argument** - Provide a single argument while running the Java application. This argument will be treated as the input CSV file path (e.g. */Users/sampleuser/input_files/user_input.csv*).  

## Sample CSV input-file contents
Id,firstName,lastName,salary,managerId  
123,Joe,Doe,60000,  
124,Martin,Chekov,45000,123  
125,Bob,Ronstad,47000,123  
300,Alice,Hasacat,50000,124  
305,Brett,Hardleaf,34000,300  
306,Vito,Corleone,30000,300  
307,Michael,Corleone,30000,306  
308,John,Corleone,40000,307  
309,Freddy,Corleone,30000,308  

## Sample Output from Console
====== Input received from CSV ==============  
Id,firstName,lastName,salary,managerId  
123,Joe,Doe,60000,  
124,Martin,Chekov,45000,123  
125,Bob,Ronstad,47000,123  
300,Alice,Hasacat,50000,124  
305,Brett,Hardleaf,34000,300  
306,Vito,Corleone,30000,300  
307,Michael,Corleone,30000,306  
308,John,Corleone,40000,307  
309,Freddy,Corleone,30000,308  
\===============================================  
  
====== Managers earning less =================  
[managerId = 124, firstName = Martin, lastName = Chekov, salaryDifference = 15000]  
[managerId = 306, firstName = Vito, lastName = Corleone, salaryDifference = 6000]  
[managerId = 307, firstName = Michael, lastName = Corleone, salaryDifference = 18000]  
\==============================================  
  
====== Managers earning more =================  
[managerId = 300, firstName = Alice, lastName = Hasacat, salaryDifference = 2000]  
\==============================================  
  
===== Employees with long reporting lines =====  
[employeeId = 308, firstName = John, lastName = Corleone, managerCountAboveExpected = 1]  
[employeeId = 309, firstName = Freddy, lastName = Corleone, managerCountAboveExpected = 2]  
\===============================================  

