package com.example.springtransaction.phantomread;

import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service("TicketServicePhantomRead")
@Transactional(isolation = Isolation.SERIALIZABLE)
public class TicketService {

    private final TicketRepo ticketRepo;

    public TicketService(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;

    }

    @PostConstruct
    public void save() {
        Ticket ticketToNorway = new Ticket();
        ticketToNorway.setTicketName("to Norway");

        Ticket ticketToPoland = new Ticket();
        ticketToPoland.setTicketName("to Poland");

        ticketRepo.save(ticketToPoland);
        ticketRepo.save(ticketToNorway);
    }

    @Async
    public void saveNewTicket() throws InterruptedException {
        Ticket ticket = new Ticket();
        ticket.setTicketName("to France");
        Thread.sleep(2000);
        ticketRepo.save(ticket);
    }

    @Async
    public void show() throws InterruptedException {
        List<Ticket> tickets = ticketRepo.findAll();
        System.out.println("after reading1 T1=" + tickets);
        Thread.sleep(5000);
        List<Ticket> tickets2 = ticketRepo.findAll();
        System.out.println("after reading2 T2=" + tickets2);
    }
}
