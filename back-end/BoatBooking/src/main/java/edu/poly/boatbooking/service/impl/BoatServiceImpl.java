package edu.poly.boatbooking.service.impl;

import edu.poly.boatbooking.dto.BoatDto;
import edu.poly.boatbooking.entity.Boat;
import edu.poly.boatbooking.exception.ResourceNotFoundException;
import edu.poly.boatbooking.mapper.BoatMapper;
import edu.poly.boatbooking.repository.BoatRepository;
import edu.poly.boatbooking.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoatServiceImpl implements BoatService {

    private BoatRepository boatRepository;

    @Autowired
    public BoatServiceImpl(BoatRepository boatRepository) {
        this.boatRepository = boatRepository;
    }
    @Override
    public BoatDto createBoat(BoatDto boatDto) {

        Boat boat = BoatMapper.mapToBoat(boatDto);
        if (!boatRepository.existsById(boat.getId())) {
            Boat saveBoat = boatRepository.save(boat);
            return BoatMapper.mapToBoatDto(saveBoat);
        } else {
            return null;
        }
    }

    @Override
    public BoatDto getBoatById(Long boatId) {
        Boat boat = boatRepository.findById(boatId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Boat is not exists with given id: " + boatId));
        return BoatMapper.mapToBoatDto(boat);
    }

    @Override
    public List<BoatDto> getAllBoats() {
        List<Boat> boats = boatRepository.findAll();
        return boats.stream().map((boat) -> BoatMapper.mapToBoatDto(boat))
                .collect(Collectors.toList());
    }

    @Override
    public BoatDto updatedBoat(Long boatId, BoatDto updatedBoat) {
        Boat boat = boatRepository.findById(boatId).orElseThrow(
                () -> new ResourceNotFoundException("Boat is not exists with given id: " + boatId)
        );

        boat.setName(updatedBoat.getName());
        boat.setNum_seat(updatedBoat.getNum_seat());
        boat.setNum_bed(updatedBoat.getNum_bed());

        Boat updatedBoatObj = boatRepository.save(boat);
        return BoatMapper.mapToBoatDto(updatedBoatObj);
    }

    @Override
    public void deleteBoat(Long boatId) {
        Boat boat = boatRepository.findById(boatId).orElseThrow(
                () -> new ResourceNotFoundException("Boat is not exists with given id: " + boatId)
        );

        boatRepository.deleteById(boatId);
    }
}
