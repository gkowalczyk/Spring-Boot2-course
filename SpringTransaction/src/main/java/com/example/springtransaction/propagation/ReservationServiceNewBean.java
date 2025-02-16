package com.example.springtransaction.propagation;

import org.springframework.stereotype.Service;

@Service
public class ReservationServiceNewBean {

    private ReservationService reservationService;

    public ReservationServiceNewBean(ReservationService reservationService) {
        this.reservationService = reservationService;
      //  reservationService.saveTicket();
      //  reservationService.reserveTicket();
        reservationService.reserveTicketForPassenger();
    }
}