package com.example.spring_security_m3_hom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationRepo extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByValue(String token);
}


