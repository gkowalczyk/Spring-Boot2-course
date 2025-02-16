package com.example.springtransaction.nonrepetableread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service("TicketServiceNonRepeatableRead")
@Transactional(isolation = Isolation.REPEATABLE_READ)
public class TicketService {

    private final TicketRepo ticketRepo;

    public TicketService(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
        save();
    }


    public void save() {
        Ticket ticketToNorway = new Ticket();
        ticketToNorway.setTicketName("to Norway");
        ticketRepo.save(ticketToNorway);

        Ticket ticketToPoland = new Ticket();
        ticketToPoland.setTicketName("to Poland");
        ticketRepo.save(ticketToPoland);
    }

    @Async
    public void update() throws InterruptedException, SQLException {
        Ticket ticketById = ticketRepo.findById(1L).get();
        ticketById.setTicketName("to Germany");
        Thread.sleep(5000);
        ticketRepo.save(ticketById);

        Ticket newTicket = ticketRepo.findById(1L).get();
        System.out.println("after update=" + newTicket);

    }

    @Async
    public void show() throws InterruptedException {
        Ticket ticketById = ticketRepo.findById(1L).get();
        System.out.println("after reading1 T1=" + ticketById);

        Thread.sleep(5000);

        Ticket ticketById2 = ticketRepo.findById(1L).get();
        System.out.println("after reading2 T2=" + ticketById2);
    }
}
