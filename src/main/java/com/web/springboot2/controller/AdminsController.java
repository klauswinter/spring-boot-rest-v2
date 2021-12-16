package com.web.springboot2.controller;

import com.web.springboot2.model.User;
import com.web.springboot2.service.RoleService;
import com.web.springboot2.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminsController {

    private final RoleService roleService;

    public AdminsController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String getAdminPage(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("authorizedUser", userDetails);
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "admin_page";
    }
}
