package edu.poly.boatbooking.repository;

import edu.poly.boatbooking.entity.Port;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortRepository extends JpaRepository<Port, Long> {
}
