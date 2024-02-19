package edu.poly.boatbooking.service;

import edu.poly.boatbooking.dto.ScheduleDto;
import edu.poly.boatbooking.dto.TicketDto;

import java.util.List;

public interface TicketService {
    TicketDto createTicket(TicketDto ticketDto);

    TicketDto getTicketById(Long ticketId);

    List<TicketDto> getAllTicket();

    TicketDto updatedTicket(Long ticketId, TicketDto updatedTicket);

    void deleteTicket(Long ticketId);
}
