package edu.poly.boatbooking.controller;

import edu.poly.boatbooking.dto.BoatDto;
import edu.poly.boatbooking.service.BoatService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/admin/boats")
public class BoatController {
    private BoatService boatService;

    @PostMapping
    public ResponseEntity<BoatDto> createBoat(@RequestBody BoatDto boatDto){
        BoatDto savedBoat = boatService.createBoat(boatDto);
        if (savedBoat == null) return new ResponseEntity<>(savedBoat, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(savedBoat, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<BoatDto> getBoatById(@PathVariable("id") Long boatId){
        BoatDto boatDto = boatService.getBoatById(boatId);
        return ResponseEntity.ok(boatDto);
    }

    @GetMapping
    public ResponseEntity<List<BoatDto>> getAllBoats(){
        List<BoatDto> boats = boatService.getAllBoats();
        return ResponseEntity.ok(boats);
    }

    @PutMapping("{id}")
    public ResponseEntity<BoatDto> updateBoat(@PathVariable("id") Long boatId,
                                              @RequestBody BoatDto updatedBoat){
        BoatDto boatDto = boatService.updatedBoat(boatId, updatedBoat);
        return ResponseEntity.ok(boatDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBoat(@PathVariable("id") Long boatId){
        boatService.deleteBoat(boatId);
        return ResponseEntity.ok("Boat deleted successfully!");
    }

}
