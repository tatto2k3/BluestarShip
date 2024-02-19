package edu.poly.boatbooking.repository;

import edu.poly.boatbooking.entity.Boat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoatRepository extends JpaRepository<Boat, Long> {

}
