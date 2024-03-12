package edu.poly.boatbooking.dto;

import edu.poly.boatbooking.entity.ERole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    private Long id;
    private String full_name;
    private String email;
    private String password;
}
