package com.example.springtransaction.propagation;

import jakarta.persistence.*;


import java.math.BigDecimal;

@Entity
public class Passenger {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private BigDecimal wallet;

    public Passenger(String name, BigDecimal wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public Passenger() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getWallet() {
        return wallet;
    }
    public void setWallet(BigDecimal wallet) {
        this.wallet = wallet;
    }
}
