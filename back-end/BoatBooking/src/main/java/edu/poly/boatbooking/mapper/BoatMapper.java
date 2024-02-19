package edu.poly.boatbooking.mapper;

import edu.poly.boatbooking.dto.BoatDto;
import edu.poly.boatbooking.entity.Boat;

public class BoatMapper {
    public static BoatDto mapToBoatDto(Boat boat){
        return new BoatDto(
                boat.getId(),
                boat.getName(),
                boat.getNum_seat(),
                boat.getNum_bed()
        );
    }

    public static Boat mapToBoat(BoatDto boatDto) {
        return new Boat (
                boatDto.getId(),
                boatDto.getName(),
                boatDto.getNum_seat(),
                boatDto.getNum_bed()
        );
    }
}
