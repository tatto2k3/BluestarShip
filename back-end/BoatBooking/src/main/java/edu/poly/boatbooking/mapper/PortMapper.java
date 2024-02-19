package edu.poly.boatbooking.mapper;

import edu.poly.boatbooking.dto.PortDto;
import edu.poly.boatbooking.entity.Port;

public class PortMapper {
    public static PortDto mapToPortDto (Port port) {
        return new PortDto(
                port.getId(),
                port.getPort_name(),
                port.getPort_place()
        );
    }
    public static Port mapToPort(PortDto portDto) {
        return new Port(
                portDto.getId(),
                portDto.getPort_name(),
                portDto.getPort_place()
        );
    }
}
