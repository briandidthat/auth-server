package com.oa.authserver.service;

import com.oa.authserver.domain.Role;
import com.oa.authserver.domain.SecurityUser;
import com.oa.authserver.domain.User;
import com.oa.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.PostConstruct;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    public UserRepository repository;

    @PostConstruct
    private void saveTestUser() {
        User admin = new User("admin", "$2a$10$nkwXt0IXLF8pgheDphrKfe51nOFE6CUYWGTYFL7TwP7tULOK9YuHO", true);
        // all roles must be prepended with ROLE
        Role role = new Role("ROLE_ADMIN");
        // since there is a many to many relationship, we must add the Role to the set of roles before saving user
        admin.getRoles().add(role);

        repository.save(admin);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repository.findByUsername(s);
        if (user == null)
            throw new UsernameNotFoundException("Invalid username or password.");

        return new SecurityUser(user);
    }
}
