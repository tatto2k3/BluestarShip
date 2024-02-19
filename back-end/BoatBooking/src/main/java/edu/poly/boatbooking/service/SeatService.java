package edu.poly.boatbooking.service;

import edu.poly.boatbooking.dto.SeatDto;

import java.util.List;

public interface SeatService {
    SeatDto createSeat(SeatDto seatDto);

    SeatDto getSeatById(String seatId);

    List<SeatDto> getAllSeat();

    SeatDto updatedSeat(String seatId, SeatDto updatedSeat);

    void deleteSeat(String seatId);
}
