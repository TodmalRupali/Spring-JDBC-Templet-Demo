Spring-JDBC-Templet-Demo
Spring JdbcTemplate is a powerful mechanism to connect to the database and execute SQL queries. 
It internally uses JDBC api, but eliminates a lot of problems of JDBC API.
JdbcTemplate class

It is the central class in the Spring JDBC support classes.
It takes care of creation and release of resources such as creating and closing of connection object etc. So it will not lead to any problem if you forget to close the connection.

It handles the exception and provides the informative exception 
messages by the help of excepion classes defined in the org.springframework.dao package.

We can perform all the database operations by the help of JdbcTemplate class such as insertion, updation, 
deletion and retrieval of the data from the database.


Performed Functionallity
1. signUp-
    Validate MailId
2. signIn
3. getDataById
4. getDataByName
5. getDataByEmail
6. getDataByContactNumber
7. getDataByUsingAnyInput
8. getAllData
9. sortByName using stream api
10. sortById using stream api
11. sortBySalary using stream api
12. sortByAge using stream api
13. sortByDOB using stream api
14. filterDataBySalary using stream api
15. loanEligibility- Yes Eligible for Loan | salary>=50000
16. updateData
17. deleteData
18. fetch second largest salary record using stream api
19. deleteAllData
20. SaveBulkOfData
