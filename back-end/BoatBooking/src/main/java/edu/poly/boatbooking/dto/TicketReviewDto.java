package edu.poly.boatbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketReviewDto {
    private String customerName;
    private String numId;
    private String boat_name;
    private Long sId;
    private String seatId;
    private String departureDay;
    private String departureTime;
    private String arrivalTime;
    private String arrivalDay;
}
