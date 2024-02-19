package edu.poly.boatbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {
    private Long id;
    private String boat_name;
    private String port_name;;
    private String fromLocation;
    private String toLocation;
    private String departureDay;
    private String departureTime;
    private String arrivalTime;
    private String price;
}
