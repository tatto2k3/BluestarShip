package edu.poly.boatbooking.mapper;

import edu.poly.boatbooking.dto.TicketDto;
import edu.poly.boatbooking.entity.Ticket;

public class TicketMapper {
    public static TicketDto mapToTicketDto (Ticket ticket) {
        return new TicketDto(
                ticket.getId(),
                ticket.getSId(),
                ticket.getCId(),
                ticket.getSeatId()
        );
    }
    public static Ticket mapToTicket(TicketDto ticketDto) {
        return new Ticket(
                ticketDto.getId(),
                ticketDto.getSId(),
                ticketDto.getCId(),
                ticketDto.getSeatId()
        );
    }
}
