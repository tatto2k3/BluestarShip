package edu.poly.boatbooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "boats")
public class Boat {
    @Id
    @Column(unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "num_seat")
    private int num_seat;

    @Column(name = "num_bed")
    private int num_bed;

}
