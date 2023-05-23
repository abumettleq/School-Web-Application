# School Web Application Documentation

## Table of Contents

1. Introduction
2. Features
3. Technologies Used
4. Installation
5. Configuration
6. Usage
7. File Structure
8. Acknowledgements
9. License

## 1. Introduction

The School Web Application is a Java-based web application developed using the Spring Framework. It aims to provide a comprehensive platform for schools to manage various activities such as news updates, e-library, student management system, and teacher-student communication. This documentation will guide you through the installation, configuration, and usage of the application.

## 2. Features

The School Web Application includes the following features:

- News Management: Administrators can create and manage news articles to keep the school community informed.
- E-Library: A digital library system for students and teachers to access and manage educational resources.
- Login System: Separate login systems for students and teachers, allowing them to access personalized features.
- Student Information System (S.I.S): A module for managing student-related information, including profiles, attendance, grades, and schedules.
- Student Management System (S.M.S): A module for teachers to manage student-related information, including attendance, grades, and other details specific to a particular class.

## 3. Technologies Used

The following technologies and frameworks were used in the development of this application:

- Java
- Spring Framework (Spring Boot, Spring MVC, Spring Data JPA)
- HTML/CSS/JavaScript
- Thymeleaf (Java-based templating engine)
- MySQL (Relational database management system)

## 4. Installation

To install and run the School Web Application locally, follow these steps:

1. Clone the repository from GitHub:

```
git clone https://github.com/abumettleq/School-Web-Application.git
```

2. Ensure that Java Development Kit (JDK) and MySQL are installed on your system.

3. Create a MySQL database for the application.

4. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).

5. Update the database configuration in the `application.properties` file located in `src/main/resources`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/{database_name}
spring.datasource.username={database_username}
spring.datasource.password={database_password}
```

Replace `{database_name}`, `{database_username}`, and `{database_password}` with your MySQL database details.

6. Build and run the application from the IDE or use the following command in the project directory:

```
./mvnw spring-boot:run
```

## 5. Configuration

The School Web Application provides various configuration options that can be customized. The main configuration files can be found in the `src/main/resources` directory:

- `application.properties`: Contains the general application configuration, including the database settings.
- Other configuration files specific to Spring modules (e.g., Spring Security) may also be present.

## 6. Usage

After successfully running the application, you can access it in your web browser using the following URL:

```
http://localhost:8080
```

You will be presented with the application's home page, from where you can navigate to different features based on your role (student or teacher). Use the provided login system to authenticate and access the respective functionalities.

## 7. File Structure

The file structure of the School Web Application project is organized as follows:

```
School-Web-Application
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.demo
│   │   ├── resources
│   │   └── webapp
│   └── test


│       └── java
│           └── com.example.demo
├── pom.xml
└── README.md
```

## 8. Acknowledgements

Alaaeddin M. AbuMettleq - 190041145, Sayed Ghazanfar Shah - 190041142, Mohammed Kamal - 190041143.
