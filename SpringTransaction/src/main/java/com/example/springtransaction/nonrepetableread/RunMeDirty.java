package com.example.springtransaction.nonrepetableread;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component("RunMeDirtyNonRepeatableRead")
public class RunMeDirty {

    private final TicketService ticketService;

    public RunMeDirty(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() throws SQLException, InterruptedException {
        ticketService.update();
        ticketService.show();
    }
}
