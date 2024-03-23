package edu.poly.boatbooking.controller;

import edu.poly.boatbooking.dto.ScheduleDto;
import edu.poly.boatbooking.dto.SeatDto;
import edu.poly.boatbooking.entity.Seat;
import edu.poly.boatbooking.service.SeatService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/auth/seats")
public class SeatController {
    private SeatService scheduleService;

    @PostMapping
    public ResponseEntity<SeatDto> createSchedule(@RequestBody SeatDto scheduleDto) {
        SeatDto savedSchedule = scheduleService.createSeat(scheduleDto);
        return new ResponseEntity<>(savedSchedule, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SeatDto> getScheduleById(@PathVariable("id") String scheduleId){
        SeatDto SeatDto = scheduleService.getSeatById(scheduleId);
        return ResponseEntity.ok(SeatDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SeatDto>> getAllSchedule(){
        List<SeatDto> scheduleDtos = scheduleService.getAllSeat();
        return ResponseEntity.ok(scheduleDtos);
    }



    @PutMapping("{id}")
    public ResponseEntity<SeatDto> updateSchedule(@PathVariable("id") String scheduleId,
                                                      @RequestBody SeatDto updatedSchedule){
        SeatDto scheduleDto = scheduleService.updatedSeat(scheduleId,updatedSchedule);
        return ResponseEntity.ok(scheduleDto);
    }

    @DeleteMapping
    public ResponseEntity<String> deletePort(@PathVariable("id") String scheduleId){
        scheduleService.deleteSeat(scheduleId);
        return ResponseEntity.ok("Delete schedule successfully!");
    }
}
