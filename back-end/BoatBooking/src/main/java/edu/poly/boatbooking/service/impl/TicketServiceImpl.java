package edu.poly.boatbooking.service.impl;

import edu.poly.boatbooking.dto.TicketDto;
import edu.poly.boatbooking.entity.Ticket;
import edu.poly.boatbooking.exception.ResourceNotFoundException;
import edu.poly.boatbooking.mapper.TicketMapper;
import edu.poly.boatbooking.repository.TicketRepository;
import edu.poly.boatbooking.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {this.ticketRepository = ticketRepository;}

    @Override
    public TicketDto createTicket(TicketDto ticketDto) {
        Ticket ticket = TicketMapper.mapToTicket(ticketDto);
        Ticket saveTicket = ticketRepository.save(ticket);

        return TicketMapper.mapToTicketDto(saveTicket);
    }

    @Override
    public TicketDto getTicketById(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Ticket is not exists with given id: " + ticketId));
        return TicketMapper.mapToTicketDto(ticket);
    }

    @Override
    public List<TicketDto> getAllTicket() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream().map((ticket) -> TicketMapper.mapToTicketDto(ticket))
                .collect(Collectors.toList());
    }

    @Override
    public TicketDto updatedTicket(Long ticketId, TicketDto updatedTicket) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(
                () -> new ResourceNotFoundException("Ticket is not exists with given id: " + ticketId)
        );

        ticket.setC_id(updatedTicket.getC_id());
        ticket.setS_id(updatedTicket.getS_id());
        ticket.setSeat_id(updatedTicket.getSeat_id());

        Ticket updatedTicketObj = ticketRepository.save(ticket);
        return TicketMapper.mapToTicketDto(updatedTicketObj);
    }

    @Override
    public void deleteTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(
                () -> new ResourceNotFoundException("Ticket is not exists with given id: " + ticketId)
        );

        ticketRepository.deleteById(ticketId);
    }
}
