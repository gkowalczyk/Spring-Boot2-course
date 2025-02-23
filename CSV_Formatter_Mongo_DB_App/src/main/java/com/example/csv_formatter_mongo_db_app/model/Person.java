package com.example.csv_formatter_mongo_db_app.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Person {
    @Id
    private String id;
    @Size(min = 2, message = "First name should have at least 2 characters")
    private String firstName;
    @Size(min = 2, message = "last name should have at least 2 characters")
    private String lastName;
    @Email(message = "Email should be valid")
    private String email;
    @Size(min = 4, message = "male, female or other")
    private String gender;
    @Size(min = 7, message = "IP address should have at least 7 characters")
    private String ipAddress;
}
