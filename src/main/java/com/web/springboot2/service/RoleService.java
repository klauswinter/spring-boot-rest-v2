package com.web.springboot2.service;

import com.web.springboot2.model.Role;
import com.web.springboot2.model.User;

import java.util.List;

public interface RoleService {
    void saveRole(Role role);
    List<Role> getAllRoles();
}
