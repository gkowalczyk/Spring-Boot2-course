package com.example.springtransaction.dirtyread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service("TicketServiceDirtyRead")
@Transactional(rollbackFor = SQLException.class)
public class TicketService {

    private final TicketRepo ticketRepo;

    public TicketService(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    @Async
    public void update() throws InterruptedException, SQLException {
        Ticket ticketToNorway = new Ticket();
        ticketToNorway.setTicketName("to Norway");
        ticketRepo.save(ticketToNorway);
        Thread.sleep(5000);
        throw new RuntimeException("exception");// automatyczny rollback gdy wyjątek typu RuntimeException
    }
    @Async
    public void show() throws InterruptedException {

        System.out.println(ticketRepo.findAll());
    }
}
