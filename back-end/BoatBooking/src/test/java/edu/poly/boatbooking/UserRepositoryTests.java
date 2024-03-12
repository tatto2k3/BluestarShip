package edu.poly.boatbooking;

import edu.poly.boatbooking.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    UserRepository repo;
    @Test
    public void testCreateUser(){
//        PasswordEncoder passwordEncoder =
    }
}
