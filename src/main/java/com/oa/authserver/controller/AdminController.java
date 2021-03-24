package com.oa.authserver.controller;

import com.oa.authserver.domain.User;
import com.oa.authserver.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService service;

    @GetMapping("/admin/users/all")
    public List<User> getAllUsers() {
        return service.findAllUsers();
    }
}
