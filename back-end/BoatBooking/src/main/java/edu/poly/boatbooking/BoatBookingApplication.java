package edu.poly.boatbooking;

import edu.poly.boatbooking.entity.ERole;
import edu.poly.boatbooking.entity.User;
import edu.poly.boatbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BoatBookingApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(BoatBookingApplication.class, args);
	}
	public void run(String... args){
		User adminAccount = userRepository.findByRole(ERole.ADMIN);
		if (null == adminAccount){
			User user = new User();
			user.setFull_name("admin");
			user.setEmail("admin@gmail.com");
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			user.setRole(ERole.ADMIN);
			userRepository.save(user);
		}
	}
}
