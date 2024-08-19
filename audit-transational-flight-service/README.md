### About:
- Rest API Flight Booking service where booking can be success or failure depending of sufficient payment validation, but capture audit log all information.
- Spring Boot microservice jpa transactional and audit logging.

### Used Resources:
- Dependencies:
- Spring Boot (2.5.x)
- Maven 
- Java (1.8)
- Libraries:
  * starter-web 
  * starter-data-jpa
  * starter-aop
  * mysql-connector-java
  * lombok 
  
  
### Test
- Postman collection supplied with two test cases (Success and Rejected).
- When transaction success, the FS_AUDIT_LOGS, FS_PASSENGER_INFOS and FS_PAYMENT_INFO tables will be populated.
- When transaction rejected, the FS_AUDIT_LOGS table will only be populated.


