package com.oa.authserver.controller;

import com.oa.authserver.domain.SecurityUser;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard/local")
    public String getDashboard(@AuthenticationPrincipal SecurityUser user) {
        return "dashboard";
    }
}
