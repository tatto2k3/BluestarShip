package edu.poly.boatbooking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    private Long id;
    @Column(name = "boat_name")
    private String boat_name;
    @Column(name = "port_name")
    private String port_name;
    @Column(name = "fromLocation")
    private String fromLocation;
    @Column(name = "toLocation")
    private String toLocation;
    @Column(name = "departureDay")
    private String departureDay;
    @Column(name = "departureTime")
    private String departureTime;
    @Column(name = "arrivalTime")
    private String arrivalTime;
    @Column(name = "price")
    private String price;

}
