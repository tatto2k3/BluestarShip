package edu.poly.boatbooking.repository;

import edu.poly.boatbooking.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, String> {
}
