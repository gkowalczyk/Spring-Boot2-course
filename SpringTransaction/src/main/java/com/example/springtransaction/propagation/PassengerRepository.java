package com.example.springtransaction.propagation;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
