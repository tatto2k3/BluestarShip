package edu.poly.boatbooking.controller;

import edu.poly.boatbooking.dto.ScheduleDto;
import edu.poly.boatbooking.entity.Schedule;
import edu.poly.boatbooking.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/auth/schedule")
public class ScheduleController {
    private ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleDto> createSchedule(@RequestBody ScheduleDto scheduleDto) {
        ScheduleDto savedSchedule = scheduleService.createSchedule(scheduleDto);
        if (savedSchedule == null) return new ResponseEntity<>(savedSchedule, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(savedSchedule, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ScheduleDto> getScheduleById(@PathVariable("id") Long scheduleId){
        ScheduleDto scheduleDto = scheduleService.getScheduleById(scheduleId);
        return ResponseEntity.ok(scheduleDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ScheduleDto>> getAllSchedule(){
        List<ScheduleDto> scheduleDtos = scheduleService.getAllSchedule();
        return ResponseEntity.ok(scheduleDtos);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchFlight(
            @RequestParam String fromLocation,
            @RequestParam String toLocation,
            @RequestParam String departureDay
    ) {
        try {
            List<Schedule> flights = scheduleService.findSchedule(fromLocation, toLocation, departureDay);
            int totalFlights = flights.size();
            return ResponseEntity.ok().body(Map.of("total_flight", totalFlights, "flight", flights));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request.");
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<ScheduleDto> updateSchedule(@PathVariable("id") Long scheduleId,
                                              @RequestBody ScheduleDto updatedSchedule){
        ScheduleDto scheduleDto = scheduleService.updatedSchedule(scheduleId,updatedSchedule);
        return ResponseEntity.ok(scheduleDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePort(@PathVariable("id") Long scheduleId){
        scheduleService.deleteSchedule(scheduleId);
        return ResponseEntity.ok("Delete schedule successfully!");
    }

}
