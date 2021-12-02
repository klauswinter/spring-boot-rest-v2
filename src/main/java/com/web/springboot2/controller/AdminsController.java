package com.web.springboot2.controller;

import com.web.springboot2.model.Role;
import com.web.springboot2.model.User;
import com.web.springboot2.service.RoleServiceImpl;
import com.web.springboot2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminsController {

    private final UserServiceImpl userServiceImpl;
    private final RoleServiceImpl roleServiceImpl;

    @Autowired
    public AdminsController(UserServiceImpl userServiceImpl, RoleServiceImpl roleServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.roleServiceImpl = roleServiceImpl;
    }

    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("users", userServiceImpl.getAllUsers());
        return "admin/all_users";
    }

    @GetMapping("/user_info/{id}")
    public String showUserInfo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("show_users", userServiceImpl.getUserById(id));
        return "admin/user_info";
    }

    @GetMapping("/new")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("role", new Role());
        model.addAttribute("allRoles", roleServiceImpl.getAllRoles());
        return "admin/new_user";
    }

    @PostMapping()
    public String createNewUser(@ModelAttribute("user") User user, @ModelAttribute("role") Role role) {
        userServiceImpl.saveUser(user);
        roleServiceImpl.saveRole(role);
        return "redirect:/admin";
    }

    @GetMapping("edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userServiceImpl.getUserById(id));
        model.addAttribute("allRoles", roleServiceImpl.getAllRoles());
        return "admin/edit_user";
    }

    @PatchMapping("/edit/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userServiceImpl.saveUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userServiceImpl.removeUserById(id);
        return "redirect:/admin";
    }
}
