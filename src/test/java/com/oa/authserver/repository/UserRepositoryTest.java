package com.oa.authserver.repository;

import com.oa.authserver.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository repository;
    private User user1, user2;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
        user1 = new User("user1", "password", false);
        user2 = new User("user2", "password2", false);
    }

    @Test
    void findById() {
        user1 = repository.save(user1);
        Optional<User> fromRepository = repository.findById(user1.getId());

        assertEquals(user1, fromRepository.get());
    }

    @Test
    void findByUsername() {
        user1 = repository.save(user1);

        User fromRepository = repository.findByUsername(user1.getUsername());

        assertEquals(user1, fromRepository);
    }

    @Test
    void findAllUsers() {
        user1 = repository.save(user1);
        user2 = repository.save(user2);

        List<User> users = repository.findAll();

        assertEquals(2, users.size());
    }
}