package edu.poly.boatbooking.service;

import edu.poly.boatbooking.dto.PortDto;

import java.util.List;

public interface PortService {
    PortDto createPort(PortDto portDto);

    PortDto getPortById(Long portId);

    List<PortDto> getAllPorts();

    PortDto updatedPort(Long portId, PortDto updatedPort);

    void deletePort(Long portId);
}
