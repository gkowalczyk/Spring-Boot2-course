package com.example.springtransaction.nonrepetableread;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ticketRepoNonRepeatableRead")
public interface TicketRepo extends JpaRepository<Ticket, Long> {
}
