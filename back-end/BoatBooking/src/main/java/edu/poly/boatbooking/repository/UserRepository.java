package edu.poly.boatbooking.repository;

import edu.poly.boatbooking.entity.ERole;
import edu.poly.boatbooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    User findByRole(ERole role);

}

