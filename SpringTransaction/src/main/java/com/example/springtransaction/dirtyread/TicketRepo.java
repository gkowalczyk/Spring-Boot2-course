package com.example.springtransaction.dirtyread;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ticketRepo")
public interface TicketRepo extends JpaRepository<Ticket, Long> {
}
