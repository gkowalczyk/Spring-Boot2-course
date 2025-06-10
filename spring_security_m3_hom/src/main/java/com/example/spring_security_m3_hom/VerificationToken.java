package com.example.spring_security_m3_hom;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String value;
    @ManyToOne
    private AppUser appUser;
    private LocalDateTime localDateTime = LocalDateTime.now();

    public VerificationToken(String value, AppUser appUser) {
        this.value = value;
        this.appUser = appUser;
    }
}

