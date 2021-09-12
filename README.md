<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#description">Description About The Project</a>
      <ul>
        <li><a href="#school-management-system-uml-diagram">School Management System Uml Diagram</a></li>
      </ul>
    </li>
    <li>
      <a href="#mapping-operations-on-swagger">Mapping Operations On Swagger</a>
      <ul>
        <li><a href="#mapping-operations-on-the-student">Mapping Operations On The Student</a></li>
        <li><a href="#mapping-operations-on-the-instructor">Mapping Operations On The Instructor</a></li>
        <li><a href="#mapping-operations-on-the-course">Mapping Operations On The Course</a></li>
        <li><a href="#mapping-operations-on-the-address">Mapping Operations On The Address</a></li>
      </ul>
    </li>
    <li><a href="#accessing-another-endpoint-using-restTemplate">Accessing Another Endpoint Using RestTemplate</a>
      <ul>
        <li><a href="#accessor-endpoint-for-tlToDollar-operation">Accessor Endpoint For TlToDollar Operation</a></li>
        <li><a href="#accessor-endpoint-for-dollarToTl-operation">Accessor Endpoint For DollarToTl Operation</a></li>
      </ul>
    </li>
    <li><a href="#third-project">Third Projects Information</a></li>
  </ol>
</details>

## Description

---
- The third project of Gitti Gidiyor Java Spring Bootcamp by patika.
- Database of a school management system has been created.
- H2 is used as the database system.
- The connection of the project with h2 is made using Spring Data Jpa.
- Querying, updating and deleting operations can be performed With Spring Boot Get, Post, Put and Delete mapping.
- The design of the project was made in accordance with the UML diagram.
- Swagger was used to perform Get, Post, Put and Delete mapping operations.

### School Management System Uml Diagram

---
![ThirdHomework](SchoolManagementSystem/src/main/java/images/ThirdHomework.jpg)

## Mapping Operations On Swagger

---
### Mapping Operations On The Student

![Student](SchoolManagementSystem/src/main/java/images/Student.jpg)

### Mapping Operations On The Instructor

![Instructor](SchoolManagementSystem/src/main/java/images/Instructor.jpg)

### Mapping Operations On The Course

![Course](SchoolManagementSystem/src/main/java/images/Course.jpg)

### Mapping Operations On The Address

![Address](SchoolManagementSystem/src/main/java/images/Address.jpg)

## Accessing Another Endpoint Using RestTemplate

---
### Accessed Endpoints

![Endpoints](SchoolManagementSystem/src/main/java/images/Endpoints.jpg)

* Accessed Urls:
  * "http://localhost:8080/convert/tltodollar"
  * "http://localhost:8080/convert/dollartotl"

### Accessor Endpoint for TlToDollar Operation

* Accessor Url:
  * "http://localhost:8081/convert/Endpoint"


![TltoDollar](SchoolManagementSystem/src/main/java/images/Tltodollar.jpg)

### Accessor Endpoint for DollarToTl Operation

* Accessor Url:
  * "http://localhost:8081/convert/Endpoint2"

![DollarToTl](SchoolManagementSystem/src/main/java/images/Dollartotl.jpg)


## Third Project



![homework-3](https://user-images.githubusercontent.com/45206582/130367375-bd448187-9b20-41aa-9608-d0ae906e862a.PNG)
