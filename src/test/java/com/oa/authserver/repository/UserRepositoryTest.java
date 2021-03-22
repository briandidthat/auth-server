package com.oa.authserver.repository;

import com.oa.authserver.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
    }

    @Test
    void findByUsername() {
    }
}