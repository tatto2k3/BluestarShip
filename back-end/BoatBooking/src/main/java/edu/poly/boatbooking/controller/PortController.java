package edu.poly.boatbooking.controller;

import edu.poly.boatbooking.dto.PortDto;
import edu.poly.boatbooking.service.PortService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/auth/ports")
public class PortController {
    private PortService portService;

    @PostMapping
    public ResponseEntity<PortDto> createPort(@RequestBody PortDto portDto) {
        PortDto savedPort = portService.createPort(portDto);
        if (savedPort == null) return new ResponseEntity<>(savedPort, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(savedPort, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PortDto> getPortById(@PathVariable("id") Long portId){
        PortDto portDto = portService.getPortById(portId);
        return ResponseEntity.ok(portDto);
    }

    @GetMapping
    public ResponseEntity<List<PortDto>> getAllPorts(){
        List<PortDto> portDtos = portService.getAllPorts();
        return ResponseEntity.ok(portDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<PortDto> updatePort(@PathVariable("id") Long portId,
                                              @RequestBody PortDto updatedPort){
        PortDto portDto = portService.updatedPort(portId,updatedPort);
        return ResponseEntity.ok(portDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePort(@PathVariable("id") Long portId){
        portService.deletePort(portId);
        return ResponseEntity.ok("Delete port successfully!");
    }
}
