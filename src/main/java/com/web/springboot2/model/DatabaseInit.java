package com.web.springboot2.model;

import com.web.springboot2.service.RoleServiceImpl;
import com.web.springboot2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Component
public class DatabaseInit {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DatabaseInit(UserServiceImpl userService, RoleServiceImpl roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @PostConstruct
    public void databaseInit() {
        userService.saveUser(new User(3L, "admin", "admin@admin.in",
                passwordEncoder.encode("admin"), Collections.singleton(new Role("ROLE_ADMIN"))));
        userService.saveUser(new User(4L, "user", "user@user.in",
                passwordEncoder.encode("user"), Collections.singleton(new Role("ROLE_USER"))));
        roleService.saveRole(new Role("ROLE_SUPERADMIN"));
        roleService.saveRole(new Role("ROLE_MANAGER"));
    }
}
