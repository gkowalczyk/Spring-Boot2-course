package com.example.springtransaction.propagation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class ReservationService {

    private TicketRepository ticketRepository;
    private PassengerRepository passengerRepository;
    private BigDecimal TICKET_PRICE = new BigDecimal(90);
    private ReservationService2 reservationService2;

    public ReservationService(TicketRepository ticketRepository, PassengerRepository passengerRepository, ReservationService2 reservationService2) {
        this.ticketRepository = ticketRepository;
        this.passengerRepository = passengerRepository;
        this.reservationService2 = reservationService2;
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveTicket() {
        Ticket ticket = new Ticket("Concert");
        ticketRepository.save(ticket);
        //  System.out.println(10 / 0);
    }

    @Transactional
    public String reserveTicket() {
        Passenger passenger = new Passenger();
        passenger.setName("John");
        passenger.setWallet(new BigDecimal(100));
        passengerRepository.save(passenger);
        validateWallet(passenger.getWallet());
        Ticket ticket = new Ticket("Football match");
        ticketRepository.save(ticket);
        return "Ticket reserved";
    }

    private boolean validateWallet(BigDecimal accountBalance) {
        if (accountBalance.compareTo(TICKET_PRICE) < 0) {
            throw new RuntimeException("Insufficient funds");
        }
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void reserveTicketForPassenger() {
        Passenger passenger = new Passenger();
        passenger.setName("John");
        passenger.setWallet(new BigDecimal(100));
        passengerRepository.save(passenger);
        try {
            reservationService2.reserveTicket2();
        } catch (Exception e) {
            System.out.println("Exception caught" + e);
        }
    }
}
