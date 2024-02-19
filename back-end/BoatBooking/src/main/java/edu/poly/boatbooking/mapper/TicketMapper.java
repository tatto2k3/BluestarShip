package edu.poly.boatbooking.mapper;

import edu.poly.boatbooking.dto.TicketDto;
import edu.poly.boatbooking.entity.Ticket;

public class TicketMapper {
    public static TicketDto mapToTicketDto (Ticket ticket) {
        return new TicketDto(
                ticket.getId(),
                ticket.getS_id(),
                ticket.getC_id(),
                ticket.getSeat_id()
        );
    }
    public static Ticket mapToTicket(TicketDto ticketDto) {
        return new Ticket(
                ticketDto.getId(),
                ticketDto.getS_id(),
                ticketDto.getC_id(),
                ticketDto.getSeat_id()
        );
    }
}
