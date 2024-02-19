package edu.poly.boatbooking.service;

import edu.poly.boatbooking.dto.BoatDto;

import java.util.List;

public interface BoatService {
    BoatDto createBoat(BoatDto boatDto);

    BoatDto getBoatById(Long boatId);

    List<BoatDto> getAllBoats();

    BoatDto updatedBoat(Long boatId, BoatDto updatedBoat);

    void deleteBoat(Long boatId);
}
