package edu.poly.boatbooking.controller;

import edu.poly.boatbooking.dto.TicketDto;
import edu.poly.boatbooking.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto) {
        TicketDto savedTicket = ticketService.createTicket(ticketDto);
        return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable("id") Long ticketId){
        TicketDto ticketDto = ticketService.getTicketById(ticketId);
        return ResponseEntity.ok(ticketDto);
    }

    @GetMapping
    public ResponseEntity<List<TicketDto>> getAllTicket(){
        List<TicketDto> ticketDtos = ticketService.getAllTicket();
        return ResponseEntity.ok(ticketDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<TicketDto> updateTicket(@PathVariable("id") Long ticketId,
                                                      @RequestBody TicketDto updatedTicket){
        TicketDto ticketDto = ticketService.updatedTicket(ticketId,updatedTicket);
        return ResponseEntity.ok(ticketDto);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteTicket(@PathVariable("id") Long ticketId){
        ticketService.deleteTicket(ticketId);
        return ResponseEntity.ok("Delete ticket successfully!");
    }
}
