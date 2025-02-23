package com.example.csv_formatter_mysqldb_app.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "First name is mandatory")
    @Column(name = "first_name")
    private String firstName;
    @NotBlank(message = "Last name is mandatory")
    @Column(name = "last_name")
    private String lastName;
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Gender is mandatory")
    private String gender;
    @NotBlank(message = "IP address is mandatory")
    @Column(name = "ip_address")
    private String ipAddress;
}
