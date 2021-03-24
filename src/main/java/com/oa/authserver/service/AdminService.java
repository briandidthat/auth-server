package com.oa.authserver.service;

import com.oa.authserver.domain.User;
import com.oa.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private UserRepository repository;

    @Secured({"ROLE_ADMIN", "ROLE_SUPER_ADMIN"})
    public List<User> findAllUsers() {
        return repository.findAll();
    }
}
