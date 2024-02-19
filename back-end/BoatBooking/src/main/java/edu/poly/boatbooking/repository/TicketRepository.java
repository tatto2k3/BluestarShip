package edu.poly.boatbooking.repository;

import edu.poly.boatbooking.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
