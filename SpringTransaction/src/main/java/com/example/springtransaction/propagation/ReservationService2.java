package com.example.springtransaction.propagation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ReservationService2 {

    private TicketRepository ticketRepository;
    private PassengerRepository passengerRepository;

    public ReservationService2(TicketRepository ticketRepository, PassengerRepository passengerRepository) {
        this.ticketRepository = ticketRepository;
        this.passengerRepository = passengerRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void reserveTicket2() {

        Ticket ticket = new Ticket("Volvo bus");
        ticketRepository.save(ticket);
        throw  new RuntimeException("Exception thrown");
    }
}
