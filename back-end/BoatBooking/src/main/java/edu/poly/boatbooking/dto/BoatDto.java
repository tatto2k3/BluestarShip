package edu.poly.boatbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoatDto {
    private Long id;
    private String name;
    private int num_seat;;
    private int num_bed;


}
