package edu.poly.boatbooking.mapper;

import edu.poly.boatbooking.dto.SeatDto;
import edu.poly.boatbooking.entity.Seat;

public class SeatMapper {
    public static SeatDto mapToSeatDto (Seat seat) {
        return new SeatDto(
                seat.getId(),
                seat.getType()
        );
    }
    public static Seat mapToSeat(SeatDto seatDto) {
        return new Seat(
                seatDto.getId(),
                seatDto.getType()
        );
    }
}
