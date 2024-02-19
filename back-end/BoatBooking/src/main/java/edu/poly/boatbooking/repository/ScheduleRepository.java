package edu.poly.boatbooking.repository;

import edu.poly.boatbooking.dto.ScheduleDto;
import edu.poly.boatbooking.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByFromLocationAndToLocationAndDepartureDay(String fromLocation, String toLocation, String departureDay);
}
