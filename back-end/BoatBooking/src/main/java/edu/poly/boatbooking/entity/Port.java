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
@Table(name = "ports")
public class Port {
    @Id
    private Long id;
    @Column(name = "port_name")
    private String port_name;
    @Column(name = "port_place")
    private String port_place;
}
