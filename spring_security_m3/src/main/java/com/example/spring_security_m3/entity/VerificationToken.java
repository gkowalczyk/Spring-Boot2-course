package com.example.spring_security_m3.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {

     @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String value;
    @OneToOne
    private AppUser appUser;

    public VerificationToken(String value, AppUser appUser) {
        this.value = value;
        this.appUser = appUser;
    }
}

