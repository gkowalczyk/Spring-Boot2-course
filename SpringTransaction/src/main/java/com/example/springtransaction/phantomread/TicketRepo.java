package com.example.springtransaction.phantomread;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ticketRepoPhantomRead")
public interface TicketRepo extends JpaRepository<Ticket, Long> {
}
