//package com.web.springboot2.model;
//
//import com.web.springboot2.service.RoleService;
//import com.web.springboot2.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.PostConstruct;
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//public class DbInit {
//
//    UserService userService;
//    RoleService roleService;
//
//    @Autowired
//    public DbInit(UserService userService, RoleService roleService) {
//        this.userService = userService;
//        this.roleService = roleService;
//    }
//
//    Role adminRole = new Role("ADMIN");
//    Role userRole = new Role("USER");
//
//    Set<Role> adminSetRole = new HashSet<>();
//    Set<Role> userSetRole = new HashSet<>();
//
//    {
//        adminSetRole.add(adminRole);
//        userSetRole.add(userRole);
//    }
//
//    @PostConstruct
//    public void initUsers() {
//        User admin = new User();
//        admin.setName("admin");
//        admin.setLastName("admin");
//        admin.setAge(35);
//        admin.setEmail("admin@mail.ru");
//        admin.setPassword("admin");
//        admin.setRoles(adminSetRole);
//        userService.createNewUser(admin);
//
//        User user = new User();
//        user.setName("user");
//        user.setLastName("user");
//        user.setAge(30);
//        user.setEmail("user@mail.ru");
//        user.setPassword("user");
//        user.setRoles(userSetRole);
//        userService.createNewUser(user);
//    }
//}